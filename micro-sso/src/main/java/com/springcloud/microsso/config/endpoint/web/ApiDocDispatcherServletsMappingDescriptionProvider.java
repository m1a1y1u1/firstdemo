/*
 * Copyright 2012-2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.springcloud.microsso.config.endpoint.web;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.handler.AbstractUrlHandlerMapping;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.RequestMappingInfoHandlerMapping;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import javax.servlet.Servlet;
import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//import org.springframework.data.rest.webmvc.support.DelegatingHandlerMapping;

/**
 * A {@link ApiDocMappingDescriptionProvider} that introspects the {@link HandlerMapping
 * HandlerMappings} that are known to one or more {@link DispatcherServlet
 * DispatcherServlets}.
 *
 * @author Andy Wilkinson
 * @author Stephane Nicoll
 * @since 2.0.0
 */
public class ApiDocDispatcherServletsMappingDescriptionProvider implements ApiDocMappingDescriptionProvider {

    private static final List<HandlerMappingDescriptionProvider<? extends HandlerMapping>> descriptionProviders;

    static {
        List<HandlerMappingDescriptionProvider<? extends HandlerMapping>> providers = new ArrayList<>();
        // 添加dispatcherServlet的过滤路径
        providers.add(new RequestMappingInfoHandlerMappingDescriptionProvider());
//        providers.add(new UrlHandlerMappingDescriptionProvider());
//		if (ClassUtils.isPresent("org.springframework.data.rest.webmvc.support.DelegatingHandlerMapping", null)) {
//			providers.add(new DelegatingHandlerMappingDescriptionProvider(new ArrayList<>(providers)));
//		}
        descriptionProviders = Collections.unmodifiableList(providers);
    }

    @Override
    public String getMappingName() {
        return "api-doc-dispatcherServlets";
    }

    @Override
    public Map<String, List<ApiDocDispatcherServletMappingDescription>> describeMappings(ApplicationContext context) {
        if (context instanceof WebApplicationContext) {
            return describeMappings((WebApplicationContext) context);
        }
        return Collections.emptyMap();
    }

    private Map<String, List<ApiDocDispatcherServletMappingDescription>> describeMappings(WebApplicationContext context) {
        // determineDispatcherServlets关键
        Map<String, List<ApiDocDispatcherServletMappingDescription>> mappings = new HashMap<>();
        determineDispatcherServlets(context).forEach((name, dispatcherServlet) -> mappings.put(String.format("api-doc-%s",name),
                describeMappings(new ApiDocDispatcherServletHandlerMappings(name, dispatcherServlet, context))));
        return mappings;
    }

    private Map<String, DispatcherServlet> determineDispatcherServlets(WebApplicationContext context) {
        Map<String, DispatcherServlet> dispatcherServlets = new LinkedHashMap<>();
        context.getBeansOfType(ServletRegistrationBean.class).values().forEach((registration) -> {
            Servlet servlet = registration.getServlet();
            if (servlet instanceof DispatcherServlet && !dispatcherServlets.containsValue(servlet)) {
                dispatcherServlets.put(registration.getServletName(), (DispatcherServlet) servlet);
            }
        });
        // 看来几次
        context.getBeansOfType(DispatcherServlet.class).forEach((name, dispatcherServlet) -> {
            if (!dispatcherServlets.containsValue(dispatcherServlet)) {
                dispatcherServlets.put(name, dispatcherServlet);
            }
        });
        return dispatcherServlets;
    }

    private List<ApiDocDispatcherServletMappingDescription> describeMappings(ApiDocDispatcherServletHandlerMappings mappings) {
        return mappings.getHandlerMappings().stream().flatMap(this::describe).collect(Collectors.toList());
    }

    private <T extends HandlerMapping> Stream<ApiDocDispatcherServletMappingDescription> describe(T handlerMapping) {
        return describe(handlerMapping, descriptionProviders).stream();
    }

    @SuppressWarnings("unchecked")
    private static <T extends HandlerMapping> List<ApiDocDispatcherServletMappingDescription> describe(T handlerMapping,
                                                                                                       List<HandlerMappingDescriptionProvider<?>> descriptionProviders) {
        // 关键位置HandlerMappingDescriptionProvider<T>
        for (HandlerMappingDescriptionProvider<?> descriptionProvider : descriptionProviders) {
            System.out.println(handlerMapping.getClass().getName());
            if (descriptionProvider.getMappingClass().isInstance(handlerMapping)) {
                return ((HandlerMappingDescriptionProvider<T>) descriptionProvider).describe(handlerMapping);
            }
        }
        return Collections.emptyList();
    }

    private interface HandlerMappingDescriptionProvider<T extends HandlerMapping> {

        Class<T> getMappingClass();

        List<ApiDocDispatcherServletMappingDescription> describe(T handlerMapping);

    }

    /**
     *
     */
    private static final class RequestMappingInfoHandlerMappingDescriptionProvider
            implements HandlerMappingDescriptionProvider<RequestMappingHandlerMapping> {

        @Override
        public Class<RequestMappingHandlerMapping> getMappingClass() {
            return RequestMappingHandlerMapping.class;
        }

        @Override
        public List<ApiDocDispatcherServletMappingDescription> describe(RequestMappingHandlerMapping handlerMapping) {
            // 注解映射器转描述集
            Map<RequestMappingInfo, HandlerMethod> handlerMethods = handlerMapping.getHandlerMethods();
            return handlerMethods.entrySet().stream().map(this::describe).collect(Collectors.toList());
        }
        /**
         * 构建API详情body
         * @return: com.springcloud.microsso.config.endpoint.web.ApiDocDispatcherServletMappingDescription
         * @data: Created in 2019/8/9 13:58
         * @author: <a href="may@drore.com">马雨</a>
         */
        private ApiDocDispatcherServletMappingDescription describe(Entry<RequestMappingInfo, HandlerMethod> mapping) {
            ApiDocDispatcherServletMappingDetails mappingDetails = new ApiDocDispatcherServletMappingDetails();
            mappingDetails.setHandlerMethod(new ApiDocHandlerMethodDescription(mapping.getValue()));
            mappingDetails.setRequestMappingConditions(new ApiDocRequestMappingConditionsDescription(mapping.getKey()));
            return new ApiDocDispatcherServletMappingDescription(mapping.getKey().toString(), mapping.getValue().toString(),"这是一首简单的小情歌 ",
                    mappingDetails);
        }

    }

//    private static final class UrlHandlerMappingDescriptionProvider
//            implements HandlerMappingDescriptionProvider<AbstractUrlHandlerMapping> {
//
//        @Override
//        public Class<AbstractUrlHandlerMapping> getMappingClass() {
//            return AbstractUrlHandlerMapping.class;
//        }
//
//        @Override
//        public List<ApiDocDispatcherServletMappingDescription> describe(AbstractUrlHandlerMapping handlerMapping) {
//            return handlerMapping.getHandlerMap().entrySet().stream().map(this::describe).collect(Collectors.toList());
//        }
//
//        private ApiDocDispatcherServletMappingDescription describe(Entry<String, Object> mapping) {
//            return new ApiDocDispatcherServletMappingDescription(mapping.getKey(), mapping.getValue().toString(), null);
//        }
//
//    }

//	private static final class DelegatingHandlerMappingDescriptionProvider
//			implements HandlerMappingDescriptionProvider<DelegatingHandlerMapping> {
//
//		private final List<HandlerMappingDescriptionProvider<?>> descriptionProviders;
//
//		private DelegatingHandlerMappingDescriptionProvider(
//				List<HandlerMappingDescriptionProvider<?>> descriptionProviders) {
//			this.descriptionProviders = descriptionProviders;
//		}

//		@Override
//		public Class<DelegatingHandlerMapping> getMappingClass() {
//			return DelegatingHandlerMapping.class;
//		}

//		@Override
//		public List<DispatcherServletMappingDescription> describe(DelegatingHandlerMapping handlerMapping) {
//			List<DispatcherServletMappingDescription> descriptions = new ArrayList<>();
//			for (HandlerMapping delegate : handlerMapping.getDelegates()) {
//				descriptions.addAll(
//						DispatcherServletsMappingDescriptionProvider.describe(delegate, this.descriptionProviders));
//			}
//			return descriptions;
//		}

//	}

}

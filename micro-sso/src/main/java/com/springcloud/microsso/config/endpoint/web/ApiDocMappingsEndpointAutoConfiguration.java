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

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.actuate.autoconfigure.endpoint.condition.ConditionalOnEnabledEndpoint;
import org.springframework.boot.actuate.web.mappings.servlet.DispatcherServletsMappingDescriptionProvider;
import org.springframework.boot.actuate.web.mappings.servlet.FiltersMappingDescriptionProvider;
import org.springframework.boot.actuate.web.mappings.servlet.ServletsMappingDescriptionProvider;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication.Type;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.DispatcherServlet;

import java.util.stream.Collectors;

/**
 * {@link EnableAutoConfiguration Auto-configuration} for {@link ApiDocMappingsEndpoint}.
 *
 * @author Andy Wilkinson
 * @since 2.0.0
 */
@Configuration
public class ApiDocMappingsEndpointAutoConfiguration {

	@Bean
	@ConditionalOnEnabledEndpoint
	public ApiDocMappingsEndpoint ApiDocMappingsEndpoint(ApplicationContext applicationContext,
			ObjectProvider<ApiDocMappingDescriptionProvider> descriptionProviders) {
		return new ApiDocMappingsEndpoint(descriptionProviders.orderedStream().collect(Collectors.toList()),
				applicationContext);
	}

	@Configuration
	@ConditionalOnWebApplication(type = Type.SERVLET)
	static class ServletWebConfiguration {

		@Bean
		ApiDocServletsMappingDescriptionProvider apiDocServletMappingDescriptionProvider() {
			return new ApiDocServletsMappingDescriptionProvider();
		}

		@Bean
		ApiDocFiltersMappingDescriptionProvider apiDocFilterMappingDescriptionProvider() {
			return new ApiDocFiltersMappingDescriptionProvider();
		}

		@Configuration
		static class SpringMvcConfiguration {

			@Bean
			ApiDocDispatcherServletsMappingDescriptionProvider apiDocDispatcherServletsMappingDescriptionProvider() {
				return new ApiDocDispatcherServletsMappingDescriptionProvider();
			}

		}

	}

}

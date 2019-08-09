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

import org.springframework.boot.actuate.web.mappings.MappingDescriptionProvider;
import org.springframework.boot.actuate.web.mappings.servlet.FilterRegistrationMappingDescription;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.Filter;
import javax.servlet.ServletContext;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * A {@link MappingDescriptionProvider} that describes that mappings of any {@link Filter
 * Filters} registered with a {@link ServletContext}.
 *
 * @author Andy Wilkinson
 * @since 2.0.0
 */
public class ApiDocFiltersMappingDescriptionProvider implements ApiDocMappingDescriptionProvider {

	@Override
	public List<FilterRegistrationMappingDescription> describeMappings(ApplicationContext context) {
		if (!(context instanceof WebApplicationContext)) {
			return Collections.emptyList();
		}
		return ((WebApplicationContext) context).getServletContext().getFilterRegistrations().values().stream()
				.map(FilterRegistrationMappingDescription::new).collect(Collectors.toList());
	}

	@Override
	public String getMappingName() {
		return "api-doc-servletFilters";
	}

}

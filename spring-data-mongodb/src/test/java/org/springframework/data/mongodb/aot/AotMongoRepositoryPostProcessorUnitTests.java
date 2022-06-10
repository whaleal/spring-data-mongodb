/*
 * Copyright 2022 the original author or authors.
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
package org.springframework.data.mongodb.aot;

/**
 * @author Christoph Strobl
 * @since 2022/04
 */
public class AotMongoRepositoryPostProcessorUnitTests {

	// @Test
	// void contributesProxiesForDataAnnotations() {
	//
	// RepositoryBeanContribution repositoryBeanContribution = computeConfiguration(ImperativeConfig.class)
	// .forRepository(ImperativeConfig.PersonRepository.class);
	//
	// assertThatContribution(repositoryBeanContribution) //
	// .codeContributionSatisfies(contribution -> {
	//
	// contribution.contributesJdkProxy(Transient.class, SynthesizedAnnotation.class);
	// contribution.contributesJdkProxy(LastModifiedDate.class, SynthesizedAnnotation.class);
	// contribution.contributesJdkProxy(Document.class, SynthesizedAnnotation.class);
	// contribution.contributesJdkProxy(DBRef.class, SynthesizedAnnotation.class);
	// contribution.contributesClassProxy(Address.class, LazyLoadingProxy.class);
	// });
	// }
	//
	// BeanContributionBuilder computeConfiguration(Class<?> configuration) {
	//
	// AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
	// ctx.register(configuration);
	// ctx.refreshForAotProcessing();
	//
	// return it -> {
	//
	// String[] repoBeanNames = ctx.getBeanNamesForType(it);
	// assertThat(repoBeanNames).describedAs("Unable to find repository %s in configuration %s.", it, configuration)
	// .hasSize(1);
	//
	// String beanName = repoBeanNames[0];
	// BeanDefinition beanDefinition = ctx.getBeanDefinition(beanName);
	//
	// AotMongoRepositoryPostProcessor postProcessor = ctx.getBean(AotMongoRepositoryPostProcessor.class);
	//
	// postProcessor.setBeanFactory(ctx.getDefaultListableBeanFactory());
	//
	// return postProcessor.contribute((RootBeanDefinition) beanDefinition, it, beanName);
	// };
	// }
	//
	// interface BeanContributionBuilder {
	// RepositoryBeanContribution forRepository(Class<?> repositoryInterface);
	// }

}

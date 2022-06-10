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

import static org.assertj.core.api.Assertions.*;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.function.Consumer;

import org.assertj.core.api.AbstractAssert;
import org.springframework.aot.generator.DefaultCodeContribution;
import org.springframework.aot.hint.RuntimeHints;
import org.springframework.data.aot.RepositoryBeanContribution;
import org.springframework.data.repository.core.RepositoryInformation;
import org.springframework.data.repository.core.support.RepositoryFragment;

/**
 * @author Christoph Strobl
 * @since 2022/04
 */
public class RepositoryBeanContributionAssert
		extends AbstractAssert<RepositoryBeanContributionAssert, RepositoryBeanContribution>  {

	public RepositoryBeanContributionAssert(RepositoryBeanContribution actual) {
		super(actual, RepositoryBeanContributionAssert.class);
	}

	public static RepositoryBeanContributionAssert assertThatContribution(RepositoryBeanContribution actual) {
		return new RepositoryBeanContributionAssert(actual);
	}

	public RepositoryBeanContributionAssert targetRepositoryTypeIs(Class<?> expected) {

		assertThat(getRepositoryInformation().getRepositoryInterface()).isEqualTo(expected);
		return myself;
	}

	public RepositoryBeanContributionAssert hasNoFragments() {
		assertThat(getRepositoryInformation().getFragments()).isEmpty();
		return this;
	}

	public RepositoryBeanContributionAssert hasFragments() {

		assertThat(getRepositoryInformation().getFragments()).isNotEmpty();
		return this;
	}

	public RepositoryBeanContributionAssert verifyFragments(Consumer<Set<RepositoryFragment<?>>> consumer) {

		assertThat(getRepositoryInformation().getFragments()).satisfies(it -> consumer.accept(new LinkedHashSet<>(it)));
		return this;
	}

	public RepositoryBeanContributionAssert codeContributionSatisfies(Consumer<CodeContributionAssert> consumer) {

		DefaultCodeContribution codeContribution = new DefaultCodeContribution(new RuntimeHints());
		this.actual.applyTo(codeContribution);
		consumer.accept(new CodeContributionAssert(codeContribution));
		return this;
	}

	private RepositoryInformation getRepositoryInformation() {
		assertThat(this.actual).describedAs("No repository interface found on null bean contribution.").isNotNull();
		assertThat(this.actual.getRepositoryInformation())
				.describedAs("No repository interface found on null repository information.").isNotNull();
		return this.actual.getRepositoryInformation();
	}



}

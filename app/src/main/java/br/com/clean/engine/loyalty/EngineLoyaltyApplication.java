package br.com.clean.engine.loyalty;

import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.context.AnnotationConfigServletWebServerApplicationContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import java.util.List;

@SpringBootApplication
public class EngineLoyaltyApplication {
	
	private static final List<String> PACKAGES_IGNORE = List.of(
			"br.com.clean.engine.loyalty.domain",
			"br.com.clean.engine.loyalty.controller.model"
			);

	public static void main(final String[] args) {
		SpringApplication.run(EngineLoyaltyApplication.class, args);
	}

	@Bean
	BeanFactoryPostProcessor beanFactoryPostProcessor(final ApplicationContext beanRegistry) {
		return beanFactory -> genericApplicationContext(
				(BeanDefinitionRegistry) ((AnnotationConfigServletWebServerApplicationContext) beanRegistry)
						.getBeanFactory());
	}

	void genericApplicationContext(final BeanDefinitionRegistry beanRegistry) {
		final ClassPathBeanDefinitionScanner beanDefinitionScanner = new ClassPathBeanDefinitionScanner(beanRegistry);
		beanDefinitionScanner.addIncludeFilter(packageIgnoreFilter());
		beanDefinitionScanner.scan("br.com.clean.engine.loyalty");
	}

	static TypeFilter packageIgnoreFilter() {
		return (final MetadataReader mr, final MetadataReaderFactory mrf) -> {
			return PACKAGES_IGNORE
					.stream()
					.noneMatch(packageIgnore -> mr.getClassMetadata().getClassName().contains(packageIgnore));
		};
	}
}

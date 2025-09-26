package learn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class LearningProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(LearningProjectApplication.class, args);
	}

	/*
	 * @SpringBootApplication is a combination of three annotations:
	 * 1. @Configuration: Indicates that the class can be used by the Spring IoC
	 * container as a source of bean definitions.
	 * 2. @EnableAutoConfiguration: Tells Spring Boot to start adding beans based on
	 * classpath settings, other beans, and various property settings.
	 * eg.
	 * setting up the DispatcherServlet for a web application if spring-webmvc is on
	 * the classpath.
	 * 3. @ComponentScan: Tells Spring to look for other components, configurations,
	 * and services in the specified package, allowing it to find controllers.
	 * By default, It scans the package of the class where @SpringBootApplication is
	 * located.
	 * This is why it's common to place the main application class in the root
	 * package.
	 * 
	 * if you want to customize the component scanning, you can use that annotation
	 * separately above the @SpringBootApplication
	 * with specific basePackages or basePackageClasses attributes.
	 * eg. @ComponentScan(basePackages = {"com.example.package1",
	 * "com.example.package2"})
	 */

	/*
	 * After adding @SpringBootApplication, if you added already present annotations
	 * like @Configuration,
	 * 
	 * @EnableAutoConfiguration, or @ComponentScan, it may lead to redundancy.
	 * While it won't cause errors, it's cleaner to remove the redundant
	 * annotations.
	 * 
	 * here are the interview questions based on the above explanation:
	 * 1. What is the purpose of the @SpringBootApplication annotation in a Spring
	 * Boot application?
	 * ans: It is a convenience annotation that
	 * combines @Configuration, @EnableAutoConfiguration, and @ComponentScan.
	 * 
	 * 2. What does the @Configuration annotation signify in a Spring application?
	 * ans: It indicates that the class can be used by the Spring IoC container as a
	 * source of bean definitions.
	 * 
	 * 3. How does the @EnableAutoConfiguration annotation help in a Spring Boot
	 * application?
	 * ans: It tells Spring Boot to automatically configure your application based
	 * on the dependencies present on the classpath.
	 * 
	 * 4. where we can find the classpath settings?
	 * ans: Classpath settings can be found in the build configuration files like
	 * pom.xml for Maven or build.gradle for Gradle.
	 * 
	 * 5. What is the role of the @ComponentScan annotation in a Spring application?
	 * ans: It tells Spring to scan the specified package and its sub-packages for
	 * components, configurations, and services to register them as beans in the
	 * application context.
	 * by default, it scans the package of the class where @SpringBootApplication is
	 * or else we can customize it with basePackages or basePackageClasses
	 * 
	 * 6. Why is it common to place the main application class in the root package?
	 * ans: Placing the main application class in the root package allows the
	 * 
	 * @ComponentScan to automatically scan all sub-packages for components,
	 * configurations, and services.
	 * 
	 * @Configuaration and @EnableAutoConfiguration will also be applied to the
	 * entire application. since
	 * all the other packages are present in inside the root package.
	 * 
	 * 7. What happens if we don't use the @SpringBootApplication annotation while
	 * running the application?
	 * ans: Annotations like @Configuration, @EnableAutoConfiguration,
	 * and @ComponentScan won't be applied automatically.
	 * if No-AutoConfiguration is present:
	 * we may need to manually configure beans and settings.
	 * and deafult configurations like seeting up embedded tomcat server, Data
	 * source is wee added hibernate related dependency
	 * like Spring-JPA, not done.
	 * If you don’t use @ComponentScan (or specify it manually): Spring won’t detect
	 * your beans (@Service, @Controller, etc.), meaning dependency injection will
	 * fail unless you register beans explicitly.
	 * No configuration class recognition:
	 * Without @Configuration, Spring won’t treat your main class as a configuration
	 * class, so bean definitions inside it (@Bean methods) won’t work.
	 * 
	 * 
	 * 
	 */

}

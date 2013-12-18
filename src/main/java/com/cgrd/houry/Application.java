package com.cgrd.houry;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.cgrd.houry.persistence.domain.Project;
import com.cgrd.houry.persistence.repository.ProjectRepository;

/**
 * With an Application class like this:
 * 
 * <pre>
 * &#064;Configuration
 * &#064;ComponentScan
 * &#064;EnableAutoConfiguration
 * public class Application {
 *     public static void main(String[] args) { 
 *         ApplicationContext context = SpringApplication.run(Application.class, args);
 *         .. 
 *     }
 * }
 * </pre>
 * 
 * the following application.properties:
 * 
 * <pre>
 * spring.datasource.driverClassName=com.mysql.jdbc.Driver
 * spring.datasource.url=jdbc:mysql://localhost/cgrd_houry?useUnicode=true&characterEncoding=utf8
 * spring.datasource.username=root
 * spring.datasource.password=
 * </pre>
 * 
 * and this pom.xml:
 * 
 * <pre>
 * &lt;project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
 *     xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd"&gt;
 *     &lt;modelVersion&gt;4.0.0&lt;/modelVersion&gt;
 * 
 *     &lt;groupId&gt;com.cgrd&lt;/groupId&gt;
 *     &lt;artifactId&gt;houry&lt;/artifactId&gt;
 *     &lt;version&gt;0.1.0&lt;/version&gt;
 * 
 *     &lt;parent&gt;
 *         &lt;groupId&gt;org.springframework.boot&lt;/groupId&gt;
 *         &lt;artifactId&gt;spring-boot-starter-parent&lt;/artifactId&gt;
 *         &lt;version&gt;0.5.0.M6&lt;/version&gt;
 *     &lt;/parent&gt;
 * 
 *     &lt;dependencies&gt;
 *         &lt;dependency&gt;
 *             &lt;groupId&gt;org.springframework.boot&lt;/groupId&gt;
 *             &lt;artifactId&gt;spring-boot-starter-web&lt;/artifactId&gt;
 *         &lt;/dependency&gt;
 *         &lt;dependency&gt;
 *             &lt;groupId&gt;org.springframework.boot&lt;/groupId&gt;
 *             &lt;artifactId&gt;spring-boot-starter-data-jpa&lt;/artifactId&gt;
 *         &lt;/dependency&gt;
 *         &lt;dependency&gt;
 *             &lt;groupId&gt;org.springframework.boot&lt;/groupId&gt;
 *             &lt;artifactId&gt;spring-boot-starter-test&lt;/artifactId&gt;
 *         &lt;/dependency&gt;
 *         &lt;dependency&gt;
 *             &lt;groupId&gt;mysql&lt;/groupId&gt;
 *             &lt;artifactId&gt;mysql-connector-java&lt;/artifactId&gt;
 *         &lt;/dependency&gt;
 *     &lt;/dependencies&gt;
 * 
 *     &lt;properties&gt;
 *         &lt;start-class&gt;com.cgrd.houry.Application&lt;/start-class&gt;
 *     &lt;/properties&gt;
 * 
 *     &lt;build&gt;
 *         &lt;plugins&gt;
 *             &lt;plugin&gt;
 *                 &lt;groupId&gt;org.springframework.boot&lt;/groupId&gt;
 *                 &lt;artifactId&gt;spring-boot-maven-plugin&lt;/artifactId&gt;
 *             &lt;/plugin&gt;
 *         &lt;/plugins&gt;
 *     &lt;/build&gt;
 * 
 *     &lt;repositories&gt;
 *         &lt;repository&gt;
 *             &lt;id&gt;spring-snapshots&lt;/id&gt;
 *             &lt;url&gt;http://repo.spring.io/libs-snapshot&lt;/url&gt;
 *             &lt;snapshots&gt;&lt;enabled&gt;true&lt;/enabled&gt;&lt;/snapshots&gt;
 *         &lt;/repository&gt;
 *     &lt;/repositories&gt;
 *     &lt;pluginRepositories&gt;
 *         &lt;pluginRepository&gt;
 *             &lt;id&gt;spring-snapshots&lt;/id&gt;
 *             &lt;url&gt;http://repo.spring.io/libs-snapshot&lt;/url&gt;
 *             &lt;snapshots&gt;&lt;enabled&gt;true&lt;/enabled&gt;&lt;/snapshots&gt;
 *         &lt;/pluginRepository&gt;
 *     &lt;/pluginRepositories&gt;
 * &lt;/project&gt;
 * </pre>
 * 
 * Spring Boot automatically provides these Beans:
 * 
 * <pre>
 * application 
 * beanNameHandlerMapping 
 * dataSource
 * defaultServletHandlerMapping 
 * defaultViewResolver
 * dispatcherServlet
 * embeddedServletContainerCustomizerBeanPostProcessor 
 * entityManagerFactory
 * faviconHandlerMapping 
 * faviconRequestHandler
 * handlerExceptionResolver
 * hiddenHttpMethodFilter 
 * httpRequestHandlerAdapter 
 * jdbcTemplate
 * jpaVendorAdapter 
 * messageSource 
 * mvcContentNegotiationManager
 * mvcConversionService 
 * mvcUriComponentsContributor 
 * mvcValidator
 * namedParameterJdbcTemplate 
 * openEntityManagerInViewInterceptor
 * org.springframework.aop.config.internalAutoProxyCreator
 * org.springframework.boot.autoconfigure.MessageSourceAutoConfiguration
 * org.springframework.boot.autoconfigure.PropertyPlaceholderAutoConfiguration
 * org.springframework.boot.autoconfigure.aop.AopAutoConfiguration
 * org.springframework.boot.autoconfigure.aop.AopAutoConfiguration$JdkDynamicAutoProxyConfiguration
 * org.springframework.boot.autoconfigure.data.JpaRepositoriesAutoConfiguration
 * org.springframework.boot.autoconfigure.data.JpaRepositoriesAutoConfiguration$JpaWebConfiguration
 * org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration
 * org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration$JdbcTemplateConfiguration
 * org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration$TomcatConfiguration
 * org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration
 * org.springframework.boot.autoconfigure.jdbc.TomcatDataSourceConfiguration
 * org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration
 * org.springframework.boot.autoconfigure.orm.jpa.JpaBaseConfiguration$JpaWebConfiguration
 * org.springframework.boot.autoconfigure.web.DispatcherServletAutoConfiguration
 * org.springframework.boot.autoconfigure.web.EmbeddedServletContainerAutoConfiguration
 * org.springframework.boot.autoconfigure.web.EmbeddedServletContainerAutoConfiguration$EmbeddedTomcat
 * org.springframework.boot.autoconfigure.web.ServerPropertiesAutoConfiguration
 * org.springframework.boot.autoconfigure.web.WebMvcAutoConfiguration
 * org.springframework.boot.autoconfigure.web.WebMvcAutoConfiguration$WebMvcAutoConfigurationAdapter
 * org.springframework.boot.autoconfigure.web.WebMvcAutoConfiguration$WebMvcAutoConfigurationAdapter$FaviconConfiguration
 * org.springframework.boot.context.embedded.properties.ServerProperties
 * org.springframework.boot.context.properties.ConfigurationPropertiesBindingPostProcessor
 * org.springframework.context.annotation.ConfigurationClassPostProcessor.enhancedConfigurationProcessor
 * org.springframework.context.annotation.ConfigurationClassPostProcessor.importAwareProcessor
 * org.springframework.context.annotation.internalAutowiredAnnotationProcessor
 * org.springframework.context.annotation.internalCommonAnnotationProcessor
 * org.springframework.context.annotation.internalConfigurationAnnotationProcessor
 * org.springframework.context.annotation.internalPersistenceAnnotationProcessor
 * org.springframework.context.annotation.internalRequiredAnnotationProcessor
 * org.springframework.data.repository.core.support.RepositoryInterfaceAwareBeanPostProcessor#0
 * org.springframework.data.web.config.SpringDataWebConfiguration
 * org.springframework.transaction.annotation.ProxyTransactionManagementConfiguration
 * org.springframework.transaction.config.internalTransactionAdvisor
 * org.springframework.web.servlet.config.annotation.DelegatingWebMvcConfiguration
 * pageableResolver
 * projectRepository
 * propertySourcesPlaceholderConfigurer
 * requestMappingHandlerAdapter
 * requestMappingHandlerMapping
 * resourceHandlerMapping
 * simpleControllerHandlerAdapter
 * sortResolver
 * tomcatEmbeddedServletContainerFactory
 * transactionAttributeSource
 * transactionInterceptor
 * transactionManager
 * viewControllerHandlerMapping
 * </pre>
 * 
 * enabeling Spring Data repositories such as:
 * 
 * <pre>
 * public interface ProjectRepository extends PagingAndSortingRepository&lt;Project, Long&gt; {
 *     List&lt;Project&gt; findByDescription(String description);
 * }
 * </pre>
 * 
 * so that entities like:
 * 
 * <pre>
 * &#064;Entity
 * public class Project {
 *     &#064;Id
 *     &#064;GeneratedValue(strategy = GenerationType.AUTO)
 *     private long id;
 *     private String description;
 * 
 *     public Project() {
 *     }
 * }
 * </pre>
 * 
 * can be retrieved like this:
 * 
 * <pre>
 * ProjectRepository repository = context.getBean(ProjectRepository.class);
 * Iterable&lt;Project&gt; p1 = repository.findAll();
 * List&lt;Project&gt; p2 = repository.findByDescription(&quot;my-desc&quot;);
 * </pre>
 * 
 * An integration test can be constructed as such:
 * 
 * <pre>
 * &#064;RunWith(SpringJUnit4ClassRunner.class)
 * &#064;ContextConfiguration(classes = Application.class, loader = SpringApplicationContextLoader.class)
 * &#064;ActiveProfiles(&quot;test&quot;)
 * public class ProjectRepositoryTests {
 *     &#064;Autowired
 *     ProjectRepository projectRepository;
 * 
 *     &#064;Test
 *     public void findAll() throws Exception {
 *         List&lt;Project&gt; projects = (List&lt;Project&gt;) projectRepository.findAll();
 *         assertEquals(3, projects.size());
 *     }
 * }
 * </pre>
 * 
 * using the test database as configured in application-test.properties:
 * 
 * <pre>
 * spring.datasource.url=jdbc:mysql://localhost/cgrd_houry_test?useUnicode=true&characterEncoding=utf8
 * spring.datasource.username=test
 * spring.datasource.password=
 * </pre>
 */
@Configuration
@ComponentScan
@EnableAutoConfiguration
public class Application {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Application.class, args);

        System.out.println("Let's inspect the beans provided by Spring Boot:");

        String[] beanNames = context.getBeanDefinitionNames();
        Arrays.sort(beanNames);
        for (String beanName : beanNames) {
            System.out.println(beanName);
        }

        ProjectRepository repository = context.getBean(ProjectRepository.class);

        Iterable<Project> projects = repository.findAll();
        System.out.println("Projects found with findAll():");
        System.out.println("-------------------------------");
        for (Project p : projects) {
            System.out.println(p);
        }
        System.out.println();

        List<Project> hourys = repository.findByDescription("cgrd-houry");
        System.out.println("Projects found with findByDescription('cgrd-houry'):");
        System.out.println("-------------------------------");
        for (Project p : hourys) {
            System.out.println(p);
        }
        System.out.println();

        Page<Project> page = repository.findAll(new PageRequest(0, 2));
        System.out.println("Page found with findAll(pageRequest(0,2)):");
        System.out.println("-------------------------------");
        System.out.println(page);
        for (Project p : page.getContent()) {
            System.out.println(p);
        }
        page = repository.findAll(new PageRequest(1, 2));
        System.out.println("Page found with findAll(pageRequest(1,2)):");
        System.out.println("-------------------------------");
        System.out.println(page);
        for (Project p : page.getContent()) {
            System.out.println(p);
        }

    }

}

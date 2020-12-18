#自定义自动装配过程

1、将App标记为@EnableAutoConfiguration，并作为App.run方法的首参。
@EnableAutoConfiguration
public class App {
public static void main(String[] args) {
SpringApplication.run(App.class, args);
}
}

2、WebConfiguration
@Configuration
public class WebConfiguration {
...
}

3、创建自动装配类WebAutoConfiguration，并使用@Import导入WebConfiguration
  import org.springframework.context.annotation.Configuration;
  import org.springframework.context.annotation.Import;
  @Configuration
  @Import(WebConfiguration.class)
  public class WebAutoConfiguration {
  }
  
4、在项目src/main/resources目录下新建META-INF/spring.factories资源，并配置WebAutoConfiguration类：
org.springframework.boot.autoconfigure.EnableAutoConfiguration=\
com.ebc.WebAutoConfiguration


• 自动装配命名的潜规则
自动装配Class的命名规则
SpringBoot内建的自动装配的class的名称模式均为*AutoConfiguration，按照该模式，我们自定义的自动装配Class
均沿用该命名方式
自动装配Package的命名规则
${group}.autoconfigure
自定义Starter的命名规则
${module}-spring-boot-starter


总结
1.通过各种注解实现了类与类之间的依赖关系，容器在启动的时候Application.run，会调用
EnableAutoConfigurationImportSelector.class的selectImports方法（其实是其父类的方法）
2.selectImports方法最终会调用SpringFactoriesLoader.loadFactoryNames方法来获取一个全面的常用
BeanConfiguration列表
3.loadFactoryNames方法会读取FACTORIES_RESOURCE_LOCATION（也就是spring-boot-autoconfigure.jar 下
面的spring.factories），获取到所有的Spring相关的Bean的全限定名ClassName，大概120多个
4.selectImports方法继续调用filter(configurations, autoConfigurationMetadata);这个时候会根据这些
BeanConfiguration里面的条件，来一一筛选，最关键的是@ConditionalOnClass，这个条件注解会去classpath下
查找，jar包里面是否有这个条件依赖类，所以必须有了相应的jar包，才有这些依赖类，才会生成IOC环境需要的一些
默认配置Bean
5.最后把符合条件的BeanConfiguration注入默认的EnableConfigurationPropertie类里面的属性值，并且注入到
IOC环境当中
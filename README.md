SpringBoo注意事项：
1.使用@SpringBootApplication注解的启动类不能直接放在main/java文件夹下，必须要建一个包把它放进去、使用@EnableAutoConfiguration注解、使用@ComponentScan指明对象扫描范围。
2.启动类默认指扫描当前启动类所在的包或者在该子包下里的对象。
3.如果当前启动类没有包、@EnableAutoConfiguration、@ComponentScan注解，则在启动时会报错：Your ApplicationContext is unlikely to start due to a @ComponentScan of the default package错误。
4.@ComponentScan(basePackages = { "test" })。
5.SpringBoot包路径很重要，如果启动类和Controller类分开在两个包里，则Controller类需要添加注解@EnableAutoConfiguration。
如果Controller类与启动类或者在该子包下，则不需要添加@EnableAutoConfiguration注解。
6.@SpringBootApplication注解在哪个方法上，哪个方法为启动类，启动启动类，扫描Controller类。

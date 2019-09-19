## AOP配置实例


<!-- 打印日志 切入service层 -->
<aop:config expose-proxy="true" proxy-target-class="true">
<aop:pointcut id="services" expression="execution(* com.wondersgroup.bigdata.project.service.impl.*..*(..))"/>
<aop:aspect id="aopService" ref="serviceAopConfigurationImpl" order="1">
<aop:before method="before" pointcut-ref="services"/>
<aop:after-returning method="afterReturn" returning="returnValue" pointcut-ref="services"/>
<aop:after-throwing method="afterThrow" throwing="exception" pointcut-ref="services"/>
</aop:aspect>
</aop:config>

<!--  切入controller层-->
<aop:config expose-proxy="true" proxy-target-class="true">
<aop:pointcut id="controllers" expression="execution(* com.wondersgroup.bigdata.project.web.*.controller.*..*(..))"/>
<!--    <aop:pointcut id="controllers" expression="execution(* com.wondersgroup.bigdata.project.web.test.controller.TestController.aopService(Long, Long, Long))"/>-->
<aop:aspect id="aopController" ref="controllerAopConfigurationImpl" order="1">
<aop:before method="before" pointcut-ref="controllers"/>
<aop:after-returning method="afterReturn" returning="returnValue" pointcut-ref="controllers"/>
<aop:after-throwing method="afterThrow" throwing="exception" pointcut-ref="controllers"/>
</aop:aspect>
</aop:config>
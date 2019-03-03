# fake-spring
Just for learn spring

# 简介
一个模仿spring ioc，aop的小项目，为学习spring而写的，代码参考了code4craft大大照猫画虎实现的。
Spring的代码很多，层次复杂，阅读起来费劲。

从核心功能出发，一步步构建，也算是学习和理解spring的设计思路吧= = 

spring最常用的就是通过xml配置bean了（虽然springboot已经可以完全不使用xml），本项目就从构建简单的
BeanFactory读取xml中的配置到字典中（默认是singleton），一步步实现核心功能吧

# 版本控制
项目是逐步迭代的，第一个版本可通过

`git checkout step-1-create-beanfactory`

来获取, 历史版本如下：

`step-1-create-beanfactory`

`step-2-do-bean-initilizing-in`

`step-3-inject-bean-with-property`

`step-4-config-beanfactory-with-xml`

`step-5-inject-bean-into-bean`

`step6-ApplicationContext`

`step-7-method-interceptor`


# 单体应用脚手架

[![CI](https://github.com/highsoft-shanghai/monolithic/actions/workflows/main.yml/badge.svg?branch=master)](https://github.com/highsoft-shanghai/monolithic/actions/workflows/main.yml)

本项目旨在为单体类应用提供基本的项目启动模板，以减少迭代0的技术准备工作。本模板集成了部分通用功能（如认证与授权、身份管理、权限管理、组织架构及其管理等），
并完成了典型项目的大部分技术事务（如全局异常处理、上下文、应用框架、测试基础框架等），基于此，开发者可以快速完成迭代0的准备工作，并尽可能早地进入业务交付。

## 常用命令
为方便日常开发，项目预置了部分常用脚本，可以帮助项目成员快速完成一些常见的任务。

### 静态代码检查
良好的编码风格和编码格式是高质量软件的基础，时刻注意编码格式和风格是推荐的优秀实践。如需快速获得编码风格的问题反馈，请使用以下命令：
```bash
./scripts/check-static
```

### 本地CI检查
为了持续集成，项目提供了必要的基础设施，质量门禁便是其中之一。质量门禁提供了静态代码检查、单元测试、集成测试、测试覆盖率等各项质量检查项，以帮助团队守住质量基线，为持续集成提供必要的基础。
**开发每次推送代码至代码库前务必在本地执行质量门禁检查**，并且在代码被推送至代码仓库后，构建服务器也会触发质量门禁。本地执行质量检测直接执行以下命令：
```bash
./scripts/check-all
```
如果计算机资源充足（多核CPU、大内存、SSD），可使用并行检查缩短反馈时间：
```bash
./scripts/check-all-parallel
```

## 项目文档
关于项目的详细说明，请参考相关文档：
* [项目框架基础能力](/documents/foundations.md)

## REFERENCE DOCUMENTATION

For further reference, please consider the following sections:

* [Official Gradle documentation](https://docs.gradle.org)
* [Spring Boot Gradle Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.6.7/gradle-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.6.7/gradle-plugin/reference/html/#build-image)
* [Testcontainers MongoDB Module Reference Guide](https://www.testcontainers.org/modules/databases/mongodb/)
* [Testcontainers Postgres Module Reference Guide](https://www.testcontainers.org/modules/databases/postgres/)
* [Quartz Scheduler](https://docs.spring.io/spring-boot/docs/2.6.7/reference/htmlsingle/#boot-features-quartz)
* [Spring REST Docs](https://docs.spring.io/spring-restdocs/docs/current/reference/html5/)
* [Spring Configuration Processor](https://docs.spring.io/spring-boot/docs/2.6.7/reference/htmlsingle/#configuration-metadata-annotation-processor)
* [Spring Web](https://docs.spring.io/spring-boot/docs/2.6.7/reference/htmlsingle/#boot-features-developing-web-applications)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/2.6.7/reference/htmlsingle/#boot-features-jpa-and-spring-data)
* [Flyway Migration](https://docs.spring.io/spring-boot/docs/2.6.7/reference/htmlsingle/#howto-execute-flyway-database-migrations-on-startup)
* [Spring Data MongoDB](https://docs.spring.io/spring-boot/docs/2.6.7/reference/htmlsingle/#boot-features-mongodb)
* [Spring Boot Actuator](https://docs.spring.io/spring-boot/docs/2.6.7/reference/htmlsingle/#production-ready)
* [Testcontainers](https://www.testcontainers.org/)

## GUIDES

The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/bookmarks/)
* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)
* [Accessing Data with MongoDB](https://spring.io/guides/gs/accessing-data-mongodb/)
* [Building a RESTful Web Service with Spring Boot Actuator](https://spring.io/guides/gs/actuator-service/)

## ADDITIONAL LINKS

These additional references should also help you:

* [Gradle Build Scans – insights for your project's build](https://scans.gradle.com#gradle)

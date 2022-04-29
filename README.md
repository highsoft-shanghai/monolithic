# 单体应用脚手架

## 常用命令
为方便日常开发，项目预置了部分常用脚本，可以帮助项目成员快速完成一些常见的任务。

### 静态代码检查
良好的编码风格和编码格式是高质量软件的基础，时刻注意编码格式和风格是推荐的优秀实践。如需快速获得编码风格的问题反馈，请使用以下命令：
```bash
./scripts/check-static
```

### 本地CI检查
为了持续集成，项目提供了必要的基础设施，质量门禁便是其中之一。质量门禁提供了静态代码检查、单元测试、集成测试、测试覆盖率等各项质量检查项，以帮助团队守住质量继续，为持续集成提供必要的基础。
**开发每次推送代码至代码库前务必在本地执行质量门禁检查**，并且在代码被推送至代码仓库后，构建服务器也会触发质量门禁。本地执行质量检测直接执行一下命令：
```bash
./scripts/check-all
```

### REFERENCE DOCUMENTATION

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

### GUIDES

The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/bookmarks/)
* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)
* [Accessing Data with MongoDB](https://spring.io/guides/gs/accessing-data-mongodb/)
* [Building a RESTful Web Service with Spring Boot Actuator](https://spring.io/guides/gs/actuator-service/)

### ADDITIONAL LINKS

These additional references should also help you:

* [Gradle Build Scans – insights for your project's build](https://scans.gradle.com#gradle)

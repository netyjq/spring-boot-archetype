## SpringBoot Maven Archetype 脚手架
[![Build Status](https://travis-ci.org/netyjq/spring-boot-archetype.svg?branch=master)](https://travis-ci.org/netyjq/spring-boot-archetype)

### 简介

用于快速构建高效、代码干净且稳定的“spring-boot”项目。

### 特性
- `war`或者`jar`支持`maven profile`打包运行 
- 控制层统一入参验证
- 通用`Model`，`Mapper`，`Service` 让你立马开始写业务代码
- 整合`mybatis-plus3`
- 整合`swagger-ui`
- 整合`lombok`
- 全局异常封装处理
- `logger`支持`profile`
- 遵循阿里巴巴Java开发规范
- 各类实用工具封装
- ...


### 使用

你可以直接通过更改本项目包名运行，或者打包成Maven Archetype 脚手架，以便以后新的项目直接使用本套脚手架。

下面介绍打包Maven Archetype的方式：

#### 打包Maven Archetype

1. `$ git clone https://github.com/netyjq/spring-boot-archetype.git`

2. `$ cd spring-boot-archetype`，然后执行 `$ mvn clean install -U`

3. `$ mvn archetype:create-from-project`

4. `$ cd target\generated-sources\archetype`，查看`pom.xml`文件信息，可以更改成你乐意的，groupId, artifactId, version，这三个信息后面会用到。

5. `$ mvn clean install` OK 完成了

#### 使用Maven Archetype

1. 打开Intellij IDEA，点击导航按钮:文件>新建>项目>
2. 选择Maven，选中复选框"Create from Archetype"，然后点击按钮 "Add Archetype" 
3. 然后您将看到一个表单，只需输入来自上面你填写的“pom”信息。
4. 在列表中选择你刚刚创建的 "Archetype"，逐步创建项目，新项目将自动完成构建。
### Contact
- Gmail: netyjq@gmail.com
- Wechat: eWVrYXlqcQ==

### End
欢迎fork, star。有任何问题请提[issue](https://github.com/netyjq/spring-boot-archetype/issues)。



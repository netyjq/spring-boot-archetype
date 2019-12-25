## SpringBoot Maven Archetype 脚手架
[![Build Status](https://travis-ci.org/netyjq/spring-boot-archetype.svg?branch=master)](https://travis-ci.org/netyjq/spring-boot-archetype)

### 简介

 **`spring-boot-archetype`** 是一个maven脚手架，用于快速构建高效、稳定且代码干净的`spring-boot`项目。只要您安装了`Maven`，
 或者您使用`Intellij IDEA`进行编码，只需简单的几个步骤，就能基于 **`spring-boot-archetype`** 构建一个新的`spring-boot`项目。

### 特性
- 支持`maven profile`动态打包`war`或者`jar`运行 
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

### Maven依赖坐标信息

```xml
<dependency>
  <groupId>com.github.netyjq</groupId>
  <artifactId>spring-boot-archetype</artifactId>
  <version>0.0.2.release</version>
</dependency>
```

### 使用

#### 通过`Maven`命令行创建新项目

确保你已经安装了`Maven`，然后在你的终端上输入下面的命令，一段时间后，maven会提示你输入你的项目的`groupId`、`artifactId`、`version`、
`package`，之后你的项目就会自动构建成功。

```
mvn archetype:generate -DarchetypeGroupId=com.github.netyjq -DarchetypeArtifactId=spring-boot-archetype -DarchetypeVersion=0.0.2.release
```

#### 通过 `Intellij IDEA` 创建新项目

1. 打开 `Intellij IDEA`，点击导航按钮:文件>新建>项目>
2. 选择Maven，选中复选框 "Create from Archetype"，然后点击按钮 "Add Archetype" 
3. 然后您将看到一个表单，依次填写`groupId`、`artifactId`、`version`，Maven坐标信息上面有 。
4. 在列表中选择你刚刚添加 "Archetype"，逐步创建项目，新项目将自动完成构建。

**注意：Add Archetype 步骤只需执行一次，以后可直接选择 `spring-boot-archetype:0.0.2.release`**

### Contact
- Gmail: netyjq@gmail.com
- Wechat: eWVrYXlqcQ==

### End
欢迎fork, star。有任何问题请提[issue](https://github.com/netyjq/spring-boot-archetype/issues)。



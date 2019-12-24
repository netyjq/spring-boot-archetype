## SpringBoot Maven Archetype
[![Build Status](https://travis-ci.org/netyjq/spring-boot-archetype.svg?branch=master)](https://travis-ci.org/netyjq/spring-boot-archetype)

[中文文档](https://github.com/netyjq/spring-boot-archetype/blob/master/README-CN.md)

### Introduction

**`spring-boot-archetype`** is a maven scaffold for quickly building efficient, clean, and stable `spring-boot` projects. 
As long as you have `Maven` installed, or you encode using `Intellij IDEA`, you can build a new `spring-boot` project 
based on **`spring-boot-archetype`** in a few simple steps.

### Properties
- packaged to jar or war according to active profile 
- Unified `@RequestMapping` input verification
- `BaseModel`,`BaseMapper`,`BaseService` supported, write code at once
- `mybatis-plus3` supported
- `swagger-ui` supported
- `lombok` supported
- Global exception encapsulation handling
- `logger` with `profile` supported
- Follow the alibaba p3c specification
- Various utility packages
- ...

### Maven Dependency

```xml
<dependency>
  <groupId>com.github.netyjq</groupId>
  <artifactId>spring-boot-archetype</artifactId>
  <version>0.0.2.release</version>
</dependency>
```

### Usage

#### Use with maven command-line

Make sure you have already installed maven, and then type the command below to your terminal,

after a while, maven will tips you input your project's `groupId`, `artifactId`, `version`, `package`, then your project will be automatically built successfully.

```
mvn archetype:generate -DarchetypeGroupId=com.github.netyjq -DarchetypeArtifactId=spring-boot-archetype -DarchetypeVersion=0.0.2.release
```
 
#### Use with Intellij IDEA  

1. Open the Intellij IDEA, click the navigation button: File > new > Project > 
2. Choose Maven, Check the checkbox "Create from Archetype", then click button "Add Archetype" 
3. Then you will see a form, just enter the 'pom' information.
4. Select the "Archetype" you just added in the list, step by step, and the new project will automatically complete the build.

### Contact
- Gmail: netyjq@gmail.com
- Wechat: eWVrYXlqcQ==

### End
I am glad with your fork or star, any question please submit a [issue](https://github.com/netyjq/spring-boot-archetype/issues).



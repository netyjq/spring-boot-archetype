## SpringBoot Maven Archetype
[![Build Status](https://travis-ci.org/netyjq/spring-boot-archetype.svg?branch=master)](https://travis-ci.org/netyjq/spring-boot-archetype)

[中文文档](https://github.com/netyjq/spring-boot-archetype/blob/master/README-CN.md)

### Introduction

This project is used to quickly build efficient, code-clean and stable 'spring-boot' projects.

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


### Usage

You can run it directly by changing the project package name, or by packaging it as a maven archetype scaffold so that 
a new projects can be created with the maven archetype you made.

Here's how to package Maven Archetype:

1. `$ git clone https://github.com/netyjq/spring-boot-archetype.git`

2. `$ cd spring-boot-archetype`，and then `$ mvn clean install -U`

3. `$ mvn archetype:create-from-project`

4. `$ cd target\generated-sources\archetype` Check if the 'pom.xml' information needs to be modified, groupId artifactId and version is useful.

5. `$ mvn clean install`, all completed

And how to use Maven Archetype: 

1. Open the Intellij IDEA, click the navigation button: File > new > Project > 
2. Choose Maven, Check the checkbox "Create from Archetype", then click button "Add Archetype" 
3. Then you will see a form, just enter the 'pom' information from the previous step.
4. Select the "Archetype" you just created in the list, step by step, and the new project will automatically complete the build.
### Contact
- Gmail: netyjq@gmail.com
- Wechat: eWVrYXlqcQ==

### End
I am glad with your fork or star, any question please submit a [issue](https://github.com/netyjq/spring-boot-archetype/issues).



## SpringBoot Maven Archetype 脚手架
[![Build Status](https://travis-ci.org/netyjq/spring-boot-archetype.svg?branch=master)](https://travis-ci.org/netyjq/spring-boot-archetype)

### Introduction

用于快速构建高效稳定的`spring-boot`项目

### Branches

- master 单个模块项目，单pom
- master-multiple-modules 多个模块项目，多pom

### Properties
- war或者jar打包运行
- 统一入参验证
- 通用Model,Mapper,Service
- mybatis自动分页
- 全局异常封装处理
- logger支持profile
- 遵循阿里巴巴Java开发规范
- 各类实用工具封装
- ...


### Usage

你可以直接通过更改本项目包名运行，或者打包成Maven Archetype 脚手架，以便以后新的项目直接使用本套脚手架。

下面介绍打包Maven Archetype的方式：

1. `git clone https://github.com/netyjq/spring-boot-archetype.git`

2. 先进入项目目录`cd spring-boot-archetype`，然后`$ mvn clean install -U`

3. `mvn archetype:create-from-project`

4. 进入`target\generated-sources\archetype`，看下`pom` 信息 是否需要修改

5. `mvn clean install`

6. 在`Idea`中 `new project` 界面 选择`create from archetype`， 点击`add Archetype` ， 输入上一步的`pom` 信息

7. 一路按正常流程 Next 直到完成构建

### Contact

wechat: eWVrYXlqcQ==

### End
欢迎fork, star。有任何问题请提[issue](https://github.com/netyjq/spring-boot-archetype/issues)，我会全力解决。



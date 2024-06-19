# 存放west2-work6-test1作业的仓库

## 接口文档：

https://apifox.com/apidoc/shared-5220fddd-ae8b-4aaf-b961-5a4788477497

## 技术栈：

springcloud,sentinel,redis,mysql,mybatis,druid,seata,nacos,openfeign

## 项目结构：

├─gateway

│  ├─src

│  │  ├─main

│  │  │  ├─java

│  │  │  │  └─com

│  │  │  │      └─getaway

│  │  │  │          ├─config

│  │  │  │          ├─filters

│  │  │  │          └─utils

│  │  │  └─resources

│  │  └─test

│  │      └─java

│  └─target

│      ├─classes

│      │  └─com

│      │      └─getaway

│      │          ├─config

│      │          ├─filters

│      │          └─utils

│      └─generated-sources

│          └─annotations

├─logs

│  └─user-service

├─transaction-service

│  ├─src

│  │  ├─main

│  │  │  ├─java

│  │  │  │  └─com

│  │  │  │      └─transaction

│  │  │  │          ├─config

│  │  │  │          ├─controller

│  │  │  │          ├─domain

│  │  │  │          │  └─dto

│  │  │  │          ├─mapper

│  │  │  │          └─service

│  │  │  │              └─impl

│  │  │  └─resources

│  │  └─test

│  │      └─java

│  └─target

│      ├─classes

│      │  └─com

│      │      └─transaction

│      │          ├─config

│      │          ├─controller

│      │          ├─domain

│      │          │  └─dto

│      │          ├─mapper

│      │          └─service

│      │              └─impl

│      └─generated-sources

│          └─annotations

├─user-service

│  ├─src

│  │  ├─main

│  │  │  ├─java

│  │  │  │  └─com

│  │  │  │      └─user

│  │  │  │          ├─config

│  │  │  │          ├─controller

│  │  │  │          ├─domain

│  │  │  │          │  └─po

│  │  │  │          ├─mapper

│  │  │  │          ├─service

│  │  │  │          │  └─impl

│  │  │  │          └─utils

│  │  │  └─resources

│  │  └─test

│  │      └─java

│  └─target

│      ├─classes

│      │  └─com

│      │      └─user

│      │          ├─config

│      │          ├─controller

│      │          ├─domain

│      │          │  └─po

│      │          ├─mapper

│      │          ├─service

│      │          │  └─impl

│      │          └─utils

│      └─generated-sources

│          └─annotations

├─work-api

│  ├─src

│  │  ├─main

│  │  │  ├─java

│  │  │  │  └─com

│  │  │  │      └─api

│  │  │  │          ├─client

│  │  │  │          └─config

│  │  │  └─resources

│  │  └─test

│  │      └─java

│  └─target

│      ├─classes

│      │  └─com

│      │      └─api

│      │          ├─client

│      │          └─config

│      └─generated-sources

│          └─annotations

└─work-common

​    ├─src

​    │  ├─main

​    │  │  ├─java

​    │  │  │  └─com

​    │  │  │      └─yk

​    │  │  │          └─common

​    │  │  │              ├─config

​    │  │  │              ├─domain

​    │  │  │              ├─exception

​    │  │  │              ├─interceptors

​    │  │  │              └─utils

​    │  │  └─resources

​    │  │      └─META-INF

​    │  └─test

​    │      └─java

​    └─target

​        ├─classes

​        │  ├─com

​        │  │  └─yk

​        │  │      └─common

​        │  │          ├─config

​        │  │          ├─domain

​        │  │          ├─exception

​        │  │          ├─interceptors

​        │  │          └─utils

​        │  └─META-INF

​        └─generated-sources

​            └─annotations

## 项目功能

- 用户的注册，登录，事务的增删改查
- openfeign远程调用
- nacos的服务注册发现
- 使用了loadbalancer负载均衡
- sentinel集成过载熔断功能
- 使用了seata的AT模式进行分布式事务管理


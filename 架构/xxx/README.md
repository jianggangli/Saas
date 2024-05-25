1.下载项目之后执行命令：git config --global core.hooksPath .githooks
2.模块描述：
    xxx-boot：SpringBoot Application启动入口 + 配置文件
    xxx-web：Controller层 + Logic层
    xxx-service：Service层 + Dao层
    xxx-service-sdk：第三方远程调用本微服务数据
    xxx-starter：第三方集成本微服务
3.web与service可以单独部署成两个微服务，用于高并发场景的客户
4.打出来的介质：
    xxx-boot-版本号xxx-exec.jar：微服务web + 微服务service
    xxx-web-版本号xxx-exec.jar：微服务web
    xxx-service-版本号xxx-exec.jar：微服务service
    xxx-starter-版本号xxx.jar：第三方集成本微服务
    
    

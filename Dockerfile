# 该镜像需要依赖的基础镜像
FROM java:11
# 将当前目录下的jar包复制到docker容器的/目录下
ADD target/spring-boot-demo-1.0.0.jar /spring-boot-demo-1.0.0.jar
# 运行过程中创建一个jar文件
RUN bash -c 'touch /spring-boot-demo-1.0.0.jar'
# 声明服务运行在8080端口
EXPOSE 8080
# 指定docker容器启动时运行jar包
ENTRYPOINT ["java", "-jar","/spring-boot-demo-1.0.0.jar"]
# 指定维护者的名字
MAINTAINER flamingo
FROM java:8u111-jdk

ADD target/Project3_v2.UserService.jar /UserService.jar

EXPOSE 8892

CMD ["java","-jar", "UserService.jar", "com.java.Host"]

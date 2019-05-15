FROM java:8u111-jdk

ADD maven/Project3_v2.UserService.jar /UserService.jar

CMD ["java","-jar", "UserService.jar", "com.java.Host"]

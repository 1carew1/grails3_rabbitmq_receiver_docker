FROM java:7
EXPOSE 8081
ADD /build/libs/rabbitMQGrails3Rx-0.1.war rabbitMQGrails3Rx-0.1.war
ENTRYPOINT ["java","-Dgrails.env=prod","-jar","rabbitMQGrails3Rx-0.1.war"]

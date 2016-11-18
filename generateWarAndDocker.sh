grails package
docker build -f Dockerfile -t 1carew1/grails3_rabbitmq_receiver_docker .
docker push 1carew1/grails3_rabbitmq_receiver_docker
docker run  -t -p 8081:8081 1carew1/grails3_rabbitmq_receiver_docker

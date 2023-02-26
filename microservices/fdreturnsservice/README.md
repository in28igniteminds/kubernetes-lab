# FD Returns Micro Service
Run FDReturnsserviceApplication as a Java Application.

## Resources

- http://localhost:8100/api/v1/fdreturns/from/SBI/for/10000

```json

```

## Containerization

###Dockerfile

```json
FROM maven:3.8.7-openjdk-18-slim AS build
WORKDIR /home/app
COPY . /home/app
RUN mvn -f /home/app/pom.xml clean package

FROM openjdk:17-jdk-alpine
VOLUME /tmp
EXPOSE 8100
COPY --from=build /home/app/target/*.jar app.jar
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar" ]
```

### Creating Containers

- sudo docker build -t in28igniteminds/fd-returns-service:0.0.1.RELEASE .


#### Environment Variable

```
        env:     #CHANGE
          - name: CURRENCY_EXCHANGE_URI
            valueFrom:
              configMapKeyRef:
                key: CURRENCY_EXCHANGE_URI
                name: currency-exchange-uri-demo
```
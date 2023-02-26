# Bank Interest Microservice

Run com.in28minutes.interestrateservice.InterestRateserviceApplication.java as a Java application

## Resources

http://localhost:8000/rates/SBI/

```json
{
  "id": 10002,
  "bankName": "SBI",
  "interestRate": "10",
}
```
## Notes

## Tables Created
```
CREATE TABLE bank_interest_rate (
                         id   INTEGER      NOT NULL,
                         bank_name VARCHAR(128) NOT NULL,
                         interest_rate NUMERIC NOT NULL,
                         PRIMARY KEY (id)
);
```
## Data
```
insert into bank_interest_rate (id,bank_name,interest_rate)
values(10001,'SBI',10);
insert into bank_interest_rate (id,bank_name,interest_rate)
values(10002,'ICICI',20);
```

## Containerization

###Dockerfile
```
FROM maven:3.8.7-openjdk-18-slim AS build
WORKDIR /home/app
COPY . /home/app
RUN mvn -f /home/app/pom.xml clean package

FROM openjdk:17-jdk-alpine
VOLUME /tmp
EXPOSE 8000
COPY --from=build /home/app/target/*.jar app.jar
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar" ]
```
### Creating Container

- sudo docker build -t in28igniteminds/bank-interest-service:0.0.2.RELEASE .

### Running Container

#### Basic
```
docker container run --publish 8000:8000 in28igniteminds/bank-interest-service:0.0.2.RELEASE
```
FROM maven:3.6.3-jdk-11-slim AS build
RUN mkdir /opt/api-springboot-engine-loyalty
WORKDIR /opt/api-springboot-engine-loyalty
COPY . /opt/api-springboot-engine-loyalty
RUN mvn clean package

FROM gcr.io/distroless/java:11
COPY --from=build /opt/api-springboot-engine-loyalty/app/target/app*.jar api-springboot-engine-loyalty.jar
EXPOSE 8080
CMD ["api-springboot-engine-loyalty.jar"]
FROM openjdk:11-jre-slim-buster
EXPOSE 8095
RUN mkdir -p /app/
ADD build/libs/StrategyExample-1.jar /app/StrategyExample-1.jar
ENTRYPOINT ["java", "-jar", "/app/StrategyExample-1.jar"]
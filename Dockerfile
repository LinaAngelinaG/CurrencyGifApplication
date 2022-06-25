FROM adoptopenjdk/openjdk11:ubi
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} ./
EXPOSE 8080
ENTRYPOINT ["java","-jar","./"]


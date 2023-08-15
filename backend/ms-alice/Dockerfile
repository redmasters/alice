FROM arm64v8/gradle:jdk17 AS builder
ENV APP_HOME=/app/
WORKDIR $APP_HOME
COPY build.gradle settings.gradle $APP_HOME

COPY gradle $APP_HOME/gradle
COPY --chown=gradle:gradle . /home/gradle/src
USER root
RUN chown -R gradle /home/gradle/src

RUN gradle build || return 0
COPY . .
RUN gradle clean build

FROM arm64v8/gradle:jdk17 AS jre-build
# actual container
ENV ARTIFACT_NAME=ms-alice-0.0.1-SNAPSHOT.jar
ENV APP_HOME=/app

WORKDIR $APP_HOME
COPY --from=builder $APP_HOME/build/libs/$ARTIFACT_NAME .

EXPOSE 8081
ENTRYPOINT exec java -jar ${ARTIFACT_NAME}

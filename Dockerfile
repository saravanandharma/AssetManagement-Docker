#######################  stage 1  ####################################
#Start with a base image containing Java runtime
FROM openjdk:11-slim as build

# Java version
#ENV JAVA_VERSION=11.0.12 \
#	JAVA_HOME=/usr/java/jdk-11

#ENV	PATH $JAVA_HOME/bin:$PATH

#Maintaier Info
LABEL maintainer="Saravanan Dharmalingam saravanan.dharmalingam@gmail.com"

#Applciations's Jar File type
ARG JAR_FILE

#Add the application's jar to the container
COPY ${JAR_FILE} app.jar

#Unpacking the application's jar
RUN mkdir -p target/dependency && (cd target/dependency; jar -xf /app.jar)

##################### Stage 2 ##########################################
#Same Java Runtime
FROM openjdk:11-slim

# Add volume pointing to /tmp
VOLUME /tmp

#Copy unpacked application to the new container
ARG DEPENDENCY=/target/dependency
COPY --from=build ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY --from=build ${DEPENDENCY}/META-INF /app/META-INF
COPY --from=build ${DEPENDENCY}/BOOT-INF/classes /app

#Execute the application
ENTRYPOINT ["java","-cp","app:app/lib/*","com.saravanan.assetmgmt.AssetmgmtApplication"]


FROM openjdk:17

LABEL maintainer="Ktronics"

# Add Target Jar
ADD target/DeviceDownDetectorSpring-0.0.1-SNAPSHOT.jar DeviceDownDetectorSpring.jar

# Add Entrypoint
ENTRYPOINT ["java", "-jar", "DeviceDownDetectorSpring.jar"]
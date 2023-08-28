# DOCKER 배포 파일
# OpenJDK 를 빌드용으로 가져온다.
FROM openjdk:17-ea-11-jdk-slim AS builder

# 파일 복사
COPY gradlew .
COPY gradle gradle
COPY build.gradle .
COPY settings.gradle .
COPY src src

# gradlew에 실행권한을 준다.
RUN chmod +x ./gradlew

# Clean 하여 generate 된 Q클래스 삭제
RUN ./gradlew clean

# Jar 파일로 빌드
RUN ./gradlew bootJar

# 빌드된 Jar 파일을 /libs 로 복사한다.
FROM openjdk:17-ea-11-jdk-slim
COPY --from=builder build/libs/*.jar cts-monitor.jar

# 빌드 포트
EXPOSE 8082
# 설정된 profile로 Application 시작
ENTRYPOINT ["java","-jar", "/cts-monitor.jar"]
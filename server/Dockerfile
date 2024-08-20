# Bước 1: Sử dụng image Java chính thức để build ứng dụng
FROM maven:3.8.5-openjdk-17 AS build

# Thiết lập thư mục làm việc
WORKDIR /app

# Copy các file cần thiết vào container
COPY pom.xml ./
COPY src ./src

# Cài đặt Maven và build ứng dụng
RUN mvn clean package -DskipTests

# Bước 2: Tạo image chạy ứng dụng
FROM openjdk:17-jdk-alpine

# Thiết lập thư mục làm việc
WORKDIR /app

# Copy file JAR từ giai đoạn build vào container
COPY --from=build /app/target/*.jar app.jar

# Expose cổng mà ứng dụng sẽ chạy và cổng debug
EXPOSE 8080 5005

# Lệnh để chạy ứng dụng với hỗ trợ debug
ENTRYPOINT ["java", "-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=5005", "-jar", "/app/app.jar"]

FROM gradle:7.4.2-jdk17 AS build

WORKDIR /app

# Copia os arquivos de definição do Gradle (build.gradle, settings.gradle, etc) e o código fonte
COPY --chown=gradle:gradle build.gradle settings.gradle gradlew /home/gradle/src/
COPY --chown=gradle:gradle gradle /home/gradle/src/gradle
COPY --chown=gradle:gradle src /home/gradle/src/src

# Define o diretório de trabalho
WORKDIR /home/gradle/src

# Executa o build do Gradle, resultando no jar executável
RUN gradle build --no-daemon

# Etapa de execução
FROM openjdk:17

# Copia o jar executável do estágio de build para o estágio de execução
#COPY --from=build ./build/libs/rinha.backend-0.0.1-SNAPSHOT.jar /app/rinha.jar
# Copia o jar executável do estágio de build para o estágio de execução
COPY --from=build /home/gradle/src/build/libs/*.jar /app/app.jar

# Define o diretório de trabalho
WORKDIR /app

# Comando para executar a aplicação
CMD ["java", "-jar", "app.jar"]

EXPOSE 3000


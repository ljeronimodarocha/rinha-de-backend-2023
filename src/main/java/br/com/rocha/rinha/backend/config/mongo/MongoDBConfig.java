package br.com.rocha.rinha.backend.config.mongo;


import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.config.AbstractReactiveMongoConfiguration;

public class MongoDBConfig extends AbstractReactiveMongoConfiguration {

    @Value("DATABASE_URL")
    private String DATABASE_URL;

    @Bean
    public MongoClient mongoClient() {
        return MongoClients.create();
    }

    @Override
    protected String getDatabaseName() {
        return DATABASE_URL;
    }
}
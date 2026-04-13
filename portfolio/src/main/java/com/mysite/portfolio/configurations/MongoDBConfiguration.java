package com.mysite.portfolio.configurations;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
public class MongoDBConfiguration {
    @Autowired
    ProjectProperties properties;

    private final MongoClient mongoClient;

    public MongoDBConfiguration(ProjectProperties properties)
    {
        this.properties = properties;
        System.out.println("*** Hello ***");
        System.out.println("development.stage: " + properties.getStage());
        System.out.println("development.mongoDbUri: " + properties.getMongoDbUri());
        this.mongoClient = MongoClients.create(properties.getMongoDbUri());

    }

    @Bean
    public MongoTemplate mongoTemplate() {
        // You need to specify the database name here (e.g., "myDatabase")
        System.out.println("--- HERE ---");
        String stageSuffix = ("test".equalsIgnoreCase(properties.getStage()) ? "-test" : "");
        return new MongoTemplate(mongoClient, "shoppingLists" + stageSuffix);
    }

}

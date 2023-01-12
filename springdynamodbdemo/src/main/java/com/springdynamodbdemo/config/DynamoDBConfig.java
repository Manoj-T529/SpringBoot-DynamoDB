package com.springdynamodbdemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;

@Configuration
public class DynamoDBConfig {

	private static final String secretKey = "FOmDACoOKAA/r4e9jP0WGA0+/C8O8sis2nX3oCoA";
	private static final String accessKey = "AKIAXUDM3OXZJRDXZ4HY";
	private static final String region = "us-east-1";
	private static final String serviceEndPoint = "dynamodb.us-east-1.amazonaws.com";

	
	@Bean
	public DynamoDBMapper dynamoDBMapper() {
		return new DynamoDBMapper(amazonDynamoDBConfig());
	}

	private AmazonDynamoDB amazonDynamoDBConfig() {
		// TODO Auto-generated method stub
		return AmazonDynamoDBClientBuilder.standard()
				.withEndpointConfiguration(
						new AwsClientBuilder.EndpointConfiguration(serviceEndPoint, region))
				.withCredentials(new AWSStaticCredentialsProvider(
						new BasicAWSCredentials(accessKey, secretKey)))
				.build();
	}

}// https://us-east-1.console.aws.amazon.com/dynamodbv2/home?region=us-east-1#tables

package com;

import java.util.Properties;

public class Producer {
	public Properties initProducer() {
		Properties props = new Properties();
		 props.put("bootstrap.servers", "118.89.37.123:9092,118.89.58.94:9092");
		 props.put("acks", "all");
		 props.put("retries", 0);
		 props.put("batch.size", 16384);
		 props.put("linger.ms", 1);
		 props.put("buffer.memory", 33554432);
		 props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		 props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		return props;
	}
}

package com;

import java.util.Properties;

public class Consumer {
	public Properties initConsumer() {
		Properties properties = new Properties();
		properties.put("bootstrap.servers", "118.89.37.123:9092,118.89.58.94:9092");
		//设置不自动提交，自己手动更新offset
		properties.put("enable.auto.commit", "true");
		properties.put("auto.offset.reset", "earliest");
		properties.put("session.timeout.ms", "30000");
		properties.put("key.deserializer",
			"org.apache.kafka.common.serialization.StringDeserializer");
		properties.put("value.deserializer",
			"org.apache.kafka.common.serialization.StringDeserializer");
		properties.put("group.id", "test");
		properties.put("auto.commit.interval.ms", "1000");
		return properties;

	}
}

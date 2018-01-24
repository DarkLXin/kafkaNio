package com;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.Pipe;
import java.util.Arrays;
import java.util.Date;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import com.sun.jmx.snmp.Timestamp;
import com.sun.org.apache.bcel.internal.generic.NEW;
public class Test {

	public static void main(String[] args){
		/**
		 * kafka
		 */
	Producer producer =new Producer();
		Consumer consumer = new Consumer();
		KafkaProducer<String, String> kafkaProducer = new KafkaProducer<String, String>(producer.initProducer());
		kafkaProducer.send(new ProducerRecord<String, String>("testDZK","testKafka", "testKafka£¡"));
		kafkaProducer.close();
		KafkaConsumer<String, String> cons = new KafkaConsumer<String, String>(consumer.initConsumer());
		cons.subscribe(Arrays.asList("testDZK"));
        while (true) {
            ConsumerRecords<String, String> records = cons.poll(20);
            for (ConsumerRecord<String, String> record : records)
                System.out.printf("offset = %d, key = %s, value = %s%n", record.offset(), record.key(), record.value());
        }
		/**
		 * nio
		 */
/*		RandomAccessFile aFile;
		try {
			aFile = new RandomAccessFile("data/nio-data.txt", "rw");
			//Pipe pipe = Pipe.open();
			//Pipe.SinkChannel sinkChannel = pipe.sink();
			
			FileChannel inChannel = aFile.getChannel();
			ByteBuffer buf = ByteBuffer.allocate(100);
			int bytesRead = inChannel.read(buf);
			System.out.println(bytesRead);
			String newData = "...winner winner chicken dinner... ";
			buf.clear();
			buf.put(newData.getBytes());
			buf.flip();
			while(buf.hasRemaining()) {
				inChannel.write(buf);
					System.out.println("position--"+inChannel.position()+"--channel size--"+inChannel.size());
			}
			inChannel.close();
			//Pipe.SourceChannel sourceChannel = pipe.source();
			//ByteBuffer buff = ByteBuffer.allocate(48);
			//int bytesRead = sourceChannel.read(buff);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
*/
		/**
		 * thread
		 */
/*		System.out.println(Thread.currentThread().getName());
		
		      for(int i=0; i<10; i++){
		         new Thread("" + i){
		            public void run(){
		             System.out.println("Thread: " + getName() + "running");
		            }
		         }.start();
		      }*/

	}
}

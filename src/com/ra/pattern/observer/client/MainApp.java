package com.ra.pattern.observer.client;

import com.ra.pattern.observer.ItemConsumer;
import com.ra.pattern.observer.subject.ItemProducer;

public class MainApp {

	public static void main(String[] args) {
		ItemProducer<String> producer = new ItemProducer<>();

		int i=0;
		for(; i<3; i++) {
			producer.produceItem(new String("Pippo" + i));
		}
		
		producer.register(new ItemConsumer<String>());
		
		for(; i<5; i++) {
			producer.produceItem(new String("Pippo" + i));
		}
		
		producer.register(new ItemConsumer<String>());
		producer.register(new ItemConsumer<String>());
		
		producer.produceItem(new String("Pippo" + i));
		
		producer.register(new ItemConsumer<String>());
	}
}

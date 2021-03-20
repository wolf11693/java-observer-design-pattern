package com.ra.pattern.observer.client;

import java.util.ArrayList;
import java.util.List;

import com.ra.pattern.observer.ItemConsumer;
import com.ra.pattern.observer.subject.ItemProducer;

public class MainApp {

	public static void main(String[] args) {
		ItemConsumer<String> consumerA = new ItemConsumer<>();
		ItemConsumer<String> consumerB = new ItemConsumer<>();
		ItemConsumer<String> consumerC = new ItemConsumer<>();
		
		ItemProducer<String> producer = new ItemProducer<>();
		List<String> list = new ArrayList<>();
		list.add(new String("Pippo1"));
		list.add(new String("Pippo2"));
		list.add(new String("Pippo3"));
		list.add(new String("Pippo4"));
		producer.setItemsProduced(list);
		producer.register(consumerA);
		producer.register(consumerB);
		producer.register(consumerC);
		
		producer.produceItem(new String("Pippo5"));
		
		ItemConsumer<String> consumerD = new ItemConsumer<>();
		producer.register(consumerD);
	}
}

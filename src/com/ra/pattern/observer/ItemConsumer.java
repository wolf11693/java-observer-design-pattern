package com.ra.pattern.observer;

import java.util.ArrayList;
import java.util.List;

public class ItemConsumer<E> implements Observer {
	
	private List<E> itemsReceived;
	
	public ItemConsumer() {
		super();
		this.itemsReceived = new ArrayList<>();
	}
	
	public List<E> getItemsReceived() {
		return itemsReceived;
	}

	@Override
	public <T> void update(T item) {
		this.itemsReceived.add((E) item);
		System.out.println("received item: " + item);
	}

}
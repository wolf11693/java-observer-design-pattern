package com.ra.pattern.observer.subject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.ra.pattern.observer.Observer;

public class ItemProducer<T> implements Subject {

	private List<T> itemsProduced;
	private int itemsSended = 0;
	private Map<Observer, Integer> observers;
	
	public ItemProducer() {
		this.itemsProduced = new ArrayList<>();
		this.observers = new HashMap<>();
	}

	public List<T> getItemsProduced() {
		return itemsProduced;
	}
	
	public void produceItem(T item) {
		this.itemsProduced.add(item);
		if(itemsSended < itemsProduced.size()) {
			this.notifyObservers();
		}
	}

	public Map<Observer, Integer> getObservers() {
		return observers;
	}

	public void setObservers(Map<Observer, Integer> observers) {
		this.observers = observers;
	}

	@Override
	public void register(Observer observer) {
		if(observer != null && !this.observers.containsKey(observer)) {
			this.observers.put(observer, 0);
		}
		this.notifyObservers();
	}

	@Override
	public void unregister(Observer observer) {
		if(observer != null && this.observers.containsKey(observer)) {
			this.observers.remove(observer);
		}
	}

	@Override
	public void notifyObservers() {
		for(Entry<Observer, Integer> entry : this.observers.entrySet()) {
			Observer observer = entry.getKey();
			int nextItemToReceive = entry.getValue();
			
			int i=nextItemToReceive;
			for(; i<this.itemsProduced.size(); i++) {
				observer.update(this.itemsProduced.get(i));
			}
			
			entry.setValue(i);
		}
		
		this.itemsSended = this.itemsProduced.size();
	}
}
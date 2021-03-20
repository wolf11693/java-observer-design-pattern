package com.ra.pattern.observer.subject;

import com.ra.pattern.observer.Observer;

public interface Subject {

	public void register(Observer observer);
	
	public void unregister(Observer observer);
	
	public void notifyObservers();
}

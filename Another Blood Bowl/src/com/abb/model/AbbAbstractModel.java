/**
 * 
 */
package com.abb.model;

import java.util.ArrayList;

import com.abb.observer.Observable;
import com.abb.observer.Observer;

/**
 * @author wdzt6311
 *
 */
public class AbbAbstractModel implements Observable 
{
	private ArrayList<Observer> listObserver = new ArrayList<Observer>();   

	// Observer pattern
	public void addObserver(Observer obs) 
	{
		this.listObserver.add(obs);
	}

	public void notifyObserver() 
	{
		for(Observer obs : listObserver)
			obs.update();
	}
	
	public void removeObserver()
	{
		listObserver = new ArrayList<Observer>();
	}  
}

/**
 * 
 */
package com.abb.observer;

/**
 * @author wdzt6311
 *
 */
public interface Observable {
	  public void addObserver(Observer obs);
	  public void removeObserver();
	  public void notifyObserver();
}

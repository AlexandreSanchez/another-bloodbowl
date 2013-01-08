/**
 * 
 */
package com.abb.controler;

import com.abb.model.AbbMatch;
import com.abb.observer.Observer;
import com.abb.view.AbbBoardView;

/**
 * @author wdzt6311
 *
 */
public class AbbBoardControler extends AbbAbstractControler
{
	private AbbBoardView view;
	private AbbMatch model;
	
	public AbbBoardControler(AbbMatch model) 
	{
		this.model = model;	
		this.view = new AbbBoardView(this);
		
		addListenersToModel();
	}
 
	private void addListenersToModel()
	{
		model.addObserver(view);
	}
}

/**
 * 
 */
package com.abb.controler;

import com.abb.model.AbbAbstractModel;


/**
 * @author wdzt6311
 *
 */

public abstract class AbbAbstractControler 
{
	private AbbAbstractModel model;
	
	public AbbAbstractControler(AbbAbstractModel model) 
	{
		this.model = model;		
	}

	public AbbAbstractModel getModel()
	{
		return model;
	}
}

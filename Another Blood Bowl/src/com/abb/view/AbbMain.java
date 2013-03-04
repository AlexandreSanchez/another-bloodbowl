package com.abb.view;

import com.abb.controler.*;
import com.abb.model.*;

/**
 * 
 */
 
/**
 * @author wdzt6311
 *
 */
public class AbbMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		AbbAbstractModel model = new AbbMatch();
		AbbAbstractControler controler = new AbbBoardControler(model);
	    AbbBoardView board = new AbbBoardView(controler);
	    model.addObserver(board);
	}
}

package com.abb.view;

import com.abb.controler.AbbBoardControler;
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
		AbbMatch model = new AbbMatch();
		AbbBoardControler controler = new AbbBoardControler(model);
	}
}

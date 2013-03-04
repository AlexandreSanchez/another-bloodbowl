/**
 * 
 */
package com.abb.view;

import java.awt.GridLayout;

import javax.swing.JPanel;

import com.abb.controler.AbbAbstractControler;
import com.abb.controler.AbbBoardControler;
import com.abb.model.AbbAbstractModel;
import com.abb.model.AbbField;
import com.abb.model.AbbMatch;

/**
 * @author wdzt6311
 *
 */
public class AbbFieldView extends JPanel
{
	private int LENGHT = 26;
	private int HEIGHT = 15;
	private AbbSquareView[][] squares;
	private AbbMatch model;
		
	public AbbFieldView(AbbAbstractModel model)
	{		
        this.model = (AbbMatch) model;

        this.setLayout(new GridLayout(HEIGHT, LENGHT));
	    squares = new AbbSquareView[LENGHT][HEIGHT];
	    
        for (int j=0;j<HEIGHT;j++)
        {
        	for (int i=0;i<LENGHT;i++)
        	{
        		squares[i][j] = new AbbSquareView(this.model.getField().getSquare(i, j));
        		this.add(squares[i][j]);
        	}
        }
	}
}

/**
 * 
 */
package com.abb.view;

import java.awt.GridLayout;

import javax.swing.JPanel;

import com.abb.controler.AbbAbstractControler;
import com.abb.controler.AbbBoardControler;
import com.abb.model.AbbField;

/**
 * @author wdzt6311
 *
 */
public class AbbFieldView extends JPanel
{
    private AbbAbstractControler controler;
	private int LENGHT = 26;
	private int HEIGHT = 15;
	private AbbSquareView[][] squares;
		
	public AbbFieldView(AbbAbstractControler controler)
	{		
        this.controler = controler;                

        this.setLayout(new GridLayout(HEIGHT, LENGHT));
	    squares = new AbbSquareView[LENGHT][HEIGHT];
	    
        for (int j=0;j<HEIGHT;j++)
        {
        	for (int i=0;i<LENGHT;i++)
        	{
        		squares[i][j] = new AbbSquareView(controler);
        		this.add(squares[i][j]);
        	}
        }
	}
}

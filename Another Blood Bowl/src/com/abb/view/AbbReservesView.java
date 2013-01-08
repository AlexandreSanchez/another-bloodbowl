/**
 * 
 */
package com.abb.view;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JPanel;

import com.abb.controler.AbbAbstractControler;
import com.abb.controler.AbbBoardControler;
import com.abb.model.AbbDugouts;

/**
 * @author wdzt6311
 *
 */
public class AbbReservesView extends JPanel
{
    private AbbAbstractControler controler;

    private int LENGHT = 3;
	private int HEIGHT = 6;

	public AbbReservesView(AbbAbstractControler controler)
	{
        this.controler = controler;                
	    this.setLayout(new GridLayout(HEIGHT, LENGHT));
	    this.update();
	}

	public void update()
	{     	
	    int id = 0;
        for (int j=0;j<HEIGHT;j++)
        {        	
        	for (int i=0;i<LENGHT;i++)
        	{
        		String txt = "";
        		Color col = Color.LIGHT_GRAY;
        		id = j*LENGHT + i;
        		
        		if (id < model.getReserves().size())
        		{
        			txt += model.getReserves().get(id).getNumber();
        			col = Color.ORANGE;
        		}
        		
        		JButton button = new JButton(txt);
        		button.setBackground(col);
        		button.setMargin(new Insets(0,0,0,0));
        		this.add(button);
        	}
        }		
	}
	
}

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
import com.abb.model.AbbAbstractModel;
import com.abb.model.AbbDugouts;

/**
 * @author wdzt6311
 *
 */
public class AbbDeadAndInjuriedView extends JPanel 
{
    private AbbDugouts model;

    private int LENGHT = 3;
	private int HEIGHT = 4;

	public AbbDeadAndInjuriedView(AbbAbstractModel model)
	{
        this.model = (AbbDugouts) model;                
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
        		String txt = "I";
        		Color col = Color.LIGHT_GRAY;
        		id = j*LENGHT + i;
        		
        		if (id < model.getDeadAndInjuried().size())
        		{
        			txt += model.getDeadAndInjuried().get(id).getNumber();
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

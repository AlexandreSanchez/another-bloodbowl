/**
 * 
 */
package com.abb.view;

import java.awt.Color;
import java.awt.Container;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import com.abb.controler.AbbAbstractControler;
import com.abb.controler.AbbBoardControler;
import com.abb.controler.SquareListener;
import com.abb.model.AbbField;
import com.abb.model.AbbSquare;
import com.abb.model.FieldZones;
import com.abb.observer.Observer;

/**
 * @author wdzt6311
 *
 */
public class AbbSquareView  extends JButton implements Observer
{   
    private AbbAbstractControler controler;

    public AbbSquareView(AbbAbstractControler controler)
	{
        this.controler = controler;                
	}
	
	private Color getColorFromZoneType(FieldZones aZoneType)
	{
		Color col;
		
		switch(aZoneType)
		{
		case EndZoneLeft:
		case EndZoneRight:
			col = Color.PINK;
			break;
		case WideZoneLeftUp:
		case WideZoneLeftDown:
		case WideZoneRightUp:
		case WideZoneRightDown:
			col = Color.GRAY;
			break;
		case ScrimmageLeft:
		case ScrimmageRight:
			col = Color.MAGENTA;
			break;
		default:			
			col = Color.WHITE;
		}
		
		return col;
	} 
	
	public void update()
	{
		String txt = "";
		Color col = getColorFromZoneType(model.getZoneType());
//		if (model.isPlayerAvailable())
//		{
//			txt += model.getPlayer().getNumber();	
//			if (model.getPlayer().getTeam() == 1)
//			{
//				col = Color.RED;
//			}
//			else
//			{
//				col = Color.BLUE;
//			}
//		}
//		else
//		{
//			txt += model.getTackleZones(1);
//			txt += "/";
//			txt += model.getTackleZones(2);
//			if (model.getTackleZones(1) != 0)
//			{
//				col = Color.YELLOW;
//			}
//		}
//		if (model.isBallPresent())
//		{
//			txt += "B";
//			col = Color.GREEN;
//		}
//
		setText(txt);
		setBackground(col);
		setMargin(new Insets(0,0,0,0));
		addActionListener(new SquareListener());
	}
	
	class SquareListener implements ActionListener
	{
	    public void actionPerformed(ActionEvent e)
	    {
	    }              
	}
}

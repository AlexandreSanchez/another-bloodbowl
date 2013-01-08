package com.abb.view;
/**
 * 
 */

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;

import com.abb.controler.AbbAbstractControler;
import com.abb.controler.AbbBoardControler;
import com.abb.model.AbbMatch;
import com.abb.model.FieldZones;
import com.abb.observer.Observable;
import com.abb.observer.Observer;

/**
 * @author wdzt6311
 *
 */
public class AbbBoardView extends JFrame implements Observer
{
    private JPanel container = new JPanel();
	
	private AbbFieldView field;
    private AbbDugoutsView dugoutsHome;
    private AbbDugoutsView dugoutsAway;

    public AbbBoardView(AbbAbstractControler controler)
    {          
        field = new AbbFieldView(controler);
        dugoutsHome = new AbbDugoutsView(controler);
        dugoutsAway = new AbbDugoutsView(controler);

        this.setSize(1000, 450);
        this.setTitle("Another Blood Bowl");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
    	container.setLayout(new BorderLayout());
    	
    	container.add(field, BorderLayout.CENTER);
    	container.add(dugoutsHome, BorderLayout.WEST);
    	container.add(dugoutsAway, BorderLayout.EAST);
    	
    	container.setVisible(true);

    	this.setContentPane(container);
        this.setVisible(true);
    }

	@Override
	public void update()
	{
		// TODO Auto-generated method stub
		
	}
}

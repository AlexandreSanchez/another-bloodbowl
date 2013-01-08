/**
 * 
 */
package com.abb.view;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import com.abb.controler.AbbAbstractControler;
import com.abb.controler.AbbBoardControler;
import com.abb.model.AbbDugouts;

/**
 * @author wdzt6311
 *
 */
public class AbbDugoutsView  extends JPanel
{
    private AbbAbstractControler controler;

    private AbbReservesView reserves;
    private AbbKnockedOutView knockedOut;
    private AbbDeadAndInjuriedView deadAndInjuried;

	public AbbDugoutsView(AbbAbstractControler controler)
	{
        this.controler = controler;                

        reserves = new AbbReservesView(controler);
		knockedOut = new AbbKnockedOutView(controler);
		deadAndInjuried = new AbbDeadAndInjuriedView(controler);
		
		this.setLayout(new BorderLayout());
    	this.add(reserves, BorderLayout.NORTH);
    	this.add(knockedOut, BorderLayout.CENTER);
    	this.add(deadAndInjuried, BorderLayout.SOUTH);
	}
}

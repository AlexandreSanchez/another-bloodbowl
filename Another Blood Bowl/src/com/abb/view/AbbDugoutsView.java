/**
 * 
 */
package com.abb.view;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import com.abb.controler.AbbAbstractControler;
import com.abb.controler.AbbBoardControler;
import com.abb.model.AbbAbstractModel;
import com.abb.model.AbbDugouts;

/**
 * @author wdzt6311
 *
 */
public class AbbDugoutsView  extends JPanel
{
    private AbbDugouts model;

    private AbbReservesView reserves;
    private AbbKnockedOutView knockedOut;
    private AbbDeadAndInjuriedView deadAndInjuried;

	public AbbDugoutsView(AbbAbstractModel model)
	{
        this.model = (AbbDugouts) model;                

        reserves = new AbbReservesView(model);
		knockedOut = new AbbKnockedOutView(model);
		deadAndInjuried = new AbbDeadAndInjuriedView(model);
		
		this.setLayout(new BorderLayout());
    	this.add(reserves, BorderLayout.NORTH);
    	this.add(knockedOut, BorderLayout.CENTER);
    	this.add(deadAndInjuried, BorderLayout.SOUTH);
	}
}

package com.abb.model;
import java.util.ArrayList;

/**
 * 
 */

/**
 * @author wdzt6311
 *
 */
public class AbbDugouts {
	private ArrayList<AbbPlayer> reserves = new ArrayList<AbbPlayer>();
	private ArrayList<AbbPlayer> knockedOut = new ArrayList<AbbPlayer>();
	private ArrayList<AbbPlayer> deadAndInjuried = new ArrayList<AbbPlayer>();
	/**
	 * @return the reserves
	 */
	public ArrayList<AbbPlayer> getReserves() {
		return reserves;
	}
	/**
	 * @param reserves the reserves to set
	 */
	public void setReserves(ArrayList<AbbPlayer> reserves) {
		this.reserves = reserves;
	}
	/**
	 * @return the knockedOut
	 */
	public ArrayList<AbbPlayer> getKnockedOut() {
		return knockedOut;
	}
	/**
	 * @param knockedOut the knockedOut to set
	 */
	public void setKnockedOut(ArrayList<AbbPlayer> knockedOut) {
		this.knockedOut = knockedOut;
	}
	/**
	 * @return the deadAndInjuried
	 */
	public ArrayList<AbbPlayer> getDeadAndInjuried() {
		return deadAndInjuried;
	}
	/**
	 * @param deadAndInjuried the deadAndInjuried to set
	 */
	public void setDeadAndInjuried(ArrayList<AbbPlayer> deadAndInjuried) {
		this.deadAndInjuried = deadAndInjuried;
	}
	
	public void addPlayerInReserve(AbbPlayer p)
	{
		reserves.add(p);
	}
	public void addPlayerInKO(AbbPlayer p)
	{
		knockedOut.add(p);
	}
	public void addPlayerInInjuries(AbbPlayer p)
	{
		deadAndInjuried.add(p);
	}
	
	public void getKosBack()
	{
		for(int i = 0; i < knockedOut.size(); i++)
		{
			
			int dice = AbbDiceEngine.launchD6();
			if (dice > 3)
			{
				reserves.add(knockedOut.get(i));
				knockedOut.remove(i);
			}
		}
	}
}

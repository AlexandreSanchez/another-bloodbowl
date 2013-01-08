package com.abb.model;
import java.util.ArrayList;

/**
 * 
 */

/**
 * @author wdzt6311
 *
 */
public class AbbMatchTeam {
	private AbbTeam team;
	private FieldZones side;
	private ArrayList<AbbInducements> inducements = new ArrayList<AbbInducements>();
	private ArrayList<AbbPlayer> playersOnField = new ArrayList<AbbPlayer>();
	private AbbDugouts dugouts = new AbbDugouts();
	private int fans = 0;
	private int FAME = 0;
	private int TD = 0;
	private int turn = 0;
	private int extraReRoll = 0;
	
	public void getKosBack()
	{
		dugouts.getKosBack();
	}
	
	/**
	 * @return the team
	 */
	public AbbTeam getTeam() {
		return team;
	}

	/**
	 * @param team the team to set
	 */
	public void setTeam(AbbTeam team) {
		this.team = team;
	}

	/**
	 * @return the inducements
	 */
	public ArrayList<AbbInducements> getInducements() {
		return inducements;
	}

	/**
	 * @param inducements the inducements to set
	 */
	public void setInducements(ArrayList<AbbInducements> inducements) {
		this.inducements = inducements;
	}

	/**
	 * @return the dugouts
	 */
	public AbbDugouts getDugouts() {
		return dugouts;
	}

	/**
	 * @param dugouts the dugouts to set
	 */
	public void setDugouts(AbbDugouts dugouts) {
		this.dugouts = dugouts;
	}

	/**
	 * @return the extraReRoll
	 */
	public int getExtraReRoll() {
		return extraReRoll;
	}

	/**
	 * @param extraReRoll the extraReRoll to set
	 */
	public void setExtraReRoll(int extraReRoll) {
		this.extraReRoll = extraReRoll;
	}

	/**
	 * @return the fans
	 */
	public int getFans() {
		return fans;
	}

	/**
	 * @param fans the fans to set
	 */
	public void setFans(int fans) {
		this.fans = fans;
	}

	/**
	 * @return the fAME
	 */
	public int getFAME() {
		return FAME;
	}

	/**
	 * @param fAME the fAME to set
	 */
	public void setFAME(int fAME) {
		FAME = fAME;
	}

	public int getNbReRolls()
	{
		return team.getNbReRolls() + extraReRoll;
	}
	
	/**
	 * @return the side
	 */
	public FieldZones getSide() {
		return side;
	}

	/**
	 * @param side the side to set
	 */
	public void setSide(FieldZones side) {
		this.side = side;
	}
	
	/**
	 * @return the tD
	 */
	public int getTD() {
		return TD;
	}

	/**
	 * @param tD the tD to set
	 */
	public void setTD(int tD) {
		TD = tD;
	}

	/**
	 * @return the turn
	 */
	public int getTurn() {
		return turn;
	}

	/**
	 * @param turn the turn to set
	 */
	public void setTurn(int turn) {
		this.turn = turn;
	}

	public void calculateFAME(int opposingFans)
	{
		if (fans <= opposingFans)
		{
			setFAME(0);
		}
		else if (fans >= 2*opposingFans)
		{
			setFAME(2);
		}
		else
		{
			setFAME(1);
		}		
		System.out.println("[SETUP] "+team.getName()+" has "+fans+" fans and a FAME of "+FAME);	
	}
	
	public AbbMatchTeam(AbbTeam roster, FieldZones sideMainZone)
	{
		team = roster;
		side = sideMainZone;
		dugouts.setReserves(team.getPlayerList());
		fans = (team.getNbFanFactor() + AbbDiceEngine.launchD6(2)) * 1000;
	}
}

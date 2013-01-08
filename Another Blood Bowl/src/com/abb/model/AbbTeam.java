package com.abb.model;
import java.util.ArrayList;

/**
 * 
 */

/**
 * @author wdzt6311
 *
 */
public class AbbTeam {
	private Races race;
	private String name = "";
	private int uid = 0;
	private int value, treasury = 0;
	private int nbReRolls, nbFanFactor, nbApothecary, nbCheerLeaders, nbAssistantCoaches = 0;
	private ArrayList<AbbPlayer> playerList = new ArrayList<AbbPlayer>();
	
	/**
	 * @return the uid
	 */
	public int getUid() {
		return uid;
	}

	/**
	 * @param uid the uid to set
	 */
	public void setUid(int uid) {
		this.uid = uid;
	}

	/**
	 * @return the race
	 */
	public Races getRace() {
		return race;
	}

	/**
	 * @param race the race to set
	 */
	public void setRace(Races race) {
		this.race = race;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the value
	 */
	public int getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(int value) {
		this.value = value;
	}

	/**
	 * @return the treasury
	 */
	public int getTreasury() {
		return treasury;
	}

	/**
	 * @param treasury the treasury to set
	 */
	public void setTreasury(int treasury) {
		this.treasury = treasury;
	}

	/**
	 * @return the nbReRolls
	 */
	public int getNbReRolls() {
		return nbReRolls;
	}

	/**
	 * @param nbReRolls the nbReRolls to set
	 */
	public void setNbReRolls(int nbReRolls) {
		this.nbReRolls = nbReRolls;
	}

	/**
	 * @return the nbFanFactor
	 */
	public int getNbFanFactor() {
		return nbFanFactor;
	}

	/**
	 * @param nbFanFactor the nbFanFactor to set
	 */
	public void setNbFanFactor(int nbFanFactor) {
		this.nbFanFactor = nbFanFactor;
	}

	/**
	 * @return the nbApothecary
	 */
	public int getNbApothecary() {
		return nbApothecary;
	}

	/**
	 * @param nbApothecary the nbApothecary to set
	 */
	public void setNbApothecary(int nbApothecary) {
		this.nbApothecary = nbApothecary;
	}

	/**
	 * @return the nbCheerLeaders
	 */
	public int getNbCheerLeaders() {
		return nbCheerLeaders;
	}

	/**
	 * @param nbCheerLeaders the nbCheerLeaders to set
	 */
	public void setNbCheerLeaders(int nbCheerLeaders) {
		this.nbCheerLeaders = nbCheerLeaders;
	}

	/**
	 * @return the nbAssistantCoaches
	 */
	public int getNbAssistantCoaches() {
		return nbAssistantCoaches;
	}

	/**
	 * @param nbAssistantCoaches the nbAssistantCoaches to set
	 */
	public void setNbAssistantCoaches(int nbAssistantCoaches) {
		this.nbAssistantCoaches = nbAssistantCoaches;
	}

	/**
	 * @return the playerList
	 */
	public ArrayList<AbbPlayer> getPlayerList() {
		return playerList;
	}

	/**
	 * @param playerList the playerList to set
	 */
	public void setPlayerList(ArrayList<AbbPlayer> playerList) {
		this.playerList = playerList;
	}

	public boolean isValide()
	{
		// TODO
		return true;
	}
	
	public boolean updateValue()
	{
		// TODO
		return true;
	}

	public boolean addNewPlayer(AbbPlayer aPlayer)
	{
		aPlayer.setTeam(uid);
		boolean bResult = playerList.add(aPlayer);
		updateValue();
		
		return bResult;
	}
	
	public AbbTeam()
	{
		 
	}
}

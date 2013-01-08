package com.abb.model;
import java.util.ArrayList;

/**
 * 
 */

/**
 * @author wdzt6311
 *
 */
public class AbbPlayer {
	private String name = "";
	private String position = "";
	private int number = 0;
	private int price = 0;
	private int team = 0;
	private int MA, ST, AG, AV = 0;
	private int COMP, TD, INT, CAS, MVP, SPP = 0;
	private ArrayList<Skills> skills = new ArrayList<Skills>();
	private PlayerStates state = PlayerStates.Reserve;
	private Injuries injurie = Injuries.NoInjurie;
	
	/**
	 * @return the team
	 */
	public int getTeam() {
		return team;
	}

	/**
	 * @param team the team to set
	 */
	public void setTeam(int team) {
		this.team = team;
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
	 * @return the position
	 */
	public String getPosition() {
		return position;
	}

	/**
	 * @param position the position to set
	 */
	public void setPosition(String position) {
		this.position = position;
	}

	/**
	 * @return the number
	 */
	public int getNumber() {
		return number;
	}

	/**
	 * @param number the number to set
	 */
	public void setNumber(int number) {
		this.number = number;
	}

	/**
	 * @return the price
	 */
	public int getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(int price) {
		this.price = price;
	}

	/**
	 * @return the mA
	 */
	public int getMA() {
		return MA;
	}

	/**
	 * @param mA the mA to set
	 */
	public void setMA(int mA) {
		MA = mA;
	}

	/**
	 * @return the sT
	 */
	public int getST() {
		return ST;
	}

	/**
	 * @param sT the sT to set
	 */
	public void setST(int sT) {
		ST = sT;
	}

	/**
	 * @return the aG
	 */
	public int getAG() {
		return AG;
	}

	/**
	 * @param aG the aG to set
	 */
	public void setAG(int aG) {
		AG = aG;
	}

	/**
	 * @return the aV
	 */
	public int getAV() {
		return AV;
	}

	/**
	 * @param aV the aV to set
	 */
	public void setAV(int aV) {
		AV = aV;
	}

	/**
	 * @return the cOMP
	 */
	public int getCOMP() {
		return COMP;
	}

	/**
	 * @param cOMP the cOMP to set
	 */
	public void setCOMP(int cOMP) {
		COMP = cOMP;
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
	 * @return the iNT
	 */
	public int getINT() {
		return INT;
	}

	/**
	 * @param iNT the iNT to set
	 */
	public void setINT(int iNT) {
		INT = iNT;
	}

	/**
	 * @return the cAS
	 */
	public int getCAS() {
		return CAS;
	}

	/**
	 * @param cAS the cAS to set
	 */
	public void setCAS(int cAS) {
		CAS = cAS;
	}

	/**
	 * @return the mVP
	 */
	public int getMVP() {
		return MVP;
	}

	/**
	 * @param mVP the mVP to set
	 */
	public void setMVP(int mVP) {
		MVP = mVP;
	}

	/**
	 * @return the sPP
	 */
	public int getSPP() {
		return SPP;
	}

	/**
	 * @param sPP the sPP to set
	 */
	public void setSPP(int sPP) {
		SPP = sPP;
	}

	/**
	 * @return the skills
	 */
	public ArrayList<Skills> getSkills() {
		return skills;
	}

	/**
	 * @param skills the skills to set
	 */
	public void setSkills(ArrayList<Skills> skills) {
		this.skills = skills;
	}

	/**
	 * @return the state
	 */
	public PlayerStates getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(PlayerStates state) {
		this.state = state;
	}

	/**
	 * @return the injurie
	 */
	public Injuries getInjurie() {
		return injurie;
	}

	/**
	 * @param injurie the injurie to set
	 */
	public void setInjurie(Injuries injurie) {
		this.injurie = injurie;
	}

	public AbbPlayer()
	{
		
	}

	private boolean tryAgilityTest(int modifiers)
	{
		boolean res = AbbAgility.test(this.getAG(), modifiers);
		return res;
	}
	
	public boolean tryDodge(int modifiers)
	{
		boolean res = tryAgilityTest(1-modifiers);
		
		if (res==false)
		{
			this.isKnockDown();
		}
		
		return res;
	}
	
	private void isKnockDown() 
	{
		this.setState(PlayerStates.checkTable());
	}

	public boolean tryPickBall(int modifiers)
	{
		return tryAgilityTest(1+modifiers);
	}
	
	public boolean tryCatchBall(int modifiers)
	{
		return tryAgilityTest(modifiers);
	}
	
	public AbbPasses.Result tryThrowBall(AbbPasses kind, int modifiers)
	{
		AbbPasses.Result res = AbbAgility.testWithFumble(this.getAG(), modifiers);

		if (kind == AbbPasses.HailMary && res == AbbPasses.Result.Accurate)
		{
			res = AbbPasses.Result.Scattered;
		}

		return res;
	}

	public boolean tryGoForIt()
	{
		boolean res = true;
		
		if (AbbDiceEngine.launchD6() == 1)
		{
			res = false;
		}
			
		return res;
	}

	public void tryStandUp() {
		// TODO move cost = 3 or roll 4+
		System.out.print(getName()+" try to stand up ");				
		if ((getMA() >= 3) || (AbbDiceEngine.launchD6() >= 4))
		{
			this.setState(PlayerStates.Standing);
			System.out.print(" and succed.\n");
		}
		else
		{
			System.out.print(" and failed.\n");			
		}
	}

	public boolean tryInterception(int modifiers) 
	{	
		System.out.print("[ACTION] "+getName()+" try an interception ");				
		boolean res = AbbAgility.test(this.getAG(), modifiers-2);
		
		if (res == true)
		{
			this.setState(PlayerStates.Standing);
			System.out.print(" and succed.\n");
		}
		else
		{
			System.out.print(" and failed.\n");			
		}

		return res;
	}
	
	public boolean isInjuriedByFoul(int diceAndMod)
	{				
		return (diceAndMod > getAV());
	}

	public void isInjuriedByCrowd()
	{				
		System.out.println("[ACTION] "+getName()+" has been injuried by the crowd");
		setState(PlayerStates.checkTable());
	}

	public boolean isInjuriedByBlock(boolean isAttacker, BlockDice choosenDice)
	{	
		boolean res = false;
		
		switch(choosenDice)
		{
			case Skull:
				if (isAttacker)
				{
					res = true;					
				}
				break;
			case DefenderDown:
				if (!isAttacker)
				{
					res = true;					
				}
				break;
			case BothDown:
				if (!hasSkill(GeneralSkills.Block))
				{
					res = true;
				}
				break;
			case DefenderStumbles:
				if (!isAttacker && !hasSkill(AgilitySkills.Dodge))
				{
					res = true;
				}
				break;
			default:
				res = false;
		}
		
		if (res == true)
		{
			System.out.println("[ACTION] "+getName()+" has been injuried");
			setState(PlayerStates.checkTable());
		}

		return res;
	}

	public boolean hasSkill(Skills skill)
	{
		if (skills.contains(skill))
		{
			System.out.println("[DEBUG] "+getName()+" has the skill ["+skill.toString()+"]");
		}
		else
		{
			System.out.println("[DEBUG] "+getName()+" hasn't the skill ["+skill.toString()+"]");
		}

		return skills.contains(skill);
	}	
}

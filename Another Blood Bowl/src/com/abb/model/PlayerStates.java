package com.abb.model;
/**
 * 
 */

/**
 * @author wdzt6311
 *
 */
public enum PlayerStates {
	Standing,
	Prone,
	Stunned,
	KnockOut,
	Reserve,
	Casualty;

	public static PlayerStates checkTable(int diceRes) 
	{
		PlayerStates state = PlayerStates.Stunned;
		
		if (diceRes == 8 || diceRes ==9) 
		{
			state = PlayerStates.KnockOut;
		}
		else if (diceRes == 10 || diceRes == 11 || diceRes == 12)
		{
			state = PlayerStates.Casualty;
		}

		System.out.print("[INJURY] [Dice:"+diceRes+"] Player is "+state.toString()+"\n");	

		return state;
	}

	public static PlayerStates checkTable() 
	{	
		int diceRes = AbbDiceEngine.launchD6(2);
		
		return checkTable(diceRes);
	}
}

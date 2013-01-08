package com.abb.model;
/**
 * 
 */

/**
 * @author wdzt6311
 *
 */
public class AbbDiceEngine {
	
	private static int launchDice(int sides)
	{
		int result =(int)(1+sides*(Math.random()));
		return result;		
	}
	
	public static int launchD8()
	{
		return launchDice(8);
	}
	
	public static int launchD8(int nbOfDices)
	{
		int result = 0;
		for (int i=0; i<nbOfDices; i++)
		{
			result += launchD8();
		}
		return result;
	}
	
	public static int launchD6()
	{
		return launchDice(6);
	}
	
	public static int launchD6(int nbOfDices)
	{
		int result = 0;
		for (int i=0; i<nbOfDices; i++)
		{
			result += launchD6();
		}
		return result;
	}
	
	public static int launchD3()
	{
		return launchDice(6)/2;
	}
	
	public static int launchD3(int nbOfDices)
	{
		int result = 0;
		for (int i=0; i<nbOfDices; i++)
		{
			result += launchD3();
		}
		return result;
	}
	
	public static BlockDice launchBlockDice()
	{
		BlockDice result = null;
		
		switch(launchD6())
		{
		case 1 :
			result = BlockDice.Skull;
			break;
		case 2 :
			result = BlockDice.DefenderStumbles;
			break;
		case 3 :
		case 4 :
			result = BlockDice.Pushed;
			break;
		case 5 :
			result = BlockDice.DefenderDown;
			break;
		case 6 :
			result = BlockDice.BothDown;
			break;
		}
		
		System.out.println("[BLOCK DICE] "+result.toString());
		return result;
	}
}

package com.abb.model;
/**
 * 
 */

/**
 * @author wdzt6311
 *
 */
public class AbbAgility {

	static public boolean test(int agility,int modifiers)
	{
		boolean res = true;
		int diceRes = AbbDiceEngine.launchD6();
		
		System.out.print(" [AG="+agility+" Dice="+diceRes+" Mod="+modifiers+"]");	
		
		if (diceRes == 1) 
		{
			res = false;
		}
		else if (diceRes == 6)
		{
			res = true;
		}
		else 
		{
			res = checkTable(agility, diceRes + modifiers);
		}
		
		return res;
	}

	static public AbbPasses.Result testWithFumble(int agility,int modifiers)
	{
		AbbPasses.Result res = AbbPasses.Result.Accurate;
		int diceRes = AbbDiceEngine.launchD6();
		
		System.out.print(" [AG="+agility+" Dice="+diceRes+" Mod="+modifiers+"]");	
		
		if (diceRes == 1 || diceRes + modifiers <= 1) 
		{
			res = AbbPasses.Result.Fumble;
		}
		else if (diceRes == 6)
		{
			res = AbbPasses.Result.Accurate;
		}
		else 
		{
			if(checkTable(agility, diceRes + modifiers) == false)
			{
				res = AbbPasses.Result.Scattered;
			}
		}
		
		return res;
	}

	static private boolean checkTable(int agility, int diceResModified)
	{
		boolean res = false;
		
		switch(agility)
		{
		case 1:
			if (diceResModified>=6) res = true;
			break;
		case 2:
			if (diceResModified>=5) res = true;
			break;
		case 3:
			if (diceResModified>=4) res = true;
			break;
		case 4:
			if (diceResModified>=3) res = true;
			break;
		case 5:
			if (diceResModified>=2) res = true;
			break;
		case 6:
		default:
			if (diceResModified>=1) res = true;
			break;			
		}
		return res;
	}
}

package com.abb.model;
/**
 * 
 */

/**
 * @author wdzt6311
 *
 */
public enum AbbCoinTosse {
	Orcs,
	Eagles;

	public static boolean betOnSide(AbbCoinTosse side) {
		int diceRes = AbbDiceEngine.launchD6();
		AbbCoinTosse tosseRes = AbbCoinTosse.Orcs;
		
		if (diceRes%2 == 0)
		{
			tosseRes = AbbCoinTosse.Eagles;
		}
		
		boolean res = (side == tosseRes);
		
		System.out.print("[SETUP] Coin Tosse - Home team bet on "+side.toString()+" [Tosse: "+tosseRes.toString()+"]");	
		if (res)
		{
			System.out.print(" and wins the tosse.\n");			
		}
		else
		{
			System.out.print(" and loses the tosse.\n");			
		}
		
		return res; 
	}
}

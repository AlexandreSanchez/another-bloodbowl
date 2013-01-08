package com.abb.model;
/**
 * 
 */

/**
 * @author wdzt6311
 *
 */
public enum AbbKickOff {
	GetTheRef,
	Riot,
	PerfectDefence,
	HighKick,
	CheeringFans,
	ChangingWeather,
	BrilliantCoaching,
	QuickSnap,
	Blitz,
	ThrowARock,
	PitchInvasion;
	
	public static AbbKickOff checkTable() {
		AbbKickOff kickoff = AbbKickOff.GetTheRef;
		
		int diceRes = AbbDiceEngine.launchD6(2);
		
		switch (diceRes)
		{
			case 2:
				kickoff = AbbKickOff.GetTheRef;
				break;
			case 3:
				kickoff = AbbKickOff.Riot;
				break;
			case 4:
				kickoff = AbbKickOff.PerfectDefence;
				break;
			case 5:
				kickoff = AbbKickOff.HighKick;
				break;
			case 6:
				kickoff = AbbKickOff.CheeringFans;
				break;
			case 7:
				kickoff = AbbKickOff.ChangingWeather;
				break;
			case 8:
				kickoff = AbbKickOff.BrilliantCoaching;
				break;
			case 9:
				kickoff = AbbKickOff.QuickSnap;
				break;
			case 10:
				kickoff = AbbKickOff.Blitz;
				break;
			case 11:
				kickoff = AbbKickOff.ThrowARock;
				break;
			case 12:
			default:
				kickoff = AbbKickOff.PitchInvasion;
				break;
		}
		
		System.out.println("[SETUP] Kick-Off table [Dice:"+diceRes+"] : Result is "+kickoff.toString());	

		return kickoff;
	}	
}

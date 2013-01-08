package com.abb.model;
import java.util.Dictionary;

/**
 * 
 */

/**
 * @author wdzt6311
 *
 */
public class AbbMatch extends AbbAbstractModel
{
	private AbbMatchTeam teamHome, teamAway;
	private AbbMatchTeam kickingTeam, receivingTeam;
	private AbbField field = new AbbField();
	private AbbWeather weather = AbbWeather.Nice;
	private int halftime = 0;
	
	/**
	 * @return the field
	 */
	public AbbField getField() {
		return field;
	}

	/**
	 * @param field the field to set
	 */
	public void setField(AbbField field) {
		this.field = field;
	}

	/**
	 * @return the weather
	 */
	public AbbWeather getWeather() {
		return weather;
	}


	/**
	 * @param weather the weather to set
	 */
	public void setWeather(AbbWeather weather) {
		this.weather = weather;
	}


	/**
	 * @return the halftime
	 */
	public int getHalftime() {
		return halftime;
	}


	/**
	 * @param halftime the halftime to set
	 */
	public void setHalftime(int halftime) {
		this.halftime = halftime;
	}
	
	/**
	 * @return the teamHome
	 */
	public AbbMatchTeam getTeamHome() {
		return teamHome;
	}

	/**
	 * @param teamHome the teamHome to set
	 */
	public void setTeamHome(AbbMatchTeam teamHome) {
		this.teamHome = teamHome;
	}

	/**
	 * @return the teamAway
	 */
	public AbbMatchTeam getTeamAway() {
		return teamAway;
	}

	/**
	 * @param teamAway the teamAway to set
	 */
	public void setTeamAway(AbbMatchTeam teamAway) {
		this.teamAway = teamAway;
	}

	/**
	 * @return the kickingTeam
	 */
	public AbbMatchTeam getKickingTeam() {
		return kickingTeam;
	}

	/**
	 * @param kickingTeam the kickingTeam to set
	 */
	public void setKickingTeam(AbbMatchTeam kickingTeam) {
		this.kickingTeam = kickingTeam;
	}

	/**
	 * @return the receivingTeam
	 */
	public AbbMatchTeam getReceivingTeam() {
		return receivingTeam;
	}

	/**
	 * @param receivingTeam the receivingTeam to set
	 */
	public void setReceivingTeam(AbbMatchTeam receivingTeam) {
		this.receivingTeam = receivingTeam;
	}

	public AbbTeam loadTeam1() 
	{
		AbbTeam t = new AbbTeam();
		t.setName("Toronto Killers");
		t.setRace(Races.Orc);
		t.setUid(1);
		t.setTreasury(1000000);
		t.setNbFanFactor(5);
			
		for (int i=1; i<15; i++)
		{
			AbbPlayer p = new AbbPlayer();
			p.setName("Player " + i);
			p.setPosition("Blitzer");
			p.setNumber(i);
			p.setMA(7);
			p.setST(3);
			p.setAG(3);
			p.setAV(7);
			p.getSkills().add(GeneralSkills.Block);
			t.addNewPlayer(p);			
		}
		
		return t;		
	}
	public AbbTeam loadTeam2() 
	{
		AbbTeam t = new AbbTeam();
		t.setName("Shaki Rats");
		t.setRace(Races.Skaven);
		t.setUid(2);
		t.setTreasury(1000000);
		t.setNbFanFactor(1);
			
		for (int i=1; i<15; i++)
		{
			AbbPlayer p = new AbbPlayer();
			p.setName("Player " + i);
			p.setPosition("Lineman");
			p.setNumber(i);
			p.setMA(7);
			p.setST(3);
			p.setAG(3);
			p.setAV(7);
			p.getSkills().add(AgilitySkills.Dodge);
			t.addNewPlayer(p);			
		}
		
		return t;		
	}
		
	private void changeWeather()
	{
		AbbWeather weather = AbbWeather.checkTable();
		setWeather(weather);

		// TODO : weather consequences
		switch(weather)
		{
		case SwelteringHeat:
			//TODO : implement
			break;
		case VerySunny:
			//TODO : implement
			break;
		case Nice:
			//TODO : implement
			break;
		case PouringRain:
			//TODO : implement
			break;
		case Blizzard:
			//TODO : implement
			break;
		}
	}
	
	private void resolveKickOffEvent()
	{
		AbbKickOff event = AbbKickOff.checkTable();
		
		switch(event)
		{
		case GetTheRef:
			//TODO : implement
			break;
		case Riot:
			//TODO : implement
			break;
		case PerfectDefence:
			//TODO : implement
			break;
		case HighKick:
			//TODO : implement
			break;
		case CheeringFans:
			//TODO : implement
			break;
		case ChangingWeather:
			changeWeather();
			break;
		case BrilliantCoaching:
			//TODO : implement
			break;
		case QuickSnap:
			//TODO : implement
			break;
		case Blitz:
			//TODO : implement
			break;
		case ThrowARock:
			//TODO : implement
			break;
		case PitchInvasion:
			//TODO : implement
			break;
		}
	}

	public void preMatchSequence()
	{
		// PRE-MATCH : Weather
		changeWeather();
		
		// TODO : Leagues only - Petty Cash (Porte-monnaie)
		// TODO : Leagues only - Inducements (Primes)
		
		// PRE-MATCH : Determine FAME of teams
		teamHome.calculateFAME(teamAway.getFans());
		teamAway.calculateFAME(teamHome.getFans());
		
		// PRE-MATCH : Coin Tosse
		// TODO : Team 1 must choose coin face
		AbbCoinTosse face = AbbCoinTosse.Orcs;
		
		if (AbbCoinTosse.betOnSide(face))
		{
			kickingTeam = teamHome;
			receivingTeam = teamAway;
		}
		else
		{
			kickingTeam = teamAway;
			receivingTeam = teamHome;
		}
	}
	
	public void setupNewHalfTime()
	{
		halftime++;
		// TODO : IF HALF-TIME : RAZ rerolls
		// TODO : IF HALF-TIME : RAZ turns

		setupNewKickOff();

		// TODO : IF HALF-TIME : Machines ?
	}

	public void setupNewKickOff()
	{
		// SETUP : Get KOs back
		teamHome.getKosBack();
		teamAway.getKosBack();
	}

	public AbbMatch()
	{
		AbbTeam team1 = loadTeam1();
		AbbTeam team2 = loadTeam2();
		teamHome = new AbbMatchTeam(team1, FieldZones.MainZoneLeft);
		teamAway = new AbbMatchTeam(team2, FieldZones.MainZoneRight);

		//////////////////////////////////////////////////////
		// PRE-MATCH SEQUENCE
		//////////////////////////////////////////////////////
		preMatchSequence();
		
		//////////////////////////////////////////////////////
		// SETUP SEQUENCE
		//////////////////////////////////////////////////////
		setupNewHalfTime();
			
		// TODO : Place the player of Kicking Team (win TOSSE)
		getField().placePlayer(team1.getPlayerList().get(1), 6, 4);
		getField().placePlayer(team1.getPlayerList().get(2), 5, 4);
		getField().placePlayer(team1.getPlayerList().get(3), 5, 5);
		getField().placePlayer(team1.getPlayerList().get(4), 5, 6);
		getField().placePlayer(team1.getPlayerList().get(5), 6, 6);

		// TODO : Place the player of Receiving Team (lose TOSSE)
		getField().placePlayer(team2.getPlayerList().get(11), 6, 5);

		// SETUP : Kicking Team place the ball on the pitch for kick-off
		// TODO : User interaction
		int x=20;
		int y=10;
		
		// SETUP : Kick-Off event
		resolveKickOffEvent();
		
		// SETUP : Kick-Off
		getField().placeBallKickOff(x, y, kickingTeam.getSide());
		
		//getField().movePlayer(5, 5, 6, 5);
		
		//////////////////////////////////////////////////////
		// MATCH SEQUENCE
		//////////////////////////////////////////////////////
		// TODO : PLAY the GAME
		// TODO : T1 Receiving Team
		// TODO : T1 Kicking Team
		
		//////////////////////////////////////////////////////
		// POST-MATCH SEQUENCE
		//////////////////////////////////////////////////////
		// TODO : END MATCH = Increase XP Players
		// TODO : END MATCH = Update Teams		
	}
}

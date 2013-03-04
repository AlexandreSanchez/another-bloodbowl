package com.abb.model;
import java.awt.List;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map.Entry;

/**
 * 
 */

/**
 * @author wdzt6311
 *
 */
public class AbbSquare extends AbbAbstractModel
{
	private FieldZones zoneType;
	private AbbPlayer player;
	private boolean ballPresent = false;
	private HashMap<FieldZones.Directions, AbbSquare> tackleZone = new HashMap<FieldZones.Directions, AbbSquare>(); 

	public void addTackleZone(FieldZones.Directions dir, AbbSquare square) {
		tackleZone.put(dir, square);
	}

	public AbbSquare getTackleZone(FieldZones.Directions dir) {
		return tackleZone.get(dir);
	}

	public int getAssistsAgainstFrom(AbbSquare square) {
		int res = 0;
		if (player != null)
		{

			for(Entry<FieldZones.Directions, AbbSquare> entry : tackleZone.entrySet())
			{
				AbbSquare valeur = entry.getValue();		    	
				if (valeur != null)
				{
					if (valeur.isPlayerStanding() && valeur != square)
					{
						if (valeur.getPlayer().getTeam() != player.getTeam()
						&&  valeur.getTackleZones(player.getTeam()) <= 1)
						{
							res++;
						}
					}
				}
		    }   		
		}
		return res;
	}
	
	public int getTackleZones(int team) {
		int nbTz = 0;
		for(Entry<FieldZones.Directions, AbbSquare> entry : tackleZone.entrySet())
		{
			AbbSquare valeur = entry.getValue();		    	
			if (valeur != null)
			{
				if (valeur.isPlayerStanding())
				{
					if (valeur.getPlayer().getTeam() == team) nbTz++;
		    	}
			}
	    }   		
		return nbTz;
	}

	public int getTackleZonesAgainstPlayer() {
		int nbTz = 0;
		if (player != null)
		{
			for(Entry<FieldZones.Directions, AbbSquare> entry : tackleZone.entrySet())
			{
				AbbSquare valeur = entry.getValue();		    	
				if (valeur != null)
				{
					if (valeur.isPlayerStanding())
					{
						if (valeur.getPlayer().getTeam() != player.getTeam()) nbTz++;
			    	}
				}
		    }   		
		}
		return nbTz;
	}
	
	public FieldZones getZoneType() {
		return zoneType;
	}

	public void setZoneType(FieldZones zoneType) {
		this.zoneType = zoneType;
	}

	public AbbPlayer getPlayer() {
		return player;
	}

	public void setPlayer(AbbPlayer player) {
		this.player = player;
	}

	public void removePlayer() {
		this.player = null;
	}

	public boolean isBallPresent() {
		return ballPresent;
	}

	public boolean isPlayerAvailable() 
	{
		boolean res = false;
		
		if (player != null)
		{
			if (player.getState() == PlayerStates.Standing
			|| player.getState() == PlayerStates.Prone
			|| player.getState() == PlayerStates.Stunned)
			{
				res = true;
			}
		}
		
		return res;
	}

	public boolean canPlayerIntercept(int passTeam) 
	{
		boolean res = false;
		
		if (isPlayerStanding())
		{
			if (player.getTeam() != passTeam)
			{
				res = true;
			}
		}
		
		return res;
	}

	public boolean isPlayerStanding() 
	{
		boolean res = false;
		
		if (player != null)
		{
			if (player.getState() == PlayerStates.Standing)
			{
				res = true;
			}
		}
		
		return res;
	}

	public AbbPasses.Result playerThrowTheBall(AbbPasses kind) 
	{
		AbbPasses.Result res = AbbPasses.Result.Scattered;
		
		if (isPlayerStanding() && isBallPresent())
		{
			System.out.print("[ACTION] "+player.getName()+" try to throw the ball");			

			int modifiers = AbbPasses.getModificator(kind);
			modifiers -= getTackleZonesAgainstPlayer();
			res = player.tryThrowBall(kind, modifiers);
						
			if (res == AbbPasses.Result.Accurate)
			{
				System.out.print(" and succed.\n");							
			}
			else if (res == AbbPasses.Result.Scattered)
			{
				System.out.print(" and failed.\n");							
			}
			else
			{
				System.out.print(" and has fumbled and dropped the ball.\n");							
			}
		}
		else
		{
			System.out.println("[DEBUG] No pass is possible from this square.");
		}

		return res;
	}
	
	public boolean playerCatchTheBall(boolean fromPerfectPass) 
	{
		boolean res = false;
		
		if (isPlayerStanding())
		{
			System.out.print("[ACTION] "+player.getName()+" try to catch the ball");			
			int modifiers = 0;
			if (fromPerfectPass) modifiers = 1;
			modifiers -= getTackleZonesAgainstPlayer();
			res = player.tryCatchBall(modifiers);
			if (res)
			{
				System.out.print(" and succed.\n");							
			}
			else
			{
				System.out.print(" and failed.\n");							
			}
		}
		
		return res;
	}
	
	public void setBallPresent(boolean ball) {
		this.ballPresent = ball;
	}
	
	public AbbSquare ballEnters(boolean fromPerfectPass) {
		AbbSquare square = this;
		
		if (playerCatchTheBall(fromPerfectPass) || player == null)
		{
			setBallPresent(true);			
		}
		else
		{
			square = ballBounces();
		}
		
		return square;
	}

	public AbbSquare ballBounces() {
		FieldZones.Directions direction = FieldZones.Directions.getDirections(AbbDiceEngine.launchD8());
		
		System.out.println("[BOUNCE] Ball bounces in direction "+direction);
		setBallPresent(false);
		
		AbbSquare square = tackleZone.get(direction);
		if (square != null)
		{
			square = tackleZone.get(direction).ballEnters(false);
		}
		else
		{
			crowdThrowBackBall();
		}
			
		return square;
	}

	public AbbSquare()
	{
		this.setZoneType(FieldZones.NotSetted);
		this.setBallPresent(false);
	}

	public boolean resolveDodges() 
	{
		boolean res = true;
		int nbDoges = getTackleZonesAgainstPlayer();
		
		if (nbDoges > 0)
		{
			res = player.tryDodge(nbDoges);
		}
		
		return res;
	}

	public boolean playerInterception() 
	{
		int modifiers = 0;
		boolean res = false;
		
		modifiers -= getTackleZonesAgainstPlayer();
		res = player.tryInterception(modifiers);	
		setBallPresent(res);
	
		return res;
	}
	
	public boolean resolveInjury(boolean isAttacker, BlockDice choosenDice) 
	{
		boolean res = getPlayer().isInjuriedByBlock(isAttacker, choosenDice);
		
		if (res == true && isBallPresent())
		{
			System.out.println("[BLOCK] "+getPlayer().getName()+" drops the ball");

			AbbSquare square = ballBounces();
		}
		
		return res;
	}
	
	public FieldZones.Directions getDirection(AbbSquare square)
	{
		FieldZones.Directions dir = FieldZones.Directions.N;
		
		for(Entry<FieldZones.Directions, AbbSquare> entry : tackleZone.entrySet())
		{
			AbbSquare valeur = entry.getValue();	
			FieldZones.Directions key = entry.getKey();
			
			if (valeur == square)
			{
				dir = key;
			}
		}

		return dir;
	}
	
	public AbbSquare followPlayer(AbbSquare destination)
	{
		// TODO : Attacker must choose if he follows
		System.out.println("[ACTION] "+getPlayer().getName()+" follows the block");

		destination.setPlayer(getPlayer());
		removePlayer();
		destination.setBallPresent(isBallPresent());			
		setBallPresent(false);
		
		return destination;
	}

	public boolean isPushPossible(AbbSquare square)
	{
		boolean res = false;
		
		if (square != null)
		{
			if (square.isPlayerAvailable() == false)
			{
				res = true;
			}
		}
		
		return res;
	}
	
	public AbbSquare pushPlayer(AbbSquare origin)
	{
		AbbSquare square = this;
		boolean pushOutOfThePitch = false;
		
		FieldZones.Directions[] dirs = FieldZones.Directions.getPushDirections(getDirection(origin));
		
		ArrayList<AbbSquare> pushZones = new ArrayList<AbbSquare>();

		// Find first the free push zones
		for (int i=0; i<3; i++)
		{
			if (isPushPossible(getTackleZone(dirs[i])))
			{
				pushZones.add(getTackleZone(dirs[i]));
				//System.out.println("[DEBUG] Push possible in empty zone "+dirs[i]);
			}			
		}
		
		if (pushZones.isEmpty())
		{
			// If not find push zones in the pitch
			for (int i=0; i<3; i++)
			{
				if (getTackleZone(dirs[i]) != null)
				{
					pushZones.add(getTackleZone(dirs[i]));
					//System.out.println("[DEBUG] Push possible in non empty zone "+dirs[i]);
				}			
			}

			if (pushZones.size() < 3)
			{
				pushOutOfThePitch = true;
			}
		}
		
		if (pushOutOfThePitch)
		{
			System.out.println("[ACTION] "+origin.getPlayer().getName()+" push "+getPlayer().getName()+" out of the pitch");
			getPlayer().isInjuriedByCrowd();
			removePlayer();
			crowdThrowBackBall();
		}
		else
		{
			// TODO : Attacker must choose the push zone
			System.out.println("[ACTION] "+origin.getPlayer().getName()+" push "+getPlayer().getName()+" in direction "+dirs[0]);				
			square = pushZones.get(0);
			square.playerEnters(this);
		}
				
		return square;
	}
	
	public void crowdThrowBackBall()
	{
		// TODO : OUT OF THE PITCH
		int direction = AbbDiceEngine.launchD6();
		int distance = AbbDiceEngine.launchD6(2);
		setBallPresent(false);
	}

	public void playerEnters(AbbSquare origin)
	{
		if (isPlayerAvailable())
		{
			pushPlayer(origin);
		}
		
		setPlayer(origin.getPlayer());
		origin.removePlayer();	
		
		if (isBallPresent())
		{
			ballBounces();
		}
		else
		{
			setBallPresent(origin.isBallPresent());			
			origin.setBallPresent(false);
		}
	}			
}

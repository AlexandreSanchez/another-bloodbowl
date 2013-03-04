package com.abb.model;
import java.util.ArrayList;

/**
 * 
 */

/**
 * @author wdzt6311
 *
 */
public class AbbField extends AbbAbstractModel
{
	private int LENGHT = 26;
	private int HEIGHT = 15;
	private int MINLENGHT = 0;
	private int MINHEIGHT = 0;
	private int MAXLENGHT = LENGHT-1;
	private int MAXHEIGHT = HEIGHT-1;
	private AbbSquare[][] field;

	private FieldZones[][] zoneDefs =
	{ 
	{FieldZones.EndZoneLeft,FieldZones.WideZoneLeftUp,FieldZones.WideZoneLeftUp,FieldZones.WideZoneLeftUp,FieldZones.WideZoneLeftUp,FieldZones.WideZoneLeftUp,FieldZones.WideZoneLeftUp,FieldZones.WideZoneLeftUp,FieldZones.WideZoneLeftUp,FieldZones.WideZoneLeftUp,FieldZones.WideZoneLeftUp,FieldZones.WideZoneLeftUp,FieldZones.WideZoneLeftUp,FieldZones.WideZoneRightUp,FieldZones.WideZoneRightUp,FieldZones.WideZoneRightUp,FieldZones.WideZoneRightUp,FieldZones.WideZoneRightUp,FieldZones.WideZoneRightUp,FieldZones.WideZoneRightUp,FieldZones.WideZoneRightUp,FieldZones.WideZoneRightUp,FieldZones.WideZoneRightUp,FieldZones.WideZoneRightUp,FieldZones.WideZoneRightUp,FieldZones.EndZoneLeft},
	{FieldZones.EndZoneLeft,FieldZones.WideZoneLeftUp,FieldZones.WideZoneLeftUp,FieldZones.WideZoneLeftUp,FieldZones.WideZoneLeftUp,FieldZones.WideZoneLeftUp,FieldZones.WideZoneLeftUp,FieldZones.WideZoneLeftUp,FieldZones.WideZoneLeftUp,FieldZones.WideZoneLeftUp,FieldZones.WideZoneLeftUp,FieldZones.WideZoneLeftUp,FieldZones.WideZoneLeftUp,FieldZones.WideZoneRightUp,FieldZones.WideZoneRightUp,FieldZones.WideZoneRightUp,FieldZones.WideZoneRightUp,FieldZones.WideZoneRightUp,FieldZones.WideZoneRightUp,FieldZones.WideZoneRightUp,FieldZones.WideZoneRightUp,FieldZones.WideZoneRightUp,FieldZones.WideZoneRightUp,FieldZones.WideZoneRightUp,FieldZones.WideZoneRightUp,FieldZones.EndZoneLeft},
	{FieldZones.EndZoneLeft,FieldZones.WideZoneLeftUp,FieldZones.WideZoneLeftUp,FieldZones.WideZoneLeftUp,FieldZones.WideZoneLeftUp,FieldZones.WideZoneLeftUp,FieldZones.WideZoneLeftUp,FieldZones.WideZoneLeftUp,FieldZones.WideZoneLeftUp,FieldZones.WideZoneLeftUp,FieldZones.WideZoneLeftUp,FieldZones.WideZoneLeftUp,FieldZones.WideZoneLeftUp,FieldZones.WideZoneRightUp,FieldZones.WideZoneRightUp,FieldZones.WideZoneRightUp,FieldZones.WideZoneRightUp,FieldZones.WideZoneRightUp,FieldZones.WideZoneRightUp,FieldZones.WideZoneRightUp,FieldZones.WideZoneRightUp,FieldZones.WideZoneRightUp,FieldZones.WideZoneRightUp,FieldZones.WideZoneRightUp,FieldZones.WideZoneRightUp,FieldZones.EndZoneLeft},
	{FieldZones.EndZoneLeft,FieldZones.WideZoneLeftUp,FieldZones.WideZoneLeftUp,FieldZones.WideZoneLeftUp,FieldZones.WideZoneLeftUp,FieldZones.WideZoneLeftUp,FieldZones.WideZoneLeftUp,FieldZones.WideZoneLeftUp,FieldZones.WideZoneLeftUp,FieldZones.WideZoneLeftUp,FieldZones.WideZoneLeftUp,FieldZones.WideZoneLeftUp,FieldZones.WideZoneLeftUp,FieldZones.WideZoneRightUp,FieldZones.WideZoneRightUp,FieldZones.WideZoneRightUp,FieldZones.WideZoneRightUp,FieldZones.WideZoneRightUp,FieldZones.WideZoneRightUp,FieldZones.WideZoneRightUp,FieldZones.WideZoneRightUp,FieldZones.WideZoneRightUp,FieldZones.WideZoneRightUp,FieldZones.WideZoneRightUp,FieldZones.WideZoneRightUp,FieldZones.EndZoneLeft},
	{FieldZones.EndZoneLeft,FieldZones.MainZoneLeft,FieldZones.MainZoneLeft,FieldZones.MainZoneLeft,FieldZones.MainZoneLeft,FieldZones.MainZoneLeft,FieldZones.MainZoneLeft,FieldZones.MainZoneLeft,FieldZones.MainZoneLeft,FieldZones.MainZoneLeft,FieldZones.MainZoneLeft,FieldZones.MainZoneLeft,FieldZones.ScrimmageLeft,FieldZones.ScrimmageRight,FieldZones.MainZoneRight,FieldZones.MainZoneRight,FieldZones.MainZoneRight,FieldZones.MainZoneRight,FieldZones.MainZoneRight,FieldZones.MainZoneRight,FieldZones.MainZoneRight,FieldZones.MainZoneRight,FieldZones.MainZoneRight,FieldZones.MainZoneRight,FieldZones.MainZoneRight,FieldZones.EndZoneLeft},
	{FieldZones.EndZoneLeft,FieldZones.MainZoneLeft,FieldZones.MainZoneLeft,FieldZones.MainZoneLeft,FieldZones.MainZoneLeft,FieldZones.MainZoneLeft,FieldZones.MainZoneLeft,FieldZones.MainZoneLeft,FieldZones.MainZoneLeft,FieldZones.MainZoneLeft,FieldZones.MainZoneLeft,FieldZones.MainZoneLeft,FieldZones.ScrimmageLeft,FieldZones.ScrimmageRight,FieldZones.MainZoneRight,FieldZones.MainZoneRight,FieldZones.MainZoneRight,FieldZones.MainZoneRight,FieldZones.MainZoneRight,FieldZones.MainZoneRight,FieldZones.MainZoneRight,FieldZones.MainZoneRight,FieldZones.MainZoneRight,FieldZones.MainZoneRight,FieldZones.MainZoneRight,FieldZones.EndZoneLeft},
	{FieldZones.EndZoneLeft,FieldZones.MainZoneLeft,FieldZones.MainZoneLeft,FieldZones.MainZoneLeft,FieldZones.MainZoneLeft,FieldZones.MainZoneLeft,FieldZones.MainZoneLeft,FieldZones.MainZoneLeft,FieldZones.MainZoneLeft,FieldZones.MainZoneLeft,FieldZones.MainZoneLeft,FieldZones.MainZoneLeft,FieldZones.ScrimmageLeft,FieldZones.ScrimmageRight,FieldZones.MainZoneRight,FieldZones.MainZoneRight,FieldZones.MainZoneRight,FieldZones.MainZoneRight,FieldZones.MainZoneRight,FieldZones.MainZoneRight,FieldZones.MainZoneRight,FieldZones.MainZoneRight,FieldZones.MainZoneRight,FieldZones.MainZoneRight,FieldZones.MainZoneRight,FieldZones.EndZoneLeft},
	{FieldZones.EndZoneLeft,FieldZones.MainZoneLeft,FieldZones.MainZoneLeft,FieldZones.MainZoneLeft,FieldZones.MainZoneLeft,FieldZones.MainZoneLeft,FieldZones.MainZoneLeft,FieldZones.MainZoneLeft,FieldZones.MainZoneLeft,FieldZones.MainZoneLeft,FieldZones.MainZoneLeft,FieldZones.MainZoneLeft,FieldZones.ScrimmageLeft,FieldZones.ScrimmageRight,FieldZones.MainZoneRight,FieldZones.MainZoneRight,FieldZones.MainZoneRight,FieldZones.MainZoneRight,FieldZones.MainZoneRight,FieldZones.MainZoneRight,FieldZones.MainZoneRight,FieldZones.MainZoneRight,FieldZones.MainZoneRight,FieldZones.MainZoneRight,FieldZones.MainZoneRight,FieldZones.EndZoneLeft},
	{FieldZones.EndZoneLeft,FieldZones.MainZoneLeft,FieldZones.MainZoneLeft,FieldZones.MainZoneLeft,FieldZones.MainZoneLeft,FieldZones.MainZoneLeft,FieldZones.MainZoneLeft,FieldZones.MainZoneLeft,FieldZones.MainZoneLeft,FieldZones.MainZoneLeft,FieldZones.MainZoneLeft,FieldZones.MainZoneLeft,FieldZones.ScrimmageLeft,FieldZones.ScrimmageRight,FieldZones.MainZoneRight,FieldZones.MainZoneRight,FieldZones.MainZoneRight,FieldZones.MainZoneRight,FieldZones.MainZoneRight,FieldZones.MainZoneRight,FieldZones.MainZoneRight,FieldZones.MainZoneRight,FieldZones.MainZoneRight,FieldZones.MainZoneRight,FieldZones.MainZoneRight,FieldZones.EndZoneLeft},
	{FieldZones.EndZoneLeft,FieldZones.MainZoneLeft,FieldZones.MainZoneLeft,FieldZones.MainZoneLeft,FieldZones.MainZoneLeft,FieldZones.MainZoneLeft,FieldZones.MainZoneLeft,FieldZones.MainZoneLeft,FieldZones.MainZoneLeft,FieldZones.MainZoneLeft,FieldZones.MainZoneLeft,FieldZones.MainZoneLeft,FieldZones.ScrimmageLeft,FieldZones.ScrimmageRight,FieldZones.MainZoneRight,FieldZones.MainZoneRight,FieldZones.MainZoneRight,FieldZones.MainZoneRight,FieldZones.MainZoneRight,FieldZones.MainZoneRight,FieldZones.MainZoneRight,FieldZones.MainZoneRight,FieldZones.MainZoneRight,FieldZones.MainZoneRight,FieldZones.MainZoneRight,FieldZones.EndZoneLeft},
	{FieldZones.EndZoneLeft,FieldZones.MainZoneLeft,FieldZones.MainZoneLeft,FieldZones.MainZoneLeft,FieldZones.MainZoneLeft,FieldZones.MainZoneLeft,FieldZones.MainZoneLeft,FieldZones.MainZoneLeft,FieldZones.MainZoneLeft,FieldZones.MainZoneLeft,FieldZones.MainZoneLeft,FieldZones.MainZoneLeft,FieldZones.ScrimmageLeft,FieldZones.ScrimmageRight,FieldZones.MainZoneRight,FieldZones.MainZoneRight,FieldZones.MainZoneRight,FieldZones.MainZoneRight,FieldZones.MainZoneRight,FieldZones.MainZoneRight,FieldZones.MainZoneRight,FieldZones.MainZoneRight,FieldZones.MainZoneRight,FieldZones.MainZoneRight,FieldZones.MainZoneRight,FieldZones.EndZoneLeft},
	{FieldZones.EndZoneLeft,FieldZones.WideZoneLeftDown,FieldZones.WideZoneLeftDown,FieldZones.WideZoneLeftDown,FieldZones.WideZoneLeftDown,FieldZones.WideZoneLeftDown,FieldZones.WideZoneLeftDown,FieldZones.WideZoneLeftDown,FieldZones.WideZoneLeftDown,FieldZones.WideZoneLeftDown,FieldZones.WideZoneLeftDown,FieldZones.WideZoneLeftDown,FieldZones.WideZoneLeftDown,FieldZones.WideZoneRightDown,FieldZones.WideZoneRightDown,FieldZones.WideZoneRightDown,FieldZones.WideZoneRightDown,FieldZones.WideZoneRightDown,FieldZones.WideZoneRightDown,FieldZones.WideZoneRightDown,FieldZones.WideZoneRightDown,FieldZones.WideZoneRightDown,FieldZones.WideZoneRightDown,FieldZones.WideZoneRightDown,FieldZones.WideZoneRightDown,FieldZones.EndZoneLeft},
	{FieldZones.EndZoneLeft,FieldZones.WideZoneLeftDown,FieldZones.WideZoneLeftDown,FieldZones.WideZoneLeftDown,FieldZones.WideZoneLeftDown,FieldZones.WideZoneLeftDown,FieldZones.WideZoneLeftDown,FieldZones.WideZoneLeftDown,FieldZones.WideZoneLeftDown,FieldZones.WideZoneLeftDown,FieldZones.WideZoneLeftDown,FieldZones.WideZoneLeftDown,FieldZones.WideZoneLeftDown,FieldZones.WideZoneRightDown,FieldZones.WideZoneRightDown,FieldZones.WideZoneRightDown,FieldZones.WideZoneRightDown,FieldZones.WideZoneRightDown,FieldZones.WideZoneRightDown,FieldZones.WideZoneRightDown,FieldZones.WideZoneRightDown,FieldZones.WideZoneRightDown,FieldZones.WideZoneRightDown,FieldZones.WideZoneRightDown,FieldZones.WideZoneRightDown,FieldZones.EndZoneLeft},
	{FieldZones.EndZoneLeft,FieldZones.WideZoneLeftDown,FieldZones.WideZoneLeftDown,FieldZones.WideZoneLeftDown,FieldZones.WideZoneLeftDown,FieldZones.WideZoneLeftDown,FieldZones.WideZoneLeftDown,FieldZones.WideZoneLeftDown,FieldZones.WideZoneLeftDown,FieldZones.WideZoneLeftDown,FieldZones.WideZoneLeftDown,FieldZones.WideZoneLeftDown,FieldZones.WideZoneLeftDown,FieldZones.WideZoneRightDown,FieldZones.WideZoneRightDown,FieldZones.WideZoneRightDown,FieldZones.WideZoneRightDown,FieldZones.WideZoneRightDown,FieldZones.WideZoneRightDown,FieldZones.WideZoneRightDown,FieldZones.WideZoneRightDown,FieldZones.WideZoneRightDown,FieldZones.WideZoneRightDown,FieldZones.WideZoneRightDown,FieldZones.WideZoneRightDown,FieldZones.EndZoneLeft},
	{FieldZones.EndZoneLeft,FieldZones.WideZoneLeftDown,FieldZones.WideZoneLeftDown,FieldZones.WideZoneLeftDown,FieldZones.WideZoneLeftDown,FieldZones.WideZoneLeftDown,FieldZones.WideZoneLeftDown,FieldZones.WideZoneLeftDown,FieldZones.WideZoneLeftDown,FieldZones.WideZoneLeftDown,FieldZones.WideZoneLeftDown,FieldZones.WideZoneLeftDown,FieldZones.WideZoneLeftDown,FieldZones.WideZoneRightDown,FieldZones.WideZoneRightDown,FieldZones.WideZoneRightDown,FieldZones.WideZoneRightDown,FieldZones.WideZoneRightDown,FieldZones.WideZoneRightDown,FieldZones.WideZoneRightDown,FieldZones.WideZoneRightDown,FieldZones.WideZoneRightDown,FieldZones.WideZoneRightDown,FieldZones.WideZoneRightDown,FieldZones.WideZoneRightDown,FieldZones.EndZoneLeft},
	};
	
	public AbbSquare[][] getField() {
		return field;
	}

	public void setField(AbbSquare[][] field) {
		this.field = field;
	}
	
	public boolean isValideLenght(int x)
	{
		return (x>=MINLENGHT && x<=MAXLENGHT);
	}

	public boolean isValideHeight(int y)
	{
		return (y>=MINHEIGHT && y<=MAXHEIGHT);
	}

	public boolean areValideCoords(int x, int y)
	{
		return (isValideLenght(x) && isValideHeight(y));
	}
	
	public AbbSquare getSquare(int x, int y)
	{
		AbbSquare square = null;
		
		if (areValideCoords(x, y))
		{
			square = field[y][x];
		}
		
		return square;
	}

	public void placePlayer(AbbPlayer aPlayer, int x, int y)
	{
		aPlayer.setState(PlayerStates.Standing);
		field[y][x].setPlayer(aPlayer);
	}

	public boolean movePlayer(int x1, int y1, int x2, int y2)
	{
		return movePlayer(getSquare(x1, y1), FieldZones.Directions.getMoveDirection(x1, y1, x2, y2));
	}

	public boolean movePlayer(int x1, int y1, FieldZones.Directions direction)
	{
		return movePlayer(getSquare(x1, y1), direction);
	}
	
	public boolean movePlayer(AbbSquare origin, FieldZones.Directions direction)
	{
		return movePlayer(origin, origin.getTackleZone(direction));
	}
	
	public boolean movePlayer(AbbSquare origin, AbbSquare destination)
	{
		boolean res = true;
		
		if (origin != null && destination != null)
		{
			if (origin.isPlayerAvailable() == false)
			{
				System.out.println("[DEBUG] No player to move.");
				res = false;
			}
			else if (origin.isPlayerStanding())
			{
				if (destination.isPlayerAvailable() == false)
				{
					System.out.println("[ACTION] "+origin.getPlayer().getName()+" tries to move.\n");
					if (origin.resolveDodges())
					{
						System.out.print("[ACTION] "+origin.getPlayer().getName()+" moves with succes.");
						// Make the move
						AbbPlayer player = origin.getPlayer();
						origin.removePlayer();			
						destination.setPlayer(player);
					}
					else
					{
						System.out.print("[ACTION] "+origin.getPlayer().getName()+" fails dodges.");
					}
				}
				else
				{
					if (origin.getPlayer().getTeam() == destination.getPlayer().getTeam())
					{
						System.out.println("[DEBUG] The square is occuped by "+destination.getPlayer().getName()+".");				
						res = false;
					}
					else if (destination.isPlayerStanding())
					{
						// Make a block
						makeBlock(origin, destination);
					}
					else
					{
						// Make a foul
						makeFoul(origin, destination);
					}
				}
			}
			else
			{
				// Player Stands Up
				origin.getPlayer().tryStandUp();
			}
		}
		else
		{
			System.out.println("[DEBUG] No player to move.");			
		}
		
		return res;
	}
	
	public boolean makeFoul(AbbSquare origin, AbbSquare destination)
	{
		System.out.println("[ACTION] "+origin.getPlayer().getName()+" engage a foul action on "+destination.getPlayer().getName()+".");				

		//TODO
		int dice1 = AbbDiceEngine.launchD6();
		int dice2 = AbbDiceEngine.launchD6();
		int dice3 = AbbDiceEngine.launchD6();
		int dice4 = AbbDiceEngine.launchD6();
		int assistBonusOrigin = destination.getAssistsAgainstFrom(origin);
		int assistBonusDestination = origin.getAssistsAgainstFrom(destination);
		int assistBalance = assistBonusOrigin - assistBonusDestination;
		
		System.out.println("[ACTION] Foul result [Amor Dices :"+dice1+"/"+dice2+" Assists:"+assistBalance+"] [Injurie dices :"+dice3+"/"+dice4+"]");				
		if (dice1 == dice2 || dice3 == dice4)
		{
			// REF !
			System.out.println("[FOUL] The referee has spotted the foul.");		
			// TODO TURN OVER
			// TODO Player is sent off to the dungeon
		}
		else if (destination.getPlayer().isInjuriedByFoul(dice1 + dice2 + assistBalance))
		{
			// INJURIE
			PlayerStates foulRes = PlayerStates.checkTable(dice3 + dice4);
			destination.getPlayer().setState(foulRes);
		}
		else
		{
			// Foul fails
			System.out.println("[FOUL] The foul fails.");				
		}
		
		return true;
	}

	public AbbPasses getKindOfPass(int x1, int y1,int x2, int y2)
	{
		AbbPasses kind = AbbPasses.ShortPass;
		int x12 = x1-x2;
		int y12 = y1-y2;
		double d = Math.sqrt(x12*x12 + y12*y12);
	
		if (d < 3.99) kind = AbbPasses.QuickPass;
		else if (d < 7.4) kind = AbbPasses.ShortPass;
		else if (d < 10.8) kind = AbbPasses.LongPass;
		else if (d < 13.6) kind = AbbPasses.LongBomb;
		else kind = AbbPasses.HailMary;

		return kind;
	}
	
	public double distance(int x, int y, int a, int b, int c)
	{
		return Math.abs(a*x + b*y + c) / Math.sqrt(a*a + b*b);
	}
	
	public ArrayList<AbbSquare> getInterceptionSquares(AbbPasses kind, int passTeam, int x1, int y1,int x2, int y2)
	{
		ArrayList<AbbSquare> interceptionZones = new ArrayList<AbbSquare>();
		
		if (kind != AbbPasses.HailMary)
		{
			int x12 = x1-x2;
			int y12 = y1-y2;
			int xy = x2*y1 - x1*y2;
			double d = Math.sqrt(x12*x12 + y12*y12);
	
			if ((x12 == 0) && (Math.abs(y12) > 1))
			{
				for (int j = Math.min(y1,y2)+1; j < Math.max(y1,y2); j++)
				{
					for (int i = x1-1; i <= x1+1; i++)
					{
						if (getSquare(i,j).canPlayerIntercept(passTeam))
						{
							System.out.print("[ACTION] Interception zone ["+i+","+j+"] by "+getSquare(i,j).getPlayer().getName()+"\n");
							interceptionZones.add(getSquare(i,j));
						}
					}
				}
			}
			else if ((y12 == 0) && (Math.abs(x12) > 1))
			{
				for (int i = Math.min(x1,x2)+1; i < Math.max(x1,x2); i++)
				{
					for (int j = y1-1; j <= y1+1; j++)
					{
						if (getSquare(i,j).canPlayerIntercept(passTeam))
						{
							System.out.print("[ACTION] Interception zone ["+i+","+j+"] by "+getSquare(i,j).getPlayer().getName()+"\n");
							interceptionZones.add(getSquare(i,j));
						}
					}
				}
			}
			else if ((x12 == 0) || (y12 == 0))
			{
				System.out.print("[ACTION] No interception possible for this pass.");		
			}
			else
			{
				for (int i = Math.min(x1,x2); i <= Math.max(x1,x2); i++)
				{
					for (int j = Math.min(y1,y2); j <= Math.max(y1,y2); j++)
					{
						d = distance(i,j,-y12,x12,xy);
						if ((d <= 1) && ((d > 0) || ((i != x1) && (i != x2) && (j != y1) && (j != y2))))
						{
							if (getSquare(i,j).canPlayerIntercept(passTeam))
							{
								System.out.print("[ACTION] Interception zone ["+i+","+j+"] by "+getSquare(i,j).getPlayer().getName()+"\n");
								interceptionZones.add(getSquare(i,j));
							}
						}
					}
				}
			}
		}
		
		return interceptionZones;
	}

	public boolean makePass(int x1, int y1,int x2, int y2)
	{
		boolean res = false;
		boolean interceptionRes = false;
			
		if (areValideCoords(x1, y1) && areValideCoords(x2, y2))
		{
			AbbPasses kind = getKindOfPass(x1+1, y1+1, x2+1, y2+1);
			System.out.print("[ACTION] Pass ["+kind.toString()+"] from ["+x1+","+y1+"] to ["+x2+","+y2+"]\n");
			
			ArrayList<AbbSquare> interceptionZones = getInterceptionSquares(kind, getSquare(x1, y1).getPlayer().getTeam(), x1, y1, x2, y2);
			if (interceptionZones.size() > 0)
			{
				//TODO : ASK USER FOR INTERCEPTION PLAYER
				interceptionRes = interceptionZones.get(0).playerInterception();
			}

			if (interceptionRes == false)
			{
				res = makePass(kind, getSquare(x1, y1), getSquare(x2, y2));			
			}			
			else
			{
				getSquare(x1, y1).setBallPresent(false);
			}
		}
		
		return res;
	}

	public boolean makePass(AbbPasses kind, AbbSquare origin, AbbSquare destination)
	{
		boolean res = false;
		AbbPasses.Result passRes = AbbPasses.Result.Scattered;
		
		if (origin.isPlayerStanding() && origin.isBallPresent())
		{
			passRes = origin.playerThrowTheBall(kind);
			if (passRes != AbbPasses.Result.Fumble)
			{
				res = AbbPasses.Result.isASuccess(passRes);
				origin.setBallPresent(false);
				destination.ballEnters(res);
			}
		}
		else
		{
			System.out.println("[DEBUG] No pass is possible from this square.");
		}
		
		return res;
	}

	public boolean makeDodge(AbbSquare origin, AbbSquare destination)
	{
		// TODO
		
		return true;
	}

	public int getBlockBalance(AbbSquare origin, AbbSquare destination)
	{
		int nbDices = 0;
		
		if (origin.isPlayerStanding() && destination.isPlayerStanding())
		{
			int stOrigin = origin.getPlayer().getST();
			int stDestination = destination.getPlayer().getST();
			int assistBonusOrigin = destination.getAssistsAgainstFrom(origin);
			int assistBonusDestination = origin.getAssistsAgainstFrom(destination);
			int stOriginWithAssits = origin.getPlayer().getST() + destination.getAssistsAgainstFrom(origin);
			int stDestinationWithAssits = destination.getPlayer().getST() + origin.getAssistsAgainstFrom(destination);
			
			System.out.println("[BLOCK] "+origin.getPlayer().getName()+" [ST:"+stOrigin+" ASSIST:"+assistBonusOrigin+ "] "+destination.getPlayer().getName()+" [ST:"+stDestination+" ASSIST:"+assistBonusDestination+ "]");
			int blockBalance = stOriginWithAssits - stDestinationWithAssits;
			
			if (blockBalance > stDestinationWithAssits) nbDices = 3;
			else if (Math.abs(blockBalance) > stOriginWithAssits) nbDices = -3;
			else if (blockBalance > 0) nbDices = 2;
			else if (blockBalance == 0) nbDices = 1;
			else if (blockBalance < 0) nbDices = -2;	
		}
		return nbDices;
	}

	public boolean makeBlock(AbbSquare origin, AbbSquare destination)
	{
		System.out.println("[ACTION] "+origin.getPlayer().getName()+" engage a block action on "+destination.getPlayer().getName()+".");				

		AbbSquare attacker = origin;
		AbbSquare defender = destination;
		int nbDices = getBlockBalance(origin, destination);
		
		ArrayList<BlockDice> dice = new ArrayList<BlockDice>();
		for (int i=0; i<Math.abs(nbDices); i++)
		{
			dice.add(AbbDiceEngine.launchBlockDice());
		}
		
		BlockDice choosenDice = dice.get(0);	
		if (nbDices > 0)
		{
			// TODO : ATT CHOOSE DICE		
			choosenDice = dice.get(0);	
		}
		else
		{
			// TODO : DEF CHOOSE DICE			
			choosenDice = dice.get(0);	
		}
		
		// RESOLVE PUSHES
		if (BlockDice.needsPush(choosenDice))
		{
			defender = destination.pushPlayer(attacker);
			attacker = attacker.followPlayer(destination);
		}
		
		// RESOLVE INJURIES
		boolean attRes = attacker.resolveInjury(true, choosenDice);
		boolean defRes = defender.resolveInjury(false, choosenDice);
		
		if (attRes)
		{
			// TODO : TURN OVER
		}
		
		return true;
	}

	public void placeBallKickOff(int x, int y, FieldZones kickTeamMainZone)
	{
		// TODO : coherence controls
		if (FieldZones.isInOpposingCamp(kickTeamMainZone, field[y][x].getZoneType()))
		{
			int scatterDirection = AbbDiceEngine.launchD8();
			int scatterDistance = AbbDiceEngine.launchD6();
			field[y][x].setBallPresent(true);			
			System.out.print("[ACTION] Kick-Off falls in ["+x+","+y+"]");
			
			boolean ballIsOut = false;
			int hAfterBounce = 0;
			int lAfterBounce = 0;
			switch (scatterDirection)
			{
				case 1:
					hAfterBounce = y-scatterDistance;
					lAfterBounce = x-scatterDistance;
					break;
				case 2:
					hAfterBounce = y-scatterDistance;
					lAfterBounce = x;
					break;
				case 3:
					hAfterBounce = y-scatterDistance;
					lAfterBounce = x+scatterDistance;
					break;
				case 4:
					hAfterBounce = y;
					lAfterBounce = x-scatterDistance;
					break;
				case 5:
					hAfterBounce = y;
					lAfterBounce = x+scatterDistance;
					break;
				case 6:
					hAfterBounce = y+scatterDistance;
					lAfterBounce = x-scatterDistance;
					break;
				case 7:
					hAfterBounce = y+scatterDistance;
					lAfterBounce = x;
					break;
				case 8:
					hAfterBounce = y+scatterDistance;
					lAfterBounce = x+scatterDistance;
					break;
			}
			ballIsOut = !areValideCoords(hAfterBounce, lAfterBounce);
			if (ballIsOut == false)
			{
				ballIsOut = true;
				System.out.print(" and bounces to ["+hAfterBounce+","+lAfterBounce+"] (dir:"+scatterDirection+" dist: "+scatterDistance+")\n");			
				if (FieldZones.isInOpposingCamp(kickTeamMainZone, field[hAfterBounce][lAfterBounce].getZoneType()))
				{
					AbbSquare squareAfterBounce = field[hAfterBounce][lAfterBounce].ballBounces();
					if (squareAfterBounce != null)
					{
						ballIsOut = !FieldZones.isInOpposingCamp(kickTeamMainZone, squareAfterBounce.getZoneType());						
					}
				}
			}
			
			if (ballIsOut)
			{
				System.out.print(" => Kick-Off ball bounces out of the receiving area.\n");
				// TODO : give ball to other team
			}
		}
		else
		{
			System.out.println("[DEBUG] Kick-Off ball placement is wrong.");
		}
	}

	public void placeBallWithoutTest(int x, int y)
	{
		field[y][x].setBallPresent(true);
	}

	public void placeBall(int x, int y)
	{
		field[y][x].setBallPresent(true);
	}
	
	public AbbField()
	{
		field = new AbbSquare[HEIGHT][LENGHT];
		
		for(int y=0; y<HEIGHT; y++)
		{
			for(int x=0; x<LENGHT; x++)
			{
				AbbSquare square = new AbbSquare();
				square.setZoneType(getZoneTypeFromCoords(x, y));	
				field[y][x] = square;
			}
		}

		for(int y=0; y<HEIGHT; y++)
		{
			for(int x=0; x<LENGHT; x++)
			{
				field[y][x].addTackleZone(FieldZones.Directions.NO, getSquare(x-1, y-1));
				field[y][x].addTackleZone(FieldZones.Directions.O,  getSquare(x-1, y));
				field[y][x].addTackleZone(FieldZones.Directions.SO, getSquare(x-1, y+1));
				field[y][x].addTackleZone(FieldZones.Directions.N,  getSquare(x  , y-1));
				field[y][x].addTackleZone(FieldZones.Directions.S,  getSquare(x  , y+1));
				field[y][x].addTackleZone(FieldZones.Directions.NE, getSquare(x+1, y-1));
				field[y][x].addTackleZone(FieldZones.Directions.E,  getSquare(x+1, y));
				field[y][x].addTackleZone(FieldZones.Directions.SE, getSquare(x+1, y+1));
			}
		}
	}
	
	public FieldZones getZoneTypeFromCoords(int x, int y)
	{
		return zoneDefs[y][x];
	}

	public boolean isSquareFree(int x, int y)
	{
		return (isSquareFree(getSquare(x,y)));
	}

	public boolean isSquareFree(AbbSquare s)
	{
		return (!s.isPlayerAvailable());
	}
}

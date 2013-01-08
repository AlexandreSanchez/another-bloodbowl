package com.abb.model;
/**
 * 
 */

/**
 * @author wdzt6311
 *
 */
public enum FieldZones {
	NotSetted,
	MainZoneLeft,
	ScrimmageLeft,
	WideZoneLeftUp,
	WideZoneLeftDown,
	EndZoneLeft,
	MainZoneRight,
	ScrimmageRight,
	WideZoneRightUp,
	WideZoneRightDown,
	EndZoneRight;
	
	static public boolean isInOpposingCamp(FieldZones teamMainZone, FieldZones zone)
	{
		boolean ret = false;
		
		if (teamMainZone == FieldZones.MainZoneLeft)
		{
			ret = (zone == FieldZones.MainZoneRight ||zone == FieldZones.ScrimmageRight ||zone == FieldZones.WideZoneRightUp ||zone == FieldZones.WideZoneRightDown ||zone == FieldZones.EndZoneRight); 
		}
		if (teamMainZone == FieldZones.MainZoneRight)
		{
			ret = (zone == FieldZones.MainZoneLeft ||zone == FieldZones.ScrimmageLeft ||zone == FieldZones.WideZoneLeftUp ||zone == FieldZones.WideZoneLeftDown ||zone == FieldZones.EndZoneLeft); 
		}		
		
		return ret;
	}
	static public boolean isInSameCamp(FieldZones teamMainZone, FieldZones zone)
	{
		boolean ret = false;
		
		if (teamMainZone == FieldZones.MainZoneRight)
		{
			ret = (zone == FieldZones.MainZoneRight ||zone == FieldZones.ScrimmageRight ||zone == FieldZones.WideZoneRightUp ||zone == FieldZones.WideZoneRightDown ||zone == FieldZones.EndZoneRight); 
		}
		if (teamMainZone == FieldZones.MainZoneLeft)
		{
			ret = (zone == FieldZones.MainZoneLeft ||zone == FieldZones.ScrimmageLeft ||zone == FieldZones.WideZoneLeftUp ||zone == FieldZones.WideZoneLeftDown ||zone == FieldZones.EndZoneLeft); 
		}		
		
		return ret;
	}
	/**
	 * @author wdzt6311
	 *
	 */
	public enum Directions {
		NO,
		N,
		NE,
		O,
		E,
		SO,
		S,
		SE;

		static public Directions getMoveDirection(int x1, int y1, int x2, int y2)
		{
			Directions dir = N;
			int dx = x2-x1;
			int dy = y2-y1;

			if (dx>0 && dy>0)
			{
				dir = SE;
			}
			else if (dx==0 && dy>0)
			{
				dir = S;				
			}
			else if (dx<0 && dy>0)
			{
				dir = SO;				
			}
			else if (dx>0 && dy==0)
			{
				dir = E;				
			}
			else if (dx<0 && dy==0)
			{
				dir = O;				
			}
			else if (dx>0 && dy<0)
			{
				dir = NE;				
			}
			else if (dx==0 && dy<0)
			{
				dir = N;				
			}
			else if (dx<0 && dy<0)
			{
				dir = NO;
			}
			
			return dir;
		}
		
		static public Directions getDirections(int dice)
		{
			Directions dir = N;
			
			switch(dice)
			{
			case 1:
				dir = NO;
				break;
			case 2:
				dir = N;
				break;
			case 3:
				dir = NE;
				break;
			case 4:
				dir = O;
				break;
			case 5:
				dir = E;
				break;
			case 6:
				dir = SO;
				break;
			case 7:
				dir = S;
				break;
			case 8:
				dir = SE;
				break;
			}
			
			return dir;
		}
		
		static public Directions[] getPushDirections(Directions from)
		{
			Directions[] directions = new Directions[3];
			
			switch(from)
			{
			case N:
				directions[0] = SO;
				directions[1] = S;
				directions[2] = SE;
				break;
			case S:
				directions[0] = NO;
				directions[1] = N;
				directions[2] = NE;
				break;
			case O:
				directions[0] = NE;
				directions[1] = E;
				directions[2] = SE;
				break;
			case E:
				directions[0] = NO;
				directions[1] = O;
				directions[2] = SO;
				break;
			case NO:
				directions[0] = E;
				directions[1] = SE;
				directions[2] = S;
				break;
			case NE:
				directions[0] = O;
				directions[1] = SO;
				directions[2] = S;
				break;
			case SO:
				directions[0] = NE;
				directions[1] = E;
				directions[2] = N;
				break;
			case SE:
				directions[0] = O;
				directions[1] = NO;
				directions[2] = N;
				break;		
			}
			
			return directions;
		}
	}
}

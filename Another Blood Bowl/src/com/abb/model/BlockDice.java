package com.abb.model;
/**
 * 
 */

/**
 * @author wdzt6311
 *
 */
public enum BlockDice {
	Skull,
	BothDown,
	Pushed,
	DefenderStumbles,
	DefenderDown;
	
	static public boolean needsPush(BlockDice dice)
	{	
		return (dice == Pushed || dice == DefenderStumbles || dice == DefenderDown);
	}
}

package com.abb.model;
/**
 * 
 */

/**
 * @author wdzt6311
 *
 */
public enum AbbPasses {
	QuickPass,
	ShortPass,
	LongPass,
	LongBomb,
	HailMary;
	
	public static int getModificator(AbbPasses kind) {
		int ret = 0;
		switch (kind)
		{
			case QuickPass:
				ret = 1;
				break;
			case LongPass:
				ret = -1;
				break;
			case LongBomb:
				ret = -2;
				break;
			case ShortPass:
			case HailMary:
			default:
				ret = 0;
				break;
		}		

		return ret;
	}

	/**
	 * @author wdzt6311
	 *
	 */
	public enum Result {
		Accurate,
		Scattered,
		Fumble;
		
		public static boolean isASuccess(AbbPasses.Result passRes)
		{
			boolean res = false;
			
			if (passRes == Accurate)
			{
				res = true;
			}
			
			return res;
		}
	}	
}

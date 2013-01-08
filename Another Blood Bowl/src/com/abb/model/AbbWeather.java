package com.abb.model;
/**
 * 
 */

/**
 * @author wdzt6311
 *
 */
public enum AbbWeather {
	SwelteringHeat,
	VerySunny,
	Nice,
	PouringRain,
	Blizzard;

	public static AbbWeather checkTable() {
		AbbWeather weather = AbbWeather.Nice;
		
		int diceRes = AbbDiceEngine.launchD6(2);
		
		switch (diceRes)
		{
			case 2:
				weather = AbbWeather.SwelteringHeat;
				break;
			case 3:
				weather = AbbWeather.VerySunny;
				break;
			case 11:
				weather = AbbWeather.PouringRain;
				break;
			case 12:
				weather = AbbWeather.Blizzard;
				break;
			default:
				weather = AbbWeather.Nice;
				break;
		}
		
		System.out.println("[SETUP] Weather [Dice:"+diceRes+"] : Weather is "+weather.toString());	

		return weather;
	}

}

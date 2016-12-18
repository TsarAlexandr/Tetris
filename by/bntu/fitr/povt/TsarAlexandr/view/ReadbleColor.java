package by.bntu.fitr.povt.TsarAlexandr.view;

import java.util.Random;

public enum ReadbleColor {
	BLACK, RED, BLUE, YELLOW, GREEN;
	
	private static  ReadbleColor [] colormass = {BLACK, RED, BLUE, YELLOW, GREEN};
	
	public  static ReadbleColor getRandomColor()
	{
		int colorNum = new Random().nextInt(colormass.length -1) + 1;
		return colormass[colorNum];
	}

}

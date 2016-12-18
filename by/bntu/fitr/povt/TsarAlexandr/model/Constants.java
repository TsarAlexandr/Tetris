package by.bntu.fitr.povt.TsarAlexandr.model;

import by.bntu.fitr.povt.TsarAlexandr.view.ReadbleColor;

public class Constants {
	
	public static final int SIZE_OF_CELL = 24;
	
	public static final int COUNT_ON_X = 10;
	public static final int COUNT_ON_Y = 2 * COUNT_ON_X;
	
	public static final int SCREEN_WIDTH = COUNT_ON_X *SIZE_OF_CELL;
    public static final int SCREEN_HEIGHT = COUNT_ON_Y *SIZE_OF_CELL;
    
    public static final ReadbleColor VOID_COLOR = ReadbleColor.BLACK;
    public static final int BOOST_MULT = 10;
    public static final int FPS = 60;
    public static final int	MOVEDOWNS_PER_SECOND = 3;
    public static  int FRAMES_PER_MOVE = FPS / MOVEDOWNS_PER_SECOND;
    public static final int OFFSET_TOP = 3;
    
  
    public static final int MISSING_BLOKS = 1;

    public static final int MAX_FIGURE_WIDTH = 4;
}

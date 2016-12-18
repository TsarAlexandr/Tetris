package by.bntu.fitr.povt.TsarAlexandr.controller;


import by.bntu.fitr.povt.TsarAlexandr.view.GraphicModule;
import by.bntu.fitr.povt.TsarAlexandr.view.lwjglmodule.LWJGLgraphic;
import by.bntu.fitr.povt.TsarAlexandr.model.Shifts;

import static by.bntu.fitr.povt.TsarAlexandr.model.Constants.BOOST_MULT;
import static by.bntu.fitr.povt.TsarAlexandr.model.Constants.FPS;
import static by.bntu.fitr.povt.TsarAlexandr.model.Constants.FRAMES_PER_MOVE;



import by.bntu.fitr.povt.TsarAlexandr.model.FieldAndFigures;



import by.bntu.fitr.povt.TsarAlexandr.model.keyboard.KeyboardModule;
import by.bntu.fitr.povt.TsarAlexandr.model.keyboard.lwjglmodule.LWJGLkeyboard;


public class GamePlay {
	
	private static boolean endOfGame;
	
	private static KeyboardModule keyboardModule;
	private static GraphicModule graphModule;
	private static boolean wasBoost;
	private static boolean wasRotate;
	private static Shifts shiftDir;
	private static FieldAndFigures gameField;
	private static int loopNumber;
	public static int score;
	
	private static void initFields()
	{
		endOfGame = false;
		wasBoost = false;
		wasRotate = false;
		keyboardModule = new LWJGLkeyboard();
		graphModule = new LWJGLgraphic();
		shiftDir = Shifts.WAIT;
		score = 0;
		gameField = new FieldAndFigures();
		loopNumber = 0;
		
	}
	
	private static void input()
	{
		keyboardModule.update();
		shiftDir = keyboardModule.getShiftDirect();
		wasBoost = keyboardModule.wasBoost();
		wasRotate = keyboardModule.wasRotate();
		endOfGame = endOfGame || keyboardModule.wasEsc() || graphModule.isClose();
	}
	
	private static void logic()
	{
		if(shiftDir != Shifts.WAIT)
		{
			gameField.tryToShift(shiftDir);
			
			shiftDir = Shifts.WAIT;
		}
		
		if (wasRotate)
		{
			gameField.tryToRotate();;
			wasRotate = false;
		}
		
		if(loopNumber % (FRAMES_PER_MOVE / (wasBoost? BOOST_MULT:1)) == 0)
		{
			if(gameField.tryToDrop())
			{
				score += 20 * gameField.multipl;
			}
			
		}
		
		loopNumber = ((loopNumber + 1)%(FRAMES_PER_MOVE));
		
		endOfGame = endOfGame || gameField.isOverfield();
	}
	
	
	public static void play() {
		initFields();
		
		while(!endOfGame)
		{
			input();
			logic();
			
			
			if (score == 20)
			{
				FRAMES_PER_MOVE = 2;
			}
			System.out.println(FRAMES_PER_MOVE);
			graphModule.draw(gameField);
			graphModule.sync(FPS);
			
			
			
			
		}
		
		graphModule.destroy();
		
				
		
	}

}

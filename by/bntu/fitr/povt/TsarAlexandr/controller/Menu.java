package by.bntu.fitr.povt.TsarAlexandr.controller;


import by.bntu.fitr.povt.TsarAlexandr.view.lwjglmodule.LWJGLMenu;
import by.bntu.fitr.povt.TsarAlexandr.controller.GamePlay;
 
public class Menu {
 


	
	public static void main(String[] argv) {
		LWJGLMenu obj = new LWJGLMenu();
		GamePlay game = new GamePlay();
		obj.start(game);
	}
}
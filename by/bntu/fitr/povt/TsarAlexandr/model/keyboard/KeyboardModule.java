package by.bntu.fitr.povt.TsarAlexandr.model.keyboard;

import by.bntu.fitr.povt.TsarAlexandr.model.Shifts; 

public interface KeyboardModule {
	
	void update();
	
	boolean wasBoost();
	boolean wasRotate();
	boolean wasEsc();
	Shifts getShiftDirect();

}

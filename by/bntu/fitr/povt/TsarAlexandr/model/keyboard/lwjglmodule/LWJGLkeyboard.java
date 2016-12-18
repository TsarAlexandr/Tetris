package by.bntu.fitr.povt.TsarAlexandr.model.keyboard.lwjglmodule;

import org.lwjgl.input.Keyboard;
import by.bntu.fitr.povt.TsarAlexandr.model.Shifts;
import by.bntu.fitr.povt.TsarAlexandr.model.keyboard.KeyboardModule;

public class LWJGLkeyboard implements KeyboardModule {
	private boolean wasEsc;
	private boolean wasRotate;
	private Shifts shiftDirect;

	@Override
	public void update() {
		resetValues();

		while (Keyboard.next()) {
			if (Keyboard.getEventKeyState()) {
				switch (Keyboard.getEventKey()) {
				case Keyboard.KEY_SPACE:
					wasRotate = true;
					break;
				case Keyboard.KEY_ESCAPE:
					wasEsc = true;
					break;
				case Keyboard.KEY_LEFT:
					shiftDirect = Shifts.LEFT;
					break;
				case Keyboard.KEY_RIGHT:
					shiftDirect = Shifts.RIGHT;
					break;
				}
			}

		}
	}

	private void resetValues() {
		this.wasEsc = false;
		this.wasRotate = false;
		this.shiftDirect = Shifts.WAIT;
	}

	@Override
	public boolean wasBoost() {

		return Keyboard.isKeyDown(Keyboard.KEY_DOWN);
	}

	@Override
	public boolean wasRotate() {

		return wasRotate;
	}

	@Override
	public boolean wasEsc() {

		return wasEsc;
	}

	@Override
	public Shifts getShiftDirect() {

		return shiftDirect;
	}

}

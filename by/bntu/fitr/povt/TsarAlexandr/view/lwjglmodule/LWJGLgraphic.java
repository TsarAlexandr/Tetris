package by.bntu.fitr.povt.TsarAlexandr.view.lwjglmodule;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.util.Color;
import org.lwjgl.util.ReadableColor;

import by.bntu.fitr.povt.TsarAlexandr.model.*;
import by.bntu.fitr.povt.TsarAlexandr.view.GraphicModule;
import by.bntu.fitr.povt.TsarAlexandr.view.ReadbleColor;

import static by.bntu.fitr.povt.TsarAlexandr.model.Constants.*;
import static org.lwjgl.opengl.GL11.*;

public class LWJGLgraphic implements GraphicModule {

	public LWJGLgraphic() {
		initOpengl();
	}

	private void initOpengl() {
		try {
			Display.setDisplayMode(new DisplayMode(Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT));
			Display.setTitle("TETRIS");
			Display.create();
		} catch (LWJGLException e) {
			ErrorCatcher.graphexept(e);
		}

		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		glOrtho(0, Constants.SCREEN_WIDTH, 0, Constants.SCREEN_HEIGHT, 1, -1);
		glMatrixMode(GL_MODELVIEW);

	}

	private void drawCell(int x, int y, Color color) {
		glColor3ub(color.getRedByte(), color.getGreenByte(), color.getBlueByte());
		glRectf(x, y, x + Constants.SIZE_OF_CELL, y + Constants.SIZE_OF_CELL);

	}

	@Override
	public void draw(FieldAndFigures field) {
		glClear(GL_COLOR_BUFFER_BIT);
		for (int x = 0; x < COUNT_ON_X; x++) {
			for (int y = 0; y < COUNT_ON_Y; y++) {
				ReadbleColor color = field.getColor(x, y);
				drawCell(x * SIZE_OF_CELL, y * SIZE_OF_CELL, convertColor(color));
			}
		}
		Figure figure = field.getFigure();
		ReadbleColor color = figure.getColor();
		for (Cord coord : figure.getCords()) {
			drawCell(coord.x * SIZE_OF_CELL, coord.y * SIZE_OF_CELL, convertColor(color));
		}

		Display.update();

	}

	private Color convertColor(ReadbleColor color) {
		switch (color) {
		case BLACK:
			return new Color(ReadableColor.BLACK);
		case RED:
			return new Color(ReadableColor.RED);
		case YELLOW:
			return new Color(ReadableColor.YELLOW);
		case GREEN:
			return new Color(ReadableColor.GREEN);
		case BLUE:
			return new Color(ReadableColor.BLUE);
		default:
			return new Color(ReadableColor.WHITE);
		}
	}

	@Override
	public boolean isClose() {
		return Display.isCloseRequested();
	}

	@Override
	public void destroy() {
		Display.destroy();

	}

	@Override
	public void sync(int fps) {
		Display.sync(fps);

	}

}

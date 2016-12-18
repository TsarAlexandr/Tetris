package by.bntu.fitr.povt.TsarAlexandr.model;

import by.bntu.fitr.povt.TsarAlexandr.view.ReadbleColor;

import static by.bntu.fitr.povt.TsarAlexandr.model.Constants.*;

import java.util.Random;

public class FieldAndFigures {

	private ReadbleColor[][] field;

	private Figure figure;

	private int[] countFiledCellsInLine;
	
	public int multipl;

	public FieldAndFigures() {
		createNewFigure();

		field = new ReadbleColor[COUNT_ON_X][COUNT_ON_Y + OFFSET_TOP];
		countFiledCellsInLine = new int[COUNT_ON_Y + OFFSET_TOP];

		Random rnd = new Random();

		

		int missingBlocksXCoords = rnd.nextInt(COUNT_ON_X - (MISSING_BLOKS + 1));

		for (int x = 0; x < COUNT_ON_X; x++) {
			if ((missingBlocksXCoords == x)) {
				field[x][0] = VOID_COLOR;

			} else {
				field[x][0] = ReadbleColor.getRandomColor();
				countFiledCellsInLine[0]++;
			}
		}

		for (int y = 1; y < COUNT_ON_Y + OFFSET_TOP; y++) {
			for (int x = 0; x < COUNT_ON_X; x++) {
				field[x][y] = VOID_COLOR;
			}
		}
	}

	private void createNewFigure() {
		int randX = new Random().nextInt(COUNT_ON_X - MAX_FIGURE_WIDTH);

		this.figure = new Figure(new Cord(randX, COUNT_ON_Y + OFFSET_TOP - 1));
	}

	public boolean isEmpity(int x, int y) {
		return (field[x][y].equals(VOID_COLOR));
	}

	public ReadbleColor getColor(int x, int y) {
		if (field[x][y] == null)
			return VOID_COLOR;
		return field[x][y];
	}

	public Figure getFigure() {
		return figure;
	}

	private boolean tryDestroy(int y) {

		if (countFiledCellsInLine[y] < COUNT_ON_X) {
			return false;
		}

		for (int x = 0; x < COUNT_ON_X; x++) {
			field[x][y] = VOID_COLOR;
		}

		countFiledCellsInLine[y] = 0;
		return true;
	}

	private void shiftDown() {
		int fallTo = -1;
		boolean ret = true;
		multipl = 1;
		for (int y = 0; y < COUNT_ON_Y; ++y) {
			if (fallTo == -1) {
				if (countFiledCellsInLine[y] == 0) {
					
					fallTo = y;
				}
			} else

			{   if (countFiledCellsInLine[y] == 0 && ret)
				multipl++;
				
				if (countFiledCellsInLine[y] != 0) {
					
					ret = false;
					for (int x = 0; x < COUNT_ON_X; ++x) {
						field[x][fallTo] = field[x][y];
						field[x][y] = VOID_COLOR;
						
					}

					countFiledCellsInLine[fallTo] = countFiledCellsInLine[y];
					countFiledCellsInLine[y] = 0;
					fallTo++;

				}
				
				
			}

		}

	}

	public boolean isOverfield() {

		for (int i = 0; i < OFFSET_TOP; i++) {
			if (countFiledCellsInLine[COUNT_ON_Y + i] != 0)
				return true;
		}

		return false;
	}

	public void tryToShift(Shifts direction) {
		Cord[] shiftCord = figure.getShiftCord(direction);
		
		boolean canShift = true;

		for (Cord cord : shiftCord) {
			if ((cord.x < 0 || cord.x >= COUNT_ON_X) || (cord.y < 0 || cord.y >= COUNT_ON_Y + OFFSET_TOP)
					|| !isEmpity(cord.x, cord.y)) {
				canShift = false;
			}
		}

		if (canShift) {
			figure.shift(direction);
		}
	}

	public boolean tryToDrop() {
		Cord[] fallenCoords = figure.getFallCord();
		boolean res = false;

		boolean canFall = true;

		for (Cord coord : fallenCoords) {
			if ((coord.y < 0 || coord.y >= COUNT_ON_Y + OFFSET_TOP) || (coord.x < 0 || coord.x >= COUNT_ON_X)
					|| !isEmpity(coord.x, coord.y)) {
				canFall = false;
			}
		}

		if (canFall) {
			figure.fall();
			return res;
		} else {
			Cord[] figureCoords = figure.getCords();

			boolean haveToShiftLinesDown = false;

			for (Cord coord : figureCoords) {
				field[coord.x][coord.y] = figure.getColor();

				countFiledCellsInLine[coord.y]++;

				haveToShiftLinesDown = tryDestroy(coord.y) || haveToShiftLinesDown;
			}

			if (haveToShiftLinesDown)
			{
				shiftDown();
				res = true;
				
			}

			createNewFigure();
			return res;
		}
	}

	public void tryToRotate() {
		boolean canRotate = true;
		Cord[] rotCord = figure.getRotationCord();
		for (Cord cord : rotCord) {
			if ((cord.y < 0 || cord.y >= COUNT_ON_Y + OFFSET_TOP) || (cord.x < 0 || cord.x >= COUNT_ON_X)
					|| !isEmpity(cord.x, cord.y)) {
				canRotate = false;
			}

		}

		if (canRotate) {
			figure.rotate();
		}
	}

}

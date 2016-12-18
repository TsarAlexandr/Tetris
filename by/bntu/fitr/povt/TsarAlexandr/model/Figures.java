package by.bntu.fitr.povt.TsarAlexandr.model;

import by.bntu.fitr.povt.TsarAlexandr.view.ReadbleColor;
import java.util.Random;

public enum Figures {
	I_FORM(CoordMask.I_FORM, ReadbleColor.BLUE ),
	QUAD_FORM(CoordMask.QUAD_FORM, ReadbleColor.GREEN),
	T_FORM(CoordMask.T_FORM, ReadbleColor.RED),
	S_FORM(CoordMask.S_FORM, ReadbleColor.YELLOW);
	
	private CoordMask mask;
	private ReadbleColor color;
	
	Figures(CoordMask mask, ReadbleColor color)
	{
		this.color = color;
		this.mask = mask;
	}
	public CoordMask getMask() {
		return mask;
	}

	public ReadbleColor getColor() {
		return color;
	}
	
	public static final Figures [] figurMass = {I_FORM,QUAD_FORM,T_FORM,S_FORM};
	
	public static Figures getRanFigure()
	{
		int formNumber = new Random().nextInt(figurMass.length);
		return figurMass[formNumber];
	}

	


	

}

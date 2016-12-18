package by.bntu.fitr.povt.TsarAlexandr.model;

import by.bntu.fitr.povt.TsarAlexandr.view.ReadbleColor;

public class Figure {
	
	private Cord metaCord;
	private Rotation currentRotation;
	private Figures form;
	
	public Figure(Cord metaCord)
	{
		this(metaCord, Rotation.NORMAL, Figures.getRanFigure());
	}
	
	public Figure(Cord metaCord, Rotation currentRotation, Figures form )
	{
		this.currentRotation = currentRotation;
		this.metaCord = metaCord;
		this.form = form;
	}
	 public Cord[] getCords ()
	 {
		 return form.getMask().generate(metaCord, currentRotation);
	 }
	 
	 public Cord[] getRotationCord()
	 {
		 return form.getMask().generate(metaCord, Rotation.getNextForm(currentRotation));
	 }
	 
	 public void rotate()
	 {
		 this.currentRotation  = Rotation.getNextForm(currentRotation);
	 }
	 
	 public Cord[] getShiftCord(Shifts direction)
	 {
		 Cord newCord  = null;
		 switch(direction)
		 {
		 case LEFT:
			 newCord = new Cord(metaCord.x-1,metaCord.y);
			 break;
		 case RIGHT:
			 newCord = new Cord(metaCord.x+1, metaCord.y);
			 break;
		default: ErrorCatcher.wrongpar("Shiftdirection", "Figure");
		 }
		 return form.getMask().generate(newCord, currentRotation);
	 }
	 
	 public void shift(Shifts direction)
	 {
		 switch(direction)
		 {
		 case LEFT:
			 metaCord.x--;
			 break;
		 case RIGHT:
			 metaCord.x++;
			 break;
		default : ErrorCatcher.wrongpar("shiftdirection", "figure");
		 }
		
	}
	 
	 
	 public Cord[] getFallCord(){
		 Cord newCord = new Cord(metaCord.x, metaCord.y-1);
		 return form.getMask().generate(newCord, currentRotation);
	 }
	 
	 public void fall()
	 {
		 metaCord.y--;
	 }
	 
	 public ReadbleColor getColor()
	 {
		 return form.getColor();
	 }
	 
}






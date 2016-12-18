package by.bntu.fitr.povt.TsarAlexandr.model;

public enum Rotation {
	
	NORMAL(0), FLIP_CLOCKWISE(1),INVERT(2),FLIP_COUNTRCLOKWISE(3);
	
	private int number;
	Rotation(int number){
		this.number = number;
	}
	
	
	private static Rotation [] rotationMass = {NORMAL, FLIP_CLOCKWISE,INVERT,
			FLIP_COUNTRCLOKWISE};
	
	
	
	public static Rotation getNextForm(Rotation previosForm)
	{
		int newRotationIndex =  (previosForm.number + 1) % rotationMass.length;
		return rotationMass[newRotationIndex];
	}

}

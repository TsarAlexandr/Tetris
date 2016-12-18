package by.bntu.fitr.povt.TsarAlexandr.model;

public enum CoordMask {
	I_FORM(new GenerationDelegate(){
		@Override
		public Cord[] generate(Cord imCord, Rotation rotation)
		{
			Cord [] ret = new Cord[4];
			switch (rotation)
			{
			case NORMAL:
			case INVERT:
				ret[0] = imCord;
                ret[1] = new Cord(imCord.x , imCord.y - 1);
                ret[2] = new Cord(imCord.x, imCord.y - 2);
                ret[3] = new Cord(imCord.x, imCord.y - 3);
                break;
			case FLIP_COUNTRCLOKWISE:
			case FLIP_CLOCKWISE:
				ret[0] = imCord;
                ret[1] = new Cord(imCord.x + 1, imCord.y);
                ret[2] = new Cord(imCord.x + 2, imCord.y);
                ret[3] = new Cord(imCord.x + 3, imCord.y);
                break;
            default:
                ErrorCatcher.wrongpar("rotation", "CordMask");
              
			}
			return ret;
		}
	}
	),
	QUAD_FORM(
	new GenerationDelegate(){
		@Override
		public  Cord[] generate(Cord imCord, Rotation rotation)
		{
			Cord [] ret = new Cord[4];
			ret[0] = imCord;
			ret[1] = new Cord(imCord.x, imCord.y - 1);
			ret[2] = new Cord(imCord.x + 1, imCord.y - 1);
			ret[3] = new Cord(imCord.x + 1, imCord.y);

			return ret;
		}
	}
	),
	T_FORM(new GenerationDelegate(){
		@Override
		public Cord[] generate(Cord imCord, Rotation rotation)
		{
			Cord [] ret = new Cord [4];
			switch (rotation){
            case NORMAL:
                ret[0] = imCord;
                ret[1] = new Cord(imCord.x + 1, imCord.y);
                ret[2] = new Cord(imCord.x + 1, imCord.y - 1);
                ret[3] = new Cord(imCord.x + 2, imCord.y);
                break;
            case INVERT:
                ret[0] = new Cord(imCord.x, imCord.y - 1);
                ret[1] = new Cord(imCord.x + 1, imCord.y - 1);
                ret[2] = new Cord(imCord.x + 1, imCord.y);
                ret[3] = new Cord(imCord.x + 2, imCord.y - 1);
                break;
            case FLIP_COUNTRCLOKWISE:
                ret[0] = imCord;;
                ret[1] = new Cord(imCord.x, imCord.y - 1);
                ret[2] = new Cord(imCord.x + 1, imCord.y - 1);
                ret[3] = new Cord(imCord.x, imCord.y - 2);
                break;
            case FLIP_CLOCKWISE:
                ret[0] = new Cord(imCord.x + 1, imCord.y);
                ret[1] = new Cord(imCord.x + 1, imCord.y - 1);
                ret[2] = new Cord(imCord.x, imCord.y - 1);
                ret[3] = new Cord(imCord.x + 1, imCord.y - 2);
                break;
            default:
                ErrorCatcher.wrongpar("rotation", "CordMask");
        }

        return ret;
		}
	}),
	S_FORM( new GenerationDelegate(){
		public Cord[] generate(Cord imCord, Rotation rotation)
		{
			Cord [] ret = new Cord[4];
			 switch (rotation){
             case NORMAL:
             case INVERT:
                 ret[0] = new Cord(imCord.x , imCord.y - 1);
                 ret[1] = new Cord(imCord.x + 1 , imCord.y - 1);
                 ret[2] = new Cord(imCord.x + 1, imCord.y);
                 ret[3] = new Cord(imCord.x + 2, imCord.y);
                 break;
             case FLIP_COUNTRCLOKWISE:
             case FLIP_CLOCKWISE:
                 ret[0] = imCord;
                 ret[1] = new Cord(imCord.x, imCord.y - 1);
                 ret[2] = new Cord(imCord.x + 1, imCord.y - 1);
                 ret[3] = new Cord(imCord.x + 1, imCord.y - 2);
                 break;
             default:
                 ErrorCatcher.wrongpar("rotation", "CordMask");
		}
			 return ret;
	}
	});	
	
	private interface GenerationDelegate
	{
		Cord [] generate(Cord imCord, Rotation rotation);
	}
	
	private GenerationDelegate form;
	
	CoordMask(GenerationDelegate form)
	{
		this.form = form;
	}
	
	public Cord [] generate(Cord imCord, Rotation rotation)
	{
		return this.form.generate(imCord, rotation);
	}
	
	

}

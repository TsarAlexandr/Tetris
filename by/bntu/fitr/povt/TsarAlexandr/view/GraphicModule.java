package by.bntu.fitr.povt.TsarAlexandr.view;
import by.bntu.fitr.povt.TsarAlexandr.model.FieldAndFigures;

public interface GraphicModule {
	
	void draw(FieldAndFigures field);
	boolean isClose();
	void destroy();
	void sync(int fps);
	
	

}

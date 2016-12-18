package by.bntu.fitr.povt.TsarAlexandr.model;

public class ErrorCatcher {
	
	public static void wrongpar(String epar, String eclass)
	{
		System.err.println("Error in " + epar + " in class " + eclass);
		System.exit(-2);
	}
	
	public static void graphexept(Exception er)
	{
		System.err.println("Graphik module failed");
		er.printStackTrace();
		System.exit(-3);
	}

}

package crud.controller;

public enum Trabajo {

	PROGRAMMER, GRAPHIC_DESIGNER, TESTER, UX_DESIGN;

	/**
	 * Devuelve el salario del trabajo
	 * @param trabajo
	 * @return
	 */
	public static int getSalario(Trabajo trabajo) {

		switch (trabajo) {
		case PROGRAMMER:

			return 40000;
		case GRAPHIC_DESIGNER:

			return 50000;
		case TESTER:

			return 41500;
		case UX_DESIGN:

			return 39999;
		default:
			return 0;
		}

	}
	
	/**
	 * Devuelver el nombre del trabajo
	 * @param trabajo
	 * @return
	 */
	public static String getTrabajo(Trabajo trabajo) {
		
		switch (trabajo) {
		case PROGRAMMER:
			
			return "programmer";
		case GRAPHIC_DESIGNER:
			
			return "graphic designer";
		case TESTER:
			
			return "tester";
		case UX_DESIGN:
			
			return "ux designer";
		default:
			
			return "trabajo predeterminado";
		}
		
	}


}

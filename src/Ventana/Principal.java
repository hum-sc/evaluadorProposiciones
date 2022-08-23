package Ventana;

import Ventana.ShowTable;

public class Principal {
	
	public static void main(String[] args) {

		int i=0;
		int opion;
		ShowTable v = new ShowTable ();
		
		do {
			opion = v.pedirDatos();
			i++;
			v.asegnar(i, opion);
		} while (opion != 9);

	}

}

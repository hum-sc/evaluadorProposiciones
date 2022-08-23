/**
 * 
 */
package Ventana;

import java.util.HashMap;

import javax.swing.JOptionPane;

/**
 * @author Cesar Ivan Ramirez
 *
 */
public class ShowTable {
	HashMap<Integer, String> values = new HashMap<Integer, String>();
	String clave [] = {"p","q","r","^","v","¬","(",")"};

	public int pedirDatos(){
		String options;
        int op;
        options = JOptionPane.showInputDialog(null,
        		"Selecciona tipo de operacion para crear\n"+
                "0.- p\n"+
                "1.- q\n"+
                "2.- r\n"+
                "3.- ^\n"+
                "4.- v\n"+
                "5.- ¬\n"+
                "6.- (\n"+
                "7.- )\n"+
                "8.- Aceptar\n"+
                "9.- Finalizar\n","Bienvenido al evaluador de proposiciones logicas",JOptionPane.QUESTION_MESSAGE);      
        op = Integer.parseInt(options);
        return op; 
        
    }
	public void asegnar(int i, int j) {
		String temp;
		temp = clave [j];
        values.put(i, temp);
	}
}

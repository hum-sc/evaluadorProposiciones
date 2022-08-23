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
public class View {
	HashMap<Integer, String> values = new HashMap<Integer, String>();
	String clave [] = {"p","q","r","^","v","¬","(",")","Evaluar"};
	int j = 0;

	public int showMessages(String mensaje){
		String options, temp;
		String Data = mensaje;
		String temp2 = Preview();
        int op;
        
        options = JOptionPane.showInputDialog(null,Data+"Previsualizacion\n"+temp2
        		,"Bienvenido al evaluador de proposiciones logicas",JOptionPane.QUESTION_MESSAGE);
        
        for(int i=0; i<=8; i++){
            Data += clave [i]+"/n"; 
        }
        op = Integer.parseInt(options);
        j++;
		temp = clave [op];
        values.put(j, temp);

        return op; 
		
    }
	public String Preview () {
		String temp="";
		for (String i : values.values()) {
			temp += i;
		}
		return temp;
	}
	
}

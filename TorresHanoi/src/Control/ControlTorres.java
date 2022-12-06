package Control;

public class ControlTorres {
	int i=1;
	public void Hanoi(int n, int origen,  int auxiliar, int destino){
		
        if(n==1){
        	System.out.println((i++)+".-mover disco de " + origen + " a " + destino);
        }else{
        	Hanoi(n-1, origen, destino, auxiliar);
        	System.out.println((i++)+".- mover disco de "+ origen + " a " + destino);
        	Hanoi(n-1, auxiliar, origen, destino);
        }
    }
}

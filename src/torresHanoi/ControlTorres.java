package torresHanoi;

public class ControlTorres {
	int i=1;
	/**
	 *
	* */
	public String hanoi(int n, int origen,  int auxiliar, int destino){
		String retorno = "";
        if(n==1){
        	return ((i++)+".-mover disco de " + origen + " a " + destino)+"\n";
        }
		retorno += hanoi(n-1, origen, destino, auxiliar);
		retorno += ((i++)+".- mover disco de "+ origen + " a " + destino)+"\n";
		retorno += hanoi(n-1, auxiliar, origen, destino);
		return retorno;
    }
}

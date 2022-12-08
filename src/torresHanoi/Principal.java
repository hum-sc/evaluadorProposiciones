package torresHanoi;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ControlTorres cT = new ControlTorres();
        int n, o, f, a;
        System.out.println("Numero de discos: ");
        n = sc.nextInt();
        
        System.out.println("Torre Inicial: ");
        o = sc.nextInt();
        
        System.out.println("Torre final: ");
        f = sc.nextInt();
        
        a = Math.abs(f-o);
        
        System.out.println(cT.hanoi(n,o,a,f));
        sc.close();

	}

}

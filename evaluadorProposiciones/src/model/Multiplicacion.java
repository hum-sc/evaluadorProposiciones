package model;

public class Multiplicacion extends Operation{
	public Multiplicacion(Operation left, Operation right) {
        super(left, right);
    }


    @Override
    public String toString() {
        return left.toString()+"*"+right.toString();
    }
}

package model;

public class Divicion extends Operation{
	public Divicion(Operation left, Operation right) {
        super(left, right);
    }

    

    @Override
    public String toString() {
        return left.toString()+"/"+right.toString();
    }
}

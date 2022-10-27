package model;

public class Power extends Operation{
	public Power(Operation left, Operation right) {
        super(left, right);
    }


    @Override
    public String toString() {
        return "^";
    }
}

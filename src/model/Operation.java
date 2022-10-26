/**
 * 
 */
package model;

/**
 * @author hum-s
 *
 */
public class Operation {
	protected Operation left, right, parent;

	public Operation() {
		
	}
	
	public Operation(Operation left, Operation right) {
		this.left = left;
		this.right = right;
		this.parent = null;
	}

	public void setLeft(Operation left) {
		this.left = left;
	}

	public void setRight(Operation right) {
		this.right = right;
	}
	public Operation getLeft() {
		return left;
	}
	public Operation getRight() {
		return right;
	}
	
	public String EnOrden() {
		String a= "";
		String b= "";
		left.EnOrden();
		right.EnOrden();
		a=left.toString();
		b=right.toString();
		return a+b;
	}
	public String PosOrden() {
		String b ="";
		String x = "";

		if (!(left == null)) {
			
			left.PosOrden();
			b = left.toString();
			right.PosOrden();
			
			x = right.toString();
		}
		return b+x;
	}
	@Override
    public String toString() {
        return left.toString()+"operando"+right.toString();
    }
}

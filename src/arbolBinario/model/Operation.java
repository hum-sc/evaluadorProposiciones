/**
 * 
 */
package arbolBinario.model;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Map;

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

	public String preOrden(){
		String result = "";
		result += this.toString();
		if(left != null){
			result += left.preOrden();
		}
		if(right != null){
			result += right.preOrden();
		}
		return result;
	}

	public String inOrden(){
		String result = "";
		if(left != null){
			result += left.inOrden();
		}
		result += this.toString();
		if(right != null){
			result += right.inOrden();
		}
		return result;
	}

	public String postOrden(){
		String result = "";
		if(left != null){
			result += left.postOrden();
		}
		if(right != null){
			result += right.postOrden();
		}
		result += this.toString();
		return result;
	}

	public void inLavels(Map<Integer,ArrayList<String>> map, int i){
		if(map.get(i) == null) map.put(i, new ArrayList<String>());
		map.get(i).add(this.toString());
		this.left.inLavels(map, i+1);
		this.right.inLavels(map, i+1);
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

	@Override
    public String toString() {
        return "operando";
    }
	public Operation getOperation(){
        return null;
    }
}

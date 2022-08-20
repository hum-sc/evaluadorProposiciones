/**
 * 
 */
package model;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hum-s
 *
 */
public class Operation {
	private Operation left, right;
	public Map<String, boolean[]> values;
	
	public Operation() {
		
	}
	
	public Operation(Operation left, Operation right) {
		this.left = left;
		this.right = right;
		this.values = new HashMap<>();
	}
}

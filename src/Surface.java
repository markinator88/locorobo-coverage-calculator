
public class Surface {
	
	/**
	 * Should we have one Surface class or should we create multiple classes
	 * (that may inherit from the Surface class) for different types of surfaces?
	 */
	
	String surfaceName;
	private int type ; 
	private double quantity; 
	
	final int TYPE_TRIM = 0;
	final int TYPE_PAINT = 1;
	final int TYPE_TILE = 2;
	
	Surface() {
	surfaceName = new String("new surface");
	}
	public String getSurfaceName() {
		return surfaceName;
	}
	public void setSurfaceName(String surfaceName) {
		this.surfaceName = surfaceName;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public double getQuantity() {
		return quantity;
	}
	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}
	Surface (Surface s) {
		
	}
	Surface (int type, double quantity) {
		surfaceName = new String (); 
		this.type = type;
		this.quantity =quantity; 
		
	}
	
	public String getName() {
		return surfaceName;
	}
	public void setName(String s) {
		surfaceName = s;
	}
}

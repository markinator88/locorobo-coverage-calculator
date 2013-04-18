
public class Surface {
	
	/**
	 * Should we have one Surface class or should we create multiple classes
	 * (that may inherit from the Surface class) for different types of surfaces?
	 */
	
	String surfaceName;
	private int surfaceType;
	private int dim1;
	private int dim2;
	
	final int TYPE_FLOOR = 0;
	final int TYPE_CEILING = 1;
	final int TYPE_WALL = 2;
	Surface() {
		surfaceName = new String("new surface");
	}
	Surface (Surface s) {
		
	}
	Surface (int type, int dimension1, int dimension2) {
		
	}
	public String getName() {
		return surfaceName;
	}
	public void setName(String s) {
		surfaceName = s;
	}
}

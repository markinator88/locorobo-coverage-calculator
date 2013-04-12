
public class Surface {
	
	/**
	 * Should we have one Surface class or should we create multiple classes
	 * (that may inherit from the Surface class) for different types of surfaces?
	 */
	
	private int surfaceType;
	private int dim1;
	private int dim2;
	
	final int TYPE_FLOOR = 0;
	final int TYPE_CEILING = 1;
	final int TYPE_WALL = 2;
	
	Surface (int type, int dimension1, int dimension2) {
		
	}
}

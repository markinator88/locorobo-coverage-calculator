import java.util.ArrayList;


public class Surface {
	
	/**
	 * Surface class 
	 *  
	 */
	private int type ; 
	private double surfaceXdim; 
	private double surfaceYdim; 
	final int TYPE_TRIM = 0;
	final int TYPE_PAINT = 1;
	final int TYPE_TILE = 2;
	String surfaceName;
	private ArrayList<Cutout> cutoutList = new ArrayList<Cutout>();
	public ArrayList<Cutout> getCutoutList() {
		return cutoutList;
	}
	public void setCutoutList(ArrayList<Cutout> cutoutList) {
		this.cutoutList = cutoutList;
	}
	public double getSurfaceXdim() {
		return surfaceXdim;
	}
	public void setSurfaceXdim(double surfaceXdim) {
		this.surfaceXdim = surfaceXdim;
	}
	public double getSurfaceYdim() {
		return surfaceYdim;
	}
	public void setSurfaceYdim(double surfaceYdim) {
		this.surfaceYdim = surfaceYdim;
	}

	
	
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
		return surfaceXdim;
	}
	public void setQuantity(double quantity) {
		this.surfaceXdim = quantity;
	}
	Surface (Surface s) {
		
	}
	Surface (int type, double quantity) {
		surfaceName = new String (); 
		this.type = type;
		this.surfaceXdim =quantity; 
		
	}
	
	public String getName() {
		return surfaceName;
	}
	public void setName(String s) {
		surfaceName = s;
	}
}

import java.util.ArrayList;

/**
 * used to store and modify a description of the room
 */
public class Surface {
	
	private String surfaceName;
    private String surfaceType; 
	private double surfaceXdim; 
	private double surfaceYdim; 
	final int TYPE_TRIM = 0;
	final int TYPE_PAINT = 1;
	final int TYPE_TILE = 2;
	
	private ArrayList<Cutout> cutoutList = new ArrayList<Cutout>();
	
	/**
	 * creates a new surface with no information
	 */
	Surface (){
		
		surfaceName = new String("new surface");
	}
	
	/**
	 * creates a new surface with specified dimensions 
	 * @param surfaceXdim
	 * @param surfaceYdim
	 * @param surfaceType
	 */
	Surface(double surfaceXdim, double surfaceYdim, String surfaceType) {
		//
		surfaceName = new String("new surface");
		this.surfaceXdim = surfaceXdim; 
		this.surfaceYdim = surfaceYdim;
		this.surfaceType = surfaceType; 
		}
	/**
	 * creates a copy of the specified surface
	 * @param surface to be copied
	 */
	Surface(Surface s) { // copy constructor
		this.surfaceName = new String(s.getName());
		this.cutoutList = new ArrayList<Cutout>();
		for (Cutout cutout : cutoutList) {
			this.cutoutList.add(new Cutout(cutout));
		}
	}
	
	/**
	 * adds a cutout to the surface
	 * @param cutout to be added
	 */
	public void addCutout(Cutout c) {
		cutoutList.add(c); 
	}
	
	/**
	 * replaces a cutout
	 * @param index of cutout to be replace
	 * @param modifiedCutout replacement cutout
	 */
	public void replaceCutout(int index, Cutout modifiedCutout) {
		cutoutList.set(index, modifiedCutout);
	}
	
	/**
	 * removes a cutout
	 * @param index of cutout to be removed
	 */
	public void removeCutout(int index) {
		cutoutList.remove(index);
	}

	/**
	 * returns a cutout
	 * @param index of cutout
	 * @return cutout
	 */
	public Cutout getCutoutAtIndex(int index) {
		return cutoutList.get(index);
	}
	
	/**
	 * returns number of cutouts
	 * @return number of cutouts
	 */
	public int getListSize() {
		return cutoutList.size();
	}
	
	/**
	 * sets name of surface
	 * @param surface name
	 */
	public void setName(String s) {
		surfaceName = s;
	}
	
	/**
	 * gets the name of the surface
	 * @return surface name
	 */
	public String getSurfaceName() {
		return surfaceName;
	}
	
	/**
	 * sets the name of the surface
	 * @param surfaceName
	 */
	public void setSurfaceName(String surfaceName) {
		this.surfaceName = surfaceName;
	}
	
	/**
	 * returns the type of surface
	 * @return type of surface
	 */
	public String getSurfaceType() {
		return surfaceType;
	}
	
	/**
	 * sets the type of surface
	 * @param surfaceType
	 */
	public void setSurfaceType(String surfaceType) {
		this.surfaceType = surfaceType;
	}
	
	/**
	 * gets the X dimension
	 * @return x dimension
	 */
	public double getSurfaceXdim() {
		return surfaceXdim;
	}
	
	/**
	 * sets the x dimension
	 * @param surfaceXdim
	 */
	public void setSurfaceXdim(double surfaceXdim) {
		this.surfaceXdim = surfaceXdim;
	}
	
	/**
	 * gets the surface y dimension
	 * @return
	 */
	public double getSurfaceYdim() {
		return surfaceYdim;
	}
	
	/**
	 * sets the surface y dimension
	 * @param surfaceYdim
	 */
	public void setSurfaceYdim(double surfaceYdim) {
		this.surfaceYdim = surfaceYdim;
	}
	
	/**
	 * sets the list of cutouts
	 * @param cutoutList
	 */
	public void setCutoutList(ArrayList<Cutout> cutoutList) {
		this.cutoutList = cutoutList;
	}
	
	/**
	 * returns the surface name
	 * @return surface
	 */
	public String getName() {
		return surfaceName;
	}
	
	/**
	 * returns the list of cutouts
	 * @return list of cutouts
	 */
	public ArrayList<Cutout> getCutoutList() {
		return (ArrayList<Cutout>)cutoutList.clone();
	}
	
	/**
	 * returns the names of all cutouts
	 * @return names of all cutouts
	 */
	public String[] toStringArray() {
		String returnArray[] = new String[cutoutList.size()];
		for (int n=0; n<cutoutList.size(); n++) {
			returnArray[n] = cutoutList.get(n).getName();
		}
		return returnArray;
	}
	
}

	
	
	

	
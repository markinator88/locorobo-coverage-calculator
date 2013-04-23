import java.util.ArrayList;


public class Surface {
	
	/**
	 * Surface class 
	 *  
	 */
	private String surfaceName;
	private ArrayList<Cutout> cutoutList = new ArrayList<Cutout>();
	private int type; 
	private double surfaceXdim; 
	private double surfaceYdim; 
	final int TYPE_TRIM = 0;
	final int TYPE_PAINT = 1;
	final int TYPE_TILE = 2;
	
	
	Surface() {
		surfaceName = new String("new surface");
	}
	Surface(Surface r) { // copy constructor
		this.surfaceName = new String(r.getName());
		this.cutoutList = new ArrayList<Cutout>();
		for (Cutout cutout : cutoutList) {
			this.cutoutList.add(new Cutout(cutout));
		}
	}
	
	public void addCutout(Cutout s) {
		cutoutList.add(s); 
	}
	public void replaceCutout(int index, Cutout modifiedCutout) {
		cutoutList.set(index, modifiedCutout);
	}
	
	
	
	public void removeSurface(int index) {
		cutoutList.remove(index);
	}

	public Cutout getCutoutAtIndex(int index) {
		return cutoutList.get(index);
	}
	
	public int getListSize() {
		return cutoutList.size();
	}
	
	public void setName(String s) {
		surfaceName = s;
	}
	
	public String getName() {
		return surfaceName;
	}
	
	public ArrayList<Cutout> getCutoutList() {
		return (ArrayList<Cutout>)cutoutList.clone();
	}
	
	public String[] toStringArray() {
		String returnArray[] = new String[cutoutList.size()];
		for (int n=0; n<cutoutList.size(); n++) {
			returnArray[n] = cutoutList.get(n).getName();
		}
		return returnArray;
	}
	
}

	
	
	

	
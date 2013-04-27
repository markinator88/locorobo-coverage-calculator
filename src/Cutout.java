import java.util.ArrayList;

/**
 * used to store and modify information describing a cutout 
 */
public class Cutout {
	
	private double cutoutXdim ; 
	private double cutoutYdim ; 
	private String cutoutType;
	
	//
	/**
	 * creates a new cutout of a specified type with specified dimensions
	 * @param cutoutType whether cutout is a door or window
	 * @param cutoutXdim height or length of the cutout
	 * @param cutoutYdim width of the cutout
	 */
	public Cutout(String cutoutType, double cutoutXdim, double cutoutYdim) {
		//
		this.cutoutType = cutoutType; 
		this.cutoutXdim = cutoutXdim; 
		this.cutoutYdim = cutoutYdim; 
		
		}
	
	/**
	 * creates a copy of the specified cutout	
	 * @param cutout to copy
	 */
	public Cutout(Cutout cutout) {
		// TODO Auto-generated constructor stub
	}

	/**
	 * returns the x dimension of the cutout
	 * @return height or length of the cutout
	 */
	public double getCutoutXdim() {
		return cutoutXdim;
	}

	/**
	 * sets the x dimension of the cutout
	 * @param cutoutXdim height or length of the cutout
	 */
	public void setCutoutXdim(double cutoutXdim) {
		this.cutoutXdim = cutoutXdim;
	}

	/**
	 * returns the y dimension of the cutout
	 * @return width of the cutout
	 */
	public double getCutoutYdim() {
		return cutoutYdim;
	}

	/**
	 * sets the y dimension of the cutout
	 * @param cutoutYdim width of the cutout
	 */
	public void setCutoutYdim(double cutoutYdim) {
		this.cutoutYdim = cutoutYdim;
	}

	/**
	 * returns the type of cutout
	 * @return whether the cutout is a door or window
	 */	
	public String getCutoutType() {
		return cutoutType;
	}

	/**
	 * set the type of cutout
	 * @param cutoutType whether the cutout is a door or window
	 */
	public void setCutoutType(String cutoutType) {
		this.cutoutType = cutoutType;
	}

	/**
	 * returns the name of the cutout
	 * @return name of the cutout
	 */
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}
 

}


public class Cutout {
	
	private double cutoutXdim ; 
	private double cutoutYdim ; 
	private int cutoutType;
	//cutout Type int Door = 0, int Window = 1;
	
	
	public Cutout(int cutoutType, double cutoutXdim, double cutoutYdim) {
		
		this.cutoutType = cutoutType; 
		this.cutoutXdim = cutoutXdim; 
		this.cutoutYdim = cutoutYdim; 
				
	}
		
	public Cutout(Cutout cutout) {
		// TODO Auto-generated constructor stub
	}

	public double getCutoutXdim() {
		return cutoutXdim;
	}


	public void setCutoutXdim(double cutoutXdim) {
		this.cutoutXdim = cutoutXdim;
	}


	public double getCutoutYdim() {
		return cutoutYdim;
	}


	public void setCutoutYdim(double cutoutYdim) {
		this.cutoutYdim = cutoutYdim;
	}


	public int getCutoutType() {
		return cutoutType;
	}


	public void setCutoutType(int cutoutType) {
		this.cutoutType = cutoutType;
	}


	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}
 

}

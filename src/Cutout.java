import java.util.ArrayList;


public class Cutout {
	
	private double cutoutXdim ; 
	private double cutoutYdim ; 
	private String cutoutType;
	
	
	public Cutout(String cutoutType, double cutoutXdim, double cutoutYdim) {
		
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


	public String getCutoutType() {
		return cutoutType;
	}


	public void setCutoutType(String cutoutType) {
		this.cutoutType = cutoutType;
	}


	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}
 

}

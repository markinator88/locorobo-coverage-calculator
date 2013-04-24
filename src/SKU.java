
public class SKU {
	private int foreignKey;
	private String skuName;
	private double baseUnits;
	private double price;
	
	public SKU(int foreignKey, String skuName, double baseUnits, double price) {
		this.foreignKey = foreignKey;
		this.skuName = skuName;
		this.baseUnits = baseUnits;
		this.price = price;
	}
	
	public int getForeignKey() {
		return foreignKey;
	}
	
	public String getSKUName() {
		return skuName;
	}
	
	public double getBaseUnits() {
		return baseUnits;
	}
	
	public double getPrice() {
		return price;
	}
}

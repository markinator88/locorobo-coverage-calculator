/**
 * used to store and modify information about SKUs (stock-keeping units)
 */
public class SKU {
	private int foreignKey;
	private String skuName;
	private double baseUnits;
	private double price;
	
	/**
	 * creates a SKU with the specified parameters
	 * @param foreignKey foreign key to link with a material
	 * @param skuName name of SKU
	 * @param baseUnits amount of base/standard units in SKU
	 * @param price of the SKU
	 */
	public SKU(int foreignKey, String skuName, double baseUnits, double price) {
		this.foreignKey = foreignKey;
		this.skuName = skuName;
		this.baseUnits = baseUnits;
		this.price = price;
	}
	
	/**
	 * returns the foreign key for the SKU to link to material
	 * @return foreign key
	 */
	public int getForeignKey() {
		return foreignKey;
	}
	
	/**
	 * returns the name of the SKU
	 * @return
	 */
	public String getSKUName() {
		return skuName;
	}
	
	/**
	 * returns the number of base/standard units of material in this SKU
	 * @return number of base/standard units of material in this SKU
	 */
	public double getBaseUnits() {
		return baseUnits;
	}
	
	/**
	 * returns the price of one SKU
	 * @return price
	 */
	public double getPrice() {
		return price;
	}
}

import java.util.*;

/**
 * used to store and modify information describing a material
 */

public class Material {

	private int uniqueID;
	private String materialName;
	private int materialType;
	private LinkedList<SKU> skuList;
	
	final static int TYPE_VOLUME = 0;
	final static int TYPE_TILED = 1;
	final static int TYPE_LENGTH = 2;
	
	/**
	 * creates a new material with the specified unique ID, name, and coverage type
	 * @param iD unique ID of the material
	 * @param name name of the material
	 * @param type coverage tpye of the material
	 */
	public Material (int iD, String name, int type) {
		uniqueID = iD;
		materialName = name;
		materialType = type;
	}
	
	/**
	 * returns the unique ID of the material
	 * @return unique ID of the material
	 */
	public int getID() {
		return uniqueID;
	}
	
	/**
	 * returns the name of the material
	 * @return name of the material
	 */
	public String getName() {
		return materialName;
	}
	
	/**
	 * returns the coverage type of the material
	 * @return coverage type of the material
	 */
	public int getType() {
		return materialType;
	}
	
	/**
	 * add a SKU (stock-keeping unit) that this material can be purchased as
	 * @param s SKU to be added
	 */
	public void addSKU(SKU s) {
		skuList.add(s);
	}
	
	/**
	 * returns the list of SKUs (stock-keeping units) that this material can be purchased as
	 * @return list of SKUs of this material
	 */
	public LinkedList<SKU> getSKUList() {
		return skuList;
	}
	
	
}

import java.util.*;

public class Material {

/**
* Should we have one Material class or should we create multiple classes
* (that may inherit from the Material class) for different types of materials?
*/
	private int uniqueID;
	private String materialName;
	private int materialType;
	private LinkedList<SKU> skuList;
	
	final static int TYPE_VOLUME = 0;
	final static int TYPE_TILED = 1;
	final static int TYPE_LENGTH = 2;
	
	public Material (int iD, String name, int type) {
		uniqueID = iD;
		materialName = name;
		materialType = type;
	}
	
	public int getID() {
		return uniqueID;
	}
	
	public String getName() {
		return materialName;
	}
	
	public int getType() {
		return materialType;
	}
	
	public void addSKU(SKU s) {
		skuList.add(s);
	}
	
	public LinkedList<SKU> getSKUList() {
		return skuList;
	}
	
	
}

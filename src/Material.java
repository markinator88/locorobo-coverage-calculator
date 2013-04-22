
public class Material {

/**
* Should we have one Material class or should we create multiple classes
* (that may inherit from the Material class) for different types of materials?
*/
	private int UID;
	private String materialName;
	private int materialType;
	private SKUList skuList;
	
	final static int TYPE_VOLUME = 0;
	final static int TYPE_TILED = 1;
	final static int TYPE_LENGTH = 2;
}
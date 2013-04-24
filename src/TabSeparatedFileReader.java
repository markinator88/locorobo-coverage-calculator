import java.io.*;
import java.util.*;
 
public class TabSeparatedFileReader {
	
	/**
	 * reads files to memory in program
	 * @return list of materials including SKUs
	 * @throws Exception
	 */
    public static LinkedList<Material> readFiles() throws Exception {

        /*
         * Source files to read data from.
         */
    	LinkedList<Material> materialsList = new LinkedList<Material>();
    	

        String materialsFileName = "materials.tsv";
        String skuFileName = "sku.tsv"; // SKU = stock-keeping unit

        BufferedReader bReader = new BufferedReader(
                new FileReader(materialsFileName));
 
        String line;

        // loop through lines until end of file

      
        while ((line = bReader.readLine()) != null) {          
        	// Split the content of tab-separated line
             
            String dataValue[] = line.split("\t");
            int uniqueID = Integer.parseInt(dataValue[0]);
            String materialName = dataValue[1];
            int materialType = Integer.parseInt(dataValue[2]);
            
            // materialsList.
 
            // add new material to list
          
        }
        bReader.close();
        
        bReader = new BufferedReader(new FileReader(skuFileName));
        
        while ((line = bReader.readLine()) != null) {
        	
        	 String dataValue[] = line.split("\t");
        	 int foreignKey = Integer.parseInt(dataValue[0]);
        	 String unitName = dataValue[1];
        	 double baseUnits = Integer.parseInt(dataValue[2]);
        	 double price = Double.parseDouble(dataValue[3]);
        	 
        	 int index = 0;
        	 boolean found = false;
        	 do {
        		 if (foreignKey == materialsList.get(index).getID())
        			 found = true;
        		 else
        			 index ++;
        	 } while(found = false && index < materialsList.size());
        	 if (found == true)
        	 {
        		materialsList.get(index).addSKU(new SKU(foreignKey, unitName, baseUnits, price));
        	 }
        }
        bReader.close();
        
        return materialsList;
    }
 
}

import java.io.*;

 
public class TabSeparatedFileReader {
	
	/**
	 * reads files to memory in program
	 * @return list of materials including SKUs
	 * @throws Exception
	 */
    public static MaterialsList readFiles() throws Exception {
    	
        // source data files with tab-seperated data
        String materialsFileName = "materials.tsv";
        String skuFileName = "sku.tsv"; // SKU = stock-keeping unit
 
     	MaterialsList materialsList = new MaterialsList();
       
        
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
 
            // add new material to list
            materialsList.addMaterial(new Material(uniqueID, materialName, materialType)); 
        }
        bReader.close();
        
        bReader = new BufferedReader(new FileReader(skuFileName));
        
        while ((line = bReader.readLine()) != null) {
        	
        	 String dataValue[] = line.split("\t");
        	 // TODO: set up adding SKUS to list in materials 
        	 /*
             int foreignKey = Integer.parseInt(dataValue[0]);
             String materialName = dataValue[1];
             int materialType = Integer.parseInt(dataValue[2]);
             
             //code to search for matching UID and foreign key
            
        	*/
        	 
        	 boolean found = false;
        	 do {
        		 
        	 } while(found = false);
        	 
        }
        bReader.close();
        
        return materialsList;
    }
 
}
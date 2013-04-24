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
    		
    	BufferedWriter bw = new BufferedWriter(new FileWriter(new File("file.txt")));
    	bw.write("Look, a file");
    	bw.close();
    	
    	
    	String dir="user.dir"; // set to current directory
    	  try {dir=new File(System.getProperty(dir)).getCanonicalPath();}
    	  catch (IOException e1) { /*handler required but null */ }
    	  System.out.println ("Current dir : " + dir);
    	  
    	File materialsFilePath = new File("materials.tsv");
    	File skuFilePath = new File("sku.tsv");
       

        BufferedReader reader = new BufferedReader(new FileReader(materialsFilePath));
 
        String line;

        // loop through lines until end of file

      
        while ((line = reader.readLine()) != null) {          
        	// Split the content of tab-separated line
             
            String dataValue[] = line.split("\t");
            int uniqueID = Integer.parseInt(dataValue[0]);
            String materialName = dataValue[1];
            int materialType = Integer.parseInt(dataValue[2]);
            
            materialsList.add(new Material(uniqueID, materialName, materialType));
 
            // add new material to list
          
        }
        reader.close();
        
        reader = new BufferedReader(new FileReader(skuFilePath));
        
        while ((line = reader.readLine()) != null) {
        	
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
        reader.close();
        
        return materialsList;
        
        
    }
 
}

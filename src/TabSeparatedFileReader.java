import java.io.*;

 
public class TabSeparatedFileReader {
 
    public static void main(String args[]) throws Exception {
        /**
         * Source files to read data from.
         */
      
        String materialsFileName = "materials.tsv";
        String skuFileName = "sku.tsv"; // SKU = stock-keeping unit
 
        /**
         * Creating a buffered reader to read the file
         */
        BufferedReader bReader;
        bReader = new BufferedReader(new FileReader(materialsFileName));
        BufferedReader bReader = new BufferedReader(
                new FileReader(materialsFileName));
 
        String line;
 //derp
        /**
         * Looping the read block until all lines in the file are read.
         */
        while ((line = bReader.readLine()) != null) {
 
            /**
             * Splitting the content of tabbed separated line
             */
            String dataValue[] = line.split("\t");
            int uniqueID = Integer.parseInt(dataValue[0]);
            String materialName = dataValue[1];
            int materialType = Integer.parseInt(dataValue[2]);
 
            /**
             * Printing the value read from file to the console
             */
            //System.out.println(value1 + "\t" + value2 + "\t" + value3 + "\t"
            //        + value4);
        }
        bReader.close();
        return materialsList;
    }
 
}
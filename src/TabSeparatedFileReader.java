import java.io.BufferedReader;
import java.io.FileReader;
 
public class TabSeparatedFileReader {
 
    public static void main(String args[]) throws Exception {
        /**
         * Source file to read data from.
         */
        String dataFileName = "C:/Users/Oh SUP Gurl/Desktop/School Stuff/Software Engineering/final/materials1.txt";
 
        /**
         * Creating a buffered reader to read the file
         */
        BufferedReader bReader = new BufferedReader(
                new FileReader(dataFileName));
 
        String line;
 //derp1
        /**
         * Looping the read block until all lines in the file are read.
         */
        while ((line = bReader.readLine()) != null) {
 
            /**
             * Splitting the content of tabbed separated line
             */
            String datavalue[] = line.split("\t");
            String value1 = datavalue[0];
            String value2 = datavalue[1];
            int value3 = Integer.parseInt(datavalue[2]);
            double value4 = Double.parseDouble(datavalue[3]);
 
            /**
             * Printing the value read from file to the console
             */
            System.out.println(value1 + "\t" + value2 + "\t" + value3 + "\t"
                    + value4);
        }
        bReader.close();
    }
 
}
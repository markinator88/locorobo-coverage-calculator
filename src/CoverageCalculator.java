import java.awt.*;
import java.util.*;
import javax.swing.*;
/**
 * @author Mark Rutledge
 * @date 4/8/2012
 */
public class CoverageCalculator {
	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args){
		try {
			//LinkedList<Material> materialsList = TabSeparatedFileReader.readFiles();
			ProjectManager frame = new ProjectManager(new Project());
			frame.setVisible(true);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}

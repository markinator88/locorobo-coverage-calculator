import java.awt.*;
import java.util.*;
import javax.swing.*;
/**
 * starts the coverage calculator by opening up the project manager 
 */
public class CoverageCalculator {
	/**
	 * driver that starts CoverageCalculator by opening up the project manager
	 * @param args
	 */
	public static void main(String[] args){
		try {
			LinkedList<Material> materialsList = TabSeparatedFileReader.readFiles();
			ProjectManager frame = new ProjectManager(new Project(materialsList));
			frame.setVisible(true);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}

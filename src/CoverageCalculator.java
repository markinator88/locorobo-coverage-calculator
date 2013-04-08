import java.awt.*;
import javax.swing.*;
/**
 * @author Mark Rutledge
 * @date 4/8/2012
 */
public class CoverageCalculator {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ProjectManager frame = new ProjectManager();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setPreferredSize(new Dimension(500, 500));
		frame.pack();
		frame.setVisible(true);
	}
}

import javax.swing.*;
import java.util.*;
import java.awt.*;

public class Report extends JDialog {

	
	double totalPaint;
//	double totalTrim = 0.000;
//	double totalTiles = 0.000;
//	double paintVolume = 0.00;
	double paints;
	double trimAmount = 0.00;
	double sqftTiles = 0.00;
	final double toFeet = 12; //This will convert the dimensions given into feet.
	final double calcPaint = 250; //1 gallon of paint to cover 250 sqft.
	
	/**
	 * Create the panel.
	 */
	private Project project;
	private Project room;

	public Report (Project p) {
		
		this.project = p;
	//	Room r = p.getRoomAtIndex(0);				
		setLocation(new Point(400, 200));
		setSize(new Dimension(600, 400));
	
		for(int m=0; m<project.getListSize(); m++) { //cycle through rooms
		    Room r = p.getRoomAtIndex(m);
			// code for displaying room name
		    for(int n=0; n<room.getListSize(); n++) {  //cycle through surfaces
		    	// code for displaying surface name
		    	
		        // code for getting materials needed for each surface 
		    	
		        // code for adding materials for surface to total materials 
		    	
		    } 
		}

				
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{153, 143, 0};
		gridBagLayout.rowHeights = new int[]{15, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 1.0, 0.0, 1.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		//Report Title
		JLabel label = new JLabel("Coverage Calculator Report");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(0, 0, 5, 0);
		gbc_label.anchor = GridBagConstraints.NORTHWEST;
		gbc_label.gridx = 1;
		gbc_label.gridy = 0;
		getContentPane().add(label, gbc_label);
		
		/* Calculates and shows the amount of paint needed for the job.
		 **/
		JLabel lblNewLabel = new JLabel("Paint Needed");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 2;
		getContentPane().add(lblNewLabel, gbc_lblNewLabel);
		
		paints = BuyPaint();
		JLabel PaintLabel = new JLabel(" "+paints+" gallons");
		GridBagConstraints gbc_PaintLabel = new GridBagConstraints();
		gbc_PaintLabel.insets = new Insets(0, 0, 5, 0);
		gbc_PaintLabel.fill = GridBagConstraints.BOTH;
		gbc_PaintLabel.gridx = 1;
		gbc_PaintLabel.gridy = 2;
		getContentPane().add(PaintLabel, gbc_PaintLabel);
		
		/*Calculates and shows the amount of trim needed for the job.
		 **/
		JLabel lblNewLabel_1 = new JLabel("Trim Needed");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 4;
		getContentPane().add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		
		JLabel TrimLabel = new JLabel(" " +totalTrim+" feet");
		GridBagConstraints gbc_TrimLabel = new GridBagConstraints();
		gbc_TrimLabel.insets = new Insets(0, 0, 5, 0);
		gbc_TrimLabel.fill = GridBagConstraints.BOTH;
		gbc_TrimLabel.gridx = 1;
		gbc_TrimLabel.gridy = 4;
		getContentPane().add(TrimLabel, gbc_TrimLabel);
		
		/* * 
		 * Calculates and shows the amount of tiles needed for the job.
		 * Pull tile data from materials class and calculate into square feet.
		 * */
		JLabel lblNewLabel_2 = new JLabel("Tiles Needed");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 6;
		getContentPane().add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		
		JLabel TilesLabel = new JLabel(" "+totalTiles+" square feet.");
		GridBagConstraints gbc_TilesLabel = new GridBagConstraints();
		gbc_TilesLabel.insets = new Insets(0, 0, 5, 0);
		gbc_TilesLabel.fill = GridBagConstraints.BOTH;
		gbc_TilesLabel.gridx = 1;
		gbc_TilesLabel.gridy = 6;
		getContentPane().add(TilesLabel, gbc_TilesLabel);
		
		/* Remove this section from the report after confirming the correct amount of cutout needed.
		   Also remove the results section after confirming the correct amount.
		   Pulls the amount of cutout from each material. This is just to help confirm
		   the correct amount of materials needed.
		**/  
		   
		JLabel lblNewLabel_3 = new JLabel("Subtract Cutout");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 8;
		getContentPane().add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		//Shows the amount of cutout for tiles, trim, and paint materials.
		JLabel CutLabel = new JLabel();
		GridBagConstraints gbc_CutLabel = new GridBagConstraints();
		gbc_CutLabel.fill = GridBagConstraints.BOTH;
		gbc_CutLabel.gridx = 1;
		gbc_CutLabel.gridy = 8;
		getContentPane().add(CutLabel, gbc_CutLabel);

	}
	
	public double BuyPaint() {
		double paintVolume = 100/calcPaint;
		return paintVolume;
	}
	
	public double BuyTiles() {
		double totalTiles = 100;
		return totalTiles;
	}
	
	public double BuyTrim() {
		double totalTrim = 0;
		return totalTrim;
	}

}
	


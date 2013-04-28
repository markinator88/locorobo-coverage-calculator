import javax.swing.*;
import java.util.*;
import java.util.jar.Attributes.Name;
import java.awt.*;

public class Report extends JDialog {

	
	double totalPaint;
	double totalTrim = 0.000;
	double totalTiles = 0.000;
	double paintVolume = 0.00;
	double paints;
	double trims;
	double tiles;
	double trimAmount = 0.00;
	double sqftTiles = 0.00;
	
	double paintNeeded=0.00;
	double tilesNeeded=0.00;
	double trimNeeded = 0.00;
	
	double cutoutPaint = 0.00;
	double totalPaintCut = 0.00;
	double cutoutTiles = 0.00;
	double totalTilesCut = 0.00;
	double cutoutTrim = 0.00;
	double totalTrimCut = 0.00;
	
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
		
		/**
	
		for(int m=0; m<project.getListSize(); m++) { //cycle through rooms
		    Room r = p.getRoomAtIndex(m);
			// code for displaying room name
		    for(int n=0; n<room.getListSize(); n++) {  
		    	Room name = p.getRoomList();
		    			//cycle through surfaces
		    	for(int o=0;o<room.getListSize(); o++) {
		    		
		    	}
		    	// code for displaying surface name
		    	
		        // code for getting materials needed for each surface 
		    	
		        // code for adding materials for surface to total materials 
		    	
		    } 
		}
			*/
				
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
		
		/** Converts the total amount of paint material needed into gallons.
		 * 
		 */
		paints = BuyPaint()-paintCut();
		paintVolume = (paints-cutoutPaint)/calcPaint;
		JLabel PaintLabel = new JLabel(" "+paintVolume+" gallons");
		GridBagConstraints gbc_PaintLabel = new GridBagConstraints();
		gbc_PaintLabel.insets = new Insets(0, 0, 5, 0);
		gbc_PaintLabel.fill = GridBagConstraints.BOTH;
		gbc_PaintLabel.gridx = 1;
		gbc_PaintLabel.gridy = 2;
		getContentPane().add(PaintLabel, gbc_PaintLabel);
		
		/* shows the amount of trim needed for the job.
		 **/
		JLabel lblNewLabel_1 = new JLabel("Trim Needed");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 4;
		getContentPane().add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		trims = BuyTrim();
		totalTrimCut = trimCut();
		totalTrim = (trims-totalTrimCut)/toFeet;
		JLabel TrimLabel = new JLabel(" "+totalTrim+" feet");
		GridBagConstraints gbc_TrimLabel = new GridBagConstraints();
		gbc_TrimLabel.insets = new Insets(0, 0, 5, 0);
		gbc_TrimLabel.fill = GridBagConstraints.BOTH;
		gbc_TrimLabel.gridx = 1;
		gbc_TrimLabel.gridy = 4;
		getContentPane().add(TrimLabel, gbc_TrimLabel);
		
		/* * 
		 * Shows the amount of tiles needed for the job.
		 * Pull tile data from materials class and calculate into square feet.
		 * */
		JLabel lblNewLabel_2 = new JLabel("Tiles Needed");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 6;
		getContentPane().add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		totalTiles = BuyTiles() - tilesCut()/toFeet;
		JLabel TilesLabel = new JLabel(" "+totalTiles+" square feet.");
		GridBagConstraints gbc_TilesLabel = new GridBagConstraints();
		gbc_TilesLabel.insets = new Insets(0, 0, 5, 0);
		gbc_TilesLabel.fill = GridBagConstraints.BOTH;
		gbc_TilesLabel.gridx = 1;
		gbc_TilesLabel.gridy = 6;
		getContentPane().add(TilesLabel, gbc_TilesLabel);
		
		/* Remove this section from the report after confirming the correct amount of cutout needed.
		   Also remove the results section after confirming the correct amount.
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
	
	/** Totals the amount of paint needed to be purchased.
	 * 
	 * @return
	 */
	public double BuyPaint() {
		paintNeeded = 300;
		return paintNeeded;
	}
	
	/** Totals the amount of tiles needed to be purchased.
	 * 
	 * @return
	 */
	public double BuyTiles() {
		tilesNeeded = 1100;
		return tilesNeeded;
	}
	/** Adds up the amount of trim to be purchased.
	 * 
	 * @return
	 */
	public double BuyTrim() {
		trimNeeded = 573;
		return trimNeeded;
	}
	
	/** Adds up the amount of cutout material affecting paint.
	 * 
	 * @return
	 */
	public double paintCut() {
		cutoutPaint = 150;
		return cutoutPaint;
	}
	
	/** Adds up the amount of cutout material affecting tiles.
	 * 
	 * @return
	 */
	public double tilesCut() {
		cutoutTiles = 101;
		return cutoutTiles;
	}	
	
	/** Adds up the amount of cutout material affecting trim.
	 * 
	 * @return
	 */
	public double trimCut() {
		cutoutTrim = 24;
		return cutoutTrim;
	}
	
	
	
	
	
	
}
	


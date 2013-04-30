import java.awt.Dialog;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.Point;
import java.awt.Dimension;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ProjectReport extends JDialog {

	final double toFeet = 12; // This will convert the dimensions given into
								// feet.
	final double calcPaint = 200; // 1 gallon of paint to cover 250 sqft.

	private Project project;
	private Project room;
	private JDialog thisDialog = this;
	private JTextArea paintAmountTextField;
	private JTextArea tileAmountTextField;
	private JTextArea trimAmountTextField;
	private JTextArea paintCostTextField;
	private JTextArea tileCostTextField;
	private JTextArea trimCostTextField;
	private JTextArea totalCostProjectTextField;
	private JButton closeReportLabel;
	private double paintCutoutTotal; 
	private double tileTotalAmount;
	private double tileTotalCost;
	private double paintTotalAmount;
	private double paintTotalCost;
	private double trimTotalAmount;
	private double trimTotalCost;
	private String roomList;
	private JTextArea surfaceListingTextArea;
	private JTextArea cutoutListingTextArea;
	private JLabel lblSurfaceListing;
	private JLabel lblCutoutListing;

	public ProjectReport(Project p) {
		getContentPane().setBackground(new Color(250, 250, 210));
		setMinimumSize(new Dimension(400, 400));
		setLocation(new Point(100, 100));

		this.project = p;

		setTitle("Coverage Calculator - Project Manager");
		// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 400, 300, 300);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 40, 0, 40, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 1.0, 1.0, 1.0, 1.0,
				Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 1.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 1.0, Double.MIN_VALUE };
		getContentPane().setLayout(gridBagLayout);

		JLabel lblRoomsListing = new JLabel("Rooms Listing");
		GridBagConstraints gbc_lblRoomsListing = new GridBagConstraints();
		gbc_lblRoomsListing.insets = new Insets(0, 0, 5, 5);
		gbc_lblRoomsListing.gridx = 1;
		gbc_lblRoomsListing.gridy = 0;
		getContentPane().add(lblRoomsListing, gbc_lblRoomsListing);
		
		lblSurfaceListing = new JLabel("Surface Listing");
		GridBagConstraints gbc_lblSurfaceListing = new GridBagConstraints();
		gbc_lblSurfaceListing.insets = new Insets(0, 0, 5, 5);
		gbc_lblSurfaceListing.gridx = 2;
		gbc_lblSurfaceListing.gridy = 0;
		getContentPane().add(lblSurfaceListing, gbc_lblSurfaceListing);
		
		lblCutoutListing = new JLabel("Cutout Listing");
		GridBagConstraints gbc_lblCutoutListing = new GridBagConstraints();
		gbc_lblCutoutListing.insets = new Insets(0, 0, 5, 5);
		gbc_lblCutoutListing.gridx = 3;
		gbc_lblCutoutListing.gridy = 0;
		getContentPane().add(lblCutoutListing, gbc_lblCutoutListing);

		JTextArea roomListingTextArea = new JTextArea();
		roomListingTextArea.setBorder(UIManager.getBorder("TextField.border"));
		GridBagConstraints gbc_roomListingTextArea = new GridBagConstraints();
		gbc_roomListingTextArea.anchor = GridBagConstraints.NORTH;
		gbc_roomListingTextArea.insets = new Insets(0, 0, 5, 5);
		gbc_roomListingTextArea.fill = GridBagConstraints.HORIZONTAL;
		gbc_roomListingTextArea.gridx = 1;
		gbc_roomListingTextArea.gridy = 1;
		getContentPane().add(roomListingTextArea, gbc_roomListingTextArea);
		
		surfaceListingTextArea = new JTextArea();
		GridBagConstraints gbc_surfaceListingTextArea = new GridBagConstraints();
		gbc_surfaceListingTextArea.anchor = GridBagConstraints.NORTH;
		gbc_surfaceListingTextArea.insets = new Insets(0, 0, 5, 5);
		gbc_surfaceListingTextArea.fill = GridBagConstraints.HORIZONTAL;
		gbc_surfaceListingTextArea.gridx = 2;
		gbc_surfaceListingTextArea.gridy = 1;
		getContentPane().add(surfaceListingTextArea, gbc_surfaceListingTextArea);
		
		cutoutListingTextArea = new JTextArea();
		GridBagConstraints gbc_cutoutListingTextArea = new GridBagConstraints();
		gbc_cutoutListingTextArea.anchor = GridBagConstraints.NORTH;
		gbc_cutoutListingTextArea.insets = new Insets(0, 0, 5, 5);
		gbc_cutoutListingTextArea.fill = GridBagConstraints.HORIZONTAL;
		gbc_cutoutListingTextArea.gridx = 3;
		gbc_cutoutListingTextArea.gridy = 1;
		getContentPane().add(cutoutListingTextArea, gbc_cutoutListingTextArea);

		JLabel lblAmountNeeded = new JLabel("Amount Needed");
		GridBagConstraints gbc_lblAmountNeeded = new GridBagConstraints();
		gbc_lblAmountNeeded.insets = new Insets(0, 0, 5, 5);
		gbc_lblAmountNeeded.gridx = 2;
		gbc_lblAmountNeeded.gridy = 2;
		getContentPane().add(lblAmountNeeded, gbc_lblAmountNeeded);

		JLabel lblTotalCost = new JLabel("Material Cost");
		GridBagConstraints gbc_lblTotalCost = new GridBagConstraints();
		gbc_lblTotalCost.insets = new Insets(0, 0, 5, 5);
		gbc_lblTotalCost.gridx = 3;
		gbc_lblTotalCost.gridy = 2;
		getContentPane().add(lblTotalCost, gbc_lblTotalCost);

		JLabel lblTotalPaintNeeded = new JLabel("Paint");
		GridBagConstraints gbc_lblTotalPaintNeeded = new GridBagConstraints();
		gbc_lblTotalPaintNeeded.fill = GridBagConstraints.VERTICAL;
		gbc_lblTotalPaintNeeded.anchor = GridBagConstraints.EAST;
		gbc_lblTotalPaintNeeded.insets = new Insets(0, 0, 5, 5);
		gbc_lblTotalPaintNeeded.gridx = 1;
		gbc_lblTotalPaintNeeded.gridy = 3;
		getContentPane().add(lblTotalPaintNeeded, gbc_lblTotalPaintNeeded);

		paintAmountTextField = new JTextArea();
		GridBagConstraints gbc_paintAmountTextField = new GridBagConstraints();
		gbc_paintAmountTextField.insets = new Insets(0, 0, 5, 5);
		gbc_paintAmountTextField.fill = GridBagConstraints.BOTH;
		gbc_paintAmountTextField.gridx = 2;
		gbc_paintAmountTextField.gridy = 3;
		getContentPane().add(paintAmountTextField, gbc_paintAmountTextField);
		paintAmountTextField.setColumns(10);

		paintCostTextField = new JTextArea();
		GridBagConstraints gbc_paintCostTextField = new GridBagConstraints();
		gbc_paintCostTextField.insets = new Insets(0, 0, 5, 5);
		gbc_paintCostTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_paintCostTextField.gridx = 3;
		gbc_paintCostTextField.gridy = 3;
		getContentPane().add(paintCostTextField, gbc_paintCostTextField);
		paintCostTextField.setColumns(10);

		JLabel lblTotalTileNeeded = new JLabel("Tile");
		GridBagConstraints gbc_lblTotalTileNeeded = new GridBagConstraints();
		gbc_lblTotalTileNeeded.anchor = GridBagConstraints.EAST;
		gbc_lblTotalTileNeeded.insets = new Insets(0, 0, 5, 5);
		gbc_lblTotalTileNeeded.gridx = 1;
		gbc_lblTotalTileNeeded.gridy = 4;
		getContentPane().add(lblTotalTileNeeded, gbc_lblTotalTileNeeded);

		tileAmountTextField = new JTextArea();
		GridBagConstraints gbc_tileAmountTextField = new GridBagConstraints();
		gbc_tileAmountTextField.insets = new Insets(0, 0, 5, 5);
		gbc_tileAmountTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_tileAmountTextField.gridx = 2;
		gbc_tileAmountTextField.gridy = 4;
		getContentPane().add(tileAmountTextField, gbc_tileAmountTextField);
		tileAmountTextField.setColumns(10);

		tileCostTextField = new JTextArea();
		GridBagConstraints gbc_tileCostTextField = new GridBagConstraints();
		gbc_tileCostTextField.insets = new Insets(0, 0, 5, 5);
		gbc_tileCostTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_tileCostTextField.gridx = 3;
		gbc_tileCostTextField.gridy = 4;
		getContentPane().add(tileCostTextField, gbc_tileCostTextField);
		tileCostTextField.setColumns(10);

		JLabel lblTotalTrimNeeded = new JLabel("Trim");
		GridBagConstraints gbc_lblTotalTrimNeeded = new GridBagConstraints();
		gbc_lblTotalTrimNeeded.anchor = GridBagConstraints.EAST;
		gbc_lblTotalTrimNeeded.insets = new Insets(0, 0, 5, 5);
		gbc_lblTotalTrimNeeded.gridx = 1;
		gbc_lblTotalTrimNeeded.gridy = 5;
		getContentPane().add(lblTotalTrimNeeded, gbc_lblTotalTrimNeeded);

		trimAmountTextField = new JTextArea();
		GridBagConstraints gbc_trimAmountTextField = new GridBagConstraints();
		gbc_trimAmountTextField.insets = new Insets(0, 0, 5, 5);
		gbc_trimAmountTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_trimAmountTextField.gridx = 2;
		gbc_trimAmountTextField.gridy = 5;
		getContentPane().add(trimAmountTextField, gbc_trimAmountTextField);
		trimAmountTextField.setColumns(10);

		trimCostTextField = new JTextArea();
		GridBagConstraints gbc_trimCostTextField = new GridBagConstraints();
		gbc_trimCostTextField.insets = new Insets(0, 0, 5, 5);
		gbc_trimCostTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_trimCostTextField.gridx = 3;
		gbc_trimCostTextField.gridy = 5;
		getContentPane().add(trimCostTextField, gbc_trimCostTextField);
		trimCostTextField.setColumns(10);

		JLabel lblTotalCostOf = new JLabel("Total Cost of Project");
		GridBagConstraints gbc_lblTotalCostOf = new GridBagConstraints();
		gbc_lblTotalCostOf.anchor = GridBagConstraints.EAST;
		gbc_lblTotalCostOf.insets = new Insets(0, 0, 5, 5);
		gbc_lblTotalCostOf.gridx = 2;
		gbc_lblTotalCostOf.gridy = 7;
		getContentPane().add(lblTotalCostOf, gbc_lblTotalCostOf);

		totalCostProjectTextField = new JTextArea();
		GridBagConstraints gbc_totalCostProjectTextField = new GridBagConstraints();
		gbc_totalCostProjectTextField.insets = new Insets(0, 0, 5, 5);
		gbc_totalCostProjectTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_totalCostProjectTextField.gridx = 3;
		gbc_totalCostProjectTextField.gridy = 7;
		getContentPane().add(totalCostProjectTextField,
				gbc_totalCostProjectTextField);
		totalCostProjectTextField.setColumns(10);

		closeReportLabel = new JButton();
		closeReportLabel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				thisDialog.setVisible(false);
				thisDialog.dispose();
			}
		});
		closeReportLabel.setText("Close Report ");
		GridBagConstraints gbc_closeReportLabel = new GridBagConstraints();
		gbc_closeReportLabel.insets = new Insets(0, 0, 0, 5);
		gbc_closeReportLabel.gridx = 1;
		gbc_closeReportLabel.gridy = 8;
		getContentPane().add(closeReportLabel, gbc_closeReportLabel);

	
		for (int m = 0; m < project.getListSize(); m++) { // cycle through rooms
			Room r = p.getRoomAtIndex(m);
			String roomName = r.getRoomName();
			roomListingTextArea.append(roomName + "\n");
				
					
			for (int n = 0; n < r.getListSize(); n++) {  // cycle through surfaces
				Surface s = r.getSurfaceAtIndex(n);
				String surfaceName = s.getSurfaceName();
				double paintArea = paintAmount(s); 
				
				surfaceListingTextArea.append(surfaceName + "\n");
				if (s.getListSize() == 0){  // used to give paintTotal if there are no cutouts
					paintTotalAmount = paintTotalAmount + (paintArea - paintCutoutTotal); 
					
				}
				
				for (int j = 0; j < s.getListSize(); j++) { // cycle through cutouts
					String cutoutType = s.getCutoutAtIndex(j).getCutoutType();
					cutoutListingTextArea.append(cutoutType + "\n");
					paintCutoutTotal = paintCutout(s.getCutoutAtIndex(j));  
					paintTotalAmount = paintTotalAmount + (paintArea - paintCutoutTotal); 
				
				}
			}

		}  //End of for loops
		
		paintTotalAmount = paintTotalAmount / calcPaint; 
		paintTotalCost = paintTotalAmount * 9.95; 
		paintAmountTextField.append(Double.toString(Math.ceil(paintTotalAmount)) + " gals"); 
		paintCostTextField.append("$" +Double.toString(Math.ceil(paintTotalCost)) + "0"); 
		
	} //End of ProjectReport Class
	

	 
	public double paintCutout (Cutout c){
		double totalPaintCutout = 0; 
		totalPaintCutout = totalPaintCutout + (c.getCutoutXdim() * c.getCutoutYdim());
		return totalPaintCutout;
		
	}
	
	
	public double paintAmount (Surface s) {
		
		double paintArea = 0; 
		double xdim = s.getSurfaceXdim(); 
		double ydim = s.getSurfaceYdim();
		paintArea = xdim * ydim ; 
		return paintArea;
	}
	
}
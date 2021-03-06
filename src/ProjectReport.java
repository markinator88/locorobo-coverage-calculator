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
import java.awt.Font;
import java.awt.Dialog.ModalityType;
import java.awt.SystemColor;
import java.text.NumberFormat;
import java.util.Locale;

public class ProjectReport extends JDialog {

	final double toFeet = 12; // This will convert the dimensions given into
								// feet.
	final double calcPaint = 200; // 1 gallon of paint to cover 250 sqft.
	final double calcTrim = 10;
	final double calcTile = 9;
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
	private double tileCutoutTotal;
	private double trimCutoutTotal;
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
	double paintArea;
	double tileArea;
	double trimArea;
	private JTextArea paintAreaTextArea;
	private JTextArea tileAreaTextArea;
	private JTextArea trimAreaTextArea;
	private JLabel lblMaterialAreaLabel;

	public ProjectReport(Project p) {
		setBackground(SystemColor.control);
		setFont(new Font("Dialog", Font.BOLD, 12));
		getContentPane().setFont(new Font("Tahoma", Font.BOLD, 12));
		getContentPane().setBackground(new Color(250, 250, 210));
		setMinimumSize(new Dimension(600, 400));
		setLocation(new Point(100, 100));

		this.project = p;

		setTitle("Report Manager");
		// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 400, 300, 300);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0, 40, 0, 40, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 1.0, 1.0, 1.0, 1.0, 1.0,
				Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 1.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 1.0, Double.MIN_VALUE };
		getContentPane().setLayout(gridBagLayout);

		JLabel lblRoomsListing = new JLabel("Rooms Listing");
		lblRoomsListing.setFont(new Font("Tahoma", Font.BOLD, 12));
		GridBagConstraints gbc_lblRoomsListing = new GridBagConstraints();
		gbc_lblRoomsListing.insets = new Insets(0, 0, 5, 5);
		gbc_lblRoomsListing.gridx = 1;
		gbc_lblRoomsListing.gridy = 0;
		getContentPane().add(lblRoomsListing, gbc_lblRoomsListing);

		lblSurfaceListing = new JLabel("Surface Listing");
		lblSurfaceListing.setFont(new Font("Tahoma", Font.BOLD, 12));
		GridBagConstraints gbc_lblSurfaceListing = new GridBagConstraints();
		gbc_lblSurfaceListing.insets = new Insets(0, 0, 5, 5);
		gbc_lblSurfaceListing.gridx = 3;
		gbc_lblSurfaceListing.gridy = 0;
		getContentPane().add(lblSurfaceListing, gbc_lblSurfaceListing);

		lblCutoutListing = new JLabel("Cutout Listing");
		lblCutoutListing.setFont(new Font("Tahoma", Font.BOLD, 12));
		GridBagConstraints gbc_lblCutoutListing = new GridBagConstraints();
		gbc_lblCutoutListing.insets = new Insets(0, 0, 5, 5);
		gbc_lblCutoutListing.gridx = 4;
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
		gbc_surfaceListingTextArea.gridx = 3;
		gbc_surfaceListingTextArea.gridy = 1;
		getContentPane()
				.add(surfaceListingTextArea, gbc_surfaceListingTextArea);

		cutoutListingTextArea = new JTextArea();
		GridBagConstraints gbc_cutoutListingTextArea = new GridBagConstraints();
		gbc_cutoutListingTextArea.anchor = GridBagConstraints.NORTH;
		gbc_cutoutListingTextArea.insets = new Insets(0, 0, 5, 5);
		gbc_cutoutListingTextArea.fill = GridBagConstraints.HORIZONTAL;
		gbc_cutoutListingTextArea.gridx = 4;
		gbc_cutoutListingTextArea.gridy = 1;
		getContentPane().add(cutoutListingTextArea, gbc_cutoutListingTextArea);
		
		lblMaterialAreaLabel = new JLabel("Total Area/Length");
		lblMaterialAreaLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		GridBagConstraints gbc_lblMaterialAreaLabel = new GridBagConstraints();
		gbc_lblMaterialAreaLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblMaterialAreaLabel.gridx = 2;
		gbc_lblMaterialAreaLabel.gridy = 2;
		getContentPane().add(lblMaterialAreaLabel, gbc_lblMaterialAreaLabel);

		JLabel lblAmountNeeded = new JLabel("Amount Needed");
		lblAmountNeeded.setFont(new Font("Tahoma", Font.BOLD, 12));
		GridBagConstraints gbc_lblAmountNeeded = new GridBagConstraints();
		gbc_lblAmountNeeded.insets = new Insets(0, 0, 5, 5);
		gbc_lblAmountNeeded.gridx = 3;
		gbc_lblAmountNeeded.gridy = 2;
		getContentPane().add(lblAmountNeeded, gbc_lblAmountNeeded);

		JLabel lblTotalCost = new JLabel("Material Cost");
		lblTotalCost.setFont(new Font("Tahoma", Font.BOLD, 12));
		GridBagConstraints gbc_lblTotalCost = new GridBagConstraints();
		gbc_lblTotalCost.insets = new Insets(0, 0, 5, 5);
		gbc_lblTotalCost.gridx = 4;
		gbc_lblTotalCost.gridy = 2;
		getContentPane().add(lblTotalCost, gbc_lblTotalCost);

		JLabel lblTotalPaintNeeded = new JLabel("Paint");
		lblTotalPaintNeeded.setFont(new Font("Tahoma", Font.BOLD, 12));
		GridBagConstraints gbc_lblTotalPaintNeeded = new GridBagConstraints();
		gbc_lblTotalPaintNeeded.fill = GridBagConstraints.VERTICAL;
		gbc_lblTotalPaintNeeded.anchor = GridBagConstraints.EAST;
		gbc_lblTotalPaintNeeded.insets = new Insets(0, 0, 5, 5);
		gbc_lblTotalPaintNeeded.gridx = 1;
		gbc_lblTotalPaintNeeded.gridy = 3;
		getContentPane().add(lblTotalPaintNeeded, gbc_lblTotalPaintNeeded);
		
		paintAreaTextArea = new JTextArea();
		GridBagConstraints gbc_paintAreaTextArea = new GridBagConstraints();
		gbc_paintAreaTextArea.insets = new Insets(0, 0, 5, 5);
		gbc_paintAreaTextArea.fill = GridBagConstraints.BOTH;
		gbc_paintAreaTextArea.gridx = 2;
		gbc_paintAreaTextArea.gridy = 3;
		getContentPane().add(paintAreaTextArea, gbc_paintAreaTextArea);

		paintAmountTextField = new JTextArea();
		GridBagConstraints gbc_paintAmountTextField = new GridBagConstraints();
		gbc_paintAmountTextField.insets = new Insets(0, 0, 5, 5);
		gbc_paintAmountTextField.fill = GridBagConstraints.BOTH;
		gbc_paintAmountTextField.gridx = 3;
		gbc_paintAmountTextField.gridy = 3;
		getContentPane().add(paintAmountTextField, gbc_paintAmountTextField);
		paintAmountTextField.setColumns(10);

		paintCostTextField = new JTextArea();
		GridBagConstraints gbc_paintCostTextField = new GridBagConstraints();
		gbc_paintCostTextField.insets = new Insets(0, 0, 5, 5);
		gbc_paintCostTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_paintCostTextField.gridx = 4;
		gbc_paintCostTextField.gridy = 3;
		getContentPane().add(paintCostTextField, gbc_paintCostTextField);
		paintCostTextField.setColumns(10);

		JLabel lblTotalTileNeeded = new JLabel("Tile");
		lblTotalTileNeeded.setFont(new Font("Tahoma", Font.BOLD, 12));
		GridBagConstraints gbc_lblTotalTileNeeded = new GridBagConstraints();
		gbc_lblTotalTileNeeded.anchor = GridBagConstraints.EAST;
		gbc_lblTotalTileNeeded.insets = new Insets(0, 0, 5, 5);
		gbc_lblTotalTileNeeded.gridx = 1;
		gbc_lblTotalTileNeeded.gridy = 4;
		getContentPane().add(lblTotalTileNeeded, gbc_lblTotalTileNeeded);
		
		tileAreaTextArea = new JTextArea();
		GridBagConstraints gbc_tileAreaTextArea = new GridBagConstraints();
		gbc_tileAreaTextArea.insets = new Insets(0, 0, 5, 5);
		gbc_tileAreaTextArea.fill = GridBagConstraints.BOTH;
		gbc_tileAreaTextArea.gridx = 2;
		gbc_tileAreaTextArea.gridy = 4;
		getContentPane().add(tileAreaTextArea, gbc_tileAreaTextArea);

		tileAmountTextField = new JTextArea();
		GridBagConstraints gbc_tileAmountTextField = new GridBagConstraints();
		gbc_tileAmountTextField.insets = new Insets(0, 0, 5, 5);
		gbc_tileAmountTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_tileAmountTextField.gridx = 3;
		gbc_tileAmountTextField.gridy = 4;
		getContentPane().add(tileAmountTextField, gbc_tileAmountTextField);
		tileAmountTextField.setColumns(10);

		tileCostTextField = new JTextArea();
		GridBagConstraints gbc_tileCostTextField = new GridBagConstraints();
		gbc_tileCostTextField.insets = new Insets(0, 0, 5, 5);
		gbc_tileCostTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_tileCostTextField.gridx = 4;
		gbc_tileCostTextField.gridy = 4;
		getContentPane().add(tileCostTextField, gbc_tileCostTextField);
		tileCostTextField.setColumns(10);

		JLabel lblTotalTrimNeeded = new JLabel("Trim");
		lblTotalTrimNeeded.setFont(new Font("Tahoma", Font.BOLD, 12));
		GridBagConstraints gbc_lblTotalTrimNeeded = new GridBagConstraints();
		gbc_lblTotalTrimNeeded.anchor = GridBagConstraints.EAST;
		gbc_lblTotalTrimNeeded.insets = new Insets(0, 0, 5, 5);
		gbc_lblTotalTrimNeeded.gridx = 1;
		gbc_lblTotalTrimNeeded.gridy = 5;
		getContentPane().add(lblTotalTrimNeeded, gbc_lblTotalTrimNeeded);
		
		trimAreaTextArea = new JTextArea();
		GridBagConstraints gbc_trimAreaTextArea = new GridBagConstraints();
		gbc_trimAreaTextArea.insets = new Insets(0, 0, 5, 5);
		gbc_trimAreaTextArea.fill = GridBagConstraints.BOTH;
		gbc_trimAreaTextArea.gridx = 2;
		gbc_trimAreaTextArea.gridy = 5;
		getContentPane().add(trimAreaTextArea, gbc_trimAreaTextArea);

		trimAmountTextField = new JTextArea();
		GridBagConstraints gbc_trimAmountTextField = new GridBagConstraints();
		gbc_trimAmountTextField.insets = new Insets(0, 0, 5, 5);
		gbc_trimAmountTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_trimAmountTextField.gridx = 3;
		gbc_trimAmountTextField.gridy = 5;
		getContentPane().add(trimAmountTextField, gbc_trimAmountTextField);
		trimAmountTextField.setColumns(10);

		trimCostTextField = new JTextArea();
		GridBagConstraints gbc_trimCostTextField = new GridBagConstraints();
		gbc_trimCostTextField.insets = new Insets(0, 0, 5, 5);
		gbc_trimCostTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_trimCostTextField.gridx = 4;
		gbc_trimCostTextField.gridy = 5;
		getContentPane().add(trimCostTextField, gbc_trimCostTextField);
		trimCostTextField.setColumns(10);

		JLabel lblTotalCostOf = new JLabel("Total Cost of Project");
		lblTotalCostOf.setFont(new Font("Tahoma", Font.BOLD, 12));
		GridBagConstraints gbc_lblTotalCostOf = new GridBagConstraints();
		gbc_lblTotalCostOf.anchor = GridBagConstraints.EAST;
		gbc_lblTotalCostOf.insets = new Insets(0, 0, 5, 5);
		gbc_lblTotalCostOf.gridx = 3;
		gbc_lblTotalCostOf.gridy = 7;
		getContentPane().add(lblTotalCostOf, gbc_lblTotalCostOf);

		totalCostProjectTextField = new JTextArea();
		GridBagConstraints gbc_totalCostProjectTextField = new GridBagConstraints();
		gbc_totalCostProjectTextField.insets = new Insets(0, 0, 5, 5);
		gbc_totalCostProjectTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_totalCostProjectTextField.gridx = 4;
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

			for (int n = 0; n < r.getListSize(); n++) { // cycle through
														// surfaces
				Surface s = r.getSurfaceAtIndex(n);
				String surfaceName = s.getSurfaceName();
				paintArea = paintAmount(s);
				tileArea = tileAmount(s);
				trimArea = trimAmount(s);
				surfaceListingTextArea.append(surfaceName + "\n");
				if (s.getListSize() == 0) { // used to give paintTotal if there
											// are no cutouts

					if (s.getSurfaceType() == 1)
						paintTotalAmount = paintTotalAmount + paintArea;
					else if (s.getSurfaceType() == 0)
						trimTotalAmount = trimTotalAmount + trimArea;
					else if (s.getSurfaceType() == 2)
						tileTotalAmount = tileTotalAmount + tileArea;
					else
						;
				}

				for (int j = 0; j < s.getListSize(); j++) { // cycle through cutouts
					String cutoutType = s.getCutoutAtIndex(j).getCutoutType();
					cutoutListingTextArea.append(cutoutType + "\n");
					if ((s.getSurfaceType() == 1)) {
			
						paintCutoutTotal = paintCutout(s.getCutoutAtIndex(j));
						paintTotalAmount = paintTotalAmount + (paintArea - paintCutoutTotal);
					}

					else if (s.getSurfaceType() == 0) {

						trimCutoutTotal = trimCutout(s.getCutoutAtIndex(j));
						trimTotalAmount = trimTotalAmount + (trimArea + trimCutoutTotal);

					}

					else {

						tileCutoutTotal = tileCutout(s.getCutoutAtIndex(j));
						tileTotalAmount = tileTotalAmount + (tileArea - tileCutoutTotal);
					}
				}
			}
			} // End of for loops

			// calculations and display of paint amount and cost
			
		paintTotalAmount*=100;
		paintTotalAmount = (int) paintTotalAmount;
		paintTotalAmount/=100;
		

		

		
		
			double paintTotalAmountGals = paintTotalAmount / calcPaint;
			paintTotalCost =  Math.ceil(paintTotalAmountGals) * 9.95;
			
			//converts to 2 decimal places
			paintTotalCost*=100;
			paintTotalCost = (int)paintTotalCost;
			paintTotalCost/=100;
			NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.US);
			String ptc1 = nf.format(paintTotalCost);
			
			paintTotalAmount*=100;
			paintTotalAmount = (int) paintTotalAmount;
			paintTotalAmount/=100;			
			
			
			paintAmountTextField.append(Double.toString( Math.ceil(paintTotalAmountGals)) + " gals");
			paintCostTextField.append(ptc1);
			paintAreaTextArea.append(Double.toString(paintTotalAmount) + " Sqft"); 
			

			// calculations and display of tile amount and cost
			tileTotalAmount = tileTotalAmount / calcTile;
			tileTotalCost = Math.ceil(tileTotalAmount) * 9.95;
			
			//converts to 2 decimal places
			tileTotalCost*=100;
			tileTotalCost = (int) tileTotalCost;
			tileTotalCost/=100;
			NumberFormat nf1 = NumberFormat.getCurrencyInstance(Locale.US);
			String ttc1 = nf1.format(tileTotalCost); 
			
			
			tileTotalAmount*=100;
			tileTotalAmount = (int) tileTotalAmount;
			tileTotalAmount/=100;
			
			
			tileAmountTextField.append(Double.toString(Math.ceil(tileTotalAmount)) + " Tiles");
			tileCostTextField.append(ttc1);
			tileAreaTextArea.append(Double.toString(tileTotalAmount) + " Sqft"); 

			// calculations and display of trim amount and cost
			trimTotalAmount = (trimTotalAmount) ;
			trimTotalCost = Math.ceil(trimTotalAmount) * 9.95;
			
			//converts to 2 decimal places
			trimTotalCost*=100;
			trimTotalCost = (int) trimTotalCost;
			trimTotalCost/=100;
			NumberFormat nf2 = NumberFormat.getCurrencyInstance(Locale.US);
			String ttc = nf2.format(trimTotalCost); 	
			
			trimTotalAmount*=100;
			trimTotalAmount = (int) trimTotalAmount;
			trimTotalAmount/=100;
			
			trimAmountTextField.append(Double.toString(Math.ceil(trimTotalAmount)) + " feet");
			trimCostTextField.append(ttc);
			trimAreaTextArea.append(Double.toString(trimTotalAmount) + " ft"); 
			
			double projectCostTotal = (trimTotalCost + paintTotalCost + tileTotalCost); 
			projectCostTotal*=100;
			projectCostTotal = (int) projectCostTotal;
			projectCostTotal/=100;
			NumberFormat nf3 = NumberFormat.getCurrencyInstance(Locale.US);
			String ptc = nf3.format(projectCostTotal); 
			totalCostProjectTextField.append(ptc); 
		

	} // End of ProjectReport Class

	private double tileCutout(Cutout c) {
		double totalTileCutout = 0;
		totalTileCutout = totalTileCutout
				+ (c.getCutoutXdim() * c.getCutoutYdim());
		return totalTileCutout;
	}

	private double trimCutout(Cutout c) {
		double totalPaintCutout = 0;
		totalPaintCutout = totalPaintCutout
				+ ((c.getCutoutXdim() * 2) + (c.getCutoutYdim() * 2));
		return totalPaintCutout;
	}

	private double trimAmount(Surface s) {
		double trimArea = 0;
		double xdim = s.getSurfaceXdim();
		double ydim = s.getSurfaceYdim();
		trimArea = xdim;
		return trimArea;
	}

	private double tileAmount(Surface s) {
		double tileArea = 0;
		double xdim = s.getSurfaceXdim();
		double ydim = s.getSurfaceYdim();
		tileArea = xdim * ydim;
		return tileArea;
	}

	public double paintAmount(Surface s) {

		double paintArea = 0;
		double xdim = s.getSurfaceXdim();
		double ydim = s.getSurfaceYdim();
		paintArea = xdim * ydim;
		return paintArea;
	}

	public double paintCutout(Cutout c) {
		double totalPaintCutout = 0;
		totalPaintCutout = totalPaintCutout
				+ (c.getCutoutXdim() * c.getCutoutYdim());
		return totalPaintCutout;

	}
	}

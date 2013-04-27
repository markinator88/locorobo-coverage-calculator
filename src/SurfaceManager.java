import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class SurfaceManager extends JDialog {

	final int TYPE_TRIM = 0;
	final int TYPE_PAINT = 1;
	final int TYPE_TILE = 2;

	private JDialog thisDialog = this;
	private Surface startingSurface;
	private Surface workingSurface;
	private JTextField surfaceX;
	private JComboBox MaterialComboBox;
	private JTextField surfaceY;
	private JTextField cutoutX;
	private JTextField cutoutY;
	private JLabel lblChooseMaterial;
	private JLabel lblChooseCutoutType;
	private JComboBox CutoutTypeComboBox;
	private JLabel lblSurfaceSize;
	private JLabel lblCutoutSize;
	private JButton AddCutout;
	private JLabel lblSurfaceList;
	private JTextArea cutoutTextArea;
	private JTextField surfaceNameTextField;
	String surfaceType;
	int cutoutType; 
	private Double surfaceXdim;
	private Double surfaceYdim; 
	

	public SurfaceManager(Dialog owner, Surface s) {
		super(owner, true);
		
		
		setSize(new Dimension(700, 474));
		getContentPane().setBackground(
				UIManager.getColor("InternalFrame.activeTitleGradient"));
		getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 12));

		startingSurface = s; // holds original surface
		workingSurface = new Surface(s); // holds working copy of surface

		setTitle("Surface Manager");
		setBounds(200, 200, 700, 400);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 133, 117, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, -37, 0, 37, 87, 43, 0, 90, 30,
				30, 5, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, 1.0, 1.0,
				Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 1.0, 0.0,
				0.0, 1.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0 };
		getContentPane().setLayout(gridBagLayout);

		 
		
		String[] data = { "Trim", "Paint", "Floor Tile" };
		
		
		surfaceNameTextField = new JTextField();
		surfaceNameTextField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		surfaceNameTextField.setText("Enter Name of Surface");
		GridBagConstraints gbc_surfaceNameTextField = new GridBagConstraints();
		gbc_surfaceNameTextField.insets = new Insets(0, 0, 5, 5);
		gbc_surfaceNameTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_surfaceNameTextField.gridx = 0;
		gbc_surfaceNameTextField.gridy = 1;
		getContentPane().add(surfaceNameTextField, gbc_surfaceNameTextField);
		surfaceNameTextField.setColumns(10);
		
				lblChooseMaterial = new JLabel("Choose Material");
				lblChooseMaterial.setFont(new Font("Tahoma", Font.PLAIN, 14));
				GridBagConstraints gbc_lblChooseMaterial = new GridBagConstraints();
				gbc_lblChooseMaterial.insets = new Insets(0, 0, 5, 5);
				gbc_lblChooseMaterial.gridx = 0;
				gbc_lblChooseMaterial.gridy = 3;
				getContentPane().add(lblChooseMaterial, gbc_lblChooseMaterial);
		
				lblSurfaceSize = new JLabel("Surface Size");
				lblSurfaceSize.setFont(new Font("Tahoma", Font.PLAIN, 14));
				GridBagConstraints gbc_lblSurfaceSize = new GridBagConstraints();
				gbc_lblSurfaceSize.insets = new Insets(0, 0, 5, 5);
				gbc_lblSurfaceSize.gridx = 1;
				gbc_lblSurfaceSize.gridy = 3;
				getContentPane().add(lblSurfaceSize, gbc_lblSurfaceSize);
		
				MaterialComboBox = new JComboBox();
				MaterialComboBox.setModel(new DefaultComboBoxModel(data));
				GridBagConstraints gbc_MaterialComboBox = new GridBagConstraints();
				gbc_MaterialComboBox.insets = new Insets(0, 0, 5, 5);
				gbc_MaterialComboBox.fill = GridBagConstraints.HORIZONTAL;
				gbc_MaterialComboBox.gridx = 0;
				gbc_MaterialComboBox.gridy = 4;
				getContentPane().add(MaterialComboBox, gbc_MaterialComboBox);
		surfaceX = new JTextField();
		surfaceX.setText("Height/Legth");
		GridBagConstraints gbc_surfaceX = new GridBagConstraints();
		gbc_surfaceX.fill = GridBagConstraints.BOTH;
		gbc_surfaceX.insets = new Insets(0, 0, 5, 5);
		gbc_surfaceX.gridx = 1;
		gbc_surfaceX.gridy = 4;
		getContentPane().add(surfaceX, gbc_surfaceX);
		
				surfaceY = new JTextField();
				surfaceY.setText("Width");
				GridBagConstraints gbc_surfaceY = new GridBagConstraints();
				gbc_surfaceY.insets = new Insets(0, 0, 5, 5);
				gbc_surfaceY.fill = GridBagConstraints.HORIZONTAL;
				gbc_surfaceY.gridx = 2;
				gbc_surfaceY.gridy = 4;
				getContentPane().add(surfaceY, gbc_surfaceY);

		lblChooseCutoutType = new JLabel("Choose Cutout Type");
		lblChooseCutoutType.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblChooseCutoutType = new GridBagConstraints();
		gbc_lblChooseCutoutType.anchor = GridBagConstraints.SOUTH;
		gbc_lblChooseCutoutType.insets = new Insets(0, 0, 5, 5);
		gbc_lblChooseCutoutType.gridx = 0;
		gbc_lblChooseCutoutType.gridy = 5;
		getContentPane().add(lblChooseCutoutType, gbc_lblChooseCutoutType);

		lblCutoutSize = new JLabel("Cutout Size");
		lblCutoutSize.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblCutoutSize = new GridBagConstraints();
		gbc_lblCutoutSize.anchor = GridBagConstraints.SOUTH;
		gbc_lblCutoutSize.insets = new Insets(0, 0, 5, 5);
		gbc_lblCutoutSize.gridx = 1;
		gbc_lblCutoutSize.gridy = 5;
		getContentPane().add(lblCutoutSize, gbc_lblCutoutSize);

		/*
		 * Creates a comboBox with a list of cut out options. This list will be
		 * used to calculate the area to be removed from the surface area
		 * calculations. The surface types are 'door", "window", and "other" and
		 * this effects the amount of trim that will be uses. The "other" and
		 * "window" option will account for trim on all for sides while "door"
		 * will only calculate on 3 sides.
		 */

		CutoutTypeComboBox = new JComboBox();
		// CutoutTypeComboBox.addActionListener(new SaveCutoutListener());
		CutoutTypeComboBox.setModel(new DefaultComboBoxModel(new String[] {
				"Door", "Window", "Other" }));
		GridBagConstraints gbc_CutoutTypeComboBox = new GridBagConstraints();
		gbc_CutoutTypeComboBox.insets = new Insets(0, 0, 5, 5);
		gbc_CutoutTypeComboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_CutoutTypeComboBox.gridx = 0;
		gbc_CutoutTypeComboBox.gridy = 6;
		getContentPane().add(CutoutTypeComboBox, gbc_CutoutTypeComboBox);

		cutoutX = new JTextField();
		cutoutX.setText("Height");
		cutoutX.setColumns(10);
		GridBagConstraints gbc_cutoutX = new GridBagConstraints();
		gbc_cutoutX.insets = new Insets(0, 0, 5, 5);
		gbc_cutoutX.fill = GridBagConstraints.HORIZONTAL;
		gbc_cutoutX.gridx = 1;
		gbc_cutoutX.gridy = 6;
		getContentPane().add(cutoutX, gbc_cutoutX);

		cutoutY = new JTextField();
		cutoutY.setText("Width");
		cutoutY.setColumns(10);
		GridBagConstraints gbc_cutoutY = new GridBagConstraints();
		gbc_cutoutY.insets = new Insets(0, 0, 5, 5);
		gbc_cutoutY.fill = GridBagConstraints.HORIZONTAL;
		gbc_cutoutY.gridx = 2;
		gbc_cutoutY.gridy = 6;
		getContentPane().add(cutoutY, gbc_cutoutY);

		AddCutout = new JButton("Add Cutout");
		AddCutout.addActionListener(new SaveCutoutListener());
		AddCutout.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_AddCutout = new GridBagConstraints();
		gbc_AddCutout.insets = new Insets(0, 0, 5, 5);
		gbc_AddCutout.gridx = 0;
		gbc_AddCutout.gridy = 7;
		getContentPane().add(AddCutout, gbc_AddCutout);

		lblSurfaceList = new JLabel("Cutout List");
		lblSurfaceList.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_lblSurfaceList = new GridBagConstraints();
		gbc_lblSurfaceList.anchor = GridBagConstraints.EAST;
		gbc_lblSurfaceList.insets = new Insets(0, 0, 5, 5);
		gbc_lblSurfaceList.gridx = 1;
		gbc_lblSurfaceList.gridy = 7;
		getContentPane().add(lblSurfaceList, gbc_lblSurfaceList);

		cutoutTextArea = new JTextArea();
		cutoutTextArea.setRows(1);
		GridBagConstraints gbc_cutoutTextArea = new GridBagConstraints();
		gbc_cutoutTextArea.insets = new Insets(0, 0, 5, 5);
		gbc_cutoutTextArea.fill = GridBagConstraints.BOTH;
		gbc_cutoutTextArea.gridx = 2;
		gbc_cutoutTextArea.gridy = 7;
		getContentPane().add(cutoutTextArea, gbc_cutoutTextArea);
		
				JButton exitNoSaveButton = new JButton("Exit Without Saving");
				exitNoSaveButton.addActionListener(new ExitNoSaveListener());
				
						// Button that saves all the information gathered for the surface
						JButton saveExitButton = new JButton("Save and Exit");
						saveExitButton.addActionListener(new SaveExitListener());
						GridBagConstraints gbc_saveExitButton = new GridBagConstraints();
						gbc_saveExitButton.fill = GridBagConstraints.BOTH;
						gbc_saveExitButton.insets = new Insets(0, 0, 5, 5);
						gbc_saveExitButton.gridx = 1;
						gbc_saveExitButton.gridy = 10;
						getContentPane().add(saveExitButton, gbc_saveExitButton);
				GridBagConstraints gbc_exitNoSaveButton = new GridBagConstraints();
				gbc_exitNoSaveButton.insets = new Insets(0, 0, 5, 5);
				gbc_exitNoSaveButton.fill = GridBagConstraints.HORIZONTAL;
				gbc_exitNoSaveButton.gridx = 1;
				gbc_exitNoSaveButton.gridy = 11;
				getContentPane().add(exitNoSaveButton, gbc_exitNoSaveButton);
	}

	public Surface showDialog() {
		// TODO finish logic for surface
		this.setVisible(true);
		return startingSurface;
	}

	/*
	 * private class ModifySurfaceListener implements ActionListener { public
	 * void actionPerformed(ActionEvent e) { } } private class
	 * DeleteSurfaceListener implements ActionListener { public void
	 * actionPerformed(ActionEvent e) { } }
	 */
	// Listener for the Save cut out Button - calls the createCutout method
	public class SaveCutoutListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			// Calls createCutout method
			createCutout();
		}
	}

	// Method that is used to create the cut out dimensions. Called from the
	// SaveCutoutListener
	private void createCutout() {
		try {
		String cutoutType = (CutoutTypeComboBox.getSelectedItem().toString());
		double cutoutXdim = Double.parseDouble(cutoutX.getText());
		double cutoutYdim = Double.parseDouble(cutoutY.getText());
		cutoutTextArea.append((cutoutType) + ", Width=" + cutoutXdim
				+ ", Height=" + cutoutYdim + ": \n");
		Cutout cutout = new Cutout(cutoutType, cutoutXdim, cutoutYdim) ; 
		workingSurface.addCutout(cutout);  
		
	} // End of try block
		catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null,"Input must be a number.");
			//e.printStackTrace();
		} // End of catch NumberFormatException
		
	}

	// private class SaveEmxitListener implements ActionListener {
	// public void actionPerformed(ActionEvent e) {
	// textField.setText(studentOutputString((String)comboBox.getSelectedItem()));
	// textField.setText("BLAH");

	private class SaveExitListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			saveSurface();
		
		}

		// creates a new Surface Object
		private void saveSurface() {
			workingSurface.setName(surfaceNameTextField.getText());
			surfaceXdim = Double.parseDouble(surfaceX.getText());
			surfaceYdim = Double.parseDouble(surfaceY.getText());
			workingSurface.setSurfaceXdim(surfaceXdim);
			workingSurface.setSurfaceYdim(surfaceYdim);
			workingSurface.setSurfaceType(surfaceType); 
			startingSurface = workingSurface;
			
			thisDialog.setVisible(false);
			thisDialog.dispose();
			
			System.out.println(workingSurface.getName());
			System.out.println(workingSurface.getCutoutList()); 
			System.out.println(startingSurface.getName());
			System.out.println(startingSurface.getSurfaceYdim());
			

			
		}
	}

	private class ExitNoSaveListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			thisDialog.setVisible(false);
			thisDialog.dispose();
		}
	}
}

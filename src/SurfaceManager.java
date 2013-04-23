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
	private JButton SaveCutout;
	private JButton SaveSurface;
	private JLabel lblSurfaceList;
	private JTextArea cutoutTextArea;
	private double cutOutTotalDoor;
	private double cutOutTotalWindow;
	private JTextField surfaceNameTextField;
	String surfaceType;

	ArrayList<Surface> surfaces = new ArrayList<Surface>();

	private JTextArea surfaceTextArea;
	private JLabel lblSurfaceList_1;

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
		gridBagLayout.columnWidths = new int[] { 0, 0, 195, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, -37, 0, 0, 87, 43, 0, 90, 30,
				30, 5, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, 1.0, 1.0,
				Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 1.0, 0.0,
				0.0, 1.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0 };
		getContentPane().setLayout(gridBagLayout);

		String[] data = { "Trim", "Paint", "Floor Tile" };
		surfaceNameTextField = new JTextField();
		surfaceNameTextField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		surfaceNameTextField.setText("Enter Name for Room");
		GridBagConstraints gbc_surfaceNameTextField = new GridBagConstraints();
		gbc_surfaceNameTextField.insets = new Insets(0, 0, 5, 5);
		gbc_surfaceNameTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_surfaceNameTextField.gridx = 2;
		gbc_surfaceNameTextField.gridy = 1;
		getContentPane().add(surfaceNameTextField, gbc_surfaceNameTextField);
		surfaceNameTextField.setColumns(10);

		lblChooseMaterial = new JLabel("Choose Material");
		lblChooseMaterial.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblChooseMaterial = new GridBagConstraints();
		gbc_lblChooseMaterial.insets = new Insets(0, 0, 5, 5);
		gbc_lblChooseMaterial.gridx = 0;
		gbc_lblChooseMaterial.gridy = 2;
		getContentPane().add(lblChooseMaterial, gbc_lblChooseMaterial);

		lblSurfaceSize = new JLabel("Surface Size");
		lblSurfaceSize.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblSurfaceSize = new GridBagConstraints();
		gbc_lblSurfaceSize.insets = new Insets(0, 0, 5, 5);
		gbc_lblSurfaceSize.gridx = 1;
		gbc_lblSurfaceSize.gridy = 2;
		getContentPane().add(lblSurfaceSize, gbc_lblSurfaceSize);

		MaterialComboBox = new JComboBox();
		MaterialComboBox.setModel(new DefaultComboBoxModel(data));
		GridBagConstraints gbc_MaterialComboBox = new GridBagConstraints();
		gbc_MaterialComboBox.insets = new Insets(0, 0, 5, 5);
		gbc_MaterialComboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_MaterialComboBox.gridx = 0;
		gbc_MaterialComboBox.gridy = 3;
		getContentPane().add(MaterialComboBox, gbc_MaterialComboBox);
		surfaceX = new JTextField();
		surfaceX.setText("Height/Legth");
		GridBagConstraints gbc_surfaceX = new GridBagConstraints();
		gbc_surfaceX.fill = GridBagConstraints.BOTH;
		gbc_surfaceX.insets = new Insets(0, 0, 5, 5);
		gbc_surfaceX.gridx = 1;
		gbc_surfaceX.gridy = 3;
		getContentPane().add(surfaceX, gbc_surfaceX);

		surfaceY = new JTextField();
		surfaceY.setText("Width");
		GridBagConstraints gbc_surfaceY = new GridBagConstraints();
		gbc_surfaceY.insets = new Insets(0, 0, 5, 5);
		gbc_surfaceY.fill = GridBagConstraints.HORIZONTAL;
		gbc_surfaceY.gridx = 2;
		gbc_surfaceY.gridy = 3;
		getContentPane().add(surfaceY, gbc_surfaceY);

		SaveSurface = new JButton("Save Surface");
		SaveSurface.addActionListener(new SaveSurfaceListener());
		SaveSurface.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_SaveSurface = new GridBagConstraints();
		gbc_SaveSurface.insets = new Insets(0, 0, 5, 5);
		gbc_SaveSurface.gridx = 0;
		gbc_SaveSurface.gridy = 4;
		getContentPane().add(SaveSurface, gbc_SaveSurface);
		lblSurfaceList_1 = new JLabel("Surface List");
		GridBagConstraints gbc_lblSurfaceList_1 = new GridBagConstraints();
		gbc_lblSurfaceList_1.anchor = GridBagConstraints.EAST;
		gbc_lblSurfaceList_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblSurfaceList_1.gridx = 1;
		gbc_lblSurfaceList_1.gridy = 4;
		getContentPane().add(lblSurfaceList_1, gbc_lblSurfaceList_1);
		surfaceTextArea = new JTextArea();
		GridBagConstraints gbc_surfaceTextArea = new GridBagConstraints();
		gbc_surfaceTextArea.insets = new Insets(0, 0, 5, 5);
		gbc_surfaceTextArea.fill = GridBagConstraints.BOTH;
		gbc_surfaceTextArea.gridx = 2;
		gbc_surfaceTextArea.gridy = 4;
		getContentPane().add(surfaceTextArea, gbc_surfaceTextArea);

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

		SaveCutout = new JButton("Save Cutout");
		SaveCutout.addActionListener(new SaveCutoutListener());
		SaveCutout.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_SaveCutout = new GridBagConstraints();
		gbc_SaveCutout.insets = new Insets(0, 0, 5, 5);
		gbc_SaveCutout.gridx = 0;
		gbc_SaveCutout.gridy = 7;
		getContentPane().add(SaveCutout, gbc_SaveCutout);

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
		Component verticalStrut = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut = new GridBagConstraints();
		gbc_verticalStrut.fill = GridBagConstraints.HORIZONTAL;
		gbc_verticalStrut.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut.gridx = 1;
		gbc_verticalStrut.gridy = 10;
		getContentPane().add(verticalStrut, gbc_verticalStrut);

		// Button that saves all the information gathered for the surface
		JButton saveExitButton = new JButton("Save and Exit");
		saveExitButton.addActionListener(new SaveExitListener());
		GridBagConstraints gbc_saveExitButton = new GridBagConstraints();
		gbc_saveExitButton.fill = GridBagConstraints.BOTH;
		gbc_saveExitButton.insets = new Insets(0, 0, 5, 5);
		gbc_saveExitButton.gridx = 1;
		gbc_saveExitButton.gridy = 11;
		getContentPane().add(saveExitButton, gbc_saveExitButton);

		JButton exitNoSaveButton = new JButton("Exit Without Saving");
		exitNoSaveButton.addActionListener(new ExitNoSaveListener());
		GridBagConstraints gbc_exitNoSaveButton = new GridBagConstraints();
		gbc_exitNoSaveButton.insets = new Insets(0, 0, 5, 5);
		gbc_exitNoSaveButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_exitNoSaveButton.gridx = 1;
		gbc_exitNoSaveButton.gridy = 12;
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
		Double cutoutXdim = Double.parseDouble(cutoutX.getText());
		Double cutoutYdim = Double.parseDouble(cutoutY.getText());
		cutoutTextArea.append((cutoutType) + ", Width=" + cutoutXdim
				+ ", Height=" + cutoutYdim + ": \n");
	} // End of try block
		catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null,"Input must be a number.");
			//e.printStackTrace();
		} // End of catch NumberFormatException
		
	}
	public class SaveSurfaceListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			// Calls createCutout method
			createSurface();
		}

	}

	private void createSurface() {

		try {
			surfaceType = (MaterialComboBox.getSelectedItem().toString());
			Double surfaceXdim = Double.parseDouble(surfaceX.getText());
			Double surfaceYdim = Double.parseDouble(surfaceY.getText());
			surfaceTextArea.append((surfaceType) + ", Width=" + surfaceXdim
					+ ", Height=" + surfaceYdim + ": \n");

		} // End of try block

		catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Input must be a number.");
			// e.printStackTrace();
		} // End of catch NumberFormatException

	}

	// private class SaveEmxitListener implements ActionListener {
	// public void actionPerformed(ActionEvent e) {
	// textField.setText(studentOutputString((String)comboBox.getSelectedItem()));
	// textField.setText("BLAH");

	private class SaveExitListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			workingSurface.setName(surfaceNameTextField.getText());
			startingSurface = workingSurface;
			saveSurface();
			thisDialog.setVisible(false);
			thisDialog.dispose();
		}

		// creates a new Surface Object
		private void saveSurface() {
			if (MaterialComboBox.getSelectedItem().toString().equals("Trim")) {
				Surface st = new Surface(TYPE_TRIM, 7);
				surfaces.add(st);
				System.out.println(cutOutTotalDoor);
				System.out.println(cutOutTotalWindow);
				System.out.println(surfaces.get(0).toString());

			}

		}
	}

	private class ExitNoSaveListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			thisDialog.setVisible(false);
			thisDialog.dispose();
		}
	}
}

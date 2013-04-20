import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
	
	
	public class SurfaceManager extends JDialog {
			
private JDialog thisDialog = this;
private JTextField lengthTextField;
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
private JLabel lblSurfaceList;
private JTextArea textArea;
double cutOutTotalDoor; 
double cutOutTotalWindow; 

public SurfaceManager(Dialog owner, Surface s) {
super(owner, true);
getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 12));

startingSurface = s; //holds original surface
workingSurface = new Surface(s); //holds working copy of surface

setTitle("Surface Manager");
setBounds(200, 200, 700, 400);
GridBagLayout gridBagLayout = new GridBagLayout();
gridBagLayout.columnWidths = new int[]{0, 0, 0, 0};
gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 43, 0, 90, 0, 0, 0, 0, 0, 0};
gridBagLayout.columnWeights = new double[]{1.0, 0.0, 1.0, Double.MIN_VALUE};
gridBagLayout.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
getContentPane().setLayout(gridBagLayout);

String[] data = {"Trim", "Paint", "Floor Tile"};

lengthTextField = new JTextField();
lengthTextField.setText("Length"); 
GridBagConstraints gbc_lengthTextField = new GridBagConstraints();
lengthTextField.addActionListener(new lengthTextFieldListener());
gbc_lengthTextField.anchor = GridBagConstraints.NORTHWEST;
gbc_lengthTextField.insets = new Insets(0, 110, 77,110);
gbc_lengthTextField.gridx = 3;
gbc_lengthTextField.gridy = 0;
getContentPane().add(lengthTextField, gbc_lengthTextField);
lengthTextField.setColumns(10);
lengthTextField.setColumns(10);

lblChooseMaterial = new JLabel("Choose Material");
lblChooseMaterial.setFont(new Font("Tahoma", Font.PLAIN, 14));
GridBagConstraints gbc_lblChooseMaterial = new GridBagConstraints();
gbc_lblChooseMaterial.insets = new Insets(0, 0, 5, 5);
gbc_lblChooseMaterial.gridx = 0;
gbc_lblChooseMaterial.gridy = 1;
getContentPane().add(lblChooseMaterial, gbc_lblChooseMaterial);

lblSurfaceSize = new JLabel("Surface Size");
lblSurfaceSize.setFont(new Font("Tahoma", Font.PLAIN, 14));
GridBagConstraints gbc_lblSurfaceSize = new GridBagConstraints();
gbc_lblSurfaceSize.insets = new Insets(0, 0, 5, 5);
gbc_lblSurfaceSize.gridx = 1;
gbc_lblSurfaceSize.gridy = 1;
getContentPane().add(lblSurfaceSize, gbc_lblSurfaceSize);

MaterialComboBox = new JComboBox();
GridBagConstraints gbc_MaterialComboBox = new GridBagConstraints();
gbc_MaterialComboBox.insets = new Insets(0, 0, 5, 5);
gbc_MaterialComboBox.fill = GridBagConstraints.HORIZONTAL;
gbc_MaterialComboBox.gridx = 0;
gbc_MaterialComboBox.gridy = 2;
getContentPane().add(MaterialComboBox, gbc_MaterialComboBox);
surfaceX = new JTextField();
surfaceX.setText("Height/Legth");
GridBagConstraints gbc_surfaceX = new GridBagConstraints();
gbc_surfaceX.fill = GridBagConstraints.BOTH;
gbc_surfaceX.insets = new Insets(0, 0, 5, 5);
gbc_surfaceX.gridx = 1;
gbc_surfaceX.gridy = 2;
getContentPane().add(surfaceX, gbc_surfaceX);

surfaceY = new JTextField();
surfaceY.setText("Width");
GridBagConstraints gbc_surfaceY = new GridBagConstraints();
gbc_surfaceY.insets = new Insets(0, 0, 5, 5);
gbc_surfaceY.fill = GridBagConstraints.HORIZONTAL;
gbc_surfaceY.gridx = 2;
gbc_surfaceY.gridy = 2;
getContentPane().add(surfaceY, gbc_surfaceY);

lblChooseCutoutType = new JLabel("Choose Cutout Type");
lblChooseCutoutType.setFont(new Font("Tahoma", Font.PLAIN, 14));
GridBagConstraints gbc_lblChooseCutoutType = new GridBagConstraints();
gbc_lblChooseCutoutType.anchor = GridBagConstraints.SOUTH;
gbc_lblChooseCutoutType.insets = new Insets(0, 0, 5, 5);
gbc_lblChooseCutoutType.gridx = 0;
gbc_lblChooseCutoutType.gridy = 4;
getContentPane().add(lblChooseCutoutType, gbc_lblChooseCutoutType);

lblCutoutSize = new JLabel("Cutout Size");
lblCutoutSize.setFont(new Font("Tahoma", Font.PLAIN, 14));
GridBagConstraints gbc_lblCutoutSize = new GridBagConstraints();
gbc_lblCutoutSize.anchor = GridBagConstraints.SOUTH;
gbc_lblCutoutSize.insets = new Insets(0, 0, 5, 5);
gbc_lblCutoutSize.gridx = 1;
gbc_lblCutoutSize.gridy = 4;
getContentPane().add(lblCutoutSize, gbc_lblCutoutSize);

/* 
Creates a comboBox with a list of cut out options.  This list will  be used to calculate the area to be removed from the surface 
area calculations.  The surface types are 'door", "window", and "other" and this effects the amount of trim that will be uses.  The 
"other" and "window" option will account for trim on all for sides while "door" will only calculate on 3 sides.  
*/

CutoutTypeComboBox = new JComboBox();
//CutoutTypeComboBox.addActionListener(new SaveCutoutListener());
CutoutTypeComboBox.setModel(new DefaultComboBoxModel(new String[] {"Door", "Window", "Other"}));
GridBagConstraints gbc_CutoutTypeComboBox = new GridBagConstraints();
gbc_CutoutTypeComboBox.insets = new Insets(0, 0, 5, 5);
gbc_CutoutTypeComboBox.fill = GridBagConstraints.HORIZONTAL;
gbc_CutoutTypeComboBox.gridx = 0;
gbc_CutoutTypeComboBox.gridy = 5;
getContentPane().add(CutoutTypeComboBox, gbc_CutoutTypeComboBox);

cutoutX = new JTextField();
cutoutX.setText("Height");
cutoutX.setColumns(10);
GridBagConstraints gbc_cutoutX = new GridBagConstraints();
gbc_cutoutX.insets = new Insets(0, 0, 5, 5);
gbc_cutoutX.fill = GridBagConstraints.HORIZONTAL;
gbc_cutoutX.gridx = 1;
gbc_cutoutX.gridy = 5;
getContentPane().add(cutoutX, gbc_cutoutX);

cutoutY = new JTextField();
cutoutY.setText("Width");
cutoutY.setColumns(10);
GridBagConstraints gbc_cutoutY = new GridBagConstraints();
gbc_cutoutY.insets = new Insets(0, 0, 5, 5);
gbc_cutoutY.fill = GridBagConstraints.HORIZONTAL;
gbc_cutoutY.gridx = 2;
gbc_cutoutY.gridy = 5;
getContentPane().add(cutoutY, gbc_cutoutY);

SaveCutout = new JButton("Save Cutout");
SaveCutout.addActionListener(new SaveCutoutListener());
SaveCutout.setFont(new Font("Tahoma", Font.PLAIN, 12));
GridBagConstraints gbc_SaveCutout = new GridBagConstraints();
gbc_SaveCutout.insets = new Insets(0, 0, 5, 5);
gbc_SaveCutout.gridx = 0;
gbc_SaveCutout.gridy = 6;
getContentPane().add(SaveCutout, gbc_SaveCutout);

lblSurfaceList = new JLabel("Cutout List");
lblSurfaceList.setFont(new Font("Tahoma", Font.PLAIN, 12));
GridBagConstraints gbc_lblSurfaceList = new GridBagConstraints();
gbc_lblSurfaceList.anchor = GridBagConstraints.EAST;
gbc_lblSurfaceList.insets = new Insets(0, 0, 5, 5);
gbc_lblSurfaceList.gridx = 1;
gbc_lblSurfaceList.gridy = 6;
getContentPane().add(lblSurfaceList, gbc_lblSurfaceList);

textArea = new JTextArea();
GridBagConstraints gbc_textArea = new GridBagConstraints();
gbc_textArea.insets = new Insets(0, 0, 5, 5);
gbc_textArea.fill = GridBagConstraints.BOTH;
gbc_textArea.gridx = 2;
gbc_textArea.gridy = 6;
getContentPane().add(textArea, gbc_textArea);
Component verticalStrut = Box.createVerticalStrut(20);
GridBagConstraints gbc_verticalStrut = new GridBagConstraints();
gbc_verticalStrut.fill = GridBagConstraints.HORIZONTAL;
gbc_verticalStrut.insets = new Insets(0, 0, 5, 5);
gbc_verticalStrut.gridx = 1;
gbc_verticalStrut.gridy = 9;
getContentPane().add(verticalStrut, gbc_verticalStrut);

//Saves all the information gathered for the surface
JButton saveExitButton = new JButton("Save and Exit");
saveExitButton.addActionListener(new SaveExitListener());
GridBagConstraints gbc_saveExitButton = new GridBagConstraints();
gbc_saveExitButton.fill = GridBagConstraints.HORIZONTAL;
gbc_saveExitButton.insets = new Insets(0, 0, 5, 5);
gbc_saveExitButton.gridx = 1;
gbc_saveExitButton.gridy = 10;
getContentPane().add(saveExitButton, gbc_saveExitButton);

JButton exitNoSaveButton = new JButton("Exit Without Saving");
exitNoSaveButton.addActionListener(new ExitNoSaveListener());
GridBagConstraints gbc_exitNoSaveButton = new GridBagConstraints();
gbc_exitNoSaveButton.insets = new Insets(0, 0, 0, 5);
gbc_exitNoSaveButton.fill = GridBagConstraints.HORIZONTAL;
gbc_exitNoSaveButton.anchor = GridBagConstraints.NORTH;
gbc_exitNoSaveButton.gridx = 1;
gbc_exitNoSaveButton.gridy = 11;
getContentPane().add(exitNoSaveButton, gbc_exitNoSaveButton);
}
public Surface showDialog() {
// TODO finish logic for surface
this.setVisible(true);
return startingSurface;
}
private class lengthTextFieldListener implements ActionListener {
public void actionPerformed(ActionEvent e) {
System.out.println("Text= " + lengthTextField.getText());
}
}
/*
private class ModifySurfaceListener implements ActionListener {
public void actionPerformed(ActionEvent e) {
}
}
private class DeleteSurfaceListener implements ActionListener {
public void actionPerformed(ActionEvent e) {
}
}
*/

public class SaveCutoutListener implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		// Calls createCutout method 
		createCutout(); 
   }

	// Method that is used to create the cutout dimensions.   Called from the SaveCutoutListener
private void createCutout() {
	String cutoutType  = (CutoutTypeComboBox.getSelectedItem().toString()); 
	Double cutoutXdim = Double.parseDouble(cutoutX.getText()) ; 
	Double cutoutYdim = Double.parseDouble(cutoutY.getText()) ; 
	 double cutoutSize = 0; 
	 if (cutoutType.equals("Door")) {
	 	 cutoutSize = cutoutXdim * cutoutYdim ;
	 	 textArea.append((cutoutType)+"= " + cutoutSize + " Sqft" + ": \n") ; 
	 	 cutOutTotalDoor =  cutOutTotalDoor + cutoutSize ; 
	 	
	 }
	 else {
		 cutoutSize = cutoutXdim * cutoutYdim ;
	 	 textArea.append((cutoutType)+"= " + cutoutSize + " Sqft" + ": \n") ; 
	 	 cutOutTotalWindow = cutOutTotalWindow + cutoutSize; 
	 	
		  }
}

   
}
//private class SaveEmxitListener implements ActionListener  {
// public void actionPerformed(ActionEvent e) {
//  textField.setText(studentOutputString((String)comboBox.getSelectedItem()));
//  textField.setText("BLAH");


private class SaveExitListener implements ActionListener {
public void actionPerformed(ActionEvent e) {
//workingSurface.setName(surfaceNameTextField.getText());
startingSurface = workingSurface;
System.out.println(cutOutTotalDoor);
System.out.println(cutOutTotalWindow);
thisDialog.setVisible(false);
thisDialog.dispose();
}
}
private class ExitNoSaveListener implements ActionListener {
public void actionPerformed(ActionEvent e) {
thisDialog.setVisible(false);
thisDialog.dispose();
}
}
}






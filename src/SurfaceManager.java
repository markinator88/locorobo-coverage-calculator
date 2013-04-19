import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class SurfaceManager extends JDialog {
	
	private JDialog thisDialog = this;
	private JTextField lengthTextField;
	private Surface startingSurface;
	private Surface workingSurface;
	private JTextField txtLength;
	private JComboBox comboBox;
	private JTextField txtWidth;
	private JTextField txtHeight;
	private JTextField textField_3;
	private JLabel lblChooseMaterial;
	private JLabel lblChooseCutoutType;
	private JComboBox comboBox_1;
	private JLabel lblSurfaceSize;
	private JLabel lblCutoutSize;
	private JButton btnSaveSurface;
	private JLabel lblSurfaceList;
	private JList list;
	
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
		
		comboBox = new JComboBox();
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 0;
		gbc_comboBox.gridy = 2;
		getContentPane().add(comboBox, gbc_comboBox);
		
		txtLength = new JTextField();
		txtLength.setText("Height/Legth");
		GridBagConstraints gbc_txtLength = new GridBagConstraints();
		gbc_txtLength.fill = GridBagConstraints.BOTH;
		gbc_txtLength.insets = new Insets(0, 0, 5, 5);
		gbc_txtLength.gridx = 1;
		gbc_txtLength.gridy = 2;
		getContentPane().add(txtLength, gbc_txtLength);
		
		txtWidth = new JTextField();
		txtWidth.setText("Width");
		GridBagConstraints gbc_txtWidth = new GridBagConstraints();
		gbc_txtWidth.insets = new Insets(0, 0, 5, 5);
		gbc_txtWidth.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtWidth.gridx = 2;
		gbc_txtWidth.gridy = 2;
		getContentPane().add(txtWidth, gbc_txtWidth);
		
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
		
		comboBox_1 = new JComboBox();
		GridBagConstraints gbc_comboBox_1 = new GridBagConstraints();
		gbc_comboBox_1.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_1.gridx = 0;
		gbc_comboBox_1.gridy = 5;
		getContentPane().add(comboBox_1, gbc_comboBox_1);
		
		txtHeight = new JTextField();
		txtHeight.setText("Height");
		txtHeight.setColumns(10);
		GridBagConstraints gbc_txtHeight = new GridBagConstraints();
		gbc_txtHeight.insets = new Insets(0, 0, 5, 5);
		gbc_txtHeight.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtHeight.gridx = 1;
		gbc_txtHeight.gridy = 5;
		getContentPane().add(txtHeight, gbc_txtHeight);
		
		textField_3 = new JTextField();
		textField_3.setText("Width");
		textField_3.setColumns(10);
		GridBagConstraints gbc_textField_3 = new GridBagConstraints();
		gbc_textField_3.insets = new Insets(0, 0, 5, 5);
		gbc_textField_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_3.gridx = 2;
		gbc_textField_3.gridy = 5;
		getContentPane().add(textField_3, gbc_textField_3);
		
		btnSaveSurface = new JButton("Save Cutout");
		btnSaveSurface.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_btnSaveSurface = new GridBagConstraints();
		gbc_btnSaveSurface.insets = new Insets(0, 0, 5, 5);
		gbc_btnSaveSurface.gridx = 0;
		gbc_btnSaveSurface.gridy = 6;
		getContentPane().add(btnSaveSurface, gbc_btnSaveSurface);
		
		lblSurfaceList = new JLabel("Cutout List");
		lblSurfaceList.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_lblSurfaceList = new GridBagConstraints();
		gbc_lblSurfaceList.anchor = GridBagConstraints.EAST;
		gbc_lblSurfaceList.insets = new Insets(0, 0, 5, 5);
		gbc_lblSurfaceList.gridx = 1;
		gbc_lblSurfaceList.gridy = 6;
		getContentPane().add(lblSurfaceList, gbc_lblSurfaceList);
		
		list = new JList();
		GridBagConstraints gbc_list = new GridBagConstraints();
		gbc_list.insets = new Insets(0, 0, 5, 5);
		gbc_list.fill = GridBagConstraints.BOTH;
		gbc_list.gridx = 2;
		gbc_list.gridy = 6;
		getContentPane().add(list, gbc_list);
		Component verticalStrut = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut = new GridBagConstraints();
		gbc_verticalStrut.fill = GridBagConstraints.HORIZONTAL;
		gbc_verticalStrut.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut.gridx = 1;
		gbc_verticalStrut.gridy = 9;
		getContentPane().add(verticalStrut, gbc_verticalStrut);
		
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
	private class SaveExitListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			//workingSurface.setName(surfaceNameTextField.getText());
			startingSurface = workingSurface;
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



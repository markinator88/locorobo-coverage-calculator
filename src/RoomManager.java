import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RoomManager extends JDialog {
	
	private JTextField roomNameTextField;
	private JList surfaceListBox;
	private Room workingRoom = new Room();
	
	public RoomManager(Frame owner, Room r) {
		super(owner,true);
		workingRoom = r;
		
		setTitle("Room Manager");
		setBounds(200, 200, 520, 324);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		JButton newSurfaceButton = new JButton("New Surface");
		newSurfaceButton.addActionListener(new NewSurfaceListener());
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridheight = 7;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 0;
		getContentPane().add(scrollPane, gbc_scrollPane);
		
		surfaceListBox = new JList();
		scrollPane.setViewportView(surfaceListBox);
		//getContentPane().add(surfaceListBox);
		
		roomNameTextField = new JTextField();
		GridBagConstraints gbc_roomNameTextField = new GridBagConstraints();
		gbc_roomNameTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_roomNameTextField.anchor = GridBagConstraints.SOUTH;
		gbc_roomNameTextField.insets = new Insets(0, 0, 5, 0);
		gbc_roomNameTextField.gridx = 1;
		gbc_roomNameTextField.gridy = 0;
		getContentPane().add(roomNameTextField, gbc_roomNameTextField);
		roomNameTextField.setColumns(10);
		GridBagConstraints gbc_newSurfaceButton = new GridBagConstraints();
		gbc_newSurfaceButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_newSurfaceButton.insets = new Insets(0, 0, 5, 0);
		gbc_newSurfaceButton.gridx = 1;
		gbc_newSurfaceButton.gridy = 1;
		getContentPane().add(newSurfaceButton, gbc_newSurfaceButton);
		
		JButton modifySurfaceButton = new JButton("Modify Surface");
		modifySurfaceButton.addActionListener(new ModifySurfaceListener());
		GridBagConstraints gbc_modifySurfaceButton = new GridBagConstraints();
		gbc_modifySurfaceButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_modifySurfaceButton.insets = new Insets(0, 0, 5, 0);
		gbc_modifySurfaceButton.gridx = 1;
		gbc_modifySurfaceButton.gridy = 2;
		getContentPane().add(modifySurfaceButton, gbc_modifySurfaceButton);
		
		JButton deleteSurfaceButton = new JButton("Delete Surface");
		deleteSurfaceButton.addActionListener(new DeleteSurfaceListener());
		GridBagConstraints gbc_deleteSurfaceButton = new GridBagConstraints();
		gbc_deleteSurfaceButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_deleteSurfaceButton.insets = new Insets(0, 0, 5, 0);
		gbc_deleteSurfaceButton.gridx = 1;
		gbc_deleteSurfaceButton.gridy = 3;
		getContentPane().add(deleteSurfaceButton, gbc_deleteSurfaceButton);
		
		Component verticalStrut = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut = new GridBagConstraints();
		gbc_verticalStrut.insets = new Insets(0, 0, 5, 0);
		gbc_verticalStrut.gridx = 1;
		gbc_verticalStrut.gridy = 4;
		getContentPane().add(verticalStrut, gbc_verticalStrut);
		
		JButton saveExitButton = new JButton("Save and Exit");
		saveExitButton.addActionListener(new SaveExitListener());
		GridBagConstraints gbc_saveExitButton = new GridBagConstraints();
		gbc_saveExitButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_saveExitButton.insets = new Insets(0, 0, 5, 0);
		gbc_saveExitButton.gridx = 1;
		gbc_saveExitButton.gridy = 5;
		getContentPane().add(saveExitButton, gbc_saveExitButton);
		
		JButton exitNoSaveButton = new JButton("Exit Without Saving");
		exitNoSaveButton.addActionListener(new ExitNoSaveListener());
		GridBagConstraints gbc_exitNoSaveButton = new GridBagConstraints();
		gbc_exitNoSaveButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_exitNoSaveButton.anchor = GridBagConstraints.NORTH;
		gbc_exitNoSaveButton.gridx = 1;
		gbc_exitNoSaveButton.gridy = 6;
		getContentPane().add(exitNoSaveButton, gbc_exitNoSaveButton);
	}

	private class NewSurfaceListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			//SurfaceManager dialog = new SurfaceManager(workingRoom.getSurfaceAtIndex(surfaceListBox.getSelectedIndex()));
			//dialog.setVisible(true);			
		}
	}
	private class ModifySurfaceListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
		}
	}
	private class DeleteSurfaceListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
		}
	}
	private class SaveExitListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
		}
	}
	private class ExitNoSaveListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
		}
	}
}

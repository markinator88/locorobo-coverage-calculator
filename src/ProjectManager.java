import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;

/**
 * GUI components allowing the user to view and modify the project 
 */
public class ProjectManager extends JFrame {
	
	private Project project;
	JFrame thisFrame = this;
	JList roomListBox;
	JButton newRoomButton;
	JButton modifyRoomButton;
	JButton deleteRoomButton;
	JButton createReportButton;
	
	/**
	 * creates a GUI interface for viewing and modifying the specified project
	 * @param p project to be modified
	 */
	public ProjectManager(Project p) {
		this.project = p;
		
		setTitle("Coverage Calculator - Project Manager");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 300);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridheight = 4;
		gbc_scrollPane.insets = new Insets(0, 0, 0, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 0;
		getContentPane().add(scrollPane, gbc_scrollPane);
		
		roomListBox = new JList(project.toStringArray());
		roomListBox.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(roomListBox);
		
		newRoomButton = new JButton("New Room");
		newRoomButton.addActionListener(new NewRoomListener());
		GridBagConstraints gbc_newRoomButton = new GridBagConstraints();
		gbc_newRoomButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_newRoomButton.anchor = GridBagConstraints.SOUTH;
		gbc_newRoomButton.insets = new Insets(0, 0, 5, 0);
		gbc_newRoomButton.gridx = 1;
		gbc_newRoomButton.gridy = 0;
		getContentPane().add(newRoomButton, gbc_newRoomButton);
		
		modifyRoomButton = new JButton("Modify Room");
		modifyRoomButton.addActionListener(new ModifyRoomListener());
		GridBagConstraints gbc_modifyRoomButton = new GridBagConstraints();
		gbc_modifyRoomButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_modifyRoomButton.insets = new Insets(0, 0, 5, 0);
		gbc_modifyRoomButton.gridx = 1;
		gbc_modifyRoomButton.gridy = 1;
		getContentPane().add(modifyRoomButton, gbc_modifyRoomButton);
		
		deleteRoomButton = new JButton("Delete Room");
		deleteRoomButton.addActionListener(new DeleteRoomListener());
		GridBagConstraints gbc_deleteRoomButton = new GridBagConstraints();
		gbc_deleteRoomButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_deleteRoomButton.insets = new Insets(0, 0, 5, 0);
		gbc_deleteRoomButton.gridx = 1;
		gbc_deleteRoomButton.gridy = 2;
		getContentPane().add(deleteRoomButton, gbc_deleteRoomButton);
		
		JButton createReportButton = new JButton("Create Report");
		createReportButton.addActionListener(new CreateReportListener());
		GridBagConstraints gbc_createReportButton = new GridBagConstraints();
		gbc_createReportButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_createReportButton.anchor = GridBagConstraints.NORTH;
		gbc_createReportButton.gridx = 1;
		gbc_createReportButton.gridy = 3;
		getContentPane().add(createReportButton, gbc_createReportButton);
		
	/**
	 * method used to update data displayed in the list of rooms every time the list is modified	
	 */
	}
	private void updateList() {
		roomListBox.setListData(project.toStringArray());
		this.validate();
	}
	
	/**
	 * listens for button press of the new room button
	 */
	private class NewRoomListener implements ActionListener {
		/**
		 * creates a new room and opens the room manager to modify that room
		 */
		public void actionPerformed(ActionEvent e) {
			RoomManager dialog = new RoomManager(thisFrame, new Room());
			Room result = dialog.showDialog();
			project.addRoom(result);
			updateList();
		}
	}
	/**
	 * listens for button press of the modify room button
	 */
	private class ModifyRoomListener implements ActionListener {
		/**
		 * opens the selected room for modification in the room manager
		 */
		public void actionPerformed(ActionEvent e) {
			RoomManager dialog = new RoomManager(thisFrame, project.getRoomAtIndex(roomListBox.getSelectedIndex()));
			Room result = dialog.showDialog();
			project.replaceRoom(roomListBox.getSelectedIndex(), result);
			updateList();
		}
	}
	
	/**
	 * listens for button press of the modify room button
	 */
	private class DeleteRoomListener implements ActionListener {
		/**
		 * prompts for deletion of selected room
		 */
		public void actionPerformed(ActionEvent e) {
			if (JOptionPane.showConfirmDialog(
					null,
					"Are you sure you want to delete the selected surface?",
					"Delete",
					JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION) {
					project.removeRoom(roomListBox.getSelectedIndex());
				} // else do nothing
			updateList();
		}
	}
	/** 
	 * listens for button press of create report button
	 */
	private class CreateReportListener implements ActionListener {
		/**
		 * creates a report of the project
		 */
		public void actionPerformed(ActionEvent e) {
			ProjectReport dialog = new ProjectReport(project);
			dialog.setVisible(true);
			// TODO code for event
			// should open report selection screen
		}
	}
}

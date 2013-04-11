import javax.swing.*;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class ProjectManager extends JFrame {
	
	private Project project = new Project();
	
	public ProjectManager() {
		setTitle("Coverage Calculator - Project Manager");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 520, 295);
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
		
		JList roomListBox = new JList();
		scrollPane.setViewportView(roomListBox);
		
		JButton newRoomButton = new JButton("New Room");
		newRoomButton.addActionListener(new NewRoomListener());
		GridBagConstraints gbc_newRoomButton = new GridBagConstraints();
		gbc_newRoomButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_newRoomButton.anchor = GridBagConstraints.SOUTH;
		gbc_newRoomButton.insets = new Insets(0, 0, 5, 0);
		gbc_newRoomButton.gridx = 1;
		gbc_newRoomButton.gridy = 0;
		getContentPane().add(newRoomButton, gbc_newRoomButton);
		
		JButton modifyRoomButton = new JButton("Modify Room");
		modifyRoomButton.addActionListener(new ModifyRoomListener());
		GridBagConstraints gbc_modifyRoomButton = new GridBagConstraints();
		gbc_modifyRoomButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_modifyRoomButton.insets = new Insets(0, 0, 5, 0);
		gbc_modifyRoomButton.gridx = 1;
		gbc_modifyRoomButton.gridy = 1;
		getContentPane().add(modifyRoomButton, gbc_modifyRoomButton);
		
		JButton deleteRoomButton = new JButton("Delete Room");
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
	}
	
	private class NewRoomListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			// TODO code for event
			// should add new room to list and maybe open modification screen
		}
	}
	private class ModifyRoomListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			// TODO code for event
			// should open selected room in RoomManager for modification
		}
	}
	private class DeleteRoomListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			// TODO code for event
			// should delete selected room
		}
	}
	private class CreateReportListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			// TODO code for event
			// should open report selection screen
		}
	}
}

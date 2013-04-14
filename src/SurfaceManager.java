import javax.swing.*;


import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SurfaceManager extends JDialog {
	
	public SurfaceManager() {
		setTitle("Surface Manager");
		setBounds(200, 200, 520, 295);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridheight = 7;
		gbc_scrollPane.insets = new Insets(0, 0, 0, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 0;
		getContentPane().add(scrollPane, gbc_scrollPane);
		
		String[] data = {"Trim", "Paint", "Floor Tile"};
		JList surfaceListBox = new JList(data);
		scrollPane.setViewportView(surfaceListBox);
		
		
		
			
		JButton newTrimButton = new JButton("Add Trim");
		newTrimButton.addActionListener(new NewTrimListener());
		GridBagConstraints gbc_newTrimButton = new GridBagConstraints();
		gbc_newTrimButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_newTrimButton.insets = new Insets(0, 0, 5, 0);
		gbc_newTrimButton.gridx = 1;
		gbc_newTrimButton.gridy = 1;
		getContentPane().add(newTrimButton, gbc_newTrimButton);
		
		/* JButton newSurfaceButton = new JButton("Add Tile Flooring");
		newSurfaceButton.addActionListener(new NewTileListener());
		GridBagConstraints gbc_TileButton = new GridBagConstraints();
		gbc_newSurfaceButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_newSurfaceButton.insets = new Insets(0, 0, 5, 0);
		gbc_newSurfaceButton.gridx = 1;
		gbc_newSurfaceButton.gridy = 1;
		getContentPane().add(newTileButton, gbc_newTileButton); */
		
		JButton modifySurfaceButton = new JButton("Add Paint");
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

	private class NewTrimListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
            JTextArea textArea = new JTextArea();
            textArea.setEditable(true);
            JScrollPane scrollPane = new JScrollPane(textArea);
            scrollPane.requestFocus();
            textArea.requestFocusInWindow();
            scrollPane.setPreferredSize(new Dimension(800, 600));
            JOptionPane.showMessageDialog(scrollPane,
                    "Paste Info");
            String info = textArea.getText();		
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



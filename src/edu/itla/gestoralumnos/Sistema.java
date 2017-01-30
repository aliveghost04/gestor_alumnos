package edu.itla.gestoralumnos;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

import edu.itla.gestoralumnos.iu.InterfazPrincipal;

public class Sistema {
	
	public static void main(String[] args) {
		
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(),
					"Error", JOptionPane.ERROR_MESSAGE);
		}
		new InterfazPrincipal().setVisible(true);
	}
}

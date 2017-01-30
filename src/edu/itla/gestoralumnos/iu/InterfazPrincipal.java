package edu.itla.gestoralumnos.iu;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JLayeredPane;
import javax.swing.border.TitledBorder;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;

import edu.itla.gestoralumnos.bd.Conexion;
import edu.itla.gestoralumnos.bd.Consulta;
import edu.itla.gestoralumnos.entidades.Alumno;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class InterfazPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNombreAltas;
	private JTextField txtApellidoAltas;
	private JTextField txtEdadAltas;
	private JTextField txtCalleAltas;
	private JTextField txtNumeroAltas;
	private JTextField txtCodigoPostalAltas;
	private JTextField txtNombreBajas;
	private JTextField txtApellidosBajas;
	private JTextField txtEdadBajas;
	private JTextField txtCalleBajas;
	private JTextField txtNumeroBajas;
	private JTextField txtCodigoPostalBajas;
	private JTextField txtNombreModificaciones;
	private JTextField txtApellidosModificaciones;
	private JTextField txtEdadModificaciones;
	private JTextField txtCalleModificaciones;
	private JTextField txtNumeroModificaciones;
	private JTextField txtCodigoPostalModificaciones;
	private JTextField txtClaveAltas;
	private JComboBox<String> cbClaveModificaciones;
	private JComboBox<String> cbClaveBajas;
	private Consulta consulta;
	private ResultSet rs;

	public InterfazPrincipal() {
		
		try {
			consulta = Consulta.getInstancia();
		} catch (Exception e) {
			mensajeError(e);
			System.exit(0);
		}
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 330, 405);
		setTitle("Gestión de Alumnos");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		final JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 295, 350);
		contentPane.add(tabbedPane);
		
		JLayeredPane layeredPaneAltas = new JLayeredPane();
		tabbedPane.addTab("Altas", null, layeredPaneAltas, null);
		
		JPanel pnlDatosPersonalesAltas = new JPanel();
		pnlDatosPersonalesAltas.setBorder(new TitledBorder(null, "Datos Personales:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlDatosPersonalesAltas.setBounds(10, 11, 270, 128);
		layeredPaneAltas.add(pnlDatosPersonalesAltas);
		pnlDatosPersonalesAltas.setLayout(null);
		
		JLabel lblClave = new JLabel("Clave:");
		lblClave.setBounds(22, 20, 46, 14);
		pnlDatosPersonalesAltas.add(lblClave);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(22, 45, 46, 14);
		pnlDatosPersonalesAltas.add(lblNombre);
		
		JLabel lblApellidos = new JLabel("Apellidos:");
		lblApellidos.setBounds(22, 70, 46, 14);
		pnlDatosPersonalesAltas.add(lblApellidos);
		
		JLabel lblEdad = new JLabel("Edad:");
		lblEdad.setBounds(22, 95, 46, 14);
		pnlDatosPersonalesAltas.add(lblEdad);
		
		txtClaveAltas = new JTextField();
		txtClaveAltas.setBounds(122, 17, 138, 20);
		txtClaveAltas.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				if(txtClaveAltas.getText().length() == 4) {
					e.consume();
				} 
			}
		});
		pnlDatosPersonalesAltas.add(txtClaveAltas);
		
		txtNombreAltas = new JTextField();
		txtNombreAltas.setColumns(10);
		txtNombreAltas.setBounds(122, 42, 138, 20);
		txtNombreAltas.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				if (txtNombreAltas.getText().length() == 10) {
					e.consume();
				}
			}
		});
		pnlDatosPersonalesAltas.add(txtNombreAltas);
		
		txtApellidoAltas = new JTextField();
		txtApellidoAltas.setColumns(10);
		txtApellidoAltas.setBounds(122, 67, 138, 20);
		txtApellidoAltas.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				if (txtApellidoAltas.getText().length() == 20) {
					e.consume();
				}
			}
		});
		pnlDatosPersonalesAltas.add(txtApellidoAltas);
		
		txtEdadAltas = new JTextField();
		txtEdadAltas.setColumns(10);
		txtEdadAltas.setBounds(122, 92, 138, 20);
		txtEdadAltas.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				if (e.getKeyChar() < KeyEvent.VK_0 || e.getKeyChar() > KeyEvent.VK_9) {
					e.consume();
				} 
				if (txtEdadAltas.getText().length() == 2) {
					e.consume();
				}
			}
		});
		pnlDatosPersonalesAltas.add(txtEdadAltas);
		
		JPanel pnlDireccionAltas = new JPanel();
		pnlDireccionAltas.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Direcci\u00F3n:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlDireccionAltas.setBounds(10, 160, 270, 112);
		layeredPaneAltas.add(pnlDireccionAltas);
		pnlDireccionAltas.setLayout(null);
		
		JLabel lblCalle = new JLabel("Calle:");
		lblCalle.setBounds(21, 20, 46, 14);
		pnlDireccionAltas.add(lblCalle);
		
		JLabel lblNmero = new JLabel("N\u00FAmero:");
		lblNmero.setBounds(21, 45, 46, 14);
		pnlDireccionAltas.add(lblNmero);
		
		JLabel lblCodigoPostal = new JLabel("C\u00F3digo Postal:");
		lblCodigoPostal.setBounds(21, 70, 69, 14);
		pnlDireccionAltas.add(lblCodigoPostal);
		
		txtCalleAltas = new JTextField();
		txtCalleAltas.setColumns(10);
		txtCalleAltas.setBounds(122, 20, 138, 20);
		txtCalleAltas.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				if (txtCalleAltas.getText().length() == 20) {
					e.consume();
				}
			}
		});
		pnlDireccionAltas.add(txtCalleAltas);
		
		txtNumeroAltas = new JTextField();
		txtNumeroAltas.setColumns(10);
		txtNumeroAltas.setBounds(122, 45, 138, 20);
		txtNumeroAltas.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				
				if (e.getKeyChar() < KeyEvent.VK_0 || e.getKeyChar() > KeyEvent.VK_9) {
					e.consume();
				}
				if (txtNumeroAltas.getText().length() == 9) {
					e.consume();
				}
			}
		});
		pnlDireccionAltas.add(txtNumeroAltas);
		
		txtCodigoPostalAltas = new JTextField();
		txtCodigoPostalAltas.setColumns(10);
		txtCodigoPostalAltas.setBounds(122, 70, 138, 20);
		txtCodigoPostalAltas.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				if (txtCodigoPostalAltas.getText().length() == 5) {
					e.consume();
				}
			}
		});
		pnlDireccionAltas.add(txtCodigoPostalAltas);
		
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				limpiarCampos();
			}
		});
		btnLimpiar.setBounds(52, 283, 89, 23);
		layeredPaneAltas.add(btnLimpiar);
		
		JButton btnDarDeAlta = new JButton("Dar de Alta");
		btnDarDeAlta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int edad;
				int numero;
				String clave = txtClaveAltas.getText();
				String nombre = txtNombreAltas.getText();
				String apellidos = txtApellidoAltas.getText();
				String calle = txtCalleAltas.getText();
				String codigoPostal = txtCodigoPostalAltas.getText();
				
				if (clave.equals("") || nombre.equals("") || apellidos.equals("") 
						|| calle.equals("") || codigoPostal.equals("")) {
					JOptionPane.showMessageDialog(InterfazPrincipal.this, "Debe llenar todos los campos", 
							"Advertencia", JOptionPane.WARNING_MESSAGE);
					return;
				}
				
				try {
					edad = Integer.parseInt(txtEdadAltas.getText());
				} catch(Exception e1) {
					JOptionPane.showMessageDialog(InterfazPrincipal.this, "Inserte una edad válida",
							"Error", JOptionPane.ERROR_MESSAGE);
					txtEdadAltas.requestFocus();
					txtEdadAltas.selectAll();
					return;
				}
				
				try {
					numero = Integer.parseInt(txtNumeroAltas.getText());
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(InterfazPrincipal.this, "Inserte un número válido",
							"Error", JOptionPane.ERROR_MESSAGE);
					txtNumeroAltas.requestFocus();
					txtNumeroAltas.selectAll();
					return;
				}
//				try {
//					rs = consulta.hacerConsulta();
//					while (rs.next()) {
//						if (rs.getString("clave").equals(clave)) 
//							JOptionPane.showMessageDialog(InterfazPrincipal.this, "La clave introducida "
//									+ "ya existe, utilice otra", "Error", JOptionPane.ERROR_MESSAGE);
//						txtClaveAltas.requestFocus();
//						txtClaveAltas.selectAll();
//						return;
//					}
//				} catch (Exception e1) {
//					mensajeError(e1);
//				}
//				
				try {
					consulta.insertarCampos(new Alumno(clave, nombre, apellidos, edad, calle, numero, codigoPostal));
					JOptionPane.showMessageDialog(InterfazPrincipal.this, "Alumno dado de Alta Sastifactoriamente !!", 
							"Información", JOptionPane.INFORMATION_MESSAGE);
				} catch (Exception e1) {
					mensajeError(e1);
				}
			}
		});
		btnDarDeAlta.setBounds(151, 283, 89, 23);
		layeredPaneAltas.add(btnDarDeAlta);
		
		JLayeredPane layeredPaneBajas = new JLayeredPane();
		tabbedPane.addTab("Bajas", null, layeredPaneBajas, null);
		
		JPanel pnlAlumnosBajas = new JPanel();
		pnlAlumnosBajas.setBorder(new TitledBorder(null, "Alumnos:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlAlumnosBajas.setBounds(10, 11, 270, 56);
		layeredPaneBajas.add(pnlAlumnosBajas);
		pnlAlumnosBajas.setLayout(null);
		
		JLabel lblClave_1 = new JLabel("Clave:");
		lblClave_1.setBounds(22, 31, 46, 14);
		pnlAlumnosBajas.add(lblClave_1);
		
		cbClaveBajas = new JComboBox<String>();
		cbClaveBajas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (cbClaveBajas.getSelectedIndex() == 0) {
					limpiarCampos();
					return;
				}
				
				String clave = cbClaveBajas.getSelectedItem().toString();
				try {
					rs = consulta.hacerConsulta();
					while (rs.next()) {
						if (rs.getString("clave").equals(clave)) {
							txtNombreBajas.setText(rs.getString("nombre"));
							txtApellidosBajas.setText(rs.getString("apellidos"));
							txtEdadBajas.setText(rs.getString("edad"));
							txtCalleBajas.setText(rs.getString("calle"));
							txtNumeroBajas.setText(rs.getString("numero"));
							txtCodigoPostalBajas.setText(rs.getString("codigo"));
						}
					}
				} catch (SQLException e1) {
					mensajeError(e1);
				}
				
			}
		});
		cbClaveBajas.setBounds(142, 23, 118, 25);
		pnlAlumnosBajas.add(cbClaveBajas);
		
		JPanel pnlDatosPersonalesBajas = new JPanel();
		pnlDatosPersonalesBajas.setBorder(new TitledBorder(null, "Datos Personales:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlDatosPersonalesBajas.setBounds(10, 78, 270, 103);
		layeredPaneBajas.add(pnlDatosPersonalesBajas);
		pnlDatosPersonalesBajas.setLayout(null);
		
		JLabel lblNombre_1 = new JLabel("Nombre:");
		lblNombre_1.setBounds(21, 25, 46, 14);
		pnlDatosPersonalesBajas.add(lblNombre_1);
		
		JLabel lblApellidos_1 = new JLabel("Apellidos:");
		lblApellidos_1.setBounds(21, 50, 46, 14);
		pnlDatosPersonalesBajas.add(lblApellidos_1);
		
		JLabel lblEdad_1 = new JLabel("Edad:");
		lblEdad_1.setBounds(21, 75, 46, 14);
		pnlDatosPersonalesBajas.add(lblEdad_1);
		
		txtNombreBajas = new JTextField();
		txtNombreBajas.setBounds(141, 22, 119, 20);
		pnlDatosPersonalesBajas.add(txtNombreBajas);
		txtNombreBajas.setColumns(10);
		txtNombreBajas.setEnabled(false);
		
		txtApellidosBajas = new JTextField();
		txtApellidosBajas.setColumns(10);
		txtApellidosBajas.setBounds(141, 47, 119, 20);
		pnlDatosPersonalesBajas.add(txtApellidosBajas);
		txtApellidosBajas.setEnabled(false);
		
		txtEdadBajas = new JTextField();
		txtEdadBajas.setColumns(10);
		txtEdadBajas.setBounds(141, 72, 119, 20);
		pnlDatosPersonalesBajas.add(txtEdadBajas);
		txtEdadBajas.setEnabled(false);
		
		JPanel pnlDireccionBajas = new JPanel();
		pnlDireccionBajas.setBorder(new TitledBorder(null, "Direcci\u00F3n:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlDireccionBajas.setBounds(10, 184, 270, 91);
		layeredPaneBajas.add(pnlDireccionBajas);
		pnlDireccionBajas.setLayout(null);
		
		JLabel lblCalle_1 = new JLabel("Calle:");
		lblCalle_1.setBounds(21, 21, 46, 14);
		pnlDireccionBajas.add(lblCalle_1);
		
		JLabel lblNmero_1 = new JLabel("N\u00FAmero:");
		lblNmero_1.setBounds(21, 46, 46, 14);
		pnlDireccionBajas.add(lblNmero_1);
		
		JLabel lblCdigoPostal = new JLabel("C\u00F3digo Postal:");
		lblCdigoPostal.setBounds(21, 69, 69, 14);
		pnlDireccionBajas.add(lblCdigoPostal);
		
		txtCalleBajas = new JTextField();
		txtCalleBajas.setBounds(142, 18, 118, 20);
		pnlDireccionBajas.add(txtCalleBajas);
		txtCalleBajas.setColumns(10);
		txtCalleBajas.setEnabled(false);
		
		txtNumeroBajas = new JTextField();
		txtNumeroBajas.setColumns(10);
		txtNumeroBajas.setBounds(142, 43, 118, 20);
		pnlDireccionBajas.add(txtNumeroBajas);
		txtNumeroBajas.setEnabled(false);
		
		txtCodigoPostalBajas = new JTextField();
		txtCodigoPostalBajas.setColumns(10);
		txtCodigoPostalBajas.setBounds(142, 66, 118, 20);
		pnlDireccionBajas.add(txtCodigoPostalBajas);
		txtCodigoPostalBajas.setEnabled(false);
		
		JButton btnDarDeBaja = new JButton("Dar de baja");
		btnDarDeBaja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					String clave = cbClaveBajas.getSelectedItem().toString();
					if (cbClaveBajas.getSelectedIndex() > 0) {
						consulta.eliminarCampos(clave);
						cbClaveBajas.setModel(new DefaultComboBoxModel<String>(calcularClaves()));
					}
					else {
						JOptionPane.showMessageDialog(InterfazPrincipal.this, "Debe seleccionar un Alumno a dar de baja", 
								"Advertencia", JOptionPane.WARNING_MESSAGE);
						return;
					}
					
					JOptionPane.showMessageDialog(InterfazPrincipal.this, "Alumno dado de Baja Sastifactoriamente !!", 
							"Información", JOptionPane.INFORMATION_MESSAGE);
					
					limpiarCampos();
				} catch (Exception e) {
					mensajeError(e);
				}
			}
		});
		btnDarDeBaja.setBounds(99, 286, 89, 23);
		layeredPaneBajas.add(btnDarDeBaja);
		
		JLayeredPane layeredPaneModificaciones = new JLayeredPane();
		tabbedPane.addTab("Modificaciones", null, layeredPaneModificaciones, null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(null, "Alumnos:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 270, 56);
		layeredPaneModificaciones.add(panel);
		
		JLabel label = new JLabel("Clave:");
		label.setBounds(22, 31, 46, 14);
		panel.add(label);
		
		cbClaveModificaciones = new JComboBox<String>();
		cbClaveModificaciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if (cbClaveModificaciones.getSelectedIndex() == 0) {
					switchHabilitarCamposModificaciones(false);
					limpiarCampos();
					return;
				}
				
				switchHabilitarCamposModificaciones(true);
				String clave = cbClaveModificaciones.getSelectedItem().toString();
				try {
					rs = consulta.hacerConsulta();
					while (rs.next()) {
						if (rs.getString("clave").equals(clave)) {
							txtNombreModificaciones.setText(rs.getString("nombre"));
							txtApellidosModificaciones.setText(rs.getString("apellidos"));
							txtEdadModificaciones.setText(rs.getString("edad"));
							txtCalleModificaciones.setText(rs.getString("calle"));
							txtNumeroModificaciones.setText(rs.getString("numero"));
							txtCodigoPostalModificaciones.setText(rs.getString("codigo"));
						}
					}
				} catch (SQLException e1) {
					mensajeError(e1);
				}
			}
		});
		cbClaveModificaciones.setBounds(142, 23, 118, 25);
		panel.add(cbClaveModificaciones);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(null, "Datos Personales:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 78, 270, 103);
		layeredPaneModificaciones.add(panel_1);
		
		JLabel label_1 = new JLabel("Nombre:");
		label_1.setBounds(21, 25, 46, 14);
		panel_1.add(label_1);
		
		JLabel label_2 = new JLabel("Apellidos:");
		label_2.setBounds(21, 50, 46, 14);
		panel_1.add(label_2);
		
		JLabel label_3 = new JLabel("Edad:");
		label_3.setBounds(21, 75, 46, 14);
		panel_1.add(label_3);
		
		txtNombreModificaciones = new JTextField();
		txtNombreModificaciones.setColumns(10);
		txtNombreModificaciones.setBounds(141, 22, 119, 20);
		txtNombreModificaciones.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				if (txtNombreModificaciones.getText().length() == 10) {
					e.consume();
				}
			}
		});
		panel_1.add(txtNombreModificaciones);
		
		txtApellidosModificaciones = new JTextField();
		txtApellidosModificaciones.setColumns(10);
		txtApellidosModificaciones.setBounds(141, 47, 119, 20);
		txtApellidosModificaciones.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				if (txtApellidosModificaciones.getText().length() == 20) {
					e.consume();
				}
			}
		});
		panel_1.add(txtApellidosModificaciones);
		
		txtEdadModificaciones = new JTextField();
		txtEdadModificaciones.setColumns(10);
		txtEdadModificaciones.setBounds(141, 72, 119, 20);
		txtEdadModificaciones.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				if (e.getKeyChar() < KeyEvent.VK_0 || e.getKeyChar() > KeyEvent.VK_9) {
					e.consume();
				} 
				if (txtEdadModificaciones.getText().length() == 2) {
					e.consume();
				}
			}
		});
		panel_1.add(txtEdadModificaciones);
		
		JPanel panel_5 = new JPanel();
		panel_5.setLayout(null);
		panel_5.setBorder(new TitledBorder(null, "Direcci\u00F3n:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_5.setBounds(10, 186, 270, 91);
		layeredPaneModificaciones.add(panel_5);
		
		JLabel label_4 = new JLabel("Calle:");
		label_4.setBounds(21, 21, 46, 14);
		panel_5.add(label_4);
		
		JLabel label_5 = new JLabel("N\u00FAmero:");
		label_5.setBounds(21, 46, 46, 14);
		panel_5.add(label_5);
		
		JLabel label_6 = new JLabel("C\u00F3digo Postal:");
		label_6.setBounds(21, 69, 69, 14);
		panel_5.add(label_6);
		
		txtCalleModificaciones = new JTextField();
		txtCalleModificaciones.setColumns(10);
		txtCalleModificaciones.setBounds(142, 18, 118, 20);
		txtCalleModificaciones.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				if (txtCalleModificaciones.getText().length() == 20) {
					e.consume();
				}
			}
		});
		panel_5.add(txtCalleModificaciones);
		
		txtNumeroModificaciones = new JTextField();
		txtNumeroModificaciones.setColumns(10);
		txtNumeroModificaciones.setBounds(142, 43, 118, 20);
		txtNumeroModificaciones.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				
				if (e.getKeyChar() < KeyEvent.VK_0 || e.getKeyChar() > KeyEvent.VK_9) {
					e.consume();
				}
				if (txtNumeroModificaciones.getText().length() == 9) {
					e.consume();
				}
			}
		});
		panel_5.add(txtNumeroModificaciones);
		
		txtCodigoPostalModificaciones = new JTextField();
		txtCodigoPostalModificaciones.setColumns(10);
		txtCodigoPostalModificaciones.setBounds(142, 66, 118, 20);
		txtCodigoPostalModificaciones.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				
				if (txtCodigoPostalModificaciones.getText().length() == 5) {
					e.consume();
				}
			}
		});
		panel_5.add(txtCodigoPostalModificaciones);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if (cbClaveModificaciones.getSelectedIndex() == 0) {
					JOptionPane.showMessageDialog(InterfazPrincipal.this, "Debe Seleccionar un Alumno",
							"Información", JOptionPane.INFORMATION_MESSAGE);
					return;
				}
				
				int edad;
				int numero;
				String clave = cbClaveModificaciones.getSelectedItem().toString();
				String nombre = txtNombreModificaciones.getText();
				String apellido = txtApellidosModificaciones.getText();
				String calle = txtCalleModificaciones.getText();
				String codigoPostal = txtCodigoPostalModificaciones.getText();
				
				if (clave.equals("") || nombre.equals("") || calle.equals("") || codigoPostal.equals("") 
						|| apellido.equals("")) {
					JOptionPane.showMessageDialog(InterfazPrincipal.this, "Debe llenar todos los campos", 
							"Advertencia", JOptionPane.INFORMATION_MESSAGE);
					return;
				}
				
				try {
					edad = Integer.parseInt(txtEdadModificaciones.getText());
				} catch (Exception e) {
					JOptionPane.showMessageDialog(InterfazPrincipal.this, "Debe introducir una edad válida", 
							"Error", JOptionPane.ERROR_MESSAGE);
					txtEdadModificaciones.requestFocus();
					txtEdadModificaciones.selectAll();
					return;
				}
				
				try {
					numero = Integer.parseInt(txtNumeroModificaciones.getText());
				} catch (Exception e) {
					JOptionPane.showMessageDialog(InterfazPrincipal.this, "Debe introducir un número válido", 
							"Error", JOptionPane.ERROR_MESSAGE);
					txtNumeroModificaciones.requestFocus();
					txtNumeroModificaciones.selectAll();
					return;
				}
				
				try {
					consulta.cambiarCampos(new Alumno(clave, nombre, apellido, edad, calle, numero, codigoPostal));
					JOptionPane.showMessageDialog(InterfazPrincipal.this, "Alumno Modificado correctamente !!", 
							"Información", JOptionPane.INFORMATION_MESSAGE);
				} catch (Exception e) {
					mensajeError(e);
				}
			}
		});
		btnModificar.setBounds(97, 288, 89, 23);
		layeredPaneModificaciones.add(btnModificar);
		
		tabbedPane.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				switch (tabbedPane.getSelectedIndex()) {
				case 1:
					cbClaveBajas.setModel(new DefaultComboBoxModel<String>(calcularClaves()));
					limpiarCampos();
					break;
				case 2:
					cbClaveModificaciones.setModel(new DefaultComboBoxModel<String>(calcularClaves()));
					switchHabilitarCamposModificaciones(false);
					limpiarCampos();
					break;
				}
			}
		});
	}
	
	private void limpiarCampos() {
		
		txtClaveAltas.setText("");
		txtNombreAltas.setText("");
		txtApellidoAltas.setText("");
		txtEdadAltas.setText("");
		txtCalleAltas.setText("");
		txtNumeroAltas.setText("");
		txtCodigoPostalAltas.setText("");
		txtNombreBajas.setText("");
		txtApellidosBajas.setText("");
		txtEdadBajas.setText("");
		txtCalleBajas.setText("");
		txtNumeroBajas.setText("");
		txtCodigoPostalBajas.setText("");
		txtNombreModificaciones.setText("");
		txtApellidosModificaciones.setText("");
		txtEdadModificaciones.setText("");
		txtCalleModificaciones.setText("");
		txtNumeroModificaciones.setText("");
		txtCodigoPostalModificaciones.setText("");
	}
	
	private void mensajeError(Exception e1) {
		JOptionPane.showMessageDialog(InterfazPrincipal.this, e1.getMessage(),
				"Error", JOptionPane.ERROR_MESSAGE);
	}
	
	private void switchHabilitarCamposModificaciones(boolean activar) {
		
		txtNombreModificaciones.setEnabled(activar);
		txtApellidosModificaciones.setEnabled(activar);
		txtEdadModificaciones.setEnabled(activar);
		txtCalleModificaciones.setEnabled(activar);
		txtNumeroModificaciones.setEnabled(activar);
		txtCodigoPostalModificaciones.setEnabled(activar);
	}
	
	private String[] calcularClaves() {
		
		ArrayList<Alumno> alumnos = Conexion.getInstancia().getAlumnos();
		
		if (alumnos.size() != 0) {
			String[] claves = new String[alumnos.size() + 1];
			
			claves[0] = "Seleccione";
			for(int x = 0; x < alumnos.size(); x++) {
				claves[x+1] = alumnos.get(x).getClave();
			}
			
			return claves;
		} else return new String[] {"Seleccione"};
	}
}

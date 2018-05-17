import javax.swing.JFrame;
import java.awt.Window.Type;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ventana_4 {

	public JFrame frmAadirProducto;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	int id;
	String nombre;
	ConexionBBDD conexion_1 = new ConexionBBDD ();
	/**
	 * Create the application.
	 */
	public Ventana_4() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		this.id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
		frmAadirProducto = new JFrame();
		frmAadirProducto.setType(Type.UTILITY);
		frmAadirProducto.setTitle("Modificar Producto");
		frmAadirProducto.setBounds(100, 100, 320, 300);
		frmAadirProducto.getContentPane().setLayout(null);
		
		JLabel lblId = new JLabel("ID");
		lblId.setHorizontalAlignment(SwingConstants.CENTER);
		lblId.setBounds(10, 11, 283, 14);
		frmAadirProducto.getContentPane().add(lblId);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setBounds(10, 36, 283, 20);
		frmAadirProducto.getContentPane().add(textField);
		textField.setColumns(10);		
		textField.setText(Integer.toString(conexion_1.M_Producto_id(id)));
		
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombre.setBounds(10, 67, 284, 14);
		frmAadirProducto.getContentPane().add(lblNombre);
		
		textField_1 = new JTextField();
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setColumns(10);
		textField_1.setBounds(10, 87, 283, 20);
		frmAadirProducto.getContentPane().add(textField_1);
		textField_1.setText(conexion_1.M_Producto_nom(id));
		
		
		JLabel lblPrecio = new JLabel("Precio (\u20AC)");
		lblPrecio.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrecio.setBounds(10, 118, 284, 14);
		frmAadirProducto.getContentPane().add(lblPrecio);
		
		textField_2 = new JTextField();
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_2.setColumns(10);
		textField_2.setBounds(10, 138, 283, 20);
		frmAadirProducto.getContentPane().add(textField_2);
		textField_2.setText(Integer.toString(conexion_1.M_Producto_pre(id)));
		
		JLabel lblCategora = new JLabel("Categor\u00EDa");
		lblCategora.setHorizontalAlignment(SwingConstants.CENTER);
		lblCategora.setBounds(10, 169, 284, 14);
		frmAadirProducto.getContentPane().add(lblCategora);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"\t\tBEBIDAS", "\t\tCOMIDAS", "\t\tPOSTRES"}));
		comboBox.setSelectedIndex(0);
		comboBox.setBounds(10, 186, 283, 20);
		frmAadirProducto.getContentPane().add(comboBox);
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (textField.getText().equals("") || textField_1.getText().equals("") || textField_2.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Hay un campo sin rellenar.");
				} else {
				conexion_1.M_Producto(textField_1.getText(), Integer.parseInt(textField.getText()), Integer.parseInt(textField_2.getText()), comboBox.getSelectedIndex()+1);
				
				frmAadirProducto.dispose();
				}	
								
			}
		});
		btnOk.setBounds(10, 229, 137, 23);
		frmAadirProducto.getContentPane().add(btnOk);
		
		JButton btnCancelar = new JButton("Borrar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
			}
		});
		btnCancelar.setBounds(156, 229, 137, 23);
		frmAadirProducto.getContentPane().add(btnCancelar);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

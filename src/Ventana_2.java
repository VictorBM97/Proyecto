import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPanel;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.Toolkit;

//800 x 600
//784 x 561
public class Ventana_2 {

	public JFrame frmAdministracin;
	private JTable table;
	JComboBox comboBox = new JComboBox();
	ConexionBBDD conexion_1 = new ConexionBBDD ();



	public Ventana_2() {
		initialize();
	}

	private void initialize() {
		frmAdministracin = new JFrame();
		frmAdministracin.setIconImage(Toolkit.getDefaultToolkit().getImage("src/icono.png"));
		frmAdministracin.setTitle("Administraci\u00F3n");
		frmAdministracin.setBounds(100, 100, 800, 600);
		//frmAdministracin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAdministracin.getContentPane().setLayout(null);
		
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"BEBIDAS", "COMIDAS", "POSTRES"}));
		comboBox.setSelectedIndex(0);
		comboBox.setBounds(10, 10, 764, 25);
		frmAdministracin.getContentPane().add(comboBox);
		JPanel panel = new JPanel();
		panel.setBounds(10, 67, 500, 449);
		frmAdministracin.getContentPane().add(panel);
		panel.setLayout(null);
		
		table = new JTable();
		table.setBounds(0, 0, 500, 449);
		panel.add(table);
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, "Coca Cola", "2"},
				{null, "Coca Cola Light", "2"},
				{null, "Coca Cola Zero", "2"},
				{null, "Fanta Naranja", "2"},
				{null, "Fanta Lim\u00F3n", "2"},
				{null, "Cerveza", "3"},
				{null, "Copa", "5"},
			},
			new String[] {
				"ID", "NOMBRE", "PRECIO"
			}
		));
		table.getColumnModel().getColumn(2).setPreferredWidth(73);
		
		table.setModel(conexion_1.Bebidas());
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ventana_1 ventana1 = new Ventana_1 ();
				ventana1.frmBarViktor.setVisible(true);
				frmAdministracin.setVisible(false);
			}
		});
		btnVolver.setBounds(10, 527, 89, 23);
		frmAdministracin.getContentPane().add(btnVolver);
		
		JLabel lblProducto = new JLabel("Producto");
		lblProducto.setBounds(178, 46, 79, 14);
		frmAdministracin.getContentPane().add(lblProducto);
		
		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setBounds(345, 46, 79, 14);
		frmAdministracin.getContentPane().add(lblPrecio);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(10, 46, 46, 14);
		frmAdministracin.getContentPane().add(lblId);
		
		JButton btnNewButton = new JButton("A\u00F1adir");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Ventana_3 ventana3 = new Ventana_3 ();
				ventana3.frmAadirProducto.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(519, 71, 255, 141);
		frmAdministracin.getContentPane().add(btnNewButton);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ventana_4 ventana4 = new Ventana_4 ();
				ventana4.frmAadirProducto.setVisible(true);
			}
		});
		btnModificar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnModificar.setBounds(519, 223, 255, 141);
		frmAdministracin.getContentPane().add(btnModificar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
				conexion_1.E_Producto(id);
			}
		});
		
		btnEliminar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnEliminar.setBounds(519, 375, 255, 141);
		frmAdministracin.getContentPane().add(btnEliminar);
		
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if (comboBox.getSelectedIndex() == 0) {
					table.setModel(conexion_1.Bebidas());
				}
				if (comboBox.getSelectedIndex() == 1) {
					table.setModel(conexion_1.Comidas());
				}
				if (comboBox.getSelectedIndex() == 2) {
					table.setModel(conexion_1.Postres());
				}
				
			}
		});
	}
	
}

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

//800 x 600
//784 x 561
public class Ventana_5 {

	public JFrame frmAdministracin;
	ConexionBBDD conexion_1 = new ConexionBBDD ();



	public Ventana_5() {
		initialize();
	}

	private void initialize() {
		frmAdministracin = new JFrame();
		frmAdministracin.setIconImage(Toolkit.getDefaultToolkit().getImage("src/icono.png"));
		frmAdministracin.setTitle("Administraci\u00F3n");
		frmAdministracin.setBounds(100, 100, 857, 670);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setBounds(10, 598, 89, 23);
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ventana_1 ventana1 = new Ventana_1 ();
				ventana1.frmBarViktor.setVisible(true);
				frmAdministracin.setVisible(false);
			}
		});
		frmAdministracin.getContentPane().setLayout(null);
		frmAdministracin.getContentPane().add(btnVolver);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 198, 173);
		frmAdministracin.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnNewButton.setToolTipText("");
		btnNewButton.setBackground(Color.GREEN);
		btnNewButton.setIcon(new ImageIcon("src/mesa.png"));
		btnNewButton.setBounds(0, 0, 198, 173);
		panel.add(btnNewButton);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(218, 11, 198, 173);
		frmAdministracin.getContentPane().add(panel_1);
		
		JButton button = new JButton("");
		button.setBackground(Color.GREEN);
		button.setIcon(new ImageIcon("src/mesa.png"));
		button.setBounds(0, 0, 198, 173);
		panel_1.add(button);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBounds(426, 11, 198, 173);
		frmAdministracin.getContentPane().add(panel_2);
		
		JButton button_1 = new JButton("");
		button_1.setBackground(Color.GREEN);
		button_1.setIcon(new ImageIcon("src/mesa.png"));
		button_1.setBounds(0, 0, 198, 173);
		panel_2.add(button_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBounds(10, 195, 198, 173);
		frmAdministracin.getContentPane().add(panel_3);
		
		JButton button_2 = new JButton("");
		button_2.setToolTipText("1");
		button_2.setBackground(Color.GREEN);
		button_2.setIcon(new ImageIcon("src/mesa.png"));
		button_2.setBounds(0, 0, 198, 173);
		panel_3.add(button_2);
		
		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBounds(218, 195, 198, 173);
		frmAdministracin.getContentPane().add(panel_4);
		
		JButton button_3 = new JButton("");
		button_3.setBackground(Color.GREEN);
		button_3.setIcon(new ImageIcon("src/mesa.png"));
		button_3.setBounds(0, 0, 198, 173);
		panel_4.add(button_3);
		
		JPanel panel_5 = new JPanel();
		panel_5.setLayout(null);
		panel_5.setBounds(426, 195, 198, 173);
		frmAdministracin.getContentPane().add(panel_5);
		
		JButton button_4 = new JButton("");
		button_4.setBackground(Color.GREEN);
		button_4.setIcon(new ImageIcon("src/mesa.png"));
		button_4.setBounds(0, 0, 198, 173);
		panel_5.add(button_4);
		
		JPanel panel_9 = new JPanel();
		panel_9.setLayout(null);
		panel_9.setBounds(634, 11, 198, 173);
		frmAdministracin.getContentPane().add(panel_9);
		
		JButton button_8 = new JButton("");
		button_8.setBackground(Color.GREEN);
		button_8.setIcon(new ImageIcon("src/mesa.png"));
		button_8.setBounds(0, 0, 198, 173);
		panel_9.add(button_8);
		
		JPanel panel_10 = new JPanel();
		panel_10.setLayout(null);
		panel_10.setBounds(634, 195, 198, 173);
		frmAdministracin.getContentPane().add(panel_10);
		
		JButton button_9 = new JButton("");
		button_9.setBackground(Color.GREEN);
		button_9.setIcon(new ImageIcon("src/mesa.png"));
		button_9.setBounds(0, 0, 198, 173);
		panel_10.add(button_9);
		
		JPanel panel_6 = new JPanel();
		panel_6.setLayout(null);
		panel_6.setBounds(10, 379, 198, 173);
		frmAdministracin.getContentPane().add(panel_6);
		
		JButton button_5 = new JButton("");
		button_5.setBackground(Color.GREEN);
		button_5.setIcon(new ImageIcon("src/mesa.png"));
		button_5.setBounds(0, 0, 198, 173);
		panel_6.add(button_5);
		
		JPanel panel_7 = new JPanel();
		panel_7.setLayout(null);
		panel_7.setBounds(218, 379, 198, 173);
		frmAdministracin.getContentPane().add(panel_7);
		
		JButton button_6 = new JButton("");
		button_6.setBackground(Color.GREEN);
		button_6.setIcon(new ImageIcon("src/mesa.png"));
		button_6.setBounds(0, 0, 198, 173);
		panel_7.add(button_6);
		
		JPanel panel_8 = new JPanel();
		panel_8.setLayout(null);
		panel_8.setBounds(426, 379, 198, 173);
		frmAdministracin.getContentPane().add(panel_8);
		
		JButton button_7 = new JButton("");
		button_7.setBackground(Color.GREEN);
		button_7.setIcon(new ImageIcon("src/mesa.png"));
		button_7.setBounds(0, 0, 198, 173);
		panel_8.add(button_7);
		
		JPanel panel_11 = new JPanel();
		panel_11.setLayout(null);
		panel_11.setBounds(634, 379, 198, 173);
		frmAdministracin.getContentPane().add(panel_11);
		
		JButton button_10 = new JButton("");
		button_10.setBackground(Color.GREEN);
		button_10.setIcon(new ImageIcon("src/mesa.png"));
		button_10.setBounds(0, 0, 198, 173);
		panel_11.add(button_10);
	}
}
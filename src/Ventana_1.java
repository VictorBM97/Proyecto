import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

//800 x 600
//784 x 561
public class Ventana_1 {

	public JFrame frmBarViktor;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana_1 window = new Ventana_1();
					window.frmBarViktor.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Ventana_1() {
		initialize();
	}

	private void initialize() {
		frmBarViktor = new JFrame();
		frmBarViktor.setTitle("BAR VIKTOR");
		frmBarViktor.setIconImage(Toolkit.getDefaultToolkit().getImage("src/icono.png"));
		frmBarViktor.setBounds(100, 100, 800, 600);
		frmBarViktor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBarViktor.getContentPane().setLayout(null);
		
		JButton btnPedidos = new JButton("    PEDIDOS");
		btnPedidos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Ventana_5 ventana5= new Ventana_5 ();
				ventana5.frmAdministracin.setVisible(true);
				frmBarViktor.setVisible(false);
			}
		});
		btnPedidos.setHorizontalAlignment(SwingConstants.LEFT);
		btnPedidos.setFont(new Font("Tahoma", Font.BOLD, 40));
		btnPedidos.setIcon(new ImageIcon("src/bar.png"));
		btnPedidos.setBounds(0, 0, 784, 280);
		frmBarViktor.getContentPane().add(btnPedidos);
		
		JButton btnAdministracin = new JButton("    ADMINISTRACI\u00D3N");
		btnAdministracin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ventana_2 ventana2 = new Ventana_2 ();
				ventana2.frmAdministracin.setVisible(true);
				frmBarViktor.setVisible(false);
			}
		});
		btnAdministracin.setFont(new Font("Tahoma", Font.BOLD, 40));
		btnAdministracin.setHorizontalAlignment(SwingConstants.LEFT);
		btnAdministracin.setIcon(new ImageIcon("src/admin.png"));
		btnAdministracin.setBounds(0, 280, 784, 281);
		frmBarViktor.getContentPane().add(btnAdministracin);
	}
}

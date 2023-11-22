package gui;


import defaultPackage.Encrypt;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;


public class encriptarGUI extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JTextField txtClau;
	private JLabel lbLMissatge;
	private JTextField txtMissatge;
	private JLabel lbLResultat;
	private JButton btnEnviar;
	private JTextField txtResultat;
	private JButton btnMenu;
	private Encrypt usoEncrypt = new Encrypt();

		
	
	public encriptarGUI() {
		setLayout(null);
		setBounds(0, 0, 710, 797);
		setLocation(0, 0);
		iniciar();
		

	}

	public void iniciar() {
		setBorder(new EmptyBorder(5, 5, 5, 5));

		JLabel lbLclau = new JLabel("CLAU: ");
		lbLclau.setHorizontalAlignment(SwingConstants.CENTER);
		lbLclau.setFont(new Font("Arial Black", Font.BOLD, 30));
		lbLclau.setForeground(new Color(255, 255, 255));
		lbLclau.setBounds(49, 59, 150, 63);
		add(lbLclau);

		txtClau = new JTextField();
		txtClau.setFont(new Font("Arial Black", Font.PLAIN, 20));
		txtClau.setBackground(new Color(255, 255, 255));
		txtClau.setBounds(186, 70, 150, 44);
		add(txtClau);
		txtClau.setColumns(10);

		lbLMissatge = new JLabel("MISSATGE:");
		lbLMissatge.setHorizontalAlignment(SwingConstants.CENTER);
		lbLMissatge.setForeground(Color.WHITE);
		lbLMissatge.setFont(new Font("Arial Black", Font.BOLD, 30));
		lbLMissatge.setBounds(49, 174, 240, 63);
		add(lbLMissatge);

		txtMissatge = new JTextField();
		txtMissatge.setFont(new Font("Arial Black", Font.PLAIN, 20));
		txtMissatge.setBounds(284, 185, 337, 44);
		add(txtMissatge);
		txtMissatge.setColumns(10);

		lbLResultat = new JLabel("RESULTAT:");
		lbLResultat.setHorizontalAlignment(SwingConstants.CENTER);
		lbLResultat.setForeground(Color.WHITE);
		lbLResultat.setFont(new Font("Arial Black", Font.BOLD, 30));
		lbLResultat.setBounds(228, 279, 240, 63);
		add(lbLResultat);

		btnMenu = new JButton("MENU");
		btnMenu.setForeground(new Color(255, 255, 255));
		btnMenu.setBackground(new Color(128, 0, 0));
		btnMenu.setFont(new Font("Arial Black", Font.PLAIN, 20));
		btnMenu.setBounds(486, 643, 135, 76);
		btnMenu.addActionListener(this);
		add(btnMenu);

		btnEnviar = new JButton("ENVIAR");
		btnEnviar.setForeground(Color.WHITE);
		btnEnviar.setFont(new Font("Arial Black", Font.PLAIN, 20));
		btnEnviar.setBackground(new Color(128, 0, 0));
		btnEnviar.setBounds(486, 59, 135, 76);
		btnEnviar.addActionListener(this);
		add(btnEnviar);

		txtResultat = new JTextField();
		txtResultat.setHorizontalAlignment(SwingConstants.CENTER);
		txtResultat.setFont(new Font("Arial Black", Font.PLAIN, 12));
		txtResultat.setBounds(62, 370, 572, 44);
		add(txtResultat);
		txtResultat.setColumns(10);

		JLabel Background = new JLabel("CLAU :");
		Background.setBounds(-12, 0, 718, 785);
		Background.setBackground(new Color(255, 255, 255));
		Background.setForeground(new Color(255, 128, 0));
		Image img = new ImageIcon(this.getClass().getResource("/matrix.png")).getImage();
		setLayout(null);
		Background.setIcon(new ImageIcon(img));
		add(Background);

	}


	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == btnEnviar) {
			String clau = txtClau.getText();
			int clauInt = Integer.parseInt(clau);
			if (clauInt<0) clauInt = Math.abs(clauInt);
			else if (clauInt==0) clauInt=10;
			String missatge = txtMissatge.getText();
			String resultat = "";
			for (int i = 0; missatge.length() > i; i++) {
				int valorChar = (int) missatge.charAt(i);
				resultat = resultat + usoEncrypt.encryptCesar(clauInt, valorChar);
			}
			txtResultat.setText(resultat);

		} else if (e.getSource() == btnMenu) {
			removeAll();
			Menu2 usoMenu2 = new Menu2();
			add(usoMenu2, BorderLayout.CENTER);
			revalidate();
			repaint();
			
		}
	}
}

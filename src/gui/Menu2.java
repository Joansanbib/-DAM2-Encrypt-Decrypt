package gui;

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

public class Menu2 extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JButton btnEncriptar;
	private JButton btnDecrypt;
	encriptarGUI pagEncriptar = new encriptarGUI();
	deCrypt pagDecrypt = new deCrypt();


	public Menu2() {
		setLayout(null);
		setBounds(0, 0, 710, 797);
		iniciar();
	}
	public void iniciar() {
		
		setBorder(new EmptyBorder(5, 5, 5, 5));
		
		JLabel txtTitol = new JLabel("ACTV. 1 ENCRYPT/DECRYPT");
		txtTitol.setHorizontalAlignment(SwingConstants.CENTER);
		txtTitol.setBounds(84, 11, 528, 109);
		txtTitol.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 31));
		txtTitol.setForeground(new Color(255, 255, 255));
		txtTitol.setBackground(new Color(255, 255, 0));
		add(txtTitol);

		JLabel lblCredits = new JLabel("JOAN SANTAMARIA, DAM2");
		lblCredits.setHorizontalAlignment(SwingConstants.CENTER);
		lblCredits.setFont(new Font("Arial Black", Font.BOLD, 20));
		lblCredits.setForeground(new Color(255, 255, 255));
		lblCredits.setBounds(117, 106, 462, 91);
		add(lblCredits);

		btnEncriptar = new JButton("ENCRIPTAR");
		btnEncriptar.setFont(new Font("Arial Black", Font.PLAIN, 20));
		btnEncriptar.setBackground(new Color(128, 0, 0));
		btnEncriptar.setForeground(new Color(255, 255, 255));
		btnEncriptar.setBounds(239, 290, 217, 109);
		btnEncriptar.addActionListener(this);
		add(btnEncriptar);

		btnDecrypt = new JButton("DESENCRIPTAR");
		btnDecrypt.setFont(new Font("Arial Black", Font.BOLD, 20));
		btnDecrypt.setForeground(new Color(255, 255, 255));
		btnDecrypt.setBackground(new Color(128, 0, 0));
		btnDecrypt.setBounds(239, 449, 217, 109);
		btnDecrypt.addActionListener(this);
		add(btnDecrypt);

		JLabel Background = new JLabel("");
		Background.setBounds(-12, 0, 718, 785);
		Background.setBackground(new Color(255, 128, 64));
		Background.setForeground(new Color(255, 128, 0));
		Image img = new ImageIcon(this.getClass().getResource("/matrix.png")).getImage();
		setLayout(null);
		Background.setIcon(new ImageIcon(img));
		add(Background);
		
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource()==btnEncriptar) {
			removeAll();
			add(pagEncriptar, BorderLayout.CENTER);
			revalidate();
			repaint();
			
			
			
		}
		else if(e.getSource()==btnDecrypt) {
			removeAll();
			add(pagDecrypt, BorderLayout.CENTER);
			revalidate();
			repaint();
		}
	}

}

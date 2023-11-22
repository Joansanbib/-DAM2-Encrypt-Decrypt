package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.*;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

public class jframe extends JFrame implements ActionListener {


	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnEncriptar;
	private JButton btnDecrypt;
	encriptarGUI pagEncriptar = new encriptarGUI();
	deCrypt pagDecrypt = new deCrypt();
	

	public jframe() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 710, 797);
		setLocationRelativeTo(null);
		setResizable(false);
		setTitle("ENIGMA");
		iniciar();

	}

	public void iniciar() {
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel txtTitol = new JLabel("ACTV. 1 ENCRYPT/DECRYPT");
		txtTitol.setHorizontalAlignment(SwingConstants.CENTER);
		txtTitol.setBounds(84, 11, 528, 109);
		txtTitol.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 31));
		txtTitol.setForeground(new Color(255, 255, 255));
		txtTitol.setBackground(new Color(255, 255, 0));
		contentPane.add(txtTitol);

		JLabel lblCredits = new JLabel("JOAN SANTAMARIA, DAM2");
		lblCredits.setHorizontalAlignment(SwingConstants.CENTER);
		lblCredits.setFont(new Font("Arial Black", Font.BOLD, 20));
		lblCredits.setForeground(new Color(255, 255, 255));
		lblCredits.setBounds(117, 106, 462, 91);
		contentPane.add(lblCredits);

		btnEncriptar = new JButton("ENCRIPTAR");
		btnEncriptar.setFont(new Font("Arial Black", Font.PLAIN, 20));
		btnEncriptar.setBackground(new Color(128, 0, 0));
		btnEncriptar.setForeground(new Color(255, 255, 255));
		btnEncriptar.setBounds(239, 290, 217, 109);
		btnEncriptar.addActionListener(this);
		contentPane.add(btnEncriptar);

		btnDecrypt = new JButton("DESENCRIPTAR");
		btnDecrypt.setFont(new Font("Arial Black", Font.BOLD, 20));
		btnDecrypt.setForeground(new Color(255, 255, 255));
		btnDecrypt.setBackground(new Color(128, 0, 0));
		btnDecrypt.setBounds(239, 449, 217, 109);
		btnDecrypt.addActionListener(this);
		contentPane.add(btnDecrypt);

		JLabel Background = new JLabel("");
		Background.setBounds(-12, 0, 718, 785);
		Background.setBackground(new Color(255, 128, 64));
		Background.setForeground(new Color(255, 128, 0));
		Image img = new ImageIcon(this.getClass().getResource("/matrix.png")).getImage();
		contentPane.setLayout(null);
		Background.setIcon(new ImageIcon(img));
		contentPane.add(Background);
		

	}

	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource()==btnEncriptar) {
			contentPane.removeAll();
			contentPane.add(pagEncriptar, BorderLayout.CENTER);
			contentPane.revalidate();
			contentPane.repaint();
			
			
			
		}
		else if(e.getSource()==btnDecrypt) {
			contentPane.removeAll();
			contentPane.add(pagDecrypt, BorderLayout.CENTER);
			contentPane.revalidate();
			contentPane.repaint();
		}
	}
}

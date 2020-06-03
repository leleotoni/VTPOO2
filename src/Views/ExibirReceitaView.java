package Views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controllers.ExibirController;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.sql.SQLException;

import javax.swing.JTextField;
import java.awt.Color;
import java.awt.FlowLayout;

public class ExibirReceitaView extends JFrame {

	private JPanel contentPane;
	private final JScrollPane scrollPane = new JScrollPane();
	private JTextField textField;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ExibirReceitaView frame = new ExibirReceitaView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public ExibirReceitaView() throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 434, 44);
		contentPane.add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		JLabel lblBuscarReceita = new JLabel("Buscar Receita");
		lblBuscarReceita.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel.add(lblBuscarReceita);
		
		textField = new JTextField();
		panel.add(textField);
		textField.setColumns(9);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBackground(Color.PINK);
		btnBuscar.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel.add(btnBuscar);
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.setBackground(Color.PINK);
		btnAtualizar.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel.add(btnAtualizar);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnVoltar.setBackground(Color.PINK);
		panel.add(btnVoltar);
		
		scrollPane.setBounds(0, 47, 434, 214);
		contentPane.add(scrollPane);
		table = new JTable();
		
	
		ExibirController ouvinte = new ExibirController(table);
		btnAtualizar.addActionListener(ouvinte);
		btnVoltar.addActionListener(ouvinte);
		
		scrollPane.setViewportView(table);
	}
}

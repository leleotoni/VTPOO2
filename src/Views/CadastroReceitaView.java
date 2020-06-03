package Views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controllers.CadastroController;

import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JCheckBox;

public class CadastroReceitaView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4714611049653657612L;
	private JPanel contentPane;
	private JTextField textNome;
	private JTextField textIngrediente1;
	private JTextField textIngrediente2;
	private JTextField textNota;
	private JComboBox comboTipo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroReceitaView frame = new CadastroReceitaView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CadastroReceitaView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome Receita:");
		lblNome.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNome.setFont(new Font("Lucida Sans Unicode", Font.BOLD, 12));
		lblNome.setBounds(10, 35, 97, 32);
		contentPane.add(lblNome);
		
		JLabel lblTitulo = new JLabel("Cadastro");
		lblTitulo.setForeground(Color.RED);
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Lucida Sans", Font.BOLD, 20));
		lblTitulo.setBounds(0, 0, 434, 25);
		contentPane.add(lblTitulo);
		
		textNome = new JTextField();
		textNome.setBounds(130, 41, 145, 20);
		contentPane.add(textNome);
		textNome.setColumns(10);
		
		JLabel lblIngrediente1 = new JLabel("Ingrediente 1:");
		lblIngrediente1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblIngrediente1.setFont(new Font("Lucida Sans Unicode", Font.BOLD, 12));
		lblIngrediente1.setBounds(10, 67, 97, 32);
		contentPane.add(lblIngrediente1);
		
		JLabel lblIngrediente2 = new JLabel("Ingrediente 2:");
		lblIngrediente2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblIngrediente2.setFont(new Font("Lucida Sans Unicode", Font.BOLD, 12));
		lblIngrediente2.setBounds(10, 101, 97, 32);
		contentPane.add(lblIngrediente2);
		
		JLabel lblNota = new JLabel("Nota:");
		lblNota.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNota.setFont(new Font("Lucida Sans Unicode", Font.BOLD, 12));
		lblNota.setBounds(10, 132, 97, 32);
		contentPane.add(lblNota);
		
		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTipo.setFont(new Font("Lucida Sans Unicode", Font.BOLD, 12));
		lblTipo.setBounds(10, 164, 97, 32);
		contentPane.add(lblTipo);
		
		textIngrediente1 = new JTextField();
		textIngrediente1.setColumns(10);
		textIngrediente1.setBounds(130, 73, 145, 20);
		contentPane.add(textIngrediente1);
		
		textIngrediente2 = new JTextField();
		textIngrediente2.setColumns(10);
		textIngrediente2.setBounds(130, 107, 145, 20);
		contentPane.add(textIngrediente2);
		
		textNota = new JTextField();
		textNota.setColumns(10);
		textNota.setBounds(130, 138, 40, 20);
		contentPane.add(textNota);
		
		comboTipo = new JComboBox();
		comboTipo.setBounds(130, 170, 145, 20);
		contentPane.add(comboTipo);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBackground(Color.PINK);
		btnCadastrar.setBounds(166, 227, 97, 23);
		contentPane.add(btnCadastrar);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setBackground(Color.PINK);
		btnLimpar.setBounds(37, 227, 89, 23);
		contentPane.add(btnLimpar);
		
		JButton btnExibir = new JButton("Exibir");
		btnExibir.setBackground(Color.PINK);
		btnExibir.setBounds(304, 227, 89, 23);
		contentPane.add(btnExibir);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(10, 5, 89, 23);
		contentPane.add(btnVoltar);
		
		JCheckBox chPossui1 = new JCheckBox("Possui este?");
		chPossui1.setFont(new Font("Tahoma", Font.BOLD, 11));
		chPossui1.setBounds(296, 72, 97, 23);
		contentPane.add(chPossui1);
		
		JCheckBox chPossui2 = new JCheckBox("Possui este?");
		chPossui2.setFont(new Font("Tahoma", Font.BOLD, 11));
		chPossui2.setBounds(296, 106, 97, 23);
		contentPane.add(chPossui2);
		
		
		CadastroController ouvinte = new CadastroController(textNome, textIngrediente1,chPossui1, textIngrediente2, chPossui2, comboTipo, textNota);
			
		btnCadastrar.addActionListener(ouvinte);
		btnExibir.addActionListener(ouvinte);
		btnLimpar.addActionListener(ouvinte);
		btnVoltar.addActionListener(ouvinte);
	}
}

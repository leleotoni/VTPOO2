package Views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controllers.IndexController;

import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;

public class IndexView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6451416371407554219L;
	private CadastroReceitaView cadastroView;
	private ExibirReceitaView exibirView;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IndexView frame = new IndexView();
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
	public IndexView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCadastrar.setForeground(Color.BLACK);
		btnCadastrar.setBackground(Color.PINK);
		btnCadastrar.setBounds(60, 172, 107, 40);
		contentPane.add(btnCadastrar);
		
		JButton btnExibir = new JButton("Exibir");
		btnExibir.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnExibir.setBackground(Color.PINK);
		btnExibir.setBounds(264, 172, 107, 40);
		contentPane.add(btnExibir);
		
		JLabel lblTitulo = new JLabel("Receitas");
		lblTitulo.setForeground(Color.MAGENTA);
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Script MT Bold", Font.BOLD, 30));
		lblTitulo.setBounds(0, 23, 434, 27);
		contentPane.add(lblTitulo);
		
		IndexController ouvinte = new IndexController(cadastroView);
		IndexController ouvinte2 = new IndexController(exibirView);
		btnExibir.addActionListener(ouvinte2);
		btnCadastrar.addActionListener(ouvinte);
	}
}

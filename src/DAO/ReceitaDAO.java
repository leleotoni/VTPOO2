package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import Models.Receita;


public class ReceitaDAO {

	private Connection myConn;
	
	public ReceitaDAO() throws SQLException {
		
		String user = "root";
		String password = "admin";
		String dburl = "jdbc:mysql://localhost:3306/poo2?useTimezone=true&serverTimezone=America/Sao_Paulo";

		
		myConn = DriverManager.getConnection(dburl, user, password);
		
		System.out.print("Conectado!");
	}
	

	
	public List<Receita> getAllReceitas() throws SQLException {
		
		List<Receita> list = new ArrayList<>();
		
		Statement rStat = null;
		ResultSet rResult = null;
		
		rStat = myConn.createStatement();
		rResult = rStat.executeQuery("SELECT * FROM Receitas");
		
		while (rResult.next()) {
			Receita tempReceita = new Receita(
					rResult.getString("nome"),
					rResult.getString("ingrediente1"),
					rResult.getBoolean("possui1"),
					rResult.getString("ingrediente2"),
					rResult.getBoolean("possui2"),
					rResult.getInt("nota"),
					rResult.getString("tipo")
					
					);
			
			list.add(tempReceita);
		}
		
		rStat.close();
		return list;
		
	}
	public String INSERT = "INSERT INTO Receita (nome,ingrediente1,possui1,ingrediente2,possui2,nota,tipo) VALUES (?,?,?,?,?,?,?)";
	public void inserirReceita(Receita receita)  {
		PreparedStatement pStat;
		
		try {
			pStat = myConn.prepareStatement(INSERT);
			pStat.setString(1, receita.getNome());
			pStat.setString(2, receita.getIngrediente1());
			pStat.setBoolean(3, receita.Possui1());
			pStat.setString(4, receita.getIngrediente2());
			pStat.setBoolean(5, receita.Possui2());
			pStat.setInt(6, receita.getNota());
			pStat.setString(7, receita.getTipo());

			pStat.execute();
			JOptionPane.showMessageDialog(null, "Rceita cadastrada com sucesso");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	

	}


	public void updateReceitaById(int id, Receita receita) throws SQLException {
		Statement rStat = null;
		
		rStat = myConn.createStatement();
		String query = String.format("UPDATE receitas SET " 
				+ " nome = '%s' , ingrediente1 = '%s' , possui1 = %b, ingrediente2 = '%s', possui2 = %b, nota = %s, tipo = '%s' WHERE id = %s", 
				receita.getNome(), receita.getIngrediente1(), receita.Possui1(), receita.getIngrediente2(), receita.Possui2(), receita.getNota(), receita.getTipo(), id);
		System.out.println(query);
		rStat.executeUpdate(query);

	}
	
}

package Models;

public class Receita {
	private String nome;
	private String ingrediente1;
	private boolean possui1;
	private String ingrediente2;
	private boolean possui2;
	private int nota;
	private String tipo;

	
	public Receita(String nome, String ingrediente1, boolean possui1, String ingrediente2, boolean possui2, int nota, String tipo) {
		this.nome = nome;
		this.ingrediente1 = ingrediente1;
		this.possui1 = possui1;
		this.ingrediente2 = ingrediente2;
		this.possui2 = possui2;
		this.nota = nota;
		this.tipo = tipo;
		
	}
	
	public String toString() {
		return "Nome da Receita: " + this.nome + 
				"Ingrediente 1: " + this.ingrediente1 + 
				" Possui este?" + this.possui1 +
				" Ingrediente 2" + this.ingrediente2 + 
				" Possui este?" + this.possui2 +
				" Nota: " + this.nota +
				" Tipo: " + this.tipo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getIngrediente1() {
		return ingrediente1;
	}

	public void setIngrediente1(String ingrediente1) {
		this.ingrediente1 = ingrediente1;
	}
	
	public boolean Possui1() {
		return possui1;
	}
	
	public void setPossui1(boolean possui1) {
		this.possui1 = possui1;
	}
	
	public String getIngrediente2() {
		return ingrediente2;
	}

	public void setIngrediente2(String ingrediente2) {
		this.ingrediente2 = ingrediente2;
	}
	
	public boolean Possui2() {
		return possui2;
	}
	
	public void setPossui2(boolean possui2) {
		this.possui2 = possui2;
	}
	
	public int getNota() {
		return nota;
	}

	public void setNota(int nota) {
		this.nota = nota;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
}

package custos.negocio.modelo;

import custos.negocio.Model;

public class Produto extends Model{
	private String id;
	private String nome;

	public Produto(String nome) {
		this.nome = nome;
	}
	
	public Produto(String id, String nome) {
		this.id = id;
		this.nome = nome;
	}	

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getId() {
		return id;
	}

	@Override
	public String toString() {
		return id + " - " + nome;
	}	
}

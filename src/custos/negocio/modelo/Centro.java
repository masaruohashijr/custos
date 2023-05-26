package custos.negocio.modelo;

import java.util.Iterator;

import custos.negocio.Model;

public class Centro extends Model{
	private String id;
	private String nome;
	private String acronimo;

	public Centro(String nome) {
		this.nome = nome;
	}

	public Centro(String id, String nome, String acronimo) {
		this.id = id;
		this.nome = nome;
		this.acronimo = acronimo;
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

	public String getAcronimo() {
		return acronimo;
	}

	public void setAcronimo(String acronimo) {
		this.acronimo = acronimo;
	}

	@Override
	public String toString() {
		return id + " - " + nome;
	}

	public Integer getNumeroId() {
		String[] split = id.split("[.]");
		String strNumeroId = "";
		for (int i = 0; i < split.length; i++) {
			strNumeroId += split[i];
		}
		Integer numeroId = Integer.valueOf(strNumeroId);
		return numeroId;
	}	
}

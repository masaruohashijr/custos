package custos.negocio.modelo;

import custos.negocio.Model;

public class Insumo extends Model{
	private String id;
	private String idVPD;
	private String nome;

	public Insumo(String idVPD, String nome) {
		this.idVPD = idVPD;
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

	public String getIdVPD() {
		return idVPD;
	}

	public void setIdVPD(String idVPD) {
		this.idVPD = idVPD;
	}

	@Override
	public String toString() {
		return id + " - " + idVPD + " - " + nome;
	}	
}

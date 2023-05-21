package custos.negocio.modelo;

import custos.negocio.Model;

public class FatorCentro extends Model{
	private String id;
	private String idAtividade;
	private String idCentro;
	private Double fator;

	public FatorCentro(String idAtividade, String idCentro, Double fator) {
		this.idAtividade = idAtividade;
		this.idCentro = idCentro;
		this.fator = fator;
	}

	public FatorCentro(String id, String idAtividade, String idCentro, Double fator) {
		this.id = id;
		this.idAtividade = idAtividade;
		this.idCentro = idCentro;
		this.fator = fator;
	}
	
	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public String getIdAtividade() {
		return idAtividade;
	}

	public void setIdAtividade(String idAtividade) {
		this.idAtividade = idAtividade;
	}

	public String getIdCentro() {
		return idCentro;
	}

	public void setIdCentro(String idCentro) {
		this.idCentro = idCentro;
	}

	public Double getFator() {
		return fator;
	}

	public void setFator(Double fator) {
		this.fator = fator;
	}

	@Override
	public String toString() {
		return id + " - " + idAtividade + " - " + idCentro + " - " + fator;
	}	
}

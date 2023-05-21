package custos.negocio.modelo;

import custos.negocio.Model;

public class FatorAspecto extends Model{
	private String id;
	private String idAtividade;
	private String idAspecto;
	private Double fator;

	public FatorAspecto(String idAtividade, String idAspecto, Double fator) {
		this.idAtividade = idAtividade;
		this.idAspecto = idAspecto;
		this.fator = fator;
	}

	public FatorAspecto(String id, String idAtividade, String idAspecto, Double fator) {
		this.id = id;
		this.idAtividade = idAtividade;
		this.idAspecto = idAspecto;
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

	public String getIdAspecto() {
		return idAspecto;
	}

	public void setIdAspecto(String idAspecto) {
		this.idAspecto = idAspecto;
	}

	public Double getFator() {
		return fator;
	}

	public void setFator(Double fator) {
		this.fator = fator;
	}

	@Override
	public String toString() {
		return id + " - " + idAtividade + " - " + idAspecto + " - " + fator;
	}	
}

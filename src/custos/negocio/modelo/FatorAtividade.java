package custos.negocio.modelo;

import custos.negocio.Model;

public class FatorAtividade extends Model{
	private String id;
	private String idInsumo;
	private String idAtividade;
	private Double fator;

	public FatorAtividade(String idInsumo, String idAtividade, Double fator) {
		this.idInsumo = idInsumo;
		this.idAtividade = idAtividade;
		this.fator = fator;
	}

	public FatorAtividade(String id, String idInsumo, String idAtividade, Double fator) {
		this.id = id;
		this.idInsumo = idInsumo;
		this.idAtividade = idAtividade;
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

	public String getIdInsumo() {
		return idInsumo;
	}

	public void setIdInsumo(String idInsumo) {
		this.idInsumo = idInsumo;
	}

	public Double getFator() {
		return fator;
	}

	public void setFator(Double fator) {
		this.fator = fator;
	}

	@Override
	public String toString() {
		return id + " - " + idInsumo + " - " + idAtividade + " - " + fator;
	}	
}

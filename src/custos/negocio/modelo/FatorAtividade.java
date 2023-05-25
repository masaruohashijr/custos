package custos.negocio.modelo;

import custos.negocio.Model;

public class FatorAtividade extends Model{
	private String id;
	private String idVPD;
	private String idAtividade;
	private Double fator;

	public FatorAtividade(String idVPD, String idAtividade, Double fator) {
		this.idVPD = idVPD;
		this.idAtividade = idAtividade;
		this.fator = fator;
	}

	public FatorAtividade(String id, String idVPD, String idAtividade, Double fator) {
		this.id = id;
		this.idVPD = idVPD;
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

	public String getIdVPD() {
		return idVPD;
	}

	public void setIdVPD(String idVPD) {
		this.idVPD = idVPD;
	}

	public Double getFator() {
		return fator;
	}

	public void setFator(Double fator) {
		this.fator = fator;
	}

	@Override
	public String toString() {
		return id + " - " + idVPD + " - " + idAtividade + " - " + fator;
	}	
}

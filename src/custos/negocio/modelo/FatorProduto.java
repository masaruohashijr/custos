package custos.negocio.modelo;

import custos.negocio.Model;

public class FatorProduto extends Model{
	private String id;
	private String idAtividade;
	private String idProduto;
	private Double fator;

	public FatorProduto(String idAtividade, String idProduto, Double fator) {
		this.idAtividade = idAtividade;
		this.idProduto = idProduto;
		this.fator = fator;
	}

	public FatorProduto(String id,String idAtividade, String idProduto, Double fator) {
		this.id = id;
		this.idAtividade = idAtividade;
		this.idProduto = idProduto;
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


	public String getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(String idProduto) {
		this.idProduto = idProduto;
	}

	public Double getFator() {
		return fator;
	}

	public void setFator(Double fator) {
		this.fator = fator;
	}

	@Override
	public String toString() {
		return id + " - " + idAtividade + " - " + idProduto + " - " + fator;
	}	
}

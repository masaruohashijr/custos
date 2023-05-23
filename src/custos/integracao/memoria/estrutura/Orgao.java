package custos.integracao.memoria.estrutura;

import java.util.ArrayList;
import java.util.List;

import custos.negocio.modelo.Centro;

public class Orgao {
	private Centro centro;
	private List<Orgao> unidades;
	private Double fator;

	public Orgao(Centro centro) {
	        this.centro = centro;
	        this.unidades = new ArrayList<>();
	    }

	public Centro getCentro() {
		return centro;
	}

	public void setCentro(Centro centro) {
		this.centro = centro;
	}

	public List<Orgao> getUnidades() {
		return unidades;
	}

	public void addUnidade(Orgao unidade) {
		unidades.add(unidade);
	}

	public void removeUnidade(Orgao unidade) {
		unidades.remove(unidade);
	}

	public void insere(Centro filho, int nivel) {
		String idFilho = filho.getId();
		String idPai = this.centro.getId();
		String[] codigoPai = idPai.split("[.]");
		String[] codigoFilho = idFilho.split("[.]");
		if(codigoPai[nivel].equals(codigoFilho[nivel])) {
			nivel ++;
			insere(filho, nivel);
		} else {
			final int ni = nivel;
			for (Orgao orgao : unidades) {
				String idUnidade = orgao.getCentro().getId();
				String[] codigoUnidade = idUnidade.split("[.]");
				if(codigoUnidade[ni].equals(codigoFilho[ni])){
					orgao.insere(filho, ni);
					return;
				}
			}
			unidades.add(new Orgao(filho));
			this.setUnidades(unidades);
		}
	}
	
	public void setUnidades(List<Orgao> unidades) {
		this.unidades = unidades;
	}

	public Double getFator() {
		return fator;
	}

	public void setFator(Double fator) {
		if (null == this.fator) {
			this.fator = 0.0;
		}
		this.fator = fator;
	}

	@Override
	public String toString() {
		return this.centro.getId();
	}

	public void addFator(Double fator) {
		if (null == this.fator) {
			this.fator = 0.0;
		}		
		this.fator += fator;		
	}
}

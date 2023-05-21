package custos.integracao.memoria.estrutura;

import java.util.ArrayList;
import java.util.List;

import custos.negocio.modelo.Centro;

public class Orgao {
	private Centro centro;
	private List<Orgao> unidades;

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

	public void insere(Centro novo) {
		String idNovo = novo.getId();
		if(this.centro.getId().contains(idNovo)) {
			
		}
	}
}

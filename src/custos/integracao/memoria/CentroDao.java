package custos.integracao.memoria;

import java.util.ArrayList;
import java.util.List;

import custos.integracao.memoria.estrutura.Orgao;
import custos.negocio.modelo.Centro;

public class CentroDao {
	private static List<Centro> centros = new ArrayList<>();
	private static Orgao organograma;

	public String inserir(Centro centro) {
		centros.add(centro);
		String id = centro.getId();
		if (null == id) {
			id = String.valueOf(centros.size() - 1);
			centro.setId(id);
			if(null == organograma) {
				organograma = new Orgao(centro);
			} else {
				organograma.insere(centro);
			}
		}
		return id;
	}

	public List<Centro> listar() {
		return centros;
	}

	public void excluir(String id) {
		Centro aRemover = null;
		for (Centro centro : centros) {
			if (id.equals(centro.getId())) {
				aRemover = centro;
				break;
			}
		}
		centros.remove(aRemover);
	}

	public void alterar(Centro centro) {
		String id = centro.getId();
		centros.remove(Integer.parseInt(id));
		centros.add(Integer.parseInt(id), centro);
	}
}

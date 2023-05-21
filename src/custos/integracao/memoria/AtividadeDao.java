package custos.integracao.memoria;

import java.util.ArrayList;
import java.util.List;

import custos.negocio.modelo.Atividade;

public class AtividadeDao {
	private static List<Atividade> atividades = new ArrayList<>();

	public String inserir(Atividade atividade) {
		atividades.add(atividade);
		String id = atividade.getId();
		if (null == id) {
			id = String.valueOf(atividades.size() - 1);
			atividade.setId(id);
		}
		return id;
	}

	public List<Atividade> listar() {
		return atividades;
	}

	public void excluir(String id) {
		Atividade aRemover = null;
		for (Atividade atividade : atividades) {
			if (id.equals(atividade.getId())) {
				aRemover = atividade;
				break;
			}
		}
		atividades.remove(aRemover);
	}

	public void alterar(Atividade atividade) {
		String id = atividade.getId();
		atividades.remove(Integer.parseInt(id));
		atividades.add(Integer.parseInt(id), atividade);
	}
}

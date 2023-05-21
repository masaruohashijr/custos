package custos.integracao.memoria;

import java.util.ArrayList;
import java.util.List;

import custos.negocio.modelo.FatorAtividade;

public class FatorAtividadeDao {
	private static List<FatorAtividade> fatores = new ArrayList<>();

	public String inserir(FatorAtividade fator) {
		fatores.add(fator);
		String id = fator.getId();
		if (null == id) {
			id = String.valueOf(fatores.size() - 1);
			fator.setId(id);
		}
		return id;
	}

	public List<FatorAtividade> listar() {
		return fatores;
	}

	public void excluir(String id) {
		FatorAtividade aRemover = null;
		for (FatorAtividade fator : fatores) {
			if (id.equals(fator.getId())) {
				aRemover = fator;
				break;
			}
		}
		fatores.remove(aRemover);
	}

	public void alterar(FatorAtividade fator) {
		String id = fator.getId();
		fatores.remove(Integer.parseInt(id));
		fatores.add(Integer.parseInt(id), fator);
	}
}

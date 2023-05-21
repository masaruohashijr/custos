package custos.integracao.memoria;

import java.util.ArrayList;
import java.util.List;

import custos.negocio.modelo.FatorCentro;

public class FatorCentroDao {
	private static List<FatorCentro> fatores = new ArrayList<>();

	public String inserir(FatorCentro fator) {
		fatores.add(fator);
		String id = fator.getId();
		if (null == id) {
			id = String.valueOf(fatores.size() - 1);
			fator.setId(id);
		}
		return id;
	}

	public List<FatorCentro> listar() {
		return fatores;
	}

	public void excluir(String id) {
		FatorCentro aRemover = null;
		for (FatorCentro fator : fatores) {
			if (id.equals(fator.getId())) {
				aRemover = fator;
				break;
			}
		}
		fatores.remove(aRemover);
	}

	public void alterar(FatorCentro fator) {
		String id = fator.getId();
		fatores.remove(Integer.parseInt(id));
		fatores.add(Integer.parseInt(id), fator);
	}
}

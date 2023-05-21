package custos.integracao.memoria;

import java.util.ArrayList;
import java.util.List;

import custos.negocio.modelo.FatorAspecto;

public class FatorAspectoDao {
	private static List<FatorAspecto> fatores = new ArrayList<>();

	public String inserir(FatorAspecto fator) {
		fatores.add(fator);
		String id = fator.getId();
		if (null == id) {
			id = String.valueOf(fatores.size() - 1);
			fator.setId(id);
		}
		return id;
	}

	public List<FatorAspecto> listar() {
		return fatores;
	}

	public void excluir(String id) {
		FatorAspecto aRemover = null;
		for (FatorAspecto fator : fatores) {
			if (id.equals(fator.getId())) {
				aRemover = fator;
				break;
			}
		}
		fatores.remove(aRemover);
	}

	public void alterar(FatorAspecto fator) {
		String id = fator.getId();
		fatores.remove(Integer.parseInt(id));
		fatores.add(Integer.parseInt(id), fator);
	}
}

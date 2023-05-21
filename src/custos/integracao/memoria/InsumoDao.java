package custos.integracao.memoria;

import java.util.ArrayList;
import java.util.List;

import custos.negocio.modelo.Insumo;

public class InsumoDao {
	private static List<Insumo> insumos = new ArrayList<>();

	public String inserir(Insumo insumo) {
		insumos.add(insumo);
		String id = insumo.getId();
		if (null == id) {
			id = String.valueOf(insumos.size() - 1);
			insumo.setId(id);
		}
		return id;
	}

	public List<Insumo> listar() {
		return insumos;
	}

	public void excluir(String id) {
		Insumo aRemover = null;
		for (Insumo insumo : insumos) {
			if (id.equals(insumo.getId())) {
				aRemover = insumo;
				break;
			}
		}
		insumos.remove(aRemover);
	}

	public void alterar(Insumo insumo) {
		String id = insumo.getId();
		insumos.remove(Integer.parseInt(id));
		insumos.add(Integer.parseInt(id), insumo);
	}
}

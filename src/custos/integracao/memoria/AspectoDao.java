package custos.integracao.memoria;

import java.util.ArrayList;
import java.util.List;

import custos.negocio.modelo.Aspecto;

public class AspectoDao {
	private static List<Aspecto> aspectos = new ArrayList<>();

	public String inserir(Aspecto aspecto) {
		aspectos.add(aspecto);
		String id = aspecto.getId();
		if (null == id) {
			id = String.valueOf(aspectos.size() - 1);
			aspecto.setId(id);
		}
		return id;
	}

	public List<Aspecto> listar() {
		return aspectos;
	}

	public void excluir(String id) {
		Aspecto aRemover = null;
		for (Aspecto aspecto : aspectos) {
			if (id.equals(aspecto.getId())) {
				aRemover = aspecto;
				break;
			}
		}
		aspectos.remove(aRemover);
	}

	public void alterar(Aspecto aspecto) {
		String id = aspecto.getId();
		aspectos.remove(Integer.parseInt(id));
		aspectos.add(Integer.parseInt(id), aspecto);
	}
}

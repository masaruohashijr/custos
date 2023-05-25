package custos.integracao.memoria;

import java.util.ArrayList;
import java.util.List;

import custos.negocio.modelo.Fato;

public class FatoDao {
	private static List<Fato> fatos = new ArrayList<>();

	public String inserir(Fato fato) {
		fatos.add(fato);
		String id = fato.getId();
		if (null == id) {
			id = String.valueOf(fatos.size() - 1);
			fato.setId(id);
		}
		return id;
	}

	public List<Fato> listar() {
		return fatos;
	}

	public void excluir(String id) {
		Fato aRemover = null;
		for (Fato fato : fatos) {
			if (id.equals(fato.getId())) {
				aRemover = fato;
				break;
			}
		}
		fatos.remove(aRemover);
	}

	public void alterar(Fato fato) {
		String id = fato.getId();
		fatos.remove(Integer.parseInt(id));
		fatos.add(Integer.parseInt(id), fato);
	}
}

package custos.integracao.memoria;

import java.util.ArrayList;
import java.util.List;

import custos.negocio.modelo.Produto;

public class ProdutoDao {
	private static List<Produto> objetos = new ArrayList<>();

	public String inserir(Produto objeto) {
		objetos.add(objeto);
		String id = objeto.getId();
		if (null == id) {
			id = String.valueOf(objetos.size() - 1);
			objeto.setId(id);
		}
		return id;
	}

	public List<Produto> listar() {
		return objetos;
	}

	public void excluir(String id) {
		Produto aRemover = null;
		for (Produto objeto : objetos) {
			if (id.equals(objeto.getId())) {
				aRemover = objeto;
				break;
			}
		}
		objetos.remove(aRemover);
	}

	public void alterar(Produto objeto) {
		String id = objeto.getId();
		objetos.remove(Integer.parseInt(id));
		objetos.add(Integer.parseInt(id), objeto);
	}
}

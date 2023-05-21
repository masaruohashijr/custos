package custos.integracao.csv;

import custos.negocio.Model;
import custos.negocio.modelo.Produto;

public class ProdutoCSVDao extends CSVDao{

	@Override
	protected Model build(String[] array) {
		String[] partes = array[0].split("-");
		Model objeto = new Produto(partes[0], partes[1]);
		return objeto;
	}
}
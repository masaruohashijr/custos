package custos.integracao.csv;

import custos.negocio.Model;
import custos.negocio.modelo.FatorProduto;

public class FatorProdutoCSVDao extends CSVDao{

	@Override
	protected Model build(String[] array) {
		String[] partes = array[0].split("-");
		Double fator = Double.valueOf(partes[2]);
		Model fatorProduto = new FatorProduto(partes[0], partes[1], fator);
		return fatorProduto;

	}
}
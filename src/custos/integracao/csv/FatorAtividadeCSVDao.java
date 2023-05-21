package custos.integracao.csv;

import custos.negocio.Model;
import custos.negocio.modelo.FatorAtividade;

public class FatorAtividadeCSVDao extends CSVDao{

	@Override
	protected Model build(String[] array) {
		String[] partes = array[0].split("-");
		Double fator = Double.valueOf(partes[2]);
		Model fatorAtividade = new FatorAtividade(partes[0], partes[1], fator);
		return fatorAtividade;
	}
}
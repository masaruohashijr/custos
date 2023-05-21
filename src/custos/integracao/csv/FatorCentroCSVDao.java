package custos.integracao.csv;

import custos.negocio.Model;
import custos.negocio.modelo.FatorCentro;

public class FatorCentroCSVDao extends CSVDao{

	@Override
	protected Model build(String[] array) {
		String[] partes = array[0].split("-");
		Double fator = Double.valueOf(partes[2]);
		Model fatorCentro = new FatorCentro(partes[0], partes[1], fator);
		return fatorCentro;
	}
}
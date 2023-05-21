package custos.integracao.csv;

import custos.negocio.Model;
import custos.negocio.modelo.FatorAspecto;

public class FatorAspectoCSVDao extends CSVDao{

	@Override
	protected Model build(String[] array) {
		String[] partes = array[0].split("-");
		Double fator = Double.valueOf(partes[2]);
		Model fatorAspecto = new FatorAspecto(partes[0], partes[1], fator);
		return fatorAspecto;
	}
}
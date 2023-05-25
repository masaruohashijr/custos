package custos.integracao.csv;

import custos.negocio.Model;
import custos.negocio.modelo.Fato;

public class FatoCSVDao extends CSVDao{

	@Override
	protected Model build(String[] array) {
		String[] partes = array[0].trim().split("-");
		Double valor = Double.valueOf(partes[2]);
		Model fato = new Fato(partes[0].trim(), partes[1].trim(), valor);
		return fato;
	}
}
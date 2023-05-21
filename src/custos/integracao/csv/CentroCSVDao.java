package custos.integracao.csv;

import custos.negocio.Model;
import custos.negocio.modelo.Centro;

public class CentroCSVDao extends CSVDao{

	@Override
	protected Model build(String[] array) {
		String[] partes = array[0].split(",");
		Model centro = new Centro(partes[0], partes[1], partes[2]);
		return centro;
	}
}
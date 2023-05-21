package custos.integracao.csv;

import custos.negocio.Model;
import custos.negocio.modelo.Aspecto;

public class AspectoCSVDao extends CSVDao{

	@Override
	protected Model build(String[] array) {
		String[] partes = array[0].split("-");
		Model aspecto = new Aspecto(partes[0], partes[1]);
		return aspecto;
	}
}
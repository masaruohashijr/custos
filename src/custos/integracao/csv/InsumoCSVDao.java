package custos.integracao.csv;

import custos.negocio.Model;
import custos.negocio.modelo.Insumo;

public class InsumoCSVDao extends CSVDao{

	@Override
	protected Model build(String[] array) {
		String[] partes = array[0].split("-");
		Model insumo = new Insumo(partes[0], partes[1]);
		return insumo;
	}
}
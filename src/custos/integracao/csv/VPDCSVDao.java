package custos.integracao.csv;

import custos.negocio.Model;
import custos.negocio.modelo.VPD;

public class VPDCSVDao extends CSVDao{

	@Override
	protected Model build(String[] array) {
		String[] partes = array[0].split("-");
		Model vpd = new VPD(partes[0], partes[1]);
		return vpd;
	}
}
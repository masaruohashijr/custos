package custos.integracao.csv;

import custos.negocio.Model;
import custos.negocio.modelo.Atividade;

public class AtividadeCSVDao extends CSVDao{

	@Override
	protected Model build(String[] array) {
		String[] partes = array[0].split("-");
		Model atividade = new Atividade(partes[0].trim(), partes[1].trim());
		return atividade;
	}
}
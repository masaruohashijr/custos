package custos.apresentacao.comando.ditribuicao.atividade;

import java.util.ArrayList;
import java.util.List;

import custos.apresentacao.Console;
import custos.apresentacao.Tela;
import custos.apresentacao.comando.Comando;
import custos.apresentacao.comando.Menu;
import custos.integracao.memoria.AtividadeDao;
import custos.integracao.memoria.FatorAtividadeDao;
import custos.negocio.modelo.FatorAtividade;

public class ListarDistribuicaoAtividade extends Console implements Comando {
	
	private String id;
	private FatorAtividadeDao dao = new FatorAtividadeDao();
	private List<Menu> menus = new ArrayList<>();
	public ListarDistribuicaoAtividade(String id) {
		this.id = id;
		menus.add(new Menu(9, "PARA VOLTAR"));
	}

	@Override
	public Tela executar() {
		printf("Listar Distribuições de Insumos por Atividades");
		Tela tela = new Tela("");
		List<FatorAtividade> fatores = dao.listar();
		fatores.stream().forEach(v -> tela.escrever(v.getId() + " - " + v.getIdInsumo() + " - " + v.getIdAtividade() + " - " + v.getFator()));
		tela.escrever("-----");
		menus.stream().forEach(m -> tela.escrever(m.getId() + " - " + m.getTitulo()));
		return tela;
	}

	@Override
	public String getId() {
		return this.id;
	}

}


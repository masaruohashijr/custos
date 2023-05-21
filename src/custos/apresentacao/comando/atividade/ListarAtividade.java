package custos.apresentacao.comando.atividade;

import java.util.ArrayList;
import java.util.List;

import custos.apresentacao.Console;
import custos.apresentacao.Tela;
import custos.apresentacao.comando.Comando;
import custos.apresentacao.comando.Menu;
import custos.integracao.memoria.AtividadeDao;
import custos.negocio.modelo.Atividade;

public class ListarAtividade extends Console implements Comando {
	
	private String id;
	private AtividadeDao dao = new AtividadeDao();
	private List<Menu> menus = new ArrayList<>();
	public ListarAtividade(String id) {
		this.id = id;
		menus.add(new Menu(9, "PARA VOLTAR"));
	}

	@Override
	public Tela executar() {
		printf("Listar Atividades");
		Tela tela = new Tela("");
		List<Atividade> atividades = dao.listar();
		atividades.stream().forEach(v -> tela.escrever(v.getId() + " - " + v.getNome()));
		tela.escrever("-----");
		menus.stream().forEach(m -> tela.escrever(m.getId() + " - " + m.getTitulo()));
		return tela;
	}

	@Override
	public String getId() {
		return this.id;
	}

}


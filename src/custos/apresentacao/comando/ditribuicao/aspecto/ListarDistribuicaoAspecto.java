package custos.apresentacao.comando.ditribuicao.aspecto;

import java.util.ArrayList;
import java.util.List;

import custos.apresentacao.Console;
import custos.apresentacao.Tela;
import custos.apresentacao.comando.Comando;
import custos.apresentacao.comando.Menu;
import custos.integracao.memoria.FatorAspectoDao;
import custos.negocio.modelo.FatorAspecto;

public class ListarDistribuicaoAspecto extends Console implements Comando {
	
	private String id;
	private FatorAspectoDao dao = new FatorAspectoDao();
	private List<Menu> menus = new ArrayList<>();
	public ListarDistribuicaoAspecto(String id) {
		this.id = id;
		menus.add(new Menu(9, "PARA VOLTAR"));
	}

	@Override
	public Tela executar() {
		printf("Listar Aspectos");
		Tela tela = new Tela("");
		List<FatorAspecto> fatores = dao.listar();
		fatores.stream().forEach(v -> tela.escrever(v.getId() + " - " + v.getIdAtividade() + " - " + v.getIdAspecto() + " - " + v.getFator()));
		tela.escrever("-----");
		menus.stream().forEach(m -> tela.escrever(m.getId() + " - " + m.getTitulo()));
		return tela;
	}

	@Override
	public String getId() {
		return this.id;
	}

}


package custos.apresentacao.comando.ditribuicao.produto;

import java.util.ArrayList;
import java.util.List;

import custos.apresentacao.Console;
import custos.apresentacao.Tela;
import custos.apresentacao.comando.Comando;
import custos.apresentacao.comando.Menu;
import custos.integracao.memoria.FatorProdutoDao;
import custos.negocio.modelo.FatorProduto;

public class ListarDistribuicaoProduto extends Console implements Comando {
	
	private String id;
	private FatorProdutoDao dao = new FatorProdutoDao();
	private List<Menu> menus = new ArrayList<>();
	public ListarDistribuicaoProduto(String id) {
		this.id = id;
		menus.add(new Menu(9, "PARA VOLTAR"));
	}

	@Override
	public Tela executar() {
		printf("Listar Distribuições de Atividades em Produtos");
		Tela tela = new Tela("");
		List<FatorProduto> fatores = dao.listar();
		fatores.stream().forEach(v -> tela.escrever(v.getId() + " - " + v.getIdAtividade() + " - " + v.getIdProduto() + " - " + v.getFator()));
		tela.escrever("-----");
		menus.stream().forEach(m -> tela.escrever(m.getId() + " - " + m.getTitulo()));
		return tela;
	}

	@Override
	public String getId() {
		return this.id;
	}

}


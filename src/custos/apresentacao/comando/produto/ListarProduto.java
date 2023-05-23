package custos.apresentacao.comando.produto;

import java.util.ArrayList;
import java.util.List;

import custos.apresentacao.Console;
import custos.apresentacao.Tela;
import custos.apresentacao.comando.Comando;
import custos.apresentacao.comando.Menu;
import custos.integracao.memoria.ProdutoDao;
import custos.negocio.modelo.Produto;

public class ListarProduto extends Console implements Comando {
	
	private String id;
	private ProdutoDao dao = new ProdutoDao();
	private List<Menu> menus = new ArrayList<>();
	public ListarProduto(String id) {
		this.id = id;
		menus.add(new Menu(9, "PARA VOLTAR"));
	}

	@Override
	public Tela executar() {
		printf("Listar Produto");
		Tela tela = new Tela("");
		List<Produto> insumos = dao.listar();
		insumos.stream().forEach(v -> tela.escrever(v.getId() + " - " + v.getNome()));
		tela.escrever("-----");
		menus.stream().forEach(m -> tela.escrever(m.getId() + " - " + m.getTitulo()));
		return tela;
	}

	@Override
	public String getId() {
		return this.id;
	}

}


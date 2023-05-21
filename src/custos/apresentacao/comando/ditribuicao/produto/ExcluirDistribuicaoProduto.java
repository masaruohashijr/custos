package custos.apresentacao.comando.ditribuicao.produto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import custos.apresentacao.Console;
import custos.apresentacao.Tela;
import custos.apresentacao.comando.Comando;
import custos.apresentacao.comando.Menu;
import custos.integracao.memoria.FatorProdutoDao;

public class ExcluirDistribuicaoProduto extends Console implements Comando {
	
	private String id;
	private FatorProdutoDao dao = new FatorProdutoDao();
	private List<Menu> menus = new ArrayList<>();
	public ExcluirDistribuicaoProduto(String id) {
		this.id = id;
		menus.add(new Menu(9, "PARA VOLTAR"));
	}

	@Override
	public Tela executar() {
		printf("Excluir Distribuição de Atividade por Produto");
		Tela tela = new Tela("");
		print("Informe o ID da Distribuição de Atividades por Produtos");
		Scanner scanner = new Scanner(System.in);
		String dado = scanner.nextLine();
		dao.excluir(dado);
		tela.escrever("-----");
		tela.escrever("Distribuição de Atividades por Produtos excluída com SUCESSO!");
		tela.escrever("-----");
		menus.stream().forEach(m -> tela.escrever(m.getId() + " - " + m.getTitulo()));
		return tela;
	}

	@Override
	public String getId() {
		return this.id;
	}

}


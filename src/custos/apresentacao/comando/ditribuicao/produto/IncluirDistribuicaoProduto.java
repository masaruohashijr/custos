package custos.apresentacao.comando.ditribuicao.produto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import custos.apresentacao.Console;
import custos.apresentacao.Tela;
import custos.apresentacao.comando.Comando;
import custos.apresentacao.comando.Menu;
import custos.integracao.memoria.FatorProdutoDao;
import custos.negocio.modelo.FatorProduto;

public class IncluirDistribuicaoProduto extends Console implements Comando {
	
	private String id;
	private FatorProdutoDao dao = new FatorProdutoDao();
	private List<Menu> menus = new ArrayList<>();
	public IncluirDistribuicaoProduto(String id) {
		this.id = id;
		menus.add(new Menu(9, "PARA VOLTAR"));
	}

	@Override
	public Tela executar() {
		printf("Incluir Distribuição de Atividade em Produto");
		Tela tela = new Tela("");
		print("Informe o ID da Atividade, o ID do Produto e o valor separados por (;):");
		Scanner scanner = new Scanner(System.in);
		String dado = scanner.nextLine();
		FatorProduto fator = build(dado);
		String id = dao.inserir(fator);
		tela.escrever("-----");
		tela.escrever("Distribuição de Atividades por Produtos incluída com SUCESSO!");
		tela.escrever("-----");
		tela.escrever(String.valueOf(fator));
		tela.escrever("-----");
		menus.stream().forEach(m -> tela.escrever(m.getId() + " - " + m.getTitulo()));
		return tela;
	}

	private FatorProduto build(String dado) {
		String[] split = dado.split(";");
		Double fator = Double.valueOf(split[2]);
		FatorProduto fatorProduto = new FatorProduto(split[0],split[1],fator);
		return fatorProduto;
	}

	@Override
	public String getId() {
		return this.id;
	}

}


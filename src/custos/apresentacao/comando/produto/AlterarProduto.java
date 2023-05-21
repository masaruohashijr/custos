package custos.apresentacao.comando.produto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import custos.apresentacao.Console;
import custos.apresentacao.Tela;
import custos.apresentacao.comando.Comando;
import custos.apresentacao.comando.Menu;
import custos.integracao.memoria.ProdutoDao;
import custos.negocio.modelo.Produto;

public class AlterarProduto extends Console implements Comando {
	
	private String id;
	private ProdutoDao dao = new ProdutoDao();
	private List<Menu> menus = new ArrayList<>();
	public AlterarProduto(String id) {
		this.id = id;
		menus.add(new Menu(9, "PARA VOLTAR"));
	}

	@Override
	public Tela executar() {
		printf("Alterar Objeto");
		Tela tela = new Tela("");
		print("Informe o ID e o NOME da Objeto separados por (;):");
		Scanner scanner = new Scanner(System.in);
		String dado = scanner.nextLine();
		Produto objeto = build(dado);
		dao.alterar(objeto);
		tela.escrever("-----");
		tela.escrever("Objeto alterada com SUCESSO!");
		tela.escrever("-----");
		tela.escrever(String.valueOf(objeto));
		tela.escrever("-----");
		menus.stream().forEach(m -> tela.escrever(m.getId() + " - " + m.getTitulo()));
		return tela;
	}

	private Produto build(String dado) {
		String[] split = dado.split(";");
		Produto objeto = new Produto(split[0]);
		return objeto;
	}

	@Override
	public String getId() {
		return this.id;
	}

}


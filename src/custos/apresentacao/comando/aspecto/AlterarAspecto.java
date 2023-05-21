package custos.apresentacao.comando.aspecto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import custos.apresentacao.Console;
import custos.apresentacao.Tela;
import custos.apresentacao.comando.Comando;
import custos.apresentacao.comando.Menu;
import custos.integracao.memoria.AspectoDao;
import custos.negocio.modelo.Aspecto;

public class AlterarAspecto extends Console implements Comando {
	
	private String id;
	private AspectoDao dao = new AspectoDao();
	private List<Menu> menus = new ArrayList<>();
	public AlterarAspecto(String id) {
		this.id = id;
		menus.add(new Menu(9, "PARA VOLTAR"));
	}

	@Override
	public Tela executar() {
		printf("Alterar Aspecto");
		Tela tela = new Tela("");
		print("Informe o ID e o NOME da Aspecto separados por (;):");
		Scanner scanner = new Scanner(System.in);
		String dado = scanner.nextLine();
		Aspecto aspecto = build(dado);
		dao.alterar(aspecto);
		tela.escrever("-----");
		tela.escrever("Aspecto alterada com SUCESSO!");
		tela.escrever("-----");
		tela.escrever(String.valueOf(aspecto));
		tela.escrever("-----");
		menus.stream().forEach(m -> tela.escrever(m.getId() + " - " + m.getTitulo()));
		return tela;
	}

	private Aspecto build(String dado) {
		String[] split = dado.split(";");
		Aspecto aspecto = new Aspecto(split[0]);
		return aspecto;
	}

	@Override
	public String getId() {
		return this.id;
	}

}


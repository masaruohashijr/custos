package custos.apresentacao.comando.ditribuicao.aspecto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import custos.apresentacao.Console;
import custos.apresentacao.Tela;
import custos.apresentacao.comando.Comando;
import custos.apresentacao.comando.Menu;
import custos.integracao.memoria.FatorAspectoDao;
import custos.negocio.modelo.FatorAspecto;

public class IncluirDistribuicaoAspecto extends Console implements Comando {
	
	private String id;
	private FatorAspectoDao dao = new FatorAspectoDao();
	private List<Menu> menus = new ArrayList<>();
	public IncluirDistribuicaoAspecto(String id) {
		this.id = id;
		menus.add(new Menu(9, "PARA VOLTAR"));
	}

	@Override
	public Tela executar() {
		printf("Incluir Aspecto");
		Tela tela = new Tela("");
		print("Informe o ID da Atividade, o ID do Aspecto e o valor separados por (;):");
		Scanner scanner = new Scanner(System.in);
		String dado = scanner.nextLine();
		FatorAspecto fator = build(dado);
		String id = dao.inserir(fator);
		tela.escrever("-----");
		tela.escrever("Distribuição de Atividades por Aspectos incluída com SUCESSO!");
		tela.escrever("-----");
		tela.escrever(String.valueOf(fator));
		tela.escrever("-----");
		menus.stream().forEach(m -> tela.escrever(m.getId() + " - " + m.getTitulo()));
		return tela;
	}

	private FatorAspecto build(String dado) {
		String[] split = dado.split(";");
		Double fator = Double.valueOf(split[2]);
		FatorAspecto fatorAspecto = new FatorAspecto(split[0],split[1],fator);
		return fatorAspecto;
	}

	@Override
	public String getId() {
		return this.id;
	}

}


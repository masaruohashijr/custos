package custos.apresentacao.comando.ditribuicao.centro;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import custos.apresentacao.Console;
import custos.apresentacao.Tela;
import custos.apresentacao.comando.Comando;
import custos.apresentacao.comando.Menu;
import custos.integracao.memoria.FatorCentroDao;
import custos.negocio.modelo.FatorCentro;

public class AlterarDistribuicaoCentro extends Console implements Comando {
	
	private String id;
	private FatorCentroDao dao = new FatorCentroDao();
	private List<Menu> menus = new ArrayList<>();
	public AlterarDistribuicaoCentro(String id) {
		this.id = id;
		menus.add(new Menu(9, "PARA VOLTAR"));
	}

	@Override
	public Tela executar() {
		printf("Alterar Distribuição de Atividades por Centros");
		Tela tela = new Tela("");
		print("Informe o ID, o ID da Atividade, o ID do Centro e o valor separados por (;):");
		Scanner scanner = new Scanner(System.in);
		String dado = scanner.nextLine();
		FatorCentro atividade = build(dado);
		dao.alterar(atividade);
		tela.escrever("-----");
		tela.escrever("Distribuição de Atividades por Centros alterada com SUCESSO!");
		tela.escrever("-----");
		tela.escrever(String.valueOf(atividade));
		tela.escrever("-----");
		menus.stream().forEach(m -> tela.escrever(m.getId() + " - " + m.getTitulo()));
		return tela;
	}

	private FatorCentro build(String dado) {
		String[] split = dado.split(";");
		Double fator = Double.valueOf(split[3]);
		FatorCentro fatorCentro = new FatorCentro(split[0],split[1],split[3],fator);
		return fatorCentro;
	}

	@Override
	public String getId() {
		return this.id;
	}

}


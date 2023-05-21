package custos.apresentacao.comando.ditribuicao.centro;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import custos.apresentacao.Console;
import custos.apresentacao.Tela;
import custos.apresentacao.comando.Comando;
import custos.apresentacao.comando.Menu;
import custos.integracao.memoria.FatorCentroDao;

public class ExcluirDistribuicaoCentro extends Console implements Comando {
	
	private String id;
	private FatorCentroDao dao = new FatorCentroDao();
	private List<Menu> menus = new ArrayList<>();
	public ExcluirDistribuicaoCentro(String id) {
		this.id = id;
		menus.add(new Menu(9, "PARA VOLTAR"));
	}

	@Override
	public Tela executar() {
		printf("Excluir Distribuição de Atividades por Centros");
		Tela tela = new Tela("");
		print("Informe o ID da Distribuição de Atividades por Centros");
		Scanner scanner = new Scanner(System.in);
		String dado = scanner.nextLine();
		dao.excluir(dado);
		tela.escrever("-----");
		tela.escrever("Distribuição de Atividades por Centros excluída com SUCESSO!");
		tela.escrever("-----");
		menus.stream().forEach(m -> tela.escrever(m.getId() + " - " + m.getTitulo()));
		return tela;
	}

	@Override
	public String getId() {
		return this.id;
	}

}


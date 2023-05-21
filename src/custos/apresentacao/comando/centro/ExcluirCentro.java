package custos.apresentacao.comando.centro;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import custos.apresentacao.Console;
import custos.apresentacao.Tela;
import custos.apresentacao.comando.Comando;
import custos.apresentacao.comando.Menu;
import custos.integracao.memoria.CentroDao;

public class ExcluirCentro extends Console implements Comando {
	
	private String id;
	private CentroDao dao = new CentroDao();
	private List<Menu> menus = new ArrayList<>();
	public ExcluirCentro(String id) {
		this.id = id;
		menus.add(new Menu(9, "PARA VOLTAR"));
	}

	@Override
	public Tela executar() {
		printf("Excluir Centro");
		Tela tela = new Tela("");
		print("Informe o ID da Centro");
		Scanner scanner = new Scanner(System.in);
		String dado = scanner.nextLine();
		dao.excluir(dado);
		tela.escrever("-----");
		tela.escrever("Centro excluído com SUCESSO!");
		tela.escrever("-----");
		menus.stream().forEach(m -> tela.escrever(m.getId() + " - " + m.getTitulo()));
		return tela;
	}

	@Override
	public String getId() {
		return this.id;
	}

}


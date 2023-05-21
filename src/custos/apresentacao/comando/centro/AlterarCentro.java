package custos.apresentacao.comando.centro;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import custos.apresentacao.Console;
import custos.apresentacao.Tela;
import custos.apresentacao.comando.Comando;
import custos.apresentacao.comando.Menu;
import custos.integracao.memoria.CentroDao;
import custos.negocio.modelo.Centro;

public class AlterarCentro extends Console implements Comando {
	
	private String id;
	private CentroDao dao = new CentroDao();
	private List<Menu> menus = new ArrayList<>();
	public AlterarCentro(String id) {
		this.id = id;
		menus.add(new Menu(9, "PARA VOLTAR"));
	}

	@Override
	public Tela executar() {
		printf("Alterar Centro");
		Tela tela = new Tela("");
		print("Informe o ID e o NOME da Centro separados por (;):");
		Scanner scanner = new Scanner(System.in);
		String dado = scanner.nextLine();
		Centro centro = build(dado);
		dao.alterar(centro);
		tela.escrever("-----");
		tela.escrever("Centro alterado com SUCESSO!");
		tela.escrever("-----");
		tela.escrever(String.valueOf(centro));
		tela.escrever("-----");
		menus.stream().forEach(m -> tela.escrever(m.getId() + " - " + m.getTitulo()));
		return tela;
	}

	private Centro build(String dado) {
		String[] split = dado.split(";");
		Centro centro = new Centro(split[0]);
		return centro;
	}

	@Override
	public String getId() {
		return this.id;
	}

}


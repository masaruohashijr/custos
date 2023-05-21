package custos.apresentacao.comando.insumo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import custos.apresentacao.Console;
import custos.apresentacao.Tela;
import custos.apresentacao.comando.Comando;
import custos.apresentacao.comando.Menu;
import custos.integracao.memoria.InsumoDao;
import custos.negocio.modelo.Insumo;

public class AlterarInsumo extends Console implements Comando {
	
	private String id;
	private InsumoDao dao = new InsumoDao();
	private List<Menu> menus = new ArrayList<>();
	public AlterarInsumo(String id) {
		this.id = id;
		menus.add(new Menu(9, "PARA VOLTAR"));
	}

	@Override
	public Tela executar() {
		printf("Alterar Insumo");
		Tela tela = new Tela("");
		print("Informe o ID e o NOME da Insumo separados por (;):");
		Scanner scanner = new Scanner(System.in);
		String dado = scanner.nextLine();
		Insumo insumo = build(dado);
		dao.alterar(insumo);
		tela.escrever("-----");
		tela.escrever("Insumo alterada com SUCESSO!");
		tela.escrever("-----");
		tela.escrever(String.valueOf(insumo));
		tela.escrever("-----");
		menus.stream().forEach(m -> tela.escrever(m.getId() + " - " + m.getTitulo()));
		return tela;
	}

	private Insumo build(String dado) {
		String[] split = dado.split(";");
		Insumo insumo = new Insumo(split[0],split[1]);
		return insumo;
	}

	@Override
	public String getId() {
		return this.id;
	}

}


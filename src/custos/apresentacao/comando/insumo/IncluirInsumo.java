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

public class IncluirInsumo extends Console implements Comando {
	
	private String id;
	private InsumoDao dao = new InsumoDao();
	private List<Menu> menus = new ArrayList<>();
	public IncluirInsumo(String id) {
		this.id = id;
		menus.add(new Menu(9, "PARA VOLTAR"));
	}

	@Override
	public Tela executar() {
		printf("Incluir Insumo");
		Tela tela = new Tela("");
		print("Informe o NOME da Insumo");
		Scanner scanner = new Scanner(System.in);
		String dado = scanner.nextLine();
		Insumo insumo = build(dado);
		String id = dao.inserir(insumo);
		tela.escrever("-----");
		tela.escrever("Insumo incluída com SUCESSO!");
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


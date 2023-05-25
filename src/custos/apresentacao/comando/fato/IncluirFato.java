package custos.apresentacao.comando.fato;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import custos.apresentacao.Console;
import custos.apresentacao.Tela;
import custos.apresentacao.comando.Comando;
import custos.apresentacao.comando.Menu;
import custos.integracao.memoria.FatoDao;
import custos.negocio.modelo.Fato;

public class IncluirFato extends Console implements Comando {
	
	private String id;
	private FatoDao dao = new FatoDao();
	private List<Menu> menus = new ArrayList<>();
	public IncluirFato(String id) {
		this.id = id;
		menus.add(new Menu(9, "PARA VOLTAR"));
	}

	@Override
	public Tela executar() {
		printf("Incluir Fato");
		Tela tela = new Tela("");
		print("Informe a VPD e o valor da Fato");
		Scanner scanner = new Scanner(System.in);
		String dado = scanner.nextLine();
		Fato insumo = build(dado);
		String id = dao.inserir(insumo);
		tela.escrever("-----");
		tela.escrever("Fato "+id+" incluído com SUCESSO!");
		tela.escrever("-----");
		tela.escrever(String.valueOf(insumo));
		tela.escrever("-----");
		menus.stream().forEach(m -> tela.escrever(m.getId() + " - " + m.getTitulo()));
		return tela;
	}

	private Fato build(String dado) {
		String[] split = dado.split(";");
		Double valor = Double.valueOf(split[1]);
		Fato insumo = new Fato(split[0],valor);
		return insumo;
	}

	@Override
	public String getId() {
		return this.id;
	}

}


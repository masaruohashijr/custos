package custos.apresentacao.comando.vpd;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import custos.apresentacao.Console;
import custos.apresentacao.Tela;
import custos.apresentacao.comando.Comando;
import custos.apresentacao.comando.Menu;
import custos.integracao.memoria.VPDDao;
import custos.negocio.modelo.VPD;

public class IncluirVPD extends Console implements Comando {
	
	private String id;
	private VPDDao dao = new VPDDao();
	private List<Menu> menus = new ArrayList<>();
	public IncluirVPD(String id) {
		this.id = id;
		menus.add(new Menu(9, "PARA VOLTAR"));
	}

	@Override
	public Tela executar() {
		printf("Incluir VPD");
		Tela tela = new Tela("");
		print("Informe o NOME da VPD");
		Scanner scanner = new Scanner(System.in);
		String dado = scanner.nextLine();
		VPD vpd = build(dado);
		String id = dao.inserir(vpd);
		tela.escrever("-----");
		tela.escrever("VPD incluída com SUCESSO!");
		tela.escrever("-----");
		tela.escrever(String.valueOf(vpd));
		tela.escrever("-----");
		menus.stream().forEach(m -> tela.escrever(m.getId() + " - " + m.getTitulo()));
		return tela;
	}

	private VPD build(String dado) {
		VPD vpd = new VPD(dado);
		return vpd;
	}

	@Override
	public String getId() {
		return this.id;
	}

}


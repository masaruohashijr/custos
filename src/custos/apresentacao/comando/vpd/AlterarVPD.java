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

public class AlterarVPD extends Console implements Comando {
	
	private String id;
	private VPDDao dao = new VPDDao();
	private List<Menu> menus = new ArrayList<>();
	public AlterarVPD(String id) {
		this.id = id;
		menus.add(new Menu(9, "PARA VOLTAR"));
	}

	@Override
	public Tela executar() {
		printf("Alterar VPD");
		Tela tela = new Tela("");
		print("Informe o ID e o NOME da VPD separados por (;):");
		Scanner scanner = new Scanner(System.in);
		String dado = scanner.nextLine();
		VPD vpd = build(dado);
		dao.alterar(vpd);
		tela.escrever("-----");
		tela.escrever("VPD alterada com SUCESSO!");
		tela.escrever("-----");
		tela.escrever(String.valueOf(vpd));
		tela.escrever("-----");
		menus.stream().forEach(m -> tela.escrever(m.getId() + " - " + m.getTitulo()));
		return tela;
	}

	private VPD build(String dado) {
		String[] split = dado.split(";");
		VPD vpd = new VPD(split[0],split[1]);
		return vpd;
	}

	@Override
	public String getId() {
		return this.id;
	}

}


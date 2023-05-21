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

public class ExcluirVPD extends Console implements Comando {
	
	private String id;
	private VPDDao dao = new VPDDao();
	private List<Menu> menus = new ArrayList<>();
	public ExcluirVPD(String id) {
		this.id = id;
		menus.add(new Menu(9, "PARA VOLTAR"));
	}

	@Override
	public Tela executar() {
		printf("Excluir VPD");
		Tela tela = new Tela("");
		print("Informe o ID da VPD");
		Scanner scanner = new Scanner(System.in);
		String dado = scanner.nextLine();
		dao.excluir(dado);
		tela.escrever("-----");
		tela.escrever("VPD excluída com SUCESSO!");
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


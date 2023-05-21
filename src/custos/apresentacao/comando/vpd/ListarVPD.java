package custos.apresentacao.comando.vpd;

import java.util.ArrayList;
import java.util.List;

import custos.apresentacao.Console;
import custos.apresentacao.Tela;
import custos.apresentacao.comando.Comando;
import custos.apresentacao.comando.Menu;
import custos.integracao.memoria.VPDDao;
import custos.negocio.modelo.VPD;

public class ListarVPD extends Console implements Comando {
	
	private String id;
	private VPDDao dao = new VPDDao();
	private List<Menu> menus = new ArrayList<>();
	public ListarVPD(String id) {
		this.id = id;
		menus.add(new Menu(9, "PARA VOLTAR"));
	}

	@Override
	public Tela executar() {
		printf("Listar VPD");
		Tela tela = new Tela("");
		List<VPD> vpds = dao.listar();
		vpds.stream().forEach(v -> tela.escrever(v.getId() + " - " + v.getNome()));
		tela.escrever("-----");
		menus.stream().forEach(m -> tela.escrever(m.getId() + " - " + m.getTitulo()));
		return tela;
	}

	@Override
	public String getId() {
		return this.id;
	}

}


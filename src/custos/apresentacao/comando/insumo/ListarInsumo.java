package custos.apresentacao.comando.insumo;

import java.util.ArrayList;
import java.util.List;

import custos.apresentacao.Console;
import custos.apresentacao.Tela;
import custos.apresentacao.comando.Comando;
import custos.apresentacao.comando.Menu;
import custos.integracao.memoria.InsumoDao;
import custos.negocio.modelo.Insumo;

public class ListarInsumo extends Console implements Comando {
	
	private String id;
	private InsumoDao dao = new InsumoDao();
	private List<Menu> menus = new ArrayList<>();
	public ListarInsumo(String id) {
		this.id = id;
		menus.add(new Menu(9, "PARA VOLTAR"));
	}

	@Override
	public Tela executar() {
		printf("Listar Insumo");
		Tela tela = new Tela("");
		List<Insumo> insumos = dao.listar();
		insumos.stream().forEach(v -> tela.escrever(v.getId() + " - " + v.getIdVPD() + " - " + v.getNome()));
		tela.escrever("-----");
		menus.stream().forEach(m -> tela.escrever(m.getId() + " - " + m.getTitulo()));
		return tela;
	}

	@Override
	public String getId() {
		return this.id;
	}

}


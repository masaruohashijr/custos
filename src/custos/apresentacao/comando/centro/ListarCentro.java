package custos.apresentacao.comando.centro;

import java.util.ArrayList;
import java.util.List;

import custos.apresentacao.Console;
import custos.apresentacao.Tela;
import custos.apresentacao.comando.Comando;
import custos.apresentacao.comando.Menu;
import custos.integracao.memoria.CentroDao;
import custos.negocio.modelo.Centro;

public class ListarCentro extends Console implements Comando {
	
	private String id;
	private CentroDao dao = new CentroDao();
	private List<Menu> menus = new ArrayList<>();
	public ListarCentro(String id) {
		this.id = id;
		menus.add(new Menu(9, "PARA VOLTAR"));
	}

	@Override
	public Tela executar() {
		printf("Listar Centro");
		Tela tela = new Tela("");
		List<Centro> centros = dao.listar();
		centros.stream().forEach(v -> tela.escrever(v.getId() + " - " + v.getNome() + " - " + v.getAcronimo()));
		tela.escrever("-----");
		menus.stream().forEach(m -> tela.escrever(m.getId() + " - " + m.getTitulo()));
		return tela;
	}

	@Override
	public String getId() {
		return this.id;
	}

}


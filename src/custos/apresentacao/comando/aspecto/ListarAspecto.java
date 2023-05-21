package custos.apresentacao.comando.aspecto;

import java.util.ArrayList;
import java.util.List;

import custos.apresentacao.Console;
import custos.apresentacao.Tela;
import custos.apresentacao.comando.Comando;
import custos.apresentacao.comando.Menu;
import custos.integracao.memoria.AspectoDao;
import custos.negocio.modelo.Aspecto;

public class ListarAspecto extends Console implements Comando {
	
	private String id;
	private AspectoDao dao = new AspectoDao();
	private List<Menu> menus = new ArrayList<>();
	public ListarAspecto(String id) {
		this.id = id;
		menus.add(new Menu(9, "PARA VOLTAR"));
	}

	@Override
	public Tela executar() {
		printf("Listar Aspecto");
		Tela tela = new Tela("");
		List<Aspecto> aspectos = dao.listar();
		aspectos.stream().forEach(v -> tela.escrever(v.getId() + " - " + v.getNome()));
		tela.escrever("-----");
		menus.stream().forEach(m -> tela.escrever(m.getId() + " - " + m.getTitulo()));
		return tela;
	}

	@Override
	public String getId() {
		return this.id;
	}

}


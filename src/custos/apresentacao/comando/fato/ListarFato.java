package custos.apresentacao.comando.fato;

import java.util.ArrayList;
import java.util.List;

import custos.apresentacao.Console;
import custos.apresentacao.Tela;
import custos.apresentacao.comando.Comando;
import custos.apresentacao.comando.Menu;
import custos.integracao.memoria.FatoDao;
import custos.negocio.modelo.Fato;

public class ListarFato extends Console implements Comando {
	
	private String id;
	private FatoDao dao = new FatoDao();
	private List<Menu> menus = new ArrayList<>();
	public ListarFato(String id) {
		this.id = id;
		menus.add(new Menu(9, "PARA VOLTAR"));
	}

	@Override
	public Tela executar() {
		printf("Listar Fato");
		Tela tela = new Tela("");
		List<Fato> fatos = dao.listar();
		fatos.stream().forEach(v -> tela.escrever(v.getId() + " - " + v.getVpd() + " - " + v.getValor()));
		tela.escrever("-----");
		menus.stream().forEach(m -> tela.escrever(m.getId() + " - " + m.getTitulo()));
		return tela;
	}

	@Override
	public String getId() {
		return this.id;
	}

}


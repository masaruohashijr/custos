package custos.apresentacao.comando.ditribuicao.centro;

import java.util.ArrayList;
import java.util.List;

import custos.apresentacao.Console;
import custos.apresentacao.Tela;
import custos.apresentacao.comando.Comando;
import custos.apresentacao.comando.Menu;
import custos.integracao.memoria.FatorCentroDao;
import custos.negocio.modelo.FatorCentro;

public class ListarDistribuicaoCentro extends Console implements Comando {
	
	private String id;
	private FatorCentroDao dao = new FatorCentroDao();
	private List<Menu> menus = new ArrayList<>();
	public ListarDistribuicaoCentro(String id) {
		this.id = id;
		menus.add(new Menu(9, "PARA VOLTAR"));
	}

	@Override
	public Tela executar() {
		printf("Listar Centros");
		Tela tela = new Tela("");
		List<FatorCentro> fatores = dao.listar();
		fatores.stream().forEach(v -> tela.escrever(v.getId() + " - " + v.getIdAtividade() + " - " + v.getIdCentro() + " - " + v.getFator()));
		tela.escrever("-----");
		menus.stream().forEach(m -> tela.escrever(m.getId() + " - " + m.getTitulo()));
		return tela;
	}

	@Override
	public String getId() {
		return this.id;
	}

}


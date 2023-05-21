package custos.apresentacao.comando.ditribuicao.centro;

import java.util.ArrayList;
import java.util.List;

import custos.apresentacao.Console;
import custos.apresentacao.Tela;
import custos.apresentacao.comando.Comando;
import custos.apresentacao.comando.Menu;

public class MenuDistribuicaoCentro extends Console implements Comando {
	
	private String id;
	private List<Menu> menus = new ArrayList<>();
	public MenuDistribuicaoCentro(String id) {
		this.id = id;
		menus.add(new Menu(261, "Listar"));
		menus.add(new Menu(262, "Incluir"));
		menus.add(new Menu(263, "Alterar"));
		menus.add(new Menu(264, "Excluir"));
		menus.add(new Menu(9, "PARA VOLTAR"));
	}

	@Override
	public Tela executar() {
		printf("Distribuir Atividades em Centros");
		menus.stream().forEach(m -> print(m.getId() + " - " + m.getTitulo()));
		print("Selecione uma das opções acima:");
		return new Tela("");
	}

	@Override
	public String getId() {
		return this.id;
	}

}


package custos.apresentacao.comando;

import java.util.ArrayList;
import java.util.List;

import custos.apresentacao.Console;
import custos.apresentacao.Tela;

public class MenuPrincipal implements Comando {
	private String id;
	private List<Menu> menus = new ArrayList<>();

	public MenuPrincipal(String id) {
		this.id = id;
		menus.add(new Menu(1, "Cadastro"));
		menus.add(new Menu(2, "Configuração"));
		menus.add(new Menu(3, "Apropriação"));
		menus.add(new Menu(4, "Demonstração"));
		menus.add(new Menu(0, "PARA SAIR"));
	}

	@Override
	public Tela executar() {
		Console c = new Console();
		c.printf("CUSTOS");
		menus.stream().forEach(m -> c.print(m.getId() + " - " + m.getTitulo()));
		c.print("Selecione uma das opções acima:");
		return new Tela("");
	}

	@Override
	public String getId() {
		return this.id;
	}
}

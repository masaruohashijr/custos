package custos.apresentacao.comando.aspecto;

import java.util.ArrayList;
import java.util.List;

import custos.apresentacao.Console;
import custos.apresentacao.Tela;
import custos.apresentacao.comando.Comando;
import custos.apresentacao.comando.Menu;

public class MenuAspecto extends Console implements Comando {
	
	private String id;
	private List<Menu> menus = new ArrayList<>();
	public MenuAspecto(String id) {
		this.id = id;
		menus.add(new Menu(151, "Listar"));
		menus.add(new Menu(152, "Incluir"));
		menus.add(new Menu(153, "Alterar"));
		menus.add(new Menu(154, "Excluir"));
		menus.add(new Menu(9, "PARA VOLTAR"));
	}

	@Override
	public Tela executar() {
		printf("Aspecto");
		menus.stream().forEach(m -> print(m.getId() + " - " + m.getTitulo()));
		print("Selecione uma das opções acima:");
		return new Tela("");
	}

	@Override
	public String getId() {
		return this.id;
	}

}


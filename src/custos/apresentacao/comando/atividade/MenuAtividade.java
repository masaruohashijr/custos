package custos.apresentacao.comando.atividade;

import java.util.ArrayList;
import java.util.List;

import custos.apresentacao.Console;
import custos.apresentacao.Tela;
import custos.apresentacao.comando.Comando;
import custos.apresentacao.comando.Menu;

public class MenuAtividade extends Console implements Comando {
	
	private String id;
	private List<Menu> menus = new ArrayList<>();
	public MenuAtividade(String id) {
		this.id = id;
		menus.add(new Menu(131, "Listar"));
		menus.add(new Menu(132, "Incluir"));
		menus.add(new Menu(133, "Alterar"));
		menus.add(new Menu(134, "Excluir"));
		menus.add(new Menu(9, "PARA VOLTAR"));
	}

	@Override
	public Tela executar() {
		printf("Atividade");
		menus.stream().forEach(m -> print(m.getId() + " - " + m.getTitulo()));
		print("Selecione uma das opções acima:");
		return new Tela("");
	}

	@Override
	public String getId() {
		return this.id;
	}

}


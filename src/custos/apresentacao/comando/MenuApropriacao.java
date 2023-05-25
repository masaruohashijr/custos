package custos.apresentacao.comando;

import java.util.ArrayList;
import java.util.List;

import custos.apresentacao.Console;
import custos.apresentacao.Tela;

public class MenuApropriacao extends Console implements Comando {
	
	private String id;
	private List<Menu> menus = new ArrayList<>();
	public MenuApropriacao(String id) {
		this.id = id;
		menus.add(new Menu(31, "Fato"));
		menus.add(new Menu(32, "Nota de Apropriação"));
		menus.add(new Menu(9, "PARA VOLTAR"));		
	}

	@Override
	public Tela executar() {
		printf("APURAÇÃO");
		menus.stream().forEach(m -> print(m.getId() + " - " + m.getTitulo()));
		print("Selecione uma das opções acima:");
		return new Tela("");
	}

	@Override
	public String getId() {
		return this.id;
	}

}



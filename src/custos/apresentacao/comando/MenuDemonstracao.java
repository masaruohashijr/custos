package custos.apresentacao.comando;

import java.util.ArrayList;
import java.util.List;

import custos.apresentacao.Console;
import custos.apresentacao.Tela;

public class MenuDemonstracao extends Console implements Comando {
	
	private String id;
	private List<Menu> menus = new ArrayList<>();
	public MenuDemonstracao(String id) {
		this.id = id;
		menus.add(new Menu(31, "Centro"));
		menus.add(new Menu(32, "Aspecto"));
		menus.add(new Menu(33, "Objeto")); 
		menus.add(new Menu(9, "PARA VOLTAR"));		
	}

	@Override
	public Tela executar() {
		printf("DEMONSTRAÇÃO DO RESULTADO ECONÔMICO");
		menus.stream().forEach(m -> print(m.getId() + " - " + m.getTitulo()));
		print("Selecione uma das opções acima:");
		return new Tela("");
	}

	@Override
	public String getId() {
		return this.id;
	}

}


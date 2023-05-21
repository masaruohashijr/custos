package custos.apresentacao.comando;

import java.util.ArrayList;
import java.util.List;

import custos.apresentacao.Console;
import custos.apresentacao.Tela;

public class MenuCadastro extends Console implements Comando {
	
	private String id;
	private List<Menu> menus = new ArrayList<>();
	public MenuCadastro(String id) {
		this.id = id;
		menus.add(new Menu(11, "VPD"));
		menus.add(new Menu(12, "Insumo"));
		menus.add(new Menu(13, "Atividade"));
		menus.add(new Menu(14, "Produto")); // Apendicectomia 
		menus.add(new Menu(15, "Aspecto")); // QUALISUS I e QUALISUS II
		menus.add(new Menu(16, "Centro")); // Hospitais
		menus.add(new Menu(9, "PARA VOLTAR"));		
	}

	@Override
	public Tela executar() {
		printf("CADASTRO");
		menus.stream().forEach(m -> print(m.getId() + " - " + m.getTitulo()));
		print("Selecione uma das opções acima:");
		return new Tela("");
	}

	@Override
	public String getId() {
		return this.id;
	}

}


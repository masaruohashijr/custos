package custos.apresentacao.comando;

import java.util.ArrayList;
import java.util.List;

import custos.apresentacao.Console;
import custos.apresentacao.Tela;

public class MenuApuracao extends Console implements Comando {
	
	private String id;
	private List<Menu> menus = new ArrayList<>();
	public MenuApuracao(String id) {
		this.id = id;
		menus.add(new Menu(21, "Fato"));
		menus.add(new Menu(22, "Critério"));
		menus.add(new Menu(23, "Distribuir Insumos em Atividades"));// Insumo -> Atividade
		menus.add(new Menu(24, "Distribuir Atividades em Produtos"));// Atividade -> Produto
		menus.add(new Menu(25, "Distribuir Atividades em Aspectos"));// Atividade -> Aspecto
		menus.add(new Menu(26, "Distribuir Atividades em Centros"));// Atividade -> Centro
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


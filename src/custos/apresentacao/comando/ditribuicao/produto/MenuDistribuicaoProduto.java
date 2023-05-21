package custos.apresentacao.comando.ditribuicao.produto;

import java.util.ArrayList;
import java.util.List;

import custos.apresentacao.Console;
import custos.apresentacao.Tela;
import custos.apresentacao.comando.Comando;
import custos.apresentacao.comando.Menu;

public class MenuDistribuicaoProduto extends Console implements Comando {
	
	private String id;
	private List<Menu> menus = new ArrayList<>();
	public MenuDistribuicaoProduto(String id) {
		this.id = id;
		menus.add(new Menu(241, "Listar"));
		menus.add(new Menu(242, "Incluir"));
		menus.add(new Menu(243, "Alterar"));
		menus.add(new Menu(244, "Excluir"));
		menus.add(new Menu(9, "PARA VOLTAR"));
	}

	@Override
	public Tela executar() {
		printf("Distribuir Atividades em Produtos");
		menus.stream().forEach(m -> print(m.getId() + " - " + m.getTitulo()));
		print("Selecione uma das opções acima:");
		return new Tela("");
	}

	@Override
	public String getId() {
		return this.id;
	}

}


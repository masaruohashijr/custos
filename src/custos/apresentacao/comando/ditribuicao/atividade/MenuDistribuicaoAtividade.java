package custos.apresentacao.comando.ditribuicao.atividade;

import java.util.ArrayList;
import java.util.List;

import custos.apresentacao.Console;
import custos.apresentacao.Tela;
import custos.apresentacao.comando.Comando;
import custos.apresentacao.comando.Menu;

public class MenuDistribuicaoAtividade extends Console implements Comando {
	
	private String id;
	private List<Menu> menus = new ArrayList<>();
	public MenuDistribuicaoAtividade(String id) {
		this.id = id;
		menus.add(new Menu(221, "Listar"));
		menus.add(new Menu(222, "Incluir"));
		menus.add(new Menu(223, "Alterar"));
		menus.add(new Menu(224, "Excluir"));
		menus.add(new Menu(9, "PARA VOLTAR"));
	}

	@Override
	public Tela executar() {
		printf("Distribuir VPDs em Atividades");
		menus.stream().forEach(m -> print(m.getId() + " - " + m.getTitulo()));
		print("Selecione uma das opções acima:");
		return new Tela("");
	}

	@Override
	public String getId() {
		return this.id;
	}

}


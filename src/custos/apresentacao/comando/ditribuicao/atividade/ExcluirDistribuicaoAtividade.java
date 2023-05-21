package custos.apresentacao.comando.ditribuicao.atividade;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import custos.apresentacao.Console;
import custos.apresentacao.Tela;
import custos.apresentacao.comando.Comando;
import custos.apresentacao.comando.Menu;
import custos.integracao.memoria.FatorAtividadeDao;

public class ExcluirDistribuicaoAtividade extends Console implements Comando {
	
	private String id;
	private FatorAtividadeDao dao = new FatorAtividadeDao();
	private List<Menu> menus = new ArrayList<>();
	public ExcluirDistribuicaoAtividade(String id) {
		this.id = id;
		menus.add(new Menu(9, "PARA VOLTAR"));
	}

	@Override
	public Tela executar() {
		printf("Excluir Distribuição de Insumo por Atividade");
		Tela tela = new Tela("");
		print("Informe o ID da Distribuição de Insumos por Atividades");
		Scanner scanner = new Scanner(System.in);
		String dado = scanner.nextLine();
		dao.excluir(dado);
		tela.escrever("-----");
		tela.escrever("Distribuição de Insumos por Atividades excluída com SUCESSO!");
		tela.escrever("-----");
		menus.stream().forEach(m -> tela.escrever(m.getId() + " - " + m.getTitulo()));
		return tela;
	}

	@Override
	public String getId() {
		return this.id;
	}

}


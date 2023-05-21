package custos.apresentacao.comando.ditribuicao.atividade;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import custos.apresentacao.Console;
import custos.apresentacao.Tela;
import custos.apresentacao.comando.Comando;
import custos.apresentacao.comando.Menu;
import custos.integracao.memoria.FatorAtividadeDao;
import custos.negocio.modelo.FatorAtividade;

public class IncluirDistribuicaoAtividade extends Console implements Comando {
	
	private String id;
	private FatorAtividadeDao dao = new FatorAtividadeDao();
	private List<Menu> menus = new ArrayList<>();
	public IncluirDistribuicaoAtividade(String id) {
		this.id = id;
		menus.add(new Menu(9, "PARA VOLTAR"));
	}

	@Override
	public Tela executar() {
		printf("Incluir Distribuição de Insumo por Atividade");
		Tela tela = new Tela("");
		print("Informe o ID do Insumo, o ID da Atividade e o valor separados por (;):");
		Scanner scanner = new Scanner(System.in);
		String dado = scanner.nextLine();
		FatorAtividade fator = build(dado);
		String id = dao.inserir(fator);
		tela.escrever("-----");
		tela.escrever("Distribuição de Insumos por Atividades incluída com SUCESSO!");
		tela.escrever("-----");
		tela.escrever(String.valueOf(fator));
		tela.escrever("-----");
		menus.stream().forEach(m -> tela.escrever(m.getId() + " - " + m.getTitulo()));
		return tela;
	}

	private FatorAtividade build(String dado) {
		String[] split = dado.split(";");
		Double fator = Double.valueOf(split[2]);
		FatorAtividade fatorAtividade = new FatorAtividade(split[0],split[1],fator);
		return fatorAtividade;
	}

	@Override
	public String getId() {
		return this.id;
	}

}


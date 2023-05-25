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

public class AlterarDistribuicaoAtividade extends Console implements Comando {
	
	private String id;
	private FatorAtividadeDao dao = new FatorAtividadeDao();
	private List<Menu> menus = new ArrayList<>();
	public AlterarDistribuicaoAtividade(String id) {
		this.id = id;
		menus.add(new Menu(9, "PARA VOLTAR"));
	}

	@Override
	public Tela executar() {
		printf("Alterar Distribuição de VPD por Atividade");
		Tela tela = new Tela("");
		print("Informe o ID, o ID do VPD, o ID da Atividade e o valor separados por (;):");
		Scanner scanner = new Scanner(System.in);
		String dado = scanner.nextLine();
		FatorAtividade atividade = build(dado);
		dao.alterar(atividade);
		tela.escrever("-----");
		tela.escrever("Distribuição de VPDs por Atividades alterada com SUCESSO!");
		tela.escrever("-----");
		tela.escrever(String.valueOf(atividade));
		tela.escrever("-----");
		menus.stream().forEach(m -> tela.escrever(m.getId() + " - " + m.getTitulo()));
		return tela;
	}

	private FatorAtividade build(String dado) {
		String[] split = dado.split(";");
		Double fator = Double.valueOf(split[3]);
		FatorAtividade fatorAtividade = new FatorAtividade(split[0],split[1],split[3],fator);
		return fatorAtividade;
	}

	@Override
	public String getId() {
		return this.id;
	}

}


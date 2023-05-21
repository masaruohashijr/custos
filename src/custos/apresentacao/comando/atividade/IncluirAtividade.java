package custos.apresentacao.comando.atividade;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import custos.apresentacao.Console;
import custos.apresentacao.Tela;
import custos.apresentacao.comando.Comando;
import custos.apresentacao.comando.Menu;
import custos.integracao.memoria.AtividadeDao;
import custos.negocio.modelo.Atividade;

public class IncluirAtividade extends Console implements Comando {
	
	private String id;
	private AtividadeDao dao = new AtividadeDao();
	private List<Menu> menus = new ArrayList<>();
	public IncluirAtividade(String id) {
		this.id = id;
		menus.add(new Menu(9, "PARA VOLTAR"));
	}

	@Override
	public Tela executar() {
		printf("Incluir Atividade");
		Tela tela = new Tela("");
		print("Informe o NOME da Atividade");
		Scanner scanner = new Scanner(System.in);
		String dado = scanner.nextLine();
		Atividade atividade = build(dado);
		String id = dao.inserir(atividade);
		tela.escrever("-----");
		tela.escrever("Atividade incluída com SUCESSO!");
		tela.escrever("-----");
		tela.escrever(String.valueOf(atividade));
		tela.escrever("-----");
		menus.stream().forEach(m -> tela.escrever(m.getId() + " - " + m.getTitulo()));
		return tela;
	}

	private Atividade build(String dado) {
		String[] split = dado.split(";");
		Atividade atividade = new Atividade(split[0]);
		return atividade;
	}

	@Override
	public String getId() {
		return this.id;
	}

}


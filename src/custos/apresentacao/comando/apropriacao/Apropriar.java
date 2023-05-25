package custos.apresentacao.comando.apropriacao;

import java.util.ArrayList;
import java.util.List;

import custos.apresentacao.Console;
import custos.apresentacao.Tela;
import custos.apresentacao.comando.Comando;
import custos.apresentacao.comando.Menu;
import custos.integracao.memoria.AtividadeDao;
import custos.integracao.memoria.FatoDao;
import custos.integracao.memoria.FatorAtividadeDao;
import custos.negocio.modelo.Atividade;
import custos.negocio.modelo.Fato;
import custos.negocio.modelo.FatorAtividade;

public class Apropriar extends Console implements Comando {

	private String id;
	private FatoDao fatoDao = new FatoDao();
	private FatorAtividadeDao fatorAtividadeDao = new FatorAtividadeDao();
	private AtividadeDao atividadeDao = new AtividadeDao();
	private List<Menu> menus = new ArrayList<>();

	public Apropriar(String id) {
		this.id = id;
		menus.add(new Menu(9, "PARA VOLTAR"));
	}

	@Override
	public Tela executar() {
		printf("Apropriar Fato");
		Tela tela = new Tela("");
		List<Fato> fatos = fatoDao.listar();
		// O que fazer com essa linha?
		// 1 - 311110101 - 71422.57
		// Atividades
		for (Fato fato : fatos) {
			List<FatorAtividade> fatores = fatorAtividadeDao.listar();
			Double somaDosPesos = 0.0;
			List<Linha> linhas = new ArrayList<Linha>();
			for (FatorAtividade fator : fatores) {
				if (fator.getIdVPD().equals(fato.getVpd())) {
					String idAtividade = fator.getIdAtividade();
					List<Atividade> atividades = atividadeDao.listar();
					Double peso = fator.getFator();
					for (Atividade atividade : atividades) {
						if (idAtividade.equals(atividade.getId())) {
							Linha linha = new Linha(atividade.getId(), atividade.getNome(), peso);
							linhas.add(linha);
						}
					}
					somaDosPesos = somaDosPesos + peso;
				}
			}
			print("----- PRIMEIRA PARTE");
			print("A soma dos pesos dá " + somaDosPesos + ".");
			print("-----");
			for (Linha linha : linhas) {
				Double valor = fato.getValor() * linha.fator / somaDosPesos;
				tela.escrever(
						linha.idAtividade + " - " + linha.nomeAtividade + " - " + linha.fator + " - " + valor);
			}
		}

		tela.escrever("-----");
		menus.stream().forEach(m -> tela.escrever(m.getId() + " - " + m.getTitulo()));
		return tela;
	}

	@Override
	public String getId() {
		return this.id;
	}

	class Linha {
		String idAtividade;
		String nomeAtividade;
		Double fator;

		public Linha(String idAtividade, String nomeAtividade, Double fator) {
			this.idAtividade = idAtividade;
			this.nomeAtividade = nomeAtividade;
			this.fator = fator;
		}
	}

}

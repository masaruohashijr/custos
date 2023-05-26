package custos.apresentacao.comando.apropriacao;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import custos.apresentacao.Console;
import custos.apresentacao.Tela;
import custos.apresentacao.comando.Comando;
import custos.apresentacao.comando.Menu;
import custos.integracao.memoria.AtividadeDao;
import custos.integracao.memoria.CentroDao;
import custos.integracao.memoria.FatoDao;
import custos.integracao.memoria.FatorAtividadeDao;
import custos.integracao.memoria.FatorCentroDao;
import custos.integracao.memoria.estrutura.Orgao;
import custos.negocio.modelo.Atividade;
import custos.negocio.modelo.Centro;
import custos.negocio.modelo.Fato;
import custos.negocio.modelo.FatorAtividade;
import custos.negocio.modelo.FatorCentro;

public class Apropriar extends Console implements Comando {

	private String id;
	private FatoDao fatoDao = new FatoDao();
	private FatorAtividadeDao fatorAtividadeDao = new FatorAtividadeDao();
	private FatorCentroDao fatorCentroDao = new FatorCentroDao();
	private AtividadeDao atividadeDao = new AtividadeDao();
	private CentroDao centroDao = new CentroDao();
	private List<Menu> menus = new ArrayList<>();
	private TreeMap<Integer, Orgao> mapaOrdenado = new TreeMap<Integer, Orgao>();
	
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
			List<FatorAtividade> fatoresAtividades = fatorAtividadeDao.listar();
			Double somaDosPesos = 0.0;
			List<CustoAtividade> custosAtividade = new ArrayList<CustoAtividade>();
			for (FatorAtividade fator : fatoresAtividades) {
				if (fator.getIdVPD().equals(fato.getVpd())) {
					String idAtividade = fator.getIdAtividade();
					List<Atividade> atividades = atividadeDao.listar();
					Double peso = fator.getFator();
					for (Atividade atividade : atividades) {
						if (idAtividade.equals(atividade.getId())) {
							CustoAtividade custoAtividade = new CustoAtividade(atividade.getId(), atividade.getNome(), peso);
							custosAtividade.add(custoAtividade);
						}
					}
					somaDosPesos = somaDosPesos + peso;
				}
			}
			print("----- PRIMEIRA PARTE");
			print("A soma dos pesos dá " + somaDosPesos + ".");
			print("-----");
			for (CustoAtividade custoAtividade : custosAtividade) {
				Double valor = fato.getValor() * custoAtividade.fator / somaDosPesos;
				custoAtividade.setValor(valor);
				/*print(
						custoAtividade.idAtividade + " - " + custoAtividade.nomeAtividade + " - " + custoAtividade.fator + " - " + custoAtividade.valor);*/
			}
			List<FatorCentro> fatoresCentros = fatorCentroDao.listar();
			List<Centro> centros = centroDao.listar();
			somaDosPesos = 0.0;
			List<CustoCentro> custosCentros = new ArrayList<CustoCentro>();
			for (FatorCentro fatorCentro : fatoresCentros) {
				Double peso = fatorCentro.getFator();
				for (Centro centro : centros) {
					if(fatorCentro.getIdCentro().equals(centro.getId())) {
						CustoCentro custoCentro = new CustoCentro(fatorCentro.getIdAtividade(), centro.getId(), 
								centro.getNome(), centro.getAcronimo(), peso);
						custosCentros.add(custoCentro);
					}
				}
				somaDosPesos = somaDosPesos + peso;
			}			
			print("----- SEGUNDA PARTE");
			print("A soma dos pesos dá " + somaDosPesos + ".");
			print("-----");
			for (CustoAtividade custoAtividade : custosAtividade) {
				String idAtividade = custoAtividade.idAtividade;				
				for (CustoCentro custoCentro : custosCentros) {
					if(idAtividade.equals(custoCentro.idAtividade)) {
						Double valor = custoAtividade.valor * custoCentro.fator / somaDosPesos;
						custoCentro.setValor(valor);
						// print(custoCentro.idCentro+","+custoCentro.nomeCentro+","+custoCentro.acronimoCentro+" - "+valor);	
					}
				}		
			}
			consolidacaoOrganograma(custosCentros);
		}
		tela.escrever("-----");
		menus.stream().forEach(m -> tela.escrever(m.getId() + " - " + m.getTitulo()));
		return tela;
	}
	
	private void consolidacaoOrganograma(List<CustoCentro> custosCentros) {
		Orgao organograma = CentroDao.getOrganograma();
		resetOrganograma(organograma);
		for (CustoCentro custoCentro : custosCentros) {
			consolidar(organograma, custoCentro);
		}
		organograma = totalizar(organograma);
		montandoMapaCentros(organograma);
		Set<Integer> keySet = mapaOrdenado.keySet();
		for (Integer key : keySet) {
			Orgao orgao = mapaOrdenado.get(key);
			Centro centro = orgao.getCentro();
			print(centro.getId()+","+centro.getNome()+","+centro.getAcronimo()+" - "+orgao.getCusto());
		}
	}
	private Orgao montandoMapaCentros(Orgao orgao) {
		List<Orgao> unidades = orgao.getUnidades();
		for (Orgao suborninado : unidades) {
			suborninado = montandoMapaCentros(suborninado);
		}
		Centro centro = orgao.getCentro();
		mapaOrdenado.put(centro.getNumeroId(), orgao);
		return orgao;
	}

	private void resetOrganograma(Orgao superior) {
		superior.setCusto(Double.valueOf(0));
		List<Orgao> unidades = superior.getUnidades();
		for (Orgao subordinado : unidades) {
			resetOrganograma(subordinado);
		}
	}


	private Orgao consolidar(Orgao orgao, CustoCentro custoCentro) {
		String idCentro = orgao.getCentro().getId();
		if(idCentro.equals(custoCentro.idCentro)){
			orgao.setCusto(custoCentro.valor);
			print("Custo: "+orgao.getCusto());
		} else {
			List<Orgao> unidades = orgao.getUnidades();
			for (Orgao suborninado : unidades) {
				suborninado = consolidar(suborninado, custoCentro);
			}
		}
		return orgao;
	}

	private Orgao totalizar(Orgao orgao) {
		List<Orgao> unidades = orgao.getUnidades();
		Double total = orgao.getCusto();
		for (Orgao suborninado : unidades) {
			suborninado = totalizar(suborninado);
			total += suborninado.getCusto();
		}
		orgao.setCusto(total);
		return orgao;
	}
	

	@Override
	public String getId() {
		return this.id;
	}

	class CustoAtividade {
		String idAtividade;
		String nomeAtividade;
		Double fator;
		Double valor;

		public CustoAtividade(String idAtividade, String nomeAtividade, Double fator) {
			this.idAtividade = idAtividade;
			this.nomeAtividade = nomeAtividade;
			this.fator = fator;
		}

		public void setValor(Double valor) {
			this.valor = valor;
		}
		
	}
	
	class CustoCentro {
		String idAtividade;
		String idCentro;
		String nomeCentro;
		String acronimoCentro;
		Double fator;
		Double valor;

		public CustoCentro(String idAtividade, String idCentro, String nomeCentro, String acronimoCentro, Double fator) {
			this.idAtividade = idAtividade;
			this.idCentro = idCentro;
			this.nomeCentro = nomeCentro;
			this.acronimoCentro = acronimoCentro;
			this.fator = fator;
		}

		public void setValor(Double valor) {
			this.valor = valor;
		}
		
	}
	
}

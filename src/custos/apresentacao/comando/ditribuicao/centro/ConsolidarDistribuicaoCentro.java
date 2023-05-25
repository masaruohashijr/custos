package custos.apresentacao.comando.ditribuicao.centro;

import java.util.ArrayList;
import java.util.List;

import custos.apresentacao.Console;
import custos.apresentacao.Tela;
import custos.apresentacao.comando.Comando;
import custos.apresentacao.comando.Menu;
import custos.integracao.memoria.CentroDao;
import custos.integracao.memoria.FatorCentroDao;
import custos.integracao.memoria.estrutura.Orgao;
import custos.negocio.modelo.FatorCentro;

public class ConsolidarDistribuicaoCentro extends Console implements Comando {

	private String id;
	private FatorCentroDao dao = new FatorCentroDao();
	private List<Menu> menus = new ArrayList<>();
	Tela tela = new Tela("");

	public ConsolidarDistribuicaoCentro(String id) {
		this.id = id;
		menus.add(new Menu(9, "PARA VOLTAR"));
	}

	@Override
	public Tela executar() {
		printf("Consolidar Distribuição nos Centros");
		List<FatorCentro> fatores = dao.listar();
		Orgao organograma = CentroDao.getOrganograma();
		resetOrganograma(organograma);
		for (FatorCentro fatorCentro : fatores) {
			organograma = consolidar(organograma, fatorCentro);
		}
		organograma = totalizar(organograma);
		tela.escrever("Total: "+organograma.getFator());
		tela.escrever("-----");
		menus.stream().forEach(m -> tela.escrever(m.getId() + " - " + m.getTitulo()));
		return tela;
	}

	private void resetOrganograma(Orgao superior) {
		superior.setFator(Double.valueOf(0));
		List<Orgao> unidades = superior.getUnidades();
		for (Orgao subordinado : unidades) {
			resetOrganograma(subordinado);
		}
	}

	private Orgao consolidar(Orgao orgao, FatorCentro fatorCentro) {
		String idCentro = orgao.getCentro().getId();
		if(idCentro.equals(fatorCentro.getIdCentro())){
			orgao.setFator(fatorCentro.getFator());
			tela.escrever("Fator: "+orgao.getFator());
		} else {
			List<Orgao> unidades = orgao.getUnidades();
			for (Orgao suborninado : unidades) {
				suborninado = consolidar(suborninado, fatorCentro);
			}
		}
		return orgao;
	}

	private Orgao totalizar(Orgao orgao) {
		List<Orgao> unidades = orgao.getUnidades();
		Double total = orgao.getFator();
		for (Orgao suborninado : unidades) {
			suborninado = totalizar(suborninado);
			total += suborninado.getFator();
		}
		orgao.setFator(total);
		return orgao;
	}

	@Override
	public String getId() {
		return this.id;
	}

}

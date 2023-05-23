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
	public ConsolidarDistribuicaoCentro(String id) {
		this.id = id;
		menus.add(new Menu(9, "PARA VOLTAR"));
	}

	@Override
	public Tela executar() {
		printf("Consolidar Distribuição nos Centros");
		Tela tela = new Tela("");
		List<FatorCentro> fatores = dao.listar();
//		fatores.stream().forEach(v -> tela.escrever(v.getId() + " - " + v.getIdAtividade() + " - " + v.getIdCentro() + " - " + v.getFator()));
//		tela.escrever("-----");
//		menus.stream().forEach(m -> tela.escrever(m.getId() + " - " + m.getTitulo()));
		Orgao organograma = CentroDao.getOrganograma();
		resetOrganograma(organograma);
		for (FatorCentro fatorCentro : fatores) {
			organograma = consolidar(organograma, fatorCentro);
		}
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
		// 27.0.0.0.0.0.0 SESAU <> 27.8.3.3.4.0.0
		if(idCentro.equals(fatorCentro.getIdCentro())){
			orgao.setFator(fatorCentro.getFator());
		} else {
			List<Orgao> unidades = orgao.getUnidades();
			Double total = 0.0;
			for (Orgao suborninado : unidades) {
				suborninado = consolidar(suborninado, fatorCentro);
				total += suborninado.getFator();
			}
			if(unidades.size() == 0) {
				orgao.addFator(total);
			} else {
				orgao.setFator(total);
			}
		}
		return orgao;
	}

	@Override
	public String getId() {
		return this.id;
	}

}


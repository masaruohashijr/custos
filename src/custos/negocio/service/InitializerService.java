package custos.negocio.service;

import java.util.List;

import custos.integracao.csv.AspectoCSVDao;
import custos.integracao.csv.AtividadeCSVDao;
import custos.integracao.csv.CentroCSVDao;
import custos.integracao.csv.FatorAspectoCSVDao;
import custos.integracao.csv.FatorAtividadeCSVDao;
import custos.integracao.csv.FatorCentroCSVDao;
import custos.integracao.csv.FatorProdutoCSVDao;
import custos.integracao.csv.InsumoCSVDao;
import custos.integracao.csv.ProdutoCSVDao;
import custos.integracao.csv.VPDCSVDao;
import custos.integracao.memoria.AspectoDao;
import custos.integracao.memoria.AtividadeDao;
import custos.integracao.memoria.CentroDao;
import custos.integracao.memoria.FatorAspectoDao;
import custos.integracao.memoria.FatorAtividadeDao;
import custos.integracao.memoria.FatorCentroDao;
import custos.integracao.memoria.FatorProdutoDao;
import custos.integracao.memoria.InsumoDao;
import custos.integracao.memoria.ProdutoDao;
import custos.integracao.memoria.VPDDao;
import custos.negocio.Model;
import custos.negocio.modelo.Aspecto;
import custos.negocio.modelo.Atividade;
import custos.negocio.modelo.Centro;
import custos.negocio.modelo.FatorAspecto;
import custos.negocio.modelo.FatorAtividade;
import custos.negocio.modelo.FatorCentro;
import custos.negocio.modelo.FatorProduto;
import custos.negocio.modelo.Insumo;
import custos.negocio.modelo.Produto;
import custos.negocio.modelo.VPD;

public class InitializerService {

	public static void loadFatorAtividade() {
		List<Model> all = new FatorAtividadeCSVDao().getAllFromCSV("fatorAtividade.csv");
		FatorAtividadeDao fatorAtividadeDao = new FatorAtividadeDao();
		all.stream().forEach(a->{
			fatorAtividadeDao.inserir((FatorAtividade)a);
		});		
	}
	
	public static void loadFatorAspecto() {
		List<Model> all = new FatorAspectoCSVDao().getAllFromCSV("fatorAspecto.csv");
		FatorAspectoDao fatorAspectoDao = new FatorAspectoDao();
		all.stream().forEach(a->{
			fatorAspectoDao.inserir((FatorAspecto)a);
		});		
	}
	
	public static void loadFatorProduto() {
		List<Model> all = new FatorProdutoCSVDao().getAllFromCSV("fatorProduto.csv");
		FatorProdutoDao fatorProdutoDao = new FatorProdutoDao();
		all.stream().forEach(a->{
			fatorProdutoDao.inserir((FatorProduto)a);
		});		
	}
	
	public static void loadFatorCentro() {
		List<Model> all = new FatorCentroCSVDao().getAllFromCSV("fatorCentro.csv");
		FatorCentroDao fatorCentroDao = new FatorCentroDao();
		all.stream().forEach(a->{
			fatorCentroDao.inserir((FatorCentro)a);
		});		
	}
	
	public static void loadVPDs() {
		List<Model> all = new VPDCSVDao().getAllFromCSV("vpds.csv");
		VPDDao vpdDao = new VPDDao();
		all.stream().forEach(v->{
			vpdDao.inserir((VPD)v);
		});
	}
	
	public static void loadInsumos() {
		List<Model> all = new InsumoCSVDao().getAllFromCSV("insumos.csv");
		InsumoDao insumoDao = new InsumoDao();
		all.stream().forEach(i->{
			insumoDao.inserir((Insumo)i);
		});		
	}

	public static void loadAtividades() {
		List<Model> all = new AtividadeCSVDao().getAllFromCSV("atividades.csv");
		AtividadeDao atividadeDao = new AtividadeDao();
		all.stream().forEach(a->{
			atividadeDao.inserir((Atividade)a);
		});		
	}
	
	public static void loadProdutos() {
		List<Model> all = new ProdutoCSVDao().getAllFromCSV("produtos.csv");
		ProdutoDao objetoDao = new ProdutoDao();
		all.stream().forEach(o->{
			objetoDao.inserir((Produto)o);
		});		
	}
	
	public static void loadAspectos() {
		List<Model> all = new AspectoCSVDao().getAllFromCSV("aspectos.csv");
		AspectoDao aspectoDao = new AspectoDao();
		all.stream().forEach(a->{
			aspectoDao.inserir((Aspecto)a);
		});		
	}
	
	public static void loadCentros() {
		List<Model> all = new CentroCSVDao().getAllFromCSV("organograma.csv");
		CentroDao centroDao = new CentroDao();
		all.stream().forEach(c->{
			centroDao.inserir((Centro)c);
		});
	}
	
}

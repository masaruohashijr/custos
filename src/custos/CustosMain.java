package custos;

import java.util.ArrayList;
import java.util.List;

import custos.apresentacao.Console;
import custos.apresentacao.Controlador;
import custos.apresentacao.Tela;
import custos.negocio.service.InitializerService;

public class CustosMain extends Console {

	private List<String> migalha = new ArrayList<>();
	private Controlador controlador = new Controlador();
	
	public static void main(String[] args) {
		CustosMain main = new CustosMain();
		main.init();
		main.run();
	}

	private void init() {
		InitializerService.loadVPDs();
		InitializerService.loadInsumos();
		InitializerService.loadAtividades();
		InitializerService.loadProdutos();
		InitializerService.loadAspectos();
		InitializerService.loadCentros();
		InitializerService.loadFatorAtividade();
		InitializerService.loadFatorProduto();
		InitializerService.loadFatorAspecto();
		InitializerService.loadFatorCentro();
		InitializerService.loadFato();
	}

	private void run() {
		String opcao = "-1";
		while(!opcao.equals("0")) {
			Tela tela = executarOpcao(opcao);
			if(null!=tela) {
				print(tela);
			}
			if("9".equals(opcao)) {
				voltarTelaAnterior(opcao);
			} else {
				adicionarMigalhaPao(opcao);
			}
			opcao = leOpcao();
		}
	}

	private void adicionarMigalhaPao(String opcao) {
		migalha.add(opcao);
	}

	private void voltarTelaAnterior(String opcao) {
//		System.out.println("migalha1: "+migalha);
		int size = migalha.size();
		String opcaoAnterior = "";
		if(size>3) {
			int i= migalha.size()-1;
			while (i>0 && migalha.size()>3) {
				if(migalha.get(migalha.size()-1).length()==3) {
					migalha.remove(migalha.size()-1);
				}
				i--;
			}
			if(size == migalha.size()) {
				migalha.remove(migalha.size()-1);
			}
			opcaoAnterior = migalha.get(migalha.size()-1);
		} else if (size==3){
			migalha.remove(migalha.size()-1);
			opcaoAnterior = migalha.get(migalha.size()-1);
		} else {
			opcaoAnterior = migalha.get(0);
		}
//		System.out.println("migalha2: "+migalha);
		executarOpcao(opcaoAnterior);
	}
	
	private Tela executarOpcao(String opcao) {
		Tela tela = controlador.processar(opcao);
		return tela;
	}


}
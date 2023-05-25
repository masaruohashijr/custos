package custos.apresentacao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import custos.apresentacao.comando.Comando;
import custos.apresentacao.comando.MenuApropriacao;
import custos.apresentacao.comando.MenuCadastro;
import custos.apresentacao.comando.MenuConfiguracao;
import custos.apresentacao.comando.MenuDemonstracao;
import custos.apresentacao.comando.MenuPrincipal;
import custos.apresentacao.comando.apropriacao.Apropriar;
import custos.apresentacao.comando.aspecto.AlterarAspecto;
import custos.apresentacao.comando.aspecto.ExcluirAspecto;
import custos.apresentacao.comando.aspecto.IncluirAspecto;
import custos.apresentacao.comando.aspecto.ListarAspecto;
import custos.apresentacao.comando.aspecto.MenuAspecto;
import custos.apresentacao.comando.atividade.AlterarAtividade;
import custos.apresentacao.comando.atividade.ExcluirAtividade;
import custos.apresentacao.comando.atividade.IncluirAtividade;
import custos.apresentacao.comando.atividade.ListarAtividade;
import custos.apresentacao.comando.atividade.MenuAtividade;
import custos.apresentacao.comando.centro.AlterarCentro;
import custos.apresentacao.comando.centro.ExcluirCentro;
import custos.apresentacao.comando.centro.IncluirCentro;
import custos.apresentacao.comando.centro.ListarCentro;
import custos.apresentacao.comando.centro.MenuCentro;
import custos.apresentacao.comando.ditribuicao.aspecto.AlterarDistribuicaoAspecto;
import custos.apresentacao.comando.ditribuicao.aspecto.ExcluirDistribuicaoAspecto;
import custos.apresentacao.comando.ditribuicao.aspecto.IncluirDistribuicaoAspecto;
import custos.apresentacao.comando.ditribuicao.aspecto.ListarDistribuicaoAspecto;
import custos.apresentacao.comando.ditribuicao.aspecto.MenuDistribuicaoAspecto;
import custos.apresentacao.comando.ditribuicao.atividade.AlterarDistribuicaoAtividade;
import custos.apresentacao.comando.ditribuicao.atividade.ExcluirDistribuicaoAtividade;
import custos.apresentacao.comando.ditribuicao.atividade.IncluirDistribuicaoAtividade;
import custos.apresentacao.comando.ditribuicao.atividade.ListarDistribuicaoAtividade;
import custos.apresentacao.comando.ditribuicao.atividade.MenuDistribuicaoAtividade;
import custos.apresentacao.comando.ditribuicao.centro.AlterarDistribuicaoCentro;
import custos.apresentacao.comando.ditribuicao.centro.ConsolidarDistribuicaoCentro;
import custos.apresentacao.comando.ditribuicao.centro.ExcluirDistribuicaoCentro;
import custos.apresentacao.comando.ditribuicao.centro.IncluirDistribuicaoCentro;
import custos.apresentacao.comando.ditribuicao.centro.ListarDistribuicaoCentro;
import custos.apresentacao.comando.ditribuicao.centro.MenuDistribuicaoCentro;
import custos.apresentacao.comando.ditribuicao.produto.AlterarDistribuicaoProduto;
import custos.apresentacao.comando.ditribuicao.produto.ExcluirDistribuicaoProduto;
import custos.apresentacao.comando.ditribuicao.produto.IncluirDistribuicaoProduto;
import custos.apresentacao.comando.ditribuicao.produto.ListarDistribuicaoProduto;
import custos.apresentacao.comando.ditribuicao.produto.MenuDistribuicaoProduto;
import custos.apresentacao.comando.fato.AlterarFato;
import custos.apresentacao.comando.fato.ExcluirFato;
import custos.apresentacao.comando.fato.IncluirFato;
import custos.apresentacao.comando.fato.ListarFato;
import custos.apresentacao.comando.fato.MenuFato;
import custos.apresentacao.comando.insumo.AlterarInsumo;
import custos.apresentacao.comando.insumo.ExcluirInsumo;
import custos.apresentacao.comando.insumo.IncluirInsumo;
import custos.apresentacao.comando.insumo.ListarInsumo;
import custos.apresentacao.comando.insumo.MenuInsumo;
import custos.apresentacao.comando.produto.AlterarProduto;
import custos.apresentacao.comando.produto.ExcluirProduto;
import custos.apresentacao.comando.produto.IncluirProduto;
import custos.apresentacao.comando.produto.ListarProduto;
import custos.apresentacao.comando.produto.MenuProduto;
import custos.apresentacao.comando.vpd.AlterarVPD;
import custos.apresentacao.comando.vpd.ExcluirVPD;
import custos.apresentacao.comando.vpd.IncluirVPD;
import custos.apresentacao.comando.vpd.ListarVPD;
import custos.apresentacao.comando.vpd.MenuVPD;

public class Controlador {

	private List<Comando> comandos;

	public Controlador() {
		comandos = new ArrayList<Comando>();
		comandos.add(new MenuPrincipal("-1"));
		comandos.add(new MenuCadastro("1"));
		comandos.add(new MenuConfiguracao("2"));
		comandos.add(new MenuApropriacao("3"));
		comandos.add(new MenuDemonstracao("4"));
		comandos.add(new MenuVPD("11"));
		comandos.add(new ListarVPD("111"));
		comandos.add(new IncluirVPD("112"));
		comandos.add(new AlterarVPD("113"));
		comandos.add(new ExcluirVPD("114"));
		comandos.add(new MenuInsumo("12"));
		comandos.add(new ListarInsumo("121"));
		comandos.add(new IncluirInsumo("122"));
		comandos.add(new AlterarInsumo("123"));
		comandos.add(new ExcluirInsumo("124"));
		comandos.add(new MenuAtividade("13"));
		comandos.add(new ListarAtividade("131"));
		comandos.add(new IncluirAtividade("132"));
		comandos.add(new AlterarAtividade("133"));
		comandos.add(new ExcluirAtividade("134"));
		comandos.add(new MenuProduto("14"));
		comandos.add(new ListarProduto("141"));
		comandos.add(new IncluirProduto("142"));
		comandos.add(new AlterarProduto("143"));
		comandos.add(new ExcluirProduto("144"));
		comandos.add(new MenuAspecto("15"));
		comandos.add(new ListarAspecto("151"));
		comandos.add(new IncluirAspecto("152"));
		comandos.add(new AlterarAspecto("153"));
		comandos.add(new ExcluirAspecto("154"));
		comandos.add(new MenuCentro("16"));
		comandos.add(new ListarCentro("161"));
		comandos.add(new IncluirCentro("162"));
		comandos.add(new AlterarCentro("163"));
		comandos.add(new ExcluirCentro("164"));
		comandos.add(new MenuDistribuicaoAtividade("22"));
		comandos.add(new ListarDistribuicaoAtividade("221"));
		comandos.add(new IncluirDistribuicaoAtividade("222"));
		comandos.add(new AlterarDistribuicaoAtividade("223"));
		comandos.add(new ExcluirDistribuicaoAtividade("224"));
		comandos.add(new MenuDistribuicaoProduto("23"));
		comandos.add(new ListarDistribuicaoProduto("231"));
		comandos.add(new IncluirDistribuicaoProduto("232"));
		comandos.add(new AlterarDistribuicaoProduto("233"));
		comandos.add(new ExcluirDistribuicaoProduto("234"));
		comandos.add(new MenuDistribuicaoAspecto("24"));
		comandos.add(new ListarDistribuicaoAspecto("241"));
		comandos.add(new IncluirDistribuicaoAspecto("242"));
		comandos.add(new AlterarDistribuicaoAspecto("243"));
		comandos.add(new ExcluirDistribuicaoAspecto("244"));
		comandos.add(new MenuDistribuicaoCentro("25"));
		comandos.add(new ListarDistribuicaoCentro("251"));
		comandos.add(new IncluirDistribuicaoCentro("252"));
		comandos.add(new AlterarDistribuicaoCentro("253"));
		comandos.add(new ExcluirDistribuicaoCentro("254"));
		comandos.add(new ConsolidarDistribuicaoCentro("255"));
		comandos.add(new MenuFato("31"));
		comandos.add(new ListarFato("311"));
		comandos.add(new IncluirFato("312"));
		comandos.add(new AlterarFato("313"));
		comandos.add(new ExcluirFato("314"));
		comandos.add(new Apropriar("32"));
	}

	public Tela processar(String opcao) {
		Optional<Comando> optional = comandos.stream().filter(c -> c.getId().equals(opcao)).findAny();
		Tela tela = new Tela("");
		if (optional.isPresent()) {
			Comando comando = optional.get();
			tela = comando.executar();
		}
		return tela;
	}

}

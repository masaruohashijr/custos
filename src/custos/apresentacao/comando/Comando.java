package custos.apresentacao.comando;

import custos.apresentacao.Tela;

public interface Comando {
	String getId();
	Tela executar();
}

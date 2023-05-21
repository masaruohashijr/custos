package custos.apresentacao;

public class Tela {
	
	private StringBuilder sb = new StringBuilder();

	public Tela(String txt) {
		sb.append(txt);
	}

	public void escrever(String txt) {
		sb.append(txt+"\n");
	}

	@Override
	public String toString() {
		return sb.toString();
	}

}

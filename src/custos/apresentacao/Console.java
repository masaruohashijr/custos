package custos.apresentacao;

import java.util.Scanner;

public class Console {


	public void print(String text) {
		System.out.println(text);
	}

	public void print(Tela tela) {
		System.out.println(tela);
	}
	
	public void printf(String text) {
		System.out.println("*** " + text + " ***");
	}

	protected String leOpcao() {
		Scanner scanner = new Scanner(System.in);
		String dado = scanner.nextLine();
		return dado;
	}
	
}
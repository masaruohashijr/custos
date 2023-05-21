package custos.integracao.csv;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import custos.negocio.Model;

public abstract class CSVDao {
	
	public List<Model> getAllFromCSV(String path) {

		List<Model> elementos = new ArrayList();

		String linha = "";
		String TOKEN = ";";
		boolean linhaTitulo = false;

		try (BufferedReader br = new BufferedReader(new FileReader(path))) {

			while ((linha = br.readLine()) != null) {

				if (linhaTitulo) {
					linhaTitulo = false;
				} else {
					String[] array = linha.split(TOKEN);
					elementos.add(build(array));
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println(
					"Error " + e + " O arquivo CSV indicado não foi encontrado, verifique o caminho informado");
		} catch (IOException e) {
			System.out.println("Error " + e + " Falha na leitura do arquivo, verifique se o arquivo está correto");
		}
		
		return elementos;
	}

	protected abstract Model build(String[] array);
}

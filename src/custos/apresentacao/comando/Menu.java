package custos.apresentacao.comando;

/**
 * @author Logus
 *
 */
public class Menu {
	private String titulo;
	private int id;
	public Menu(int id, String titulo) {
		this.id = id;
		this.titulo = titulo;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
}	

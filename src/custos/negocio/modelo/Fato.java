package custos.negocio.modelo;

import custos.negocio.Model;

public class Fato extends Model {
	private String id;
	private String vpd;
	private double valor;
	
	public Fato(String vpd, double valor) {
		this.vpd = vpd;
		this.valor = valor;
	}

	public Fato(String id, String vpd, double valor) {
		this.id = id;
		this.vpd = vpd;
		this.valor = valor;
	}

	public String getVpd() {
		return vpd;
	}

	public void setVpd(String vpd) {
		this.vpd = vpd;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}

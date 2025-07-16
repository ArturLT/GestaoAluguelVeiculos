package Entidades;

public class Boleto {
	
	private Double pagamentoInic;
	private Double taxa;
	
	public Boleto() {
		
	}

	public Boleto(Double pagamentoInic, Double taxa) {
		super();
		this.pagamentoInic = pagamentoInic;
		this.taxa = taxa;
	}

	public Double getPagamentoInic() {
		return pagamentoInic;
	}

	public void setPagamentoInic(Double pagamentoInic) {
		this.pagamentoInic = pagamentoInic;
	}

	public Double getTaxa() {
		return taxa;
	}

	public void setTaxa(Double taxa) {
		this.taxa = taxa;
	}
	
	public Double pagemtnoTotal() {
		return getPagamentoInic() - getTaxa();
	}
}

package Program;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import Entidades.CarRental;
import Entidades.Veiculo;
import servicos.ServicoLocacao;
import servicos.TaxaBrasileira;

public class Main {
	
	public static void main (String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		
		System.out.println("Entre com os dados do aluguel");
		System.out.print("Modelo do carro: ");
		String carModelo = sc.nextLine();
		System.out.println("Retirada (dd/MM/yyyy hh:mm): ");
		LocalDateTime start = LocalDateTime.parse(sc.nextLine(), fmt);
		System.out.println("Entrega (dd/MM/yyyy hh:mm): ");
		LocalDateTime finish = LocalDateTime.parse(sc.nextLine(), fmt);
		
		CarRental cr = new CarRental(start, finish, new Veiculo(carModelo));
		
		System.out.print("Entre com o preço por hora:");
		double precoPorHora = sc.nextDouble();
		System.out.print("Entre com o preço por dia:");
		double precoPorDia = sc.nextDouble();
		
		ServicoLocacao sl = new ServicoLocacao(precoPorHora, precoPorDia, new TaxaBrasileira());
		
		sl.procesoBoleto(cr);
		
		System.out.println("Fatura:");
		System.out.println("Pagamento Basico: " + cr.getBoleto().getPagamentoInic());
		System.out.println("Imposto: " + cr.getBoleto().getTaxa());
		System.out.println("Pagamento toal: " + cr.getBoleto().pagemtnoTotal());
	}
}

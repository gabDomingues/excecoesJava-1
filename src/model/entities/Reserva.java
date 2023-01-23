package model.entities;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Reserva {
	
	private static DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	private Integer numeroQuarto;
	private LocalDate checkIn;
	private LocalDate checkOut;
	
	public Reserva() {
		
	}

	public Reserva(Integer numeroQuarto, LocalDate checkIn, LocalDate checkOut) {
		this.numeroQuarto = numeroQuarto;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Integer getNumeroQuarto() {
		return numeroQuarto;
	}

	public void setNumeroQuarto(Integer numeroQuarto) {
		this.numeroQuarto = numeroQuarto;
	}

	public LocalDate getcheckIn() {
		return checkIn;
	}

	public LocalDate getcheckOut() {
		return checkOut;
	}

	
	public long duracao() {
		Duration duracao = Duration.between(this.getcheckIn().atStartOfDay(), this.getcheckOut().atStartOfDay());
		return duracao.toDays();
	}
	
	public void atualizarDatas(LocalDate checkIn, LocalDate checkOut) {
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Reserva: Quarto " );
		sb.append(this.getNumeroQuarto() + ", ");
		sb.append("Check-In: " + this.getcheckIn().format(fmt) + ", ");
		sb.append("Check-Out: " + this.getcheckOut().format(fmt) + ", ");
		sb.append(this.duracao() + " noites.");
		return sb.toString();
	}
}
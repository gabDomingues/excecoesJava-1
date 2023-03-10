package model.entities;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import model.exceptions.DomainException;

public class Reserva {

	private static DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	private Integer numeroQuarto;
	private LocalDate checkIn;
	private LocalDate checkOut;

	public Reserva() {

	}

	public Reserva(Integer numeroQuarto, LocalDate checkIn, LocalDate checkOut) throws DomainException {
		if (!checkOut.isAfter(checkIn)) {
			throw new DomainException("Erro na reserva. Data de Check-Out deve ser posterior Check-In");
		} 
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

	public void atualizarDatas(LocalDate checkIn, LocalDate checkOut) throws DomainException {

		LocalDate agora = LocalDate.now();
		if (checkIn.isBefore(agora) || checkOut.isBefore(agora)) {
			throw new DomainException("Erro na reserva. Datas atualizadas devem ser futuras.");
		}
		if (!checkOut.isAfter(checkIn)) {
			throw new DomainException("Erro na reserva. Data de Check-Out deve ser posterior Check-In");
		}
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Reserva: Quarto ");
		sb.append(this.getNumeroQuarto() + ", ");
		sb.append("Check-In: " + this.getcheckIn().format(fmt) + ", ");
		sb.append("Check-Out: " + this.getcheckOut().format(fmt) + ", ");
		sb.append(this.duracao() + " noites.");
		return sb.toString();
	}
}

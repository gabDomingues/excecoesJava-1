package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import model.entities.Reserva;

public class Program {

	public static void main(String[] args) {
		
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		Reserva r1 = new Reserva ();
		String data = "23/01/2023";
		String data2 = "26/01/2023";
		
		r1 = new Reserva(101, LocalDate.parse(data, fmt), LocalDate.parse(data2, fmt) );
		System.out.println(r1);
	}

}

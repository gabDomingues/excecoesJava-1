package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

import model.entities.Reserva;

public class Program {

	public static void main(String[] args) {

		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		Scanner sc = new Scanner(System.in);
		try {
			System.out.print("Numero quarto: ");
			int numero = sc.nextInt();
			System.out.println("Check-In (dd/mm/aaaa): ");
			LocalDate checkIn = LocalDate.parse(sc.next(), fmt);
			System.out.println("Check-Out (dd/mm/aaaa): ");
			LocalDate checkOut = LocalDate.parse(sc.next(), fmt);
	
			Reserva reserva = new Reserva(numero, checkIn, checkOut);
			System.out.println(reserva);
			
			System.out.println();
			System.out.println("Atualizar reserva");
			System.out.println("Check-In (dd/mm/aaaa): ");
			checkIn = LocalDate.parse(sc.next(), fmt);
			System.out.println("Check-Out (dd/mm/aaaa): ");
			checkOut = LocalDate.parse(sc.next(), fmt);
	
			reserva.atualizarDatas(checkIn, checkOut);
			System.out.println(reserva);
		}
		catch(DateTimeParseException e) {
			System.out.println("Formato da Data Invalido!");
		}
		catch(IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
		sc.close();
	}

}

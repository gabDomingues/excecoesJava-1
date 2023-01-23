package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import model.entities.Reserva;

public class Program {

	public static void main(String[] args) {

		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		Scanner sc = new Scanner(System.in);

		System.out.print("Numero quarto: ");
		int numero = sc.nextInt();
		System.out.println("Check-In (dd/mm/aaaa): ");
		LocalDate checkIn = LocalDate.parse(sc.next(), fmt);
		System.out.println("Check-Out (dd/mm/aaaa): ");
		LocalDate checkOut = LocalDate.parse(sc.next(), fmt);

		if (!checkOut.isAfter(checkIn)) {
			System.out.println("Erro na reserva. Data de Check-Out deve ser posterior Check-In");
		} else {
			Reserva reserva = new Reserva(numero, checkIn, checkOut);
			System.out.println(reserva);
			System.out.println();
			System.out.print("Atualizar reserva");
			System.out.println("Check-In (dd/mm/aaaa): ");
			checkIn = LocalDate.parse(sc.next(), fmt);
			System.out.println("Check-Out (dd/mm/aaaa): ");
			checkOut = LocalDate.parse(sc.next(), fmt);

			LocalDate agora = LocalDate.now();
			if (checkIn.isBefore(agora) || checkOut.isBefore(agora)) {
				System.out.println("Erro na reserva. Datas atualizadas devem ser futuras.");
			} else if (!checkOut.isAfter(checkIn)) {
				System.out.println("Erro na reserva. Data de Check-Out deve ser posterior Check-In");
			} else {
				reserva.atualizarDatas(checkIn, checkOut);
				System.out.println(reserva);
			}

		}

		sc.close();
	}

}

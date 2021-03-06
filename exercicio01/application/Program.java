package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

import model.entities.Reservation;
import model.exception.DomainException;

public class Program {

	public static void main(String[] args) {
		
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			Integer numberRoom = Integer.parseInt(JOptionPane.showInputDialog("Room Number"));
			System.out.println("Room: " + numberRoom);
			
			String checkInDate = JOptionPane.showInputDialog("Check-in: ");
			Date checkIn = sdf.parse(checkInDate);
			System.out.println("Check-In date (dd/MM/yyy): " + sdf.format(checkIn));
			
			String checkOutDate = JOptionPane.showInputDialog("Check-Out: ");
			Date checkOut = sdf.parse(checkOutDate);
			System.out.println("Check-Out date (dd/MM/yyy): " + sdf.format(checkOut));	
			
			Reservation reservation = new Reservation(numberRoom, checkIn, checkOut);
			System.out.println(reservation.toString());
			
			System.out.println("\nEnter data to update the reservation: ");
			
			checkInDate = JOptionPane.showInputDialog("Check-in: ");
			checkIn = sdf.parse(checkInDate);
			System.out.println("Check-In date (dd/MM/yyy): " + sdf.format(checkIn));
			
			checkOutDate = JOptionPane.showInputDialog("Check-Out: ");
			checkOut = sdf.parse(checkOutDate);
			System.out.println("Check-Out date (dd/MM/yyy): " + sdf.format(checkOut));	
			reservation.updateDate(checkIn, checkOut);
			
		}
		catch (ParseException e) {
			System.out.println("Error in date format; ");
		}
		catch (DomainException e) {
			System.out.println("Error in reservation: " + e.getMessage());
		}
				
	}

}

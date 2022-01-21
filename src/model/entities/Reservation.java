package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
	
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;
	
	public Reservation() {
	}
	
	public Reservation(Integer roomNumber, Date checkIn, Date checkOut) {
		setRoomNumber(roomNumber);
		setCheckIn(checkIn);
		setCheckOut(checkOut);
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	private void setCheckIn(Date checkIn) { 
		this.checkIn = checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}

	private void setCheckOut(Date checkOut) {
		this.checkOut = checkOut;
	}
	
	public long duration() {
		long diffInMillies = Math.abs(getCheckOut().getTime() - getCheckIn().getTime());
	    long duration = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
		return duration;
	}
	
	public void updateDate(Date checkIn, Date checkOut) {
		setCheckIn(checkIn);
		setCheckOut(checkOut);
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Reservation: Room ");
		sb.append(getRoomNumber());
		sb.append(", Check-in: ");
		sb.append(sdf.format(getCheckIn()));
		sb.append(", Check-Out: ");
		sb.append(sdf.format(getCheckOut()));
		sb.append(String.format(", %d nights;", duration()));
		return sb.toString();
	}
	
}

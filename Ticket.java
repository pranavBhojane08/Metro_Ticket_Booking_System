package Metro;

import java.io.Serializable;

public class Ticket implements Serializable {
    private static int counter = 1001;

    private int ticketId;
    private String passengerName;
    private String source;
    private String destination;
    private double fare;

    public Ticket(String passengerName, String source, String destination, double fare) {
        this.ticketId = counter++;
        this.passengerName = passengerName;
        this.source = source;
        this.destination = destination;
        this.fare = fare;
    }

    public int getTicketId() {
        return ticketId;
    }

    @Override
    public String toString() {
        return "Ticket ID: " + ticketId +
               "\nPassenger: " + passengerName +
               "\nFrom: " + source +
               "\nTo: " + destination +
               "\nFare: ₹" + fare;
    }
}

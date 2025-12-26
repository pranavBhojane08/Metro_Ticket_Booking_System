package Metro;

import java.util.*;

public class MetroService implements FareCalculator {

	private List<Ticket> tickets = new ArrayList<>();
	private Map<String, Integer> stations = new LinkedHashMap<>();

	public MetroService() {
		stations.put("pcmc", 1);
		stations.put("sant tukaram nagar", 2);
		stations.put("bhosari", 3);
		stations.put("shivaji nagar", 4);
		stations.put("civil court", 5);
		stations.put("swargate", 6);
		stations.put("vanaz", 7);
		stations.put("ideal colony", 8);
		stations.put("nal stop", 9);
		stations.put("deccan gymkhana", 10);
		stations.put("ruby hall clinic", 11);
		stations.put("ramwadi", 12);

		List<Ticket> saved = FileUtil.loadTickets();
		if (saved != null)
			tickets = saved;
	}

	private String normalizeStation(String input) {
		return input.trim().toLowerCase();
	}

	public void showStations() {
		System.out.println("\nAvailable Pune Metro Stations:");
		for (String station : stations.keySet()) {
			System.out.println("- " + station);
		}
	}

    
	public double calculateFare(String source, String destination) {
		int s1 = stations.get(source);
		int s2 = stations.get(destination);
		return Math.abs(s1 - s2) * 10 + 10;
	}

	public void bookTicket(String name, String source, String destination) throws InvalidInputException {

		source = normalizeStation(source);
		destination = normalizeStation(destination);

		if (!stations.containsKey(source)) {
			throw new InvalidInputException("Invalid Source Station");
		}

		if (!stations.containsKey(destination)) {
			throw new InvalidInputException("Invalid Destination Station");
		}

		if (source.equals(destination)) {
			throw new InvalidInputException("Source and destination cannot be same");
		}

		double fare = calculateFare(source, destination);

		Ticket ticket = new Ticket(name, source.toUpperCase(), destination.toUpperCase(), fare);

		tickets.add(ticket);
		FileUtil.saveTickets(tickets);

		System.out.println("\n✅ Ticket Booked Successfully");
		System.out.println(ticket);
	}

	public void viewTickets() {
		if (tickets.isEmpty()) {
			System.out.println("No tickets found");
			return;
		}

		for (Ticket t : tickets) {
			System.out.println("\n-------------------");
			System.out.println(t);
		}
	}
}

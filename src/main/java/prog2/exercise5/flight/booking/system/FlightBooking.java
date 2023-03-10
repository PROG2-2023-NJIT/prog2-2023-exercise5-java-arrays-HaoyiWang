package prog2.exercise5.flight.booking.system;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.Scanner;

public class FlightBooking {
    private DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    private String flightCompany;
    // Every flight has an ID, e.g., FOF0345IN
    // It must be generated by the program automatically after a booking is completed.
    private String flightID;
    private String[] passengerFullName;
    private TripSource tripSource;
    private SourceAirport sourceAirport;
    private TripDestination tripDestination;
    private DestinationAirport destinationAirport;
    private LocalDate departureDate;
    private LocalDate returnDate;
    private int childPassengers;
    private int adultPassengers;
    private int totalPassengers;
    private double departingTicketPrice;
    private double returnTicketPrice;
    private double totalTicketPrice;
    private String[] ticketNumber;
    private TripType tripType;
    // First Business Economy
    private BookingClass bookingClass;

    // new variable
    private String[] passengerGender;
    private int[] passengerAge;

    public FlightBooking(int size) {
        this.totalPassengers = size;
        passengerFullName = new String[size];
        passengerGender = new String[size];
        passengerAge = new int[size];
        ticketNumber = new String[size];
    }

    public FlightBooking(String passengerFullName, LocalDate departureDate, LocalDate returnDate, int childPassengers, int adultPassengers) {
//        this.passengerFullName = passengerFullName;
        setDepartureDate(departureDate);
        setReturnDate(returnDate);
        this.childPassengers = childPassengers;
        this.adultPassengers = adultPassengers;
        this.totalPassengers = childPassengers + adultPassengers;
    }

    public void setPassengerFullName(int index, String fullname) {
        passengerFullName[index] = fullname;
    }

    public String getPassengerFullName(int index) {
        return passengerFullName[index];
    }

    public String getFlightCompany() {
        return flightCompany;
    }

    public TripDestination getTripDestination() {
        return tripDestination;
    }

    public int getTotalPassengers() {
        return childPassengers + adultPassengers;
    }

    public int getChildPassengers() {
        return childPassengers;
    }

    public int getAdultPassengers() {
        return adultPassengers;
    }

    public void setTotalPassengers(int childPassengers, int adultPassengers) {
        this.childPassengers = childPassengers;
        this.adultPassengers = adultPassengers;
        this.totalPassengers = childPassengers + adultPassengers;
    }

    public void setPassengerGender(int index, String s) {
        passengerGender[index] = s;
    }

    public String getPassengerGender(int index) {
        return passengerGender[index];
    }

    public void setPassengerAge(int index, int age) {
        passengerAge[index] = age;
    }

    public int getPassengerAge(int index) {
        return passengerAge[index];
    }

    public enum TripSource {
        NANJING("1", "NANJING"),
        BEIJING("2", "BEIJING"),
        Oulu("3", "Oulu"),
        Helsinki("4", "Helsinki");
//        Shanghai("3", "Shanghai"),
//        Oulu("4", "Oulu"),
//        Helsinki("5", "Helsinki"),
//        Paris("6", "Paris");

        private String code;
        private String name;

        TripSource(String code, String name) {
            this.code = code;
            this.name = name;
        }

        public static TripSource getByCode(String code) {
            for (TripSource ts : TripSource.values()) {
                if (ts.code.equals(code)) {
                    return ts;
                }
            }
            return null;
        }
    }

    public enum TripDestination {
        Nanjing("1", "Nanjing"),
        BEIJING("2", "BEIJING"),
        Oulu("3", "Oulu"),
        Helsinki("4", "Helsinki");
//        Shanghai("3", "Shanghai"),
//        Oulu("4", "Oulu"),
//        Helsinki("5", "Helsinki"),
//        Paris("6", "Paris");

        private String code;
        private String name;

        TripDestination(String code, String name) {
            this.code = code;
            this.name = name;
        }

        public static TripDestination getByCode(String code) {
            for (TripDestination ts : TripDestination.values()) {
                if (ts.code.equals(code)) {
                    return ts;
                }
            }
            return null;
        }
    }

    public enum TripType {
        ONE_WAY("1", "ONE_WAY"),
        RETURN("2", "RETURN");

        private String code;
        private String name;

        TripType(String code, String name) {
            this.code = code;
            this.name = name;
        }

        public static TripType getByCode(String code) {
            for (TripType ts : TripType.values()) {
                if (ts.code.equals(code)) {
                    return ts;
                }
            }
            return null;
        }
    }

    public enum BookingClass {
        FIRST("1", "First"),
        BUSINESS("2", "Business"),
        ECONOMY("3", "Economy");

        private String code;
        private String name;

        BookingClass(String code, String name) {
            this.code = code;
            this.name = name;
        }

        public static BookingClass getByCode(String code) {
            for (BookingClass ts : BookingClass.values()) {
                if (ts.code.equals(code)) {
                    return ts;
                }
            }
            return null;
        }
    }

    public enum SourceAirport {
        Nanjing("1", "Nanjing Lukou International Airport"),
        Beijing("2", "Beijing Capital International Airport"),
        Oulu("3", "Oulu Airport"),
        Helsinki("4", "Helsinki Airport");
//        Shanghai("3", "Shanghai Pudong International Airport"),
//        Oulu("4", "Oulu Airport"),
//        Helsinki("5", "Helsinki Airport"),
//        Paris("6", "Paris Charles de Gaulle Airport");

        private String code;
        private String name;

        SourceAirport(String code, String name) {
            this.code = code;
            this.name = name;
        }

        public static SourceAirport getByCode(String code) {
            for (SourceAirport ts : SourceAirport.values()) {
                if (ts.code.equals(code)) {
                    return ts;
                }
            }
            return null;
        }
    }

    public enum DestinationAirport {
        Nanjing("1", "Nanjing Lukou International Airport"),
        Beijing("2", "Beijing Capital International Airport"),
        Oulu("3", "Oulu Airport"),
        Helsinki("4", "Helsinki Airport");
//        Shanghai("3", "Shanghai Pudong International Airport"),
//        Oulu("4", "Oulu Airport"),
//        Helsinki("5", "Helsinki Airport"),
//        Paris("6", "Paris Charles de Gaulle Airport");

        private String code;
        private String name;

        DestinationAirport(String code, String name) {
            this.code = code;
            this.name = name;
        }

        public static DestinationAirport getByCode(String code) {
            for (DestinationAirport ts : DestinationAirport.values()) {
                if (ts.code.equals(code)) {
                    return ts;
                }
            }
            return null;
        }
    }

    public void setTripSource(String s) {
        if ((tripDestination != null) && s.equals(tripDestination.code)) {
            System.out.println("The trip source and destination the passenger chooses CANNOT be the same location. ");
            System.exit(-1);
        }
        tripSource = TripSource.getByCode(s);
        sourceAirport = SourceAirport.getByCode(s);
    }

    public TripSource getTripSource() {
        return tripSource;
    }

    public void setDepartureDate(LocalDate departureDate) {
        this.departureDate = departureDate;
    }

    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public LocalDate getReturnDate() {
        LocalDate t = departureDate.plusDays(2);
        if (t.compareTo(returnDate) > 0) {
            return departureDate.plusDays(2);
        } else {
            return returnDate;
        }
    }

    /**
     *
     * @param s  trip source
     * @param s1  trip destination
     */
    public void setTripDestination(String s, String s1) {
        if (s.equals(s1)) {
            System.out.println("The trip source and destination the passenger chooses CANNOT be the same location. ");
            System.exit(-1);
        }

        tripSource = TripSource.getByCode(s);
        sourceAirport = SourceAirport.getByCode(s);

        tripDestination = TripDestination.getByCode(s1);
        destinationAirport = DestinationAirport.getByCode(s1);
    }

    public void setTripType(String s) {
        tripType = TripType.getByCode(s);
    }

    public String getTripType() {
        return tripType.name;
    }

    public void setTicketNumber(int index) {
        ticketNumber[index] = "";

        if (tripType.code.equals("1")) {
            ticketNumber[index] += "11";
        } else {
            ticketNumber[index] += "22";
        }

        if (bookingClass.code.equals("1")) {
            ticketNumber[index] += "F";
        } else if (bookingClass.code.equals("2")) {
            ticketNumber[index] += "B";
        } else {
            ticketNumber[index] += "E";
        }

        Random random = new Random();
        for (int i = 0; i < 4; i++) {
            char c = (char)(random.nextInt((26))+65);
            ticketNumber[index] += c;
        }

        if (((tripSource.code.compareTo("3") < 0) && (tripDestination.code.compareTo("3") < 0))
                || ((tripSource.code.compareTo("3") > 0) && (tripDestination.code.compareTo("3") > 0))) {
            ticketNumber[index] += "DOM";
        } else {
            ticketNumber[index] += "INT";
        }
    }

    public String getTicketNumber(int index) {
        return ticketNumber[index];
    }

    public void setDepartingTicketPrice(int child, int adults) {
        int baseTicketPrice = 300;
        double taxes = 0;
        double serviceFee = 0;
        double bookingCharge = 0;
        if (((tripSource.code.compareTo("3") < 0) && (tripDestination.code.compareTo("3") < 0))
                || ((tripSource.code.compareTo("3") > 0) && (tripDestination.code.compareTo("3") > 0))) {
            taxes = 0.1;
            serviceFee = 0.05;
        } else {
            taxes = 0.15;
            serviceFee = 0.1;
        }

        if (bookingClass.code.equals("1")) {
            bookingCharge = 250;
        } else if (bookingClass.code.equals("2")) {
            bookingCharge = 150;
        } else {
            bookingCharge = 50;
        }

        departingTicketPrice = child*(baseTicketPrice+(taxes*baseTicketPrice)+(serviceFee*baseTicketPrice)+bookingCharge)
                + adults*(baseTicketPrice+(taxes*baseTicketPrice)+(serviceFee*baseTicketPrice)+bookingCharge);
    }

    public void setReturnTicketPrice() {
        returnTicketPrice = departingTicketPrice;
    }

    public void setTotalTicketPrice() {
        if (tripType.code.equals("1")) {
            totalTicketPrice = departingTicketPrice;
        } else {
            totalTicketPrice = departingTicketPrice + returnTicketPrice;
        }
    }

    public double getTotalTicketPrice() {
        return totalTicketPrice;
    }

    public void setBookingClass(String s) {
       bookingClass = BookingClass.getByCode(s);
    }

    public BookingClass getBookingClass() {
        return bookingClass;
    }

    public SourceAirport getSourceAirport() {
        return sourceAirport;
    }

    public void setSourceAirport(String s) {
        if ((tripDestination != null) && s.equals(destinationAirport.code)) {
            System.out.println("The trip source airport and destination airport the passenger chooses CANNOT be the same location.");
            System.exit(-1);
        }
        this.sourceAirport = SourceAirport.getByCode(s);
    }

    public DestinationAirport getDestinationAirport() {
        return destinationAirport;
    }

    public void setDestinationAirport(String s, String s1) {
        if (s.equals(s1)) {
            System.out.println("The trip source airport and destination airport the passenger chooses CANNOT be the same location.");
            System.exit(-1);
        }
        tripSource = TripSource.getByCode(s);
        sourceAirport = SourceAirport.getByCode(s);

        tripDestination = TripDestination.getByCode(s1);
        destinationAirport = DestinationAirport.getByCode(s1);
    }

    @Override
    public String toString() {
        String result = "Thank you for booking your flight with " + flightCompany +". Following are the details " +
                "of your booking and the trip:\n" +
                "\n" +
                "Ticket Number: " + getTicketNumber(0) + "\n" +
                "Passenger Name: " + passengerFullName +"\n" +
                "From " + getTripSource().name + " to " + getTripDestination().name + "\n" +
                "Date of departure: " + getDepartureDate() + "\n";

        if (departureDate.plusDays(2).compareTo(returnDate) > 0) {
            result += "Date of return: " + getReturnDate() + " (Changed from old " + returnDate + " to new " + getReturnDate() + ")\n";
        } else {
            result += "Date of return: " + getReturnDate() + "\n";
        }

        result += "Total passengers: " + getTotalPassengers() + "\n" +
                "Total ticket price in Euros: " + getTotalTicketPrice();
        return result;
    }

    public void reserveTickets() {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        this.totalPassengers = size;
        passengerFullName = new String[size];
        passengerGender = new String[size];
        passengerAge = new int[size];
        ticketNumber = new String[size];

        for (int i = 0; i < size; i++) {
            System.out.print("passengerFullName: ");
            setPassengerFullName(i, scanner.next());
            System.out.print("passengerGender: ");
            setPassengerGender(i, scanner.next());
            System.out.print("passengerAge: ");
            setPassengerAge(i, scanner.nextInt());
            System.out.print("tripSource: ");
            String ts = scanner.next();
            setTripSource(ts);
            System.out.print("tripDestination: ");
            setTripDestination(ts, scanner.next());
            System.out.print("tripType: ");
            setTripType(scanner.next());
            System.out.print("bookingClass: ");
            setBookingClass(scanner.next());
            System.out.print("departureDate: ");
            String s = scanner.next();
            setDepartureDate(LocalDate.parse(s));
            System.out.print("returnDate: ");
            String s1 = scanner.next();
            setReturnDate(LocalDate.parse(s1));
            System.out.print("ticketPrice: ");

            setTicketNumber(i);
        }

        // calucate ticket price
        setDepartingTicketPrice(0, size);
        setReturnTicketPrice();
        setTotalTicketPrice();
    }

    public void displayTripDetails() {
        String temp = "";
        for (int i = 0; i < totalPassengers; i++) {
            temp = temp + (i+1) + "/";
        }

        String result = "Thank you for booking your flights with " + flightCompany + ".\n" +
                "You reserved a total of " + temp + "tickets.\n" +
                "\n" +
                "Here are the trip details for Passenger No." + temp + "\n";
        for (int i = 0; i < totalPassengers; i++) {
            result += "Passenger's Ticket Number: " + getTicketNumber(i) + "\n" +
                    "Passenger's Full Name: " + getPassengerFullName(i) + "\n" +
                    "Passenger's Age: " + getPassengerAge(i) + "\n" +
                    "Passenger's Gender: " + getPassengerGender(i) + "\n" +
                    "From: tripSource (" + getSourceAirport() + ")\n" +
                    "To: tripDestination (" + getDestinationAirport() + ")\n" +
                    "The flight departs on: " + getDepartureDate() + ")\n";
            if (departureDate.plusDays(2).compareTo(returnDate) > 0) {
                result += "And the return flight is on: " + getReturnDate() + "(Changed from old " + returnDate + "to new " + getReturnDate() + ")\n\n";
            } else {
                result += "And the return flight is on: " + getReturnDate() + "\n\n";
            }
        }

        result += "The total ticket price is: " + getTotalTicketPrice();
        System.out.println(result);
    }
}

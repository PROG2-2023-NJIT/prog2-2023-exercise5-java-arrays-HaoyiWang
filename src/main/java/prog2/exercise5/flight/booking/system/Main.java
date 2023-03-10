package prog2.exercise5.flight.booking.system;


import java.time.LocalDate;

public class Main
{
    public static void main( String[] args )
    {
        int size = 3;
        FlightBooking fb = new FlightBooking(size);

        String [] fullName = {"Matt Jive", "Sally Fields", "Posh Quattro"};
        String [] gender = {"Male", "Female", "Other"};
        int [] age = {43, 32, 21};

        for(int i=0; i<size; ++i){
            fb.setPassengerFullName(i, fullName[i]);
            fb.setPassengerGender(i, gender[i]);
            fb.setPassengerAge(i, age[i]);
        }

        fb.setTripSource("1");
        fb.setSourceAirport("1");

        fb.setTripDestination("1", "3");
        fb.setDestinationAirport("1", "3");

        fb.setTripType("2");

        fb.setBookingClass("1");

        String sdepart = "2023-04-12";
        LocalDate departingOn = LocalDate.parse(sdepart);

        String returnD = "2023-05-12";
        LocalDate returningOn = LocalDate.parse(returnD);

        fb.setDepartureDate(departingOn);
        fb.setReturnDate(returningOn);

        fb.setDepartingTicketPrice(0, 3);

        fb.setReturnTicketPrice();

        fb.setTotalTicketPrice();

        for(int j=0; j<size; ++j){
            fb.setTicketNumber(j);
        }

        fb.displayTripDetails();
    }
}

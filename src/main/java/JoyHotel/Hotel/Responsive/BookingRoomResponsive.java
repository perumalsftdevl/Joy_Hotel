package JoyHotel.Hotel.Responsive;

import JoyHotel.Hotel.model.Room;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingRoomResponsive {

    private Long BookingId;



    private LocalDate CheckInDate;
    private LocalDate CheckOutDate;


    private String GuestFullName;

    private String GuestEmail;

    private int NumberOfAdults;

    private int NumberOfChildren;

    private int TotalNumberOfGuest;


    private String BookingConfirmationCode;

    public BookingRoomResponsive(Long bookingId, LocalDate checkInDate, LocalDate checkOutDate, int totalNumberOfGuest) {
        BookingId = bookingId;
        CheckInDate = checkInDate;
        CheckOutDate = checkOutDate;
        TotalNumberOfGuest = totalNumberOfGuest;
    }

    private Room Room;

}

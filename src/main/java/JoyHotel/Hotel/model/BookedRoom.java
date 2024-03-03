package JoyHotel.Hotel.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookedRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long BookingId;


    @Column(name = "check_in")
    private LocalDate CheckInDate;
    @Column(name = "check_out")
    private LocalDate CheckOutDate;

    @Column(name = "guest_full_name")
    private String GuestFullName;
    @Column(name = "guest_email")
    private String GuestEmail;
    @Column(name = "no_adults")
    private int NumberOfAdults;
    @Column(name = "no_children")
    private int NumberOfChildren;
    @Column(name = "total_guest")
    private int TotalNumberOfGuest;
    @Column(name = "confirm_code")
    private String BookingConfirmationCode;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_id")
    private Room Room;
    public int getNumberOfAdults() {
        return NumberOfAdults;
    }

    public void setNumberOfAdults(int numberOfAdults) {
        NumberOfAdults = numberOfAdults;
        calculateTotalNumberOfGuest();
    }

    public int getNumberOfChildren() {
        return NumberOfChildren;
    }

    public void setNumberOfChildren(int numberOfChildren) {
        NumberOfChildren = numberOfChildren;
        calculateTotalNumberOfGuest();
    }



    public String getBookingConfirmationCode() {
        return BookingConfirmationCode;
    }

    public void setBookingConfirmationCode(String bookingConfirmationCode) {
        BookingConfirmationCode = bookingConfirmationCode;
    }




    public void calculateTotalNumberOfGuest() {
        this.TotalNumberOfGuest = this.NumberOfAdults + this.NumberOfChildren;

    }


}

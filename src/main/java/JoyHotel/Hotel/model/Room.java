package JoyHotel.Hotel.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.RandomStringUtils;

import java.math.BigDecimal;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Entity
@Getter
@Setter
@AllArgsConstructor
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name = "room_type")
    private String RoomType;

    @Column(name = "room_price")
    private BigDecimal RoomPrice;
    @Column(name = "isBooked")
    private boolean isBooked = false;
    @Lob
    private Blob Photo;

    @OneToMany(mappedBy = "BookingId" ,fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<BookedRoom> Bookings;

    public Room() {
        this.Bookings = new ArrayList<>();
    }


    public void addBooking(BookedRoom booking) {
        if (Bookings == null) {
            Bookings = new ArrayList<>();
        }
        Bookings.add(booking);
        booking.setRoom(this);
        this.isBooked = true;
        String BookingCode = RandomStringUtils.randomNumeric(10);
        booking.setBookingConfirmationCode(BookingCode);
    }

}

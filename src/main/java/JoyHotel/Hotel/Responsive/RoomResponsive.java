package JoyHotel.Hotel.Responsive;

import jakarta.persistence.Column;
import jakarta.persistence.Lob;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.tomcat.util.codec.binary.Base64;

import java.math.BigDecimal;
import java.sql.Blob;
import java.util.List;
@Data
@NoArgsConstructor
public class RoomResponsive {



    private Long Id;


    private String RoomType;


    private BigDecimal RoomPrice;

    private boolean isBooked = false;

    private String  Photo;

    private List<BookingRoomResponsive> booking;

    public RoomResponsive(Long id, String roomType, BigDecimal roomPrice) {
        Id = id;
        RoomType = roomType;
        RoomPrice = roomPrice;
    }

    public RoomResponsive(Long id, String roomType, BigDecimal roomPrice, boolean isBooked, byte[] photoB, List<BookingRoomResponsive> booking) {
        Id = id;
        RoomType = roomType;
        RoomPrice = roomPrice;
        this.isBooked = isBooked;
        Photo = photoB != null ? Base64.encodeBase64String(photoB):null;
        this.booking = booking;
    }
}

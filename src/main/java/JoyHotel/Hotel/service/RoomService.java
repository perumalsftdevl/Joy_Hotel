package JoyHotel.Hotel.service;

import JoyHotel.Hotel.model.Room;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Map;

public interface RoomService {
     Room addNewRoom(MultipartFile photo, String roomType, BigDecimal roomPrice) throws IOException, SQLException;

    ResponseEntity<Map<String, Object>> RoomList();

}

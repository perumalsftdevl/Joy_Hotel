package JoyHotel.Hotel.service;

import JoyHotel.Hotel.model.Room;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;

@Service
public class RoomServiceImplements implements RoomService {
    @Override
    public Room addNewRoom(MultipartFile photo, String roomType, BigDecimal roomPrice) {
        Room room = new Room();
        room.setRoomType(roomType);
        room.setRoomPrice(roomPrice);
         if(photo.isEmpty()){

         }
        return null;
    }
}

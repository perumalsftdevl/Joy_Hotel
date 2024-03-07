package JoyHotel.Hotel.controller;


import JoyHotel.Hotel.Responsive.RoomResponsive;
import JoyHotel.Hotel.model.Room;
import JoyHotel.Hotel.service.RoomService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;

@RestController()

public class RoomController {

    private RoomService RoomService;
    public ResponseEntity<RoomResponsive> addNewRoom(@RequestParam("photo")  MultipartFile photo,@RequestParam("roomType") String RoomType,@RequestParam("roomPrice") BigDecimal roomPrice){
        Room savedRoom =RoomService.addNewRoom(photo,RoomType,roomPrice);
        RoomResponsive responsive = new RoomResponsive(savedRoom.getId(),savedRoom.getRoomType(),savedRoom.getRoomPrice());
        return  ResponseEntity.ok(responsive);

    }
}

package JoyHotel.Hotel.controller;


import JoyHotel.Hotel.Responsive.RoomResponsive;
import JoyHotel.Hotel.model.Room;
import JoyHotel.Hotel.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@RestController()
@RequiredArgsConstructor


@RequestMapping("/rooms")
public class RoomController {
    @Autowired
    private RoomService RoomService;

    @PostMapping(path = "/add/new-room")
    public ResponseEntity<RoomResponsive> addNewRoom(@RequestParam("photo") MultipartFile photo, @RequestParam("roomType") String RoomType, @RequestParam("roomPrice") BigDecimal roomPrice) throws SQLException, IOException {
        Room savedRoom = RoomService.addNewRoom(photo, RoomType, roomPrice);
        RoomResponsive responsive = new RoomResponsive(savedRoom.getId(), savedRoom.getRoomType(), savedRoom.getRoomPrice());
        return ResponseEntity.ok(responsive);
    }

    @GetMapping(path = "/room")
    public ResponseEntity<Map<String, Object>> RoomList() {
        return RoomService.RoomList();
    }
}

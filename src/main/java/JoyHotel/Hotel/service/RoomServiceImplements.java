package JoyHotel.Hotel.service;

import JoyHotel.Hotel.model.Room;
import JoyHotel.Hotel.Repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.sql.rowset.serial.SerialBlob;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;

import java.sql.Blob;
import java.sql.SQLException;
import java.util.*;

@Service
@RequiredArgsConstructor

public class RoomServiceImplements implements RoomService {
    @Autowired
    private final RoomRepository RoomRepository;

    @Override
    public Room addNewRoom(MultipartFile file, String roomType, BigDecimal roomPrice) throws IOException, SQLException {
        Room room = new Room();
        System.out.println("roomType" + roomType + "roomPrice" + roomPrice + "file" + file);
        room.setRoomType(roomType);
        room.setRoomPrice(roomPrice);

        if (!file.isEmpty()) {
            byte[] photoBytes = file.getBytes();
            System.out.println("photoBlob"+file);

            Blob photoBlob = new SerialBlob(photoBytes);
            System.out.println("photoBlob"+photoBlob);

            room.setPhoto(photoBlob); // Store the byte array instead of the Blob
        }

        System.out.println("saved_room" + room);
        return RoomRepository.save(room);
    }
    public ResponseEntity<Map<String, Object>> RoomList() {
        Map<String, Object> response = new HashMap<>();

        try {
            List<Room> roomList = RoomRepository.findAll();
            List<Map<String, Object>> roomDataList = new ArrayList<>();

            for (Room room : roomList) {
                Map<String, Object> roomData = new HashMap<>();
                roomData.put("roomType", room.getRoomType());
                roomData.put("roomPrice", room.getRoomPrice());

                // Assuming you have a method to get the photo as byte[]
                byte[] photoBytes = convertBlobToByteArray(room.getPhoto());

                // Convert byte[] to Base64 encoded string if needed
                String photoBase64 = Base64.getEncoder().encodeToString(photoBytes);

                // Add the photo data to the room data map
                roomData.put("photo", photoBase64);
                roomDataList.add(roomData);
            }

            response.put("status", true);
            response.put("msg", "Data Fetch Successfully");
            response.put("record", roomDataList);

            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception ex) {
            response.put("status", false);
            response.put("msg", ex.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private byte[] convertBlobToByteArray(Blob blob) throws SQLException, IOException {
        if (blob == null)
            return null;
        try (InputStream inputStream = blob.getBinaryStream()) {
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
            return outputStream.toByteArray();
        }
    }


}

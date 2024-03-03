package JoyHotel.Hotel.Repository;

import JoyHotel.Hotel.model.BookedRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookedRoomRepository extends JpaRepository<BookedRoom,Integer> {
}

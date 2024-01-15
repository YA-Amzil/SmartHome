package be.pxl.smarthome.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import be.pxl.smarthome.domain.Room;

@Repository
public interface RoomRepository extends JpaRepository<Room, Integer> {

}

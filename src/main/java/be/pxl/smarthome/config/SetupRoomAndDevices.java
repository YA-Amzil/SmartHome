package be.pxl.smarthome.config;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import be.pxl.smarthome.domain.Device;
import be.pxl.smarthome.domain.DeviceState;
import be.pxl.smarthome.domain.DeviceType;
import be.pxl.smarthome.domain.Room;
import be.pxl.smarthome.repository.DeviceRepository;
import be.pxl.smarthome.repository.RoomRepository;

@Component
public class SetupRoomAndDevices implements CommandLineRunner {

        private final RoomRepository roomRepository;
        private final DeviceRepository deviceRepository;

        @Autowired
        public SetupRoomAndDevices(RoomRepository roomRepository, DeviceRepository deviceRepository) {
                this.roomRepository = roomRepository;
                this.deviceRepository = deviceRepository;
        }

        @Override
        public void run(String... args) throws Exception {
                Room corridor = roomRepository.save(new Room("corridor"));
                // Room office = roomRepository.save(new Room("office"));
                Room livingRoom = roomRepository.save(new Room("living room"));
                Room bedroom = roomRepository.save(new Room("bedroom"));
                Room bathroom = roomRepository.save(new Room("bathroom"));

                deviceRepository
                                .save(new Device(bedroom, "Bedroom light 1", UUID.randomUUID(),
                                                DeviceType.LIGHT, DeviceState.OFF));
                deviceRepository.save(new Device(bedroom, "Bedroom window 1",
                                UUID.randomUUID(), DeviceType.DOOR_WINDOW_CONTACT,
                                DeviceState.OPEN));
                deviceRepository.save(new Device(bedroom, "Bedroom window 2",
                                UUID.randomUUID(), DeviceType.DOOR_WINDOW_CONTACT,
                                DeviceState.OPEN));
                deviceRepository.save(new Device(bathroom, "Bathroom window",
                                UUID.randomUUID(), DeviceType.DOOR_WINDOW_CONTACT,
                                DeviceState.CLOSED));
                deviceRepository.save(new Device(corridor, "Front door", UUID.randomUUID(),
                                DeviceType.DOOR_WINDOW_CONTACT,
                                DeviceState.CLOSED));
                deviceRepository
                                .save(new Device(livingRoom, "Standing lamp", UUID.randomUUID(),
                                                DeviceType.LIGHT, DeviceState.OFF));
                deviceRepository
                                .save(new Device(livingRoom, "Living room light", UUID.randomUUID(),
                                                DeviceType.LIGHT, DeviceState.ON));
                deviceRepository.save(new Device(livingRoom, "Thermostat", UUID.randomUUID(),
                                DeviceType.THERMOSTAT,
                                DeviceState.ON, "{\"temp\": 20.5}"));
        }
}

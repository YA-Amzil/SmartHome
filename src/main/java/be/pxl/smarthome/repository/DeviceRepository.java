package be.pxl.smarthome.repository;

import be.pxl.smarthome.domain.Device;
import be.pxl.smarthome.domain.DeviceType;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeviceRepository extends JpaRepository<Device, Integer> {
    List<Device> findByDeviceType(DeviceType deviceType);
}

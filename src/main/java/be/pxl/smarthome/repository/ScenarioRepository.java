package be.pxl.smarthome.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import be.pxl.smarthome.domain.Scenario;

public interface ScenarioRepository extends JpaRepository<Scenario, Integer> {
    boolean existsByName(String name);
}

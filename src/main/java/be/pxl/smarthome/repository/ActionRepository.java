package be.pxl.smarthome.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import be.pxl.smarthome.domain.Action;

public interface ActionRepository extends JpaRepository<Action, Integer> {

}

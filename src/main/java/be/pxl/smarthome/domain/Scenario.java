package be.pxl.smarthome.domain;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Scenarios")
public class Scenario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	@OneToMany(mappedBy = "scenario", cascade = CascadeType.ALL)
	List<Action> actions = new ArrayList<>();

	public Scenario() {
		// JPA only
	}

	public Scenario(String name) {
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public List<Action> getActions() {
		// TODO: implement this method when field actions is available
		return actions;
	}

	public void addAction(Action action) {
		// Check if an action with the same device already existsks
		if (actions.stream().anyMatch(a -> a.getDevice().getId().equals(action.getDevice().getId()))) {
			Action existingAction = actions.stream()
					.filter(a -> a.getDevice().getId().equals(action.getDevice().getId()))
					.findFirst()
					.get();
			existingAction.setDeviceState(action.getDeviceState());
			existingAction.setSettings(action.getSettings());
		} else {
			// Add the new action to the scenario's list of actions
			actions.add(action);
		}
	}

}

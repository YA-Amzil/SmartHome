package be.pxl.smarthome.api.request;

import jakarta.validation.constraints.NotBlank;

public record ScenarioRequest(@NotBlank(message = "name cannot be blank") String name) {
}

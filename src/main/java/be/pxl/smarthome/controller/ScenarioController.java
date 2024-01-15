package be.pxl.smarthome.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import be.pxl.smarthome.api.request.ActionRequest;
import be.pxl.smarthome.api.request.ScenarioRequest;
import be.pxl.smarthome.api.respone.ToastrErrorResponse;
import be.pxl.smarthome.service.ScenarioService;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping(path = "scenarios")
public class ScenarioController {

    private final ScenarioService scenarioService;

    @Autowired
    public ScenarioController(ScenarioService scenarioService) {
        this.scenarioService = scenarioService;
    }

    @PostMapping
    public ResponseEntity<Integer> createScenario(@Valid @RequestBody ScenarioRequest request) {
        scenarioService.createScenario(request);
        return new ResponseEntity<Integer>(HttpStatus.CREATED);
    }

    @PutMapping(path = "/{scenarioId}/actions")
    public ResponseEntity<Void> addActionToScenario(@PathVariable Integer scenarioId,
            @RequestBody ActionRequest actionRequest) {
        scenarioService.addAction(scenarioId, actionRequest);
        return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
    }

    @PostMapping(path = "/{scenarioId}/triggers")
    public ResponseEntity<Void> triggerScenario(@PathVariable Integer scenarioId) {
        scenarioService.triggers(scenarioId);
        return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ToastrErrorResponse> handleException(Errors errors) {
        var errorList = errors.getAllErrors();
        return new ResponseEntity<ToastrErrorResponse>(new ToastrErrorResponse(errorList.get(0).getDefaultMessage()),
                HttpStatus.BAD_REQUEST);
    }
}

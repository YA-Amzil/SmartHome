# SmartHome API
1. H2 Database
2. Webpagina
3. API documentation
4. Validation script

## 1. H2 database

http://localhost:8080/smarthome/h2-console

database url and credentials can be found in `appplication.properties`.
When you uncomment the file SetupRoomAndDevices and you have a CommandLineRunner that populates the database.

## 2. Webpagina

In the folder resources/static/ you'll find an HTML file devices.html. Here you can toggle the status of the devices.

## 3. API documentation

### Get list of devices

#### Request

`GET http://{server}:{port}/smarthome/devices`

    e.g. http://localhost:8080/smarthome/devices


#### Response

    200 OK
    Content-Type: application/json

    [{
		"id": 1,
		"name": "Bedroom light 1",
		"type": "LIGHT",
		"room": "bedroom",
		"state": "OFF"
	},
     ...]

### Create a new scenario

#### Request

POST http://{server}:{port}/smarthome/scenarios
    
    {
        "name": "Leaving home"
    }

#### Response

    201 Created

    409 Conflict
    e.g. in case the exact name already exists

    400 Bad Request
    e.g. in case the name is missing


### Add action to scenario

#### Request

PUT http://{server}:{port}/smarthome/scenarios/{scenarioId}/actions
where parameter `{scenarioId}` refers to a valid id of a scenario

    {
	    "deviceId": 2,
	    "deviceState": "CLOSED"
    }


#### Responses

    202 Accepted

    404 Not Found
    Invalid scenarioId or deviceId

### Trigger a scenario

#### Request

POST http://{server}:{port}/smarthome/scenarios/{scenarioId}/triggers
where parameter `{scenarioId}` refers to an id of a scenario

#### Responses

    202 Accepted

    404 Not Found
    Invalid scenarioId

    406 Not Acceptable
    Sensors are not in the desired state

## 4. Validation script

In the resources directory you can find a script smarthome_valideren.sh to validate
your solution.

When you run the script you should see the following output (with extra whitespaces):

    +++++++++++++++++++++++++++++++++++++++++++++++++++
    CONTROLE 1: OVERZICHT DEVICES
    [{"id":1,"name":"Bedroom light 1","type":"LIGHT","room":"bedroom","state":"OFF"},
    {"id":2,"name":"Bedroom window 1","type":"DOOR_WINDOW_CONTACT","room":"bedroom","state":"OPEN"},
    {"id":3,"name":"Bedroom window 2","type":"DOOR_WINDOW_CONTACT","room":"bedroom","state":"OPEN"},
    {"id":4,"name":"Bathroom window","type":"DOOR_WINDOW_CONTACT","room":"bathroom","state":"CLOSED"},
    {"id":5,"name":"Front door","type":"DOOR_WINDOW_CONTACT","room":"corridor","state":"CLOSED"},
    {"id":6,"name":"Standing lamp","type":"LIGHT","room":"living room","state":"OFF"},
    {"id":7,"name":"Living room light","type":"LIGHT","room":"living room","state":"ON"},
    {"id":8,"name":"Thermostat","type":"THERMOSTAT","room":"living room","state":"ON"}]
    +++++++++++++++++++++++++++++++++++++++++++++++++++
    CONTROLE 2: SCENARIO MAKEN
    +++++++++++++++++++++++++++++++++++++++++++++++++++
    CONTROLE 3: SCENARIO MET BESTAANDE NAAM
    {"timestamp":"2023-05-29T13:05:41.380+00:00","status":409,"error":"Conflict","message":"Scenario [Leaving home] already created.","path":"/smarthome/scenarios"}
    +++++++++++++++++++++++++++++++++++++++++++++++++++
    CONTROLE 4: ACTIONS TOEVOEGEN
    +++++++++++++++++++++++++++++++++++++++++++++++++++
    CONTROLE 5: TRIGGER SCENARIO
    {"timestamp":"2023-05-29T13:05:41.611+00:00","status":406,"error":"Not Acceptable","message":"Bedroom window 1 is not in state CLOSED","path":"/smarthome/scenarios/1/triggers"}

    Press any key:

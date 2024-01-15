#!/bin/bash
PORT=8082
OUTPUT=500

echo $'\n+++++++++++++++++++++++++++++++++++++++++++++++++++\n'
echo $'CONTROLE 1: OVERZICHT DEVICES\n'
curl -H Content-Type:application/json http://localhost:$PORT/smarthome/devices
echo $''
echo $'\n+++++++++++++++++++++++++++++++++++++++++++++++++++\n'
echo $'CONTROLE 2: SCENARIO MAKEN\n'
curl -d '{"name": "Leaving home"}' -H Content-Type:application/json -X POST http://localhost:$PORT/smarthome/scenarios
curl -d '{"name": "Coming home"}' -H Content-Type:application/json -X POST http://localhost:$PORT/smarthome/scenarios
echo $''
echo $'\n+++++++++++++++++++++++++++++++++++++++++++++++++++\n'
echo $'CONTROLE 3: SCENARIO MET BESTAANDE NAAM\n'
curl -d '{"name": "Leaving home"}' -H Content-Type:application/json -X POST http://localhost:$PORT/smarthome/scenarios
echo $''
echo $'\n+++++++++++++++++++++++++++++++++++++++++++++++++++\n'
echo $'CONTROLE 4: ACTIONS TOEVOEGEN\n'
curl -d '{"deviceId": 2, "deviceState": "CLOSED"}' -H Content-Type:application/json -X PUT http://localhost:$PORT/smarthome/scenarios/1/actions
curl -d '{"deviceId": 3, "deviceState": "CLOSED"}' -H Content-Type:application/json -X PUT http://localhost:$PORT/smarthome/scenarios/1/actions
curl -d '{"deviceId": 6, "deviceState": "ON"}' -H Content-Type:application/json -X PUT http://localhost:$PORT/smarthome/scenarios/1/actions
curl -d '{"deviceId": 7, "deviceState": "OFF"}' -H Content-Type:application/json -X PUT http://localhost:$PORT/smarthome/scenarios/1/actions
curl -d '{"deviceId": 8, "deviceState": "OFF"}' -H Content-Type:application/json -X PUT http://localhost:$PORT/smarthome/scenarios/1/actions
curl -d '{"deviceId": 6, "deviceState": "OFF"}' -H Content-Type:application/json -X PUT http://localhost:$PORT/smarthome/scenarios/2/actions
curl -d '{"deviceId": 7, "deviceState": "ON"}' -H Content-Type:application/json -X PUT http://localhost:$PORT/smarthome/scenarios/2/actions
curl -d '{"deviceId": 8, "deviceState": "ON", "settings": "{''temp'': 20.5}"}' -H Content-Type:application/json -X PUT http://localhost:$PORT/smarthome/scenarios/2/actions
echo $'\n+++++++++++++++++++++++++++++++++++++++++++++++++++\n'
echo $'CONTROLE 5: TRIGGER SCENARIO\n'
response=$(curl -s -H Content-Type:application/json -X POST http://localhost:$PORT/smarthome/scenarios/1/triggers)
echo ${response:0:$OUTPUT}
response=$(curl -s -H Content-Type:application/json -X POST http://localhost:$PORT/smarthome/scenarios/2/triggers)
echo ${response:0:$OUTPUT}
echo $'\n'
echo Press any key:
read key

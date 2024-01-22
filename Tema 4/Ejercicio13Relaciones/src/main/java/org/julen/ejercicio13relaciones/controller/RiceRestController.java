package org.julen.ejercicio13relaciones.controller;

import jakarta.transaction.Transactional;
import org.apache.coyote.Response;
import org.julen.ejercicio13relaciones.model.Driver;
import org.julen.ejercicio13relaciones.model.Race;
import org.julen.ejercicio13relaciones.service.RaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RiceRestController {

    private final RaceService raceService;

    @Autowired
    public RiceRestController(RaceService raceService){
        this.raceService = raceService;
    }

    @GetMapping("/races")
    public ResponseEntity<List<Race>> getAll(){
        return ResponseEntity.ok(raceService.getAllRaces());
    }

    @GetMapping("/races/{code}")
    public ResponseEntity<Race> getByCode(@PathVariable String code){
        return this.raceService.getRaceByCode(code)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/races")
    public ResponseEntity<Race> create(@RequestBody Race race){
        if(race.getRaceId() != null){
            return ResponseEntity.badRequest().build();
        }
        this.raceService.saveRace(race);
        return ResponseEntity.ok(race);
    }

    @PutMapping("/races")
    public ResponseEntity<Race> update(@RequestBody Race race){
        this.raceService.saveRace(race);
        return ResponseEntity.ok(race);
    }

    @Transactional
    @DeleteMapping("/races/{code}")
    public ResponseEntity<Race> deleteByCode(@PathVariable String code){
        this.raceService.deleteRaceByCode(code);
        return ResponseEntity.ok().build();
    }
}

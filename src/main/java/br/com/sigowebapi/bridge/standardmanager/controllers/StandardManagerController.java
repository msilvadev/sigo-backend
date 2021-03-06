package br.com.sigowebapi.bridge.standardmanager.controllers;

import br.com.sigowebapi.bridge.standardmanager.dtos.StandardDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("standard-manager")
public class StandardManagerController {

    @GetMapping
    public ResponseEntity<List<StandardDto>> listAllAssistance() {
        //TODO: Create service layer to call correct service...
        return null;
    }

    @PostMapping
    public ResponseEntity<StandardDto> saveAssistance(@RequestBody StandardDto input) {
        //TODO: Create service layer to call correct service...
        return null;
    }
}

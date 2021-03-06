package br.com.sigowebapi.bridge.gcamanager.controllers;

import br.com.sigowebapi.bridge.gcamanager.dtos.AssistanceDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/assistance-manager")
public class GcaManagerController {

    @GetMapping
    public ResponseEntity<List<AssistanceDto>> listAllAssistance() {
        //TODO: Create service layer to call correct service...
        return null;
        //return ResponseEntity.ok(service.listAllAssistance());
    }

    @PostMapping
    public ResponseEntity<AssistanceDto> saveAssistance(@RequestBody AssistanceDto input) {
        //TODO: Create service layer to call correct service...
        return null;
        //return ResponseEntity.ok(service.saveAssistance(input));
    }
}

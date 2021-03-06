package br.com.sigowebapi.bridge.gpimanager.controllers;

import br.com.sigowebapi.bridge.gpimanager.dtos.IndustrialProcessDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("industrial-process")
public class GpiManagerController {

    @GetMapping
    public ResponseEntity<List<IndustrialProcessDto>> listAllIndustrialProcess() {
        //TODO: Create service layer to call correct service...
        return null;
    }

    @PostMapping
    public ResponseEntity<IndustrialProcessDto> saveIndustrialProcess(@RequestBody IndustrialProcessDto input) {
        //TODO: Create service layer to call correct service...
        return null;
    }
}

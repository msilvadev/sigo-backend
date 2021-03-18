package br.com.sigowebapi.bridge.standardmanager.controllers;

import br.com.sigowebapi.bridge.gcamanager.dtos.AssistanceDto;
import br.com.sigowebapi.bridge.shared.CallEndpointsService;
import br.com.sigowebapi.bridge.shared.SigoMicrosservicesEndpointsUri;
import br.com.sigowebapi.bridge.standardmanager.dtos.StandardDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("standard-manager")
public class StandardManagerController {

    private final CallEndpointsService service;

    private final SigoMicrosservicesEndpointsUri endpointsUri;

    public StandardManagerController(CallEndpointsService service,
                                     SigoMicrosservicesEndpointsUri endpointsUri) {
        this.service = service;
        this.endpointsUri = endpointsUri;
    }

    @GetMapping
    public ResponseEntity<StandardDto[]> listAllAssistance() {
        String uri = endpointsUri.getStandard() + "standard-manager";
        return ResponseEntity.ok(service.listAll(uri, StandardDto[].class));
    }

    @PostMapping
    public ResponseEntity<StandardDto> saveAssistance(@RequestBody StandardDto input) {
        String uri = endpointsUri.getStandard() + "standard-manager";
        return ResponseEntity.ok(service.saveGeneric(uri, input, StandardDto.class));
    }
}

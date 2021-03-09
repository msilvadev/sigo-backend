package br.com.sigowebapi.bridge.gcamanager.controllers;

import br.com.sigowebapi.bridge.gcamanager.dtos.AssistanceDto;
import br.com.sigowebapi.bridge.shared.CallEndpointsService;
import br.com.sigowebapi.bridge.shared.SigoMicrosservicesEndpointsUri;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/assistance-manager")
public class GcaManagerController {

    private final CallEndpointsService service;

    private final SigoMicrosservicesEndpointsUri endpointsUri;

    public GcaManagerController(CallEndpointsService service, SigoMicrosservicesEndpointsUri endpointsUri) {
        this.service = service;
        this.endpointsUri = endpointsUri;
    }

    @GetMapping
    public ResponseEntity<AssistanceDto[]> listAllAssistance() {
        String uri = endpointsUri.getGca() + "assistance-manager";
        return ResponseEntity.ok(service.listAll(uri, AssistanceDto[].class));
    }

    @PostMapping
    public ResponseEntity<AssistanceDto> saveAssistance(@RequestBody AssistanceDto input) {
        String uri = endpointsUri.getGca() + "assistance-manager";
        return ResponseEntity.ok(service.saveGeneric(uri, input, AssistanceDto.class));
    }
}

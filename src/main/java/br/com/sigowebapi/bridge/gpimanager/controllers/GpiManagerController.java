package br.com.sigowebapi.bridge.gpimanager.controllers;

import br.com.sigowebapi.bridge.gcamanager.dtos.AssistanceDto;
import br.com.sigowebapi.bridge.gpimanager.dtos.IndustrialProcessDto;
import br.com.sigowebapi.bridge.shared.CallEndpointsService;
import br.com.sigowebapi.bridge.shared.SigoMicrosservicesEndpointsUri;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("industrial-process")
public class GpiManagerController {

    private final CallEndpointsService service;

    private final SigoMicrosservicesEndpointsUri endpointsUri;

    public GpiManagerController(CallEndpointsService service, SigoMicrosservicesEndpointsUri endpointsUri) {
        this.service = service;
        this.endpointsUri = endpointsUri;
    }

    @GetMapping
    public ResponseEntity<IndustrialProcessDto[]> listAllIndustrialProcess() {
        String uri = endpointsUri.getGpi() + "industrial-process";
        return ResponseEntity.ok(service.listAll(uri, IndustrialProcessDto[].class));
    }

    @PostMapping
    public ResponseEntity<IndustrialProcessDto> saveIndustrialProcess(@RequestBody IndustrialProcessDto input) {
        String uri = endpointsUri.getGpi() + "industrial-process";
        return ResponseEntity.ok(service.saveGeneric(uri, input, IndustrialProcessDto.class));
    }
}

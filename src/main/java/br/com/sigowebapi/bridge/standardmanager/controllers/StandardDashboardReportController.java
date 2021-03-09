package br.com.sigowebapi.bridge.standardmanager.controllers;

import br.com.sigowebapi.bridge.gcamanager.dtos.DashboardAssistanceReportDto;
import br.com.sigowebapi.bridge.shared.CallEndpointsService;
import br.com.sigowebapi.bridge.shared.SigoMicrosservicesEndpointsUri;
import br.com.sigowebapi.bridge.standardmanager.dtos.StandardDashboardReportDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("standard-dashboard-report")
public class StandardDashboardReportController {

    private final CallEndpointsService service;

    private final SigoMicrosservicesEndpointsUri endpointsUri;

    public StandardDashboardReportController(CallEndpointsService service,
                                        SigoMicrosservicesEndpointsUri endpointsUri) {
        this.service = service;
        this.endpointsUri = endpointsUri;
    }

    @GetMapping
    public ResponseEntity<StandardDashboardReportDto> getDashboardReport() {
        String uri = endpointsUri.getStandard() + "standard-dashboard-report";
        return ResponseEntity.ok(service.get(uri, StandardDashboardReportDto.class));
    }
}

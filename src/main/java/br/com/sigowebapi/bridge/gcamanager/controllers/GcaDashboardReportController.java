package br.com.sigowebapi.bridge.gcamanager.controllers;

import br.com.sigowebapi.bridge.gcamanager.dtos.DashboardAssistanceReportDto;
import br.com.sigowebapi.bridge.shared.CallEndpointsService;
import br.com.sigowebapi.bridge.shared.SigoMicrosservicesEndpointsUri;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("gca-dashboard-report")
public class GcaDashboardReportController {

    private final CallEndpointsService service;

    private final SigoMicrosservicesEndpointsUri endpointsUri;

    public GcaDashboardReportController(CallEndpointsService service,
                                        SigoMicrosservicesEndpointsUri endpointsUri) {
        this.service = service;
        this.endpointsUri = endpointsUri;
    }

    @GetMapping
    public ResponseEntity<DashboardAssistanceReportDto> getDashboardReport() {
        String uri = endpointsUri.getGca() + "gca-dashboard-report";
        return ResponseEntity.ok(service.get(uri, DashboardAssistanceReportDto.class));
    }

}

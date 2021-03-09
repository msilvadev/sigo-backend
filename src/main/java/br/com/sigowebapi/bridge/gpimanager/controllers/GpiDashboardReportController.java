package br.com.sigowebapi.bridge.gpimanager.controllers;

import br.com.sigowebapi.bridge.gcamanager.dtos.DashboardAssistanceReportDto;
import br.com.sigowebapi.bridge.gpimanager.dtos.DashboardReportDto;
import br.com.sigowebapi.bridge.shared.CallEndpointsService;
import br.com.sigowebapi.bridge.shared.SigoMicrosservicesEndpointsUri;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("dashboard-report")
public class GpiDashboardReportController {

    private final CallEndpointsService service;

    private final SigoMicrosservicesEndpointsUri endpointsUri;

    public GpiDashboardReportController(CallEndpointsService service,
                                        SigoMicrosservicesEndpointsUri endpointsUri) {
        this.service = service;
        this.endpointsUri = endpointsUri;
    }

    @GetMapping
    public ResponseEntity<Map<Integer, DashboardReportDto>> getDashboardReport() {
        String uri = endpointsUri.getGpi() + "dashboard-report";

        return ResponseEntity.ok(service.get(uri));
    }
}

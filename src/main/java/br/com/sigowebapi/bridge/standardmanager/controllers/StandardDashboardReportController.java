package br.com.sigowebapi.bridge.standardmanager.controllers;

import br.com.sigowebapi.bridge.standardmanager.dtos.StandardDashboardReportDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("standard-dashboard-report")
public class StandardDashboardReportController {

    @GetMapping
    public ResponseEntity<StandardDashboardReportDto> getDashboardReport() {
        //TODO: Create service layer to call correct service...
        return null;
    }

    @PostMapping("refresh-cache")
    public ResponseEntity<StandardDashboardReportDto> refreshCache() {
        //TODO: Create service layer to call correct service...
        return null;
    }
}

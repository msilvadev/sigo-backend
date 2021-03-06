package br.com.sigowebapi.bridge.gpimanager.controllers;

import br.com.sigowebapi.bridge.gpimanager.dto.DashboardReportDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ConcurrentMap;

@RestController
@RequestMapping("dashboard-report")
public class GpiDashboardReportController {

    @GetMapping
    public ResponseEntity<ConcurrentMap<Integer, DashboardReportDto>> getDashboardReport() {
        //TODO: Create service layer to call correct service...
        return null;
    }

    @PostMapping("refresh-cache")
    public ResponseEntity<ConcurrentMap<Integer, DashboardReportDto>> refreshCache() {
        //TODO: Create service layer to call correct service...
        return null;
    }
}

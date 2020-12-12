package br.com.gpimanager.controllers;

import br.com.gpimanager.domains.dashboard.DashboardReportDto;
import br.com.gpimanager.domains.process.ProcessType;
import br.com.gpimanager.services.DashboardReportService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ConcurrentMap;

@RestController
@RequestMapping("dashboard-report")
public class DashboardReportController {

    private final DashboardReportService dashboardReportService;

    public DashboardReportController(DashboardReportService dashboardReportService) {
        this.dashboardReportService = dashboardReportService;
    }

    @GetMapping
    public ResponseEntity<ConcurrentMap<ProcessType, DashboardReportDto>> getDashboardReport() {
        return ResponseEntity.ok(dashboardReportService.getDashboardReport());
    }

    @PostMapping("refresh-cache")
    public ResponseEntity<ConcurrentMap<ProcessType, DashboardReportDto>> refreshCache() {
        dashboardReportService.initializeCache();
        return ResponseEntity.ok(dashboardReportService.getDashboardReport());
    }
}

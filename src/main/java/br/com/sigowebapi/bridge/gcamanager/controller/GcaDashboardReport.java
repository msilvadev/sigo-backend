package br.com.sigowebapi.bridge.gcamanager.controller;

import br.com.sigowebapi.bridge.gcamanager.dto.DashboardAssistanceReportDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("gca-dashboard-report")
public class GcaDashboardReport {

//    private final DashboardReportService dashboardReportService;
//
//    public DashboardReportController(DashboardReportService dashboardReportService) {
//        this.dashboardReportService = dashboardReportService;
//    }

    @GetMapping
    public ResponseEntity<DashboardAssistanceReportDto> getDashboardReport() {
        //TODO: Create service layer to call correct service...
        return null;
//        return ResponseEntity.ok(dashboardReportService.getDashboardReport());
    }

    @PostMapping("refresh-cache")
    public ResponseEntity<DashboardAssistanceReportDto> refreshCache() {
        //TODO: Create service layer to call correct service...
        return null;
//        dashboardReportService.initializeCache();
//        return ResponseEntity.ok(dashboardReportService.getDashboardReport());
    }
}

package br.com.gpimanager.services;

import br.com.gpimanager.domains.dashboard.DashboardReportDto;
import br.com.gpimanager.domains.process.ProcessType;

import java.util.concurrent.ConcurrentMap;

public interface DashboardReportService {

    void initializeCache();

    void updateCacheDashboarReport(ProcessType processType, DashboardReportDto updateReport);

    ConcurrentMap<ProcessType, DashboardReportDto> getDashboardReport();
}

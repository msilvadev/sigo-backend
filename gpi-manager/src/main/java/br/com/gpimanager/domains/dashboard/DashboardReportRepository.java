package br.com.gpimanager.domains.dashboard;

import br.com.gpimanager.domains.process.ProcessType;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@Component
public class DashboardReportRepository {

    private final ConcurrentHashMap<ProcessType, DashboardReportDto> dashboardCache = new ConcurrentHashMap<>();

    public void addAll(ProcessType processType, Set<DashboardReportDto> newReports) {
        newReports.forEach(report -> {
            DashboardReportDto byProcessType = this.getByProcessType(processType);

            if (Objects.nonNull(byProcessType)) {
                byProcessType.setQuantity(1);
            } else {
                dashboardCache.put(processType, report);
            }
        });
    }

    public ConcurrentMap<ProcessType, DashboardReportDto> getAllDashboardReports() {
        return dashboardCache;
    }

    public DashboardReportDto getByProcessType(ProcessType processType) {
        return dashboardCache.get(processType);
    }

    public int size() {
        return dashboardCache.size();
    }

    public DashboardReportDto update(ProcessType processType, DashboardReportDto updateReport) {
        DashboardReportDto byProcessType = this.getByProcessType(processType);

        if (Objects.nonNull(byProcessType)) {
            byProcessType.setQuantity(1);
        } else {
            dashboardCache.put(processType, updateReport);
        }

        return this.getByProcessType(processType);
    }

}

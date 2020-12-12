package br.com.gpimanager.services;

import br.com.gpimanager.domains.dashboard.DashboardReportDto;
import br.com.gpimanager.domains.dashboard.DashboardReportDtoBuilder;
import br.com.gpimanager.domains.dashboard.DashboardReportRepository;
import br.com.gpimanager.domains.process.IndustrialProcessRepository;
import br.com.gpimanager.domains.process.ProcessStatus;
import br.com.gpimanager.domains.process.ProcessType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
public class DashboardReportServiceImpl implements DashboardReportService {

    private static final Logger LOGGER = LoggerFactory.getLogger(DashboardReportServiceImpl.class);

    private final IndustrialProcessRepository industrialProcessRepository;
    private final DashboardReportRepository dashboardReportRepository;

    private final List<Runnable> tasks;

    public DashboardReportServiceImpl(IndustrialProcessRepository industrialProcessRepository,
                                      DashboardReportRepository dashboardReportRepository) {
        this.industrialProcessRepository = industrialProcessRepository;
        this.dashboardReportRepository = dashboardReportRepository;

        tasks = Collections.singletonList(() -> {
            this.loadProcessTypeDefaultDashboardReport();
            this.loadProcessTypeNewOrderDashboardReport();
            this.loadProcessTypeDeliveryTissueDashboardReport();
        });
    }

    @Override
    public void initializeCache() {
        LOGGER.info("Initialize Dashboard Report Cache...");

        long start = System.currentTimeMillis();

        this.executeAllTasks(tasks).join();

        LOGGER.info("Dashboard Report Cache loaded in {} ms", System.currentTimeMillis() - start);

        LOGGER.info("Load {} Dashboard Report Cache", this.dashboardReportRepository.size());
    }

    @Override
    public void updateCacheDashboarReport(ProcessType processType, DashboardReportDto updateReport) {
        dashboardReportRepository.update(processType, updateReport);
    }

    @Override
    public ConcurrentMap<ProcessType, DashboardReportDto> getDashboardReport() {
        return dashboardReportRepository.getAllDashboardReports();
    }

    public void loadProcessTypeDefaultDashboardReport() {
        DashboardReportDtoBuilder builder = new DashboardReportDtoBuilder();
        Set<DashboardReportDto> reportList = new HashSet<>();

        addDashboardReportToCache(ProcessType.DEFAULT, builder, reportList);
    }

    public void loadProcessTypeNewOrderDashboardReport() {
        DashboardReportDtoBuilder builder = new DashboardReportDtoBuilder();
        Set<DashboardReportDto> reportList = new HashSet<>();

        addDashboardReportToCache(ProcessType.NEW_ORDER, builder, reportList);
    }

    public void loadProcessTypeDeliveryTissueDashboardReport() {
        DashboardReportDtoBuilder builder = new DashboardReportDtoBuilder();
        Set<DashboardReportDto> reportList = new HashSet<>();

        addDashboardReportToCache(ProcessType.DELIVERY_TISSUE, builder, reportList);
    }

    private void addDashboardReportToCache(ProcessType processType, DashboardReportDtoBuilder builder,
                                           Set<DashboardReportDto> reportList) {
        reportList.add(builder.setQuantity(industrialProcessRepository.countByProcessTypeAndProcessStatus(processType, ProcessStatus.INITIATED))
                .setStatus(ProcessStatus.INITIATED.getCode())
                .build());
        reportList.add(builder.setQuantity(industrialProcessRepository.countByProcessTypeAndProcessStatus(processType, ProcessStatus.PROCESSING))
                .setStatus(ProcessStatus.PROCESSING.getCode())
                .build());
        reportList.add(builder.setQuantity(industrialProcessRepository.countByProcessTypeAndProcessStatus(processType, ProcessStatus.SUCCESS))
                .setStatus(ProcessStatus.SUCCESS.getCode())
                .build());
        reportList.add(builder.setQuantity(industrialProcessRepository.countByProcessTypeAndProcessStatus(processType, ProcessStatus.OVERDUE))
                .setStatus(ProcessStatus.OVERDUE.getCode())
                .build());
        reportList.add(builder.setQuantity(industrialProcessRepository.countByProcessTypeAndProcessStatus(processType, ProcessStatus.FAILED))
                .setStatus(ProcessStatus.FAILED.getCode())
                .build());

        this.dashboardReportRepository.addAll(processType, reportList);
    }

    private CompletableFuture<Void> executeAllTasks(List<Runnable> tasks) {
        ExecutorService executor = Executors.newFixedThreadPool(10);
        return CompletableFuture.allOf(tasks.stream()
                .map(task -> CompletableFuture.runAsync(task, executor)).toArray(CompletableFuture[]::new));
    }

}

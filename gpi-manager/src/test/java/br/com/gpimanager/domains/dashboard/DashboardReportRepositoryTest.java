package br.com.gpimanager.domains.dashboard;

import br.com.gpimanager.domains.process.ProcessStatus;
import br.com.gpimanager.domains.process.ProcessType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class DashboardReportRepositoryTest {

    private DashboardReportRepository repository;
    private final ProcessType processType = ProcessType.DEFAULT;
    private Set<DashboardReportDto> newReports;
    private DashboardReportDtoBuilder builder;

    @BeforeEach
    void setUp() {
        repository = new DashboardReportRepository();
        newReports = new HashSet<>();
        builder = new DashboardReportDtoBuilder();

        newReports.add(builder.setQuantity(1).setStatus(1).build());
        repository.addAll(processType, newReports);
    }

    @Test
    void addAll() {
        this.newReports.add(builder.setQuantity(1).setStatus(1).build());
        repository.addAll(ProcessType.NEW_ORDER, this.newReports);

        assertThat(repository.getAllDashboardReports()).hasSize(2);
    }

    @Test
    void getAllDashboardReports() {
        assertThat(repository.getAllDashboardReports()).isNotEmpty();
    }

    @Test
    void getByProcessType() {
        DashboardReportDto dto = repository.getByProcessType(this.processType);

        assertThat(dto.getStatus()).isEqualTo(ProcessStatus.valueOfCode(1).getCode());
    }

    @Test
    void size() {
        assertThat(repository.getAllDashboardReports()).hasSize(1);
    }

    @Test
    void update() {
        DashboardReportDto update = builder.setQuantity(1).setStatus(1).build();
        repository.update(this.processType, update);

        DashboardReportDto result = repository.getByProcessType(this.processType);

        assertThat(result.getQuantity()).isEqualTo(2);
    }

    @Test
    void tryUpdateWhenNotExistYet() {
        DashboardReportDto update = builder.setQuantity(1).setStatus(1).build();
        repository.update(ProcessType.DELIVERY_TISSUE, update);

        DashboardReportDto result = repository.getByProcessType(this.processType);

        assertThat(result.getQuantity()).isEqualTo(1);
    }
}
package br.com.gpimanager.domains.dashboard;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class DashboardReportDtoTest {

    private DashboardReportDto dashboardReportDto;

    @BeforeEach
    void setUp() {
        dashboardReportDto = new DashboardReportDto(1, 1);
    }

    @Test
    void getQuantity() {
        assertThat(dashboardReportDto.getQuantity()).isEqualTo(1);
    }

    @Test
    void getStatus() {
        assertThat(dashboardReportDto.getStatus()).isEqualTo(1);
    }

    @Test
    void setQuantity() {
        dashboardReportDto.setQuantity(1);
        assertThat(dashboardReportDto.getQuantity()).isEqualTo(2);
    }
}
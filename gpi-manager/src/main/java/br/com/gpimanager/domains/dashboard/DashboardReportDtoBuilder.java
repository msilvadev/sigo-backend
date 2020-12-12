package br.com.gpimanager.domains.dashboard;

public class DashboardReportDtoBuilder {

    private int quantity;
    private int status;

    public DashboardReportDtoBuilder setQuantity(int quantity) {
        this.quantity = quantity;
        return this;
    }
    public DashboardReportDtoBuilder setStatus(int status) {
        this.status = status;
        return this;
    }

    public DashboardReportDto build() {
        return new DashboardReportDto(this.quantity, this.status);
    }
}

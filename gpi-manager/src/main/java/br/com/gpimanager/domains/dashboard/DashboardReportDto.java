package br.com.gpimanager.domains.dashboard;

import java.io.Serializable;

public class DashboardReportDto implements Serializable {

    private static final long serialVersionUID = 607321184173085405L;

    private int quantity;
    private int status;

    public DashboardReportDto(int quantity, int status) {
        this.quantity = quantity;
        this.status = status;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getStatus() {
        return status;
    }

    public void setQuantity(int quantity){
        this.quantity += quantity;
    }
}

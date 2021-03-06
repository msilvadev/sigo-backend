package br.com.sigowebapi.bridge.standardmanager.dtos;

import java.io.Serializable;

public class StandardDashboardReportDto implements Serializable {

    private static final long serialVersionUID = 607321184173085405L;

    private int industrialQuantity;
    private int environmentalQuantity;
    private int defaultQuantity;

    public StandardDashboardReportDto(int industrialQuantity, int environmentalQuantity, int defaultQuantity) {
        this.industrialQuantity = industrialQuantity;
        this.environmentalQuantity = environmentalQuantity;
        this.defaultQuantity = defaultQuantity;
    }

    public StandardDashboardReportDto() {}

    public int getIndustrialQuantity() {
        return industrialQuantity;
    }

    public void setIndustrialQuantity(int industrialQuantity) {
        this.industrialQuantity += industrialQuantity;
    }

    public int getEnvironmentalQuantity() {
        return environmentalQuantity;
    }

    public void setEnvironmentalQuantity(int consultancyQuantity) {
        this.environmentalQuantity += consultancyQuantity;
    }

    public int getDefaultQuantity() {
        return defaultQuantity;
    }

    public void setDefaultQuantity(int defaultQuantity) {
        this.defaultQuantity += defaultQuantity;
    }

    @Override
    public String toString() {
        return "DashboardReportDto{" +
                "advisoryQuantity=" + industrialQuantity +
                ", consultancyQuantity=" + environmentalQuantity +
                ", defaultQuantity=" + defaultQuantity +
                '}';
    }
}

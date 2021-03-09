package br.com.sigowebapi.bridge.shared;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "sigo-ms-endpoints-uri")
public class SigoMicrosservicesEndpointsUri {

    private String gca;
    private String gpi;
    private String standard;

    public String getGca() {
        return gca;
    }

    public void setGca(String gca) {
        this.gca = gca;
    }

    public String getGpi() {
        return gpi;
    }

    public void setGpi(String gpi) {
        this.gpi = gpi;
    }

    public String getStandard() {
        return standard;
    }

    public void setStandard(String standard) {
        this.standard = standard;
    }
}

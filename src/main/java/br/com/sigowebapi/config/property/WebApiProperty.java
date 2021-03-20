package br.com.sigowebapi.config.property;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("webapi")
public class WebApiProperty {

    private String originAllowed = "*";

    private final Security security = new Security();

    public Security getSecurity() {
        return security;
    }

    public String getOriginAllowed() {
        return originAllowed;
    }

    public void setOriginAllowed(String originAllowed) {
        this.originAllowed = originAllowed;
    }

    public static class Security {

        private boolean enableHttps;

        public boolean isEnableHttps() {
            return enableHttps;
        }

        public void setEnableHttps(boolean enableHttps) {
            this.enableHttps = enableHttps;
        }
    }
}

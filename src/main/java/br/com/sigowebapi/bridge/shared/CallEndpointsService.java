package br.com.sigowebapi.bridge.shared;

import br.com.sigowebapi.bridge.gcamanager.dtos.AssistanceDto;
import br.com.sigowebapi.bridge.gpimanager.dtos.DashboardReportDto;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class CallEndpointsService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CallEndpointsService.class);

    private final RestTemplate restTemplate;

    public CallEndpointsService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public <T> T[] listAll(String uri, Class<T[]> responseType){
        return restTemplate.getForObject(uri, responseType);
    }

    public <T> T get(String uri, Class<T> responseType){
        return restTemplate.getForObject(uri, responseType);
    }

    public Map<Integer, DashboardReportDto> get(String uri){
        String json = restTemplate.getForObject(uri, String.class);

        Map<Integer, DashboardReportDto> map = new HashMap<>();

        try {
            ObjectMapper mapper = new ObjectMapper();
            map = mapper.readValue(json, new TypeReference<HashMap<Integer, DashboardReportDto>>(){});
        } catch (Exception e) {
            LOGGER.error("Mapper read value failed!");
        }

        return map;
    }

    public <T> T saveGeneric(String uri, T input, Class<T> clazz) {
        return (T) restTemplate.postForObject(uri, input, AssistanceDto.class);
    }

}

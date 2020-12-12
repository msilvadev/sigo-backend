package br.com.gpimanager.domain.process;

import java.util.HashMap;
import java.util.Map;

public enum ProcessStatus {
    INITIATED(1,"Iniciado"),
    PROCESSING(2,"Em processamento"),
    SUCCESS(3,"Finalizado com sucesso"),
    OVERDUE(4,"Processo em atraso"),
    FAILED(5,"Falha no processo");

    private static final Map<Integer, ProcessStatus> map = new HashMap<>();

    static {
        for(ProcessStatus status : values()){
            map.put(status.code, status);
        }
    }

    public int code;
    public String description;

    private ProcessStatus(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public static ProcessStatus valueOfCode(int code) {
        return map.get(code);
    }
}

package br.com.gpimanager.domains.process;

import java.util.HashMap;
import java.util.Map;

public enum ProcessType {
    DEFAULT(0, "Tipo de processo não mapeado"),
    NEW_ORDER(1, "Novo pedido"),
    DELIVERY_TISSUE(2, "Entrega de tecido");

    private static final Map<Integer, ProcessType> map = new HashMap<>();

    static {
        for (ProcessType type : values()) {
            map.put(type.code, type);
        }
    }

    private int code;
    private String description;

    private ProcessType(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public static ProcessType valueOfCode(int code) {
        return map.get(code);
    }

    public int getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }
}

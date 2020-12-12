package br.com.gpimanager.domain;

public enum ProcessStatus {
    INITIATED(0,"Iniciado"),
    PROCESSING(1,"Em processamento"),
    SUCCESS(2,"Finalizado com sucesso"),
    FAILED(3,"Falha no processo");

    ProcessStatus(int i, String s) {
    }
}

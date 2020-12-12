package br.com.gpimanager.domain;

import java.time.LocalDateTime;

public class IndustrialProcess {

    private long number;
    private ProcessType processType;
    private ProcessStatus processStatus;
    private String description;
    private LocalDateTime start;
    private LocalDateTime end;

    public IndustrialProcess(long number, ProcessType processType, ProcessStatus processStatus, String description) {
        this.number = number;
        this.processType = processType;
        this.processStatus = processStatus;
        this.description = description;
        this.start = LocalDateTime.now();
    }

    public long getNumber() {
        return number;
    }

    public ProcessType getProcessType() {
        return processType;
    }

    public ProcessStatus getProcessStatus() {
        return processStatus;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public LocalDateTime getEnd() {
        return end;
    }
}

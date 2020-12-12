package br.com.gpimanager.domain.process;

import java.time.LocalDateTime;

public class IndustrialProcessBuilder {

    private long number;
    private ProcessType processType;
    private ProcessStatus processStatus;
    private String description;
    private LocalDateTime start;

    public IndustrialProcessBuilder() {
        this.number = 0;
        this.processType = ProcessType.DEFAULT;
        this.processStatus = ProcessStatus.INITIATED;
        this.start = LocalDateTime.now();
    }

    public IndustrialProcessBuilder withNumber(int number) {
        this.number = number;
        return this;
    }

    public IndustrialProcessBuilder withProcessType(ProcessType processType) {
        this.processType = processType;
        return this;
    }

    public IndustrialProcessBuilder withProcessStatus(ProcessStatus processStatus) {
        this.processStatus = processStatus;
        return this;
    }

    public IndustrialProcessBuilder withDescription(String description) {
        this.description = description;
        return this;
    }

    public IndustrialProcessBuilder withStart(LocalDateTime start) {
        this.start = start;
        return this;
    }

    public IndustrialProcess build() {
        return new IndustrialProcess(
                this.number,
                this.processType,
                this.processStatus,
                this.description,
                this.start
        );
    }
}

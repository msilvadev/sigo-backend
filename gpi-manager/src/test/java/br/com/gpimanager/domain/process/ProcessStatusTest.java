package br.com.gpimanager.domain.process;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class ProcessStatusTest {

    @Test
    void valueOfCode() {
        assertThat(ProcessStatus.valueOfCode(1).description).isEqualTo(ProcessStatus.INITIATED.description);
        assertThat(ProcessStatus.valueOfCode(2).description).isEqualTo(ProcessStatus.PROCESSING.description);
        assertThat(ProcessStatus.valueOfCode(3).description).isEqualTo(ProcessStatus.SUCCESS.description);
        assertThat(ProcessStatus.valueOfCode(4).description).isEqualTo(ProcessStatus.OVERDUE.description);
        assertThat(ProcessStatus.valueOfCode(5).description).isEqualTo(ProcessStatus.FAILED.description);
    }

    @Test
    void values() {
        assertThat(ProcessStatus.values()).isNotNull();
    }

    @Test
    void valueOf() {
        assertThat(ProcessStatus.valueOf("INITIATED")).isEqualTo(ProcessStatus.INITIATED);
        assertThat(ProcessStatus.valueOf("PROCESSING")).isEqualTo(ProcessStatus.PROCESSING);
        assertThat(ProcessStatus.valueOf("SUCCESS")).isEqualTo(ProcessStatus.SUCCESS);
        assertThat(ProcessStatus.valueOf("OVERDUE")).isEqualTo(ProcessStatus.OVERDUE);
        assertThat(ProcessStatus.valueOf("FAILED")).isEqualTo(ProcessStatus.FAILED);
    }
}
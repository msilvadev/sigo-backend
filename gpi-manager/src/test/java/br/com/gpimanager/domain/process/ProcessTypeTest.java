package br.com.gpimanager.domain.process;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class ProcessTypeTest {

    @Test
    void valueOfCode() {
        assertThat(ProcessType.valueOfCode(0).description).isEqualTo(ProcessType.DEFAULT.description);
        assertThat(ProcessType.valueOfCode(1).description).isEqualTo(ProcessType.NEW_ORDER.description);
        assertThat(ProcessType.valueOfCode(2).description).isEqualTo(ProcessType.DELIVERY_TISSUE.description);
    }

    @Test
    void values() {
        assertThat(ProcessType.values()).isNotNull();
    }

    @Test
    void valueOf() {
        assertThat(ProcessType.valueOf("DEFAULT")).isEqualTo(ProcessType.DEFAULT);
        assertThat(ProcessType.valueOf("NEW_ORDER")).isEqualTo(ProcessType.NEW_ORDER);
        assertThat(ProcessType.valueOf("DELIVERY_TISSUE")).isEqualTo(ProcessType.DELIVERY_TISSUE);
    }
}
package br.com.gpimanager.domain;

public enum ProcessType {
    BUYING_TISSUE(0, "Compra de tecido"),
    NEW_PARTNER(1, "Novo Parceiro Cadastrado"),
    DELIVERY_TISSUE(2, "Entrega de tecido");

    ProcessType(int i, String s) {
    }
}

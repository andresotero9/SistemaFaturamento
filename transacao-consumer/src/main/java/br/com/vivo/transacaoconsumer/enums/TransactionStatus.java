package br.com.vivo.transacaoconsumer.enums;

public enum TransactionStatus {
    PENDING("transacao criada, aguardando processamento"),
    APPROVED("pagamento aprovado"),
    PAID("pagamento concluido com sucesso"),
    EXPIRED("transação expirou"),
    FAILED("falha no processamento"),
    DECLINED("pagamento recusado"),
    CANCELLED("transação cancelada"),
    REFUNDED("valor devolvido ao cliente"),
    PARTIALLY_REFUNDED("reembolso parcial"),
    CHARGEBACK("contestacao feita pelo cliente no banco");

    private String status;

    TransactionStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
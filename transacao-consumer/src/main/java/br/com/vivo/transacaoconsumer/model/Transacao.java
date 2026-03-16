package br.com.vivo.transacaoconsumer.model;

import br.com.vivo.transacaoconsumer.enums.TransactionStatus;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "transacao")
public class Transacao {

    @Id
    private String transacaoCod;
    private Double valor;
    private LocalDateTime dataTransacao;
    private LocalDateTime dataProducer;
    private LocalDateTime dataIntegracao;

    @Enumerated(EnumType.STRING)
    private TransactionStatus transactionStatus;

    /*
     * Getters
     */
    public LocalDateTime getDataProducer() {
        return dataProducer;
    }

    public LocalDateTime getDataTransacao() {
        return dataTransacao;
    }

    public Double getValor() {
        return valor;
    }

    public String getTransacaoCod() {
        return transacaoCod;
    }

    public LocalDateTime getDataIntegracao() {
        return dataIntegracao;
    }

    public TransactionStatus getTransactionStatus() {
        return transactionStatus;
    }

    /*
     * Setters
     */
    public void setTransacaoCod(String transacaoCod) {
        this.transacaoCod = transacaoCod;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public void setDataTransacao(LocalDateTime dataTransacao) {
        this.dataTransacao = dataTransacao;
    }

    public void setDataProducer(LocalDateTime dataProducer) {
        this.dataProducer = dataProducer;
    }

    public void setDataIntegracao(LocalDateTime dataIntegracao) {
        this.dataIntegracao = dataIntegracao;
    }

    public void setTransactionStatus(TransactionStatus transactionStatus) {
        this.transactionStatus = transactionStatus;
    }

    @Override
    public String toString() {
        return "Transacao{" +
                "transacaoCod='" + transacaoCod + '\'' +
                ", valor=" + valor +
                ", dataTransacao=" + dataTransacao +
                ", dataProducer=" + dataProducer +
                ", dataIntegracao=" + dataIntegracao +
                ", transactionStatus=" + transactionStatus +
                '}';
    }
}

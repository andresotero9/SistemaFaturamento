package br.com.vivo.databasesdk.dto;

import br.com.vivo.databasesdk.enums.TransactionStatus;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public record TransacaoDTO(String transacaoCod, Double valor,
                           @JsonFormat(shape = JsonFormat.Shape.STRING) LocalDateTime dataTransacao,
                           @JsonFormat(shape = JsonFormat.Shape.STRING) LocalDateTime dataProducer,
                           LocalDateTime dataIntegracao, TransactionStatus transactionStatus) {
}
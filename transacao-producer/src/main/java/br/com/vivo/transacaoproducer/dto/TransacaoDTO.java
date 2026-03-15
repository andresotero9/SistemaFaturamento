package br.com.vivo.transacaoproducer.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public record TransacaoDTO(String transacaoCod, Double valor,
                           @JsonFormat(shape = JsonFormat.Shape.STRING) LocalDateTime dataTransacao,
                           @JsonFormat(shape = JsonFormat.Shape.STRING) LocalDateTime dataProducer) {

}

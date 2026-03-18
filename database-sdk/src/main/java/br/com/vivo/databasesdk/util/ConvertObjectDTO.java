package br.com.vivo.databasesdk.util;

import br.com.vivo.databasesdk.dto.TransacaoDTO;
import br.com.vivo.databasesdk.enums.TransactionStatus;
import br.com.vivo.databasesdk.model.Transacao;

import java.time.LocalDateTime;
import java.util.Optional;

public final class ConvertObjectDTO {
    public static Transacao convertDtoToTransacao(TransacaoDTO dto) {
        Transacao transacao = new Transacao();
        transacao.setTransacaoCod(dto.transacaoCod());
        transacao.setValor(dto.valor());
        transacao.setDataTransacao(dto.dataTransacao());
        transacao.setDataProducer(dto.dataProducer());
        transacao.setDataIntegracao(dto.dataIntegracao());
        transacao.setTransactionStatus(Optional.ofNullable(dto.transactionStatus()).orElse(TransactionStatus.PENDING));

        return transacao;
    }
}

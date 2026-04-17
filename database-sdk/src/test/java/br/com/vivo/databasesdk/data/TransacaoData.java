package br.com.vivo.databasesdk.data;

import br.com.vivo.databasesdk.Util;
import br.com.vivo.databasesdk.enums.TransactionStatus;
import br.com.vivo.databasesdk.model.Transacao;
import java.time.LocalDateTime;
import java.util.Random;

public class TransacaoData {
    
    public static Transacao getTransacao(){
        Transacao transacao = getTransacaoSemID();
        transacao.setId(new Random().nextLong(999));
        return transacao;
    }
    
    public static Transacao getTransacaoSemID(){
        Transacao transacao = new Transacao();
        transacao.setTransacaoCod(Util.gerarCodigo());
        transacao.setValor(Util.gerarValor());
        transacao.setDataProducer(LocalDateTime.now());
        transacao.setDataTransacao(Util.gerarData());
        transacao.setDataIntegracao(LocalDateTime.now().plusSeconds(60));
        transacao.setTransactionStatus(TransactionStatus.PENDING);
        return transacao;
    }
    

}

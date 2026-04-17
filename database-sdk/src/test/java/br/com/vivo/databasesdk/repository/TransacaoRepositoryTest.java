package br.com.vivo.databasesdk.repository;

import br.com.sotero.databasecommon.repository.CrudRepositoryTest;
import br.com.vivo.databasesdk.Util;
import br.com.vivo.databasesdk.data.TransacaoData;
import br.com.vivo.databasesdk.enums.TransactionStatus;
import br.com.vivo.databasesdk.model.Transacao;

import java.time.LocalDateTime;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.test.context.ActiveProfiles;

@DataJpaTest
@ActiveProfiles("test")
public class TransacaoRepositoryTest extends CrudRepositoryTest<Transacao, Long> {

    private static final Logger log = LoggerFactory.getLogger(TransacaoRepositoryTest.class);

    @Autowired
    private TransacaoRepository repository;

    @Override
    protected CrudRepository<Transacao, Long> getRepository() {
        return this.repository;
    }

    @Override
    protected Transacao entityNoId() {
        return TransacaoData.getTransacao();
    }

    @Override
    public void alteracaoNaEntidadeParaUpdate(Transacao t) {
        t.setValor(Util.gerarValor());
        t.setDataProducer(LocalDateTime.now());
        t.setDataTransacao(Util.gerarData());
        t.setDataIntegracao(LocalDateTime.now().plusSeconds(60));
        t.setTransactionStatus(TransactionStatus.EXPIRED);
    }

    @Override
    public Transacao entity() {
        Transacao transacao = TransacaoData.getTransacaoSemID();
        transacao.setTransacaoCod("123456");

        return transacao;
    }

    @Override
    public Transacao entityOnlyInstanced() {
        return new Transacao();
    }

    @Override
    public List<Transacao> listEntity() {
        return List.of(
                TransacaoData.getTransacaoSemID(),
                TransacaoData.getTransacaoSemID(),
                TransacaoData.getTransacaoSemID()
        );
    }

    @Override
    public Long getIDNaoExiste() {
        return 999999L;
    }

    @Override
    public Long getIDZerado() {
        return 0L;
    }

    @Override
    public Logger getLog() {
        return log;
    }

}

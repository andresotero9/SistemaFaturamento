package br.com.vivo.databasesdk.service;

import br.com.vivo.databasesdk.model.Transacao;
import br.com.vivo.databasesdk.repository.TransacaoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransacaoService {

    private final TransacaoRepository transacaoRepository;

    public TransacaoService(TransacaoRepository transacaoRepository) {
        this.transacaoRepository = transacaoRepository;
    }

    public void save(Transacao transacao) {
        transacaoRepository.save(transacao);
    }

    public List<Transacao> findAll() {
        return transacaoRepository.findAll();
    }

    public Optional<Transacao> findById(Long id) {
        return transacaoRepository.findById(id);
    }

    public Optional<Transacao> findByTransacaoCod(String transacaoCod) {
        return transacaoRepository.findByTransacaoCod(transacaoCod);
    }
}

package br.com.vivo.databasesdk.repository;

import br.com.vivo.databasesdk.model.Transacao;
import org.springframework.data.repository.ListCrudRepository;

import java.util.Optional;

public interface TransacaoRepository extends ListCrudRepository<Transacao, Long> {
    public Optional<Transacao> findByTransacaoCod(String transacaoCod);
}

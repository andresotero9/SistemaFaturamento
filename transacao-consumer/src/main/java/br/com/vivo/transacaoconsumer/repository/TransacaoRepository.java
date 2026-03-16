package br.com.vivo.transacaoconsumer.repository;

import br.com.vivo.transacaoconsumer.model.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransacaoRepository extends JpaRepository<Transacao, String> {
}

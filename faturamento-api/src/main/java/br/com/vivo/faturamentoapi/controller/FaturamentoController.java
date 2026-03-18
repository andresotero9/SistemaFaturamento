package br.com.vivo.faturamentoapi.controller;

import br.com.vivo.databasesdk.model.Transacao;
import br.com.vivo.databasesdk.service.TransacaoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Optional;

@ComponentScan(basePackages = {
        "br.com.vivo.faturamentoapi",
        "br.com.vivo.transacaoconsumer",
        "br.com.vivo.databasesdk"
})
@RestController
public class FaturamentoController {

    private final TransacaoService transacaoService;

    public FaturamentoController(TransacaoService transacaoService) {
        this.transacaoService = transacaoService;
    }

    @GetMapping("/findById/{transacaoId}")
    public ResponseEntity<Optional<Transacao>> findById(@PathVariable Long transacaoId) {
        Optional<Transacao> transacao = this.transacaoService.findById(transacaoId);
        return ResponseEntity.ok(transacao);
    }

    @GetMapping("/findByTransacaoCod/{transacaoCod}")
    public ResponseEntity<Optional<Transacao>> findByTransacaoCod(@PathVariable String transacaoCod) {
        Optional<Transacao> transacao = this.transacaoService.findByTransacaoCod(transacaoCod);
        return ResponseEntity.ok(transacao);
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<Transacao>> findAll(){
        List<Transacao> transacaoes = this.transacaoService.findAll();
        return ResponseEntity.ok(transacaoes);
    }
}

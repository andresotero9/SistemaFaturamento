package br.com.vivo.transacaoproducer.util;

import br.com.vivo.transacaoproducer.dto.TransacaoDTO;

import java.time.LocalDateTime;
import java.util.Random;

public class TransacaoUtil {

    private static final Random random = new Random();

    public static TransacaoDTO gerarTransacaoFake() {

        //Codigo do tamanho de 6 caracteres numericos
        String codigo = gerarCodigo();

        //random entre 1.00 até 100.000
        double valor = 1 + (100000 - 1) * random.nextDouble();

        //data da producao no kafka
        LocalDateTime dataProducer = LocalDateTime.now();

        //data da trancasao
        LocalDateTime dataTransacao = dataRandomica();

        return new TransacaoDTO(
                codigo,
                valor,
                dataTransacao,
                dataProducer
        );
    }

    /**
     * Transforme o numero em String com 6 caracteres, preenchendo com zeros a esquerda
     * <p>
     * %06d significa:
     * % -> início do format
     * 0 -> preencher com zero a esquerda
     * 6 -> tamanho total
     * d -> número inteiro
     *
     * @return String:numeroFormatado
     */
    private static String gerarCodigo() {
        int numero = random.nextInt(1_000_000);
        return String.format("%06d", numero);
    }

    /**
     * Data randomica entre a data atual até 5 horas atras
     *
     * @return LocalDateTime: dataRandomica
     */
    private static LocalDateTime dataRandomica() {
        long segundosRandom = random.nextInt(5 * 60 * 60);
        return LocalDateTime.now().minusSeconds(segundosRandom);
    }
}

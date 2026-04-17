package br.com.vivo.databasesdk;

import java.time.LocalDateTime;
import java.util.Random;

public class Util {

    private static final Random RANDOM = new Random();

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
    public static String gerarCodigo() {
        int numero = RANDOM.nextInt(1_000_000);
        return String.format("%06d", numero);
    }

    /**
     * Data randomica entre a data atual até 5 horas atras
     *
     * @return LocalDateTime: dataRandomica
     */
    public static LocalDateTime gerarData() {
        long segundosRandom = RANDOM.nextInt(5 * 60 * 60);
        return LocalDateTime.now().minusSeconds(segundosRandom);
    }
    
    //random entre 1.00 até 100.000
    public static double gerarValor(){
        return 1 + (100000 - 1) * RANDOM.nextDouble();
    }
}

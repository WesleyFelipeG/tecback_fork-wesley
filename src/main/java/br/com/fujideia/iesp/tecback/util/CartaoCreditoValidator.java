package br.com.fujideia.iesp.tecback.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class CartaoCreditoValidator {

    // Valida o número do cartão de crédito usando o Algoritmo de Luhn
    public static boolean isNumeroCartaoValido(String numeroCartao) {
        if (numeroCartao == null || !numeroCartao.matches("\\d{16}")) {
            return false;
        }
        int sum = 0;
        boolean alternate = false;
        for (int i = numeroCartao.length() - 1; i >= 0; i--) {
            int n = Integer.parseInt(numeroCartao.substring(i, i + 1));
            if (alternate) {
                n *= 2;
                if (n > 9) {
                    n = (n % 10) + 1;
                }
            }
            sum += n;
            alternate = !alternate;
        }
        return (sum % 10 == 0);
    }

    // Valida o CVV (espera um valor de 3 dígitos)
    public static boolean isCvvValido(String cvv) {
        return cvv != null && cvv.matches("\\d{3}");
    }

    // Valida a data de validade do cartão no formato MM/aa
    public static boolean isValidadeValida(String validade) {
        if (validade == null || !validade.matches("(0[1-9]|1[0-2])/\\d{2}")) {
            return false;
        }
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/yy");
            LocalDate dataValidade = LocalDate.parse(validade, formatter).withDayOfMonth(1);
            return dataValidade.isAfter(LocalDate.now().withDayOfMonth(1).minusDays(1));
        } catch (DateTimeParseException e) {
            return false;
        }
    }
}
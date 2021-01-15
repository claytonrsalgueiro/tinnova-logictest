/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tinnova.tinnovalogictest;

import com.google.common.base.Preconditions;
import java.util.Arrays;
import java.util.Collections;

/**
 *
 * @author clayton.salgueiro
 */
public class Main {

    private static final String ARRAY_RESULT = "[0, 1, 2, 3, 4, 5, 6, 7]";

    public static void main(String args[]) {

        System.out.println("Resultado Questão 1 - Votos Válidos: " + votesPercentCalc(1000, 800, VoteTypeEnum.VALID) + "%");
        System.out.println("Resultado Questão 1 - Votos Brancos: " + votesPercentCalc(1000, 150, VoteTypeEnum.VALID)+ "%");
        System.out.println("Resultado Questão 1 - Votos Nulos: " + votesPercentCalc(1000, 50, VoteTypeEnum.VALID)+ "%");
        reorder();
        factorial(5);
        multiples(9);
    }

    private static Double votesPercentCalc(final Integer totalVoters, final Integer changeFactor, final VoteTypeEnum voteType) {
        preconditions(totalVoters, changeFactor, voteType);

        return new Double((changeFactor * 100) / totalVoters);
    }

    private static void preconditions(final Integer totalVoters, final Integer changeFactor, final VoteTypeEnum voteType) {
        Preconditions.checkNotNull(voteType, "Tipo de votos a serem calculados não pode ser nulo.");
        Preconditions.checkNotNull(totalVoters, "Total de Eleitores não pode ser nulo.");
        Preconditions.checkNotNull(changeFactor, "Total de votos ".concat(voteType.getName()).concat("não pode ser nulo."));
        if (totalVoters <= 0) {
            throw new NotAllowException("Total de eleitores não pode ser zero");
        }
        if (changeFactor < 0) {
            throw new NotAllowException("Total de votos ".concat(voteType.getName()).concat(" não pode ser menor do que zero."));
        }
        if (totalVoters < changeFactor) {
            throw new NotAllowException("Total de votos ".concat(voteType.getName()).concat("não pode ser maior que o total de eleitores."));
        }
    }

    public static void reorder() {
        final Integer[] v = {5, 3, 2, 4, 7, 1, 0, 6};
        boolean loop = true;
        while (loop) {
            for (int i = 0; i < v.length; i++) {
                if ((i + 1) < 8 && (v[i + 1] < v[i])) {
                    Collections.swap(Arrays.asList(v), i, i + 1);
                }
            }
            if (ARRAY_RESULT.equals(Arrays.toString(v))) {
                loop = false;
            }
        }

        System.out.println("Resultado do Questão 2: " + Arrays.toString(v));
    }

    public static void factorial(final Integer factor) {
        Integer result = 1;
        if (factor < 0) {
            throw new NotAllowException("Valor não pode ser menor do que zero.");
        }
        for (int i = 1; i < factor; i++) {
            result += result * (i + 1);
        }

        System.out.println("Resultado do fatorial Questão 3: " + result);
    }

    public static void multiples(final Integer numberA) {
        Integer resultadoFinal = 0;
        for (int i = numberA; i > 0; i--) {
            Integer resultado = (i % 3);
            Integer resultado2 = (i % 5);
            if (resultado == 0 || resultado2 == 0) {
                resultadoFinal += i;
            }
        }

        System.out.println("Resultado questão 4: Soma dos múltimos de " + numberA + " = " + resultadoFinal);
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tinnova.tinnovalogictest;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 *
 * @author clayton.salgueiro
 */
@Getter
@AllArgsConstructor
public enum VoteTypeEnum {
    VALID("Válidos"), WHITE("Brancos"), NULLS("Nulos");

    private final String name;
}

package br.dev.aquila.simplegatewayhttp.api.v1.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Produto {
    private String produtoId;
    private String nome;
}

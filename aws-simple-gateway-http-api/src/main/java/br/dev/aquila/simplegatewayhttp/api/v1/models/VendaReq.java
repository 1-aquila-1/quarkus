package br.dev.aquila.simplegatewayhttp.api.v1.models;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VendaReq {
    private List<Produto> produtos;
}

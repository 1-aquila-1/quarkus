package br.dev.aquila.simplegatewayhttp.api.v1.models;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VendaResp {
    private String vendaId;
    private List<Produto> produtos;
    private Date dataCriacao;    
}

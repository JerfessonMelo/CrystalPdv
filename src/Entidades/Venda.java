package Entidades;

import java.util.Date;

public class Venda extends Base {

    private Date dataVenda;
    private int valorTotal;
    private Cliente cliente;
    private Atendente atendente;
    private FormaPagamento formaPagamento;
    private StatusVenda statusVenda;
    
}

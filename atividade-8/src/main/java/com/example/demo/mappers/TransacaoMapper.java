package com.example.demo.mappers;

import com.example.demo.dtos.ClienteDto;
import com.example.demo.dtos.TransacaoDto;
import com.example.demo.models.Cliente;
import com.example.demo.models.Transacao;

public class TransacaoMapper {
    public static TransacaoDto toDto(Transacao transacao){
        return new TransacaoDto(
                transacao.getPagador(),
                transacao.getRecebedor(),
                transacao.getQuantidade()
        );
    }

    public static Transacao toEntity(TransacaoDto transacaoDto){
        return new Transacao(
                transacaoDto.recebedor(),
                transacaoDto.pagador(),
                transacaoDto.quantidade()
        );
    }
}

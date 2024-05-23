package com.example.demo.mappers;

import com.example.demo.dtos.ClienteDto;
import com.example.demo.models.Cliente;

public class ClienteMapper {
    public static ClienteDto toDto(Cliente cliente){
        return new ClienteDto(
                cliente.getNome(),
                cliente.getSaldo()
        );
    }

    public static Cliente toEntity(ClienteDto clienteDto){
        return new Cliente(
                clienteDto.nome(),
                clienteDto.saldo(),
                null
        );
    }
}

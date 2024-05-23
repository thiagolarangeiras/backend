package com.example.demo.services;

import com.example.demo.dtos.ClienteDto;
import com.example.demo.mappers.ClienteMapper;
import com.example.demo.models.Cliente;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ClienteService {
    private Map<Integer, Cliente> clienteMap = new HashMap<>();

    public ClienteService (){
        clienteMap.put(1, new Cliente("cliente1", 20d , "123456"));
        clienteMap.put(2, new Cliente("cliente2", 1000.50 , "123"));
        clienteMap.put(3, new Cliente("cliente2", 5000d , "456"));
    }

    public ClienteDto getByNome(String nome){
        List<Cliente> clientes = clienteMap.values().stream().map(cliente -> {
            if(cliente.getNome() == nome) return cliente;
            return null;
        }).toList();
        return ClienteMapper.toDto(clientes.getFirst());
    }
}

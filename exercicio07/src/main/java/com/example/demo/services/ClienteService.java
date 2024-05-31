package com.example.demo.services;

import com.example.demo.dtos.ClienteDto;
import com.example.demo.mappers.ClienteMapper;
import com.example.demo.models.Cliente;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ClienteService {
    private Map<String, Cliente> clienteMap = new HashMap<>();

    public ClienteService (){
        clienteMap.put("cliente1", new Cliente("cliente1", 20d , "123456"));
        clienteMap.put("cliente2", new Cliente("cliente2", 1000.50 , "123"));
        clienteMap.put("cliente3", new Cliente("cliente3", 5000d , "456"));
    }

    public ClienteDto getByNome(String nome){
        Cliente cliente;
        if ( (cliente = clienteMap.get(nome)) == null)
            return new ClienteDto("", 0d);
        return ClienteMapper.toDto(cliente);
    }
}

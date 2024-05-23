package com.example.demo.services;

import com.example.demo.dtos.TransacaoDto;
import com.example.demo.mappers.TransacaoMapper;
import com.example.demo.models.Cliente;
import com.example.demo.models.Transacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class TransacaoService {
    private Map<Integer, Transacao> transacaoMap = new HashMap<>();
    public void insert(TransacaoDto transacaoDto){
        transacaoMap.put(1, TransacaoMapper.toEntity(transacaoDto));
    }
}

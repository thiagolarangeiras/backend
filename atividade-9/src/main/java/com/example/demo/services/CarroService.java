package com.example.demo.services;

import com.example.demo.dtos.CarroGetDto;
import com.example.demo.dtos.CarroPostDto;
import com.example.demo.mappers.CarroMapper;
import com.example.demo.models.Carro;
import com.example.demo.repositories.CarroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.UUID;

@Service
public class CarroService {
    @Autowired
    CarroRepository carroRepository;
    @Autowired
    CarroMapper carroMapper;

    public List<CarroGetDto> getAll(Integer pagina, Integer qtde, List<String> sortBy, String nome) {
        Pageable pageConfig;
        if(sortBy != null){
            List<Sort.Order> orderByList = sortBy.stream().map((nomeAtributo) -> {
                return new Sort.Order(Sort.Direction.ASC, nomeAtributo);
            }).toList();
            pageConfig = PageRequest.of(pagina, qtde, Sort.by(orderByList));
        } else {
            pageConfig = PageRequest.of(pagina, qtde);
        }

        Page<Carro> listaAnimais;
        if(nome == null)
            listaAnimais = carroRepository.findAll(pageConfig);
        else
            listaAnimais = carroRepository.findByNomeContaining(nome, pageConfig);

        return listaAnimais.stream().map(CarroMapper::EntityToGet).toList();
    }

    public CarroGetDto get(UUID id) {
        Carro carro = carroRepository.findById(id).get();
        return CarroMapper.EntityToGet(carro);
    }

    public CarroGetDto post(CarroPostDto dto) {
        Carro carro = CarroMapper.PostToEntity(dto);
        Carro carroSalvo = carroRepository.save(carro);
        return carroMapper.EntityToGet(carroSalvo);
    }

    public CarroGetDto put(UUID id, CarroPostDto dto) {
        Carro carro = carroRepository.findById(id).get();
        CarroMapper.EntityUpdate(carro, dto);
        Carro carroUpdate = carroRepository.save(carro);
        return CarroMapper.EntityToGet(carroUpdate);
    }

    public CarroGetDto delete(UUID id) {
        Carro carro = carroRepository.findById(id).get();
        carroRepository.delete(carro);
        return CarroMapper.EntityToGet(carro);
    }
}
package com.example.demo.mappers;

import com.example.demo.dtos.CarroGetDto;
import com.example.demo.dtos.CarroPostDto;
import com.example.demo.models.Carro;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CarroMapper {
    public static Carro PostToEntity(CarroPostDto dto){
        return new Carro(
                UUID.randomUUID(), // Todo
                dto.nome(),
                dto.modelo(),
                dto.cor(),
                dto.ano(),
                dto.kilometragem(),
                dto.nomeDono()
        );
    }

    public static CarroGetDto EntityToGet(Carro entity){
        return new CarroGetDto(
                entity.getId(),
                entity.getNome(),
                entity.getModelo(),
                entity.getCor(),
                entity.getAno(),
                entity.getKilometragem()
        );
    }
    public static void EntityUpdate(Carro entity, CarroPostDto dto){
        entity.setNome(dto.nome());
        entity.setModelo(dto.modelo());
        entity.setCor(dto.cor());
        entity.setAno(dto.ano());
        entity.setKilometragem(dto.kilometragem());
        entity.setNomeDono(dto.nomeDono());
    }
}

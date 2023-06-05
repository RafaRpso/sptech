package sptech.school.atividade1notasprint3.mapper;

import sptech.school.atividade1notasprint3.dto.PerfilMotoristaDTO;
import sptech.school.atividade1notasprint3.model.Motorista;

public class MotoristaMapper {


    public PerfilMotoristaDTO toPerfilMotoristaDTO(Motorista motorista) {
        PerfilMotoristaDTO dto = new PerfilMotoristaDTO();
        dto.setNome(motorista.getNome());
        dto.setEmail(motorista.getEmail());

        return dto;
    }


}

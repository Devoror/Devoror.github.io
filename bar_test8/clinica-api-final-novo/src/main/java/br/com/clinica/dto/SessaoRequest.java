package br.com.clinica.dto;

import lombok.Data;

@Data
public class SessaoRequest {
    private Long pacienteId;
    private Long alunoId;
    private String tipo;
}

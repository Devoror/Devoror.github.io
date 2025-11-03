package br.com.clinica.dto;

import lombok.Data;
import java.util.Date;

@Data
public class PacienteRequest {
    private String nome;
    private String cpf;
    private Date dataNascimento;
    private String telefone;
    private String endereco;
}

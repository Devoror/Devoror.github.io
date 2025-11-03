package br.com.clinica.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import lombok.NoArgsConstructor;

@Entity
@DiscriminatorValue("ADMINISTRADOR")
@NoArgsConstructor
public class Administrador extends Usuario {

    public Administrador(String nome, String email, String senhaHash) {
        super(nome, email, senhaHash);
    }

    @Override
    public String getPapel() {
        return "Administrador (Supervisor)";
    }
}

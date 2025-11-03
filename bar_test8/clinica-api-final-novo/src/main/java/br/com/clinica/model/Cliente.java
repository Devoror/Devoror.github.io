package br.com.clinica.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import lombok.NoArgsConstructor;

@Entity
@DiscriminatorValue("CLIENTE")
@NoArgsConstructor
public class Cliente extends Usuario {

    public Cliente(String nome, String email, String senhaHash) {
        super(nome, email, senhaHash);
    }

    @Override
    public String getPapel() {
        return "Cliente (Estagiário)";
    }
}

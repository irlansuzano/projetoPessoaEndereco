package com.marcillino.irlan.reporitories;

import com.marcillino.irlan.entities.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Interface de repositório para o Objeto Endereco
 * @author Irlan
 */
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
}

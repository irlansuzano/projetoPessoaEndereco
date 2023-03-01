package com.marcillino.irlan.reporitories;

import com.marcillino.irlan.entities.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Interface de repositorio do objeto Pessoa extendendo Jpa
 * @author Irlan
 */
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
}

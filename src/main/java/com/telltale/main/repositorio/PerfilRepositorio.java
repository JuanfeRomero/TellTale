
package com.telltale.main.repositorio;

import com.telltale.main.entidad.Perfil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PerfilRepositorio extends JpaRepository<Perfil, Integer>  {
    
    
}

package com.telltale.main.repositorio;

import com.telltale.main.entidad.Perfil;
import com.telltale.main.entidad.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PerfilRepositorio extends JpaRepository<Perfil, Integer>  {
    
    
     @Modifying
    @Query("UPDATE Perfil p SET p.nombre = :nombre, p.apellido = :apellido, p.descripcion =:descripcion  WHERE p.id_perfil = :id_perfil")
    void modificarPerfil( @Param("id_perfil")Integer id_perfil, @Param("nombre") String nombre,@Param("apellido") String apellido,@Param("descripcion") String descripcion);
    
    @Query("select p from Perfil p where p.usuario = :usuario")
    Perfil buscarPerfilPorIdUsuario( @Param("usuario")Usuario usuario);
    }


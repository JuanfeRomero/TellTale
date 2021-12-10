package com.telltale.main.servicio;

import com.telltale.main.entidad.Historia;
import com.telltale.main.entidad.Perfil;
import com.telltale.main.entidad.Usuario;
import com.telltale.main.repositorio.PerfilRepositorio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PerfilServicio {

    @Autowired
    private PerfilRepositorio perfilRepositorio;

    @Transactional
    public void crearPerfil(String nombre, String apellido, String descripcion, Usuario usuario) throws Exception {
        validarNulo(nombre, apellido, descripcion);
        Perfil perfil = new Perfil();
        perfil.setNombre(nombre);
        perfil.setApellido(apellido);
        perfil.setUsuario(usuario);
        perfil.setDescripcion(descripcion);
        perfilRepositorio.save(perfil);
    }

    @Transactional(readOnly = true)
    public List<Perfil> verTodosPerfil() {
        return perfilRepositorio.findAll();
    }

    @Transactional(readOnly = true)
    public Perfil buscarPerfilPorId(Integer id_perfil) {
        Optional<Perfil> optionalPerfil = perfilRepositorio.findById(id_perfil);
        return optionalPerfil.orElse(null);
    }

    @Transactional
    public void modificarPerfil(Integer id_perfil, String nombre, String apellido, String descripcion)throws Exception {
        validarNulo(nombre,apellido,descripcion);
        perfilRepositorio.modificarPerfil(id_perfil, nombre, apellido, descripcion);

    }

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public void validarNulo(String nombre, String apellido, String descripcion) throws Exception {
        if (nombre.trim().isEmpty() || nombre == null) {
            throw new Exception("El nombre es obligatorio");
        }
        if (apellido.trim().isEmpty() || apellido == null) {
            throw new Exception("El apellido es obligatorio");
        }
        if (descripcion.trim().isEmpty() || descripcion == null) {
            throw new Exception("La descripcion es obligatoria");

        }
    }

    @Transactional
    public void eliminarPerfil(Integer id_perfil) {
        perfilRepositorio.deleteById(id_perfil);

    }

}

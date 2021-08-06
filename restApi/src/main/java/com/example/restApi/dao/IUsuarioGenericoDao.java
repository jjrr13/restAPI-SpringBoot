package com.example.restApi.dao;

import com.example.restApi.models.entity.UsuariosGenericos;
import org.springframework.data.repository.CrudRepository;

public interface IUsuarioGenericoDao extends CrudRepository<UsuariosGenericos, Long> {
    /*
        estos metodos ya vienen por debajo de la interfaz de CrudRepository
        public UsuarioGenerico findById(Long id);
        public List<UsuarioGenerico> listAll();
        public void save(UsuarioGenerico usuarioGenerico);
        public void delete(Long id);
    */

    public UsuariosGenericos findByUsername(String username);

}

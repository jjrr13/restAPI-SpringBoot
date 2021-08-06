package com.example.restApi.service;


import com.example.restApi.models.entity.UsuariosGenericos;

import java.util.List;

public interface IServiceUsuarioGenerico {

    public List<UsuariosGenericos> listAll();

    public UsuariosGenericos save(UsuariosGenericos usuariosGenericos);

    public UsuariosGenericos findById(Long id);

    public void delete(Long id);

}

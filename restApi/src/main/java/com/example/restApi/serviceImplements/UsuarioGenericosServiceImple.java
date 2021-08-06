package com.example.restApi.serviceImplements;

import com.example.restApi.dao.IUsuarioGenericoDao;
import com.example.restApi.models.entity.UsuariosGenericos;
import com.example.restApi.service.IServiceUsuarioGenerico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("serviceUsersGeneric")
public class UsuarioGenericosServiceImple implements IServiceUsuarioGenerico {

    @Autowired
    public IUsuarioGenericoDao iUsuarioGenericoDao;

    @Override
    @Transactional(readOnly = true) // vuelve el objeto una transaccion
    public List<UsuariosGenericos> listAll() {
        return (List<UsuariosGenericos>) iUsuarioGenericoDao.findAll();
    }


    @Override
    public UsuariosGenericos save(UsuariosGenericos usuariosGenericos) {
        return iUsuarioGenericoDao.save(usuariosGenericos);
    }

    @Override
    @Transactional(readOnly = true) // vuelve el objeto una transaccion
    public UsuariosGenericos findById(Long id) {
        return iUsuarioGenericoDao.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id) {
        iUsuarioGenericoDao.deleteById(id);
    }
}

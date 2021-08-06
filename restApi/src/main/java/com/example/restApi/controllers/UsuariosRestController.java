package com.example.restApi.controllers;


import com.example.restApi.errors.BadRequestException;
import com.example.restApi.errors.DontFindElementException;
import com.example.restApi.models.entity.UsuariosGenericos;
import com.example.restApi.service.IServiceUsuarioGenerico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/users")
public class UsuariosRestController {

    @Autowired
    public IServiceUsuarioGenerico iServiceUsuarioGenerico;


    @GetMapping(value = "/listar")
    public ResponseEntity<List<UsuariosGenericos>> findAll(){
        List<UsuariosGenericos> usuariosGenericos = iServiceUsuarioGenerico.listAll();
        if (usuariosGenericos.size() > 0){
            return ResponseEntity.ok( usuariosGenericos );
        }
        else{
            return ResponseEntity.noContent().build();
        }
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET) // /api/users/{id} -> /api/users/1
    public  ResponseEntity findById( @PathVariable("id") Long id){
        UsuariosGenericos usuariosGenericos = iServiceUsuarioGenerico.findById(id);
        if (id < 0 ){
            throw new BadRequestException("id: " + id);
        }

        if (usuariosGenericos == null){
            throw new DontFindElementException("id: " + id);
        }
        else{
            return ResponseEntity.ok(usuariosGenericos);
        }
   }

   @PostMapping
   public ResponseEntity<UsuariosGenericos> create( @RequestBody  UsuariosGenericos usuariosGenericos){
       UsuariosGenericos newUsuariosGenericos = iServiceUsuarioGenerico.save(usuariosGenericos);

       if (newUsuariosGenericos == null){
           throw new BadRequestException("usuariosGenericos: " + usuariosGenericos);
       }
       else{
           return ResponseEntity.ok(newUsuariosGenericos);
       }
   }

   @DeleteMapping(value = "{id}")
   public  ResponseEntity<UsuariosGenericos> deleteById( @PathVariable("id") Long id){
       UsuariosGenericos usuariosGenericos = iServiceUsuarioGenerico.findById(id);

       if (id < 0 ){
           throw new BadRequestException("id: " + id);
       }

       if (usuariosGenericos == null){
           throw new DontFindElementException("id: " + id);
       }
       else{
           iServiceUsuarioGenerico.delete(id);
           return ResponseEntity.ok(usuariosGenericos);
       }
   }

   @PutMapping
   public ResponseEntity<UsuariosGenericos> update( @RequestBody  UsuariosGenericos usuariosGenericos){
       UsuariosGenericos newUsuariosGenericos = iServiceUsuarioGenerico.findById(usuariosGenericos.getId());

       if (usuariosGenericos == null ){
           throw new BadRequestException("usuariosGenericos: " + usuariosGenericos);
       }

       if (newUsuariosGenericos == null){
           throw new DontFindElementException("id: " + usuariosGenericos.getId());
       }
       else{
           newUsuariosGenericos.setUsername( usuariosGenericos.getUsername() );
           newUsuariosGenericos.setPassword( usuariosGenericos.getPassword() );
           newUsuariosGenericos.setEnabled( usuariosGenericos.isEnabled() );
           iServiceUsuarioGenerico.save(newUsuariosGenericos);
           return ResponseEntity.ok(newUsuariosGenericos);
       }
   }

}

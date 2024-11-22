/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.controllers;


import com.example.demo.dto.Usuario;
import com.example.demo.services.UsuarioServicelmpl;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/usuario")
@RestController
public class UsuarioController {

    @Autowired
    public UsuarioServicelmpl usuarioServicelmpl;

    @GetMapping("/all")
    public List<Usuario> getAllUsuarios() {
        return usuarioServicelmpl.GetAllUsuarios();
    }

    @GetMapping("/{id}")
    public Usuario getUsuarioById(@PathVariable(name = "id") Long id) {
        Optional<Usuario> usuario = usuarioServicelmpl.getUsuarioById(id);
        if (usuario.isPresent()) {
            return usuario.get();
        } else {
            throw new NoSuchElementException();
        }
    }

    @PostMapping("/create")
    public Optional<Usuario> createUsuario(@RequestBody Usuario usuario) {
        Optional<Usuario> newUsuario = usuarioServicelmpl.CreateUsuario(usuario);
        if (newUsuario.isPresent()) {
            return newUsuario;
        } else {
            throw new NoSuchElementException();
        }
    }

    @PutMapping("/update/{id}")
    public Usuario updateUsuario(@PathVariable(name = "id") Long id, @RequestBody Usuario usuario) {
        Usuario updateUsuario = usuarioServicelmpl.updateUsuario(id, usuario);
        return updateUsuario;
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUsuario(@PathVariable(name = "id") Long id) {
        usuarioServicelmpl.deleteUserById(id);
    }
}

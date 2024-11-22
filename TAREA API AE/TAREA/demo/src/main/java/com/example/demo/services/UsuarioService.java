/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.demo.services;

import java.util.List;
import com.example.demo.dto.Usuario;
import java.util.Optional;

public interface UsuarioService {

    List<Usuario> GetAllUsuarios();
    
    Optional<Usuario> getUsuarioById(Long id);

    Optional<Usuario> CreateUsuario(Usuario usuario);

    Usuario updateUsuario(Long id, Usuario usuario);
    
    void deleteUserById(Long id);
    
}

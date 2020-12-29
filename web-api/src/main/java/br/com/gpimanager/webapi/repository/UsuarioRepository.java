package br.com.gpimanager.webapi.repository;

import br.com.gpimanager.webapi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<User, Long> {

    public Optional<User> findByEmail(String email);

    public List<User> findByPermissionsDescription(String permissionDescription);

}

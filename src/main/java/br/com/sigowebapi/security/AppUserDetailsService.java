package br.com.sigowebapi.security;

import br.com.sigowebapi.model.User;
import br.com.sigowebapi.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class AppUserDetailsService implements UserDetailsService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> usuarioOptional = usuarioRepository.findByEmail(email);
        User user = usuarioOptional.orElseThrow(() -> new UsernameNotFoundException("User and/or password incorrect"));
        return new SystemUser(user, getPermissoes(user));
    }

    private Collection<? extends GrantedAuthority> getPermissoes(User user) {
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        user.getPermissions().forEach(p -> authorities.add(new SimpleGrantedAuthority(p.getDescription().toUpperCase())));
        return authorities;
    }
}
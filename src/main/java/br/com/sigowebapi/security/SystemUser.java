package br.com.sigowebapi.security;

import br.com.sigowebapi.model.User;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class SystemUser extends org.springframework.security.core.userdetails.User {

    private static final long serialVersionUID = 1L;

    private User user;

    public SystemUser(User user, Collection<? extends GrantedAuthority> authorities) {
        super(user.getEmail(), user.getPassword(), authorities);
        this.user = user;
    }

    public User getUsuario() {
        return user;
    }

}

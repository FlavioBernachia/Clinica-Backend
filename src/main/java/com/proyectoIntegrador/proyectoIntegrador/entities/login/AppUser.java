package com.proyectoIntegrador.proyectoIntegrador.entities.login;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;

@Entity
public class AppUser implements UserDetails {
    @Id
    @SequenceGenerator( name = "appUserSequence", sequenceName = "appUserSequence", allocationSize = 1 )
    @GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "appUserSequence" )
    private Integer id;
    private String nombre;
    private String apellido;
    private String email;
    private String userName;
    private String password;
    @Enumerated(EnumType.STRING)
    private AppUserRoles appUserRoles;

    public AppUser() {
    }

    public AppUser(String nombre, String apellido, String email, String userName, String password, AppUserRoles appUserRoles) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.userName = userName;
        this.password = password;
        this.appUserRoles = appUserRoles;
    }


    public Integer getId() {
        return id;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(appUserRoles.name());
        return Collections.singletonList(authority);}


    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return null;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public AppUserRoles getAppUserRoles() {
        return appUserRoles;
    }

    public void setAppUserRoles(AppUserRoles appUserRoles) {
        this.appUserRoles = appUserRoles;
    }
}

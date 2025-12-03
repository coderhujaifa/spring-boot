package com.huzaifa.aichat.entity;

import jakarta.persistence.*;
import java.util.Set;
import java.util.HashSet;

@Entity
@Table(name="users")
public class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable=false)
    private String password; // bcrypt hash

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name="user_roles", joinColumns = @JoinColumn(name="user_id"))
    @Column(name="role")
    private Set<String> roles = new HashSet<>();

    public User(){ }

    public User(String username, String password, Set<String> roles){
        this.username = username;
        this.password = password;
        this.roles = roles;
    }

    // getters/setters
    public Long getId(){ return id; }
    public String getUsername(){ return username; }
    public void setUsername(String u){ this.username = u; }

    public String getPassword(){ return password; }
    public void setPassword(String p){ this.password = p; }

    public Set<String> getRoles(){ return roles; }
    public void setRoles(Set<String> roles){ this.roles = roles; }
}

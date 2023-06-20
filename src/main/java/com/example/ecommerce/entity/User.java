package com.example.ecommerce.entity;

import com.example.ecommerce.utils.AuthorityEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;
import org.hibernate.annotations.NotFound;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {
    @Id
    @Column(name = "username", updatable = false, nullable = false)
    private String username;


    @NotNull
    @Column(name = "password", nullable = false)
    private String password;


    @NotNull
    @Column(name = "is_enabled", nullable = false)
    private boolean isEnabled;


    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "authority", nullable = false)
    private AuthorityEnum authority;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "profile_ref", referencedColumnName = "id")
    private UserProfile profileRef;

    @PrePersist
    private void init() {
        this.isEnabled = true;
    }


}

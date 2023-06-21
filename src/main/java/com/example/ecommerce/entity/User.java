package com.example.ecommerce.entity;

import com.example.ecommerce.utils.Authority;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@DynamicInsert
@DynamicUpdate
@Entity
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
    private Boolean isEnabled;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "authority", nullable = false)
    private Authority authority;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "profile_ref", referencedColumnName = "id")
    private UserProfile profileRef;

    @PrePersist
    private void init() {
        this.isEnabled = true;
    }
}

package com.example.ecommerce.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "user_profiles")
public class UserProfile {
    @Id
    @Column(name = "id", nullable = false, updatable = false)
    private long userId;

    @NotNull
    @Column(name = "firstname", nullable = false)
    private String firstName;

    @NotNull
    @Column(name = "lastname", nullable = false)
    private String lastName;


    @Column(name = "email")
    private String email;


    @NotNull
    @Column(name = "phone", nullable = false)
    private String phone;


    @NotNull
    @Column(name = "isd_code", nullable = false)
    private String isdCode;


    @NotNull
    @Column(name = "address", nullable = false)
    private String address;
}

package com.spartanHardware.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import java.util.List;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "authority")
public class Authority implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @ManyToMany (fetch = FetchType.LAZY, mappedBy = "authorities")
    @JsonIgnoreProperties("authorities")
    private List<User> users;

    @Override
    public String getAuthority() {
        return name;
    }
}

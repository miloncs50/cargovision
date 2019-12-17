package org.fusion.application.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;

@Entity
@Table(name = "roles")
@Data
public class Roles {
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Column(name = "name", nullable = false, length = 45)
    private String name;
    @Column(name = "update_at", nullable = true)
    private Timestamp updateAt;

    @ManyToMany
    @Transient
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Set<Users> users;
}

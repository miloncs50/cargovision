package org.fusion.application.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "customer")
@Data
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false, length = 45)
    private String name;

    @Column(name = "address", nullable = false, length = 100)
    private String address;

    @Column(name = "phone", nullable = true, length = 13)
    private String phone;

    @Column(name = "email", nullable = true, length = 45)
    private String email;

    @Column(name = "active", nullable = true)
    private Byte active;

    @Column(name = "created_by", nullable = true)
    @CreationTimestamp
    private Timestamp createdBy;

    @Column(name = "update_at", nullable = true)
    @UpdateTimestamp
    private Timestamp updateAt;

    @Transient
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Collection<Vehicale> vehicale;
}

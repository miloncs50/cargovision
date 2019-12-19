package org.fusion.application.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;

@Entity
@Table(name = "vehicale")
@Data
public class Vehicale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "name", nullable = false, length = 45)
    private String name;

    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id", nullable = false)
    private Customer customer;

    @Column(name = "active", nullable = true)
    private Byte active;

    @CreationTimestamp
    @Column(name = "created_at", nullable = true)
    private Timestamp createdAt;

    @UpdateTimestamp
    @Column(name = "update_at", nullable = true)
    private Timestamp updateAt;

    @Transient
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Set<Imports> imports;
}

package org.fusion.application.model;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;

@Entity
@Table(name = "users")
@Data
public class Users {

    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Column(name = "name", nullable = false, length = 45)
    private String name;
    @Column(name = "email", nullable = false, length = 45)
    private String email;
    @Column(name = "password", nullable = false, length = 45)
    private String password;
    @Column(name = "phone", nullable = false, length = 11)
    private String phone;
    @Column(name = "active", nullable = true)
    private Byte active;

    @Column(name = "created_at", nullable = true)
    @CreationTimestamp
    private Timestamp createdAt;

    @Column(name = "update_at", nullable = true)
    @UpdateTimestamp
    private Timestamp updateAt;

    @ManyToMany
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Roles> roles;

//    @OneToMany(mappedBy = "usersByEntryBy")
//    private Collection<Export> exportsById;
//
//    @OneToMany(mappedBy = "usersByAuthBy")
//    private Collection<Export> exportsById_0;
//
//    @OneToMany(mappedBy = "usersByEntryBy")
//    private Collection<ExportDemurrage> exportDemurragesById;
//
//    @OneToMany(mappedBy = "usersByAuthBy")
//    private Collection<ExportDemurrage> exportDemurragesById_0;
//
//    @OneToMany(mappedBy = "EntryBy")
//    private Collection<Import> importsById;
//
//    @OneToMany(mappedBy = "AuthBy")
//    private Collection<Import> importsById_0;
//
//    @OneToMany(mappedBy = "usersByEntryBy")
//    private Collection<ImportDemurrage> importDemurragesById;
//
//    @OneToMany(mappedBy = "usersByAuthBy")
//    private Collection<ImportDemurrage> importDemurragesById_0;
//
//    @OneToMany(mappedBy = "usersByUserId")
//    private Collection<UserRole> userRolesById;
}

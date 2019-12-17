package org.fusion.application.model;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Table(name = "import")
public @Data
class Imports {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "date", nullable = false)
    private Date date;

    @ManyToOne
    @JoinColumn(name = "vehicale_id", referencedColumnName = "id", nullable = false)
    private Vehicale vehicale;

    @Column(name = "transport", nullable = true, length = 45)
    private String transport;

    @Column(name = "weight", nullable = true, length = 10)
    private String weight;

    @Column(name = "fare", nullable = true, precision = 0)
    private Double fare;

    @Column(name = "note", nullable = true, length = 45)
    private String note;

    @CreationTimestamp
    @Column(name = "created_by", nullable = true)
    private Timestamp createdAt;

    @UpdateTimestamp
    @Column(name = "update_at", nullable = true)
    private Timestamp updateAt;


    @ManyToOne
    @JoinColumn(name = "entry_by", referencedColumnName = "id", nullable = true)
    private Users EntryBy;

    @ManyToOne
    @JoinColumn(name = "auth_by", referencedColumnName = "id", nullable = true)
    private Users AuthBy;

}

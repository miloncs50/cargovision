package org.fusion.application.repository;

import org.fusion.application.dao.ImportDAO;
import org.fusion.application.model.Imports;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ImportRepository extends JpaRepository<Imports, Integer> {


    //@Query("SELECT i.id as id, i.date as date, i.vehicale.name as vehicale, i.transport as transport, i.fare as fare, i.note as note, i.EntryBy as entryby, i.AuthBy as authby, i.createdAt as created, i.updateAt as updateat FROM Imports AS i")
    @Query("SELECT i.id as id, i.date as date, i.vehicale.name as vehicale, i.transport as transport, i.fare as fare, i.note as note, i.EntryBy as entryby, i.AuthBy as authby, i.createdAt as created, i.updateAt as updateat FROM Imports AS i")
    public List<ImportDAO> listAllImports();
}

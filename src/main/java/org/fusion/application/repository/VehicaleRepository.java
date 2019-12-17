package org.fusion.application.repository;

import org.fusion.application.dao.VehicaleInterface;
import org.fusion.application.model.Vehicale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VehicaleRepository extends JpaRepository<Vehicale, Integer> {

    @Query("SELECT i.id as id, i.name as name, i.customer.name as customer, i.active as active FROM Vehicale AS i")
    public List<VehicaleInterface> getVehivaleAll();

    @Query("SELECT i.id as id, i.name as name FROM Vehicale AS i where i.active=1")
    public List<VehicaleInterface> getVehivaleOnly();
}

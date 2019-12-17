package org.fusion.application.repository;

import org.fusion.application.dao.CustomerDAO;
import org.fusion.application.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    @Query("SELECT c.id as id, c.name AS name, c.address AS address, c.phone AS phone, c.email AS email, c.active AS active, c.createdBy AS created FROM Customer AS c")
    public List<CustomerDAO> getAllCustomer();

    @Query("SELECT c.id as id, c.name AS name FROM Customer AS c where c.active=1")
    public List<CustomerDAO> getCustomerList();
}

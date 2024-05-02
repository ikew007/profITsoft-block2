package com.profIITsoft.block2.repository;

import com.profIITsoft.block2.entity.Service;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

/**
 * Service repository class to manage service data in a database
 */
public interface ServiceRepository extends JpaRepository<Service, Long> {

    /**
     * Find services by names in a set
     *
     * @param services set of service names
     * @return set of services
     */
    Set<Service> findByNameIn(Set<String> services);
}
package com.exemplodev.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.exemplodev.models.Cabrom;

@RepositoryRestResource(path="/cabrom")
public interface RepositoryCabrom extends JpaRepository<Cabrom, Long> {

}

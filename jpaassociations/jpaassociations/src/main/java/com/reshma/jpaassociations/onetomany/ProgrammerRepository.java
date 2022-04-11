package com.reshma.jpaassociations.onetomany;

import org.springframework.data.repository.CrudRepository;

import com.reshma.jpaassociations.manytomany.Programmer;

public interface ProgrammerRepository extends CrudRepository<Programmer, Integer> {

}

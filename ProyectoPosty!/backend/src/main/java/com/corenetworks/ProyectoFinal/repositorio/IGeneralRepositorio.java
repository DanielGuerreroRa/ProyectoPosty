package com.corenetworks.ProyectoFinal.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface IGeneralRepositorio <T,ID> extends JpaRepository <T,ID> {
}

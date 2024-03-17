package com.corenetworks.ProyectoFinal.servicio.Impl;

import com.corenetworks.ProyectoFinal.repositorio.IGeneralRepositorio;
import com.corenetworks.ProyectoFinal.servicio.ICRUD;

import java.util.List;

public abstract class ICRUDimpl <T,ID> implements ICRUD<T,ID> {
    protected abstract IGeneralRepositorio<T,ID> getRepo();
    @Override
    public T buscarPorId(ID id) throws Exception{
        return getRepo().findById(id).orElse(null);
    }

    @Override
    public List<T> buscarTodos() throws Exception{
        return getRepo().findAll();
    }

    @Override
    public T crear(T t) throws Exception {
        return getRepo().save(t);
    }

    @Override
    public T editar(T t) throws Exception {
        return getRepo().save(t);
    }

    @Override
    public void eliminar(T t) throws Exception {
        getRepo().delete(t);
    }


}

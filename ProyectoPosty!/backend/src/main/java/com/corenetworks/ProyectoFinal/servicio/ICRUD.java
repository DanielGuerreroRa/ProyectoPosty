package com.corenetworks.ProyectoFinal.servicio;

import java.util.List;

public interface ICRUD <T,ID> {
    T buscarPorId(ID id) throws Exception;
    List<T> buscarTodos() throws Exception;
    T crear (T t) throws Exception;
    T editar (T t) throws Exception;
    void eliminar(T t) throws Exception;
}

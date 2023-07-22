package org.example.common;

import java.util.List;

public interface Service<ENTITY, ID> {
    ENTITY findById(ID id);

    List<ENTITY> getAll();

    void remove(ID id);

    ENTITY add(ENTITY entity);
}

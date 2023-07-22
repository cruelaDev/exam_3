package org.example.common;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface Repository<ID, ENTITY extends BaseEntity<ID>> {
    ENTITY findById(ID id);

    List<ENTITY> getAll();

    void delete(ID id);

    ENTITY add(ENTITY entity);
}

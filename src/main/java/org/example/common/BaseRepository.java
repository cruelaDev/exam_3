package org.example.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BaseRepository<ID, ENTITY extends BaseEntity<ID>> implements Repository<ID, ENTITY> {
    protected final Map<ID, ENTITY> entities = new HashMap<>();

    @Override
    public ENTITY findById(ID id) {
        return entities.get(id);
    }

    @Override
    public List<ENTITY> getAll() {
        return new ArrayList<>(entities.values());
    }

    @Override
    public void delete(ID id) {
        entities.remove(id);
    }

    @Override
    public ENTITY add(ENTITY entity) {
        entities.put(entity.getId(),entity);
        return entity;
    }
}

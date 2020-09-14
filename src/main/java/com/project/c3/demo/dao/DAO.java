package com.project.c3.demo.dao;

import com.project.c3.demo.entity.IDInterface;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DAO<T extends IDInterface> {
    Map<Integer, T> maps;
    int id;

    public DAO() {
        maps = new HashMap<>();
        id = 1;

    }

    public T save(T obj) {
        if (obj.getId() == 0) {
            obj.setId(id);
            id++;
        }
        maps.put(obj.getId(), obj);
        return obj;
    }

    public List<T> find() {
        return new ArrayList<>(maps.values());

    }

    public T findById(int id) {
        if (maps.containsKey(id)) {
            return maps.get(id);
        }
        return null;

    }
}



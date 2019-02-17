package com.majid.availablehotels.datastore;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class DataStoreImpl<T, R> implements DataStore<T, R> {

    private Map<R, T> map;

    public DataStoreImpl() {
        this.map = new HashMap<>();
    }

    public DataStoreImpl(Map<R, T> map) {
        this.map = map;
    }

    @Override
    public List<T> findAll() {
        return new LinkedList<>(map.values());
    }

    @Override
    public List<T> find(Predicate<? super T> predicate) {
        return map.values().stream().filter(predicate).collect(Collectors.toList());
    }

    @Override
    public T find(R id) {
        return map.get(id);
    }

    @Override
    public T update(R id, T t) {
        if (map.containsKey(id)) {
            map.put(id, t);
            return t;
        }
        return null;
    }

    @Override
    public T delete(R id) {
        return map.remove(id);
    }

    @Override
    public T create(R id, T t) {
        if (map.containsKey(id))
            throw new IllegalArgumentException("Alredy exists");
        map.put(id, t);
        return t;
    }
}

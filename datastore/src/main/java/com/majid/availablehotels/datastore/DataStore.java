package com.majid.availablehotels.datastore;

import java.util.List;
import java.util.function.Predicate;

public interface DataStore<T, R> {

    List<T> findAll();

    List<T> find(Predicate<? super T> predicate);

    T find(R id);

    T update(R id, T t);

    T delete(R id);

    T create(R id, T t);
}

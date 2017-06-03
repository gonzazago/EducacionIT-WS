package com.eduit.ws.repository;

import com.eduit.ws.model.Libro;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class LibroMemoryRepository {

    private static  Map<Long,Libro> base = new HashMap<>();

    public LibroMemoryRepository() {
      base.put(1L,new Libro(1l,"sss","xxx",true));
      base.put(2L,new Libro(2l,"sss","xxx",true));
    }

    public Libro insert(Libro libro){
        base.put(libro.getId(),libro);
        return libro;
    }

    public Libro update(Libro libro){
        base.put(libro.getId(),libro);
        return libro;
    }

    public void delete (Long id){
        base.remove(id);
    }

    public Libro getById(Long id){
        return base.get(id);
    }

    public List<Libro> getAll(){
        return base.values().stream().collect(Collectors.toList());
    }

    public boolean exists(Libro libro){
        return exists(libro.getId());
    }

    public boolean exists(Long id) {
        return base.containsKey(id);
    }
}

package com.eduit.ws.cache;


import com.eduit.ws.model.Usuario;

import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class UserCache {


    private static Map<String,Usuario> cache = new ConcurrentHashMap<>();

    public String add(Usuario usuario){
        String hash = UUID.randomUUID().toString();
        cache.put(hash,usuario);
        return hash;
    }

    public boolean isLogged(String hash){
        return cache.containsKey(hash);
    }

    public Optional<Usuario> getUsuario(String hash){
        return Optional.ofNullable(cache.get(hash));
    }

}

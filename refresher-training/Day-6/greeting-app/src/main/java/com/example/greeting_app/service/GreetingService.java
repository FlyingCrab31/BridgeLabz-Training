package com.example.greeting_app.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import com.example.greeting_app.model.Greeting;

@Service
public class GreetingService {

    private final ConcurrentMap<Long, Greeting> greetings = new ConcurrentHashMap<>();
    private final AtomicLong sequence = new AtomicLong(0);

    public List<Greeting> findAll() {
        List<Greeting> results = new ArrayList<>(greetings.values());
        results.sort(Comparator.comparingLong(Greeting::getId));
        return results;
    }

    public List<Greeting> getAllGreetings() {
        return findAll();
    }

    public Optional<Greeting> findById(long id) {
        return Optional.ofNullable(greetings.get(id));
    }

    public Optional<Greeting> getGreetingById(long id) {
        return findById(id);
    }

    public Greeting create(String name, String message) {
        long id = sequence.incrementAndGet();
        Greeting greeting = new Greeting(id, normalizeName(name), normalizeMessage(message));
        greetings.put(id, greeting);
        return greeting;
    }

    public Greeting createGreeting(String name, String message) {
        return create(name, message);
    }

    public Optional<Greeting> update(long id, String name, String message) {
        Greeting existing = greetings.get(id);
        if (existing == null) {
            return Optional.empty();
        }

        existing.setName( normalizeName(name));
        existing.setMessage(normalizeMessage(message));
        greetings.put(id, existing);
        return Optional.of(existing);
    }

    public Optional<Greeting> updateGreeting(long id, String name, String message) {
        return update(id, name, message);
    }

    public boolean delete(long id) {

        return greetings.remove(id) != null;
    }

    public boolean deleteGreeting(long id) {
        return delete(id);
    }

    private String normalizeName(String name) {
        if (name == null || name.isBlank()) {
            return "Guest" ;
        }
        return name.trim();
    }

    private String normalizeMessage(String message) {
        if (message == null || message.isBlank()) {
            return "Hello";
        }
        return message.trim() ;
    }
}

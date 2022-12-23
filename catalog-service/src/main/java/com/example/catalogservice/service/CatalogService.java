package com.example.catalogservice.service;

import com.example.catalogservice.jpa.CatalogEntity;
import com.example.catalogservice.jpa.CatalogRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class CatalogService {

    private final CatalogRepository catalogRepository;

    public Iterable<CatalogEntity> getAllCatalogs() {
        return this.catalogRepository.findAll();
    }

}

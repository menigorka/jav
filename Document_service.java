package com.example.documentmanagement.service;

import com.example.documentmanagement.model.Document;
import com.example.documentmanagement.repository.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocumentService {
    @Autowired
    private DocumentRepository documentRepository;

    public void saveDocument(Document document) {
        documentRepository.save(document);
    }

    public List<Document> getAllDocuments() {
        return documentRepository.findAll();
    }

    public List<Document> findDocumentsByType(String type) {
        return documentRepository.findAll().stream()
                .filter(doc -> doc.getType().equalsIgnoreCase(type))
                .toList();
    }
}

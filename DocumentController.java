package com.example.documentmanagement.controller;

import com.example.documentmanagement.model.Document;
import com.example.documentmanagement.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class DocumentController {
    @Autowired
    private DocumentService documentService;

    @GetMapping("/")
    public String viewHomePage(Model model) {
        List<Document> listDocuments = documentService.getAllDocuments();
        model.addAttribute("listDocuments", listDocuments);
        return "index";
    }

    @GetMapping("/new")
    public String showNewDocumentForm(Model model) {
        Document document = new Document(); // заменить на конкретный тип документа
        model.addAttribute("document", document);
        return "new_document";
    }

    @PostMapping("/save")
    public String saveDocument(Document document) {
        documentService.saveDocument(document);
        return "redirect:/";
    }

    @GetMapping("/search")
    public String searchDocuments(@RequestParam("type") String type, Model model) {
        List<Document> listDocuments = documentService.findDocumentsByType(type);
        model.addAttribute("listDocuments", listDocuments);
        return "index";
    }
}

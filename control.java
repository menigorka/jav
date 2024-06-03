import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.SQLException;
import java.util.List;

@Controller
public class DocumentController {
    @Autowired
    private DocumentService documentService;

    @GetMapping("/")
    public String viewHomePage(Model model) throws SQLException {
        List<Document> listDocuments = documentService.getAllDocuments();
        model.addAttribute("listDocuments", listDocuments);
        return "index";
    }

    @GetMapping("/new")
    public String showNewDocumentForm(Model model) {
        Document document = new Invoice("", "", "", LocalDate.now());
        model.addAttribute("document", document);
        return "new_document";
    }

    @PostMapping("/save")
    public String saveDocument(Document document) throws SQLException {
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

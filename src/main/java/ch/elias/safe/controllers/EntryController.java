package ch.elias.safe.controllers;

import ch.elias.safe.domain.entities.Entry;
import ch.elias.safe.services.EntryService;
import ch.elias.safe.services.RSAService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
public class EntryController {

    @Autowired
    private final EntryService entryService;
    RSAService rsaService;

    public EntryController(EntryService entryService, RSAService encryptDecryptService) {
        this.entryService = entryService;
        this.rsaService = encryptDecryptService;
    }

    // / GET
    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String getAllEntries(Model model) {
        List<Entry> entries = entryService.getAllEntries();
        model.addAttribute("entries", entries);
        model.addAttribute("entry", new Entry());
        return "entries";
    }

    // / POST
    @RequestMapping(path = "/", method = RequestMethod.POST)
    public RedirectView createEntry(RedirectAttributes redirectAttributes, @ModelAttribute Entry entry) {

        entry.setPassword(rsaService.encrypt(entry.getPassword()));

        // Create Entry
        entryService.createEntry(entry);


        // Flash-Message and Redirect
        String message = "Successfully created password entry for" + " <b>" + entry.getWebsite() + " </b> ✨.";
        RedirectView redirectView = new RedirectView("/", true);
        redirectAttributes.addFlashAttribute("entryMessage", message);
        return redirectView;
    }

    // /{id}
    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public String getEntry(Model model, @PathVariable("id") Integer id) {
        Entry entry = entryService.getEntry(id);
        model.addAttribute("entry", entry);
        return "edit";
    }

    // /{id}
    @RequestMapping(path = "/{id}", method = RequestMethod.POST)
    public RedirectView updateEntry(RedirectAttributes redirectAttributes, @PathVariable("id") Integer id, @ModelAttribute Entry entry) {
        entryService.updateEntry(id, entry);
        String message = (entry.isActive() ? "Updated " : "Deleted ") + " Entry <b>" + entry.getPassword() + " " + entry.getWebsite() + "</b> ✨.";
        RedirectView redirectView = new RedirectView("/", true);
        redirectAttributes.addFlashAttribute("entryMessage", message);
        return redirectView;
    }
}

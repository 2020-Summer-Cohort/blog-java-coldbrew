package com.iloremipsumshowcase.blog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthorController {
    private AuthorRepository authorRepo;
    public AuthorController(AuthorRepository authorRepo) {
    this.authorRepo = authorRepo;
    }
    @GetMapping("author/{id}")
    public String showSingleAuthor(@PathVariable Long id, Model model) {
        model.addAttribute("author", authorRepo.findAuthorById(id));
        return "author-template";
    }

    @PostMapping("author/add")
    public String addAuthor(String fullName){
        Author authorToAdd = new Author(fullName);
        authorRepo.save(authorToAdd);
        return "redirect:/";
    }
}

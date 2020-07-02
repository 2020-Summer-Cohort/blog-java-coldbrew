package com.iloremipsumshowcase.blog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthorController {
    private AuthorRepository authorRepo;
    private IpsumPostRepository ipsumPostRepo;
    private IpsumCategoryRepository ipsumCategoryRepo;
    public AuthorController(AuthorRepository authorRepo, IpsumPostRepository ipsumPostRepo, IpsumCategoryRepository ipsumCategoryRepo) {
    this.authorRepo = authorRepo;
    this.ipsumPostRepo = ipsumPostRepo;
    this.ipsumCategoryRepo = ipsumCategoryRepo;
    }
    @GetMapping("author/{id}")
    public String showSingleAuthor(@PathVariable Long id, Model model) {
        model.addAttribute("author", authorRepo.findAuthorById(id));
        return "author-template";
    }
    @GetMapping("author/")
    public String showAllAuthors(Model model){
        model.addAttribute("authors",authorRepo.findAll());
        return "allauthors-template";
    }

    @PostMapping("author/add")
    public String addAuthor(String authorName){
        Author authorToAdd = new Author(authorName);
        authorRepo.save(authorToAdd);
        return "redirect:/";
    }

    @PostMapping("author/delete")
    public String deleteAuthor(Long id){
        Author toDelete = authorRepo.findAuthorById(id);
        if(toDelete.getIpsumPosts().isEmpty()) {
            authorRepo.delete(toDelete);
        }
       return "redirect:/";
    }
}

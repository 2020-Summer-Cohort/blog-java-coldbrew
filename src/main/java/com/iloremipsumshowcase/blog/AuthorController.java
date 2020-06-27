package com.iloremipsumshowcase.blog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
public class AuthorController {
    public AuthorController(AuthorRepository authorRepo) {
    }

    public String showSingleAuthor(String authorName, Model mockModel) {
    return null;
    }

}

package com.iloremipsumshowcase.blog;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

public class HashtagController {
private HashtagRepository hashtagRepo;
private IpsumPostRepository ipsumPostRepo;
    public HashtagController(HashtagRepository hashtagRepo, IpsumPostRepository ipsumPostRepo) {
        this.hashtagRepo = hashtagRepo;
        this.ipsumPostRepo = ipsumPostRepo;
    }

    @GetMapping("hashtag/{id}")
    public String showSingleHashtag(long id, Model model) {
    model.addAttribute("hashtag",hashtagRepo.findHashtagById(id));
    return "hashtag-template";
    }

    @PostMapping("hashtag/add")
    public String addHashtag(String hashtagName){
        Hashtag hashtagToAdd = new Hashtag(hashtagName);
        hashtagRepo.save(hashtagToAdd);
        return "redirect:/";
    }

    @PostMapping("hashtag/delete")
    public String deleteHashtag(Long hashtagId){
        hashtagRepo.deleteById(hashtagId);
        return "redirect:/";
    }
}

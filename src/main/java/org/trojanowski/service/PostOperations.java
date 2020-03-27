package org.trojanowski.service;

import org.trojanowski.model.post.Post;
import org.trojanowski.model.user.User;

import java.util.List;
import java.util.stream.Collectors;

public class PostOperations {

    public List<String> checkIfPostUnique(List<Post> postsList){

        List<String> titles = postsList.stream().map(post -> post.getTitle()).collect(Collectors.toList());

        return titles.stream()
                .filter(title -> titles.stream().filter(titleToCheck->title.equals(titleToCheck)).count()>1)
                .distinct()
                .collect(Collectors.toList());
    }
}
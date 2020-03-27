package org.trojanowski.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.trojanowski.model.post.Post;
import org.trojanowski.model.user.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PostOperationsTest {

    PostOperations postOperations;

    @BeforeEach
    void setUp(){postOperations = new PostOperations();}

    @Test
    void checkIfPostUniqueOnlyPostsWithUniqueTitle(){

        Post post1 = new Post(1L,10L,"Tytul 1","Test1");
        Post post2 = new Post(2L,11L,"Tytul 2","Test2");
        Post post3 = new Post(3L,11L,"Tytul 3","Test3");

        List<Post> allPosts = Arrays.asList(post1,post2,post3);

        List<String> listToCheck = postOperations.checkIfPostUnique(allPosts);

        List<String> approvedList = Arrays.asList();

        assertIterableEquals(approvedList,listToCheck);
    }

    @Test
    void checkIfPostUniqueOnlyPostsWithoutUniqueTitle(){

        Post post1 = new Post(1L,10L,"Tytul 1","Test1");
        Post post2 = new Post(2L,11L,"Tytul 1","Test2");
        Post post3 = new Post(3L,11L,"Tytul 1","Test3");

        List<Post> allPosts = Arrays.asList(post1,post2,post3);

        List<String> listToCheck = postOperations.checkIfPostUnique(allPosts);

        List<String> approvedList = Arrays.asList(post1.getTitle());

        assertIterableEquals(approvedList,listToCheck);
    }

    @Test
    void checkIfPostUnique(){

        Post post1 = new Post(1L,10L,"Tytul 1","Test1");
        Post post2 = new Post(2L,11L,"Tytul 1","Test2");
        Post post3 = new Post(3L,11L,"Tytul 2","Test3");

        List<Post> allPosts = Arrays.asList(post1,post2,post3);

        List<String> listToCheck = postOperations.checkIfPostUnique(allPosts);

        List<String> approvedList = Arrays.asList(post1.getTitle());

        assertIterableEquals(approvedList,listToCheck);
    }

}
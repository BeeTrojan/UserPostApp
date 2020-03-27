package org.trojanowski.dataoperations;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.trojanowski.model.post.Post;
import org.trojanowski.model.user.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

class CombineDataTest {

    CombineData combineData;

    @BeforeEach
    void setUp(){combineData = new CombineData();}

    @Test
    void assignPostsToUserTest(){

        User user1ToCheck = new User(1L,new ArrayList<>());
        User user2ToCheck = new User(2L,new ArrayList<>());

        List<User> usersToCheck = Arrays.asList(user1ToCheck,user2ToCheck);
        List<Post> postsListToCombine= Arrays.asList(new Post(1L, 20L,"hej","jestem u user1"),new Post(2L, 10L,"jeh","jestem u user2"));

        List<Post> postList1 = Arrays.asList(new Post(1L, 20L,"hej","jestem u user1"));
        List<Post> postList2 = Arrays.asList(new Post(2L, 10L,"jeh","jestem u user2"));
        User user1 = new User(1L,postList1);
        User user2 = new User(2L,postList2);

        List<User> usersList = Arrays.asList(user1,user2);

        List<User> output = combineData.assignPostsToUser(usersToCheck,postsListToCombine);

        assertIterableEquals(usersList, output);
    }

    @Test
    void assignPostsToUserMultiplePostForOneUser(){

        User user1ToCheck = new User(1L,new ArrayList<>());
        User user2ToCheck = new User(2L,new ArrayList<>());

        List<User> usersToCheck = Arrays.asList(user1ToCheck,user2ToCheck);
        List<Post> postsListToCombine= Arrays.asList(new Post(1L, 20L,"hej","jestem u user1"),
                new Post(2L, 10L,"jeh","jestem u user2"),
                new Post(2L,11L,"Ohay","jestem drugim postem u user2"));

        List<Post> postList1 = Arrays.asList(new Post(1L, 20L,"hej","jestem u user1"));
        List<Post> postList2 = Arrays.asList(new Post(2L, 10L,"jeh","jestem u user2"),
                new Post(2L,11L,"Ohay","jestem drugim postem u user2"));

        User user1 = new User(1L,postList1);
        User user2 = new User(2L,postList2);

        List<User> usersList = Arrays.asList(user1,user2);

        List<User> output = combineData.assignPostsToUser(usersToCheck,postsListToCombine);

        assertIterableEquals(usersList, output);
    }

    @Test
    void assignPostsToUserWithoutPosts(){
        User user1ToCheck = new User(1L,new ArrayList<>());
        User user2ToCheck = new User(2L,new ArrayList<>());

        List<User> usersToCheck = Arrays.asList(user1ToCheck,user2ToCheck);
        List<Post> postsListToCombine= Arrays.asList(new Post(1L, 20L,"hej","jestem u user1"),
                new Post(1L, 10L,"jeh","jestem u user1"),
                new Post(1L,11L,"Ohay","jestem drugim postem u user1"));


        List<Post> postList1 = Arrays.asList(new Post(1L, 20L,"hej","jestem u user1"),
                new Post(1L, 10L,"jeh","jestem u user1"),
                new Post(1L,11L,"Ohay","jestem drugim postem u user1"));
        List<Post> postList2 = Arrays.asList();

        User user1 = new User(1L,postList1);
        User user2 = new User(2L,postList2);

        List<User> usersList = Arrays.asList(user1,user2);

        List<User> output = combineData.assignPostsToUser(usersToCheck,postsListToCombine);

        assertIterableEquals(usersList, output);
    }
}
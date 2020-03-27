package org.trojanowski.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.trojanowski.model.user.Address;
import org.trojanowski.model.user.Geo;
import org.trojanowski.model.user.User;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

class NearestNeighborTest {

    NearestNeighbor nearestNeighbor;

    @BeforeEach
    void setUp(){nearestNeighbor = new NearestNeighbor();}

    @Test
    void assignNearestNeighborOneNearestNeighbor(){
        User user1 = new User(1L,new Address(new Geo(10.0,10.0)));
        User user2 = new User(2L,new Address(new Geo(5.0,5.0)));
        User user3 = new User(3L,new Address(new Geo(5.0,10.0)));
        User user4 = new User(4L,new Address(new Geo (10.0,5.0)));

        List<User> userList = Arrays.asList(user1,user2,user3,user4);

        nearestNeighbor.assignNearestNeighbor(userList);

           assertIterableEquals(user1.getNearestNeighbor(),Arrays.asList(user4));
           assertIterableEquals(user2.getNearestNeighbor(),Arrays.asList(user3));
           assertIterableEquals(user3.getNearestNeighbor(),Arrays.asList(user2));
           assertIterableEquals(user4.getNearestNeighbor(),Arrays.asList(user1));
    }

    @Test
    void assignNearestNeighborMultipleNearestNeighbors(){
        User user1 = new User(1L,new Address(new Geo(10.0,10.0)));
        User user2 = new User(2L,new Address(new Geo(10.0,10.0)));
        User user3 = new User(3L,new Address(new Geo(10.0,10.0)));
        User user4 = new User(4L,new Address(new Geo (10.0,10.0)));

        List<User> userList = Arrays.asList(user1,user2,user3,user4);

        nearestNeighbor.assignNearestNeighbor(userList);

        assertIterableEquals(user1.getNearestNeighbor(),Arrays.asList(user2,user3,user4));
        assertIterableEquals(user2.getNearestNeighbor(),Arrays.asList(user1,user3,user4));
        assertIterableEquals(user3.getNearestNeighbor(),Arrays.asList(user1,user2,user4));
        assertIterableEquals(user4.getNearestNeighbor(),Arrays.asList(user1,user2,user3));
    }

    @Test
    void assignNearestNeighborWhenListContainsOneUser(){
        User user1 = new User(1L,new Address(new Geo(10.0,10.0)));

        List<User> userList = Arrays.asList(user1);

        nearestNeighbor.assignNearestNeighbor(userList);

        assertIterableEquals(user1.getNearestNeighbor(),Arrays.asList());

    }
}

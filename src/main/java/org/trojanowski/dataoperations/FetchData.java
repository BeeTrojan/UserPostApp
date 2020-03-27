package org.trojanowski.dataoperations;

import org.springframework.web.client.RestTemplate;
import org.trojanowski.model.post.Post;
import org.trojanowski.model.user.User;

public class FetchData {
    public User[] fetchUserData(String url){

       RestTemplate restTemplate = new RestTemplate();

       return restTemplate.getForObject(url, User[].class);
    }

    public Post[] fetchPostData(String url){

        RestTemplate restTemplate = new RestTemplate();

        return restTemplate.getForObject(url,Post[].class);
    }
}
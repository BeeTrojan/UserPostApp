package org.trojanowski.dataoperations;

import org.trojanowski.model.post.Post;
import org.trojanowski.model.user.User;

import java.util.List;

public class CombineData {
    public List<User> assignPostsToUser(List<User> usersList, List<Post> posts){

        for(User user : usersList){
            for(Post post : posts){
                if(user.getId().equals(post.getUserId())){
                    user.addPost(post);
                }
            }
        }
        return  usersList;
    }
}
package org.trojanowski;

import org.trojanowski.config.ConfigReader;
import org.trojanowski.dataoperations.CombineData;
import org.trojanowski.dataoperations.FetchData;
import org.trojanowski.model.post.Post;
import org.trojanowski.model.user.User;
import org.trojanowski.service.NearestNeighbor;
import org.trojanowski.service.PostOperations;

import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) throws Exception {
    //1
        Properties properties = ConfigReader.loadPropertiesFile("application.properties");
        String urlUsers = (String) properties.get("urlUsers");
        String urlPosts = (String) properties.get("urlPosts");

        FetchData fetchData = new FetchData();

        List<User> usersList= Arrays.asList((fetchData.fetchUserData(urlUsers)));
        List<Post> postsList = Arrays.asList((fetchData.fetchPostData(urlPosts)));

        CombineData combineData = new CombineData();
        List<User> combinedPostsUsers= combineData.assignPostsToUser(usersList,postsList);

    //2
        List<String> countedPostsByUser = combinedPostsUsers.stream().map(u->u.getUsername()+" napisał(a) "+ u.getUserPostList().size()+" postów").collect(Collectors.toList());
        System.out.println(countedPostsByUser);
    //3
        PostOperations postOperations = new PostOperations();

        List<String> notUniquePosts = postOperations.checkIfPostUnique(postsList);
        System.out.println("Nieunikalne tytuły: " + notUniquePosts);
    //4
        NearestNeighbor nearestNeighbor =new NearestNeighbor();

        List<User> listWithNearestNeighbor= nearestNeighbor.assignNearestNeighbor(usersList);
        for(User user : listWithNearestNeighbor){
            System.out.println(user.getName()+" najbliższy sąsiad to "+user.getNearestNeighbor().stream().map(m->m.getName()).collect(Collectors.toList()));
        }
    }
}

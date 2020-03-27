package org.trojanowski.service;

import org.trojanowski.model.user.User;

import java.util.*;
import java.util.stream.Collectors;


public class NearestNeighbor {

private Map<Neighbors,Integer> calculateAllDistance(List<User> userList)  {
    Map<Neighbors, Integer> userDistances = new HashMap<>();
    int distance;
    for (User user: userList){
        for (User userNeighbor:userList){
            if(!userDistances.containsKey(new Neighbors(user.getId(),userNeighbor.getId()))&& (user.getId()!=userNeighbor.getId())){

                distance = calculateDistance(user.getAddress().getGeo().getLat(), userNeighbor.getAddress().getGeo().getLat(),
                                            user.getAddress().getGeo().getLng(), userNeighbor.getAddress().getGeo().getLng());
                userDistances.put(new Neighbors(user.getId(),userNeighbor.getId()),distance);

            }
        }
    }

    return userDistances;
}

    private User findUserById(List<User> userList, Long id){
        for (User user: userList){
            if(user.getId().equals(id)){
                return user;
            }
        }

    return null;
    }

    public List<User> assignNearestNeighbor(List<User> userList){

        Map<Neighbors,Integer> usersDistances = calculateAllDistance(userList);
        List<Neighbors> nearestNeighbor;
        if(userList.size()<2){
            return new ArrayList<User>();
        }
        for(User user : userList){
            Map<Neighbors,Integer> f = usersDistances.entrySet().stream().
          filter(map -> map.getKey().checkKey(user.getId())).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
            final long minDistance = f.entrySet().stream().mapToLong(value->value.getValue()).min().getAsLong();
                nearestNeighbor =f.entrySet().stream().filter(map->map.getValue() == (minDistance)).map(v->v.getKey()).collect(Collectors.toList());

                for(Neighbors neighbors :nearestNeighbor){

                    if(!user.getId().equals(neighbors.id)) {
                        user.addNeighbor(findUserById(userList,neighbors.id));
                    }
                    if(!user.getId().equals(neighbors.idNeighbor)){
                        user.addNeighbor(findUserById(userList,neighbors.idNeighbor));
                    }
                }
}

    return userList;

    }

    private static int calculateDistance(double lat1, double lat2, double lon1, double lon2) {
        lon1 = Math.toRadians(lon1);
        lon2 = Math.toRadians(lon2);
        lat1 = Math.toRadians(lat1);
        lat2 = Math.toRadians(lat2);

        if (lon1 == lon2 && lat1 == lat2) {
            return 0;
        }

        double dlon = lon2 - lon1;
        double dlat = lat2 - lat1;
        double a = Math.pow(Math.sin(dlat / 2), 2) + Math.cos(lat1) * Math.cos(lat2) * Math.pow(Math.sin(dlon / 2), 2);
        double c = 2 * Math.asin(Math.sqrt(a));
        int r = 6371;

        return (int) (c * r);
    }
}
package org.trojanowski.model.user;

import org.trojanowski.model.post.Post;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class User  implements Serializable {
    Long id;
    String name;
    String username;
    String email;
    Address address;
    String phone;
    String website;
    Company company;


    List<User> nearestNeighbor = new ArrayList<>();

    List<Post> userPostList= new ArrayList<>();

    public User(Long id, Address address) {
        this.id = id;
        this.address = address;
    }

    public User(Long id, List<Post> userPostList) {
        this.id = id;
        this.userPostList = userPostList;
    }

    public User(Long id, Address address, List<User> nearestNeighbor) {
        this.id = id;
        this.address = address;
        this.nearestNeighbor = nearestNeighbor;
    }

    public User(Long id, String name, String username, String email, Address address, String phone, String website, Company company, List<User> nearestNeighbor, List<Post> userPostList) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.website = website;
        this.company = company;
        this.nearestNeighbor = nearestNeighbor;
        this.userPostList = userPostList;
    }

    public User() {
    }

    public User(Long id, String username, List<Post> userPostList) {
        this.id = id;
        this.username = username;
        this.userPostList = userPostList;
    }

    public List<User> getNearestNeighbor() {
        return nearestNeighbor;
    }

    public void setNearestNeighbor(List<User> nearestNeighbor) {
        this.nearestNeighbor = nearestNeighbor;
    }

    public void addPost(Post post){
        userPostList.add(post);
    }
    public void addNeighbor(User user){
        nearestNeighbor.add(user);
    }


    public List<Post> getUserPostList() {
        return userPostList;
    }

    public void setUserPostList(List<Post> userPostList) {
        this.userPostList = userPostList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != null ? !id.equals(user.id) : user.id != null) return false;
        if (name != null ? !name.equals(user.name) : user.name != null) return false;
        if (username != null ? !username.equals(user.username) : user.username != null) return false;
        if (email != null ? !email.equals(user.email) : user.email != null) return false;
        if (address != null ? !address.equals(user.address) : user.address != null) return false;
        if (phone != null ? !phone.equals(user.phone) : user.phone != null) return false;
        if (website != null ? !website.equals(user.website) : user.website != null) return false;
        if (company != null ? !company.equals(user.company) : user.company != null) return false;

        return userPostList != null ? userPostList.equals(user.userPostList) : user.userPostList == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (website != null ? website.hashCode() : 0);
        result = 31 * result + (company != null ? company.hashCode() : 0);

        result = 31 * result + (userPostList != null ? userPostList.hashCode() : 0);
        return result;
    }
}

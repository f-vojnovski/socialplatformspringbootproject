package com.filip.socialplatform.web;

import com.filip.socialplatform.model.SearchInput;
import com.filip.socialplatform.model.User;
import com.filip.socialplatform.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@SessionAttributes({"currentUser"})
@CrossOrigin
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(method = RequestMethod.POST, path = "/registerNewUser")
    public String addUser(@RequestBody User user) {
        userService.addUser(user);
        return "register success";
    }

    @RequestMapping(path = "/searchForUser", method = RequestMethod.POST)
    @ResponseBody
    public List<User> findUsersBySearching(@RequestBody SearchInput searchInput) {
        return userService.findUsersBySearching(searchInput.getSearchInput());
    }

    @RequestMapping(path = "/getLoggedInUser", method = RequestMethod.GET)
    @ResponseBody
    public String getLoggedInUser(Principal principal) {
        if (principal == null) return null;
        if (principal.getName() == null) return null;
        User user = userService.findUserByUsername(principal.getName());

        if (user == null) return null;

        return user.toString();
    }

    @RequestMapping(path = "/getUserByUsername", method = RequestMethod.GET)
    @ResponseBody
    public User getUserByUsername(SearchInput searchInput) {
        System.out.println(searchInput.getSearchInput());

        return userService.findUserByUsername(searchInput.getSearchInput());
    }

    @RequestMapping(path = "/username", method = RequestMethod.GET)
    @ResponseBody
    public String currentUserName(Principal principal) {
        if (principal == null) return "";
        if (principal.getName() != null)  return principal.getName();
        else return "";
    }

    @RequestMapping(path = "/addFriend", method = RequestMethod.POST)
    @ResponseBody
    public User addFriend(@RequestBody SearchInput searchInput, Principal principal) {
        String username = searchInput.getSearchInput();

        if (principal == null) return null;

        User userAddingFriend = userService.findUserByUsername(principal.getName());
        User userGettingFriendRequest = userService.findUserByUsername(username);

        if (userAddingFriend == null) return null;
        if (userGettingFriendRequest == null) return null;

        if (userAddingFriend.getUsername() == userGettingFriendRequest.getUsername()) return null;

        userAddingFriend.addFriend(userGettingFriendRequest);

        return userGettingFriendRequest;
    }
}

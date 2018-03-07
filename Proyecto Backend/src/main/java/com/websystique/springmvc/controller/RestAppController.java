package com.websystique.springmvc.controller;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;

import com.websystique.springmvc.model.ResultMessage;
import com.websystique.springmvc.model.SucessMessageEnum;
import com.websystique.springmvc.model.User;
import com.websystique.springmvc.model.UserProfile;
import com.websystique.springmvc.service.UserProfileService;
import com.websystique.springmvc.service.UserService;

@RestController
public class RestAppController {

	@Autowired
	UserService userService;
	
	@Autowired
	UserProfileService userProfileService;
	
  //-------------------Retrieve All Users--------------------------------------------------------
    
    @RequestMapping(value = "/user", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<User>> listAllUsers() {
        List<User> users = userService.findAllUsers();
        for (int i = 0; i < users.size(); i++) {
                System.out.println("cod: "+users.get(i).getId()+" Persona : "+users.get(i).getSsoId());
                System.out.println();
        }
        if(users.isEmpty()){
            return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<User>>(users, HttpStatus.OK);
    }
	
    

    
    /*
    @RequestMapping(value="/user", method = RequestMethod.GET , produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ResultMessage> obtenerUsuarios(@ModelAttribute User pUser, Locale objLocale) throws Exception{
	ResultMessage response = new ResultMessage(SucessMessageEnum.MESSAGE_GENERAL_SUCCESS);
		response.setData(userService.findAllUsers());
		List<User> users = userService.findAllUsers();
        for (int i = 0; i < users.size(); i++) {
                System.out.println("cod: "+users.get(i).getId()+" Persona : "+users.get(i).getSsoId());
                System.out.println();
        }
		return new ResponseEntity<ResultMessage>(response,SucessMessageEnum.MESSAGE_GENERAL_SUCCESS.getHttpStatus());
	}
    */
  //-------------------Retrieve All Type Users--------------------------------------------------------
    
    @RequestMapping(value = "/user/types", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<UserProfile>> listAllUserProfiles() {
        List<UserProfile> userprofiles = userProfileService.findAll();
        for (int i = 0; i < userprofiles.size(); i++) {
                System.out.println("Id: "+userprofiles.get(i).getId()+" Type : "+userprofiles.get(i).getType());
                System.out.println();
        }
        if(userprofiles.isEmpty()){
            return new ResponseEntity<List<UserProfile>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<UserProfile>>(userprofiles, HttpStatus.OK);
    }
    
    
    
  //-------------------Retrieve Single User--------------------------------------------------------
    
    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> getUser(@PathVariable("id") int id) {
        System.out.println("Fetching User with id " + id);
        User user = userService.findById(id);
        if (user == null) {
            System.out.println("User with id " + id + " not found");
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }
    
  //-------------------Create a User--------------------------------------------------------
    
    @RequestMapping(value = "/user/", method = RequestMethod.POST)
    public ResponseEntity<Void> createUser(@RequestBody User user,    UriComponentsBuilder ucBuilder) {
        System.out.println("Creating User " + user.getSsoId());
  
        if (!userService.isUserSSOUnique(user.getId(), user.getSsoId())) {
            System.out.println("A User with name " + user.getSsoId() + " already exist");
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
  
        userService.saveUser(user);
  
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(user.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
	
  //------------------- Update a User --------------------------------------------------------
    
    @RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
    public ResponseEntity<User> updateUser(@PathVariable("id") int id, @RequestBody User user) {
        System.out.println("Updating User " + id);
          
        User currentUser = userService.findById(id);
          
        if (currentUser==null) {
            System.out.println("User with id " + id + " not found");
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
  
        userService.updateUser(currentUser);
        return new ResponseEntity<User>(currentUser, HttpStatus.OK);
    }
  
     
     
    //------------------- Delete a User --------------------------------------------------------
      
    @RequestMapping(value = "/user/{ssoId}", method = RequestMethod.DELETE)
    public ResponseEntity<User> deleteUser(@PathVariable("ssoId") String ssoId) {
        System.out.println("Fetching & Deleting User with ssoId " + ssoId);
  
        User user = userService.findBySSO(ssoId);
        if (user == null) {
            System.out.println("Unable to delete. User with ssoId " + ssoId + " not found");
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
  
        userService.deleteUserBySSO(ssoId);
        return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
    }

}

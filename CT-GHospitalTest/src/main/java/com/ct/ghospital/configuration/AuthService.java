package com.ct.ghospital.configuration;


import java.util.Arrays;
import java.util.Collections;

import javax.ws.rs.core.Response;

import org.keycloak.OAuth2Constants;
import org.keycloak.admin.client.CreatedResponseUtil;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.keycloak.admin.client.resource.RealmResource;
import org.keycloak.admin.client.resource.UserResource;
import org.keycloak.admin.client.resource.UsersResource;
import org.keycloak.representations.AccessTokenResponse;
import org.keycloak.representations.idm.CredentialRepresentation;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.stereotype.Service;

import com.ct.ghospital.patient.exception.UnauthorizedcheckException;

@Service
public class AuthService {
	  String serverUrl = "http://localhost:8180/auth";
      String realm = "master";
      // idm-client needs to allow "Direct Access Grants: Resource Owner Password Credentials Grant"
      String clientId = "apigateway";
      String clientSecret = "FCGdYRnmbKIIg17po8M71AOeORr4KWIN";
      

      
      public AccessTokenResponse getInstance() {
    	   Keycloak keycloak = KeycloakBuilder.builder() //
                   .serverUrl(serverUrl) //
                   .realm(realm) //
                   .grantType(OAuth2Constants.PASSWORD) //
                   .clientId(clientId) //
                   .clientSecret(clientSecret) //
                   .username("kuldeep@gmail.com") //
                   .password("abcd") //
                   .build();
      
      return keycloak.tokenManager().getAccessToken();
      }
      
      
      public AccessTokenResponse getUser(String username,String password) {
   	 
    	  try{
    		  Keycloak keycloak = KeycloakBuilder.builder() //
    	  
                  .serverUrl(serverUrl) //
                  .realm(realm) //
                  .grantType(OAuth2Constants.PASSWORD) //
                  .clientId(clientId) //
                  .clientSecret(clientSecret) //
                  .username(username) //
                  .password(password) //
                  .build();
    	    return keycloak.tokenManager().getAccessToken();
    	  }  catch(UnauthorizedcheckException e) {
    		  throw new UnauthorizedcheckException();
    	  }catch(Exception e)
    	  {
    		  //System.out.println("Something wemt wrong "+e);
    		  throw new UnauthorizedcheckException();
    		 
    	  }
      }
   
      
      
      
      public UserRepresentation registerUser(String username,String password,String fname,String lname) {
    	  // Define user
          UserRepresentation user = new UserRepresentation();
          user.setEnabled(true);
          user.setUsername(username);
          user.setFirstName(fname);
          user.setLastName(lname);
          user.setEmail(username);
          user.setAttributes(Collections.singletonMap("origin", Arrays.asList("demo")));
          
        // Get realm
        Keycloak keycloak = KeycloakBuilder.builder() //
                .serverUrl(serverUrl) //
                .realm(realm) //
                .grantType(OAuth2Constants.PASSWORD) //
                .clientId(clientId) //
                .clientSecret(clientSecret) //
                .username("admin") //
                .password("admin123") //
                .build();
        
          RealmResource realmResource = keycloak.realm(realm);
          UsersResource usersRessource = realmResource.users();

          // Create user (requires manage-users role)
          Response response = usersRessource.create(user);
          System.out.printf("Repsonse: %s %s%n", response.getStatus(), response.getStatusInfo());
         System.out.println(response.getLocation());
          String userId = CreatedResponseUtil.getCreatedId(response);

          System.out.printf("User created with userId: %s%n", userId);
          
          
          // Define password credential
          CredentialRepresentation passwordCred = new CredentialRepresentation();
          passwordCred.setTemporary(false);
          passwordCred.setType(CredentialRepresentation.PASSWORD);
          passwordCred.setValue(password);

          UserResource userResource = usersRessource.get(userId);
          // Set password credential
          userResource.resetPassword(passwordCred);
          
          
          return user;
      }
     
}

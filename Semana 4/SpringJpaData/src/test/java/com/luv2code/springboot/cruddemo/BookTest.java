package com.luv2code.springboot.cruddemo;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import spring.jpa.Runner;
import spring.jpa.dao.AuthorityRepository;
import spring.jpa.dao.UserRepository;
import spring.jpa.entity.Authority;
import spring.jpa.entity.Members;
import utils.AuthorityName;

public class BookTest {
	 // Tests for Members entity
	
	@Autowired
    private Runner runner;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthorityRepository authorityRepository;

	
    @Test
    public void testMemberCreation() {
        Members member = new Members("user1", "password1", null);
        assertNotNull(member);
        assertEquals("user1", member.getUsername());
        assertEquals("password1", member.getPassword());
        assertNull(member.getAuthorities()); // Ensure authorities is null
    }

    @Test
    public void testMemberSettersAndGetters() {
        Members member = new Members();
        member.setUsername("user2");
        member.setPassword("password2");
        assertEquals("user2", member.getUsername());
        assertEquals("password2", member.getPassword());
        assertNull(member.getAuthorities()); // Ensure authorities is null
    }

    
    @Test
    public void testMemberWithAuthorities() {
        Authority authority = new Authority(AuthorityName.ROLE_ADMIN);
        Members member = new Members("user3", "password3", List.of(authority));

        assertNotNull(member);
        assertEquals("user3", member.getUsername());
        assertEquals("password3", member.getPassword());
        assertNotNull(member.getAuthorities());
        assertEquals(1, member.getAuthorities().size());
        assertEquals(AuthorityName.ROLE_ADMIN, member.getAuthorities().get(0).getName());
    }
    // Tests for Authority entity
    @Test
    public void testAuthorityCreation() {
        Authority authority = new Authority(AuthorityName.ROLE_ADMIN);
        assertNotNull(authority);
        assertEquals(AuthorityName.ROLE_ADMIN, authority.getName());
    }

    @Test
    public void testAuthoritySettersAndGetters() {
        Authority authority = new Authority();
        authority.setName(AuthorityName.ROLE_READER);
        assertEquals(AuthorityName.ROLE_READER, authority.getName());
    }
    

    @Test
    public void testAuthorityEnum() {
        Authority authority = new Authority(AuthorityName.ROLE_ADMIN);
        assertEquals(AuthorityName.ROLE_ADMIN, authority.getName());
        
        // Change the AuthorityName and verify
        authority.setName(AuthorityName.ROLE_READER);
        assertEquals(AuthorityName.ROLE_READER, authority.getName());
    }
    
 
    
}
package com.luv2code.springboot.cruddemo;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import spring.jpa.dao.UserRepository;
import spring.jpa.entity.Authority;
import spring.jpa.entity.Book;
import spring.jpa.entity.Members;
import spring.jpa.service.SecurityUserDetailsService;
import utils.AuthorityName;
import utils.SecurityAuthority;
import utils.SecurityUser;

public class BookTest {


    @Test
    public void testMemberCreation() {
        Members member = new Members("user1", "password1", null);
        assertNotNull(member);
        assertEquals("user1", member.getUsername());
        assertEquals("password1", member.getPassword());
        assertNull(member.getAuthorities());
    }

    @Test
    public void testMemberSettersAndGetters() {
        Members member = new Members();
        member.setUsername("user2");
        member.setPassword("password2");
        assertEquals("user2", member.getUsername());
        assertEquals("password2", member.getPassword());
        assertNull(member.getAuthorities()); 
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
        authority.setName(AuthorityName.ROLE_READER);
        assertEquals(AuthorityName.ROLE_READER, authority.getName());
    }

    @Test
    public void testBookCreation() {
        Book book = new Book(0, "Title", "Author", "Genre", 19.99, 2024, 10);
        assertNotNull(book);
        assertEquals("Title", book.getTitle());
        assertEquals("Author", book.getAuthor());
        assertEquals("Genre", book.getGenre());
        assertEquals(19.99, book.getPrice());
        assertEquals(2024, book.getPublished());
        assertEquals(10, book.getStock());
    }

    @Test
    public void testBookSettersAndGetters() {
        Book book = new Book();
        book.setTitle("New Title");
        book.setAuthor("New Author");
        book.setGenre("New Genre");
        book.setPrice(29.99);
        book.setPublished(2023);
        book.setStock(15);

        assertEquals("New Title", book.getTitle());
        assertEquals("New Author", book.getAuthor());
        assertEquals("New Genre", book.getGenre());
        assertEquals(29.99, book.getPrice());
        assertEquals(2023, book.getPublished());
        assertEquals(15, book.getStock());
    }

    @Test
    public void testSecurityAuthorityGetAuthority() {
        Authority authority = new Authority(AuthorityName.ROLE_ADMIN);
        SecurityAuthority securityAuthority = new SecurityAuthority(authority);

        assertEquals(AuthorityName.ROLE_ADMIN.toString(), securityAuthority.getAuthority());
    }

    @Test
    public void testSecurityUserGetAuthorities() {
        Authority authority = new Authority(AuthorityName.ROLE_ADMIN);
        Members member = new Members("user1", "password1", List.of(authority));
        SecurityUser securityUser = new SecurityUser(member);

        assertNotNull(securityUser.getAuthorities());
        assertEquals(1, securityUser.getAuthorities().size());
        assertEquals(AuthorityName.ROLE_ADMIN.toString(), securityUser.getAuthorities().iterator().next().getAuthority());
    }

    @Test
    public void testSecurityUserGetPassword() {
        Members member = new Members("user2", "password2", null);
        SecurityUser securityUser = new SecurityUser(member);

        assertEquals("password2", securityUser.getPassword());
    }

    @Test
    public void testSecurityUserGetUsername() {
        Members member = new Members("user3", "password3", null);
        SecurityUser securityUser = new SecurityUser(member);

        assertEquals("user3", securityUser.getUsername());
    }
    
    private UserRepository userRepository;
    private SecurityUserDetailsService securityUserDetailsService;

    @BeforeEach
    public void setUp() {
        userRepository = mock(UserRepository.class);
        securityUserDetailsService = new SecurityUserDetailsService(userRepository);
    }

    @Test
    public void testLoadUserByUsername_UserFound() {
        String username = "user1";
        Members member = new Members(username, "password1", null);
        when(userRepository.findByUsername(username)).thenReturn(Optional.of(member));

        SecurityUser securityUser = (SecurityUser) securityUserDetailsService.loadUserByUsername(username);

        assertNotNull(securityUser);
        assertEquals(username, securityUser.getUsername());
        assertEquals("password1", securityUser.getPassword());
    }

    @Test
    public void testLoadUserByUsername_UserNotFound() {
        String username = "user2";
        when(userRepository.findByUsername(username)).thenReturn(Optional.empty());

        UsernameNotFoundException thrown = assertThrows(
            UsernameNotFoundException.class,
            () -> securityUserDetailsService.loadUserByUsername(username),
            "Expected loadUserByUsername() to throw UsernameNotFoundException, but it didn't"
        );

        assertEquals("Use not found" + username, thrown.getMessage());
    }
}

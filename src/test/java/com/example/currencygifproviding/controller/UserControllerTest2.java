package com.example.currencygifproviding.controller;

import com.example.currencygifproviding.client.CurrencyClient;
import com.example.currencygifproviding.client.GifClient;
import com.example.currencygifproviding.service.UserService;
import org.apache.catalina.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
@RunWith(SpringRunner.class)
class UserControllerTest2 {

    @InjectMocks
    UserController userController;
    @InjectMocks
    UserService userService;

    @MockBean
    CurrencyClient currencyClient;
    @MockBean
    GifClient gifClient;

    @Test
    public void testAddEmployee()
    {

    }

}
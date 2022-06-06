package com.example.currencygifproviding.controller;

import com.example.currencygifproviding.client.CurrencyClient;
import com.example.currencygifproviding.client.GifClient;
import com.example.currencygifproviding.service.UserService;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class UserControllerTest {
    @MockBean
    CurrencyClient currencyClient;
    @MockBean
    GifClient gifClient;

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private UserService userService;


    @Test
    void getByIdTest() throws Exception {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        String dateNow = dtf.format(LocalDateTime.now()).toString() + ".json";
        String dateTom = dtf.format(LocalDateTime.now().plusDays(-1)).toString() + ".json";

        BufferedReader in = new BufferedReader(new FileReader("/Users/gusevang/Downloads/CurrencyGifProviding1/src/test/java/com/example/currencygifproviding/controller/curToday"));
        StringBuilder sb = new StringBuilder();

        while (in.readLine() != null) {
            sb.append(in.readLine()).append("\n");
        }

        JSONObject curToday = new JSONObject(sb.toString());
        in.close();

        in = new BufferedReader(new FileReader("/Users/gusevang/Downloads/CurrencyGifProviding1/src/test/java/com/example/currencygifproviding/controller/curTom"));
        while (in.readLine() != null) {
            sb.append(in.readLine()).append("\n");
        }

        JSONObject curTom = new JSONObject(sb.toString());
        in.close();

        in = new BufferedReader(new FileReader("/Users/gusevang/Downloads/CurrencyGifProviding1/src/test/java/com/example/currencygifproviding/controller/gifTestJSON"));
        while (in.readLine() != null) {
            sb.append(in.readLine()).append("\n");
        }

        JSONObject gifTestJSON = new JSONObject(sb.toString());
        in.close();

        Mockito.when(gifClient.getGifFromCuurencyMovement(eq("rich"), isA(Integer.class), isA(String.class))).thenReturn(gifTestJSON);
        Mockito.when(gifClient.getGifFromCuurencyMovement(eq("broke"), isA(Integer.class), isA(String.class))).thenReturn(gifTestJSON);

        Mockito.when(currencyClient.getPrice(
                        dateNow))
                .thenReturn(curToday);

        Mockito.when(currencyClient.getPrice(
                        dateTom))
                .thenReturn(curTom);

        mockMvc.perform(
                    get("/api/check/price/movement/AED")
                )
                .andExpect(status().isOk())
                .andExpect(model().attribute("curName","AED"))
                .andExpect((model().attribute("gifURL","https://media1.giphy.com/media/5sYr9aizhcehIIoT4S/giphy.gif?cid=74dcbbc8ienxw71m1b14gjirx54v3uwsltzau0eyqq6ipwk7&rid=giphy.gif&ct=g")));
    }


}
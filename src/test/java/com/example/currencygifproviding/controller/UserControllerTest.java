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
import org.springframework.ui.Model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class UserControllerTest {
    @MockBean
    private CurrencyClient currencyClient;
    @MockBean
    private GifClient gifClient;
    @MockBean
    private Model model;

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private UserService userService;
    @Autowired
    private UserController userController;

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

       // JSONObject curToday = new JSONObject(sb.toString());
        String curToday =  "{\n" +
                "  \"disclaimer\": \"Usage subject to terms: https://openexchangerates.org/terms\",\n" +
                "  \"license\": \"https://openexchangerates.org/license\",\n" +
                "  \"timestamp\": 1654531200,\n" +
                "  \"base\": \"USD\",\n" +
                "  \"rates\": {\n" +
                "    \"AED\": 3.6731,\n" +
                "    \"AFN\": 88.999995,\n" +
                "    \"ALL\": 112.035546,\n" +
                "    \"AMD\": 442.346123,\n" +
                "    \"ANG\": 1.802401,\n" +
                "    \"AOA\": 427.86555,\n" +
                "    \"ARS\": 121.121924,\n" +
                "    \"AUD\": 1.387736,\n" +
                "    \"AWG\": 1.8,\n" +
                "    \"AZN\": 1.7,\n" +
                "    \"BAM\": 1.823286,\n" +
                "    \"BBD\": 2,\n" +
                "    \"BDT\": 91.758948,\n" +
                "    \"BGN\": 1.82604,\n" +
                "    \"BHD\": 0.376937,\n" +
                "    \"BIF\": 2030,\n" +
                "    \"BMD\": 1,\n" +
                "    \"BND\": 1.373743,\n" +
                "    \"BOB\": 6.875705,\n" +
                "    \"BRL\": 4.7986,\n" +
                "    \"BSD\": 1,\n" +
                "    \"BTC\": 0.000031796523,\n" +
                "    \"BTN\": 77.594837,\n" +
                "    \"BWP\": 11.920126,\n" +
                "    \"BYN\": 3.376915,\n" +
                "    \"BZD\": 2.015867,\n" +
                "    \"CAD\": 1.257037,\n" +
                "    \"CDF\": 2005,\n" +
                "    \"CHF\": 0.969071,\n" +
                "    \"CLF\": 0.02973,\n" +
                "    \"CLP\": 820.39,\n" +
                "    \"CNH\": 6.654141,\n" +
                "    \"CNY\": 6.6539,\n" +
                "    \"COP\": 3797.81,\n" +
                "    \"CRC\": 682.853007,\n" +
                "    \"CUC\": 1,\n" +
                "    \"CUP\": 25.75,\n" +
                "    \"CVE\": 103.375,\n" +
                "    \"CZK\": 23.114033,\n" +
                "    \"DJF\": 178.037599,\n" +
                "    \"DKK\": 6.95426,\n" +
                "    \"DOP\": 55.15,\n" +
                "    \"DZD\": 145.162891,\n" +
                "    \"EGP\": 18.6539,\n" +
                "    \"ERN\": 15.000001,\n" +
                "    \"ETB\": 51.985694,\n" +
                "    \"EUR\": 0.934805,\n" +
                "    \"FJD\": 2.1469,\n" +
                "    \"FKP\": 0.797216,\n" +
                "    \"GBP\": 0.797216,\n" +
                "    \"GEL\": 2.925,\n" +
                "    \"GGP\": 0.797216,\n" +
                "    \"GHS\": 7.85,\n" +
                "    \"GIP\": 0.797216,\n" +
                "    \"GMD\": 54.175,\n" +
                "    \"GNF\": 8845,\n" +
                "    \"GTQ\": 7.695829,\n" +
                "    \"GYD\": 209.23097,\n" +
                "    \"HKD\": 7.845255,\n" +
                "    \"HNL\": 24.574668,\n" +
                "    \"HRK\": 7.0305,\n" +
                "    \"HTG\": 115.011805,\n" +
                "    \"HUF\": 362.548869,\n" +
                "    \"IDR\": 14428.827609,\n" +
                "    \"ILS\": 3.317085,\n" +
                "    \"IMP\": 0.797216,\n" +
                "    \"INR\": 77.794411,\n" +
                "    \"IQD\": 1459.68365,\n" +
                "    \"IRR\": 42250,\n" +
                "    \"ISK\": 129.29,\n" +
                "    \"JEP\": 0.797216,\n" +
                "    \"JMD\": 153.76486,\n" +
                "    \"JOD\": 0.7102,\n" +
                "    \"JPY\": 131.558,\n" +
                "    \"KES\": 116.95,\n" +
                "    \"KGS\": 79.520612,\n" +
                "    \"KHR\": 4060.75,\n" +
                "    \"KMF\": 460.624979,\n" +
                "    \"KPW\": 900,\n" +
                "    \"KRW\": 1253.125101,\n" +
                "    \"KWD\": 0.30632,\n" +
                "    \"KYD\": 0.833419,\n" +
                "    \"KZT\": 431.793141,\n" +
                "    \"LAK\": 13956.580531,\n" +
                "    \"LBP\": 1512.369392,\n" +
                "    \"LKR\": 362.02694,\n" +
                "    \"LRD\": 151.999978,\n" +
                "    \"LSL\": 15.326587,\n" +
                "    \"LYD\": 4.770788,\n" +
                "    \"MAD\": 9.859932,\n" +
                "    \"MDL\": 18.977223,\n" +
                "    \"MGA\": 4051.385805,\n" +
                "    \"MKD\": 57.48151,\n" +
                "    \"MMK\": 1851.683112,\n" +
                "    \"MNT\": 3105.3554,\n" +
                "    \"MOP\": 8.081552,\n" +
                "    \"MRU\": 36.51,\n" +
                "    \"MUR\": 43.153294,\n" +
                "    \"MVR\": 15.435,\n" +
                "    \"MWK\": 816.25,\n" +
                "    \"MXN\": 19.600863,\n" +
                "    \"MYR\": 4.39,\n" +
                "    \"MZN\": 63.850001,\n" +
                "    \"NAD\": 15.49,\n" +
                "    \"NGN\": 415.038518,\n" +
                "    \"NIO\": 35.853955,\n" +
                "    \"NOK\": 9.41265,\n" +
                "    \"NPR\": 124.151411,\n" +
                "    \"NZD\": 1.538978,\n" +
                "    \"OMR\": 0.384986,\n" +
                "    \"PAB\": 1,\n" +
                "    \"PEN\": 3.711137,\n" +
                "    \"PGK\": 3.569251,\n" +
                "    \"PHP\": 52.918498,\n" +
                "    \"PKR\": 200.394525,\n" +
                "    \"PLN\": 4.28715,\n" +
                "    \"PYG\": 6833.928226,\n" +
                "    \"QAR\": 3.641,\n" +
                "    \"RON\": 4.6203,\n" +
                "    \"RSD\": 109.734633,\n" +
                "    \"RUB\": 61.625001,\n" +
                "    \"RWF\": 1022.112203,\n" +
                "    \"SAR\": 3.7509,\n" +
                "    \"SBD\": 8.116969,\n" +
                "    \"SCR\": 12.875388,\n" +
                "    \"SDG\": 455.5,\n" +
                "    \"SEK\": 9.780448,\n" +
                "    \"SGD\": 1.375848,\n" +
                "    \"SHP\": 0.797216,\n" +
                "    \"SLL\": 13013,\n" +
                "    \"SOS\": 583,\n" +
                "    \"SRD\": 21.6045,\n" +
                "    \"SSP\": 130.26,\n" +
                "    \"STD\": 22994,\n" +
                "    \"STN\": 23.15,\n" +
                "    \"SVC\": 8.750408,\n" +
                "    \"SYP\": 2512.53,\n" +
                "    \"SZL\": 15.324536,\n" +
                "    \"THB\": 34.361739,\n" +
                "    \"TJS\": 11.151124,\n" +
                "    \"TMT\": 3.51,\n" +
                "    \"TND\": 3.0325,\n" +
                "    \"TOP\": 2.299232,\n" +
                "    \"TRY\": 16.586,\n" +
                "    \"TTD\": 6.783227,\n" +
                "    \"TWD\": 29.371,\n" +
                "    \"TZS\": 2329,\n" +
                "    \"UAH\": 29.526473,\n" +
                "    \"UGX\": 3750.359903,\n" +
                "    \"USD\": 1,\n" +
                "    \"UYU\": 40.029645,\n" +
                "    \"UZS\": 11013.19857,\n" +
                "    \"VES\": 5.14485,\n" +
                "    \"VND\": 23185.718844,\n" +
                "    \"VUV\": 114.629832,\n" +
                "    \"WST\": 2.612952,\n" +
                "    \"XAF\": 613.192165,\n" +
                "    \"XAG\": 0.04526526,\n" +
                "    \"XAU\": 0.00054258,\n" +
                "    \"XCD\": 2.70255,\n" +
                "    \"XDR\": 0.727607,\n" +
                "    \"XOF\": 613.192165,\n" +
                "    \"XPD\": 0.00049796,\n" +
                "    \"XPF\": 111.551961,\n" +
                "    \"XPT\": 0.0009676,\n" +
                "    \"YER\": 250.249937,\n" +
                "    \"ZAR\": 15.41414,\n" +
                "    \"ZMW\": 16.900676,\n" +
                "    \"ZWL\": 322\n" +
                "  }\n" +
                "}";
        in.close();

        in = new BufferedReader(new FileReader("/Users/gusevang/Downloads/CurrencyGifProviding1/src/test/java/com/example/currencygifproviding/controller/curTom"));
        while (in.readLine() != null) {
            sb.append(in.readLine()).append("\n");
        }

        String curTom = "{\n" +
                "  \"disclaimer\": \"Usage subject to terms: https://openexchangerates.org/terms\",\n" +
                "  \"license\": \"https://openexchangerates.org/license\",\n" +
                "  \"timestamp\": 1654473599,\n" +
                "  \"base\": \"USD\",\n" +
                "  \"rates\": {\n" +
                "    \"AED\": 3.67302,\n" +
                "    \"AFN\": 89.065173,\n" +
                "    \"ALL\": 112.228613,\n" +
                "    \"AMD\": 447.269866,\n" +
                "    \"ANG\": 1.805741,\n" +
                "    \"AOA\": 426.1758,\n" +
                "    \"ARS\": 120.610895,\n" +
                "    \"AUD\": 1.388785,\n" +
                "    \"AWG\": 1.8005,\n" +
                "    \"AZN\": 1.7,\n" +
                "    \"BAM\": 1.824519,\n" +
                "    \"BBD\": 2,\n" +
                "    \"BDT\": 89.20903,\n" +
                "    \"BGN\": 1.82326,\n" +
                "    \"BHD\": 0.37757,\n" +
                "    \"BIF\": 2054.210622,\n" +
                "    \"BMD\": 1,\n" +
                "    \"BND\": 1.376531,\n" +
                "    \"BOB\": 6.898421,\n" +
                "    \"BRL\": 4.775,\n" +
                "    \"BSD\": 1,\n" +
                "    \"BTC\": 0.000033438893,\n" +
                "    \"BTN\": 77.768691,\n" +
                "    \"BWP\": 11.999496,\n" +
                "    \"BYN\": 3.38321,\n" +
                "    \"BZD\": 2.019646,\n" +
                "    \"CAD\": 1.25882,\n" +
                "    \"CDF\": 2003.769348,\n" +
                "    \"CHF\": 0.962329,\n" +
                "    \"CLF\": 0.029421,\n" +
                "    \"CLP\": 811.81,\n" +
                "    \"CNH\": 6.64457,\n" +
                "    \"CNY\": 6.6603,\n" +
                "    \"COP\": 3779.434618,\n" +
                "    \"CRC\": 684.124098,\n" +
                "    \"CUC\": 1,\n" +
                "    \"CUP\": 25.75,\n" +
                "    \"CVE\": 103.3,\n" +
                "    \"CZK\": 23.0047,\n" +
                "    \"DJF\": 178.408038,\n" +
                "    \"DKK\": 6.935386,\n" +
                "    \"DOP\": 55.206161,\n" +
                "    \"DZD\": 145.577934,\n" +
                "    \"EGP\": 18.6204,\n" +
                "    \"ERN\": 15.000001,\n" +
                "    \"ETB\": 51.979526,\n" +
                "    \"EUR\": 0.932444,\n" +
                "    \"FJD\": 2.14444,\n" +
                "    \"FKP\": 0.800621,\n" +
                "    \"GBP\": 0.800621,\n" +
                "    \"GEL\": 2.965,\n" +
                "    \"GGP\": 0.800621,\n" +
                "    \"GHS\": 7.832265,\n" +
                "    \"GIP\": 0.800621,\n" +
                "    \"GMD\": 54.15,\n" +
                "    \"GNF\": 8862.614397,\n" +
                "    \"GTQ\": 7.710011,\n" +
                "    \"GYD\": 209.623421,\n" +
                "    \"HKD\": 7.84595,\n" +
                "    \"HNL\": 24.610314,\n" +
                "    \"HRK\": 7.020118,\n" +
                "    \"HTG\": 114.223324,\n" +
                "    \"HUF\": 366.56271,\n" +
                "    \"IDR\": 14437.654843,\n" +
                "    \"ILS\": 3.334714,\n" +
                "    \"IMP\": 0.800621,\n" +
                "    \"INR\": 77.694457,\n" +
                "    \"IQD\": 1461.782852,\n" +
                "    \"IRR\": 42300,\n" +
                "    \"ISK\": 128.95,\n" +
                "    \"JEP\": 0.800621,\n" +
                "    \"JMD\": 154.180666,\n" +
                "    \"JOD\": 0.7102,\n" +
                "    \"JPY\": 130.73433333,\n" +
                "    \"KES\": 116.98,\n" +
                "    \"KGS\": 79.525751,\n" +
                "    \"KHR\": 4067.148174,\n" +
                "    \"KMF\": 458.749854,\n" +
                "    \"KPW\": 900,\n" +
                "    \"KRW\": 1251.531966,\n" +
                "    \"KWD\": 0.306239,\n" +
                "    \"KYD\": 0.834911,\n" +
                "    \"KZT\": 435.599831,\n" +
                "    \"LAK\": 13975.742895,\n" +
                "    \"LBP\": 1515.374977,\n" +
                "    \"LKR\": 361.204622,\n" +
                "    \"LRD\": 151.999978,\n" +
                "    \"LSL\": 15.500114,\n" +
                "    \"LYD\": 4.782838,\n" +
                "    \"MAD\": 9.870982,\n" +
                "    \"MDL\": 19.051751,\n" +
                "    \"MGA\": 4043.340527,\n" +
                "    \"MKD\": 57.492275,\n" +
                "    \"MMK\": 1855.118735,\n" +
                "    \"MNT\": 3105.3554,\n" +
                "    \"MOP\": 8.095189,\n" +
                "    \"MRU\": 36.520378,\n" +
                "    \"MUR\": 43.149999,\n" +
                "    \"MVR\": 15.435,\n" +
                "    \"MWK\": 816.25,\n" +
                "    \"MXN\": 19.5482,\n" +
                "    \"MYR\": 4.391,\n" +
                "    \"MZN\": 63.850001,\n" +
                "    \"NAD\": 15.49,\n" +
                "    \"NGN\": 415.12,\n" +
                "    \"NIO\": 35.899877,\n" +
                "    \"NOK\": 9.43613,\n" +
                "    \"NPR\": 124.429799,\n" +
                "    \"NZD\": 1.537007,\n" +
                "    \"OMR\": 0.385026,\n" +
                "    \"PAB\": 1,\n" +
                "    \"PEN\": 3.711755,\n" +
                "    \"PGK\": 3.529407,\n" +
                "    \"PHP\": 52.929,\n" +
                "    \"PKR\": 198.029238,\n" +
                "    \"PLN\": 4.278652,\n" +
                "    \"PYG\": 6861.311273,\n" +
                "    \"QAR\": 3.644742,\n" +
                "    \"RON\": 4.6095,\n" +
                "    \"RSD\": 109.53531,\n" +
                "    \"RUB\": 63.250003,\n" +
                "    \"RWF\": 1023.656283,\n" +
                "    \"SAR\": 3.7509,\n" +
                "    \"SBD\": 8.116969,\n" +
                "    \"SCR\": 12.991898,\n" +
                "    \"SDG\": 455.5,\n" +
                "    \"SEK\": 9.764864,\n" +
                "    \"SGD\": 1.3753,\n" +
                "    \"SHP\": 0.800621,\n" +
                "    \"SLL\": 12887.2,\n" +
                "    \"SOS\": 580.952629,\n" +
                "    \"SRD\": 21.353,\n" +
                "    \"SSP\": 130.26,\n" +
                "    \"STD\": 22994,\n" +
                "    \"STN\": 23.15,\n" +
                "    \"SVC\": 8.767037,\n" +
                "    \"SYP\": 2512.53,\n" +
                "    \"SZL\": 15.507825,\n" +
                "    \"THB\": 34.275805,\n" +
                "    \"TJS\": 11.221863,\n" +
                "    \"TMT\": 3.51,\n" +
                "    \"TND\": 3.02,\n" +
                "    \"TOP\": 2.299232,\n" +
                "    \"TRY\": 16.508624,\n" +
                "    \"TTD\": 6.791608,\n" +
                "    \"TWD\": 29.375999,\n" +
                "    \"TZS\": 2331.549,\n" +
                "    \"UAH\": 29.457448,\n" +
                "    \"UGX\": 3745.800949,\n" +
                "    \"USD\": 1,\n" +
                "    \"UYU\": 40.08566,\n" +
                "    \"UZS\": 11015.758723,\n" +
                "    \"VES\": 5.14485,\n" +
                "    \"VND\": 23191.095867,\n" +
                "    \"VUV\": 114.629832,\n" +
                "    \"WST\": 2.612952,\n" +
                "    \"XAF\": 611.643445,\n" +
                "    \"XAG\": 0.04562356,\n" +
                "    \"XAU\": 0.00054004,\n" +
                "    \"XCD\": 2.70255,\n" +
                "    \"XDR\": 0.727495,\n" +
                "    \"XOF\": 611.643445,\n" +
                "    \"XPD\": 0.00050392,\n" +
                "    \"XPF\": 111.270217,\n" +
                "    \"XPT\": 0.00098136,\n" +
                "    \"YER\": 250.249937,\n" +
                "    \"ZAR\": 15.549,\n" +
                "    \"ZMW\": 17.033219,\n" +
                "    \"ZWL\": 322\n" +
                "  }\n" +
                "}";
        in.close();

        in = new BufferedReader(new FileReader("/Users/gusevang/Downloads/CurrencyGifProviding1/src/test/java/com/example/currencygifproviding/controller/gifTestJSON"));
        while (in.readLine() != null) {
            sb.append(in.readLine()).append("\n");
        }

        String gifTestJSON = "{\n" +
                "\t\"data\": {\n" +
                "\t\t\"type\": \"gif\",\n" +
                "\t\t\"id\": \"5sYr9aizhcehIIoT4S\",\n" +
                "\t\t\"url\": \"https://giphy.com/gifs/1stLookTV-bananas-johnny-1st-look-5sYr9aizhcehIIoT4S\",\n" +
                "\t\t\"slug\": \"1stLookTV-bananas-johnny-1st-look-5sYr9aizhcehIIoT4S\",\n" +
                "\t\t\"bitly_gif_url\": \"https://gph.is/2CGslVE\",\n" +
                "\t\t\"bitly_url\": \"https://gph.is/2CGslVE\",\n" +
                "\t\t\"embed_url\": \"https://giphy.com/embed/5sYr9aizhcehIIoT4S\",\n" +
                "\t\t\"username\": \"1stLookTV\",\n" +
                "\t\t\"source\": \"\",\n" +
                "\t\t\"title\": \"the challenge payday GIF by 1st Look\",\n" +
                "\t\t\"rating\": \"g\",\n" +
                "\t\t\"content_url\": \"\",\n" +
                "\t\t\"source_tld\": \"\",\n" +
                "\t\t\"source_post_url\": \"\",\n" +
                "\t\t\"is_sticker\": 0,\n" +
                "\t\t\"import_datetime\": \"2019-01-22 17:13:55\",\n" +
                "\t\t\"trending_datetime\": \"0000-00-00 00:00:00\",\n" +
                "\t\t\"images\": {\n" +
                "\t\t\t\"original\": {\n" +
                "\t\t\t\t\"height\": \"450\",\n" +
                "\t\t\t\t\"width\": \"600\",\n" +
                "\t\t\t\t\"size\": \"3523215\",\n" +
                "\t\t\t\t\"url\": \"https://media1.giphy.com/media/5sYr9aizhcehIIoT4S/giphy.gif?cid=74dcbbc8ienxw71m1b14gjirx54v3uwsltzau0eyqq6ipwk7&rid=giphy.gif&ct=g\",\n" +
                "\t\t\t\t\"mp4_size\": \"1221571\",\n" +
                "\t\t\t\t\"mp4\": \"https://media1.giphy.com/media/5sYr9aizhcehIIoT4S/giphy.mp4?cid=74dcbbc8ienxw71m1b14gjirx54v3uwsltzau0eyqq6ipwk7&rid=giphy.mp4&ct=g\",\n" +
                "\t\t\t\t\"webp_size\": \"2986566\",\n" +
                "\t\t\t\t\"webp\": \"https://media1.giphy.com/media/5sYr9aizhcehIIoT4S/giphy.webp?cid=74dcbbc8ienxw71m1b14gjirx54v3uwsltzau0eyqq6ipwk7&rid=giphy.webp&ct=g\",\n" +
                "\t\t\t\t\"frames\": \"62\",\n" +
                "\t\t\t\t\"hash\": \"f8066a80d3db4155e3b8d01ffc8191fe\"\n" +
                "\t\t\t},\n" +
                "\t\t\t\"downsized\": {\n" +
                "\t\t\t\t\"height\": \"302\",\n" +
                "\t\t\t\t\"width\": \"403\",\n" +
                "\t\t\t\t\"size\": \"1723511\",\n" +
                "\t\t\t\t\"url\": \"https://media1.giphy.com/media/5sYr9aizhcehIIoT4S/giphy-downsized.gif?cid=74dcbbc8ienxw71m1b14gjirx54v3uwsltzau0eyqq6ipwk7&rid=giphy-downsized.gif&ct=g\"\n" +
                "\t\t\t}\n" +
                "\t\t},\n" +
                "\t\t\"pagination\": {\n" +
                "\t\t\t\"total_count\": 8936,\n" +
                "\t\t\t\"count\": 1,\n" +
                "\t\t\t\"offset\": 100\n" +
                "\t\t},\n" +
                "\t\t\"meta\": {\n" +
                "\t\t\t\"status\": 200,\n" +
                "\t\t\t\"msg\": \"OK\",\n" +
                "\t\t\t\"response_id\": \"ienxw71m1b14gjirx54v3uwsltzau0eyqq6ipwk7\"\n" +
                "\t\t}\n" +
                "\t}\n" +
                "}";
        in.close();

        Mockito.when(gifClient.getGifFromCuurencyMovement(eq("rich"), isA(Integer.class), isA(String.class))).thenReturn(gifTestJSON);
        Mockito.when(gifClient.getGifFromCuurencyMovement(eq("broke"), isA(Integer.class), isA(String.class))).thenReturn(gifTestJSON);

        Mockito.when(currencyClient.getPrice(
                        any()))
                .thenReturn(curToday)
                .thenReturn(curTom);

        userController.getCurrencyPriceChanging("anyCur", model);
        assertEquals(null,model.getAttribute("gifURL"));


        mockMvc.perform(
                    get("/api/check/price/movement/AED")
                )
                .andExpect(status().isOk())
                .andExpect(model().attribute("curName","AED"))
                .andExpect((model().attribute("gifURL","https://media1.giphy.com/media/5sYr9aizhcehIIoT4S/giphy.gif?cid=74dcbbc8ienxw71m1b14gjirx54v3uwsltzau0eyqq6ipwk7&rid=giphy.gif&ct=g")));
    }


}
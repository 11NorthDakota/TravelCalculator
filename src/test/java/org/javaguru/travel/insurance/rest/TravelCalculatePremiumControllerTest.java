package org.javaguru.travel.insurance.rest;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class TravelCalculatePremiumControllerTest {

    @Autowired
    private JsonFileReader jsonFileReader;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void restControllerWhenFirstNameIsNullTest() throws Exception {
        doExecuteAndExpect("rest/PersonFirstNameRequest.json"
                , "rest/PersonFirstNameResponse.json");
    }

    @Test
    void restControllerWhenLastNameIsNullTest() throws Exception {
        doExecuteAndExpect("rest/PersonLastNameRequest.json",
                "rest/PersonLastNameResponse.json");
    }

    @Test
    void restControllerWhenAgreementDateFromIsNullTest() throws Exception {
        doExecuteAndExpect("rest/AgreementDateFromRequest.json",
                "rest/AgreementDateFromResponse.json");
    }

    @Test
    void restControllerWhenAgreementDateToIsNullTest() throws Exception {
        doExecuteAndExpect("rest/AgreementDateToRequest.json",
                "rest/AgreementDateToResponse.json");
    }

    @Test
    void agreementDateToShouldBeAfterAgreementDateFromTest() throws Exception {
        doExecuteAndExpect("rest/DateToAfterDateFromRequest.json",
                "rest/DateToAfterDateFromResponse.json");
    }

    @Test
    void restControllerWhenRisksNotSelected() throws Exception {
        doExecuteAndExpect("rest/SelectedRisksRequest.json",
                "rest/SelectedRisksResponse.json");
    }


    @Test
    void restControllerWhenRequestHasAllFieldsTest() throws Exception {
        doExecuteAndExpect("rest/AllFieldsRequest.json",
                "rest/AllFieldsResponse.json");

    }

    @Test
    void restControllerWhenRequestHasNoFieldsTest() throws Exception {
        doExecuteAndExpect("rest/EmptyFieldsRequest.json",
                "rest/EmptyFieldsResponse.json");
    }




    private void doExecuteAndExpect(String requestFileName, String responseFileName) throws Exception {
        String request = jsonFileReader.readFile(requestFileName);
        String response = jsonFileReader.readFile(responseFileName);
        ResultActions result = mockMvc.perform(post("/insurance/travel/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(request));
        result.andExpect(status().isOk())
                .andExpect(content().json(response));
    }

}

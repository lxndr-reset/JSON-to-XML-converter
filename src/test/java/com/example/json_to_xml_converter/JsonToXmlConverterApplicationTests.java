package com.example.json_to_xml_converter;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@AutoConfigureMockMvc
class JsonToXmlConverterApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testConversion_whenResponseIsEqualToExpected_thenTrue() throws Exception {
        String json = "{\"name\":\"John\", \"age\":20, \"address\":{\"street\":\"Wall Street\", \"city\":\"New York\"}}";

        MvcResult conversionResult = performJsonToXmlConversion(json);
        String xmlResponse = conversionResult.getResponse().getContentAsString();

        assertEquals("<address><city>New York</city><street>Wall Street</street></address><name>John</name><age>20</age>", xmlResponse);
    }

    private MvcResult performJsonToXmlConversion(String json) throws Exception {
        return mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/json-to-xml")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json)
                        .accept(MediaType.ALL))
                .andReturn();
    }

    @Test
    void testConversion_whenEmptyString_thenException() throws Exception {
        String json = "";

        MvcResult conversionResult = performJsonToXmlConversion(json);
        int statusCode = conversionResult.getResponse().getStatus();

        assertEquals(400, statusCode);
    }
}

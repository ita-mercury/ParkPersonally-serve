package com.parkpersonally.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.parkpersonally.model.Customer;
import com.parkpersonally.model.ParkingOrder;
import com.parkpersonally.model.Tag;
import com.parkpersonally.service.ParkingOrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ParkingOrderController.class)
public class ParkingOrderControllerTest {

    @MockBean
    private ParkingOrderService service;

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void should_return_new_parking_order_when_add_new_parking() throws Exception{
        Customer customer = new Customer();
        customer.setId(1);
        List<Tag> tags = new ArrayList<>();
        tags.add(new Tag("smart"));
        tags.add(new Tag("handsome"));

        ParkingOrder order = new ParkingOrder(1, 20, "南方软件园");
        order.setCustomer(customer);
        order.setTags(tags);

        given(service.createParkingOrder(any(ParkingOrder.class))).willReturn(order);

        this.mvc.perform(
                post("/parking-orders")
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .content(objectMapper.writeValueAsString(order)))
                .andExpect(status().isOk())
                .andExpect(content().string(objectMapper.writeValueAsString(order)));
    }
}

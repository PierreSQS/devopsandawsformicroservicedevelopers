package com.bharath.springcloud.controllers;

import com.bharath.springcloud.model.Flight;
import com.bharath.springcloud.repos.FlightRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(FlightController.class)
class FlightControllerTest {

    @MockBean
    FlightRepository flightRepoMock;

    @Autowired
    MockMvc mockMvc;

    @BeforeEach
    void setUp() {
    }

    @Test
    void getFlights() throws Exception{
        Flight flight1 = new Flight();
        flight1.setId(1L);
        flight1.setFlightNumber("AA1");
        flight1.setOperatingAirlines("American Airlines");
        flight1.setDepartureCity("AUS");
        flight1.setDepartureCity("NYC");
        flight1.setArrivalCity("AUS");
//        flight1.setDateOfDeparture(LocalDate.parse("02-05-2018"));
//        flight1.setEstimatedDepartureTime(LocalDateTime.parse("2018-02-05 03:14:07"));

        List<Flight> flights = List.of(flight1);

        when(flightRepoMock.findAll()).thenReturn(flights);

        mockMvc.perform(get("/flights"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].flightNumber",is(equalTo("AA1"))))
                .andDo(print());
    }
}
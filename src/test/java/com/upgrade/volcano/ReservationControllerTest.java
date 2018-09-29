package com.upgrade.volcano;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.upgrade.volcano.model.ReservationDto;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.ServletContext;

import java.nio.charset.Charset;
import java.util.Date;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON;

@SpringBootApplication
class ApplicationTest {
}


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ReservationControllerTest {

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;
    private static final MediaType JSON_CONTENT_TYPE = new MediaType(
            MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(),
            Charset.forName("utf8"));


    @Before
    public void setup() throws Exception {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @Test
    public void givenWac_whenServletContext_thenItProvidesReservationController() {
        ServletContext servletContext = wac.getServletContext();

        Assert.assertNotNull(servletContext);
        Assert.assertTrue(servletContext instanceof MockServletContext);
        Assert.assertNotNull(wac.getBean("reservationController"));
    }

    @Test
    public void givenHomePageURI_whenMockMVC_thenReturnsOk() throws Exception {
        this.mockMvc.perform(get("/"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void givenReservationsURI_whenMockMVC_emptyDatabase_thenReturnsEmpty() throws Exception {
        this.mockMvc.perform(get("/reservations"))
                .andDo(print())
                .andExpect(jsonPath("body", hasSize(0)))
                .andExpect(status().isOk());
    }

    @Test
    public void givenReservationsURI_whenMockMVC_addReservation_thenReturns204() throws Exception {

        ReservationDto reservationDto = new ReservationDto();
        reservationDto.setCustomerEmail("test@gmail.com");
        reservationDto.setArrivalDateUTC(new Date());
        ObjectMapper mapper = new ObjectMapper();
        String reservationDtoJson = mapper.writeValueAsString(reservationDto);

        this.mockMvc.perform(post("/reservations")
                .contentType(JSON_CONTENT_TYPE)
                .content(reservationDtoJson))
                .andDo(print())
                .andExpect(jsonPath("body.id", Matchers.is(Matchers.greaterThan(0))))
                .andExpect(status().is(HttpStatus.CREATED.value()));
    }

}

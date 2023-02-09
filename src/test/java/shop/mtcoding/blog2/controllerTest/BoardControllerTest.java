package shop.mtcoding.blog2.controllerTest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.mock.web.server.MockWebSession;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import shop.mtcoding.blog2.model.User;

@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = WebEnvironment.MOCK)
public class BoardControllerTest {
    
    @Autowired
    private MockMvc mvc;

    private MockHttpSession session;

    @BeforeEach
    public void setUp(){
        User mockUser = new User();
        mockUser.setId(1);
        mockUser.setUsername("ssar");
        mockUser.setPassword("1234");
        mockUser.setEmail("ssar@nate.com");

        session = new MockHttpSession();
        session.setAttribute("principal", mockUser);
    }

    @Test
    public void boardWrite_test() throws Exception{
        String req = "title=235235&content=235235";

        ResultActions rs = mvc.perform(post("/board/write").content(req)
                                                                        .contentType(MediaType.APPLICATION_FORM_URLENCODED_VALUE)
                                                                        .session(session));

        rs.andExpect(status().isOk());
    }
}

package com.company.project.controller;
import com.company.project.pojo.User;
import com.company.project.Tester;
import com.github.pagehelper.PageHelper;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


/**
* Created by CodeGenerator on 2020/04/25.
*/
public class UserControllerTest extends Tester{

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private WebApplicationContext webApplicationContext;
    private MockMvc mvc;
    private MockHttpSession session;

    @Before()  //这个方法在每个方法执行之前都会执行一遍
    public void setup() {
        mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build(); //初始化MockMvc对象.
//        mvc = MockMvcBuilders.standaloneSetup(new WebController()).build();
        session = new MockHttpSession();
    }

    @Test
    public void add() throws Exception{
         User user = new User();
                MvcResult mvcResult = (MvcResult) mvc.perform(MockMvcRequestBuilders.post("/user/add")
                .accept(MediaType.ALL)
                .session(session)
                .param("userName","").param("password","")
//                .content("".getBytes()) //传参数,最后传的形式是 Body = {"password":"admin","userName":"admin"}
                )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();

        //得到返回代码
        int status = mvcResult.getResponse().getStatus();
        //得到返回结果
        String content = mvcResult.getResponse().getContentAsString();

    }

    @Test
    public void delete() throws Exception{
            Integer id = new Integer("1");
    }

    @Test
    public void update() throws Exception{
         User user = new User();
    }

    @Test
    public void detail() throws Exception{
             Integer id = new Integer("1");
    }

    @Test
    public void list() throws Exception{
          PageHelper.startPage(0, 10);
    }
}

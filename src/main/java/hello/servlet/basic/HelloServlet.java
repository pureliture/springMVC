package hello.servlet.basic;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j
@WebServlet(name = "helloServlet", urlPatterns = "/hello")
public class HelloServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        log.debug("HelloServlet.hello");

        String userName = httpServletRequest.getParameter("username");
        log.debug("userName = {}", userName);

        httpServletResponse.setContentType("text/plain");
        httpServletResponse.setCharacterEncoding("utf-8");
        httpServletResponse.getWriter().write("hello " + userName);
    }
}

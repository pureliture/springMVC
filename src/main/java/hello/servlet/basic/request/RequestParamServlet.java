package hello.servlet.basic.request;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j
@WebServlet(name = "requestParamServlet", urlPatterns = "/request-param")
public class RequestParamServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.info("[전체 파라미터 조회] - start");

        request.getParameterNames().asIterator()
                .forEachRemaining(paramName -> log.info("{} = {}", paramName, request.getParameter(paramName)));

        log.info("[전체 파라미터 조회] - end");

        log.info("[단일 파라미터 조회]");
        String username = request.getParameter("username");
        String age = request.getParameter("age");

        log.info("username = " + username);
        log.info("age = " + age);

        log.info("[이름이 같은 복수 파라미터 조회]");
        String[] usernames = request.getParameterValues("username");

        for (String name : usernames) {
            log.info("username = " + name);
        }

        response.getWriter().write("ok");
    }
}

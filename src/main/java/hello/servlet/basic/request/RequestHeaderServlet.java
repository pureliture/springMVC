package hello.servlet.basic.request;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j
@WebServlet(name = "requestHeaderServlet", urlPatterns = "/request-header")
public class RequestHeaderServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.loggingStartLine(request);
        this.loggingAllHeaderInfo(request);
        this.loggingHeaderUtils(request);
        this.loggingEtc(request);
    }

    private void loggingStartLine(HttpServletRequest request) {
        log.info("-------------- Request-Line start --------------");
        log.info("Request Method : {}", request.getMethod());
        log.info("Request Protocol : {}", request.getProtocol());
        log.info("Request Scheme : {}", request.getScheme());
        log.info("Request URL : {}", request.getRequestURL());
        log.info("Request URI : {}", request.getRequestURI());
        log.info("Request QueryString : {}", request.getQueryString());
        log.info("Request isSecure : {}", request.isSecure());
        log.info("-------------- Request-Line end --------------");
    }

    private void loggingAllHeaderInfo(HttpServletRequest request) {
        request.getHeaderNames().asIterator()
                .forEachRemaining(headerName -> log.info("{} : {}", headerName, headerName));
    }

    private void loggingHeaderUtils(HttpServletRequest request) {
        log.info("--- Header 편의 조회 start ---");
        log.info("[Host 편의 조회]");
        log.info("request.getServerName() = " + request.getServerName()); //Host 헤더
        log.info("request.getServerPort() = " + request.getServerPort()); //Host 헤더

        log.info("[Accept-Language 편의 조회]");
        request.getLocales().asIterator()
                .forEachRemaining(locale -> log.info("locale = " + locale));
        log.info("request.getLocale() = " + request.getLocale());

        log.info("[cookie 편의 조회]");
        if (request.getCookies() != null) {
            for (Cookie cookie : request.getCookies()) {
                log.info(cookie.getName() + ": " + cookie.getValue());
            }
        }

        log.info("[Content 편의 조회]");
        log.info("request.getContentType() = " + request.getContentType());
        log.info("request.getContentLength() = " + request.getContentLength());
        log.info("request.getCharacterEncoding() = " + request.getCharacterEncoding());

        log.info("--- Header 편의 조회 end ---");
    }

    //기타 정보
    private void loggingEtc(HttpServletRequest request) {
        log.info("--- 기타 조회 start ---");

        log.info("[Remote 정보]");
        log.info("request.getRemoteHost() = " + request.getRemoteHost()); //
        log.info("request.getRemoteAddr() = " + request.getRemoteAddr()); //
        log.info("request.getRemotePort() = " + request.getRemotePort()); //

        log.info("[Local 정보]");
        log.info("request.getLocalName() = " + request.getLocalName()); //
        log.info("request.getLocalAddr() = " + request.getLocalAddr()); //
        log.info("request.getLocalPort() = " + request.getLocalPort()); //

        log.info("--- 기타 조회 end ---");
    }

}

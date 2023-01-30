package ee.biceps.api.web.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;
import java.io.PrintWriter;

@WebFilter(filterName = "Authentication")
public class AuthenticationFilter implements Filter {
    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
            throws IOException, ServletException {

        System.out.println("Attempting to authenticate request...");
        boolean isAuthenticated = true;

        if (isAuthenticated) {
            chain.doFilter(req, res);
        } else {
            PrintWriter out = res.getWriter();
            out.write("Authentication error!");
        }
    }
}

package ee.biceps.api.web.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;

@WebFilter(filterName = "Security")
public class SecurityFilter implements Filter {
    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
            throws IOException, ServletException {
        System.out.println("Decrypting");

        chain.doFilter(req, res);

        System.out.println("Encrypting");

    }
}

package ee.biceps.api.web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import ee.biceps.api.db.model.Product;
import ee.biceps.api.service.ProductService;
import ee.biceps.api.service.implementation.ProductServiceImpl;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/product")
public class ProductServlet extends HttpServlet {

    private ProductService productService;
    private ObjectMapper mapper;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        productService = new ProductServiceImpl();
        mapper = new ObjectMapper();
    }

    public void doGet(HttpServletRequest req, HttpServletResponse res) {
        String path = req.getPathInfo();

        res.setContentType("applicaation/json");

        try {
            PrintWriter out = res.getWriter();
            Product product = productService.getProductByName("todo");
            String productJson = mapper.writeValueAsString(product);
            out.write(productJson);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}

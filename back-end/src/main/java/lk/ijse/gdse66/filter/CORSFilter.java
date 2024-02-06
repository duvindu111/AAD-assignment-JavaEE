package lk.ijse.gdse66.filter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "CORSFilter", urlPatterns = "/*")
public class CORSFilter extends HttpFilter {

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {

        String origin = req.getHeader("Origin");
        System.out.println(origin);
        if(origin == null){
            res.sendError(HttpServletResponse.SC_BAD_REQUEST, "CORS Policy Violation");
            return;
        }

        res.setHeader("Access-Control-Allow-Origin", origin);
        res.setHeader("Access-Control-Allow-Headers", "Content-Type");
        res.setHeader("Access-Control-Allow-Methods", "DELETE, PUT, GET, POST, OPTIONS, HEAD ");

        chain.doFilter(req, res);
    }
}

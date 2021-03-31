package com.example.demo.Filter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebFilter(filterName = "CheckCodReservFilter")
public class CheckCodReservFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        writer.println("<html><body>");
        String nationalCode = request.getParameter("nationalCode");
        if (nationalCode.matches("^\\d{5}$")) {
            chain.doFilter(request, response);
        } else {
            writer.println("Error:Code Reserve is incorrect");
            request.getRequestDispatcher("index.jsp").include(request, response);
        }
        writer.println("</body></html>");
        writer.close();
    }
}


package edu.mum.cs;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Calculator", urlPatterns = {"/calculate"})
public class CalculatorServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            PrintWriter out = response.getWriter();

            out.println("<html><body>");
            if (request.getParameter("first_sum").equals("") || request.getParameter("second_sum").equals("")) {
                out.println("<span></span>" + "<br/>");
            } else {
                int a = Integer.parseInt(request.getParameter("first_sum"));
                int b = Integer.parseInt(request.getParameter("second_sum"));
                int sum = a + b;
                out.println("<span>" + a + "+" + b + "=" + sum + "</span>" + "<br/>");
            }

            if (request.getParameter("first_mult").equals("") || request.getParameter("second_mult").equals("")) {
                out.println("<span></span>" + "<br/>");
            } else {
                int c = Integer.parseInt(request.getParameter("first_mult"));
                int d = Integer.parseInt(request.getParameter("second_mult"));
                int mult = c * d;
                out.println("<span>" + c + "*" + d + "=" + mult + "</span>");
            }
            out.println("</body></html>");

        } catch (NumberFormatException e) {
            // log exception and / or notify user
            System.out.println("At least one invalid number in the given numbers: " + request.getParameter("first_sum") + ", " + request.getParameter("second_sum"));
            e.printStackTrace();
            // show an error message to the user somewhere in your frontend
            response.getWriter().println("<span>error</span>");
        }
    }
}


package edu.mum.cs;

import model.Quiz;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "QuizServletJSP", urlPatterns = {"/quizJsp"})
public class QuizServletJSP extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();
        Quiz quiz;
        if(session.getAttribute("quiz") ==  null){
            quiz =  new Quiz();
            session.setAttribute("quiz",quiz);
        }else{
            String answer = request.getParameter("answer");
            quiz = (Quiz)session.getAttribute("quiz");
            quiz.checkAnswer(answer);
            session.setAttribute("quiz", quiz);
        }

        if(quiz.endOfQuestion())
            request.getRequestDispatcher("success.jsp").forward(request, response);
        else
            request.getRequestDispatcher("home.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        this.doPost(request, response);
    }
}

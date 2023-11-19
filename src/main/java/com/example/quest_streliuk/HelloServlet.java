package com.example.quest_streliuk;

import java.io.*;

import com.example.quest_streliuk.model.Node;
import com.example.quest_streliuk.model.Quizzes;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import static java.lang.System.out;

//@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;
    public static String actualQwestion;
    public static  Node nextNode;
    public static String question;
    public static String action_resp;
    public  static  Quizzes quizzes = Quizzes.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");

        String question = (String) req.getAttribute("question");
        Quizzes quizzes = Quizzes.getInstance();
        Node nextNode = quizzes.findNextNode(question);

        req.setAttribute("question", nextNode.getLeft().getValue());

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/indexjsp.jsp");
        requestDispatcher.forward(req, resp);

    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        question     = req.getParameter("question");
        action_resp  = (String) req.getAttribute("action_resp");

        if(question !=null ){

            nextNode = quizzes.findNextNode(actualQwestion);

                if (question.contains("1"))
                {
                    if (nextNode.getLeft() != null) {
                        actualQwestion = nextNode.getLeft().getValue();
                    } else {
                        actualQwestion = nextNode.getValue();
                    }
                }
                if (question.contains("2")) {
                    if (nextNode.getRight() != null) {
                        actualQwestion = nextNode.getRight().getValue();
                    } else {
                        actualQwestion = nextNode.getValue();
                    }
                }

            req.setAttribute("action_resp", actualQwestion);
        } else {
            actualQwestion =  quizzes.getRoot().getValue();
            req.setAttribute("action_resp", actualQwestion);
        }

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/indexjsp.jsp");
        requestDispatcher.forward(req, resp);

    }

}
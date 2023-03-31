package com.thomas.finalgolfappproject;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ServletScoreCard", value = "/ServletScoreCard")
public class ServletScoreCard extends HttpServlet {
    protected static int hole1;
    protected static int hole2;
    protected static int hole3;
    protected static int hole4;
    protected static int hole5;
    protected static int hole6;
    protected static int hole7;
    protected static int hole8;
    protected static int hole9;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("Doesn't Work");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        out.println("<html><head>" + "<link rel='stylesheet' href='golf_style.css'>" + "</head><body>");

        int hole1 = Integer.parseInt(request.getParameter("hole1"));
        int hole2 = Integer.parseInt(request.getParameter("hole2"));
        int hole3 = Integer.parseInt(request.getParameter("hole3"));
        int hole4 = Integer.parseInt(request.getParameter("hole4"));
        int hole5 = Integer.parseInt(request.getParameter("hole5"));
        int hole6 = Integer.parseInt(request.getParameter("hole6"));
        int hole7 = Integer.parseInt(request.getParameter("hole7"));
        int hole8 = Integer.parseInt(request.getParameter("hole8"));
        int hole9 = Integer.parseInt(request.getParameter("hole9"));

        int coursescore = Integer.parseInt(String.valueOf((hole1 + hole2 + hole3 + hole4 + hole5 + hole6 + hole7 + hole8 + hole9)));

        out.println("<p> hello </p>");

        out.println("<h1>Course Score</h1>");
        out.println("<table>");
        out.println("<tr><th>Hole 1</th><th>Hole 2</th><th>Hole 3</th><th>Hole 4</th><th>Hole 5</th><th>Hole 6</th><th>Hole 7</th><th>Hole 8</th><th>Hole 9</th><th> </th><th>Total</th</tr>");
        out.println("<tr><td>" + hole1 + "</td><td>" + hole2 + "</td><td>" + hole3 + "</td><td>" + hole4 + "</td><td>" + hole5 + "</td><td>" + hole6 + "</td><td>" + hole7 + "</td><td>" + hole8 + "</td><td>" + hole9 + "</td><td>" + " " + "</td><td>" + coursescore + "</td></tr>");
        out.println("</table>");


        out.println("</body></html>");


    }


}

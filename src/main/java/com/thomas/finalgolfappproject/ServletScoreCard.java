package com.thomas.finalgolfappproject;

import entity.Skyway;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

@WebServlet(name = "ServletScoreCard", value = "/ServletScoreCard")
public class ServletScoreCard extends HttpServlet {


    //
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {


        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        out.println("<html><head>" + "<link rel='stylesheet' href='table_style.css'>" + "</head><body>");

        int[] array = new int[9];
        int coursescore = 0;
        for(int i = 0;i<9;i++){
            array[i] = Integer.parseInt(request.getParameter("hole"+(i+1)));
            coursescore += array[i];
        }
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        //step 1 create model object
        Skyway stroke = new Skyway(array);


        try {
            transaction.begin();
            entityManager.persist(stroke);

            transaction.commit();
        } finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            entityManager.close();
            entityManagerFactory.close();
        }




        out.println("<h1>Course Score</h1>");
        out.println("<table>");
        out.println("<tr><th>Hole 1</th><th>Hole 2</th><th>Hole 3</th><th>Hole 4</th><th>Hole 5</th><th>Hole 6</th><th>Hole 7</th><th>Hole 8</th><th>Hole 9</th><th>Total</th</tr>");
        out.print("<tr>");
        for (int i=0;i<9;i++){

            out.println("<td>" + array[i] + "</td>");

        }
        out.println("<td>" + coursescore + "</td>");
        out.print("</tr>");
        out.println("</table>");


        out.println("</body></html>");


    }


}



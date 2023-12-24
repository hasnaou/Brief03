package com.example.gestion_commandes;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tools.TonConnection;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public LoginServlet() {
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();

        try (Connection con = TonConnection.getConnection()) {
            if (con != null) {
                String gmail = request.getParameter("gmail");
                String passWord = request.getParameter("passWord");

                try (PreparedStatement ps = con.prepareStatement("SELECT * FROM admin WHERE gmail = ? AND passWord = ?")) {
                    ps.setString(1, gmail);
                    ps.setString(2, passWord);

                    try (ResultSet rs = ps.executeQuery()) {
                        if (rs.next()) {
                            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
                            rd.forward(request, response);
                        } else {
                            out.println("<font color=red size=18>Login Failed!!<br> ");
                            out.println("<a href=login.jsp> Try Again </a>");
                        }
                    }
                }
            } else {
                out.println("<font color=red size=18>Failed to connect to the database!<br> ");
                out.println("<a href=login.jsp> Try Again </a>");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

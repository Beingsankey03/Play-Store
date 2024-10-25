<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.example.demo.model.App"%>
<%@ page import="java.sql.*" %> <!-- Import necessary classes for database connection -->
<%
    String appId = request.getParameter("appId");
    String content = request.getParameter("content");

    // Assume you have a method to connect to your database
    Connection conn = null;
    PreparedStatement stmt = null;

    try {
        // Database connection logic (adjust according to your setup)
        Class.forName("com.mysql.cj.jdbc.Driver"); // Example for MySQL
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "root");

        String sql = "INSERT INTO reviews (app_id, content) VALUES (?, ?)";
        stmt = conn.prepareStatement(sql);
        stmt.setString(1, appId);
        stmt.setString(2, content);

        int rowsInserted = stmt.executeUpdate();
        if (rowsInserted > 0) {
            // Redirect to success page
            response.sendRedirect("addreviewsuccess.jsp");
        } else {
            // Handle the error case
            out.println("<h2>Failed to add review. Please try again.</h2>");
            out.println("<a href='addreview.jsp'>Go Back</a>");
        }
    } catch (Exception e) {
        e.printStackTrace();
        out.println("<h2>An error occurred. Please try again.</h2>");
        out.println("<a href='addreview.jsp'>Go Back</a>");
    } finally {
        // Clean up resources
        if (stmt != null) try { stmt.close(); } catch (SQLException ignore) {}
        if (conn != null) try { conn.close(); } catch (SQLException ignore) {}
    }
%>

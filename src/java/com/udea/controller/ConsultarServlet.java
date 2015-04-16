/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author jorgel.diaz
 */
@MultipartConfig(maxFileSize = 16177215)
public class ConsultarServlet extends HttpServlet {

    private String dbURL = "jdbc:mysql://localhost:3306/archivo";
    private String dbUser = "root";
    private String dbPass = "";

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ParseException {
        response.setContentType("text/html;charset=UTF-8");

        String firstName = request.getParameter("firstName").toUpperCase();
        /*String lastName = request.getParameter("lastName");
         String age = request.getParameter("age");
         String weight = request.getParameter("weight");
         String height = request.getParameter("height");
         String position = request.getParameter("position");*/

        //InputStream inputStream = null;
        /*
         // Obtener el archivo en partes a traves de una petición Multipart
         Part filePart = request.getPart("photo");

         if (filePart != null) {

         // Información para Debug
         System.out.println(filePart.getName());
         System.out.println(filePart.getSize());
         System.out.println(filePart.getContentType());

         // Obtener el InputStream del Archivo Subido
         inputStream = filePart.getInputStream();
         }*/
        Connection conn = null;
        String message = "";

        try {
            // Conectar la BD
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            conn = DriverManager.getConnection(dbURL, dbUser, dbPass);
            /*
             // Construir un estamento en SQL
             String sql = "INSERT INTO contacts(first_name,last_name,age,height,weight,position,photo)values(?,?,?,?,?,?,?)";          
             PreparedStatement statement = conn.prepareStatement(sql);
             */
            String selectSQL = "SELECT first_name,last_name,age,height,weight,position,born,photo FROM contacts WHERE first_name=?";
            PreparedStatement pStatement = conn.prepareStatement(selectSQL);
            pStatement.setString(1, firstName);
            ResultSet rs = pStatement.executeQuery();
            ArrayList lista = new ArrayList();
            while (rs.next()) {
                for (int x = 1; x <= rs.getMetaData().getColumnCount(); x++) {
                    lista.add(rs.getString(x));
                    System.out.print(rs.getString(x) + "\t");
                }
            }
            for (int i = 0; i < lista.size(); i++) {
                message = message + lista.get(i) +  ",";
            }
            /*
            
             */

            /*
            
             statement.setString(1, firstName);
             statement.setString(2, lastName);
             statement.setString(3, age);
             statement.setString(4, height);
             statement.setString(5, weight);
             statement.setString(6, position);

             if (inputStream != null) {
             statement.setBlob(7, inputStream);
             }

             // Enviar el estamento al servidor de BD
             int row = pStatement.executeUpdate();
             if (row > 0) {
             message = "TODO BIEN, SIN ERRORES";
             }*/
        } catch (SQLException ex) {
            message = "ERROR: " + ex.getMessage();
            ex.printStackTrace();
        } finally {

            // Cerramos la conexion a la BD
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
        // Setear el mensaje en el ambito del Request
        request.setAttribute("Message", message);

        // Forward a la pagina del mensaje
        getServletContext().getRequestDispatcher("/Message.jsp").forward(request, response);

    }

// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ConsultarServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(ConsultarServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ConsultarServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(ConsultarServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

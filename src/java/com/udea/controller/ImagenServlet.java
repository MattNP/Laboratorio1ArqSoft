/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jorgel.diaz
 */
public class ImagenServlet extends HttpServlet {

    private String dbURL = "jdbc:mysql://localhost:3306/archivo";//Configurar segun su Base de datos.
    private String dbUser = "root";
    private String dbPass = "root";//Configurar si su Base de datos requiere Password

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
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String idJugador = request.getParameter("jugador");
        Blob img;
        OutputStream os = null;
        byte[] buffer = null;

        Connection conn = null;
        String message = "";

        try {
            // Conectar la BD
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            conn = DriverManager.getConnection(dbURL, dbUser, dbPass);

            // Construir un estamento en SQL
            String selectSQL = "SELECT photo FROM contacts WHERE contact_id=?";
            PreparedStatement pStatement = conn.prepareStatement(selectSQL);
            pStatement.setString(1, idJugador);
            ResultSet rs = pStatement.executeQuery();

            if (rs.next()) {
                img = rs.getBlob(1);
                buffer = img.getBytes(1, (int) img.length());
            }

            response.setContentType("image/png");
            os = response.getOutputStream();
            os.write(buffer);
            os.flush();
            os.close();
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

    }
    /*img = rs.getBlob(8);
     imgData = img.getBytes(1, (int) img.length());
     }
     is.close();
     aux.flush();
     aux.close();
         

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
        processRequest(request, response);
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
        processRequest(request, response);
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

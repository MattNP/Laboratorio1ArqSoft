/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.controller;

import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jorgel.diaz
 */
@MultipartConfig(maxFileSize = 16177215)
public class ConsultarServlet extends HttpServlet {

    private String dbURL = "jdbc:mysql://localhost:3306/archivo";//Cambie archivo por Archivo
    private String dbUser = "root";
    private String dbPass = "";
    private Blob img;
    byte[] imgData = null;
    private ArrayList<String> lista;

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
        Connection conn = null;
        String message = "";

        try {
            // Conectar la BD
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            conn = DriverManager.getConnection(dbURL, dbUser, dbPass);

            // Construir un estamento en SQL
            String selectSQL = "SELECT first_name,last_name,age,height,weight,position,born,photo FROM contacts WHERE first_name=?";
            PreparedStatement pStatement = conn.prepareStatement(selectSQL);
            pStatement.setString(1, firstName);
            ResultSet rs = pStatement.executeQuery();

            lista = new ArrayList<>();

            //Se carga el vector lista con los datos cada columna
            while (rs.next()) {
                for (int x = 1; x <= rs.getMetaData().getColumnCount(); x++) {
                    lista.add(rs.getString(x));
                }
                img = rs.getBlob(8);
                imgData = img.getBytes(1, (int) img.length());
            }

            if(rs==null){
                message = "El jugador no ha sido encontrado en el Album Virtual";                
            }
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
        request.setAttribute("lista", lista);
        request.setAttribute("message", message);
        request.setAttribute("imgData", imgData);

        // Forward a la pagina del mensaje
        getServletContext().getRequestDispatcher("/Consulta.jsp").forward(request, response);

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

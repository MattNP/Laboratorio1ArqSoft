/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.controller;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author esteban.catanoe
 */
@MultipartConfig(maxFileSize = 16177215)
public class SubirServlet extends HttpServlet {

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

        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String age = request.getParameter("age");
        String weight = request.getParameter("weight");
        String height = request.getParameter("height");
        String position = request.getParameter("position");
        String born = request.getParameter("born");

        if (validarString(firstName) == false) {
            // Setear el mensaje en el ambito del Request
            request.setAttribute("Message", "El atributo Nombre contiene errores por favor corregirlos");

            // Forward a la pagina del mensaje
            getServletContext().getRequestDispatcher("/Message.jsp").forward(request, response);
            return;
        }

        if (validarString(lastName) == false) {
            // Setear el mensaje en el ambito del Request
            request.setAttribute("Message", "El atributo Apellido contiene errores por favor corregirlos");

            // Forward a la pagina del mensaje
            getServletContext().getRequestDispatcher("/Message.jsp").forward(request, response);
            return;
        }

        if (validarNumero(age) == false) {
            // Setear el mensaje en el ambito del Request
            request.setAttribute("Message", "El atributo Edad contiene errores por favor corregirlos");

            // Forward a la pagina del mensaje
            getServletContext().getRequestDispatcher("/Message.jsp").forward(request, response);
            return;
        }

        if (validarNumero(weight) == false) {
            // Setear el mensaje en el ambito del Request
            request.setAttribute("Message", "El atributo Peso contiene errores por favor corregirlos");

            // Forward a la pagina del mensaje
            getServletContext().getRequestDispatcher("/Message.jsp").forward(request, response);
            return;
        }

        if (validarNumero(height) == false) {
            // Setear el mensaje en el ambito del Request
            request.setAttribute("Message", "El atributo Estatura contiene errores por favor corregirlos");

            // Forward a la pagina del mensaje
            getServletContext().getRequestDispatcher("/Message.jsp").forward(request, response);
            return;
        }

        if (validarString(position) == false) {
            // Setear el mensaje en el ambito del Request
            request.setAttribute("Message", "El atributo Posicion contiene errores por favor corregirlos");

            // Forward a la pagina del mensaje
            getServletContext().getRequestDispatcher("/Message.jsp").forward(request, response);
            return;
        }

        if (validarFecha(born) == false) {
         // Setear el mensaje en el ambito del Request
         request.setAttribute("Message", "El atributo Fecha Nacimiento contiene errores por favor corregirlos");

         // Forward a la pagina del mensaje
         getServletContext().getRequestDispatcher("/Message.jsp").forward(request, response);
         return;
         }
        InputStream inputStream = null;

        // Obtener el archivo en partes a traves de una petición Multipart
        Part filePart = request.getPart("photo");

        if (filePart != null) {

            // Información para Debug
            System.out.println(filePart.getName());
            System.out.println(filePart.getSize());
            System.out.println(filePart.getContentType());

            // Obtener el InputStream del Archivo Subido
            inputStream = filePart.getInputStream();
        }

        Connection conn = null;
        String message = null;

        try {
            // Conectar la BD
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            conn = DriverManager.getConnection(dbURL, dbUser, dbPass);

            // Construir un estamento en SQL
            String sql = "INSERT INTO contacts(first_name,last_name,age,height,weight,position,born,photo)values(?,?,?,?,?,?,?,?)";
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setString(1, firstName);
            statement.setString(2, lastName);
            statement.setString(3, age);
            statement.setString(4, height);
            statement.setString(5, weight);
            statement.setString(6, position);
            statement.setString(7, born);

            if (inputStream != null) {
                statement.setBlob(8, inputStream);
            }

            // Enviar el estamento al servidor de BD
            int row = statement.executeUpdate();
            if (row > 0) {
                message = "Archivo actualizado y almacenado en la BD";
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
        request.setAttribute("Message", message);

        // Forward a la pagina del mensaje
        getServletContext().getRequestDispatcher("/Message.jsp").forward(request, response);

    }

    private boolean validarString(String date) {
        char c;
        for (int i = 0; i < date.length(); i++) {
            c = date.charAt(i);
            if (Character.isLetter(c) == false) {
                return false;
            }
        }
        return true;
    }

    private boolean validarNumero(String date) {
        char c;
        for (int i = 0; i < date.length(); i++) {
            c = date.charAt(i);
            if (Character.isDigit(c) == false) {
                return false;
            }
        }
        return true;
    }

    private boolean validarFecha(String date) {
        if (date.length() != 10) {
            System.out.println("El tamaño de la fecha es diferente de 10");
            return false;
        }
        if (("-".equals("" + date.charAt(4)) == false) || ("-".equals("" + date.charAt(7)) == false)) {
            System.out.println("Error en guiones");
            return false;
        }
        String[] dateArray = date.split("-");
        String year = dateArray[0];
        String month = dateArray[1];
        String day = dateArray[2];
        System.out.println("Año " + year);
        System.out.println("Mes " + month);
        System.out.println("Dia " + day);
        /*if (year.length() != 4) {
         System.out.println("Tamaño del año diferente de cero");
         return false;
         }*/
        char y;
        for (int i = 0; i < 4; i++) {
            y = year.charAt(i);
            System.out.println(y);
            if (Character.isDigit(y) == false) {
                System.out.println("El caracter " + y + " no es un digito");
                return false;
            }
        }
        int yearInt = Integer.parseInt(year);
        Calendar today = new GregorianCalendar();
        if (yearInt < 1900 || yearInt > today.get(Calendar.YEAR)) {
            System.out.println("El año no está en el intervalo");
            return false;
        }
        /*if (month.length() != 2) {
         return false;
         }*/
        char m;
        for (int i = 0; i < 2; i++) {
            m = month.charAt(i);
            if (Character.isDigit(m) == false) {
                return false;
            }
        }
        int monthInt = Integer.parseInt(month);
        if ((monthInt >= 1 && monthInt <= 12) == false) {
            return false;
        }
        if (yearInt == today.get(Calendar.YEAR) && monthInt > (today.get(Calendar.MONTH) + 1)) {
            return false;
        }
        /*if (day.length() != 2) {
         return false;
         }*/
        char d;
        for (int i = 0; i < 2; i++) {
            d = day.charAt(i);
            if (Character.isDigit(d) == false) {
                return false;
            }
        }
        int dayInt = Integer.parseInt(day);
        System.out.println("Dia " + dayInt);
        if (monthInt == 1 && (dayInt < 1 || dayInt > 28)) {
            System.out.println("Febrero");
            return false;
        }
        if ((monthInt == 3 || monthInt == 5 || monthInt == 8 || monthInt == 10) && (dayInt < 1 || dayInt > 11)) {
            System.out.println("30 dias");
            return false;
        }
        if (dayInt < 0 && dayInt > 31) {
            System.out.println("31 dias");
            return false;
        }
        System.out.println(dayInt == today.get(Calendar.DAY_OF_MONTH));
        if (yearInt == today.get(Calendar.YEAR) && monthInt == (today.get(Calendar.MONTH) + 1) && dayInt > today.get(Calendar.DAY_OF_MONTH)) {
            return false;
        }
        return true;
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
            Logger.getLogger(SubirServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(SubirServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(SubirServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(SubirServlet.class.getName()).log(Level.SEVERE, null, ex);
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

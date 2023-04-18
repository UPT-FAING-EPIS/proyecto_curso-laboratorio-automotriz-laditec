/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlet;

import Controlador.Controlador;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
 * @author JUNIOR-PC
 */
@MultipartConfig
@WebServlet(name = "CustomServlet", urlPatterns = {"/CustomServlet"})
public class CustomServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private static final long serialVersionUID = 1L;
    private Controlador controler = new Controlador();
    private String Pathfiles = "D:\\OneDrive - UNIVERSIDAD PRIVADA DE TACNA\\Documentos\\NetBeansProjects\\HACLLaditec\\web\\images\\";
    private File uploads = new File(Pathfiles);
    private String[] extens = {".jpg", ".png", ".jpeg"};

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        

    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action=request.getParameter("action");
        switch(action){
            case "Guardarfoto":
                guardarfoto(request,response);
                break;
        }
    }

    protected void guardarfoto(HttpServletRequest request, HttpServletResponse response) {

        try {
            String id = request.getParameter("txtid");
            String formato= request.getParameter("txtformato");
            Part part = request.getPart("txtfile");
            
            if (part == null) {
                System.out.println("sube el archivo");
                return;
            }
            String Pathabsolute = "";
            try {

                String Filename ="p"+id+"."+formato;
                InputStream input = part.getInputStream();
                
                if (input != null) {
                    File file = new File(uploads, Filename);
                    Pathabsolute = file.getAbsolutePath();
                    Files.deleteIfExists(file.toPath());
                    Files.copy(input, file.toPath());
                    

                }
            } catch (IOException ex) {
                Logger.getLogger(CustomServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            response.sendRedirect("Controlador?accion=ListarRepuestos");

        } catch (IOException ex) {
            Logger.getLogger(CustomServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ServletException ex) {
            Logger.getLogger(CustomServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}

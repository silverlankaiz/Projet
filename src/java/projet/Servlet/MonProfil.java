package projet.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import projet.GestionBD;
import projet.MonProfilModel;

/**
 * Servlet permettant l'affichage de monProfil.jsp
 *
 * @author francis
 */
public class MonProfil extends HttpServlet {

    /**
     * doGet récupérant le MonProfilModel stocké dans la session et transférant
     * ses informations à la vue
     *
     * @see MonProfilModel#MonProfilModel(projet.GestionBD, java.lang.String)
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();

        String psd = (String) session.getAttribute("pseudo");
        GestionBD gestionBD = (GestionBD) session.getAttribute("gestionBD");
        
        MonProfilModel monProfil = new MonProfilModel(gestionBD, psd);

        request.setAttribute("lAmis", monProfil.lAmis);
        request.setAttribute("lDocument", monProfil.lDoc);
        request.setAttribute("lDemandeAmis", monProfil.lDemandeAmis);
        request.getRequestDispatcher("/WEB-INF/monProfil.jsp").forward(request, response);
    }
}

package br.ufg.inf.fabrica.pac.view.servlets;

import br.ufg.inf.fabrica.pac.dominio.Pacote;
import br.ufg.inf.fabrica.pac.dominio.Projeto;
import br.ufg.inf.fabrica.pac.dominio.Resposta;
import br.ufg.inf.fabrica.pac.dominio.Usuario;
import br.ufg.inf.fabrica.pac.negocio.imp.GestorDePacotes;
import br.ufg.inf.fabrica.pac.view.apoio.AtributosSessao;
import br.ufg.inf.fabrica.pac.view.apoio.util.UtilVisao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Danillo
 */
@WebServlet(name = "ServletPesquisarPacotes", urlPatterns = {"/ServletPesquisarPacotes"})
public class ServletPesquisarPacotes extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");

        try {
            HttpSession session = request.getSession();
            Usuario autor = (Usuario) session.getAttribute(AtributosSessao.USUARIO_LOGADO);
            Projeto projeto = (Projeto) session.getAttribute(AtributosSessao.PROJETO_SELECIONADO);
            GestorDePacotes gestor = GestorDePacotes.getInstance();
            Resposta<List<Pacote>> resposta = gestor.pesquisarPacotesNovos(autor, projeto.getId());
            if (!resposta.isSucesso()) {
                UtilVisao.direcionarPaginaErro(request, response, resposta.getLaudo().toString());
            } else {
                PrintWriter out = response.getWriter();
                for (Pacote pacote : resposta.getChave()) {
                    out.println("<br/>" + pacote.getId());
                }
            }
        } catch (Exception ex) {
            UtilVisao.direcionarPaginaErro(request, response, "Falha no sistema");
        }

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
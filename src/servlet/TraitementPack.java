package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pack.Pack;
import pagination.Pagination;

public class TraitementPack extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception e) {
            throw new ServletException("Erreur lors du traitement de la requête", e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception e) {
            throw new ServletException("Erreur lors du traitement de la requête", e);
        }
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws Exception {
        response.setContentType("text/html;charset=UTF-8");
        String budgetParam = request.getParameter("budget");
        String villeParam = request.getParameter("ville");

        String pageStr = request.getParameter("page");
        int page = Pagination.getPageNumber(pageStr);
        int recordsPerPage = 2;
        
        Double budget = null;

        if (budgetParam != null && !budgetParam.isEmpty()) {
            try {
                budget = Double.parseDouble(budgetParam);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }

        Pack pack = new Pack();
        List<Pack> getPack = null;

        if ((budget == null || budget == 0.0) && (villeParam == null || villeParam.isEmpty())) {
            getPack = pack.getAll();
        } else {
            getPack = pack.getAllByBudgetsOrVille(budget, villeParam);
        }

        List<Pack> paginatedList = Pagination.paginateList(getPack, page, recordsPerPage);
        int totalRecords = getPack.size();
        int totalPages = Pagination.calculateTotalPages(totalRecords, recordsPerPage);
        

        request.setAttribute("pack", paginatedList);
        request.setAttribute("currentPage", page);
        request.setAttribute("totalPages", totalPages);

        
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/pack/pack.jsp");
        dispatcher.forward(request, response);
    }

}

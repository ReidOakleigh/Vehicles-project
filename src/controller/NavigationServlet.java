package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.League;
import model.Team;

/**
 * Servlet implementation class NavigationServlet
 */
@WebServlet("/navigationServlet")
public class NavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NavigationServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String act=request.getParameter("doThisToTeam");
		String path="/viewAllTeamsServlet";
		TeamHelper dao = new TeamHelper();
		LeagueHelper lh = new LeagueHelper();
		
		if (act.equals("delete")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				Team teamToDelete = dao.searchForTeamById(tempId);
				dao.deleteTeam(teamToDelete);
			} catch (NumberFormatException e) {
				System.out.println("Forgot to select an team.");
			}
			
		} else if (act.equals("edit")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				Team teamToEdit = dao.searchForTeamById(tempId);
				request.setAttribute("teamToEdit", teamToEdit);
				League league = lh.findLeagueById(teamToEdit.getLeague().getId());
//				List<League> leagues = lh.showAllLeagues();
				request.setAttribute("league", league.getSport());
				path="/edit-team.jsp";
			} catch (NumberFormatException e) {
				System.out.println("Forgot to select an team.");
			}

			
		} else if (act.equals("add")) {
			path="/index.html";
		}
		
		getServletContext().getRequestDispatcher(path).forward(request, response);
	}

}

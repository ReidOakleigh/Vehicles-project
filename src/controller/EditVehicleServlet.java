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
 * Servlet implementation class EditItemServlet
 */
@WebServlet("/editTeamServlet")
public class EditVehicleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditVehicleServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TeamHelper dao = new TeamHelper();
		LeagueHelper lh = new LeagueHelper();
		String city = request.getParameter("city");
		String name  = request.getParameter("name");
		String sport = request.getParameter("sport");
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		
		Team teamToUpdate = dao.searchForTeamById(tempId);
		League league = lh.findLeagueBySport(sport);
		teamToUpdate.setCity(city);
		teamToUpdate.setName(name);
		teamToUpdate.setLeague(league);
		
		dao.updateTeam(teamToUpdate);
		
		getServletContext().getRequestDispatcher("/viewAllTeamsServlet").forward(request, response);
	}

}

package net.link;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Commander")
public class Commander extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Commander() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");

		String remote = request.getParameter("remoteControl");
		String command = request.getParameter("command");

		PrintWriter out = response.getWriter();

		if (validateRemote(remote)) {
			if (validateCommand(remote, command)) {
				ProcessBuilder pb = new ProcessBuilder("/usr/bin/irsend", "SEND_ONCE", remote, command);
				//ProcessBuilder pb = new ProcessBuilder("/usr/bin/whoami");
				pb.redirectErrorStream(true);
				Process x = pb.start();
				BufferedReader stdInput = new BufferedReader(new InputStreamReader(x.getInputStream()));
				BufferedReader stdError = new BufferedReader(new InputStreamReader(x.getErrorStream()));
				
				response.sendRedirect("/Nova_Tv/");
				/*
				String reply = null; 
				out.println("<html><body>");
				out.println("<h1>Remote: "+remote+"</h1>");
				out.println("<h1>Command: "+command+"</h1>");
				while ((reply = stdInput.readLine()) != null) {
					out.println("<h1>"+reply+"</h1>");
				}
				out.println("</body></html>");
				*/
			} else {
				out.println("<html><body>");
				out.println("<h1>THE COMMAND SUPPLIED IS NOT VALID!</h1>");
				out.println("</body></html>");
			}

		} else {
			out.println("<html><body>");
			out.println("<h1>THE REMOTE CONTROL PROVIDED IS NOT VALID!</h1>");
			out.println("</body></html>");
		}
		out.close();
	}

	private boolean validateRemote(String remoteControl) {
		boolean validation = false;
		if (remoteControl != null) {
			if (remoteControl.equals("OTE_TV")
					|| remoteControl.equals("NOVA_TV")
					|| remoteControl.equals("ADVANCE_ZONE1")
					|| remoteControl.equals("ADVANCE_ZONE2")
					|| remoteControl.equals("DENON_X4000")
					|| remoteControl.equals("LG_TM2792S")
					|| remoteControl.equals("SAMSUNG_UE65ES8000")) {
				validation = true;
			}
		}
		return validation;
	}

	private boolean validateCommand(String remoteControl, String command) {
		boolean validation = false;
		if (command != null) {
			switch (remoteControl) {
			case "OTE_TV":
				if (command.equals("KEY_MUTE") || command.equals("KEY_POWER")
						|| command.equals("KEY_NUMERIC_1")
						|| command.equals("KEY_NUMERIC_2")
						|| command.equals("KEY_NUMERIC_3")
						|| command.equals("KEY_NUMERIC_4")
						|| command.equals("KEY_NUMERIC_5")
						|| command.equals("KEY_NUMERIC_6")
						|| command.equals("KEY_NUMERIC_7")
						|| command.equals("KEY_NUMERIC_8")
						|| command.equals("KEY_NUMERIC_9")
						|| command.equals("KEY_PVR")
						|| command.equals("KEY_NUMERIC_0")
						|| command.equals("KEY_VCR")
						|| command.equals("KEY_FAVORITES")
						|| command.equals("KEY_EPG")
						|| command.equals("KEY_INFO")
						|| command.equals("KEY_VOLUMEUP")
						|| command.equals("KEY_VOLUMEDOWN")
						|| command.equals("KEY_OK")
						|| command.equals("KEY_CHANNELUP")
						|| command.equals("KEY_CHANNELDOWN")
						|| command.equals("KEY_UP")
						|| command.equals("KEY_DOWN")
						|| command.equals("KEY_LEFT")
						|| command.equals("KEY_RIGHT")
						|| command.equals("KEY_BACK")
						|| command.equals("KEY_MENU")
						|| command.equals("KEY_EXIT")
						|| command.equals("KEY_RED")
						|| command.equals("KEY_GREEN")
						|| command.equals("KEY_YELLOW")
						|| command.equals("KEY_BLUE")
						|| command.equals("KEY_REWIND")
						|| command.equals("KEY_PLAY")
						|| command.equals("KEY_FASTFORWARD")
						|| command.equals("KEY_STOP")
						|| command.equals("KEY_PAUSE")
						|| command.equals("KEY_RECORD")
						|| command.equals("KEY_MAIL")
						|| command.equals("KEY_RADIO")
						|| command.equals("KEY_LIST")
						|| command.equals("KEY_HELP")
						|| command.equals("KEY_SEARCH")
						|| command.equals("KEY_TUNER")) {
					validation = true;
				}
				break;
			case "NOVA_TV":
				if (command.equals("KEY_POWER") || command.equals("KEY_RADIO")
						|| command.equals("KEY_TV")
						|| command.equals("KEY_GAMES")
						|| command.equals("KEY_RESERVED")
						|| command.equals("KEY_VCR")
						|| command.equals("BTN_EXTRA")
						|| command.equals("KEY_VOLUMEUP")
						|| command.equals("KEY_VOLUMEDOWN")
						|| command.equals("KEY_CHANNELUP")
						|| command.equals("KEY_CHANNELDOWN")
						|| command.equals("KEY_UP")
						|| command.equals("KEY_DOWN")
						|| command.equals("KEY_LEFT")
						|| command.equals("KEY_RIGHT")
						|| command.equals("KEY_OK")
						|| command.equals("KEY_PROGRAM")
						|| command.equals("KEY_INFO")
						|| command.equals("KEY_EXIT")
						|| command.equals("KEY_MUTE")
						|| command.equals("KEY_LIST")
						|| command.equals("KEY_FAVORITES")
						|| command.equals("KEY_MENU")
						|| command.equals("KEY_REWIND")
						|| command.equals("KEY_PAUSE")
						|| command.equals("KEY_FASTFORWARD")
						|| command.equals("KEY_RECORD")
						|| command.equals("KEY_PLAY")
						|| command.equals("KEY_STOP")
						|| command.equals("KEY_RED")
						|| command.equals("KEY_GREEN")
						|| command.equals("KEY_YELLOW")
						|| command.equals("KEY_BLUE")
						|| command.equals("KEY_NUMERIC_1")
						|| command.equals("KEY_NUMERIC_2")
						|| command.equals("KEY_NUMERIC_3")
						|| command.equals("KEY_NUMERIC_4")
						|| command.equals("KEY_NUMERIC_5")
						|| command.equals("KEY_NUMERIC_6")
						|| command.equals("KEY_NUMERIC_7")
						|| command.equals("KEY_NUMERIC_8")
						|| command.equals("KEY_NUMERIC_9")
						|| command.equals("KEY_NUMERIC_STAR")
						|| command.equals("KEY_NUMERIC_0")
						|| command.equals("KEY_NUMERIC_POUND")) {
					validation = true;
				}
				break;
			case "ADVANCE_ZONE1":
				break;
			case "ADVANCE_ZONE2":
				break;
			case "DENON_X4000":
				break;
			case "LG_TM2792S":
				break;
			case "SAMSUNG_UE65ES8000":
				break;
			default:
				validation = false;
				break;
			}
		}
		return validation;
	}
}
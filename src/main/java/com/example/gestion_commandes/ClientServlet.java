package com.example.gestion_commandes;

import dao.ClientDao;
import dao.IClientDao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Client;
import models.ClientModel;

import java.util.List;

import java.io.IOException;
import java.rmi.server.ServerCloneException;
import java.sql.SQLException;

@WebServlet("/")
public class ClientServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private IClientDao iClientDao;

    public void init() {
        this.iClientDao = new ClientDao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
        String path = request.getServletPath();
        if(path.equals("/Client.action")){
            ClientModel clientModel = new ClientModel();
            List<Client> clients = this.iClientDao.selectAllClient();
            clientModel.setClientList(clients);
            request.setAttribute("clientModel", clientModel);
            request.getRequestDispatcher("Client/client.jsp").forward(request,response);
        } else if(path.equals("/AjouterClient.action")){
            request.getRequestDispatcher("Client/add-form-client.jsp").forward(request, response);
        } else {
            if(path.equals("/SaveClient.action") && request.getMethod().equals("POST")){
                String firstName = request.getParameter("firstName");
                String lastName = request.getParameter("lastName");
                int tele = Integer.parseInt(request.getParameter("tele"));
                String mail = request.getParameter("mail");
                this.iClientDao.insertClient(new Client(firstName,lastName,tele,mail));
            } else {
                int id;
                if(path.equals("/EditClient.action")){
                    id = Integer.parseInt(request.getParameter("id"));
                    Client client = this.iClientDao.selectClient(id);
                    request.setAttribute("client", client);
                    request.setAttribute("id", id);
                    request.getRequestDispatcher("Client/update-form-client.jsp").forward(request, response);
                } else  if(path.equals("/UpdateClient.action") && request.getMethod().equals("POST")) {
                    id = Integer.parseInt(request.getParameter("id"));
                    String firstName = request.getParameter("firstName");
                    String lastName = request.getParameter("lastName");
                    int tele = Integer.parseInt(request.getParameter("tele"));
                    String mail = request.getParameter("mail");
                    Client client = new Client(firstName,lastName,tele,mail);
                    client.setId(id);
                    this.iClientDao.updateClient(client, id);
                    response.sendRedirect("Client.action");
                } else if(path.equals("/SupprimerClient.action")){
                    id = Integer.parseInt(request.getParameter("id"));
                    this.iClientDao.deleteClient(id);
                    response.sendRedirect("Client.action");
                }else{
                    request.getRequestDispatcher("/notFount.jsp");
                }
            }
        }
    }

}

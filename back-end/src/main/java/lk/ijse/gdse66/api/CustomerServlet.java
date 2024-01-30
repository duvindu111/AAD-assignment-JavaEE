package lk.ijse.gdse66.api;

import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import lk.ijse.gdse66.bo.BOFactory;
import lk.ijse.gdse66.bo.custom.CustomerBO;
import lk.ijse.gdse66.dto.CustomerDTO;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet(name = "customer", urlPatterns = "/customer")
public class CustomerServlet extends HttpServlet {

    CustomerBO customerBO = BOFactory.getBOFactory().getBO(BOFactory.BOTypes.CUSTOMER_BO);

    DataSource connectionPool;

    @Override
    public void init() throws ServletException {
        try {
            InitialContext ic = new InitialContext();
            connectionPool = (DataSource) ic.lookup("java:/comp/env/jdbc/eeAssignment");
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Jsonb jsonb = JsonbBuilder.create();

            CustomerDTO customerDTO = jsonb.fromJson(req.getReader(), CustomerDTO.class);
            System.out.println(customerDTO);

            if(customerDTO.getId()==null || !customerDTO.getId().matches("^(C00-)[0-9]{3}$")){
                resp.getWriter().write("id is empty or invalid");
                return;
            }else if(customerDTO.getName()==null || !customerDTO.getName().matches("^[A-Za-z ]{4,}$")){
                resp.getWriter().write("name is empty or invalid");
                return;
            }else if(customerDTO.getAddress()==null || !customerDTO.getAddress().matches("^[A-Za-z0-9., -]{8,}$")){
                resp.getWriter().write("address is empty or invalid");
                return;
            }else if(customerDTO.getContact()==null || !customerDTO.getContact().matches("^\\+94\\d{9}$|^(0\\d{9})$|^(0\\d{2}-\\d{7})$")){
                resp.getWriter().write("contact is empty or invalid");
                return;
            }

            int res = customerBO.saveCustomer(customerDTO);
            if(res == 201){
                resp.setStatus(res);
            }else if(res == 409){
                resp.sendError(HttpServletResponse.SC_CONFLICT, "duplicate customer id");
            }else{
                resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "failed to save customer");
            }
        } catch (Exception e) {
            e.printStackTrace();
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "An error occurred while processing the request.");
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}

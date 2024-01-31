package lk.ijse.gdse66.api;

import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import jakarta.json.bind.JsonbException;
import lk.ijse.gdse66.bo.BOFactory;
import lk.ijse.gdse66.bo.custom.OrderDetailsBO;
import lk.ijse.gdse66.dto.CustomerDTO;
import lk.ijse.gdse66.dto.OrderDTO;

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
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(name = "orderDetail", urlPatterns = "/orderDetails")
public class OrderDetailsServlet extends HttpServlet {

    OrderDetailsBO orderDetailsBO = BOFactory.getBOFactory().getBO(BOFactory.BOTypes.ORDER_DETAIL_BO);

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
        String function = req.getParameter("function");

        if(function.equals("getById")){
            String id = req.getParameter("id");
            try (Connection connection = connectionPool.getConnection()){
                OrderDTO orderDTO = orderDetailsBO.getOrderDetailsById(connection, id);

                Jsonb jsonb = JsonbBuilder.create();
                String json = jsonb.toJson(orderDTO);
                resp.getWriter().write(json);
            } catch (JsonbException e) {
                resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.getMessage());
            } catch (IOException e) {
                resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.getMessage());
            } catch (Exception e) {
                e.printStackTrace();
                resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.getMessage());
            }
        }
    }
}

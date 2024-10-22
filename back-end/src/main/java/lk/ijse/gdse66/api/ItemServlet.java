package lk.ijse.gdse66.api;

import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import jakarta.json.bind.JsonbException;
import lk.ijse.gdse66.bo.BOFactory;
import lk.ijse.gdse66.bo.custom.ItemBO;
import lk.ijse.gdse66.dto.CustomerDTO;
import lk.ijse.gdse66.dto.ItemDTO;
import lk.ijse.gdse66.entity.Item;

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
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;

@WebServlet(name = "item", urlPatterns = "/item")
public class ItemServlet extends HttpServlet {

    ItemBO itemBO = BOFactory.getBOFactory().getBO(BOFactory.BOTypes.ITEM_BO);

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

        if (function.equals("getAll")){
            try (Connection connection = connectionPool.getConnection()){
                ArrayList<ItemDTO> customerDTOList = itemBO.getAllItems(connection);

                Jsonb jsonb = JsonbBuilder.create();
                String json = jsonb.toJson(customerDTOList);
                resp.getWriter().write(json);
            } catch (JsonbException e) {
                resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.getMessage());
            } catch (IOException e) {
                resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.getMessage());
            } catch (SQLException e) {
                resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.getMessage());
            }
        }else if(function.equals("getById")){
            String id = req.getParameter("id");
            try (Connection connection = connectionPool.getConnection()){
                ItemDTO itemDTO = itemBO.getItemByCode(connection, id);

                Jsonb jsonb = JsonbBuilder.create();
                String json = jsonb.toJson(itemDTO);
                resp.getWriter().write(json);
            } catch (JsonbException e) {
                resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.getMessage());
            } catch (IOException e) {
                resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.getMessage());
            } catch (SQLException e) {
                resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.getMessage());
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (Connection connection = connectionPool.getConnection()){
            Jsonb jsonb = JsonbBuilder.create();

            ItemDTO itemDTO = jsonb.fromJson(req.getReader(), ItemDTO.class);
            System.out.println(itemDTO);

            if(itemDTO.getCode()==null || !itemDTO.getCode().matches("^(I00-)[0-9]{3}$")){
                resp.getWriter().write("item code is empty or invalid");
                return;
            }else if(itemDTO.getName()==null || !itemDTO.getName().matches("^.{3,}$")){
                resp.getWriter().write("name is empty or invalid");
                return;
            }else if(itemDTO.getPrice()==null || !itemDTO.getPrice().toString().matches("\\d+(\\.\\d{1,2})")){
                resp.getWriter().write("address is empty or invalid");
                return;
            }else if(String.valueOf(itemDTO.getQty())==null || !String.valueOf(itemDTO.getQty()).matches("^\\d+(\\.\\d{1,2})?$")){
                resp.getWriter().write("contact is empty or invalid");
                return;
            }

            boolean isSaved = itemBO.saveCustomer(connection, itemDTO);
            if(isSaved){
                resp.setStatus(HttpServletResponse.SC_CREATED);
            }else{
                resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "failed to add item");
            }
        } catch (SQLIntegrityConstraintViolationException e) {
            resp.sendError(HttpServletResponse.SC_CONFLICT, "Duplicate values. Please check again");
        }catch (Exception e) {
            e.printStackTrace();
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "An error occurred while processing the request.");
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (Connection connection = connectionPool.getConnection()){
            Jsonb jsonb = JsonbBuilder.create();

            ItemDTO itemDTO = jsonb.fromJson(req.getReader(), ItemDTO.class);
            System.out.println(itemDTO);

            if(itemDTO.getCode()==null || !itemDTO.getCode().matches("^(I00-)[0-9]{3}$")){
                resp.getWriter().write("item code is empty or invalid");
                return;
            }else if(itemDTO.getName()==null || !itemDTO.getName().matches("^[A-Za-z ]{4,}$")){
                resp.getWriter().write("name is empty or invalid");
                return;
            }else if(itemDTO.getPrice()==null || !itemDTO.getPrice().toString().matches("\\d+(\\.\\d{1,2})")){
                resp.getWriter().write("address is empty or invalid");
                return;
            }else if(String.valueOf(itemDTO.getQty())==null || !String.valueOf(itemDTO.getQty()).matches("^\\d+(\\.\\d{1,2})?$")){
                resp.getWriter().write("contact is empty or invalid");
                return;
            }

            boolean isUpdated = itemBO.updateItem(connection, itemDTO);
            if(isUpdated){
                resp.setStatus(HttpServletResponse.SC_NO_CONTENT);
            }else{
                resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "failed to update item details");
            }
        }catch (SQLIntegrityConstraintViolationException e) {
            resp.sendError(HttpServletResponse.SC_CONFLICT, "Duplicate values. Please check again");
        }catch (Exception e) {
            e.printStackTrace();
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "An error occurred while processing the request.");
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        try (Connection connection = connectionPool.getConnection()){
            boolean isDeleted = itemBO.removeItem(connection, id);
            if(isDeleted){
                resp.setStatus(HttpServletResponse.SC_NO_CONTENT);
            }else{
                resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "failed to remove item");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

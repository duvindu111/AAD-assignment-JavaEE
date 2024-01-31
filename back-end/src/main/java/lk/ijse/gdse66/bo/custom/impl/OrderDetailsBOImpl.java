package lk.ijse.gdse66.bo.custom.impl;

import lk.ijse.gdse66.bo.custom.OrderDetailsBO;
import lk.ijse.gdse66.dao.DAOFactory;
import lk.ijse.gdse66.dao.custom.OrderDAO;
import lk.ijse.gdse66.dao.custom.OrderDetailsDAO;
import lk.ijse.gdse66.dao.custom.QueryDAO;
import lk.ijse.gdse66.dto.OrderDTO;
import lk.ijse.gdse66.dto.OrderDetailsDTO;
import lk.ijse.gdse66.entity.Custom;
import lk.ijse.gdse66.entity.Order;
import lk.ijse.gdse66.entity.OrderDetail;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDetailsBOImpl implements OrderDetailsBO {

    OrderDAO orderDAO = DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.ORDER_DAO);
    OrderDetailsDAO orderDetailsDAO = DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.ORDER_DETAILS_DAO);

    @Override
    public OrderDTO getOrderDetailsById(Connection connection, String id) throws SQLException {
        OrderDTO orderDTO = new OrderDTO();

        Order order = orderDAO.findBy(connection, id);
        orderDTO.setDate(order.getDate());
        orderDTO.setCust_id(order.getCust_id());
        orderDTO.setDiscount(order.getDiscount());
        orderDTO.setTotal(order.getTotal());

        List<OrderDetail> orderDetailList = orderDetailsDAO.getAllById(connection, id);

        List<OrderDetailsDTO> orderDetailDTOList = new ArrayList<OrderDetailsDTO>();
        for(OrderDetail orderDetail : orderDetailList){
            orderDetailDTOList.add(new OrderDetailsDTO(
                    orderDetail.getItem_code(),
                    orderDetail.getUnit_price(),
                    orderDetail.getQty()
            ));
        }
        orderDTO.setOrder_list(orderDetailDTOList);

        return orderDTO;
    }
}

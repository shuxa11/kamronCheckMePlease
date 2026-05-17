package shuxa.project.Admin;

import shuxa.project.User.*;
import shuxa.project.Order.*;
import java.util.List;

public class Admin extends User{
    public Admin(Long id, String name, String email) {
        super(id, name, email);
    }

    public void printAllOrders(List<Order> orders){
        for(Order order: orders){
            System.out.println(order.toString());
        }
    }
}

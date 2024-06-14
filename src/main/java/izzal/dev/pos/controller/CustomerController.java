package izzal.dev.pos.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import izzal.dev.pos.database.CustomerRepository;
import izzal.dev.pos.model.Customer;
import izzal.dev.pos.view.CustomerView;

@Component
public class CustomerController {

    private final CustomerRepository repo;
    private final CustomerView view;
    
    @Autowired
    public CustomerController(CustomerView view, CustomerRepository repo) {
        this.view = view;
        this.repo = repo;
        initController();
    }

    public void initController() {
        this.view.setVisible(true);
        view.getBtnAdd().addActionListener(e -> addAction());
        view.getBtnEdit().addActionListener(e -> editAction());
        view.getBtnDelete().addActionListener(e -> deleteAction());
        view.getTxtSearch().addActionListener(e -> searchAction());
        List<Customer> customers = repo.findAll();
        for (Customer customer : customers) {
            view.getMdlCustomer().addRow(
                new Object[] {customer.getId(), customer.getName(), customer.getAddress(), customer.getCity()}
            );
        }
    }

    private void searchAction() {
        // TODO Auto-generated method stub
    }

    private void addAction() {
        // TODO Auto-generated method stub
    }

    private void editAction() {
        // TODO Auto-generated method stub
    }

    private void deleteAction() {
        // TODO Auto-generated method stub
    }

}

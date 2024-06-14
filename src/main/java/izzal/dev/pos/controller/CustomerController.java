package izzal.dev.pos.controller;

import java.util.List;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import izzal.dev.pos.database.CustomerRepository;
import izzal.dev.pos.model.Customer;
import izzal.dev.pos.view.CustomerView;

@Component
public class CustomerController {
    private int selectRow;
    private final CustomerRepository repo;
    private final CustomerView view;
    private final List<Long> selectedIds;
    
    @Autowired
    public CustomerController(CustomerView view, CustomerRepository repo) {
        this.view = view;
        this.repo = repo;
        this.selectedIds = new ArrayList<Long>();
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
                new Object[] {false, customer.getId(), customer.getName(), customer.getAddress(), customer.getCity()}
            );
        }
        ListSelectionModel model = view.getTblCustomer().getSelectionModel();
        model.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                selectRow = model.getMinSelectionIndex();
            } 
        });
    }

    private void searchAction() {
        // TODO Buat customer search action
    }

    private void addAction() {
        // TODO Buat customer add action
    }

    private void editAction() {
        // TODO Buat customeredit action
    }

    private void deleteAction() {
        // TODO buat customer delete action
        Long selectId = (Long) view.getMdlCustomer().getValueAt(selectRow,1);
        repo.deleteById(selectId);
        view.getMdlCustomer().removeRow(selectRow);
    }

    private void selectRow() {
        // TODO Buat select row action
    }

}

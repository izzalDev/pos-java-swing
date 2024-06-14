package izzal.dev.pos.view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import org.springframework.stereotype.Component;

import lombok.Getter;
import net.miginfocom.swing.MigLayout;

@Component
@Getter
public class CustomerView extends JFrame {
    private DefaultTableModel mdlCustomer;
    private JTable tblCustomer;
    private JScrollPane scrCustomer;
    private JTextField txtSearch;
    private JButton btnAdd;
    private JButton btnEdit;
    private JButton btnDelete;

    public CustomerView() {
        setSize(600, 400);
        setTitle("Master Pelanggan");
        setLocationByPlatform(true);
        setLayout(new MigLayout("inset 20"));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initComponents();
    }

    protected void initComponents() {
        String[] columnNames = {"ID", "Nama Pelanggan", "Alamat", "Kota"};
        Object[][] data = {};

        mdlCustomer = new DefaultTableModel(data, columnNames);
        tblCustomer = new JTable(mdlCustomer);
        scrCustomer = new JScrollPane(tblCustomer);
        txtSearch = new JTextField(20); // Set preferred columns for the text field
        btnAdd = new JButton("Tambah");
        btnEdit = new JButton("Edit");
        btnDelete = new JButton("Hapus");

        // Add components to the frame using MigLayout constraints
        add(txtSearch, "growx");
        add(btnAdd);
        add(btnEdit);
        add(btnDelete, "wrap");
        add(scrCustomer, "span, grow, push");
    }
}

package izzal.dev.pos.view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import org.springframework.stereotype.Component;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.icons.FlatSearchIcon;

// import izzal.dev.pos.utils.CheckboxRenderer;
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
        setLayout(new MigLayout("inset 20, gap 15"));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initComponents();
        init();
    }

    protected void init(){
        tblCustomer.getColumnModel().getColumn(0).setMaxWidth(40);
        txtSearch.putClientProperty(FlatClientProperties.STYLE, "arc:15; focusWidth:0; innerFocusWidth:0; margin:5,20,5,20;");
        txtSearch.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Search...");
        txtSearch.putClientProperty(FlatClientProperties.TEXT_FIELD_LEADING_ICON, new FlatSearchIcon());
        scrCustomer.putClientProperty(FlatClientProperties.STYLE,"arc:15; focusWidth:0; innerFocusWidth:0;");
    }

    protected void initComponents() {
        String[] columnNames = {"", "ID", "Nama Pelanggan", "Alamat", "Kota"};
        Object[][] data = {};

        mdlCustomer = new DefaultTableModel(data, columnNames){
            Class<?>[] types = new Class [] {
                java.lang.Boolean.class, 
                java.lang.Long.class, 
                java.lang.Object.class, 
                java.lang.Object.class,
                java.lang.Object.class,
            };

            public Class<?> getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        };

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

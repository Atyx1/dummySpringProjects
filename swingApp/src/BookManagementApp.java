import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class BookManagementApp extends JFrame {
    private JTextField searchField;
    private ArrayList<Book> bookList;
    private JTextField nameField, priceField, pageNumberField;
    private JComboBox<String> categoryComboBox, ageGroupComboBox,signatureComboBox;
    private JTextArea bookListArea;

    public BookManagementApp() {
        // Initialize the book list
        bookList = new ArrayList<>();

        // Set up the main frame
        setTitle("Book Management App");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel searchLabel = new JLabel("Search by Name:");
        searchField = new JTextField(20);
        JButton searchButton = new JButton("Search");
        // Create the components
        JLabel nameLabel = new JLabel("Name:");
        JLabel priceLabel = new JLabel("Price:");
        JLabel pageNumberLabel = new JLabel("Page Number:");
        JLabel categoryLabel = new JLabel("Category:");
        JLabel ageGroupLabel = new JLabel("Age Group:");
        JLabel signatureComboBox_1= new JLabel("Signature:");

        nameField = new JTextField(20);
        priceField = new JTextField(20);
        pageNumberField = new JTextField(20);
        categoryComboBox = new JComboBox<>(new String[]{"Fiction", "Non-fiction"});
        ageGroupComboBox = new JComboBox<>(new String[]{"Children", "Teenagers", "Adults"});
        signatureComboBox= new JComboBox<>(new String[]{"Signature", " Not Signature"});
        JButton addButton = new JButton("Add Book");
        JButton displayButton = new JButton("Display Books");
        bookListArea = new JTextArea(10, 30);


        // Create a panel for the input fields and add them
        JPanel inputPanel = new JPanel(new GridLayout(6, 3));
        inputPanel.add(nameLabel);
        inputPanel.add(nameField);
        inputPanel.add(priceLabel);
        inputPanel.add(priceField);
        inputPanel.add(pageNumberLabel);
        inputPanel.add(pageNumberField);
        inputPanel.add(categoryLabel);
        inputPanel.add(categoryComboBox);
        inputPanel.add(ageGroupLabel);
        inputPanel.add(ageGroupComboBox);
        inputPanel.add(signatureComboBox_1);
        inputPanel.add(signatureComboBox);
        JPanel searchPanel = new JPanel();
        searchPanel.add(searchLabel);
        searchPanel.add(searchField);
        searchPanel.add(searchButton);


        // Create a panel for the buttons and add them
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addButton);
        buttonPanel.add(displayButton);


        // Set up the text area for the book list
        bookListArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(bookListArea);

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchBooks();
            }
        });

        // Add action listeners to the buttons
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addBook();
            }
        });

        displayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayBooks();
            }
        });


        // Create a panel for the book list and add the scroll pane
        JPanel bookListPanel = new JPanel();
        bookListPanel.add(scrollPane);

        // Set up the main content pane and add the panels
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());
        contentPane.add(inputPanel, BorderLayout.NORTH);
        contentPane.add(buttonPanel, BorderLayout.CENTER);
        contentPane.add(bookListPanel, BorderLayout.SOUTH);
        contentPane.add(searchPanel, BorderLayout.WEST);



    }

    private void addBook() {
        String name = nameField.getText();
        double price = Double.parseDouble(priceField.getText());
        int pageNumber = Integer.parseInt(pageNumberField.getText());
        String category = (String) categoryComboBox.getSelectedItem();
        String ageGroup = (String) ageGroupComboBox.getSelectedItem();
        String signature = (String) signatureComboBox.getSelectedItem();

        Book book = new Book(name, price, pageNumber, category, ageGroup,signature);
        bookList.add(book);

        nameField.setText("");
        priceField.setText("");
        pageNumberField.setText("");

        JOptionPane.showMessageDialog(this, "Book added successfully!");
    }
    private void displayBooks() {
        bookListArea.setText("");
        for (Book book : bookList) {
            bookListArea.append(book.toString() + "\n");
        }

    }
    private void searchBooks() {
        String searchQuery = searchField.getText().toLowerCase();

        bookListArea.setText("");

        for (Book book : bookList) {
            if (book.getName().toLowerCase().contains(searchQuery)) {
                bookListArea.append(book.toString() + "\n");
            }
        }
    }












    public static void main(String[] args) {

        JFrame frame=new JFrame("BookManagementApp");
        frame.setContentPane(new BookManagementApp().getContentPane());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }
}
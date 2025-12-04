import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;
import java.util.List;

class ArtworkPurchase {
    private String name;
    private double price;
    private double discount;
    private double finalPrice;
    
    public ArtworkPurchase(String name, double price, double discount, double finalPrice) {
        this.name = name;
        this.price = price;
        this.discount = discount;
        this.finalPrice = finalPrice;
    }
    
    public String getName() { return name; }
    public double getPrice() { return price; }
    public double getDiscount() { return discount; }
    public double getFinalPrice() { return finalPrice; }
}

public class ArtGalleryGUI
{
    ArrayList<ArtGalleryVisitor> artGalleryList = new ArrayList<>();
    private DefaultTableModel model; 
    public ArtGalleryGUI(){

        //f.getContentPane().setBackground(new Color(169, 214, 229));
        JFrame frame = new JFrame("Art Gallery");
        frame .setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame .setSize(1920,1080); 
        frame .setLayout(null);
        frame .setResizable(false);

        //navBar Panel
        JPanel navPanel=new JPanel();
        navPanel.setLayout(null);
        navPanel.setBackground(new Color(30,57,75));
        navPanel.setBounds(1030,0,250,1080);

        JLabel titleLabel=new JLabel();
        titleLabel.setText("<html><div>"
            + "<div style='text-align: right;'>Art</div>"
            + "<div style='text-align: left; padding-left: 20px;'>Gallery</div></div></html>");
        titleLabel.setFont(new Font("Times New Roman", Font.BOLD , 50));
        titleLabel.setForeground(new Color(215,207,197));
        titleLabel.setBounds(10, 10, 230, 150);
        navPanel.add(titleLabel);
        frame.add(navPanel);

        //icon
        ImageIcon logoIcon= new ImageIcon("C:/Users/WELCOME/Desktop/notes/Year 1/Programming/coursework/24058821 Shaira Gurung/ArtGalleryLogo.png");
        JLabel logoLabel = new JLabel();
        logoLabel.setIcon(logoIcon);
        logoLabel.setBounds(10,5,100,100);
        navPanel.add(logoLabel);

        //navPanelbar ko Bitra buttons
        //dashbord or aka homePanel page button 
        JButton homePanelButton= new JButton("Dashboard");
        homePanelButton.setFont(new Font("Arial", Font.BOLD, 16));   
        homePanelButton.setBounds(50,190,150,50); 
        homePanelButton.setForeground(Color.WHITE);
        homePanelButton.setContentAreaFilled(false);  // Remove background fill
        homePanelButton.setBorderPainted(false);      // Remove border
        homePanelButton.setFocusPainted(false); //removes the smaller box
        navPanel.add(homePanelButton);
        //Mouse Hover
        homePanelButton.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    homePanelButton.setForeground(new Color(138,130,120)); // on hover
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    homePanelButton.setForeground(new Color(215,207,197)); // Back to white
                }

                @Override
                public void mousePressed(MouseEvent e) {
                    homePanelButton.setForeground(new Color(108,94,79)); // Slightly darker when clicked
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                    homePanelButton.setForeground(new Color(138,130,120)); // Back to hover color
                }        
            });

        //add visitor Button
        JButton addVisitorButton = new JButton("Add Visitor");
        addVisitorButton.setFont(new Font("Arial", Font.BOLD, 16));
        addVisitorButton.setBounds(50,230,150,50); 
        addVisitorButton.setForeground(Color.WHITE);
        addVisitorButton.setContentAreaFilled(false);  // Remove background fill
        addVisitorButton.setBorderPainted(false);      // Remove border
        addVisitorButton.setFocusPainted(false); //removes the smaller box
        navPanel.add(addVisitorButton);
        //Mouse Hover
        addVisitorButton.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    addVisitorButton.setForeground(new Color(138,130,120)); //  on hover
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    addVisitorButton.setForeground(new Color(215,207,197)); // Back to white
                }

                @Override
                public void mousePressed(MouseEvent e) {
                    addVisitorButton.setForeground(new Color(108,94,79)); // Slightly darker when clicked
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                    addVisitorButton.setForeground(new Color(138,130,120)); // Back to hover color
                }        
            }); 

        //Buy Product
        JButton artworkButton = new JButton("Artwork");
        artworkButton.setFont(new Font("Arial", Font.BOLD, 16));
        artworkButton.setBounds(50,270,150,50);  
        artworkButton.setForeground(Color.WHITE);
        artworkButton.setContentAreaFilled(false);  // Remove background fill
        artworkButton.setBorderPainted(false);      // Remove border
        artworkButton.setFocusPainted(false); //removes the smaller box
        navPanel.add(artworkButton);
        //Mouse Hover
        artworkButton.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    artworkButton.setForeground(new Color(138,130,120)); // on hover
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    artworkButton.setForeground(new Color(215,207,197)); // Back to white
                }

                @Override
                public void mousePressed(MouseEvent e) {
                    artworkButton.setForeground(new Color(108,94,79)); // Slightly darker when clicked
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                    artworkButton.setForeground(new Color(138,130,120)); // Back to hover color
                }        
            });
        //display Details
        JButton visitorDetailButton= new JButton("Visitor Detail");
        visitorDetailButton.setFont(new Font("Arial", Font.BOLD, 16));
        visitorDetailButton.setBounds(50,310,150,50);  
        visitorDetailButton.setForeground(Color.WHITE);
        visitorDetailButton.setContentAreaFilled(false);  // Remove background fill
        visitorDetailButton.setBorderPainted(false);      // Remove border
        visitorDetailButton.setFocusPainted(false); //removes the smaller box
        navPanel.add(visitorDetailButton);
        visitorDetailButton.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    visitorDetailButton.setForeground(new Color(138,130,120)); // on hover
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    visitorDetailButton.setForeground(new Color(215,207,197)); // Back to white
                }

                @Override
                public void mousePressed(MouseEvent e) {
                    visitorDetailButton.setForeground(new Color(108,94,79)); // Slightly darker when clicked
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                    visitorDetailButton.setForeground(new Color(138,130,120)); // Back to hover color
                }        
            });

        //homePanel 
        JPanel homePanel=new JPanel();  
        JLabel dashboardLabel=new JLabel();
        dashboardLabel.setText("Dashboard");
        dashboardLabel.setFont(new Font("Times New Roman", Font.BOLD , 50));
        dashboardLabel.setForeground(new Color(138,130,120));
        dashboardLabel.setBounds(450, 40, 300, 60);
        homePanel.setBackground(new Color(215,207,191));
        homePanel.setBounds(0,0,1030,1080);
        homePanel.add(dashboardLabel);
        homePanel.setLayout(null); 
        frame.add(homePanel);

        JLabel totalVisitorLabel=new JLabel();
        totalVisitorLabel.setText("<html><u>Total Visitors:</u></html>");
        totalVisitorLabel.setFont(new Font("Times New Roman", Font.BOLD , 20));
        totalVisitorLabel.setBounds(50,150,150,50);
        homePanel.add(totalVisitorLabel);
        JLabel standardVisitorLabel=new JLabel();
        standardVisitorLabel.setText("Standard:");
        standardVisitorLabel.setFont(new Font("Times New Roman", Font.BOLD , 15));
        standardVisitorLabel.setBounds(50,200,100,50);
        homePanel.add(standardVisitorLabel);
        JLabel eliteVisitorLabel=new JLabel();
        eliteVisitorLabel.setText("Elite:");
        eliteVisitorLabel.setFont(new Font("Times New Roman", Font.BOLD , 15));
        eliteVisitorLabel.setBounds(250,200,100,50);
        homePanel.add(eliteVisitorLabel);
        JLabel activityLabel=new JLabel();
        activityLabel.setText("Recent Activity");
        activityLabel.setFont(new Font("Times New Roman", Font.BOLD , 25));
        activityLabel.setBounds(50,300,200,50);
        JTextArea activityTextArea = new JTextArea();
        activityTextArea.setEditable(false);
        activityTextArea.setBackground(new Color(240, 240, 240)); // Light gray
        activityTextArea.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        activityTextArea.setBounds(50,350,400,200);
        activityTextArea.setText(

            ">JohnD purchased 'Starry Night'\n" +
            ">JaneS logged visit\n" + 
            ">Art advisor assigned to ID#123"
        );
        activityTextArea.setFont(new Font("Times New Roman", Font.BOLD , 20));
        homePanel.add(activityLabel);
        homePanel.add(activityTextArea);

        //addVisitorPanel
        JPanel addVisitorPanel=new JPanel();  
        JLabel register=new JLabel();
        register.setText("Register");
        register.setFont(new Font("Times New Roman", Font.BOLD , 50));
        register.setForeground(new Color(138,130,120));
        register.setBounds(450, 40, 300, 60);
        addVisitorPanel.setBackground(new Color(215,207,191));
        addVisitorPanel.setBounds(0,0,1030,1080);
        addVisitorPanel.add(register);
        addVisitorPanel.setLayout(null); 
        addVisitorPanel.setVisible(false);
        frame.add(addVisitorPanel);

        //id
        JLabel idLabel=new JLabel("ID");
        idLabel.setBounds(100,120,70,70);
        addVisitorPanel.add(idLabel);
        JTextField idTextField=new JTextField(10);
        idTextField.setBounds(210,140,150,30);
        addVisitorPanel.add(idTextField);

        JLabel nameLabel=new JLabel("Full Name");
        nameLabel.setBounds(100,200,70,70);
        addVisitorPanel.add(nameLabel);
        JTextField nameTextField=new JTextField(10);
        nameTextField.setBounds(210,220,150,30);
        addVisitorPanel.add(nameTextField); 

        //Gender Field
        JLabel genderLabel=new JLabel("Gender");
        genderLabel.setBounds(100,280,70,70);
        addVisitorPanel.add(genderLabel);

        JRadioButton maleRadioButton=new JRadioButton("Male");
        maleRadioButton.setBounds(210,300,55,50);
        maleRadioButton.setBackground(new Color(215,207,191));
        maleRadioButton.setFocusPainted(false);
        addVisitorPanel.add(maleRadioButton);
        JRadioButton femaleRadioButton=new JRadioButton("Female");
        femaleRadioButton.setBounds(270,300,70,50);
        femaleRadioButton.setBackground(new Color(215,207,191));
        femaleRadioButton.setFocusPainted(false);
        addVisitorPanel.add(femaleRadioButton);
        JRadioButton otherRadioButton=new JRadioButton("Other");
        otherRadioButton.setBounds(350,300,60,50);
        otherRadioButton.setBackground(new Color(215,207,191));
        otherRadioButton.setFocusPainted(false);
        addVisitorPanel.add(otherRadioButton);

        ButtonGroup genderButtonGroup=new ButtonGroup();
        genderButtonGroup.add(maleRadioButton);
        genderButtonGroup.add(femaleRadioButton);
        genderButtonGroup.add(otherRadioButton);

        //Contact No
        JLabel contactLabel=new JLabel("Contact No");
        contactLabel.setBounds(100,360,70,70);
        addVisitorPanel.add(contactLabel);
        JTextField contactTextField=new JTextField(10);
        contactTextField.setBounds(210,380,150,30);
        addVisitorPanel.add(contactTextField); 

        //date
        JLabel dateLabel=new JLabel("Registration Date");
        dateLabel.setBounds(100,440,120,70);
        addVisitorPanel.add(dateLabel);
        String[] dayOptions=new String[32];
        dayOptions[0] = "Day";
        for(int i=1; i<32;i++)dayOptions[i]=String.valueOf(i);//String.valueOf=int to String conversion 
        JComboBox<String> dayComboBox=new JComboBox<>(dayOptions);//JComboBox array= takes only String
        dayComboBox.setBounds(210,460,65,30);
        addVisitorPanel.add(dayComboBox);
        String[] monthOptions={"Month","Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};
        JComboBox<String> monthComboBox=new JComboBox<>(monthOptions);
        monthComboBox.setBounds(275,460,65,30);
        addVisitorPanel.add(monthComboBox);
        //1980-2025
        String[] yearOptions=new String[47];
        yearOptions[0] = "Year"; 
        for(int i=1; i<47;i++)yearOptions[i]=String.valueOf(1980+i-1);
        JComboBox<String> yearComboBox=new JComboBox<>(yearOptions);
        yearComboBox.setBounds(340,460,65,30);
        addVisitorPanel.add(yearComboBox);

        //TicketType
        JLabel ticketLabel=new JLabel("Ticket Type");
        ticketLabel.setBounds(550,120,120,70);
        addVisitorPanel.add(ticketLabel);            
        String[] ticket={"Select","Standard","Elite"};
        JComboBox<String> ticketComboBox=new JComboBox<>(ticket);
        ticketComboBox.setBounds(650,140,90,30);
        addVisitorPanel.add(ticketComboBox);

        //TicketPrice
        JLabel ticketPriceLabel=new JLabel("Ticket Price:");
        ticketPriceLabel.setBounds(550,200,120,70);
        addVisitorPanel.add(ticketPriceLabel);
        JTextField ticketPriceTextField=new JTextField(10);
        ticketPriceTextField.setBounds(650,220,150,30);
        ticketPriceTextField.setEditable(false);
        addVisitorPanel.add(ticketPriceTextField);
        //login
        JLabel loginLabel=new JLabel("Visitor ID:");
        loginLabel.setBounds(700,440,120,70);
        addVisitorPanel.add(loginLabel);
        JTextField loginIdTextField=new JTextField(10);
        loginIdTextField.setBounds(760,460,150,30);
        addVisitorPanel.add(loginIdTextField);

        //Submitbtn and clearButton
        JButton addButton=new JButton("Add visitor");
        addButton.setFont(new Font("Arial", Font.BOLD, 16));
        addButton.setBounds(250,530,150,50);  
        addButton.setBorder(BorderFactory.createMatteBorder(0, 0, 4, 4, new Color(65,21,40)));//BorderFactory.createMatteBorder: lets you create a solid-colored border on specific sides of a component (top, left, bottom, right)
        addButton.setBackground(new Color(113,12,33));
        addButton.setForeground(Color.WHITE);
        addButton.setFocusPainted(false);
        addButton.setContentAreaFilled(true); 
        addButton.setContentAreaFilled(false);
        addButton.setOpaque(true); 
        addVisitorPanel.add(addButton);
        addButton.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    addButton.setBackground(new Color(162, 76, 97));
                    addButton.setBorder(BorderFactory.createMatteBorder(0, 0, 4, 4, new Color(113,12,33)));
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                    addButton.setBackground(new Color(113, 12, 33));
                    addButton.setBorder(BorderFactory.createMatteBorder(0, 0, 4, 4, new Color(65,21,40)));
                }
            });

        JButton clearButton=new JButton("Clear");
        clearButton.setFont(new Font("Arial", Font.BOLD, 16));
        clearButton.setBounds(500,530,150,50); 
        clearButton.setBorder(BorderFactory.createMatteBorder(0, 0, 4, 4, new Color(65,21,40)));//BorderFactory.createMatteBorder: lets you create a solid-colored border on specific sides of a component (top, left, bottom, right)
        clearButton.setBackground(new Color(113,12,33));
        clearButton.setForeground(Color.WHITE);
        clearButton.setFocusPainted(false);
        clearButton.setContentAreaFilled(true); 
        clearButton.setContentAreaFilled(false);
        clearButton.setOpaque(true); 
        addVisitorPanel.add(clearButton);
        clearButton.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    clearButton.setBackground(new Color(162, 76, 97));
                    clearButton.setBorder(BorderFactory.createMatteBorder(0, 0, 4, 4, new Color(113,12,33)));
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                    clearButton.setBackground(new Color(113, 12, 33));
                    clearButton.setBorder(BorderFactory.createMatteBorder(0, 0, 4, 4, new Color(65,21,40)));
                }
            });
        //login section

        JButton loginButton=new JButton("Login");
        loginButton.setFont(new Font("Arial", Font.BOLD, 16));
        loginButton.setBounds(750,530,150,50); 
        loginButton.setBorder(BorderFactory.createMatteBorder(0, 0, 4, 4, new Color(65,21,40)));//BorderFactory.createMatteBorder: lets you create a solid-colored border on specific sides of a component (top, left, bottom, right)
        loginButton.setBackground(new Color(113,12,33));
        loginButton.setForeground(Color.WHITE);
        loginButton.setFocusPainted(false);
        loginButton.setContentAreaFilled(true); 
        loginButton.setContentAreaFilled(false);
        loginButton.setOpaque(true); 
        addVisitorPanel.add(loginButton);
        loginButton.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    loginButton.setBackground(new Color(162, 76, 97));
                    loginButton.setBorder(BorderFactory.createMatteBorder(0, 0, 4, 4, new Color(113,12,33)));
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                    loginButton.setBackground(new Color(113, 12, 33));
                    loginButton.setBorder(BorderFactory.createMatteBorder(0, 0, 4, 4, new Color(65,21,40)));
                }
            });

        //ArtWork Buy or cancel Panel
        JPanel transactionPanel=new JPanel();
        JLabel displayLabel=new JLabel();
        displayLabel.setText("Art work Transaction");
        displayLabel.setFont(new Font("Times New Roman", Font.BOLD , 50));
        displayLabel.setForeground(new Color(138,130,120));
        displayLabel.setBounds(350, 50, 500, 60);
        transactionPanel.setBackground(new Color(215, 207, 191));
        transactionPanel.setBounds(0,0,1030,1080);
        transactionPanel.add(displayLabel);
        transactionPanel.setLayout(null);
        transactionPanel.setVisible(false);
        frame.add(transactionPanel);

        JLabel transactionVisitorIdLabel =new JLabel("Visitor ID:");
        transactionVisitorIdLabel .setBounds(100,120,120,70);
        transactionPanel.add(transactionVisitorIdLabel );
        JTextField transactionVisitorIdTextField =new JTextField(10);
        transactionVisitorIdTextField .setBounds(240,140,150,30);
        transactionPanel.add(transactionVisitorIdTextField );
        JLabel artworkNameLabel=new JLabel("Artwork Name:");
        artworkNameLabel.setBounds(100,160,120,70);
        transactionPanel.add(artworkNameLabel);
        JTextField artworkNameTextField=new JTextField(10);
        artworkNameTextField.setBounds(240,180,150,30);
        transactionPanel.add(artworkNameTextField);
        JLabel artworkPriceLabel=new JLabel("Artwork Price:");
        artworkPriceLabel.setBounds(100,200,120,70);
        transactionPanel.add(artworkPriceLabel);
        JTextField artworkPriceTextField=new JTextField(10);
        artworkPriceTextField.setBounds(240,220,150,30);
        transactionPanel.add(artworkPriceTextField);
        //Buy Product
        JButton buyButton=new JButton("Buy");
        buyButton.setFont(new Font("Arial", Font.BOLD, 16));
        buyButton.setBounds(240,300,100,30);  
        buyButton.setBorder(BorderFactory.createMatteBorder(0, 0, 4, 4, new Color(65,21,40)));//BorderFactory.createMatteBorder: lets you create a solid-colored border on specific sides of a component (top, left, bottom, right)
        buyButton.setBackground(new Color(113,12,33));
        buyButton.setForeground(Color.WHITE);
        buyButton.setFocusPainted(false);
        buyButton.setContentAreaFilled(true); 
        buyButton.setContentAreaFilled(false);
        buyButton.setOpaque(true); 
        transactionPanel.add(buyButton);
        buyButton.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    buyButton.setBackground(new Color(162, 76, 97));
                    buyButton.setBorder(BorderFactory.createMatteBorder(0, 0, 4, 4, new Color(113,12,33)));
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                    buyButton.setBackground(new Color(113, 12, 33));
                    buyButton.setBorder(BorderFactory.createMatteBorder(0, 0, 4, 4, new Color(65,21,40)));
                }
            });
            
        
            

        //cancel Product
        JLabel reasonLabel=new JLabel("Cancellation Reason:");
        reasonLabel.setBounds(500,110,200,70);
        transactionPanel.add(reasonLabel);
        JTextArea reasonTextArea=new JTextArea();
        reasonTextArea.setBounds(630,150,200,100);
        transactionPanel.add(reasonTextArea);

        JButton cancelButton=new JButton("Cancel");
        cancelButton.setFont(new Font("Arial", Font.BOLD, 16));
        cancelButton.setBounds(630,300,100,30);  
        cancelButton.setBorder(BorderFactory.createMatteBorder(0, 0, 4, 4, new Color(65,21,40)));//BorderFactory.createMatteBorder: lets you create a solid-colored border on specific sides of a component (top, left, bottom, right)
        cancelButton.setBackground(new Color(113,12,33));
        cancelButton.setForeground(Color.WHITE);
        cancelButton.setFocusPainted(false);
        cancelButton.setContentAreaFilled(true); 
        cancelButton.setContentAreaFilled(false);
        cancelButton.setOpaque(true); 
        transactionPanel.add(cancelButton);
        cancelButton.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    cancelButton.setBackground(new Color(162, 76, 97));
                    cancelButton.setBorder(BorderFactory.createMatteBorder(0, 0, 4, 4, new Color(113,12,33)));
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                    cancelButton.setBackground(new Color(113, 12, 33));
                    cancelButton.setBorder(BorderFactory.createMatteBorder(0, 0, 4, 4, new Color(65,21,40)));
                }
            });

        //Generate Bill Btn
        JButton billButton=new JButton("Generate Bill");
        billButton.setFont(new Font("Arial", Font.BOLD, 16));
        billButton.setBounds(300,400,150,30);  
        billButton.setBorder(BorderFactory.createMatteBorder(0, 0, 4, 4, new Color(65,21,40)));//BorderFactory.createMatteBorder: lets you create a solid-colored border on specific sides of a component (top, left, bottom, right)
        billButton.setBackground(new Color(113,12,33));
        billButton.setForeground(Color.WHITE);
        billButton.setFocusPainted(false);
        billButton.setContentAreaFilled(true); 
        billButton.setContentAreaFilled(false);
        billButton.setOpaque(true); 
        transactionPanel.add(billButton);
        
        // ADD THIS ACTION LISTENER FOR THE BILL BUTTON
// Bill generation - MODIFIED FOR MULTIPLE PURCHASES
        billButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(transactionVisitorIdTextField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Visitor ID field cannot be empty!", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if(!transactionVisitorIdTextField.getText().matches("\\d+")) {
                    JOptionPane.showMessageDialog(null, "Visitor ID must contain only numbers!", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                try {
                    int visitorId = Integer.parseInt(transactionVisitorIdTextField.getText());
                    ArtGalleryVisitor visitor = null;
                    for (ArtGalleryVisitor v : artGalleryList) {
                        if (v.getVisitorId() == visitorId) {
                            visitor = v;
                            break;
                        }
                    }
                    if (visitor == null) {
                        JOptionPane.showMessageDialog(null, "Visitor ID not found!", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    if (!visitor.getIsActive()) {
                        JOptionPane.showMessageDialog(null, "Visitor is not active. Please log a visit first.", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    // Generate the bill file with all purchases
                    generateBillFile(visitor);

                } catch(Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error generating bill: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        billButton.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    billButton.setBackground(new Color(162, 76, 97));
                    billButton.setBorder(BorderFactory.createMatteBorder(0, 0, 4, 4, new Color(113,12,33)));
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                    billButton.setBackground(new Color(113, 12, 33));
                    billButton.setBorder(BorderFactory.createMatteBorder(0, 0, 4, 4, new Color(65,21,40)));
                }
            });


        //Calculate Discount Btn
        JButton discountButton=new JButton("Calculate Discount");
        discountButton.setFont(new Font("Arial", Font.BOLD, 16));
        discountButton.setBounds(500,400,170,30);  
        discountButton.setBorder(BorderFactory.createMatteBorder(0, 0, 4, 4, new Color(65,21,40)));//BorderFactory.createMatteBorder: lets you create a solid-colored border on specific sides of a component (top, left, bottom, right)
        discountButton.setBackground(new Color(113,12,33));
        discountButton.setForeground(Color.WHITE);
        discountButton.setFocusPainted(false);
        discountButton.setContentAreaFilled(true); 
        discountButton.setContentAreaFilled(false);
        discountButton.setOpaque(true); 
        transactionPanel.add(discountButton);
        discountButton.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    discountButton.setBackground(new Color(162, 76, 97));
                    discountButton.setBorder(BorderFactory.createMatteBorder(0, 0, 4, 4, new Color(113,12,33)));
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                    discountButton.setBackground(new Color(113, 12, 33));
                    discountButton.setBorder(BorderFactory.createMatteBorder(0, 0, 4, 4, new Color(65,21,40)));
                }
            });

        //Vistor Detail Panel
        JPanel visitorDetailPanel=new JPanel();
        JLabel detailLabel=new JLabel();
        detailLabel.setText("Visitor Details");
        detailLabel.setFont(new Font("Times New Roman", Font.BOLD , 50));
        detailLabel.setForeground(new Color(138,130,120));
        detailLabel.setBounds(350, 50, 500, 60);
        visitorDetailPanel.setBackground(new Color(215, 207, 191));
        visitorDetailPanel.setBounds(0,0,1030,1080);
        visitorDetailPanel.add(detailLabel);
        visitorDetailPanel.setLayout(null);
        visitorDetailPanel.setVisible(false);

        frame.add(visitorDetailPanel);
        JLabel visitorIdLabel=new JLabel("Visitor ID:");
        visitorIdLabel.setBounds(100,120,120,70);
        visitorDetailPanel.add(visitorIdLabel);
        JTextField visitorIdTextField=new JTextField(10);
        visitorIdTextField.setBounds(240,140,150,30);
        visitorDetailPanel.add(visitorIdTextField);

        JButton artAdvisorButton=new JButton("Assign Personal Art Advisor");
        artAdvisorButton.setFont(new Font("Arial", Font.BOLD, 12));
        artAdvisorButton.setBounds(400,120,180,50);  
        artAdvisorButton.setBorder(BorderFactory.createMatteBorder(0, 0, 4, 4, new Color(65,21,40)));//BorderFactory.createMatteBorder: lets you create a solid-colored border on specific sides of a component (top, left, bottom, right)
        artAdvisorButton.setBackground(new Color(113,12,33));
        artAdvisorButton.setForeground(Color.WHITE);
        artAdvisorButton.setFocusPainted(false);
        artAdvisorButton.setContentAreaFilled(true); 
        artAdvisorButton.setContentAreaFilled(false);
        artAdvisorButton.setOpaque(true); 
        visitorDetailPanel.add(artAdvisorButton);
        artAdvisorButton.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    artAdvisorButton.setBackground(new Color(162, 76, 97));
                    artAdvisorButton.setBorder(BorderFactory.createMatteBorder(0, 0, 4, 4, new Color(113,12,33)));
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                    artAdvisorButton.setBackground(new Color(113, 12, 33));
                    artAdvisorButton.setBorder(BorderFactory.createMatteBorder(0, 0, 4, 4, new Color(65,21,40)));
                }
            });
        JButton upgradeButton=new JButton("Check Upgrade");
        upgradeButton.setFont(new Font("Arial", Font.BOLD, 12));
        upgradeButton.setBounds(600,120,100,50);  
        upgradeButton.setBorder(BorderFactory.createMatteBorder(0, 0, 4, 4, new Color(65,21,40)));//BorderFactory.createMatteBorder: lets you create a solid-colored border on specific sides of a component (top, left, bottom, right)
        upgradeButton.setBackground(new Color(113,12,33));
        upgradeButton.setForeground(Color.WHITE);
        upgradeButton.setFocusPainted(false);
        upgradeButton.setContentAreaFilled(true); 
        upgradeButton.setContentAreaFilled(false);
        upgradeButton.setOpaque(true); 
        visitorDetailPanel.add(upgradeButton);
        upgradeButton.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    upgradeButton.setBackground(new Color(162, 76, 97));
                    upgradeButton.setBorder(BorderFactory.createMatteBorder(0, 0, 4, 4, new Color(113,12,33)));
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                    upgradeButton.setBackground(new Color(113, 12, 33));
                    upgradeButton.setBorder(BorderFactory.createMatteBorder(0, 0, 4, 4, new Color(65,21,40)));
                }
            });
        JButton rewardPointsButton=new JButton("Calculate Reward Points");
        rewardPointsButton.setFont(new Font("Arial", Font.BOLD, 12));
        rewardPointsButton.setBounds(720,120,150,50);  
        rewardPointsButton.setBorder(BorderFactory.createMatteBorder(0, 0, 4, 4, new Color(65,21,40)));//BorderFactory.createMatteBorder: lets you create a solid-colored border on specific sides of a component (top, left, bottom, right)
        rewardPointsButton.setBackground(new Color(113,12,33));
        rewardPointsButton.setForeground(Color.WHITE);
        rewardPointsButton.setFocusPainted(false);
        rewardPointsButton.setContentAreaFilled(true); 
        rewardPointsButton.setContentAreaFilled(false);
        rewardPointsButton.setOpaque(true); 
        visitorDetailPanel.add(rewardPointsButton);
        rewardPointsButton.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    rewardPointsButton.setBackground(new Color(162, 76, 97));
                    rewardPointsButton.setBorder(BorderFactory.createMatteBorder(0, 0, 4, 4, new Color(113,12,33)));
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                    rewardPointsButton.setBackground(new Color(113, 12, 33));
                    rewardPointsButton.setBorder(BorderFactory.createMatteBorder(0, 0, 4, 4, new Color(65,21,40)));
                }
            });

        JLabel memberLabel=new JLabel("Members Data");
        memberLabel.setFont(new Font("Times New Roman", Font.BOLD , 20));
        memberLabel.setBounds(450,180,180,70);
        visitorDetailPanel.add(memberLabel);
        //table
        String[] tableColumnNames={"Visitor ID","Name","Gender","Contact Number","Reg Date","Ticket Type","Ticket Price","Status","Visit Count"};
        this.model = new DefaultTableModel(tableColumnNames,0){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Make table cells non-editable
            }
        };

        JTable table=new JTable(model);
        for(ArtGalleryVisitor a: artGalleryList){
            Object[] row={a.getVisitorId(),a.getFullName(),a.getGender(),a.getRegistrationDate(), a.getTicketType(),a.getticketCost(),a.getIsActive()};
            model.addRow(row);
        }
        JScrollPane tableScrollPane=new JScrollPane(table);
        tableScrollPane.setBounds(0, 250, 1030, 500);
        visitorDetailPanel.add(tableScrollPane);
        table.setBackground(new Color(231,232,231));
        table.setFont(new Font("Arial", Font.PLAIN, 12));
        table.setRowHeight(25);

        //saveButton
        JButton saveButton=new JButton("Save");
        saveButton.setFont(new Font("Arial", Font.BOLD, 12));
        saveButton.setBounds(600,205,50,20);  
        saveButton.setBorder(BorderFactory.createMatteBorder(0, 0, 4, 4, new Color(96,96,96)));//BorderFactory.createMatteBorder: lets you create a solid-colored border on specific sides of a component (top, left, bottom, right)
        saveButton.setBackground(new Color(144,144,144));
        saveButton.setForeground(Color.WHITE);
        saveButton.setFocusPainted(false);
        saveButton.setContentAreaFilled(true); 
        saveButton.setContentAreaFilled(false);
        saveButton.setOpaque(true); 
        visitorDetailPanel.add(saveButton);
        saveButton.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    saveButton.setBackground(new Color(184,184,184));
                    saveButton.setBorder(BorderFactory.createMatteBorder(0, 0, 4, 4, new Color(152,152,152)));
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                    saveButton.setBackground(new Color(144,144,144));
                    saveButton.setBorder(BorderFactory.createMatteBorder(0, 0, 4, 4, new Color(96,96,96)));
                }
            });

        // Update your saveButton ActionListener
        // Update your saveButton ActionListener
        saveButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //blank visitor detail and is going to save
                    if (artGalleryList.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "No data to save! Please add visitors first or read existing data.", "Warning", JOptionPane.WARNING_MESSAGE);
                        return;
                    }

                    try (BufferedWriter writer = new BufferedWriter(new FileWriter("visitors.txt"))) {
                        // Write header only once at the beginning
                        writer.write("                          Art Gallery Visitor Data\n");
                        writer.write("Visitor | FullName        | Gender |Contact    | Registeration | Ticket  | Ticket  | Active| Visit  | Reward  |   Cancel  |  Brought| Artwork | Artwork   |  Final  |   Discount   |   Visitor   | Special      |  Special\n");
                        writer.write("  ID    |                 |        |Number     | Date          | Type    |  Cost   | Status| Count  | Points  |   Count   |  Status | Name    | Price     |  Price  |   Amount     |   Type      | Attribute1   |   Attribute2\n");
                        writer.write("============================================================================================================================================================================================================================================\n");

                        for (ArtGalleryVisitor visitor : artGalleryList) {

                            // Write visitor data in a structured format with proper spacing
                            writer.write(String.format("%-10d", visitor.getVisitorId()));
                            writer.write(String.format("%-18s", visitor.getFullName()));
                            writer.write(String.format("%-8s", visitor.getGender()));
                            writer.write(String.format("%-13s", visitor.getContactNumber()));
                            writer.write(String.format("%-16s", visitor.getRegistrationDate()));
                            writer.write(String.format("%-10s", visitor.getTicketType()));
                            writer.write(String.format("%-10.1f", visitor.getticketCost()));
                            writer.write(String.format("%-8s", visitor.getIsActive()));
                            writer.write(String.format("%-10d", visitor.getVisitCount()));
                            writer.write(String.format("%-12.1f", visitor.getRewardPoints()));
                            writer.write(String.format("%-11d", visitor.getCancelCount()));
                            writer.write(String.format("%-8s", visitor.getisBought()));

                            // Write artwork details if purchased
                            if (visitor.getisBought()) {
                                writer.write(String.format("%-12s", visitor.getArtworkName()));
                                writer.write(String.format("%-13.2f", visitor.getArtworkPrice()));
                                writer.write(String.format("%-10.2f", visitor.getFinalPrice()));
                                writer.write(String.format("%-15.2f", visitor.getDiscountAmount()));
                            } else {
                                writer.write(String.format("%-12s", "N/A"));
                                writer.write(String.format("%-13s", "N/A"));
                                writer.write(String.format("%-10s", "N/A"));
                                writer.write(String.format("%-15s", "N/A"));
                            }

                            // Write visitor type and special attributes
                            if (visitor instanceof EliteVisitor) {
                                EliteVisitor elite = (EliteVisitor) visitor;
                                writer.write(String.format("%-11s", "Elite"));
                                writer.write(String.format("%-18s", elite.getAssignedPersonalArtAdvisor()));
                                writer.write(String.format("%-18s", elite.getExclusiveEventAccess()));
                            } else if (visitor instanceof StandardVisitor) {
                                StandardVisitor standard = (StandardVisitor) visitor;
                                writer.write(String.format("%-11s", "Standard"));
                                writer.write(String.format("%-18s", standard.getIsEligibleForDiscountUpgrade()));
                                writer.write(String.format("%-6.1f", standard.getDiscountPercent() * 100) + "%");
                            }

                            writer.newLine(); // Move to next line for next visitor
                        }

                        JOptionPane.showMessageDialog(null, "Data saved successfully to visitors.txt!", "Success", JOptionPane.INFORMATION_MESSAGE);
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(null, "Error saving data: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            });

        frame.addWindowListener(
            new WindowAdapter(){
                @Override
                public void windowClosing(WindowEvent w){
                    int choice = JOptionPane.showConfirmDialog(null,"Do you want to save before closing","Closing",JOptionPane.YES_NO_OPTION);
                    if(choice==JOptionPane.YES_OPTION){
                        //SAVE OPERATION
                        saveButton.doClick();
                        System.exit(0);
                    }else if(choice==JOptionPane.NO_OPTION){
                        System.exit(0);
                    }
                }
            }
        );

        //readButton
        JButton readButton=new JButton("Read");
        readButton.setFont(new Font("Arial", Font.BOLD, 12));
        readButton.setBounds(670,205,50,20);  
        readButton.setBorder(BorderFactory.createMatteBorder(0, 0, 4, 4, new Color(96,96,96)));//BorderFactory.createMatteBorder: lets you create a solid-colored border on specific sides of a component (top, left, bottom, right)
        readButton.setBackground(new Color(144,144,144));
        readButton.setForeground(Color.WHITE);
        readButton.setFocusPainted(false);
        readButton.setContentAreaFilled(true); 
        readButton.setContentAreaFilled(false);
        readButton.setOpaque(true); 
        visitorDetailPanel.add(readButton);

        readButton.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    readButton.setBackground(new Color(184,184,184));
                    readButton.setBorder(BorderFactory.createMatteBorder(0, 0, 4, 4, new Color(152,152,152)));
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                    readButton.setBackground(new Color(144,144,144));
                    readButton.setBorder(BorderFactory.createMatteBorder(0, 0, 4, 4, new Color(96,96,96)));
                }
            });

readButton.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        try (BufferedReader reader = new BufferedReader(new FileReader("visitors.txt"))) {
            artGalleryList.clear(); // Clear existing data
            model.setRowCount(0);   // Clear the table
            
            String line;
            boolean isHeader = true;
            int lineCount = 0;
            
            while ((line = reader.readLine()) != null) {
                lineCount++;
                
                // Skip header lines (first 4 lines)
                if (lineCount <= 4) {
                    continue;
                }
                
                // Skip empty lines or separator lines
                if (line.trim().isEmpty() || line.contains("===")) {
                    continue;
                }
                
                // Parse the fixed-width format
                try {
                    // Extract fields based on fixed positions (adjust as needed)
                    String visitorIdStr = line.substring(0, 10).trim();
                    String fullName = line.substring(10, 28).trim();
                    String gender = line.substring(28, 36).trim();
                    String contactNumber = line.substring(36, 49).trim();
                    String registrationDate = line.substring(49, 65).trim();
                    String ticketType = line.substring(65, 75).trim();
                    String ticketCostStr = line.substring(75, 85).trim();
                    String isActiveStr = line.substring(85, 93).trim();
                    String visitCountStr = line.substring(93, 103).trim();
                    String rewardPointsStr = line.substring(103, 115).trim();
                    String cancelCountStr = line.substring(115, 126).trim();
                    String isBoughtStr = line.substring(126, 134).trim();
                    
                    // Convert strings to appropriate types
                    int visitorId = Integer.parseInt(visitorIdStr);
                    double ticketCost = Double.parseDouble(ticketCostStr);
                    boolean isActive = "true".equalsIgnoreCase(isActiveStr);
                    int visitCount = Integer.parseInt(visitCountStr);
                    double rewardPoints = Double.parseDouble(rewardPointsStr);
                    int cancelCount = Integer.parseInt(cancelCountStr);
                    boolean isBought = "true".equalsIgnoreCase(isBoughtStr);
                    
                    ArtGalleryVisitor visitor;
                    
                    if ("Elite".equals(ticketType)) {
                        visitor = new EliteVisitor(visitorId, fullName, gender, contactNumber, 
                                registrationDate, ticketCost, ticketType);
                    } else {
                        visitor = new StandardVisitor(visitorId, fullName, gender, contactNumber, 
                                registrationDate, ticketCost, ticketType);
                    }
                    
                    // Set common properties
                    visitor.isActive = isActive;
                    visitor.visitCount = visitCount;
                    visitor.rewardPoints = rewardPoints;
                    visitor.cancelCount = cancelCount;
                    visitor.isBought = isBought;
                    
                    // Read artwork details if purchased
                    if (isBought) {
                        String artworkName = line.substring(134, 146).trim();
                        if (!"N/A".equals(artworkName)) {
                            String artworkPriceStr = line.substring(146, 159).trim();
                            String finalPriceStr = line.substring(159, 169).trim();
                            String discountAmountStr = line.substring(169, 184).trim();
                            
                            visitor.artworkName = artworkName;
                            visitor.artworkPrice = Double.parseDouble(artworkPriceStr);
                            visitor.finalPrice = Double.parseDouble(finalPriceStr);
                            visitor.discountAmount = Double.parseDouble(discountAmountStr);
                        }
                    }
                    
                    artGalleryList.add(visitor);
                    
                } catch (Exception ex) {
                    System.err.println("Error parsing line " + lineCount + ": " + line);
                    ex.printStackTrace();
                }
            }
            
            refreshTable(); // Refresh the table to show loaded data
            JOptionPane.showMessageDialog(null, "Data loaded successfully! Loaded " + artGalleryList.size() + " visitors.", "Success", JOptionPane.INFORMATION_MESSAGE);
            
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error reading data: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
});

        //Event
        homePanelButton.addActionListener(
            new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    homePanel.setVisible(true);
                    addVisitorPanel.setVisible(false);
                    transactionPanel.setVisible(false);
                    visitorDetailPanel.setVisible(false);

                }
            }
        );

        addVisitorButton.addActionListener(
            new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    homePanel.setVisible(false);
                    addVisitorPanel.setVisible(true);
                    transactionPanel.setVisible(false);
                    visitorDetailPanel.setVisible(false);
                }
            }
        );

        artworkButton.addActionListener(
            new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    homePanel.setVisible(false);
                    addVisitorPanel.setVisible(false);
                    transactionPanel.setVisible(true);
                    visitorDetailPanel.setVisible(false);
                }
            }
        );
        visitorDetailButton.addActionListener(
            new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    homePanel.setVisible(false);
                    addVisitorPanel.setVisible(false);
                    transactionPanel.setVisible(false);
                    visitorDetailPanel.setVisible(true);
                }
            }
        );

        //Message Dialog
        //Add Visitor warnings
        addButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if(idTextField.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "ID field cannot be empty!","Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    if(!idTextField.getText().matches("\\d+")) {
                        JOptionPane.showMessageDialog(null, "ID must contain only numbers!", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    if(nameTextField.getText().trim().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Full Name field cannot be empty!","Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    if(!nameTextField.getText().matches("[a-zA-Z\\s]+")) {//letter atoz or A-Z bayena banea
                        JOptionPane.showMessageDialog(null, "Name must contain only letters!", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    if(!maleRadioButton.isSelected() && !femaleRadioButton.isSelected() && !otherRadioButton.isSelected()) {
                        JOptionPane.showMessageDialog(null, "Please select a gender!","Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    if(contactTextField.getText().trim().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Contact Number field cannot be empty!","Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    if(!contactTextField.getText().matches("\\d{10}")) {
                        JOptionPane.showMessageDialog(null, "Contact Number should 10 digits!","Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    String ticketType = (String)ticketComboBox.getSelectedItem();
                    if("Select".equals(ticketType)) {
                        JOptionPane.showMessageDialog(null, "Please select a ticket type!", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    if(dayComboBox.getSelectedItem().equals("Day") ||  monthComboBox.getSelectedItem().equals("Month") || yearComboBox.getSelectedItem().equals("Year")) {
                        JOptionPane.showMessageDialog(null, "Please select a complete date (day, month, and year)!","Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    //duplicate id check
                    int visitorId = Integer.parseInt(idTextField.getText());
                    
                    boolean idExists = false;
                    for (ArtGalleryVisitor visitor : artGalleryList) {
                        if (visitor.getVisitorId() == visitorId) {
                            idExists = true;
                            break;
                        }
                    }
                    if (idExists) {
                        JOptionPane.showMessageDialog(null, "Visitor ID already exists!", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    //extracting data(for table)
                    try {
                        //int visitorId already declared above
                        String fullName = nameTextField.getText();
                        String gender = maleRadioButton.isSelected() ? "Male" : femaleRadioButton.isSelected() ? "Female" : "Other";
                        String contactNumber = contactTextField.getText();
                        String registrationDate = dayComboBox.getSelectedItem() + "/" + monthComboBox.getSelectedItem() + "/" + yearComboBox.getSelectedItem();
                        //String ticketType already declared above
                        double ticketPrice = Double.parseDouble(ticketPriceTextField.getText());

                        ArtGalleryVisitor newVisitor;  // Single declaration

                        if ("Elite".equals(ticketType)) {
                            newVisitor = new EliteVisitor(
                                visitorId,
                                fullName,
                                gender,
                                contactNumber,
                                registrationDate,
                                ticketPrice,
                                ticketType
                            );
                        } else {
                            newVisitor = new StandardVisitor(
                                visitorId,
                                fullName,
                                gender,
                                contactNumber,
                                registrationDate,
                                ticketPrice,
                                ticketType
                            );
                        }
                        artGalleryList.add(newVisitor);
                        refreshTable();
                        JOptionPane.showMessageDialog(null, "Visitor added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);

                        // Clear fields
                        idTextField.setText("");
                        nameTextField.setText("");
                        genderButtonGroup.clearSelection();
                        contactTextField.setText("");
                        dayComboBox.setSelectedIndex(0);
                        monthComboBox.setSelectedIndex(0);
                        yearComboBox.setSelectedIndex(0);
                        ticketComboBox.setSelectedIndex(0);
                        ticketPriceTextField.setText("");

                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Invalid ID or ticket price format!", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            });
        //Login
        loginButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if (loginIdTextField.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Please enter Visitor ID first!", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }else{
                        try {
                            int visitorId = Integer.parseInt(loginIdTextField.getText());
                            boolean found = false;
                            ArtGalleryVisitor visitor = null;
                            // checking id
                            for (ArtGalleryVisitor v : artGalleryList) {
                                if (v.getVisitorId() == visitorId) {
                                    visitor = v;
                                    found=true;
                                    break;
                                }
                            }
                            if(found){
                                visitor.logVisit();
                                refreshTable();
                                JOptionPane.showMessageDialog(null, "Login successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
                                loginIdTextField.setText("");
                            } else {
                                JOptionPane.showMessageDialog(null, "Visitor ID not found!", "Error", JOptionPane.ERROR_MESSAGE);
                            }
                        }catch (NumberFormatException ex) {
                            JOptionPane.showMessageDialog(null, "Visitor ID must be a number!", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
            });

        //Artwork warning
        // Buy Product warnings
        buyButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(transactionVisitorIdTextField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Visitor ID field cannot be empty!", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if(!transactionVisitorIdTextField.getText().matches("\\d+")) {
                    JOptionPane.showMessageDialog(null, "Visitor ID must contain only numbers!", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if(artworkNameTextField.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Artwork name cannot be empty!", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if(artworkPriceTextField.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Price field cannot be empty!", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if(!artworkPriceTextField.getText().matches("\\d+(\\.\\d+)?")) {
                    JOptionPane.showMessageDialog(null, "Price must be a valid number!", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                try {
                    int visitorId = Integer.parseInt(transactionVisitorIdTextField.getText());
                    String artworkName = artworkNameTextField.getText();
                    double artworkPrice = Double.parseDouble(artworkPriceTextField.getText());
                    ArtGalleryVisitor visitor = null;
                    for (ArtGalleryVisitor v : artGalleryList) {
                        if (v.getVisitorId() == visitorId) {
                            visitor = v;
                            break;
                        }
                    }
                    if (visitor == null) {
                        JOptionPane.showMessageDialog(null, "Visitor ID not found!", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    if (!visitor.getIsActive()) {
                        JOptionPane.showMessageDialog(null, "Visitor is not active. Please log a visit first.", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    
                    // Process the purchase
                    String result = visitor.buyProduct(artworkName, artworkPrice);
                    
                    if (result.contains("successful") || result.contains("successful")) {
                        // Calculate discount and final price
                        double discount = visitor.calculateDiscount();
                        double finalPrice = visitor.getFinalPrice();
                        
                        // Update reward points
                        visitor.calculateRewardPoint();
                    }
                    
                    JOptionPane.showMessageDialog(null, result, "Purchase Status", JOptionPane.INFORMATION_MESSAGE);
                    
                    // Clear input fields
                    artworkNameTextField.setText("");
                    artworkPriceTextField.setText("");
                    
                } catch(Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error processing purchase: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

         cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(transactionVisitorIdTextField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Visitor ID field cannot be empty!", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if(!transactionVisitorIdTextField.getText().matches("\\d+")) {
                    JOptionPane.showMessageDialog(null, "Visitor ID must contain only numbers!", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if(artworkNameTextField.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please enter the artwork name to cancel!", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if(reasonTextArea.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Cancellation reason cannot be empty!", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if(reasonTextArea.getText().length() < 10) {
                    JOptionPane.showMessageDialog(null, "Please provide a more detailed reason (at least 10 characters)", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                try {
                    int visitorId = Integer.parseInt(transactionVisitorIdTextField.getText());
                    String cancellationReason = reasonTextArea.getText();
                    String artworkNameToCancel = artworkNameTextField.getText();
                    
                    ArtGalleryVisitor visitor = null;
                    for (ArtGalleryVisitor v : artGalleryList) {
                        if (v.getVisitorId() == visitorId) {
                            visitor = v;
                            break;
                        }
                    }
                    if (visitor == null) {
                        JOptionPane.showMessageDialog(null, "Visitor ID not found!", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    if (!visitor.getIsActive()) {
                        JOptionPane.showMessageDialog(null, "Visitor is not active. Please log a visit first.", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    
                    // Process cancellation
                    String cancellationResult = visitor.cancelProduct(artworkNameToCancel, cancellationReason);
                    
                    String message = cancellationResult;
                    JOptionPane.showMessageDialog(null, message, "Cancellation Status", JOptionPane.INFORMATION_MESSAGE);
                    
                    // Clear input fields
                    reasonTextArea.setText("");
                    artworkNameTextField.setText("");
                    
                } catch(Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error processing cancellation: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        //discount Btn
        discountButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if(transactionVisitorIdTextField.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Visitor ID field cannot be empty!", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    if(!transactionVisitorIdTextField.getText().matches("\\d+")) {
                        JOptionPane.showMessageDialog(null, "Visitor ID must contain only numbers!", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    try {
                        int visitorId = Integer.parseInt(transactionVisitorIdTextField.getText());
                        ArtGalleryVisitor visitor = null;
                        for (ArtGalleryVisitor v : artGalleryList) {
                            if (v.getVisitorId() == visitorId) {
                                visitor = v;
                                break;
                            }
                        }
                        if (visitor == null) {
                            JOptionPane.showMessageDialog(null, "Visitor ID not found!", "Error", JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                        if (!visitor.getIsActive()) {
                            JOptionPane.showMessageDialog(null, "Visitor is not active. Please log a visit first.", "Error", JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                        if (!visitor.getisBought()) {
                            JOptionPane.showMessageDialog(null, "No artwork purchased yet. Cannot calculate discount.", "Error", JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                        double discount = visitor.calculateDiscount();
                        double finalPrice = visitor.getFinalPrice();
                        String message = "Discount Calculation:\n" +
                            "Artwork: " + visitor.getArtworkName() + "\n" +
                            "Original Price: " + visitor.getArtworkPrice() + "\n" +
                            "Discount Amount: " + discount + "\n" +
                            "Final Price: " + finalPrice;
                        JOptionPane.showMessageDialog(null, message, "Discount Calculation", JOptionPane.INFORMATION_MESSAGE);

                    } catch(Exception ex) {
                        JOptionPane.showMessageDialog(null, "Error calculating discount: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            });

        //ticket automatic uneditable price
        ticketComboBox.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String selectedType = (String)ticketComboBox.getSelectedItem();
                    if("Standard".equals(selectedType)) {
                        ticketPriceTextField.setText("1000");
                    } else if("Elite".equals(selectedType)) {
                        ticketPriceTextField.setText("2000");
                    }else {
                        ticketPriceTextField.setText(""); // Clear if "Select" is chosen
                    }
                }
            });
        //clearButton functionality
        clearButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    idTextField.setText("");
                    nameTextField.setText("");
                    genderButtonGroup.clearSelection();
                    contactTextField.setText("");
                    dayComboBox.setSelectedIndex(0);
                    monthComboBox.setSelectedIndex(0);
                    yearComboBox.setSelectedIndex(0);
                    ticketComboBox.setSelectedIndex(0); // Reset to "Select"
                    ticketPriceTextField.setText("");
                }
            }); 

        //artworktransaction Buttons
        //Art Advisor Btn
        artAdvisorButton.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e){
                    if (visitorIdTextField.getText().trim().isEmpty()){
                        JOptionPane.showMessageDialog(null, "Please enter Visitor ID first!", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    try{
                        int visitorId = Integer.parseInt(visitorIdTextField.getText().trim());
                        ArtGalleryVisitor visitor = null;
                        //cheacking the visitor id
                        for (ArtGalleryVisitor v : artGalleryList) {
                            if (v.getVisitorId() == visitorId) {
                                visitor = v;
                                break;
                            }
                        }
                        if (visitor == null) {
                            JOptionPane.showMessageDialog(null, "Visitor ID not found!", "Error", JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                        if (!(visitor instanceof EliteVisitor)) {
                            JOptionPane.showMessageDialog(null, "Only Elite visitors can have personal art advisors!", "Error", JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                        EliteVisitor eliteVisitor = (EliteVisitor) visitor;
                        if (!eliteVisitor.getIsActive()) {
                            JOptionPane.showMessageDialog(null, "Visitor is not active. Please log a visit first.", "Error", JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                        //Exclusive Event Access
                        boolean advisorAssigned = eliteVisitor.assignPersonalArtAdvisor();
                        boolean eventAccess = eliteVisitor.exclusiveEventAccess();
                        String message;
                        if (advisorAssigned){
                            message =" Congratulations! You have been assigned a personal art advisor.\nExclusive Event Access:Granted";
                            if (eventAccess) {
                                message += "Exclusive Event Access: Granted";
                            } else {
                                message += "Exclusive Event Access: Not Available";
                            }
                        }else{
                            message ="You currently don't qualify for a personal art advisor.\nYou need at least 5000 reward points to be eligible.\nYour current reward points:"+ eliteVisitor.getRewardPoints();
                        }
                        JOptionPane.showMessageDialog(null, message, "Art Advisor Status", JOptionPane.INFORMATION_MESSAGE);
                        refreshTable();
                    }catch (NumberFormatException ex){
                        JOptionPane.showMessageDialog(null, "Visitor ID must be a number!", "Error", JOptionPane.ERROR_MESSAGE);
                    }catch (IllegalArgumentException | IllegalStateException ex){
                        JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    }catch (Exception ex){
                        JOptionPane.showMessageDialog(null, "An error occurred: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            });
        //Upgrade Btn
        upgradeButton.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (visitorIdTextField.getText().trim().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Please enter Visitor ID first!", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    try{
                        int visitorId = Integer.parseInt(visitorIdTextField.getText().trim());
                        ArtGalleryVisitor visitor = null;
                        //cheacking the visitor id
                        for (ArtGalleryVisitor v : artGalleryList) {
                            if (v.getVisitorId() == visitorId) {
                                visitor = v;
                                break;
                            }
                        }
                        if (visitor == null) {
                            JOptionPane.showMessageDialog(null, "Visitor ID not found!", "Error", JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                        if (!(visitor instanceof StandardVisitor)) {
                            JOptionPane.showMessageDialog(null, "Only Standard visitors can check for discount upgrades!", "Error", JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                        StandardVisitor standardVisitor = (StandardVisitor) visitor;
                        if (!standardVisitor.getIsActive()) {
                            JOptionPane.showMessageDialog(null, "Visitor is not active. Please log a visit first.", "Error", JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                        boolean upgraded = standardVisitor.checkDiscountUpgrade();
                        float currentDiscount = standardVisitor.getDiscountPercent() * 100;
                        String message;
                        if (upgraded) {
                            message = "Congratulations! Your discount has been upgraded to " + currentDiscount + "%!\n";
                        } else {
                            int visitsNeeded = standardVisitor.getVisitLimit() - standardVisitor.getVisitCount();
                            message = "Current Discount: " + currentDiscount + "%\n";
                            message += "You need " + visitsNeeded + " more visits to qualify for upgrade.";
                        }
                        JOptionPane.showMessageDialog(null, message, "Discount Upgrade Status", JOptionPane.INFORMATION_MESSAGE);
                        refreshTable();
                    }catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Visitor ID must be a number!", "Error", JOptionPane.ERROR_MESSAGE);
                    }catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "An error occurred: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            });            

        //rewardPointsButton
        rewardPointsButton.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        if (visitorIdTextField.getText().trim().isEmpty()) {
                            throw new IllegalArgumentException("Please enter Visitor ID first!");
                        }
                        int visitorId;
                        try {
                            visitorId = Integer.parseInt(visitorIdTextField.getText().trim());
                        } catch (NumberFormatException ex) {
                            throw new IllegalArgumentException("Visitor ID must be a number!");
                        }
                        //cheacking the visitor id
                        ArtGalleryVisitor visitor = null;
                        for (ArtGalleryVisitor v : artGalleryList) {
                            if (v.getVisitorId() == visitorId) {
                                visitor = v;
                                break;
                            }
                        }
                        // Check visitor status
                        if (!visitor.getIsActive()) {
                            JOptionPane.showMessageDialog(null, "Visitor is not active. Please log a visit first.", "Error", JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                        if (!visitor.getisBought()) {
                            JOptionPane.showMessageDialog(null, "No artwork purchased yet. Cannot calculate reward points.", "Error", JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                        double rewardPoints = 0.0;
                        if(visitor.getDiscountAmount() != 0.0){
                            rewardPoints = visitor.calculateRewardPoint();
                        }else{
                            JOptionPane.showMessageDialog(null,"Please calculate discount first");
                            return;
                        }

                        String visitorType = (visitor instanceof EliteVisitor) ? "Elite" : "Standard";// If visitor is EliteVisitor, assign "Elite". Else, "Standard"
                        JOptionPane.showMessageDialog(null,
                            "Reward Points Calculated!\n" +
                            "Visitor ID: " + visitorId + "\n" +
                            "Visitor Type: " + visitorType + "\n" +
                            "Current Reward Points: " + rewardPoints,
                            "Reward Points", JOptionPane.INFORMATION_MESSAGE);
                        refreshTable();   
                    }catch (IllegalArgumentException | IllegalStateException ex){
                        JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
                    }catch (Exception ex) {
                        JOptionPane.showMessageDialog(null,"An unexpected error occurred: " + ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
                    }
                }
            });

        frame.setVisible(true);
    }
    
   // Bill generation
    private void generateBillFile(ArtGalleryVisitor visitor) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Bill.txt"))) {
            
            writer.write("============================================\n");
            writer.write("              ART GALLERY BILL\n");
            writer.write("============================================\n");
            writer.write(String.format("Bill Date: %s\n", java.time.LocalDate.now()));
            writer.write(String.format("Bill Time: %s\n", java.time.LocalTime.now()));
            writer.write("--------------------------------------------\n");
            writer.write(String.format("Visitor ID: %d\n", visitor.getVisitorId()));
            writer.write(String.format("Visitor Name: %s\n", visitor.getFullName()));
            writer.write(String.format("Visitor Type: %s\n", visitor.getTicketType()));
            writer.write("--------------------------------------------\n");
            writer.write("PURCHASED ARTWORKS:\n");
            writer.write("--------------------------------------------\n");


            if (visitor.getisBought()) {
                writer.write(String.format("Artwork: %s\n", visitor.getArtworkName()));
                writer.write(String.format("  Original Price: Rs. %.2f\n", visitor.getArtworkPrice()));
                writer.write(String.format("  Discount: Rs. %.2f\n", visitor.getDiscountAmount()));
                writer.write(String.format("  Final Price: Rs. %.2f\n", visitor.getFinalPrice()));
                writer.write("--------------------------------------------\n");
                
                writer.write(String.format("TOTAL ORIGINAL PRICE: Rs. %.2f\n", visitor.getArtworkPrice()));
                writer.write(String.format("TOTAL DISCOUNT: Rs. %.2f\n", visitor.getDiscountAmount()));
                writer.write(String.format("TOTAL FINAL PRICE: Rs. %.2f\n", visitor.getFinalPrice()));
            } else {
                writer.write("No artwork purchased.\n");
            }
            
            writer.write("--------------------------------------------\n");
            writer.write(String.format("REWARD POINTS EARNED: %.1f\n", visitor.getRewardPoints()));
            writer.write("============================================\n");
            writer.write("          Thank you for your visit!\n");
            writer.write("============================================\n");

            JOptionPane.showMessageDialog(null, "Bill generated successfully in Bill.txt!", "Bill Generated", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error generating bill: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    //refresh 
    private void refreshTable() {
        this.model.setRowCount(0); // Clear existing data
        for (ArtGalleryVisitor visitor : artGalleryList) {
            model.addRow(new Object[]{
                    visitor.getVisitorId(),
                    visitor.getFullName(),
                    visitor.getGender(),
                    visitor.getContactNumber(),
                    visitor.getRegistrationDate(),
                    visitor.getTicketType(),
                    visitor.getticketCost(),
                    visitor.getIsActive(),
                    visitor.getVisitCount()

                });
        }
    }

    public static void main(String[] args) {
        new ArtGalleryGUI();
    }   
}


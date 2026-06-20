import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class StudentSystem extends JFrame implements ActionListener {

    JLabel titleLabel;
    JLabel nameLabel, ageLabel, courseLabel, genderLabel, skillsLabel;

    JTextField nameField, ageField;

    JComboBox<String> courseBox;

    JRadioButton male, female;
    ButtonGroup genderGroup;

    JCheckBox java, python, dbms;

    JButton submitBtn, clearBtn;

    JTextArea displayArea;

    JMenuBar menuBar;
    JMenu fileMenu, helpMenu;
    JMenuItem exitItem, aboutItem;

    StudentSystem() {

        setTitle("Student Registration System");
        setSize(900, 600);
        setLayout(new BorderLayout());

        // ===== COLORS =====

        Color bgColor = new Color(24, 28, 36);
        Color panelColor = new Color(35, 42, 52);
        Color accentColor = new Color(0, 170, 255);
        Color textColor = Color.WHITE;

        Font headingFont =
                new Font("Segoe UI", Font.BOLD, 26);

        Font normalFont =
                new Font("Segoe UI", Font.BOLD, 16);

        // ===== MENU BAR =====

        menuBar = new JMenuBar();

        fileMenu = new JMenu("File");
        helpMenu = new JMenu("Help");

        exitItem = new JMenuItem("Exit");
        aboutItem = new JMenuItem("About");

        fileMenu.add(exitItem);
        helpMenu.add(aboutItem);

        menuBar.add(fileMenu);
        menuBar.add(helpMenu);

        setJMenuBar(menuBar);

        exitItem.addActionListener(this);
        aboutItem.addActionListener(this);

        // ===== TITLE =====

        titleLabel =
                new JLabel(
                        "STUDENT REGISTRATION SYSTEM",
                        JLabel.CENTER);

        titleLabel.setFont(headingFont);
        titleLabel.setForeground(accentColor);

        add(titleLabel, BorderLayout.NORTH);

        // ===== LEFT PANEL =====

        JPanel formPanel = new JPanel();

        formPanel.setLayout(
                new GridLayout(8, 2, 10, 10));

        formPanel.setBackground(panelColor);

        nameLabel = new JLabel("Student Name");
        ageLabel = new JLabel("Age");
        genderLabel = new JLabel("Gender");
        courseLabel = new JLabel("Course");
        skillsLabel = new JLabel("Skills");

        nameLabel.setForeground(textColor);
        ageLabel.setForeground(textColor);
        genderLabel.setForeground(textColor);
        courseLabel.setForeground(textColor);
        skillsLabel.setForeground(textColor);

        nameLabel.setFont(normalFont);
        ageLabel.setFont(normalFont);
        genderLabel.setFont(normalFont);
        courseLabel.setFont(normalFont);
        skillsLabel.setFont(normalFont);

        // ===== TEXTFIELDS =====

        nameField = new JTextField(30);
        ageField = new JTextField(5);

        nameField.setFont(normalFont);
        ageField.setFont(normalFont);

        // ===== GENDER =====

        male = new JRadioButton("Male");
        female = new JRadioButton("Female");

        male.setBackground(panelColor);
        female.setBackground(panelColor);

        male.setForeground(textColor);
        female.setForeground(textColor);

        genderGroup = new ButtonGroup();

        genderGroup.add(male);
        genderGroup.add(female);

        JPanel genderPanel = new JPanel();

        genderPanel.setBackground(panelColor);

        genderPanel.add(male);
        genderPanel.add(female);

        // ===== COURSE =====

        String courses[] = {
                "BSc Computer Science",
                "BSc Biotechnology",
                "BCA",
                "BBA",
                "Engineering"
        };

        courseBox =
                new JComboBox<>(courses);

        courseBox.setFont(normalFont);

        // ===== SKILLS =====

        java = new JCheckBox("Java");
        python = new JCheckBox("Python");
        dbms = new JCheckBox("DBMS");

        java.setBackground(panelColor);
        python.setBackground(panelColor);
        dbms.setBackground(panelColor);

        java.setForeground(textColor);
        python.setForeground(textColor);
        dbms.setForeground(textColor);

        JPanel skillPanel = new JPanel();

        skillPanel.setBackground(panelColor);

        skillPanel.add(java);
        skillPanel.add(python);
        skillPanel.add(dbms);

        // ===== BUTTONS =====

        submitBtn = new JButton("Submit");
        clearBtn = new JButton("Clear");

        submitBtn.addActionListener(this);
        clearBtn.addActionListener(this);

        submitBtn.setFont(normalFont);
        clearBtn.setFont(normalFont);

        submitBtn.setBackground(accentColor);
        clearBtn.setBackground(Color.ORANGE);

        submitBtn.setForeground(Color.WHITE);
        clearBtn.setForeground(Color.BLACK);

        // ===== ADD TO FORM =====

        formPanel.add(nameLabel);
        formPanel.add(nameField);

        formPanel.add(ageLabel);
        formPanel.add(ageField);

        formPanel.add(genderLabel);
        formPanel.add(genderPanel);

        formPanel.add(courseLabel);
        formPanel.add(courseBox);

        formPanel.add(skillsLabel);
        formPanel.add(skillPanel);

        formPanel.add(submitBtn);
        formPanel.add(clearBtn);

        add(formPanel, BorderLayout.WEST);

        // ===== TEXT AREA =====

        displayArea = new JTextArea();

        displayArea.setFont(
                new Font(
                        "Consolas",
                        Font.BOLD,
                        16));

        displayArea.setBackground(
                new Color(18, 22, 28));

        displayArea.setForeground(
                Color.GREEN);

        JScrollPane scroll =
                new JScrollPane(displayArea);

        add(scroll, BorderLayout.CENTER);

        getContentPane().setBackground(bgColor);

        setDefaultCloseOperation(
                JFrame.EXIT_ON_CLOSE);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == submitBtn) {

            String name =
                    nameField.getText();

            String age =
                    ageField.getText();

            String gender = "";

            if (male.isSelected())
                gender = "Male";

            if (female.isSelected())
                gender = "Female";

            String course =
                    (String) courseBox.getSelectedItem();

            String skills = "";

            if (java.isSelected())
                skills += "Java ";

            if (python.isSelected())
                skills += "Python ";

            if (dbms.isSelected())
                skills += "DBMS ";

            displayArea.append(
                    "\n========================\n");

            displayArea.append(
                    "Name : " + name + "\n");

            displayArea.append(
                    "Age : " + age + "\n");

            displayArea.append(
                    "Gender : " + gender + "\n");

            displayArea.append(
                    "Course : " + course + "\n");

            displayArea.append(
                    "Skills : " + skills + "\n");

            JOptionPane.showMessageDialog(
                    this,
                    "Student Registered Successfully");
        }

        if (e.getSource() == clearBtn) {

            nameField.setText("");
            ageField.setText("");

            genderGroup.clearSelection();

            java.setSelected(false);
            python.setSelected(false);
            dbms.setSelected(false);

            JOptionPane.showMessageDialog(
                    this,
                    "Form Cleared");
        }

        if (e.getSource() == exitItem) {

            System.exit(0);
        }

        if (e.getSource() == aboutItem) {

            JOptionPane.showMessageDialog(
                    this,
                    "Student Registration System\nDeveloped using Java Swing");
        }
    }
}

public class Main {

    public static void main(String[] args) {

        new StudentSystem();

    }
}
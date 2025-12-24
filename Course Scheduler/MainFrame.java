import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.Calendar;


public class MainFrame extends javax.swing.JFrame {

    // Creates New Form MainFrame

    private String currentSemester;
    private String author;
    private String project;

    public MainFrame() {
        initComponents();
        checkData();
        rebuildSemesterComboBoxes();
        rebuildStudentComboBoxes();
        rebuildCourseCodeComboBoxes();
        rebuildClassComboBoxes(); 
    }

    public void rebuildSemesterComboBoxes() {
        ArrayList<String> semesters = SemesterQueries.getSemesterList();
        currentSemesterComboBox.setModel(new javax.swing.DefaultComboBoxModel(semesters.toArray()));
        
        if (semesters.size() > 0) {
            currentSemesterLabel.setText(semesters.get(0));
            currentSemester = semesters.get(0);
        } else {
            currentSemesterLabel.setText("None, add a semester.");
            currentSemester = "None";
        }
    }
    
    public void rebuildStudentComboBoxes() {
        ArrayList<StudentEntry> studentList = StudentQueries.getAllStudents();
        selectStudentComboBox.setModel(new javax.swing.DefaultComboBoxModel(studentList.toArray()));
        displayScheduleStudentComboBox.setModel(new javax.swing.DefaultComboBoxModel(studentList.toArray()));
        adminDropStudentComboBox.setModel(new javax.swing.DefaultComboBoxModel(studentList.toArray()));
        studentDropClassStudentComboBox.setModel(new javax.swing.DefaultComboBoxModel(studentList.toArray()));
    }
    
    public void rebuildCourseCodeComboBoxes() {
        ArrayList<String> courseCodeList = CourseQueries.getAllCourseCodes();
        addClassCourseCodeComboBox.setModel(new javax.swing.DefaultComboBoxModel(courseCodeList.toArray()));
    }
    
    public void rebuildClassComboBoxes() {
        ArrayList<String> classList = ClassQueries.getAllCourseCodes(currentSemester);
        selectClassComboBox.setModel(new javax.swing.DefaultComboBoxModel(classList.toArray()));
        displayClassListComboBox.setModel(new javax.swing.DefaultComboBoxModel(classList.toArray()));
        adminDropClassComboBox.setModel(new javax.swing.DefaultComboBoxModel(classList.toArray()));
        studentDropClassClassComboBox.setModel(new javax.swing.DefaultComboBoxModel(classList.toArray()));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel10 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        addSemesterTextfield = new javax.swing.JTextField();
        addSemesterSubmitButton = new javax.swing.JButton();
        addSemesterStatusLabel = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        addCourseCodeTextField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        addCourseDescriptionTextField = new javax.swing.JTextField();
        addCourseSubmitButton = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        addCourseStatusLabel = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        addStudentIDTextField = new javax.swing.JTextField();
        addStudentFirstNameTextField = new javax.swing.JTextField();
        addStudentLastNameTextField = new javax.swing.JTextField();
        addStudentSubmitButton = new javax.swing.JButton();
        addStudentStatusLabel = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        addClassCourseCodeComboBox = new javax.swing.JComboBox<>();
        addClassSeatsSpinner = new javax.swing.JSpinner();
        addClassSubmitButton = new javax.swing.JButton();
        addClassStatusLabel = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        displayClassListComboBox = new javax.swing.JComboBox<>();
        displayClassListDisplayButton = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        displayClassListWaitlistedTable = new javax.swing.JTable();
        jScrollPane6 = new javax.swing.JScrollPane();
        displayClassListScheduledStudentsTable = new javax.swing.JTable();
        jLabel17 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        adminDropStudentComboBox = new javax.swing.JComboBox<>();
        dropStudentSubmitButton = new javax.swing.JButton();
        jScrollPane7 = new javax.swing.JScrollPane();
        dropStudentTextArea = new javax.swing.JTextArea();
        jPanel13 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        adminDropClassComboBox = new javax.swing.JComboBox<>();
        adminDropClassSubmitButton = new javax.swing.JButton();
        jScrollPane9 = new javax.swing.JScrollPane();
        adminDropClassTextArea = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        displayClassesTextArea = new javax.swing.JTextArea();
        displayClassesDisplayButton = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        selectClassComboBox = new javax.swing.JComboBox<>();
        selectStudentComboBox = new javax.swing.JComboBox<>();
        ScheduleClassSubmitButton = new javax.swing.JButton();
        ScheduleClassStatusLabel = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        displayScheduleTextArea = new javax.swing.JTextArea();
        displayScheduleDisplayButton = new javax.swing.JButton();
        displayScheduleStudentComboBox = new javax.swing.JComboBox<>();
        jPanel14 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        studentDropClassStudentComboBox = new javax.swing.JComboBox<>();
        jLabel20 = new javax.swing.JLabel();
        studentDropClassClassComboBox = new javax.swing.JComboBox<>();
        studentDropClassSubmitButton = new javax.swing.JButton();
        jScrollPane8 = new javax.swing.JScrollPane();
        studentDropClassTextArea = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        currentSemesterLabel = new javax.swing.JLabel();
        currentSemesterComboBox = new javax.swing.JComboBox<>();
        changeSemesterButton = new javax.swing.JButton();
        aboutButton = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 1, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 153, 153));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Course Scheduler");

        jLabel3.setText("Semester Name:");

        addSemesterTextfield.setColumns(20);
        addSemesterTextfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addSemesterTextfieldActionPerformed(evt);
            }
        });

        addSemesterSubmitButton.setText("Submit");
        addSemesterSubmitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addSemesterSubmitButtonActionPerformed(evt);
            }
        });

        addSemesterStatusLabel.setText("                                                   ");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(addSemesterSubmitButton)
                    .addComponent(addSemesterStatusLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(addSemesterTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(332, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(addSemesterTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addComponent(addSemesterSubmitButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(addSemesterStatusLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Add Semester", jPanel3);

        jLabel4.setText("Course Code:");

        addCourseCodeTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addCourseCodeTextFieldActionPerformed(evt);
            }
        });

        jLabel5.setText("Course Description:");

        addCourseDescriptionTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addCourseDescriptionTextFieldActionPerformed(evt);
            }
        });

        addCourseSubmitButton.setText("Submit");
        addCourseSubmitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addCourseSubmitButtonActionPerformed(evt);
            }
        });

        addCourseStatusLabel.setText("                        ");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(addCourseSubmitButton)
                    .addComponent(addCourseStatusLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(31, 31, 31)
                        .addComponent(jLabel6)
                        .addGap(482, 482, 482)
                        .addComponent(jLabel7))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(addCourseCodeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(addCourseDescriptionTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(51, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(addCourseCodeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addCourseDescriptionTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(addCourseSubmitButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(addCourseStatusLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jLabel7)
                .addGap(23, 23, 23)
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Add Course", jPanel4);

        jLabel8.setText("Student ID:");

        jLabel9.setText("First Name:");

        jLabel10.setText("Last Name:");

        addStudentIDTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addStudentIDTextFieldActionPerformed(evt);
            }
        });

        addStudentSubmitButton.setText("Submit");
        addStudentSubmitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addStudentSubmitButtonActionPerformed(evt);
            }
        });

        addStudentStatusLabel.setText("                            ");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(addStudentSubmitButton)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(12, 12, 12)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(addStudentIDTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(addStudentFirstNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(addStudentLastNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(addStudentStatusLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 462, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(272, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(addStudentIDTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(addStudentFirstNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(addStudentLastNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(addStudentSubmitButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(addStudentStatusLabel)
                .addContainerGap(95, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Add Student", jPanel6);

        jLabel11.setText("Course Code:");

        jLabel12.setText("Seats:");

        addClassCourseCodeComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        addClassCourseCodeComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addClassCourseCodeComboBoxActionPerformed(evt);
            }
        });

        addClassSubmitButton.setText("Submit");
        addClassSubmitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addClassSubmitButtonActionPerformed(evt);
            }
        });

        addClassStatusLabel.setText("                  ");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(addClassSubmitButton)
                    .addComponent(addClassStatusLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 506, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(addClassCourseCodeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(addClassSeatsSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(226, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(addClassCourseCodeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addClassSeatsSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(addClassSubmitButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(addClassStatusLabel)
                .addContainerGap(131, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Add Class", jPanel7);

        jLabel15.setText("Choose Class:");

        displayClassListComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        displayClassListComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                displayClassListComboBoxActionPerformed(evt);
            }
        });

        displayClassListDisplayButton.setText("Display");
        displayClassListDisplayButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                displayClassListDisplayButtonActionPerformed(evt);
            }
        });

        jLabel16.setText("Scheduled Students in the Class");

        displayClassListWaitlistedTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Last Name", "First Name", "Student ID"
            }
        ));
        jScrollPane4.setViewportView(displayClassListWaitlistedTable);

        displayClassListScheduledStudentsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Last Name", "First Name", "Student ID"
            }
        ));
        jScrollPane6.setViewportView(displayClassListScheduledStudentsTable);

        jLabel17.setText("Waitlisted Students in the Class in Waitlist Order");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel16)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(displayClassListComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(displayClassListDisplayButton)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel17)
                .addGap(83, 83, 83))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(displayClassListComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(displayClassListDisplayButton)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(jLabel17))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Display Class List", jPanel11);

        jLabel18.setText("Choose Student:");

        adminDropStudentComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        adminDropStudentComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adminDropStudentComboBoxActionPerformed(evt);
            }
        });

        dropStudentSubmitButton.setText("Submit");
        dropStudentSubmitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dropStudentSubmitButtonActionPerformed(evt);
            }
        });

        dropStudentTextArea.setColumns(20);
        dropStudentTextArea.setRows(5);
        jScrollPane7.setViewportView(dropStudentTextArea);

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane7)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(adminDropStudentComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dropStudentSubmitButton)
                        .addGap(0, 336, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(adminDropStudentComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dropStudentSubmitButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Drop Student", jPanel12);

        jLabel21.setText("Choose Class:");

        adminDropClassComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        adminDropClassComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adminDropClassComboBoxActionPerformed(evt);
            }
        });

        adminDropClassSubmitButton.setText("Submit");
        adminDropClassSubmitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adminDropClassSubmitButtonActionPerformed(evt);
            }
        });

        adminDropClassTextArea.setColumns(20);
        adminDropClassTextArea.setRows(5);
        jScrollPane9.setViewportView(adminDropClassTextArea);

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 719, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jLabel21)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(adminDropClassComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(adminDropClassSubmitButton)))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(adminDropClassComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(adminDropClassSubmitButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Drop Class", jPanel13);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 750, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Admin", jPanel1);

        displayClassesTextArea.setColumns(20);
        displayClassesTextArea.setRows(5);
        jScrollPane3.setViewportView(displayClassesTextArea);

        displayClassesDisplayButton.setText("Display");
        displayClassesDisplayButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                displayClassesDisplayButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 709, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(314, 314, 314)
                .addComponent(displayClassesDisplayButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(displayClassesDisplayButton)
                .addGap(16, 16, 16))
        );

        jTabbedPane3.addTab("Display Classes", jPanel5);

        jLabel13.setText("Select Class:");

        jLabel14.setText("Select Student:");

        selectClassComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        selectClassComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectClassComboBoxActionPerformed(evt);
            }
        });

        selectStudentComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        selectStudentComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectStudentComboBoxActionPerformed(evt);
            }
        });

        ScheduleClassSubmitButton.setText("Submit");
        ScheduleClassSubmitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ScheduleClassSubmitButtonActionPerformed(evt);
            }
        });

        ScheduleClassStatusLabel.setText("          ");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ScheduleClassSubmitButton)
                    .addComponent(ScheduleClassStatusLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 459, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addComponent(jLabel13))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(selectClassComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(selectStudentComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(248, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(selectClassComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(selectStudentComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(ScheduleClassSubmitButton)
                .addGap(18, 18, 18)
                .addComponent(ScheduleClassStatusLabel)
                .addContainerGap(104, Short.MAX_VALUE))
        );

        jTabbedPane3.addTab("Schedule Class", jPanel8);

        displayScheduleTextArea.setColumns(20);
        displayScheduleTextArea.setRows(5);
        jScrollPane5.setViewportView(displayScheduleTextArea);

        displayScheduleDisplayButton.setText("Display");
        displayScheduleDisplayButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                displayScheduleDisplayButtonActionPerformed(evt);
            }
        });

        displayScheduleStudentComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        displayScheduleStudentComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                displayScheduleStudentComboBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 709, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(displayScheduleStudentComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(displayScheduleDisplayButton)
                        .addGap(248, 248, 248))))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(displayScheduleDisplayButton, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(displayScheduleStudentComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
        );

        jTabbedPane3.addTab("Display Schedule", jPanel9);

        jLabel19.setText("Choose Student:");

        studentDropClassStudentComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        studentDropClassStudentComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studentDropClassStudentComboBoxActionPerformed(evt);
            }
        });

        jLabel20.setText("Choose Class:");

        studentDropClassClassComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        studentDropClassClassComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studentDropClassClassComboBoxActionPerformed(evt);
            }
        });

        studentDropClassSubmitButton.setText("Submit");
        studentDropClassSubmitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studentDropClassSubmitButtonActionPerformed(evt);
            }
        });

        studentDropClassTextArea.setColumns(20);
        studentDropClassTextArea.setRows(5);
        jScrollPane8.setViewportView(studentDropClassTextArea);

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane8)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(studentDropClassStudentComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel20)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(studentDropClassClassComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(studentDropClassSubmitButton)
                        .addContainerGap(81, Short.MAX_VALUE))))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(studentDropClassStudentComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20)
                    .addComponent(studentDropClassClassComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(studentDropClassSubmitButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jTabbedPane3.addTab("Drop Class", jPanel14);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jTabbedPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 721, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 29, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jTabbedPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Student", jPanel2);

        jLabel2.setFont(new java.awt.Font("Comic Sans MS", 1, 16)); // NOI18N
        jLabel2.setText("Current Semester: ");

        currentSemesterLabel.setFont(new java.awt.Font("Comic Sans MS", 0, 16)); // NOI18N
        currentSemesterLabel.setText("           ");

        currentSemesterComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        currentSemesterComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                currentSemesterComboBoxActionPerformed(evt);
            }
        });

        changeSemesterButton.setText("Change Semester");
        changeSemesterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeSemesterButtonActionPerformed(evt);
            }
        });

        aboutButton.setText("About");
        aboutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(currentSemesterLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(currentSemesterComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(changeSemesterButton)
                                .addGap(31, 31, 31)
                                .addComponent(aboutButton)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(currentSemesterLabel)
                    .addComponent(currentSemesterComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(changeSemesterButton)
                    .addComponent(aboutButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void aboutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutButtonActionPerformed
        // display about information.
        JOptionPane.showMessageDialog(null, "Author: " + author + " Project: " + project);
    }//GEN-LAST:event_aboutButtonActionPerformed
                             
    private void currentSemesterComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_currentSemesterComboBoxActionPerformed

    }//GEN-LAST:event_currentSemesterComboBoxActionPerformed

    private void changeSemesterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeSemesterButtonActionPerformed
        currentSemester = (String) currentSemesterComboBox.getSelectedItem();
        currentSemesterLabel.setText(currentSemester);
        rebuildCourseCodeComboBoxes();
        rebuildClassComboBoxes();
    }//GEN-LAST:event_changeSemesterButtonActionPerformed

    private void displayScheduleStudentComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_displayScheduleStudentComboBoxActionPerformed

    }//GEN-LAST:event_displayScheduleStudentComboBoxActionPerformed

    private void displayScheduleDisplayButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_displayScheduleDisplayButtonActionPerformed
        displayScheduleTextArea.setText(String.format("%s\t%-20s\n", "Course Code", "Status"));
        String studentID = (String) ((StudentEntry) displayScheduleStudentComboBox.getSelectedItem()).getStudentID();
        ArrayList<ScheduleEntry> scheduleList = ScheduleQueries.getScheduleByStudent(currentSemester, studentID);

        for (ScheduleEntry scheduleEntry : scheduleList) {
            String courseCode = scheduleEntry.getCourseCode();
            String status = scheduleEntry.getStatus();
            displayScheduleTextArea.append(String.format("%s\t%-20s\n", courseCode, status));
        }
    }//GEN-LAST:event_displayScheduleDisplayButtonActionPerformed

    private void ScheduleClassSubmitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ScheduleClassSubmitButtonActionPerformed
        String selectedClass = (String) selectClassComboBox.getSelectedItem();
        String selectedStudent = (String) ((StudentEntry) selectStudentComboBox.getSelectedItem()).getStudentID();
        java.sql.Timestamp currentTimestamp = new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());
        String status = "";

        if (ScheduleQueries.getScheduledStudentCount(currentSemester, selectedClass)
            >= ClassQueries.getClassSeats(currentSemester, selectedClass)) {
            status = "Waitlisted";
        }   else {
            status = "Scheduled";
        }

        ScheduleEntry newSchedule = new ScheduleEntry(currentSemester, selectedClass, selectedStudent, status, currentTimestamp);
        ScheduleQueries.addScheduleEntry(newSchedule);

        if (status == "Waitlisted") {
            ScheduleClassStatusLabel.setText(selectStudentComboBox.getSelectedItem() + " has been waitlisted for this class.");
        }   else {
            ScheduleClassStatusLabel.setText(selectStudentComboBox.getSelectedItem() + " has been scheduled for this class.");
        }

    }//GEN-LAST:event_ScheduleClassSubmitButtonActionPerformed

    private void selectStudentComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectStudentComboBoxActionPerformed

    }//GEN-LAST:event_selectStudentComboBoxActionPerformed

    private void selectClassComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectClassComboBoxActionPerformed

    }//GEN-LAST:event_selectClassComboBoxActionPerformed

    private void displayClassesDisplayButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_displayClassesDisplayButtonActionPerformed
        ArrayList<ClassDescription> classList = MultiTableQueries.getAllClassDescriptions(currentSemester);
        displayClassesTextArea.setText(String.format("%s\t%-20s\t%-20s\n", "Course Code", "Description", "Seats"));

        for (ClassDescription classEntry : classList) {
            displayClassesTextArea.append(String.format("%s\t%-20s\t%-20s\n", classEntry.getCourseCode(), classEntry.getDescription(), classEntry.getSeats()));
        }
    }//GEN-LAST:event_displayClassesDisplayButtonActionPerformed

    private void addClassSubmitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addClassSubmitButtonActionPerformed
        String courseCode = (String) addClassCourseCodeComboBox.getSelectedItem();
        Integer seats = (Integer) addClassSeatsSpinner.getValue();
        ClassEntry newClass = new ClassEntry(currentSemester, courseCode, seats);
        ClassQueries.addClass(newClass);
        addClassStatusLabel.setText("Class " + courseCode + " has been added.");
        rebuildClassComboBoxes();
    }//GEN-LAST:event_addClassSubmitButtonActionPerformed

    private void addClassCourseCodeComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addClassCourseCodeComboBoxActionPerformed

    }//GEN-LAST:event_addClassCourseCodeComboBoxActionPerformed

    private void addStudentSubmitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addStudentSubmitButtonActionPerformed
        String studentID = addStudentIDTextField.getText();
        String firstName = addStudentFirstNameTextField.getText();
        String lastName = addStudentLastNameTextField.getText();
        StudentEntry newStudent = new StudentEntry(studentID, firstName, lastName);
        StudentQueries.addStudent(newStudent);
        addStudentStatusLabel.setText(lastName + ", " + firstName + " has been added.");
        rebuildStudentComboBoxes();
    }//GEN-LAST:event_addStudentSubmitButtonActionPerformed

    private void addStudentIDTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addStudentIDTextFieldActionPerformed

    }//GEN-LAST:event_addStudentIDTextFieldActionPerformed

    private void addCourseSubmitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addCourseSubmitButtonActionPerformed
        String courseCode = addCourseCodeTextField.getText();
        String description = addCourseDescriptionTextField.getText();
        CourseEntry newCourse = new CourseEntry(courseCode, description);
        CourseQueries.addCourse(newCourse);
        addCourseStatusLabel.setText(courseCode + " has been added.");
        rebuildCourseCodeComboBoxes();
    }//GEN-LAST:event_addCourseSubmitButtonActionPerformed

    private void addCourseDescriptionTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addCourseDescriptionTextFieldActionPerformed

    }//GEN-LAST:event_addCourseDescriptionTextFieldActionPerformed

    private void addCourseCodeTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addCourseCodeTextFieldActionPerformed

    }//GEN-LAST:event_addCourseCodeTextFieldActionPerformed

    private void addSemesterSubmitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addSemesterSubmitButtonActionPerformed
        String semester = addSemesterTextfield.getText();
        SemesterQueries.addSemester(semester);
        addSemesterStatusLabel.setText("Semester " + semester + " has been added.");
        rebuildSemesterComboBoxes();
    }//GEN-LAST:event_addSemesterSubmitButtonActionPerformed

    private void addSemesterTextfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addSemesterTextfieldActionPerformed

    }//GEN-LAST:event_addSemesterTextfieldActionPerformed

    private void displayClassListDisplayButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_displayClassListDisplayButtonActionPerformed
        String selectedClass = (String) displayClassListComboBox.getSelectedItem();
        ArrayList<StudentEntry> scheduledStudentsList = MultiTableQueries.getScheduledStudentsByClass(currentSemester, selectedClass);
        ArrayList<StudentEntry> waitlist = MultiTableQueries.getWaitlistedStudentsByClass(currentSemester, selectedClass);

        DefaultTableModel scheduledStudentModel = (DefaultTableModel) displayClassListScheduledStudentsTable.getModel();
        scheduledStudentModel.setRowCount(0);
        for (StudentEntry student : scheduledStudentsList) {
            scheduledStudentModel.addRow(new Object[] {student.getLastName(), student.getFirstName(), student.getStudentID()});
        }
        
        DefaultTableModel waitlistModel = (DefaultTableModel) displayClassListWaitlistedTable.getModel();
        waitlistModel.setRowCount(0);
        for (StudentEntry student : waitlist) {
            waitlistModel.addRow(new Object[] {student.getLastName(), student.getFirstName(), student.getStudentID()});
        }
    }//GEN-LAST:event_displayClassListDisplayButtonActionPerformed

    private void adminDropClassSubmitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adminDropClassSubmitButtonActionPerformed
        String selectedClass = (String) adminDropClassComboBox.getSelectedItem();
        ArrayList<StudentEntry> scheduledStudentsList = MultiTableQueries.getScheduledStudentsByClass(currentSemester, selectedClass);
        ArrayList<StudentEntry> waitlist = MultiTableQueries.getWaitlistedStudentsByClass(currentSemester, selectedClass);
        
        adminDropClassTextArea.setText("Scheduled Students Dropped from the Course: \n");
        for (StudentEntry student : scheduledStudentsList) {
            adminDropClassTextArea.append(student.toString() + "\n");
        }
        
        adminDropClassTextArea.append("\nWaitlisted Students Dropped from the Course: \n");
        for (StudentEntry student : waitlist) {
            adminDropClassTextArea.append(student.toString() + "\n");
        }
        
        ClassQueries.dropClass(currentSemester, selectedClass);
        rebuildClassComboBoxes(); 
    }//GEN-LAST:event_adminDropClassSubmitButtonActionPerformed

    private void displayClassListComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_displayClassListComboBoxActionPerformed

    }//GEN-LAST:event_displayClassListComboBoxActionPerformed

    private void adminDropStudentComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adminDropStudentComboBoxActionPerformed
    }//GEN-LAST:event_adminDropStudentComboBoxActionPerformed

    private void dropStudentSubmitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dropStudentSubmitButtonActionPerformed
        StudentEntry selectedStudent = (StudentEntry) adminDropStudentComboBox.getSelectedItem();
        
        dropStudentTextArea.setText(selectedStudent.toString() + " has been dropped from the list of students\n");
        
        for (String semester : SemesterQueries.getSemesterList()) {
            dropStudentTextArea.append("\nFor Semester: " + semester + "\n");
            
            for (ScheduleEntry scheduleEntry : ScheduleQueries.getScheduleByStudent(semester, selectedStudent.getStudentID())) {
                if (scheduleEntry.getStatus().equals("Scheduled")) {
                    String currentClass = scheduleEntry.getCourseCode();
                    dropStudentTextArea.append(selectedStudent.toString() + " has been dropped from " + currentClass + "\n");
                    
                    ArrayList<ScheduleEntry> waitlistScheduleEntry = ScheduleQueries.getWaitlistedStudentsByClass(semester, currentClass);
                    ArrayList<StudentEntry> waitlistStudentEntry = MultiTableQueries.getWaitlistedStudentsByClass(semester, currentClass);
                            
                    if (waitlistScheduleEntry.isEmpty() == false) {
                        String newStudent = waitlistStudentEntry.get(0).toString();
                        dropStudentTextArea.append(newStudent + " has been scheduled into " + currentClass + "\n");
                        ScheduleQueries.updateScheduleEntry(waitlistScheduleEntry.get(0));
                    }
                } else if ((scheduleEntry.getStatus()).equals("Waitlisted")) {
                    dropStudentTextArea.append(selectedStudent.toString() + " has been dropped from the waitlist for " + scheduleEntry.getCourseCode() + "\n");
                }
            }
        }
        
        StudentQueries.dropStudent(selectedStudent.getStudentID()); 
        rebuildStudentComboBoxes();
    }//GEN-LAST:event_dropStudentSubmitButtonActionPerformed

    private void adminDropClassComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adminDropClassComboBoxActionPerformed

    }//GEN-LAST:event_adminDropClassComboBoxActionPerformed

    private void studentDropClassStudentComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studentDropClassStudentComboBoxActionPerformed
    }//GEN-LAST:event_studentDropClassStudentComboBoxActionPerformed

    private void studentDropClassSubmitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studentDropClassSubmitButtonActionPerformed
        StudentEntry selectedStudent = (StudentEntry) studentDropClassStudentComboBox.getSelectedItem();
        String selectedClass = (String) studentDropClassClassComboBox.getSelectedItem();
        
        studentDropClassTextArea.setText(selectedStudent + " has been dropped from " + selectedClass + "\n");
        
        ArrayList<ScheduleEntry> waitlistScheduleEntry = ScheduleQueries.getWaitlistedStudentsByClass(currentSemester, selectedClass);
        ArrayList<StudentEntry> waitlistStudentEntry = MultiTableQueries.getWaitlistedStudentsByClass(currentSemester, selectedClass);
        
        if (waitlistScheduleEntry.isEmpty() == false) {
            studentDropClassTextArea.append((waitlistStudentEntry.get(0)).toString() + " has been scheduled into " + selectedClass);
            ScheduleQueries.updateScheduleEntry(waitlistScheduleEntry.get(0));
        }
        
        ScheduleQueries.dropStudentScheduleByCourse(currentSemester, selectedStudent.getStudentID(), selectedClass); 
    }//GEN-LAST:event_studentDropClassSubmitButtonActionPerformed

    private void studentDropClassClassComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studentDropClassClassComboBoxActionPerformed
    }//GEN-LAST:event_studentDropClassClassComboBoxActionPerformed
    
    private void checkData() {
        try {
            FileReader reader = new FileReader("xzq789yy.txt");
            BufferedReader breader = new BufferedReader(reader);

            String encodedAuthor = breader.readLine();
            String encodedProject = breader.readLine();
            byte[] decodedAuthor = Base64.getDecoder().decode(encodedAuthor);
            author = new String(decodedAuthor);
            byte[] decodedProject = Base64.getDecoder().decode(encodedProject);
            project = new String(decodedProject);
            reader.close();

        } catch (FileNotFoundException e) {
            // Get User Info and Create File
            author = JOptionPane.showInputDialog("Enter your first and last name.");
            project = "Course Scheduler Fall 2024";

            // Write Data to Data File
            try {
                FileWriter writer = new FileWriter("xzq789yy.txt", true);
                BufferedWriter bufferedWriter = new BufferedWriter(writer);

                // Encode Output Data
                String encodedAuthor = Base64.getEncoder().encodeToString(author.getBytes());

                bufferedWriter.write(encodedAuthor);
                bufferedWriter.newLine();

                String encodedProject = Base64.getEncoder().encodeToString(project.getBytes());
                bufferedWriter.write(encodedProject);

                bufferedWriter.close();
            } catch (IOException ioe) {
                ioe.printStackTrace();
                System.exit(1);
            }

        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }

    }

    public static void main(String args[]) {
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        // Create and Display Form
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables Declaration

    private javax.swing.JLabel ScheduleClassStatusLabel;
    private javax.swing.JButton ScheduleClassSubmitButton;
    private javax.swing.JButton aboutButton;
    private javax.swing.JComboBox<String> addClassCourseCodeComboBox;
    private javax.swing.JSpinner addClassSeatsSpinner;
    private javax.swing.JLabel addClassStatusLabel;
    private javax.swing.JButton addClassSubmitButton;
    private javax.swing.JTextField addCourseCodeTextField;
    private javax.swing.JTextField addCourseDescriptionTextField;
    private javax.swing.JLabel addCourseStatusLabel;
    private javax.swing.JButton addCourseSubmitButton;
    private javax.swing.JLabel addSemesterStatusLabel;
    private javax.swing.JButton addSemesterSubmitButton;
    private javax.swing.JTextField addSemesterTextfield;
    private javax.swing.JTextField addStudentFirstNameTextField;
    private javax.swing.JTextField addStudentIDTextField;
    private javax.swing.JTextField addStudentLastNameTextField;
    private javax.swing.JLabel addStudentStatusLabel;
    private javax.swing.JButton addStudentSubmitButton;
    private javax.swing.JComboBox<String> adminDropClassComboBox;
    private javax.swing.JButton adminDropClassSubmitButton;
    private javax.swing.JTextArea adminDropClassTextArea;
    private javax.swing.JComboBox<String> adminDropStudentComboBox;
    private javax.swing.JButton changeSemesterButton;
    private javax.swing.JComboBox<String> currentSemesterComboBox;
    private javax.swing.JLabel currentSemesterLabel;
    private javax.swing.JComboBox<String> displayClassListComboBox;
    private javax.swing.JButton displayClassListDisplayButton;
    private javax.swing.JTable displayClassListScheduledStudentsTable;
    private javax.swing.JTable displayClassListWaitlistedTable;
    private javax.swing.JButton displayClassesDisplayButton;
    private javax.swing.JTextArea displayClassesTextArea;
    private javax.swing.JButton displayScheduleDisplayButton;
    private javax.swing.JComboBox<String> displayScheduleStudentComboBox;
    private javax.swing.JTextArea displayScheduleTextArea;
    private javax.swing.JButton dropStudentSubmitButton;
    private javax.swing.JTextArea dropStudentTextArea;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JComboBox<String> selectClassComboBox;
    private javax.swing.JComboBox<String> selectStudentComboBox;
    private javax.swing.JComboBox<String> studentDropClassClassComboBox;
    private javax.swing.JComboBox<String> studentDropClassStudentComboBox;
    private javax.swing.JButton studentDropClassSubmitButton;
    private javax.swing.JTextArea studentDropClassTextArea;
    // End of Variables Declaration //GEN-END:variables
}

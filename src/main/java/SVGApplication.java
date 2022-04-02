import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

public class SVGApplication extends javax.swing.JFrame {

    public static final String CLASS_NAME = SVGApplication.class.getSimpleName();
    private static final Logger LOG = Logger.getLogger(CLASS_NAME);

    private javax.swing.JMenuItem aboutMenuItem;
    private javax.swing.JMenuItem contentMenuItem;
    private javax.swing.JMenuItem copyMenuItem;
    private javax.swing.JMenuItem cutMenuItem;
    private javax.swing.JMenuItem deleteMenuItem;
    private javax.swing.JDesktopPane desktopPane;
    private javax.swing.JMenu editMenu;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JMenu operMenu;
    private javax.swing.JMenuItem scaleMenuItem;
    private javax.swing.JMenuItem rotateMenuItem;

    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem openMenuItem;
    private javax.swing.JMenuItem pasteMenuItem;
    private javax.swing.JMenuItem saveAsMenuItem;
    private javax.swing.JMenuItem saveMenuItem;

// Agregar menu de figuras *******
    private javax.swing.JMenuItem shapeMenu;
    private javax.swing.JMenuItem lineMenuItem;
    private javax.swing.JMenuItem circleMenuItem;
    private javax.swing.JMenuItem rectMenuItem;


    public SVGApplication() {
        initComponents();
        //centrar ventana
        setLocationRelativeTo(null);

        this.setSize(800, 600);
    }

    private void initComponents() {

        desktopPane = new javax.swing.JDesktopPane();

        menuBar = new javax.swing.JMenuBar();

        fileMenu = new javax.swing.JMenu();
        openMenuItem = new javax.swing.JMenuItem();
        saveMenuItem = new javax.swing.JMenuItem();
        saveAsMenuItem = new javax.swing.JMenuItem();
        exitMenuItem = new javax.swing.JMenuItem();
        editMenu = new javax.swing.JMenu();
        cutMenuItem = new javax.swing.JMenuItem();
        copyMenuItem = new javax.swing.JMenuItem();
        pasteMenuItem = new javax.swing.JMenuItem();
        deleteMenuItem = new javax.swing.JMenuItem();

        // Agregar elementos **************
        shapeMenu = new javax.swing.JMenu();
        lineMenuItem = new javax.swing.JMenuItem();
        circleMenuItem = new javax.swing.JMenuItem();
        rectMenuItem = new javax.swing.JMenuItem();


        scaleMenuItem = new javax.swing.JMenuItem();
        rotateMenuItem = new javax.swing.JMenuItem();
        operMenu = new javax.swing.JMenu();

        operMenu = new javax.swing.JMenu();

        menuBar.add(operMenu);

        // Figuras *********
        shapeMenu.setText("Shape");
        lineMenuItem.setText("Line");
        lineMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lineMenuItemMenuItemActionPerformed(evt);
            }
        });
        shapeMenu.add(lineMenuItem);

        circleMenuItem.setText("Circle");
        circleMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                circleMenuItemMenuItemActionPerformed(evt);
            }
        });
        shapeMenu.add(circleMenuItem);

        rectMenuItem.setText("Rectangle");
        rectMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rectMenuItemMenuItemActionPerformed(evt);
            }
        });
        shapeMenu.add(rectMenuItem);

        menuBar.add(shapeMenu);



        helpMenu = new javax.swing.JMenu();
        contentMenuItem = new javax.swing.JMenuItem();
        aboutMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        fileMenu.setMnemonic('f');
        fileMenu.setText("File");

        // Nuevo  archivo *****************
        fileMenu.setMnemonic('n');
        openMenuItem.setText("New file");

        openMenuItem.setMnemonic('o');
        openMenuItem.setText("Open");
        openMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(openMenuItem);

        saveMenuItem.setMnemonic('s');
        saveMenuItem.setText("Save");
        fileMenu.add(saveMenuItem);

        saveAsMenuItem.setMnemonic('a');
        saveAsMenuItem.setText("Save As ...");
        saveAsMenuItem.setDisplayedMnemonicIndex(5);
        saveAsMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveAsMenuItemActionPerformed(evt);
            }
        });

        fileMenu.add(saveAsMenuItem);

        exitMenuItem.setMnemonic('x');
        exitMenuItem.setText("Exit");
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(exitMenuItem);

        menuBar.add(fileMenu);

        editMenu.setMnemonic('e');
        editMenu.setText("Edit");

        cutMenuItem.setMnemonic('t');
        cutMenuItem.setText("Cut");
        editMenu.add(cutMenuItem);

        copyMenuItem.setMnemonic('y');
        copyMenuItem.setText("Copy");
        editMenu.add(copyMenuItem);

        pasteMenuItem.setMnemonic('p');
        pasteMenuItem.setText("Paste");
        editMenu.add(pasteMenuItem);

        deleteMenuItem.setMnemonic('d');
        deleteMenuItem.setText("Delete");
        editMenu.add(deleteMenuItem);

        menuBar.add(editMenu);
        operMenu.setText("Operations");
        scaleMenuItem.setText("Scale");
        operMenu.add(scaleMenuItem);
        scaleMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                scaleMenuItemMenuItemActionPerformed(evt);
            }
        });

        rotateMenuItem.setText("Rotate");
        operMenu.add(rotateMenuItem);
        rotateMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rotateMenuItemMenuItemActionPerformed(evt);
            }
        });

        menuBar.add(operMenu);


        helpMenu.setMnemonic('h');
        helpMenu.setText("Help");

        contentMenuItem.setMnemonic('c');
        contentMenuItem.setText("Contents");
        helpMenu.add(contentMenuItem);

        aboutMenuItem.setMnemonic('a');
        aboutMenuItem.setText("About");
        helpMenu.add(aboutMenuItem);

        menuBar.add(helpMenu);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
        );

        pack();
    }

    private void saveAsMenuItemActionPerformed(ActionEvent evt) {

        DocumentFrame documentFrame =  (DocumentFrame) desktopPane.getSelectedFrame();

        if( documentFrame == null ) {
            return;
        }

        final JFileChooser fc = new JFileChooser();

        String userDir = System.getProperty("user.dir");

        fc.setCurrentDirectory(new File(userDir));

        // Abrir dialogo para seleccion de archivo
        fc.setDialogTitle("Seleccionar Imagen SVG");
        fc.setAcceptAllFileFilterUsed(false);

        // Mostrar unicamente archivos SVG
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos SVG", "svg");
        fc.addChoosableFileFilter(filter);

        int returnVal = fc.showSaveDialog(this);

        if( returnVal == JFileChooser.APPROVE_OPTION ) {
            // Obtener archivo seleccionado
            File file = fc.getSelectedFile();
            if (file == null) {
                return;
            }
            if (!file.getName().toLowerCase().endsWith(".svg")) {
                file = new File(file.getParentFile(), file.getName() + ".svg");
            }

            if( file.exists() ) {
                LOG.info("El archivo ya existe.");

                int input = JOptionPane.showConfirmDialog(
                        this,
                        "El archivo:\n"
                                + file.getName()
                                + "\nRemplazar el archivo?",
                        "Archivo ya existe",
                        JOptionPane.YES_NO_OPTION);
                if( input != JOptionPane.YES_OPTION ) {
                    return;
                }
            }

            Document document = documentFrame.getDocument();
            Util.saveDocument(document, file.toString());
            LOG.info( file.toString() );


        }
    }

    private void rotateMenuItemMenuItemActionPerformed(ActionEvent evt) {
        Object[] options = {"15", "30", "45", "60","75", "90"};

        String s = (String) JOptionPane.showInputDialog(
                this,
                "Angulo de rotación:",
                "Rotar",
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                "15");
        if ((s != null) && (s.length() > 0)) {
            double angulo = Double.parseDouble(s);
            DocumentFrame documentFrame =  (DocumentFrame) desktopPane.getSelectedFrame();

            if( documentFrame != null ) {
                System.out.println( documentFrame.getTitle() );

                Util.rotateSVG(documentFrame.getDocument(), angulo);

            }
            documentFrame.repaint();
        }
    }

    private void scaleMenuItemMenuItemActionPerformed(ActionEvent evt) {

        Object[] options = {"25%", "50%", "75%", "100%"};

        String s = (String) JOptionPane.showInputDialog(
                this,
                "Porcentaje a escalar:",
                "Scale",
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                "25%");

        if ((s != null) && (s.length() > 0)) {
            double scaleFactor = 1.0;
            if (s.equals("25%")) {
                scaleFactor = 1.25;
            }
            if (s.equals("50%")) {
                scaleFactor = 1.50;
            }
            if (s.equals("75%")) {
                scaleFactor = 1.75;
            }
            if (s.equals("100%")) {
                scaleFactor = 2.0;
            }

            DocumentFrame documentFrame =  (DocumentFrame) desktopPane.getSelectedFrame();

           if( documentFrame != null ) {
               System.out.println( documentFrame.getTitle() );

               Util.scaleSVG(documentFrame.getDocument(), scaleFactor);

               Dimension d = documentFrame.getPreferredSize();
               d.height = (int) (d.height * scaleFactor);
               d.width  = (int) (d.width * scaleFactor);
               documentFrame.setSize( d );
           }
            documentFrame.repaint();
        }
    }

    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
        System.exit(0);
    }

    private void openMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
        final JFileChooser fc = new JFileChooser();

        String userDir = System.getProperty("user.dir");

        fc.setCurrentDirectory(new File(userDir));

        // Abrir dialogo para seleccion de archivo
        fc.setDialogTitle("Seleccionar Imagen SVG");
        fc.setAcceptAllFileFilterUsed(false);

        // Mostrar unicamente archivos SVG
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos SVG", "svg");
        fc.addChoosableFileFilter(filter);

        int returnVal = fc.showOpenDialog(this);

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            // Obtener archivo seleccionado
            File file = fc.getSelectedFile();
            System.out.println(file);
            //This is where a real application would open the file.

            // Con el archivo seleccionado, crear un documento DOM
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = null;
            try {
                dBuilder = dbFactory.newDocumentBuilder();
            } catch (ParserConfigurationException ex) {
                LOG.severe(ex.getMessage());
            }

            Document doc = null;
            try {
                doc = dBuilder.parse(file);
                doc.getDocumentElement().normalize();

            } catch (SAXException ex) {
                LOG.severe(ex.getMessage());
            } catch (IOException ex) {
                LOG.severe(ex.getMessage());
            }


            DocumentFrame intFrame = new DocumentFrame(file.getName(),doc);

            desktopPane.add(intFrame);

            intFrame.setVisible(true);

        } else {

        }
    }

    private void lineMenuItemMenuItemActionPerformed(ActionEvent evt) {
        DocumentFrame documentFrame =  (DocumentFrame) desktopPane.getSelectedFrame();

        if( documentFrame == null ) {
            return;
        }

        Document doc = documentFrame.getDocument();

        NewLine dialog = new NewLine(SVGApplication.this, doc);

        dialog.setVisible(true);

        documentFrame.repaint();
    }

    private void circleMenuItemMenuItemActionPerformed(ActionEvent evt) {
        DocumentFrame documentFrame =  (DocumentFrame) desktopPane.getSelectedFrame();

        if( documentFrame == null ) {
            return;
        }

        Document doc = documentFrame.getDocument();

        NewCircle dialog = new NewCircle(SVGApplication.this, doc);

        dialog.setVisible(true);

        documentFrame.repaint();
    }

    private void rectMenuItemMenuItemActionPerformed(ActionEvent evt) {
        DocumentFrame documentFrame =  (DocumentFrame) desktopPane.getSelectedFrame();

        if( documentFrame == null ) {
            return;
        }

        Document doc = documentFrame.getDocument();

        NewRectangle dialog = new NewRectangle(SVGApplication.this, doc);

        dialog.setVisible(true);

        documentFrame.repaint();
    }

    // Clases figuras
    public class NewLine extends JDialog {
        public final String CLASS_NAME = NewLine.class.getSimpleName();
        public final Logger LOGGER = Logger.getLogger(CLASS_NAME);
        private Properties webColors;
        private Document doc;

        private JPanel controlsPanel;
        private JButton buttonOK;
        private JButton buttonCancel;
        private JTextField xField1;
        private JLabel x1Label;
        private JTextField yField1;
        private JLabel y1Label;
        private JTextField xField2;
        private JLabel x2Label;
        private JTextField yField2;
        private JLabel y2Label;
        private JComboBox<String> ccombo;
        private JLabel colorLabel;
        private JComboBox<String> wcombo;
        private JLabel widthLabel;

        public NewLine(JFrame parent, Document document) {
            super(parent,"New line",true);

            setLocationRelativeTo(null);
            loadColors();
            String colors[] = webColors.stringPropertyNames().toArray(new String[0]);

            doc = document;

            GridLayout layout = new GridLayout(0,2);

            controlsPanel = new JPanel(layout);

            x1Label = new JLabel("X1:");
            x1Label.setHorizontalAlignment(SwingConstants.CENTER);
            controlsPanel.add(x1Label);
            xField1=new JTextField(4);
            controlsPanel.add(xField1);

            y1Label = new JLabel("Y1:");
            y1Label.setHorizontalAlignment(SwingConstants.CENTER);
            controlsPanel.add(y1Label);
            yField1=new JTextField(4);
            controlsPanel.add(yField1);

            x2Label = new JLabel("X2:");
            x2Label.setHorizontalAlignment(SwingConstants.CENTER);
            controlsPanel.add(x2Label);
            xField2=new JTextField(4);
            controlsPanel.add(xField2);

            y2Label = new JLabel("Y2:");
            y2Label.setHorizontalAlignment(SwingConstants.CENTER);
            controlsPanel.add(y2Label);
            yField2=new JTextField(4);
            controlsPanel.add(yField2);

            colorLabel = new JLabel("Color:");
            colorLabel.setHorizontalAlignment(SwingConstants.CENTER);
            controlsPanel.add(colorLabel);
            ccombo = new JComboBox<>(colors);
            controlsPanel.add(ccombo);

            widthLabel = new JLabel("Width:");
            widthLabel.setHorizontalAlignment(SwingConstants.CENTER);
            controlsPanel.add(widthLabel);
            String ws[] = {"1", "2", "3", "4", "5", "6","7","8"};
            wcombo = new JComboBox<>(ws);
            controlsPanel.add(wcombo);

            buttonOK = new JButton("Ok");
            buttonOK.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    onOK();
                }
            });
            controlsPanel.add(buttonOK);

            buttonCancel= new JButton("Cancel");
            buttonCancel.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    onCancel();
                }
            });
            controlsPanel.add(buttonCancel);
            // call onCancel() when cross is clicked
            setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
            addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent e) {
                    onCancel();
                }
            });

            this.setContentPane(controlsPanel);

            setSize(200,400);
            setResizable(false);
            pack();

        }

        private void onOK() {

            String sx1 = xField1.getText();
            String sy1 = yField1.getText() ;
            String sx2 = xField2.getText();
            String sy2 = yField2.getText();
            String color = (String) ccombo.getSelectedItem();
            String width = (String) wcombo.getSelectedItem();

            Element line = doc.createElement("line");
            line.setAttribute("x1",sx1);
            line.setAttribute("y1",sy1);
            line.setAttribute("x2",sx2);
            line.setAttribute("y2",sy2);
            line.setAttribute("stroke",color);
            line.setAttribute("stroke-width",width);
            Element root = doc.getDocumentElement();
            root.appendChild(line);

            dispose();
        }

        private void onCancel() {
            // add your code here if necessary
            dispose();
        }

        private void loadColors() {
            try {

                String userDir = System.getProperty("user.dir");
                FileReader reader = new FileReader(userDir + "/colors.properties");

                webColors = new Properties();
                webColors.load(reader);

            } catch (FileNotFoundException ex) {
                LOGGER.severe(ex.getMessage());
            } catch (IOException ex) {
                LOGGER.severe(ex.getMessage());
            }
        }

    }
    public class NewCircle extends JDialog {
        public final String CLASS_NAME = NewCircle.class.getSimpleName();
        public final Logger LOGGER = Logger.getLogger(CLASS_NAME);
        private Properties webColors;
        private Document doc;

        private JPanel controlsPanel;
        private JButton buttonOK;
        private JButton buttonCancel;
        private JTextField cxField;
        private JLabel cxLabel;
        private JTextField cyField;
        private JLabel cyLabel;
        private JTextField rField;
        private JLabel rLabel;
        private JComboBox<String> ccombo;
        private JLabel colorLabel;
        private JComboBox<String> fccombo;
        private JLabel colorFillLabel;
        private JComboBox<String> wcombo;
        private JLabel widthLabel;

        public NewCircle(JFrame parent, Document document) {
            super(parent,"New circle",true);

            setLocationRelativeTo(null);
            loadColors();
            String colors[] = webColors.stringPropertyNames().toArray(new String[0]);

            doc = document;

            GridLayout layout = new GridLayout(0,2);

            controlsPanel = new JPanel(layout);

            cxLabel = new JLabel("X:");
            cxLabel.setHorizontalAlignment(SwingConstants.CENTER);
            controlsPanel.add(cxLabel);
            cxField =new JTextField(4);
            controlsPanel.add(cxField);

            cyLabel = new JLabel("Y:");
            cyLabel.setHorizontalAlignment(SwingConstants.CENTER);
            controlsPanel.add(cyLabel);
            cyField =new JTextField(4);
            controlsPanel.add(cyField);

            rLabel = new JLabel("R:");
            rLabel.setHorizontalAlignment(SwingConstants.CENTER);
            controlsPanel.add(rLabel);
            rField =new JTextField(4);
            controlsPanel.add(rField);

            colorLabel = new JLabel("stroke Color:");
            colorLabel.setHorizontalAlignment(SwingConstants.CENTER);
            controlsPanel.add(colorLabel);
            ccombo = new JComboBox<>(colors);
            controlsPanel.add(ccombo);

            colorFillLabel = new JLabel("Fill Color:");
            colorFillLabel.setHorizontalAlignment(SwingConstants.CENTER);
            controlsPanel.add(colorFillLabel);
            fccombo = new JComboBox<>(colors);
            controlsPanel.add(fccombo);

            widthLabel = new JLabel("Line Width:");
            widthLabel.setHorizontalAlignment(SwingConstants.CENTER);
            controlsPanel.add(widthLabel);
            String ws[] = {"1", "2", "3", "4", "5", "6","7","8"};
            wcombo = new JComboBox<>(ws);
            controlsPanel.add(wcombo);

            buttonOK = new JButton("Ok");
            buttonOK.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    onOK();
                }
            });
            controlsPanel.add(buttonOK);

            buttonCancel= new JButton("Cancel");
            buttonCancel.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    onCancel();
                }
            });
            controlsPanel.add(buttonCancel);
            // call onCancel() when cross is clicked
            setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
            addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent e) {
                    onCancel();
                }
            });

            this.setContentPane(controlsPanel);

            setSize(200,400);
            setResizable(false);
            pack();

        }

        private void onOK() {
            String scx = cxField.getText();
            String scy = cyField.getText() ;
            String sr = rField.getText();
            String color = (String) ccombo.getSelectedItem();
            String fillColor = (String) fccombo.getSelectedItem();
            String width = (String) wcombo.getSelectedItem();

            Element circle = doc.createElement("circle");
            circle.setAttribute("cx",scx);
            circle.setAttribute("cy",scy);
            circle.setAttribute("r",sr);
            circle.setAttribute("fill",fillColor);
            circle.setAttribute("stroke-width",width);
            circle.setAttribute("stroke",color);
            Element root = doc.getDocumentElement();
            root.appendChild(circle);

            dispose();
        }

        private void onCancel() {
            // add your code here if necessary
            dispose();
        }

        private void loadColors() {
            try {

                String userDir = System.getProperty("user.dir");
                FileReader reader = new FileReader(userDir + "/colors.properties");

                webColors = new Properties();
                webColors.load(reader);

            } catch (FileNotFoundException ex) {
                LOGGER.severe(ex.getMessage());
            } catch (IOException ex) {
                LOGGER.severe(ex.getMessage());
            }
        }
    }
    public class NewRectangle extends JDialog {
        public final String CLASS_NAME = NewCircle.class.getSimpleName();
        public final Logger LOGGER = Logger.getLogger(CLASS_NAME);
        private Properties webColors;
        private Document doc;

        private JPanel controlsPanel;
        private JButton buttonOK;
        private JButton buttonCancel;

        private JTextField xField;
        private JLabel xLabel;
        private JTextField yField;
        private JLabel yLabel;
        private JTextField wField;
        private JLabel wLabel;
        private JTextField hField;
        private JLabel hLabel;
        private JComboBox<String> ccombo;
        private JLabel colorLabel;
        private JComboBox<String> fccombo;
        private JLabel colorFillLabel;
        private JComboBox<String> wcombo;
        private JLabel widthLabel;

        public NewRectangle(JFrame parent, Document document) {
            super(parent,"New Rectangle",true);
            setLocationRelativeTo(null);

            loadColors();
            String colors[] = webColors.stringPropertyNames().toArray(new String[0]);

            doc = document;

            GridLayout layout = new GridLayout(0,2);

            controlsPanel = new JPanel(layout);

            xLabel = new JLabel("X:");
            xLabel.setHorizontalAlignment(SwingConstants.CENTER);
            controlsPanel.add(xLabel);
            xField =new JTextField(4);
            controlsPanel.add(xField);


            yLabel = new JLabel("Y:");
            yLabel.setHorizontalAlignment(SwingConstants.CENTER);
            controlsPanel.add(yLabel);
            yField =new JTextField(4);
            controlsPanel.add(yField);

            wLabel = new JLabel("Width:");
            wLabel.setHorizontalAlignment(SwingConstants.CENTER);
            controlsPanel.add(wLabel);
            wField =new JTextField(4);
            controlsPanel.add(wField);

            hLabel = new JLabel("Height:");
            hLabel.setHorizontalAlignment(SwingConstants.CENTER);
            controlsPanel.add(hLabel);
            hField =new JTextField(4);
            controlsPanel.add(hField);

            colorLabel = new JLabel("stroke Color:");
            colorLabel.setHorizontalAlignment(SwingConstants.CENTER);
            controlsPanel.add(colorLabel);
            ccombo = new JComboBox<>(colors);
            controlsPanel.add(ccombo);

            colorFillLabel = new JLabel("Fill Color:");
            colorFillLabel.setHorizontalAlignment(SwingConstants.CENTER);
            controlsPanel.add(colorFillLabel);
            fccombo = new JComboBox<>(colors);
            controlsPanel.add(fccombo);

            widthLabel = new JLabel("Line Width:");
            widthLabel.setHorizontalAlignment(SwingConstants.CENTER);
            controlsPanel.add(widthLabel);
            String ws[] = {"1", "2", "3", "4", "5", "6","7","8"};
            wcombo = new JComboBox<>(ws);
            controlsPanel.add(wcombo);

            buttonOK = new JButton("Ok");
            buttonOK.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    onOK();
                }
            });
            controlsPanel.add(buttonOK);

            buttonCancel= new JButton("Cancel");
            buttonCancel.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    onCancel();
                }
            });
            controlsPanel.add(buttonCancel);
            // call onCancel() when cross is clicked
            setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
            addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent e) {
                    onCancel();
                }
            });

            this.setContentPane(controlsPanel);

            setSize(200,400);
            setResizable(false);
            pack();

        }

        private void onOK() {
            // add your code here
            String sx = xField.getText();
            String sy = yField.getText() ;
            String sw = wField.getText();
            String sh = hField.getText();
            String color = (String) ccombo.getSelectedItem();
            String fillColor = (String) fccombo.getSelectedItem();
            String width = (String) wcombo.getSelectedItem();


            Element rectangle = doc.createElement("rect");
            rectangle.setAttribute("x",sx);
            rectangle.setAttribute("y",sy);
            rectangle.setAttribute("width",sw);
            rectangle.setAttribute("height",sh);
            rectangle.setAttribute("fill",fillColor);
            rectangle.setAttribute("stroke-width",width);
            rectangle.setAttribute("stroke",color);
            Element root = doc.getDocumentElement();
            root.appendChild(rectangle);

            dispose();
        }

        private void onCancel() {
            // add your code here if necessary
            dispose();
        }

        private void loadColors() {
            try {

                String userDir = System.getProperty("user.dir");
                FileReader reader = new FileReader(userDir + "/colors.properties");

                webColors = new Properties();
                webColors.load(reader);

            } catch (FileNotFoundException ex) {
                LOGGER.severe(ex.getMessage());
            } catch (IOException ex) {
                LOGGER.severe(ex.getMessage());
            }
        }
    }

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            LOG.severe(ex.getMessage());
        } catch (InstantiationException ex) {
            LOG.severe(ex.getMessage());
        } catch (IllegalAccessException ex) {
            LOG.severe(ex.getMessage());
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            LOG.severe(ex.getMessage());
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SVGApplication().setVisible(true);
            }
        });
    }
}
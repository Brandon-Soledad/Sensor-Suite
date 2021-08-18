package model;

import application.Main;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import model.*;
import tools.BlinkLabel;
import tools.GraphView;
import javax.swing.AbstractAction;
import javax.swing.Action;
import java.awt.event.ActionEvent;
import java.util.Timer;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Application GUI
 * @author Brandon Soledad
 */

public class ConsoleReceiver extends JFrame implements Runnable {

    private JPanel contentPane, rainTab, windTab, uvTab, moonPhaseTab, graphTab, rainLeft, windLeft, uvLeft, graphPane,
            evTab, evLeft;
    private ImageIcon rainTabIcon, windTabIcon, uvTabIcon, evTabIcon;
    private JSplitPane splitPane, splitPaneRain, splitPaneWind, splitPaneUV, splitPaneEV;
    private JTextArea weatherHistory, rainRight, windRight, uvRight, evRight;
    private JTabbedPane tabbedPane;
    private JMenuBar menuBar;
    private JMenu file;
    private JMenuItem about, exit, tempToggle;
    private JSeparator separator;
    private JScrollPane historyScrollPane, graphScrollPane, rainScrollPane, uvScrollPane, evScrollPane, windScrollPane;
    private JPanel weatherPane;
    private JLabel rainTabLabel, windTabLabel, tempHighLabel, tempLowLabel, currentTempLabel, weatherPaneIconLabel,
            currentTimeLabel, currentHumidity, moonPhaseLabel, statusIndicator, sunsetLabel, sunriseLabel, uvTabLabel,
            barometerPressureLabel, barometerDirectionLabel, evTabLabel;
    private int tempHigh, tempLow;
    private String currentTime;
    private MoonPhase moonPhase;
    private BarometerFeatures barometerFeatures;
    private WindRainFeatures windRainFeatures;
    private UVSolarRadiationFeatures uvFeatures;
    private GraphView tempGraph, rainGraph, windGraph;
    private Collection<Integer> graphTempValues, graphRainValues, graphWindValues;
    private EvapotranspirationFeatures evFeatures;
    private boolean showCelcius;
    private ExtendedOptions exOptions;


    /**
     * Constructor to create the frame.
     */
    public ConsoleReceiver() {

        //initializing all variables
        exOptions = new ExtendedOptions();
        showCelcius = false;
        tempToggle = new JMenuItem("Show °C");
        splitPaneEV = new JSplitPane();
        weatherPane = new JPanel();
        evFeatures = new EvapotranspirationFeatures(Main.pd, Main.myIntegratedSensorSuite.myTemperatureSensor);
        evLeft = new JPanel();
        evRight = new JTextArea();
        evTabLabel = new JLabel();
        evTabIcon = new ImageIcon("src/images/rain.png");
        evTab = new JPanel();
        windGraph = new GraphView("", "");
        graphWindValues = new ArrayList<>();
        graphPane = new JPanel();
        graphTempValues = new ArrayList<>();
        graphRainValues = new ArrayList<>();
        tempGraph = new GraphView("", "");
        rainGraph = new GraphView("", "");
        graphTab = new JPanel();
        barometerPressureLabel = new JLabel();
        barometerDirectionLabel = new JLabel();
        barometerFeatures = new BarometerFeatures();
        windRainFeatures = new WindRainFeatures();
        uvFeatures = new UVSolarRadiationFeatures(Main.pd);
        uvTabLabel = new JLabel();
        uvLeft = new JPanel();
        uvTabIcon = new ImageIcon("src/images/sunny.png");
        uvRight = new JTextArea();
        splitPaneUV = new JSplitPane();
        uvTabLabel = new JLabel();
        uvLeft = new JPanel();
        uvTabIcon = new ImageIcon("src/images/sunny.png");
        uvRight = new JTextArea();
        splitPaneUV = new JSplitPane();
        contentPane = new JPanel();
        windLeft = new JPanel();
        splitPaneWind = new JSplitPane();
        windRight = new JTextArea();
        rainTab = new JPanel();
        moonPhase = new MoonPhase();
        sunriseLabel = new JLabel();
        sunsetLabel = new JLabel();
        statusIndicator = new BlinkLabel("Data retrieved.");
        weatherHistory = new JTextArea();
        historyScrollPane = new JScrollPane(weatherHistory);
        rainTabLabel = new JLabel();
        rainLeft = new JPanel();
        rainRight = new JTextArea();
        windTabLabel = new JLabel();
        splitPane = new JSplitPane();
        splitPaneRain = new JSplitPane();
        moonPhaseTab = new JPanel();
        moonPhaseLabel = new JLabel();
        tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        windTab = new JPanel();
        uvTab = new JPanel();
        menuBar = new JMenuBar();
        file = new JMenu("File");
        about = new JMenuItem("About");
        exit = new JMenuItem("Exit");
        separator = new JSeparator();
        rainTabIcon = new ImageIcon("src/images/rain.png");
        windTabIcon = new ImageIcon("src/images/scattered clouds.png");
        tempHighLabel = new JLabel();
        tempLowLabel = new JLabel();
        currentTempLabel = new JLabel();
        currentTimeLabel = new JLabel();
        currentHumidity = new JLabel();
        JLabel weatherPaneTitle = new JLabel("What's the Weather?");
        weatherPaneTitle.setFont(new Font("Serif", Font.BOLD, 24));
        weatherPaneIconLabel = new JLabel(new ImageIcon("src/images/clouds2.png"));
        graphScrollPane = new JScrollPane(graphTab);
        rainScrollPane = new JScrollPane(rainRight);
        windScrollPane = new JScrollPane(windRight);
        evScrollPane = new JScrollPane(evRight);
        uvScrollPane = new JScrollPane(uvRight);

        // initialize main frame
        ImageIcon img = new ImageIcon("src/images/WeatherPicLogo.png");
        setIconImage(img.getImage());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1000, 400);
        setTitle("Console Receiver");
        file.add(about);
        file.add(tempToggle);
        file.add(separator);
        file.add(exit);
        menuBar.add(file);
        setJMenuBar(menuBar);

        // initialize main content pane
        contentPane.setBackground(new Color(174,242,239));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout());
        setContentPane(contentPane);

        // divide main content pane into two panes
        splitPane.setDividerLocation(300);
        splitPane.setLeftComponent(weatherPane);
        splitPane.setRightComponent(tabbedPane);
        contentPane.add(splitPane, BorderLayout.CENTER);

        // set up right side pane tabs
        rainTab.setLayout(new BorderLayout());
        rainTab.setBackground(new Color(255, 255, 255));
        graphTab.setLayout(new BorderLayout());
        graphTab.setBackground(new Color(255, 255, 255));
        windTab.setLayout(new BorderLayout());
        windTab.setBackground(new Color(255, 255, 255));
        moonPhaseTab.setBackground(new Color(255, 255, 255));
        moonPhaseTab.add(moonPhaseLabel);
        moonPhaseTab.add(new JLabel(new ImageIcon("src/images/moonphase.png")), BorderLayout.CENTER);
        uvTab.setLayout(new BorderLayout());
        uvTab.setBackground(new Color(255, 255, 255));
        evTab.setLayout(new BorderLayout());
        evTab.setBackground(new Color(255, 255, 255));
        weatherHistory.setEditable(false);
        tabbedPane.add("Weather History", historyScrollPane);
        tabbedPane.add("Rain", rainTab);
        tabbedPane.add("Wind", windTab);
        tabbedPane.add("UV & Solar Radiation", uvTab);
        tabbedPane.add("Moon Phases", moonPhaseTab);
        tabbedPane.add("Evapotranspiration", evTab);
        tabbedPane.add("Graphs", graphScrollPane);

        // set up content in each individual tab
        rainTab.add(splitPaneRain, BorderLayout.CENTER);
        splitPaneRain.setLeftComponent(rainLeft);
        splitPaneRain.setRightComponent(rainScrollPane);
        rainLeft.setBackground(new Color(245,255,250));
        rainLeft.add(rainTabLabel);
        rainLeft.add(new JLabel(rainTabIcon), BorderLayout.CENTER);
        rainRight.setEditable(false);

        windTab.add(splitPaneWind, BorderLayout.CENTER);
        splitPaneWind.setLeftComponent(windLeft);
        splitPaneWind.setRightComponent(windScrollPane);
        windLeft.setBackground(new Color(245,255,250));
        windLeft.add(windTabLabel);
        windLeft.add(new JLabel(windTabIcon), BorderLayout.CENTER);
        windRight.setEditable(false);

        uvTab.add(splitPaneUV, BorderLayout.CENTER);
        splitPaneUV.setLeftComponent(uvLeft);
        splitPaneUV.setRightComponent(uvScrollPane);
        uvLeft.setBackground(new Color(245,255,250));
        uvLeft.add(uvTabLabel);
        uvLeft.add(new JLabel(uvTabIcon), BorderLayout.CENTER);
        uvRight.setEditable(false);

        evTab.add(splitPaneEV, BorderLayout.CENTER);
        splitPaneEV.setLeftComponent(evLeft);
        splitPaneEV.setRightComponent(evScrollPane);
        evLeft.setBackground(new Color(245,255,250));
        evLeft.add(evTabLabel);
        evLeft.add(new JLabel(evTabIcon), BorderLayout.CENTER);
        evRight.setEditable(false);

        graphTab.add(graphPane);
        graphPane.setBackground(new Color(255,255,255));
        tempGraph.add(new JLabel("Temp. Graph (x=time, y=°F)"));
        rainGraph.add(new JLabel("Rain Graph (x=time, y=click amt.)"));
        windGraph.add(new JLabel("Wind Graph (x=time, wind spd.)"));
        graphPane.add(tempGraph);
        graphPane.add(rainGraph);
        graphPane.add(windGraph);

        // set left side which includes basic weather information
        weatherPane.setLayout(null);
        currentTimeLabel.setBounds(70, 280, 300, 50);
        weatherPane.add(currentTimeLabel);
        weatherPane.setBackground(new Color(255, 255, 255));
        weatherPane.add(weatherPaneTitle);
        weatherPaneTitle.setBounds(40, 0, 300, 50);
        weatherPane.add(tempLowLabel);
        tempLowLabel.setBounds(15, 205, 150, 50);
        weatherPane.add(tempHighLabel);
        tempHighLabel.setBounds(185, 205, 150, 50);
        weatherPane.add(currentTempLabel);
        currentTempLabel.setBounds(75, 50, 200, 50);
        weatherPane.add(weatherPaneIconLabel, BorderLayout.CENTER);
        weatherPaneIconLabel.setBounds(100, 90, 100, 100);
        weatherPane.add(currentHumidity);
        currentHumidity.setBounds(90, 165, 150, 50);
        weatherPane.add(statusIndicator);
        statusIndicator.setBounds(107, 260, 150, 50);
        weatherPane.add(barometerDirectionLabel);
        barometerDirectionLabel.setBounds(23, 110, 150, 50);
        weatherPane.add(barometerPressureLabel);
        barometerPressureLabel.setBounds(200, 110, 150, 50);
        sunriseLabel.setText("Sunrise: " + + ThreadLocalRandom.current().nextInt(4, 7 + 1) + ":" +
                ThreadLocalRandom.current().nextInt(0, 5 + 1) +
                ThreadLocalRandom.current().nextInt(0, 9 + 1) + " AM");
        sunsetLabel.setText("Sunset: " + ThreadLocalRandom.current().nextInt(5, 8 + 1) + ":" +
                ThreadLocalRandom.current().nextInt(0, 5 + 1) +
                ThreadLocalRandom.current().nextInt(0, 9 + 1) + " PM");
        weatherPane.add(sunriseLabel);
        sunriseLabel.setBounds(17, 230, 150, 50);
        weatherPane.add(sunsetLabel);
        sunsetLabel.setBounds(187, 230, 150, 50);

        setUpListeners();
        setVisible(true);
    }

    @Override
    // runs the console receiver
    public void run() {
        new ConsoleReceiver();
    }

    // update displayed data according to real-time ISS readings
    public void update(IntegratedSensorSuite iss) {
        rainTabLabel.setText("<html>Rain Level: " + iss.myCurrentRainAmount + "<br/> Dew Point: " +
                exOptions.getDewPoint(iss.myTemperatureSensor, iss.myHumiditySensor) + "</html>");
        windTabLabel.setText("<html>Wind Direction: " + iss.myCurrentWindDirection +
                "<br/> Wind Speed: " + iss.myCurrentWindSpeed + "<br/> Wind Chill: " +
                exOptions.getWindChill(iss.myTemperatureSensor, iss.myAnemometer) + "</html>");
        moonPhaseLabel.setText("Number of days into the moon's cycle: " + moonPhase.getMoonPhase());
        Integer currentUV = uvFeatures.getUV();
        Integer currentSR = uvFeatures.getSolarRad();
        uvTabLabel.setText("<html>UV index: " + currentUV +
                        "<br/>Solar Radiation index: " + currentSR + "</html>");
        Integer currentEV = evFeatures.getEvapotranspiration(Main.myIntegratedSensorSuite.myTemperatureSensor);
        evTabLabel.setText("Evapotranspiration Value: " + currentEV);
        if(showCelcius) {
            currentTempLabel.setText("Current Temperature: " +
                    exOptions.fahrenheitToCelsius(iss.myCurrentTemperature) + "° C");
        } else {
            currentTempLabel.setText("Current Temperature: " + iss.myCurrentTemperature + "° F");
        }
        graphTempValues.add(iss.myCurrentTemperature);
        tempGraph.addValues(graphTempValues);
        graphRainValues.add((int)iss.myCurrentRainAmount);
        rainGraph.addValues(graphRainValues);
        graphWindValues.add(windRainFeatures.getWindSpeed(iss.myAnemometer));
        windGraph.addValues(graphWindValues);

        barometerDirectionLabel.setText("WP: " +
                barometerFeatures.calculateWindPressure(windRainFeatures, iss.myAnemometer));
        barometerPressureLabel.setText("WD: " + barometerFeatures.direction());
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
        Date date = new Date(System.currentTimeMillis());
        currentTime = formatter.format(date);
        currentTimeLabel.setText(currentTime);
        currentHumidity.setText("Current Humidity: " + iss.myCurrentHumidity + "%");
        weatherHistory.append(iss.toString() + " at " + formatter.format(date).substring(14) + "\n");
        rainRight.append("Rainfall measurement: " + iss.myCurrentRainAmount + " & Dew Point: " +
                exOptions.getDewPoint(iss.myTemperatureSensor, iss.myHumiditySensor) + " at "
                + formatter.format(date).substring(14) + "\n");
        uvRight.append("UV index: " + currentUV +
                " & Solar Radiation index: " + currentSR + " at "
                + formatter.format(date).substring(14) + "\n");
        evRight.append("EV level: " + currentEV + " at "
                + formatter.format(date).substring(14) + "\n");
        statusIndicator.setForeground(Color.green);


        windRight.append("Wind Direction: " + iss.myCurrentWindDirection + " & Wind Speed: " +
                iss.myCurrentWindSpeed + " & Wind Chill: " +
                exOptions.getWindChill(iss.myTemperatureSensor, iss.myAnemometer) + " at "
                + formatter.format(date).substring(14) + "\n");

        if (iss.myCurrentTemperature > tempHigh) {
            tempHigh = iss.myCurrentTemperature;
        } else if (iss.myCurrentTemperature < tempLow) {
            tempLow = iss.myCurrentTemperature;
        }

        if(showCelcius) {
            tempHighLabel.setText("Temp. High: " + exOptions.fahrenheitToCelsius(tempHigh) + "° C");
            tempLowLabel.setText("Temp. Low: " + exOptions.fahrenheitToCelsius(tempLow) + "° C");
        } else {
            tempHighLabel.setText("Temp. High: " + tempHigh + "° F");
            tempLowLabel.setText("Temp. Low: " + tempLow + "° F");
        }

        if (iss.myCurrentTemperature > 140) {
            if(showCelcius) {
                JOptionPane.showMessageDialog(new JPanel(), "Temperature has exceeded 60°C! Heatstroke caution!",
                        "Temperature Warning", JOptionPane.WARNING_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(new JPanel(), "Temperature has exceeded 140°F! Heatstroke caution!",
                        "Temperature Warning", JOptionPane.WARNING_MESSAGE);
            }

        }

        if (iss.myCurrentRainAmount > 12000) {
            JOptionPane.showMessageDialog(new JPanel(),
                    "Rainfall has exceeded 12000 clicks! Rainstorm caution!",
                    "Storm Warning", JOptionPane.WARNING_MESSAGE);
        }

    }

    // event handlers
    private void setUpListeners() {
        about.addActionListener(theEvent -> JOptionPane.showMessageDialog
                (new JPanel(), "Developed by Joseph Yun, Noah Kehm, Jonathan Lee, and Brandon Soledad",
                        "About", 1));
        exit.addActionListener(theEvent -> System.exit(0));
        tempToggle.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (showCelcius == false) {
                    tempToggle.setText("Show °F");
                    showCelcius = true;
                } else {
                    tempToggle.setText("Show °C");
                    showCelcius = false;
                }
            }
        });
    }
}

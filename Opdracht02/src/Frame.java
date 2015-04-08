
import java.awt.GridLayout;
import java.awt.event.*;
import java.util.Properties;
import javax.swing.*;
import org.jdatepicker.JDatePicker;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;
import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.Hours;
import org.joda.time.Years;
import org.joda.time.LocalDate;
import org.joda.time.Seconds;

public class Frame extends JFrame {

    private JButton knop;
    private JLabel yearLabel;
    private JLabel daysLabel;
    private JLabel hoursLabel;
    private JLabel secondsLabel;
    private JLabel millisLabel;
    private JLabel beginTijd;
    private JLabel eindTijd;
    private JPanel panel = new JPanel();
    private JPanel leftpanel = new JPanel();
    private JPanel rightpanel = new JPanel();
    private UtilDateModel dateModel1 = new UtilDateModel();
    private UtilDateModel dateModel2 = new UtilDateModel();
    private JDatePanelImpl datePanel1 = new JDatePanelImpl(dateModel1, datePanel1Properties());
    private JDatePanelImpl datePanel2 = new JDatePanelImpl(dateModel2, datePanel1Properties());
    private JDatePickerImpl datePicker1 = new JDatePickerImpl(datePanel1, new DateLabelFormatter());
    private JDatePickerImpl datePicker2 = new JDatePickerImpl(datePanel2, new DateLabelFormatter());
    
    public Frame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("mijn nieuwe frame");
        //setBounds(50,50,450,400);
        setSize(450, 400);
        setLocationRelativeTo(null); // positie frame
        GridLayout gridje = new GridLayout(1,2); // rij en kolom
        GridLayout leftLayout = new GridLayout(8,1);
        GridLayout rightLayout = new GridLayout(8,1);
        panel.setLayout(gridje); // layout implementeren aan panel
        leftpanel.setLayout(leftLayout);
        rightpanel.setLayout(rightLayout);
        add(panel); // Panel toevoegen aan Frame
        panel.add(leftpanel);
        panel.add(rightpanel);
        
        knop = new JButton("Calculate");
        EventHandler eh = new EventHandler();
        knop.addActionListener(eh);
        yearLabel = new JLabel();
        daysLabel = new JLabel();
        hoursLabel = new JLabel();
        secondsLabel = new JLabel();
        millisLabel = new JLabel();
        beginTijd = new JLabel("Begin Tijd: ");
        eindTijd = new JLabel("Eind Tijd: ");
        
        rightpanel.add(knop); // Button en tekst toevoegen aan Panel
        rightpanel.add(beginTijd);
        rightpanel.add(datePicker1);
        rightpanel.add(eindTijd);
        rightpanel.add(datePicker2);
        leftpanel.add(yearLabel);
        leftpanel.add(daysLabel);
        leftpanel.add(hoursLabel);
        leftpanel.add(secondsLabel);
        leftpanel.add(millisLabel);
        setVisible(true);
    }

    class EventHandler implements ActionListener {

        Calculator cal = new Calculator(datePicker1, datePicker2);
        
        public void actionPerformed(ActionEvent e) {
            yearLabel.setText("Je bent " + cal.calculateAge() + " jaar oud.");
            daysLabel.setText("Je bent " + cal.calculateDays() + " dagen oud.");
            hoursLabel.setText("Je bent " + cal.calculateHours() + " uren oud.");
            secondsLabel.setText("Je bent " + cal.calculateSeconds() + " seconden oud.");
            millisLabel.setText("Je bent " + cal.calculateMillis() + " milliseconden oud.");
        }
    }

    public Properties datePanel1Properties() {
        Properties p = new Properties();
        p.put("text.today", "Today");
        p.put("text.month", "Month");
        p.put("text.year", "Year");
        return p;
    }

}

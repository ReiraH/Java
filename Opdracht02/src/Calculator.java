
import org.jdatepicker.JDatePicker;
import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.Hours;
import org.joda.time.Seconds;
import org.joda.time.Years;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rhea
 */
public class Calculator {     // iets van datepicker pakken : datePicker1.getModel().getDay() bijvoorbeeld 
 
        private JDatePicker datePicker1;
        private JDatePicker datePicker2;
    
        public Calculator(JDatePicker datePicker1, JDatePicker datePicker2) {
            this.datePicker1 = datePicker1;
            this.datePicker2 = datePicker2;
        }
    
        public int calculateAge() {
        DateTime selectedDate1 = new DateTime(datePicker1.getModel().getYear(),
                datePicker1.getModel().getMonth() + 1,
                datePicker1.getModel().getDay(), 0, 0);

        DateTime selectedDate2 = new DateTime(datePicker2.getModel().getYear(),
                datePicker1.getModel().getMonth() + 1,
                datePicker1.getModel().getDay(), 0, 0);

        return Years.yearsBetween(selectedDate1.toLocalDate(), selectedDate2.toLocalDate()).getYears();
    }

    public int calculateDays() {
        DateTime selectedDate1 = new DateTime(datePicker1.getModel().getYear(),
                datePicker1.getModel().getMonth(),
                datePicker1.getModel().getDay(), 0, 0);
        
        DateTime selectedDate2 = new DateTime(datePicker2.getModel().getYear(),
                datePicker1.getModel().getMonth() + 1,
                datePicker1.getModel().getDay(), 0, 0);
        
        return Days.daysBetween(selectedDate1.toLocalDate(), selectedDate2.toLocalDate()).getDays();
    }
    
        public int calculateHours() {
        DateTime selectedDate1 = new DateTime(datePicker1.getModel().getYear(),
                datePicker1.getModel().getMonth(),
                datePicker1.getModel().getDay(), 0, 0);
        
        DateTime selectedDate2 = new DateTime(datePicker2.getModel().getYear(),
                datePicker1.getModel().getMonth() + 1,
                datePicker1.getModel().getDay(), 0, 0);
        
        return Hours.hoursBetween(selectedDate1.toLocalDate(), selectedDate2.toLocalDate()).getHours();
    }
        
    public int calculateSeconds() {
        DateTime selectedDate1 = new DateTime(datePicker1.getModel().getYear(),
                datePicker1.getModel().getMonth(),
                datePicker1.getModel().getDay(), 0, 0);
        
        DateTime selectedDate2 = new DateTime(datePicker2.getModel().getYear(),
                datePicker1.getModel().getMonth() + 1,
                datePicker1.getModel().getDay(), 0, 0);
       
        return Seconds.secondsBetween(selectedDate1.toLocalDate(), selectedDate2.toLocalDate()).getSeconds();
    }
    
    public int calculateMillis() {
        DateTime selectedDate1 = new DateTime(datePicker1.getModel().getYear(),
                datePicker1.getModel().getMonth(),
                datePicker1.getModel().getDay(), 0, 0);
        
        DateTime selectedDate2 = new DateTime(datePicker2.getModel().getYear(),
                datePicker1.getModel().getMonth() + 1,
                datePicker1.getModel().getDay(), 0, 0);
        
        return (calculateSeconds() * 1000);
    }
    
}

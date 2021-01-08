package com.company.gui.util;

import javax.swing.JFormattedTextField.AbstractFormatter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class DateLabelFormatter extends AbstractFormatter {

    private String datePattern = "dd-MM-yyyy";
    private SimpleDateFormat dateFormatter = new SimpleDateFormat(datePattern);
    private String dateTimePattern = "dd-MM-yyyy HH:mm";
    private SimpleDateFormat dateTimeFormatter = new SimpleDateFormat(dateTimePattern);

    /**
     * Converte uma String no formato datePattern = "dd-MM-yyyy" para um objeto Calendar.
     *
     * @param text
     * @return
     * @throws ParseException
     */
    @Override
    public Object stringToValue(String text) throws ParseException {
        return dateFormatter.parseObject(text);
    }

    /**
     * Converte um objeto com data e hora para o formato de String datePattern = "dd-MM-yyyy".
     *
     * @param value
     * @return
     * @throws ParseException
     */
    @Override
    public String valueToString(Object value) throws ParseException {
        if (value != null) {
            Calendar cal = (Calendar) value;
            cal = (GregorianCalendar)value;
            return dateFormatter.format(cal.getTime());
        }

        return "";
    }

    /**
     * Converte uma String no formato dateTimePattern = "dd-MM-yyyy HH:mm" para um objeto Calendar.
     *
     * @param text
     * @return
     * @throws ParseException
     */
    public Object stringToDateTime(String text) throws ParseException {
        return dateTimeFormatter.parseObject(text);
    }

    /**
     * Converte um objeto com data e hora para o formato de String dateTimePattern = "dd-MM-yyyy HH:mm".
     *
     * @param value
     * @return
     * @throws ParseException
     */
    public String dateTimeToString(Object value) throws ParseException {
        if (value != null) {
            Calendar cal = (Calendar) value;
            return dateTimeFormatter.format(cal.getTime());
        }

        return "";
    }

}

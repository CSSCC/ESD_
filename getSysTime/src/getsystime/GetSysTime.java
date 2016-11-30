/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package getsystime;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author t2-lings
 */
public class GetSysTime {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //timeStamp is the date in desired format.
        String timeStamp = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
    }
    
}


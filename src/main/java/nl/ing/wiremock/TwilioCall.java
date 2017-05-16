package nl.ing.wiremock;

import nl.ing.wiremock.util.ResourceUtil;

import java.io.*;
import java.util.Properties;
import java.util.Scanner;

/**
 * Created by thage on 16-5-17.
 */
public class TwilioCall {

    public static void main(String[] args){

        TwilioCall twilioCall = new TwilioCall();
        twilioCall.doIt();
    }

    public void doIt(){
        Properties properties = ResourceUtil.getProperties();
        String s = properties.getProperty("hostname");

        System.out.println(s);
    }

}

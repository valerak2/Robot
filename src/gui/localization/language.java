package gui.localization;

import log.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;

class language {
    static Locale language = new Locale("eng");
    public static void main(String[] args) throws UnsupportedEncodingException {
        language=new Locale("");
        printInfo();
        language=new Locale("eng");
        printInfo();
        language=new Locale("ru");
        printInfo();
    }

    private static void printInfo() {
        ResourceBundle rb = ResourceBundle.getBundle("lang", language);
        String s1 = rb.getString("GameWindow.name");

        System.out.println(s1);
        System.out.println();
    }
    public void setLanguage(String lang){
        language = new Locale(lang);
    }
}
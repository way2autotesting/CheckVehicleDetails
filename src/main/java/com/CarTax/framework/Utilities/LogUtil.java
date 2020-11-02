package com.CarTax.framework.Utilities;

import com.CarTax.framework.config.Settings;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by Ibi on 01/11/2020.
 */
public class LogUtil {

    //File format for the log name
    ZonedDateTime date = ZonedDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyyyHHMMSS");
    String fileNameFormat = date.format(formatter);

    private BufferedWriter bufferedWriter = null;


    //Create Log file
    public void CreateLogFile() throws IOException {
        try {
            File dir = new File(Settings.LogPath);
            if (!dir.exists())
                dir.mkdir();
            //Create file
            File logFile = new File(dir + "/" + fileNameFormat + ".log");

            FileWriter fileWriter = new FileWriter(logFile.getAbsoluteFile());
            bufferedWriter = new BufferedWriter(fileWriter);

        } catch (Exception e) {

        }
    }


    //Write message within the log
    public void Write(String message) {
        try {
            formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy:HH_MM_SS");
            String dateFormat = date.format(formatter);
            bufferedWriter.write("[" + dateFormat + "]: " + message);
            bufferedWriter.newLine();
            bufferedWriter.flush();
        } catch (Exception e) {

        }
    }
}

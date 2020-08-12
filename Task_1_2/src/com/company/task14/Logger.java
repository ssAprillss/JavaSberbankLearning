package com.company.task14;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Logger implements Loggable {

    private Path logFile;

    public Logger(String file){
        this.logFile=Paths.get(file);
    }

    @Override
    public  void log(String usr,String msg){
        try {
            Files.write(logFile, (usr + " - " + java.time.LocalDateTime.now().toString() + ": " + msg + "\n").getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package com.company.task7;

public class Logger implements Printable {

    @Override
    public  void print(){
        print("Что-то произошло, но я не заю что.");
    }

    public  void print(String operation)  {
        String date = java.time.LocalDateTime.now().toString();
        String computerName = System.getenv("COMPUTERNAME");
        String userName = System.getProperty("user.name");
        System.out.printf("%s, %s, %s: %s\n",date,computerName,userName,operation);
    }
}

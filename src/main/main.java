package main;

import clases.receiver;
import clases.sender;
import java.net.InetAddress;
import ventanas.sendFiles;

public class main{
    public static void main(String[] args){
        new sendFiles().setVisible(true);
        //new receiver(null).receiveFiles();
        //new sender().sendFiles("C:\\Users\\erick\\Desktop\\Base-jdk16\\base\\src\\data\\databackup\\Empleados\\Pruebas-54321/Pruebas-54321.json");
        //gets the ip address of this PC
        /*try{
            System.out.println(InetAddress.getLocalHost());
        }catch(Exception e){
            System.out.println(e.getCause());
        }*/
    }
}
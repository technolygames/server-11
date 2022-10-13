/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import gui.frame.mainFrame;
import java.awt.EventQueue;

/**
 * Main class to use test window
 * 
 * @author erick
 */
public class main{
    
    /**
     * Main class
     * 
     * @param args to be set
     */
    public static void main(String[] args){
        EventQueue.invokeLater(()->{
            new mainFrame().setVisible(true);
        });
    }
}
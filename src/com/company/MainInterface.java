

package com.company;


import com.company.gui.Interface;

public class MainInterface {

    public static void main(String[] args) {
        Interface sistema = new Interface(new Sistema());
        sistema.setVisible(true);
    }

}




package main;


import problem1.CastleCompany;
import problem2.Exception;
import problem2.Test;

import java.io.FileNotFoundException;

public class  ProjectDriver {
    public static void main(String[] args) throws Exception, FileNotFoundException {

        CastleCompany.run();

        System.out.println();

//        Test.run();
    }
}

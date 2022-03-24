package com.fc.demo1._static;
import org.junit.Test;

public class Court {
    @Test
    public void test(){
        Lawsuit parties = new Parties();
        Lawsuit lawyer = new Lawyer(parties);
        lawyer.submit();
        lawyer.defend();
    }
}

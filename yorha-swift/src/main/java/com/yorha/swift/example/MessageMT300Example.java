package com.yorha.swift.example;

import com.prowidesoftware.swift.model.*;
import com.prowidesoftware.swift.model.mt.mt3xx.*;
import com.prowidesoftware.swift.model.field.*;

public class MessageMT300Example {


    public static void main(String[] args) {
        final MT300 m = new MT300();
        SwiftBlock1 b1 = new SwiftBlock1();
        b1.setApplicationId("F");
        b1.setServiceId("01");
        b1.setLogicalTerminal("BICFOOYYAXXX");
        b1.setSessionNumber("1234");
        b1.setSequenceNumber("123456");
        m.getSwiftMessage().setBlock1(b1);
        SwiftBlock2Input b2 = new SwiftBlock2Input();
        b2.setMessageType("103");
        b2.setReceiverAddress("BICFOARXXXXX");
        b2.setDeliveryMonitoring("1");
        m.getSwiftMessage().setBlock2(b2);
        SwiftBlock3 block3 = new SwiftBlock3();
        block3.append(new Field119("STP"));
        m.getSwiftMessage().addBlock(block3);

        /*
         * Start adding the message's fields in correct order
         */
        m.addField(new Field20("REFERENCE"));

        m.addField(new Field15B());
        m.addField(new Field30T("20161027"));
        m.addField(new Field30V("20161027"));
        m.addField(new Field36("20161027"));

        m.addField(new Field32B("USD123456789123456"));
        m.addField(new Field57A("QWEASDZXXXX"));

        m.addField(new Field33B("USD123456789123456"));
        m.addField(new Field57A("QWEASDZXXXX"));

        m.getSequenceB2();
        m.getSequenceD1List();
        System.out.println(m.message());
    }
}

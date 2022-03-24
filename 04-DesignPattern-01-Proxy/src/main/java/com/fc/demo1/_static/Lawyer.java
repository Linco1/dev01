package com.fc.demo1._static;

public class Lawyer implements Lawsuit{
    private final Lawsuit lawsuit;

    public Lawyer(Lawsuit lawsuit) {
        this.lawsuit = lawsuit;
    }

    @Override
    public void submit() {
       this.gatherEvidence();
       lawsuit.submit();
    }

    @Override
    public void defend() {
        lawsuit.defend();
        this.compareNotes();

    }
    private void gatherEvidence(){
        System.out.println("搜集证据");
    }
    private void compareNotes(){
        System.out.println("交换意见，如果被告不服，继续上诉");
    }
}

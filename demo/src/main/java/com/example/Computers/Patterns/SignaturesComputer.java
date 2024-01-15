package com.example.Computers.Patterns;

import java.util.ArrayList;
import java.util.List;

public class SignaturesComputer {

    public List<String> generateSignature(List<Integer> inputList) 
    {
        List<String> signature = new ArrayList<String>();

        for (int i = 0; i < inputList.size() - 1; i++) {
            int current = inputList.get(i);
            int next = inputList.get(i + 1);

            if (current < next) {
                signature.add("<");
            } else if (current == next) {
                signature.add("=");
            } else {
                signature.add(">");
            }
        }

        return signature;
    }
}

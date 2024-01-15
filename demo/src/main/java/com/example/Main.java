package com.example;

import java.util.List;

import com.example.Computers.ExtremesComputer;
import com.example.Objects.ExtremesResult;

public class Main {
    public static void main(String[] args) {

        ExtremesComputer extremesComputer = new ExtremesComputer();

        List<Integer> variables = List.of(3, 2, 2, 1, 2, 3, 1, 1, 2, 3, 4, 2, 3, 3, 3, 1);

        ExtremesResult extremResults = extremesComputer.computeExtremes2("min", "max", "peak", variables);

        if(extremResults == null){
            System.out.println("Il y'a eu un problème lors du calcul des extremes: ");
        }
    }
}
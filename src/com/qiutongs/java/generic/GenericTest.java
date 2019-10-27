package com.qiutongs.java.generic;

import java.util.ArrayList;
import java.util.List;

import com.qiutongs.java.inheritance.Child;
import com.qiutongs.java.inheritance.Parent;

/**
 * @author qiutongs
 * Ref: https://dzone.com/articles/covariance-and-contravariance
 */
public class GenericTest {

    public static void main(String[] args) {
        /* --------- Arrays are covariant ---------- */
        
        // an array of T[] may contain elements of type T of any subtype of T */
        // an array S[] is a subtype of the array T[] if s is a subtype of T
        Parent[] pArray = new Child[1];
        pArray[0] = new Child();
        System.out.println(pArray[0]);

        /* --------- Java Generics has Type Erase ---------- */
        
        // Type mismatch: cannot convert from Generic<Child> to Generic<Parent>
        // Generic<Parent> p = new Generic<Child>();
        
        // Type mismatch: cannot convert from ArrayList<Child> to List<Parent>
        // List<Parent> pList = new ArrayList<Child>();

        /* --------- Covariance in Generics ---------- */
        /* --------- read is ok, write is NOT ---------- */
        
        Generic<? extends Parent> pCovariance = new Generic<Child>();
        List<? extends Parent> pListCovariance = new ArrayList<Child>();
        
        Parent anotherP = pCovariance.get();
        
        // The method func(capture#2-of ? extends Parent) in the type Generic<capture#2-of ? extends Parent> is not applicable for the arguments (Parent)
        // pCovariance.func();
        
        // The method add(capture#2-of ? extends Parent) in the type List<capture#2-of ? extends Parent> is not applicable for the arguments (Child)
        // pListCovariance.add(new Child());

        /* --------- Contravariance in Generics ---------- */
        /* --------- write is ok, read is NOT ---------- */
        
        Generic<? super Parent> pContravariance = new Generic<>();
        List<? super Parent> pListContravariance = new ArrayList<>();
        
        // Type mismatch: cannot convert from capture#2-of ? super Child to Parent
        // Parent anotherPP = pContravariance.get();
        
        pContravariance.func(new Child());
        pListContravariance.add(new Child());
        
        List<Parent> list  = new ArrayList<>();
        list.add(new Child());
    }

}

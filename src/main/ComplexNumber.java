package main;

import java.util.*;
import java.lang.String;

public class ComplexNumber extends Number {

    private double re;
    private double im;

    public ComplexNumber (double re, double im) {
        super();
        this.re = re;
        this.im = im;
    }


    public ComplexNumber(String value) {
        super(value);
        StringTokenizer st = new StringTokenizer (value, "+-i", true);
        if (st.hasMoreTokens()) {
            String sa = st.nextToken().trim();
            if (st.hasMoreTokens()) {
                if (sa.equals ("+")) sa = st.nextToken().trim();
                if (sa.equals ("-")) sa = "-" + st.nextToken().trim();
                if (sa.equals ("i")) throw new IllegalArgumentException
                        (value + " is not a complex number");
            }
            re = Double.parseDouble (sa);
            if (st.hasMoreTokens()) {
                String sb = st.nextToken().trim();
                if (st.hasMoreTokens()) {
                    if (sb.equals ("+")) sb = st.nextToken().trim();
                    if (sb.equals ("-")) sb = "-" + st.nextToken().trim();
                }
                im = Double.parseDouble (sb);
            }
            if (st.hasMoreTokens()) {
                String si = st.nextToken().trim();
                if (!si.equals ("i"))
                    throw new IllegalArgumentException
                            (value + " is not a complex number");
                if (st.hasMoreTokens())
                    throw new IllegalArgumentException
                            (value + " is not a complex number");
            } else
                throw new IllegalArgumentException
                        (value + " is not a complex number");
        } else
            throw new IllegalArgumentException (value + " is not a complex number");
    }

    public double getRe() {
        return re;
    }

    public double getIm() {
        return im;
    }

    public static ComplexNumber add(ComplexNumber cn1, ComplexNumber cn2) {
        return new ComplexNumber(cn1.getRe() + cn2.getRe(), cn1.getIm() + cn2.getIm());
    }

    public static ComplexNumber dif(ComplexNumber cn1, ComplexNumber cn2) {
        return new ComplexNumber(cn1.getRe() - cn2.getRe(), cn1.getIm() - cn2.getIm());
    }

    private String sign() {
        if (im > 0) return " + ";
        else return " - ";
    }

    @Override
    public String toString() {
        String string;
        if (im == 1 || im == -1) {
            if (re == 0) {
                string = sign() + "i";
            } else {
                string = re + sign() + "i";
            }
        } else {
            string = re + sign() + Math.abs(im) + "i";
        }
        return string;
    }

}

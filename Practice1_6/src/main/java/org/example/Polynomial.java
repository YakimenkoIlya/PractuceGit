package org.example;

import java.util.ArrayList;
import java.util.List;

public class Polynomial {
    private List<ComplexNumber> coefficients;
    private static double realSum = 0;
    private static double imaginarySum = 0;

    public Polynomial(List<ComplexNumber> coefficients) {
        this.coefficients = coefficients;
    }

    public Polynomial() {
        this.coefficients = new ArrayList<>();
    }

    public Polynomial add(Polynomial other) {
        int maxSize = Math.max(this.coefficients.size(), other.coefficients.size());
        List<ComplexNumber> resultCoefficients = new ArrayList<>();

        for (int i = 0; i < maxSize; i++) {
            ComplexNumber coef1 = (i < this.coefficients.size()) ? this.coefficients.get(i) : new ComplexNumber(0, 0);
            ComplexNumber coef2 = (i < other.coefficients.size()) ? other.coefficients.get(i) : new ComplexNumber(0, 0);

            resultCoefficients.add(coef1.add(coef2));
        }

        return new Polynomial(resultCoefficients);
    }

    public List<ComplexNumber> getCoefficients() {
        return coefficients;
    }

    public void setCoefficients(List<ComplexNumber> coefficients) {
        this.coefficients = coefficients;
    }

    public static void exercise() {
        List<Polynomial> polynomials = new ArrayList<>();

        Polynomial polynomial1 = new Polynomial();
        Polynomial polynomial2 = new Polynomial();

        List<ComplexNumber> coefficients1 = new ArrayList<>();
        coefficients1.add(new ComplexNumber(2, 3));
        coefficients1.add(new ComplexNumber(-1, 2));
        polynomial1.setCoefficients(coefficients1);

        List<ComplexNumber> coefficients2 = new ArrayList<>();
        coefficients2.add(new ComplexNumber(1, -2));
        coefficients2.add(new ComplexNumber(3, 1));
        coefficients2.add(new ComplexNumber(0, 4));
        polynomial2.setCoefficients(coefficients2);

        polynomials.add(polynomial1);
        polynomials.add(polynomial2);

        Polynomial sum = new Polynomial();
        for (Polynomial polynomial : polynomials) {
            sum = sum.add(polynomial);
        }

        List<ComplexNumber> sumCoefficients = sum.getCoefficients();

        System.out.println("Полиномы:");
        for (ComplexNumber coefficient : sumCoefficients) {
            System.out.println(coefficient.getReal() + " + " + coefficient.getImaginary() + "i");
        }

        System.out.println("\nСумма всех полиномов:");
        for (ComplexNumber coefficient : sumCoefficients) {
            realSum += coefficient.getReal();
            imaginarySum += coefficient.getImaginary();
        }
        System.out.println(realSum + " + " + imaginarySum + "i");
    }
}

class ComplexNumber {
    private double real;
    private double imaginary;

    public ComplexNumber(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public double getReal() {
        return real;
    }

    public void setReal(double real) {
        this.real = real;
    }

    public double getImaginary() {
        return imaginary;
    }

    public void setImaginary(double imaginary) {
        this.imaginary = imaginary;
    }

    public ComplexNumber add(ComplexNumber other) {
        double newReal = this.real + other.real;
        double newImaginary = this.imaginary + other.imaginary;
        return new ComplexNumber(newReal, newImaginary);
    }
}



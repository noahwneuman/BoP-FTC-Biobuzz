package org.firstinspires.ftc.teamcode.resources;

import org.jetbrains.annotations.Contract;

public class Helpers {
    /**
     * Checks if two numbers are approximately equal
     * @param a the first number
     * @param b the second number
     * @param tol the tolerance
     * @returns if the difference of a and b are within the tolerance of tol
     */
    @Contract(pure = true)
    public static boolean apprEqual (double a, double b, double tol) {
        return Math.abs(a - b) < tol;
    }
}

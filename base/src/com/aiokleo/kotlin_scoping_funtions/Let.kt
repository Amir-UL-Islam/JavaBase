package com.aiokleo.kotlin_scoping_funtions

import java.util.Scanner

class Let : ExampleScopingClass() {
    private var number: Int? = Scanner(System.`in`).nextInt()
    override fun test(a: Int?) {
        if (number != null) {
            val aNumber = number!! + 1 // the number Might be changed by another thread
            // So I need to Ensure that the number is not null
            // by Using !! operator
            super.test(aNumber)
        }
        // Or use let function
        val x = number?.let {// if (number != null) is equal to (number?.let)
            val aNumber = it + 1
            val bNumber =
                aNumber.also { aNumber * aNumber } // without declaring aNumber the type of the x Variable will be Unit
            // as the last statement which is (val aNumber = it + 1) is a block of code that Declares a variable
            // Buy now x is an Int type
            // If you remove aNumber after ```val aNumber = it + 1 ``` the type of x will be Unit
        } ?: 4// work as else

        val aAlso = super.test(a).also { println("The Value of a Variable is Change to $a by also scoping function") }


        val aApply = super.test(a).apply { var b: Int? = a }
    }

    fun testWithoutLet() {
        test(number)
    }
}

package com.example.factorial;

import android.os.AsyncTask;

import com.example.factorial.interfaces.AnotherInterface;
import com.example.factorial.interfaces.MyInterface;

import java.math.BigInteger;

class Factorial extends AsyncTask<String, Void, String> {

    private MyInterface otherPillarsEnd;
    private AnotherInterface anotherInterface;

    public Factorial(MyInterface otherPillarsEnd, AnotherInterface anotherInterface) {
        this.otherPillarsEnd = otherPillarsEnd;
        this.anotherInterface = anotherInterface;
    }

    @Override
    protected String doInBackground(String... params) {
        int from = Integer.parseInt(params[0]);
        int to = Integer.parseInt(params[1]);
        String result = "";
        for (int i = from; i <= to; i++) {
            result = i + "! = " + calculatingFactorial(i) + "\n --------------------------------------------------- \n"
                    + result;
        }
        return result;
    }

    @Override
    protected void onPostExecute(String result) {
       System.out.print(result);
       otherPillarsEnd.done(result);
       otherPillarsEnd.hello("", 0, 0);
    }


    public BigInteger calculatingFactorial(int n) {
        BigInteger result;
        BigInteger bign = new BigInteger(n + "");
        if (n != 0) {
            result = new BigInteger(bign.multiply(calculatingFactorial(n - 1)) + "");
        } else {
            result = new BigInteger("1");
        }
        return result;
    }

}

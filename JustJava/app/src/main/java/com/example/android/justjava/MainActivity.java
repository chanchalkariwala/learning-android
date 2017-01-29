package com.example.android.justjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int miQuantity = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void submitOrder(View pView)
    {
        displayQuantity();
        displayPrice(2*5);
    }

    public void increment(View pView)
    {
        miQuantity++;
        displayQuantity();
    }

    public void decrement(View pView)
    {
        if(miQuantity == 0)
            return;

        miQuantity--;
        displayQuantity();
    }

    public void displayQuantity()
    {
        TextView lView = (TextView) findViewById(R.id.quantity_text_view);
        lView.setText(String.valueOf(miQuantity));
    }

    public void displayPrice(int number)
    {
        TextView lView = (TextView) findViewById(R.id.price_text_view);
        String lMessage = "Total: "+"$"+String.valueOf(miQuantity*5)+"\nThank you!";
        lView.setText(lMessage);
    }
}

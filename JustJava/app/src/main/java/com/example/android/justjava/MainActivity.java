package com.example.android.justjava;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
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
        Intent lIntent = new Intent(Intent.ACTION_SENDTO);
        lIntent.setData(Uri.parse("mailto:"));
        lIntent.putExtra(Intent.EXTRA_SUBJECT, "Just Java order");
        lIntent.putExtra(Intent.EXTRA_TEXT, getOrderSummary());
        if(lIntent.resolveActivity(getPackageManager()) != null)
        {
            startActivity(lIntent);
        }
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

    public int calculatePrice()
    {
        int lPrice = miQuantity * 5;

        if(((CheckBox)findViewById(R.id.whipped_cream)).isChecked())
            lPrice += 1;

        if(((CheckBox)findViewById(R.id.chocolate)).isChecked())
            lPrice += 2;

        return lPrice;
    }

    public String getOrderSummary()
    {
        String lMessage = "Name: "+ ((EditText)findViewById(R.id.name)).getText();
        lMessage += "\nAdd whipped cream? " + ((CheckBox)findViewById(R.id.whipped_cream)).isChecked();
        lMessage += "\nAdd chocolate? " + ((CheckBox)findViewById(R.id.chocolate)).isChecked();
        lMessage += "\nQuantity: "+miQuantity;
        lMessage += "\nTotal: "+"$"+calculatePrice();
        lMessage += "\nThank you!";

        return lMessage;
    }
}

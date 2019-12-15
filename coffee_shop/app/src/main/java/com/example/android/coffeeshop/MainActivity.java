package com.example.android.coffeeshop;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

import java.text.NumberFormat;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private int quantity;
    float price;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        quantity = 0;
        price = 3;
    }

    public void submitOrder(View view) {
        displayOrderMessage();
        swithcCoffeeCup();
//        getMap();
//        composeEmail(new String[]{"totoridi1@gmail.com"},"test subject");
    }

    public void getMap(){
        Intent mapIntent = new Intent(Intent.ACTION_VIEW);
        mapIntent.setData(Uri.parse("geo:37.7749,-122.4194"));
        if(mapIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(mapIntent);
        }
    }

    public void composeEmail(String[] addresses, String subject) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_EMAIL, addresses);
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    private void swithcCoffeeCup() {
        ImageView coffeImage = findViewById(R.id.coffe_cup);
        coffeImage.setImageResource(R.drawable.full_coffee_cup);
    }

    private void updateToppingList() {
        StringBuilder toppingList = new StringBuilder(getString(R.string.topping_list));
        TextView toppingListTextView = findViewById(R.id.toppings_list);
        CheckBox whippedCream = findViewById(R.id.whipped_cream);
        CheckBox chocolate = findViewById(R.id.chocolate);
        if(whippedCream.isChecked()) {
            toppingList.append("\n" + getString(R.string.cream_topping));
        }
        if(chocolate.isChecked()) {
            toppingList.append("\n" + getString(R.string.chocolate_topping));
        }
        toppingListTextView.setText(toppingList);
    }

    public void updatePriceBasedOnWhippedCream(View view) {
        CheckBox whippedCream = findViewById(R.id.whipped_cream);
        if(whippedCream.isChecked()) {
            price += 0.5;
        } else {
            price -= 0.5;
        }
        display(quantity);
        updateToppingList();
    }

    public void updatePriceBasedOnChocolate(View view) {
        CheckBox chocolate = findViewById(R.id.chocolate);
        if(chocolate.isChecked()) {
            price += 0.5;
        } else {
            price -= 0.5;
        }
        display(quantity);
        updateToppingList();
    }

    public void increaseQuantity(View view) {
        quantity++;
        display(quantity);
    }

    public void decreaseQuantity(View view) {
        if(quantity > 0) {
            quantity--;
            display(quantity);
        }
    }

    public void displayOrderMessage() {
        TextView orderMessageTextView = findViewById(R.id.order_message);
        TextInputEditText nameInputField = findViewById(R.id.nameInputField);
        String customerName = nameInputField.getText().toString();
        String message = getString(R.string.order_thanks_message, customerName);
        System.out.println(message);
        orderMessageTextView.setText(message);
    }

    private void display(int number) {
        TextView quantityTextView = findViewById(R.id.quantity_text_view);
        TextView totalPriceTextView = findViewById(R.id.total_price_view);
        quantityTextView.setText("" + number);
        totalPriceTextView.setText(NumberFormat.getCurrencyInstance(Locale.US).format(number * price));
    }
}

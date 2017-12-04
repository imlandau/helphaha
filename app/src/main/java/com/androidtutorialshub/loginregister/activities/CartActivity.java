package com.androidtutorialshub.loginregister.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.androidtutorialshub.loginregister.R;

import java.text.DecimalFormat;

/**
 *
 */
public class CartActivity extends AppCompatActivity {


    //Total of all items before tax
    double subtotal = 0;
    //The amount of tax being charged on all items combined
    double tax = 0;
    //Subtotal plus tax
    double total = 0;

    //Decimal format to display money
    DecimalFormat money = new DecimalFormat("0.00");
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        //Button that takes user to the menu
        Button menuBtn = (Button) findViewById(R.id.menuBtn);
        //Button that completes the purchase of the order
        Button homeBtn = (Button) findViewById(R.id.purchaseBtn);
        //Button to remove everything from the cart
        Button removeBtn = (Button) findViewById(R.id.removeAll);

        //Displays the items in the cart
        final TextView textItem = (TextView) findViewById(R.id.textItem);
        //Shows the prices of each item in the cart
        final TextView textPrice = (TextView) findViewById(R.id.textPrice);
        //Shows the quantity of each item in the cart
        final TextView textQuantity = (TextView) findViewById(R.id.textQuantity);
        //Shows the total of the order before tax
        final TextView subtotalTextView = (TextView) findViewById(R.id.subtotalTextView);
        //Shows the tax of the order
        final TextView taxTextView = (TextView) findViewById(R.id.taxTextView);
        //Shows the total cost of the order
        final TextView totalTextView = (TextView) findViewById(R.id.totalTextView);
        //Tells the user the order has been placed
        final TextView bghtTextView = (TextView) findViewById(R.id.bght);

        // Header for the textItem box
        String strName = "Item\n";
        //Header for the textPrice box
        String strPrice = "Price\n";
        //Header for the textQuantity box
        String strQuantity = "Quantity\n";


         /** Creates the string to display all the information about the items in the cart, and
         updates the subtotal based on the quantity of each item. If the quantity of an item
         is zero, it is not added to the string or subtotal. The item name, price, and quantity
         are concatenated on to the strName, strPrice, and strQuantity strings respectively, so
         that they can be displayed properly.
          **/
        int i = 0;
        while(i < 9){
            if(Cart.createdDish[i].getQuantity() > 0){
                strName = strName + "Create Your Own:\n" + Cart.createdDish[i].getName() + "\n";
                strPrice = strPrice + "\n" + String.valueOf(Cart.createdDish[i].getPrice()) + "\n";
                strQuantity = strQuantity + "\n" + String.valueOf(Cart.createdDish[i].getQuantity() + "\n");
                subtotal = subtotal + (Cart.createdDish[i].getPrice() *
                        Cart.createdDish[i].getQuantity());
            }
            i++;
        }
        if(Cart.dish1.getQuantity() > 0) {
            strName = strName + Cart.dish1.getName() + "\n";
            strPrice = strPrice  + String.valueOf(money.format(Cart.dish1.getPrice())) + "\n";
            strQuantity = strQuantity +  String.valueOf(Cart.dish1.getQuantity()) + "\n";
            subtotal = subtotal + (Cart.dish1.getQuantity() * Cart.dish1.getPrice());
        }
        if(Cart.dish2.getQuantity() > 0) {
            strName = strName + Cart.dish2.getName() + "\n";
            strPrice = strPrice +  String.valueOf(money.format(Cart.dish2.getPrice())) + "\n";
            strQuantity = strQuantity +  String.valueOf(Cart.dish2.getQuantity()) + "\n";
            subtotal = subtotal + (Cart.dish2.getQuantity() * Cart.dish2.getPrice());
        }
        if(Cart.dish3.getQuantity() > 0) {
            strName = strName + Cart.dish3.getName() + "\n";
            strPrice = strPrice + "\n" + String.valueOf(money.format(Cart.dish3.getPrice())) + "\n";
            strQuantity = strQuantity + "\n" +  String.valueOf(Cart.dish3.getQuantity()) + "\n";
            subtotal = subtotal + (Cart.dish3.getQuantity() * Cart.dish3.getPrice());
        }
        if(Cart.dish4.getQuantity() > 0) {
            strName = strName + Cart.dish4.getName() + "\n";
            strPrice = strPrice  +  String.valueOf(money.format(Cart.dish4.getPrice())) + "\n";
            strQuantity = strQuantity  + String.valueOf(Cart.dish4.getQuantity()) + "\n";
            subtotal = subtotal + (Cart.dish4.getQuantity() * Cart.dish4.getPrice());
        }
        if(Cart.drink.getQuantity() > 0) {
            strName = strName + Cart.drink.getName() + "\n";
            strPrice = strPrice + String.valueOf(money.format(Cart.drink.getPrice())) + "\n";
            strQuantity = strQuantity  + String.valueOf(Cart.drink.getQuantity()) + "\n";
            subtotal = subtotal + (Cart.drink.getQuantity() * Cart.drink.getPrice());
        }

        //Calculate the tax for the order
        tax = subtotal * .06;
        //Calculate the actual total for the order
        total = subtotal + tax;

        //Set all of the text boxes to display their corresponding strings
        textItem.setText(strName);
        textPrice.setText(strPrice);
        textQuantity.setText(strQuantity);
        subtotalTextView.setText("Subtotal:\n$" + money.format(subtotal));
        taxTextView.setText("Tax:\n$" + money.format(tax));
        totalTextView.setText("Total:\n$" + money.format(total));

        //Returns the user to the menu page
        menuBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                startActivity(new Intent(CartActivity.this, MainActivity.class));
            }
        });

        //Returns the user to the home page


        //This button removes all items in the cart
        removeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Cart.createdDish[0].getQuantity() > 0){
                    clear();
                }else if(Cart.createdDish[1].getQuantity() > 0) {
                    Toast.makeText(getApplicationContext(), "Your cart is empty",
                            Toast.LENGTH_SHORT).show();
                    clear();
                }else if(Cart.createdDish[2].getQuantity() > 0) {
                    Toast.makeText(getApplicationContext(), "Your cart is empty",
                            Toast.LENGTH_SHORT).show();
                    clear();
                }else if(Cart.createdDish[3].getQuantity() > 0) {
                    Toast.makeText(getApplicationContext(), "Your cart is empty",
                            Toast.LENGTH_SHORT).show();
                    clear();
                }else if(Cart.createdDish[4].getQuantity() > 0) {
                    Toast.makeText(getApplicationContext(), "Your cart is empty",
                            Toast.LENGTH_SHORT).show();
                    clear();
                }else if(Cart.createdDish[5].getQuantity() > 0) {
                    Toast.makeText(getApplicationContext(), "Your cart is empty",
                            Toast.LENGTH_SHORT).show();
                    clear();
                }else if(Cart.createdDish[6].getQuantity() > 0) {
                    Toast.makeText(getApplicationContext(), "Your cart is empty",
                            Toast.LENGTH_SHORT).show();
                    clear();
                }else if(Cart.createdDish[7].getQuantity() > 0) {
                    Toast.makeText(getApplicationContext(), "Your cart is empty",
                            Toast.LENGTH_SHORT).show();
                    clear();
                }else if(Cart.createdDish[8].getQuantity() > 0) {
                    Toast.makeText(getApplicationContext(), "Your cart is empty",
                            Toast.LENGTH_SHORT).show();
                    clear();
                }else if(Cart.dish1.getQuantity() > 0) {
                    Toast.makeText(getApplicationContext(), "Your cart is empty",
                            Toast.LENGTH_SHORT).show();
                    clear();
                }else if(Cart.dish2.getQuantity() > 0) {
                    Toast.makeText(getApplicationContext(), "Your cart is empty",
                            Toast.LENGTH_SHORT).show();
                    clear();
                }else if(Cart.dish3.getQuantity() > 0) {
                    Toast.makeText(getApplicationContext(), "Your cart is empty",
                            Toast.LENGTH_SHORT).show();
                    clear();
                }else if(Cart.dish4.getQuantity() > 0) {
                    Toast.makeText(getApplicationContext(), "Your cart is empty",
                            Toast.LENGTH_SHORT).show();
                    clear();
                }else if(Cart.drink.getQuantity() > 0) {
                    Toast.makeText(getApplicationContext(), "Your cart is empty",
                            Toast.LENGTH_SHORT).show();
                    clear();
                }else{
                    Toast.makeText(getApplicationContext(), "Your cart is already " +
                            "empty.", Toast.LENGTH_SHORT).show();
                    }
                }

        });
    } // end onCreate

    public void clear(){
        final TextView textItem = (TextView) findViewById(R.id.textItem);
        final TextView textPrice = (TextView) findViewById(R.id.textPrice);
        final TextView textQuantity = (TextView) findViewById(R.id.textQuantity);
        final TextView subtotalTextView = (TextView) findViewById(R.id.subtotalTextView);
        final TextView taxTextView = (TextView) findViewById(R.id.taxTextView);
        final TextView totalTextView = (TextView) findViewById(R.id.totalTextView);

        Cart.removeAll();
        subtotal = 0;
        tax = 0;
        total = 0;
        textItem.setText("Item");
        textPrice.setText("Price");
        textQuantity.setText("Quantity");
        subtotalTextView.setText("Subtotal:\n$" + money.format(subtotal));
        taxTextView.setText("Tax:\n$" + money.format(tax));
        totalTextView.setText("Total:\n$" + money.format(total));
    }
} // end class

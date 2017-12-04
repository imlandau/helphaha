package com.androidtutorialshub.loginregister.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import static com.androidtutorialshub.Cart.identifier;
import com.androidtutorialshub.loginregister.R;


public class MainActivity extends AppCompatActivity {
    static int dif;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Create reference to all of the buttons  and TextViewon the menu
        final ImageButton createYourOwnImgBtn = (ImageButton) findViewById(R.id.drinkImgBtn);
        final ImageButton dish1ImgBtn = (ImageButton) findViewById(R.id.dish1ImgBtn);
        final ImageButton dish2ImgBtn = (ImageButton) findViewById(R.id.dish2ImgBtn);
        final ImageButton dish3ImgBtn = (ImageButton) findViewById(R.id.dish3ImgBtn);
        final ImageButton dish4ImgBtn= (ImageButton) findViewById(R.id.dish4ImgBtn);
        final ImageButton drinkImgBtn = (ImageButton) findViewById(R.id.dish5ImgBtn);
        final Spinner item1 = (Spinner) findViewById(R.id.item1);
        final Spinner item2 = (Spinner) findViewById(R.id.item2);
        final TextView text1 = (TextView) findViewById(R.id.text1);
        final TextView text2 = (TextView) findViewById(R.id.text2);
        final TextView text3 = (TextView) findViewById(R.id.text3);
        final TextView text4 = (TextView) findViewById(R.id.text4);
        final TextView text5 = (TextView) findViewById(R.id.text5);
        final TextView text6 = (TextView) findViewById(R.id.text6);
        final TextView oops = (TextView) findViewById(R.id.oops);
        final TextView title = (TextView) findViewById(R.id.title);
        final TextView description = (TextView) findViewById(R.id.description);
        final TextView extra = (TextView) findViewById(R.id.extra);
        final Button quantityDown = (Button) findViewById(R.id.quandown);
        final Button quantityUp = (Button) findViewById(R.id.quanup);
        final Button submit = (Button) findViewById(R.id.submit);
        final Button byosubmit =(Button) findViewById(R.id.byosubmit);
        final TextView background = (TextView) findViewById(R.id.background);
        final TextView curQuan = (TextView) findViewById(R.id.curQuan);
        //Declaration button that takes the user to the cart
        final Button cartBtn = (Button) findViewById(R.id.cartBtn);
        //Declaration for button that takes the user to the home screen
        Button homeBtn = (Button) findViewById(R.id.purchaseBtn);

        //Declaration for the cartHolder which will redundancy within
        final int[] cartHolder = new int[7];
        cartHolder[1] = Cart.nonDish.getQuantity();
        cartHolder[2] = Cart.dish1.getQuantity();
        cartHolder[3] = Cart.dish2.getQuantity();
        cartHolder[4] = Cart.dish3.getQuantity();
        cartHolder[5] = Cart.dish4.getQuantity();
        cartHolder[6] = Cart.drink.getQuantity();

        final String[] itemHolder = new String[7];
        itemHolder[1] = "Create Your Own";
        itemHolder[2] = Cart.dish1.getName();
        itemHolder[3] = Cart.dish2.getName();
        itemHolder[4] = Cart.dish3.getName();
        itemHolder[5] = Cart.dish4.getName();
        itemHolder[6] = Cart.drink.getName();


        createYourOwnImgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                identifier = 1;
                dif = 1;
                createYourOwnImgBtn.setVisibility(View.INVISIBLE);
                curQuan.setText(String.valueOf(dif));
                title.setText(String.valueOf(itemHolder[1]));
                description.setText(getResources().getStringArray(R.array.Descriptions)[0]);
                showPopupMenu();
                item1.setVisibility(View.VISIBLE);
                item2.setVisibility(View.VISIBLE);
                byosubmit.setVisibility(View.VISIBLE);
                ArrayAdapter<String> myAdapter = new ArrayAdapter<>(MainActivity.this,
                        android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.Meat));
                myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                item1.setAdapter(myAdapter);

                ArrayAdapter<String> myAdapter2 = new ArrayAdapter<>(MainActivity.this,
                        android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.Veggie));
                myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                item2.setAdapter(myAdapter2);
            }
        });

        //Create an OnClickListener for dish5ImgBtn that will identify which item will be receiving
        //a quantity change through the popup menu that will be made visible as well.
        dish1ImgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                identifier = 2;
                dif = 0;
                if(cartHolder[2] == 0){
                    cartHolder[2] = 1;
                    dif = 1;
                }
                curQuan.setText(String.valueOf(cartHolder[2]));
                title.setText(String.valueOf(itemHolder[2]));
                description.setText(getResources().getStringArray(R.array.Descriptions)[1]);
                showPopupMenu();
                submit.setVisibility(View.VISIBLE);
            } // end onClick
        }); // end dish1ImgBtn onClickListener

        //Create an OnClickListener for dish5ImgBtn that will identify which item will be receiving
        //a quantity change through the popup menu that will be made visible as well.
        dish2ImgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                identifier = 3;
                dif = 0;
                if(cartHolder[3] == 0){
                    cartHolder[3] = 1;
                    dif = 1;
                }
                curQuan.setText(String.valueOf(cartHolder[3]));
                title.setText(String.valueOf(itemHolder[3]));
                description.setText(getResources().getStringArray(R.array.Descriptions)[2]);
                showPopupMenu();
                submit.setVisibility(View.VISIBLE);
            } // end onClick
        });

        //Create an OnClickListener for dish5ImgBtn that will identify which item will be receiving
        //a quantity change through the popup menu that will be made visible as well.
        dish3ImgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                identifier = 4;
                dif = 0;
                if(cartHolder[4] == 0){
                    cartHolder[4] = 1;
                    dif = 1;
                }
                curQuan.setText(String.valueOf(cartHolder[4]));
                title.setText(String.valueOf(itemHolder[4]));
                description.setText(getResources().getStringArray(R.array.Descriptions)[3]);
                showPopupMenu();
                submit.setVisibility(View.VISIBLE);
            }
        });

        //Create an OnClickListener for dish5ImgBtn that will identify which item will be receiving
        //a quantity change through the popup menu that will be made visible as well.
        dish4ImgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                identifier = 5;
                dif = 0;
                if(cartHolder[5] == 0){
                    cartHolder[5] = 1;
                    dif = 1;
                }
                curQuan.setText(String.valueOf(cartHolder[5]));
                title.setText(String.valueOf(itemHolder[5]));
                description.setText(getResources().getStringArray(R.array.Descriptions)[4]);
                showPopupMenu();
                submit.setVisibility(View.VISIBLE);
            }
        });

        //Create an OnClickListener for dish5ImgBtn that will identify which item will be receiving
        //a quantity change through the popup menu that will be made visible as well.
        drinkImgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                identifier = 6;
                dif = 0;
                if(cartHolder[6] == 0){
                    cartHolder[6] = 1;
                    dif = 1;
                }
                curQuan.setText(String.valueOf(cartHolder[6]));
                title.setText(String.valueOf(itemHolder[6]));
                description.setText(getResources().getStringArray(R.array.Descriptions)[5]);
                showPopupMenu();
                submit.setVisibility(View.VISIBLE);
            }
        }); // end createYourOwnImgBtn OnClickListener

        //Create an OnClickListener for dish5ImgBtn that will identify which item will be receiving
        //a quantity change through the popup menu that will be made visible as well.


        //Create an OnClickListener for cartBtn that will move the user to the cart page of the app.
        cartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, CartActivity.class));
            }
        }); // end cartBtn OnClickListener

        //Create an OnClickListener for homeBtn that will move the user to the home page of the app.
        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, Home.class));
            }
        }); // end homeBtn OnClickListener

        //Create an OnClickListener for quantityDown that will
        //decrement the quantity of the item by 1 every click.
        quantityDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(cartHolder[identifier] > 0){
                    cartHolder[identifier]--;
                    dif--;
                }
                curQuan.setText(String.valueOf(cartHolder[identifier]));
                switch (identifier) {
                    case 2: Cart.dish1.setQuantity(cartHolder[identifier]);
                        break;
                    case 3: Cart.dish2.setQuantity(cartHolder[identifier]);
                        break;
                    case 4: Cart.dish3.setQuantity(cartHolder[identifier]);
                        break;
                    case 5: Cart.dish4.setQuantity(cartHolder[identifier]);
                        break;
                    case 6: Cart.drink.setQuantity(cartHolder[identifier]);
                }
            }
        }); //End quantityDown OnClickListener

        //Create an OnClickListener for quantityUp that will
        //increment the quantity of the item by 1 every click.
        quantityUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (identifier == 1){

                }else if(identifier > 1){
                    cartHolder[identifier]++;
                }
                dif++;
                curQuan.setText(String.valueOf(cartHolder[identifier]));
                switch (identifier) {
                    case 2: Cart.dish1.setQuantity(cartHolder[identifier]);
                        break;
                    case 3: Cart.dish2.setQuantity(cartHolder[identifier]);
                        break;
                    case 4: Cart.dish3.setQuantity(cartHolder[identifier]);
                        break;
                    case 5: Cart.dish4.setQuantity(cartHolder[identifier]);
                        break;
                    case 6: Cart.drink.setQuantity(cartHolder[identifier]);
                }
            }
        }); //End quantityUp OnClickListener

        //Create an OnClickListener for submit that will
        //make the popup menu for the quantity invisible.
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (identifier) {
                    case 2: Cart.dish1.setQuantity(cartHolder[identifier]);
                        break;
                    case 3: Cart.dish2.setQuantity(cartHolder[identifier]);
                        break;
                    case 4: Cart.dish3.setQuantity(cartHolder[identifier]);
                        break;
                    case 5: Cart.dish4.setQuantity(cartHolder[identifier]);
                        break;
                    case 6: Cart.drink.setQuantity(cartHolder[identifier]);
                }

                if (dif < 1) {
                    closePopupMenu();
                    Toast.makeText(getApplicationContext(), "Your item(s) has been removed", Toast.LENGTH_SHORT).show();
                }else if (dif == 0){
                    closePopupMenu();
                    Toast.makeText(getApplicationContext(), "No changes have been made", Toast.LENGTH_SHORT).show();
                } else {
                    closePopupMenu();
                    Toast.makeText(getApplicationContext(), "Your item(s) has been added to the cart", Toast.LENGTH_SHORT).show();
                }

            }
            }
        ); //End submit OnClickListener

        //for the build your own
        byosubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(item1.getSelectedItem().toString() == "Select Meat" ||
                        item2.getSelectedItem().toString() == "Select Veggie"){
                }else{
                    String selectedDish = "-" + item1.getSelectedItem().toString() + " -" +
                            item2.getSelectedItem().toString();

                    if(selectedDish.equals("-Beef 50c Extra -Broccoli")){
                        createdDish[0].setQuantity(createdDish[0].getQuantity() + dif);
                    }else if(selectedDish.equals("-Beef 50c Extra -Carrots")){
                        createdDish[1].setQuantity(createdDish[1].getQuantity() + dif);
                    }else if(selectedDish.equals("-Beef 50c Extra -Spinach")){
                        createdDish[2].setQuantity(createdDish[2].getQuantity() + dif);
                    }else if(selectedDish.equals("-Chicken -Broccoli")){
                        createdDish[3].setQuantity(createdDish[3].getQuantity() + dif);
                    }else if(selectedDish.equals("-Chicken -Carrots")){
                        createdDish[4].setQuantity(createdDish[4].getQuantity() + dif);
                    }else if(selectedDish.equals("-Chicken -Spinach")){
                        createdDish[5].setQuantity(createdDish[5].getQuantity() + dif);
                    }else if(selectedDish.equals("-Pork -Broccoli")){
                        createdDish[6].setQuantity(createdDish[6].getQuantity() + dif);
                    }else if(selectedDish.equals("-Pork -Carrots")){
                        createdDish[7].setQuantity(createdDish[7].getQuantity() + dif);
                    }else if(selectedDish.equals("-Pork -Spinach")){
                        createdDish[8].setQuantity(createdDish[8].getQuantity() + dif);
                    }
                    else if(selectedDish.equals("-Select Meat -Select Veggie")) {
                        Toast.makeText(getApplicationContext(), "Nothing was added", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    else if(selectedDish.equals("-Select Meat -Broccoli")) {
                        Toast.makeText(getApplicationContext(), "Nothing was added", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    else if(selectedDish.equals("-Select Meat -Carrots")){
                        Toast.makeText(getApplicationContext(), "Nothing was added", Toast.LENGTH_SHORT).show();
                            return;
                    }
                    else if(selectedDish.equals("-Select Meat -Spinach")) {
                        Toast.makeText(getApplicationContext(), "Nothing was added", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    else if(selectedDish.equals("-Beef 50c Extra -Select Veggie")){
                        Toast.makeText(getApplicationContext(), "Nothing was added", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    else if(selectedDish.equals("-Chicken -Select Veggie")){
                        Toast.makeText(getApplicationContext(), "Nothing was added", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    else if(selectedDish.equals("-Pork -Select Veggie")){
                        Toast.makeText(getApplicationContext(), "Nothing was added", Toast.LENGTH_SHORT).show();
                        return;
                    }


                    if (dif < 1) {
                        closePopupMenu();
                        Toast.makeText(getApplicationContext(), "Your item(s) has been removed", Toast.LENGTH_SHORT).show();
                    }else if (dif == 0){
                        closePopupMenu();
                        Toast.makeText(getApplicationContext(), "No changes have been made", Toast.LENGTH_SHORT).show();
                    } else {
                        closePopupMenu();
                        Toast.makeText(getApplicationContext(), "Your item(s) has been added to the cart", Toast.LENGTH_SHORT).show();

                    }
                }
            }
        }); //End build your own submit OnClickListener

        oops.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                closePopupMenu();
                Toast.makeText(getApplicationContext(), "Your cart was not modified",
                        Toast.LENGTH_SHORT).show();
            }
        });
//
    } // end onCreate

    public void showPopupMenu() {
        final ImageButton createYourOwnImgBtn = (ImageButton) findViewById(R.id.drinkImgBtn);
        final ImageButton dish1ImgBtn = (ImageButton) findViewById(R.id.dish1ImgBtn);
        final ImageButton dish2ImgBtn = (ImageButton) findViewById(R.id.dish2ImgBtn);
        final ImageButton dish3ImgBtn = (ImageButton) findViewById(R.id.dish3ImgBtn);
        final ImageButton dish4ImgBtn = (ImageButton) findViewById(R.id.dish4ImgBtn);
        final ImageButton drinkImgBtn = (ImageButton) findViewById(R.id.dish5ImgBtn);
        final TextView text1 = (TextView) findViewById(R.id.text1);
        final TextView text2 = (TextView) findViewById(R.id.text2);
        final TextView text3 = (TextView) findViewById(R.id.text3);
        final TextView text4 = (TextView) findViewById(R.id.text4);
        final TextView text5 = (TextView) findViewById(R.id.text5);
        final TextView text6 = (TextView) findViewById(R.id.text6);
        final TextView oops = (TextView) findViewById(R.id.oops);
        final TextView title = (TextView) findViewById(R.id.title);
        final TextView description = (TextView) findViewById(R.id.description);
        final TextView extra = (TextView) findViewById(R.id.extra);
        final Button quantityDown = (Button) findViewById(R.id.quandown);
        final Button quantityUp = (Button) findViewById(R.id.quanup);
        final TextView background = (TextView) findViewById(R.id.background);
        final TextView curQuan = (TextView) findViewById(R.id.curQuan);

        createYourOwnImgBtn.setVisibility(View.INVISIBLE);
        dish1ImgBtn.setVisibility(View.INVISIBLE);
        dish2ImgBtn.setVisibility(View.INVISIBLE);
        dish3ImgBtn.setVisibility(View.INVISIBLE);
        dish4ImgBtn.setVisibility(View.INVISIBLE);
        drinkImgBtn.setVisibility(View.INVISIBLE);
        text1.setVisibility(View.INVISIBLE);
        text2.setVisibility(View.INVISIBLE);
        text3.setVisibility(View.INVISIBLE);
        text4.setVisibility(View.INVISIBLE);
        text5.setVisibility(View.INVISIBLE);
        text6.setVisibility(View.INVISIBLE);
        oops.setVisibility(View.VISIBLE);
        title.setVisibility(View.VISIBLE);
        description.setVisibility(View.VISIBLE);
        extra.setVisibility(View.VISIBLE);
        quantityDown.setVisibility(View.VISIBLE);
        quantityUp.setVisibility(View.VISIBLE);
        background.setVisibility(View.VISIBLE);
        curQuan.setVisibility(View.VISIBLE);
    }

    public void closePopupMenu(){
        final ImageButton createYourOwnImgBtn = (ImageButton) findViewById(R.id.drinkImgBtn);
        final ImageButton dish1ImgBtn = (ImageButton) findViewById(R.id.dish1ImgBtn);
        final ImageButton dish2ImgBtn = (ImageButton) findViewById(R.id.dish2ImgBtn);
        final ImageButton dish3ImgBtn = (ImageButton) findViewById(R.id.dish3ImgBtn);
        final ImageButton dish4ImgBtn= (ImageButton) findViewById(R.id.dish4ImgBtn);
        final ImageButton drinkImgBtn = (ImageButton) findViewById(R.id.dish5ImgBtn);
        final Spinner item1 = (Spinner) findViewById(R.id.item1);
        final Spinner item2 = (Spinner) findViewById(R.id.item2);
        final TextView text1 = (TextView) findViewById(R.id.text1);
        final TextView text2 = (TextView) findViewById(R.id.text2);
        final TextView text3 = (TextView) findViewById(R.id.text3);
        final TextView text4 = (TextView) findViewById(R.id.text4);
        final TextView text5 = (TextView) findViewById(R.id.text5);
        final TextView text6 = (TextView) findViewById(R.id.text6);
        final TextView oops = (TextView) findViewById(R.id.oops);
        final TextView title = (TextView) findViewById(R.id.title);
        final TextView description = (TextView) findViewById(R.id.description);
        final TextView extra = (TextView) findViewById(R.id.extra);
        final Button quantityDown = (Button) findViewById(R.id.quandown);
        final Button quantityUp = (Button) findViewById(R.id.quanup);
        final Button submit = (Button) findViewById(R.id.submit);
        final Button byosubmit =(Button) findViewById(R.id.byosubmit);
        final TextView background = (TextView) findViewById(R.id.background);
        final TextView curQuan = (TextView) findViewById(R.id.curQuan);

        createYourOwnImgBtn.setVisibility(View.VISIBLE);
        dish1ImgBtn.setVisibility(View.VISIBLE);
        dish2ImgBtn.setVisibility(View.VISIBLE);
        dish3ImgBtn.setVisibility(View.VISIBLE);
        dish4ImgBtn.setVisibility(View.VISIBLE);
        drinkImgBtn.setVisibility(View.VISIBLE);
        item1.setVisibility(View.INVISIBLE);
        item2.setVisibility(View.INVISIBLE);
        text1.setVisibility(View.VISIBLE);
        text2.setVisibility(View.VISIBLE);
        text3.setVisibility(View.VISIBLE);
        text4.setVisibility(View.VISIBLE);
        text5.setVisibility(View.VISIBLE);
        text6.setVisibility(View.VISIBLE);
        oops.setVisibility(View.INVISIBLE);
        title.setVisibility(View.INVISIBLE);
        description.setVisibility(View.INVISIBLE);
        extra.setVisibility(View.INVISIBLE);
        quantityDown.setVisibility(View.INVISIBLE);
        quantityUp.setVisibility(View.INVISIBLE);
        submit.setVisibility(View.INVISIBLE);
        byosubmit.setVisibility(View.INVISIBLE);
        background.setVisibility(View.INVISIBLE);
        curQuan.setVisibility(View.INVISIBLE);
    }
} // end class

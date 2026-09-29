package com.example.dolartldendeksi;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;
import android.widget.ImageView;import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.InputMismatchException;
@SuppressLint("MissingInflatedId")
class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        EditText ceviriTlDolar=findViewById(R.id.editText1);
        Button btnCeviri=findViewById(R.id.button1);
          Spinner  spinnerCeviri=findViewById(R.id.spinnerCeviri);
        TextView gosterim=findViewById(R.id.textView);
       ImageView resim=findViewById(R.id.imageView3);
     Button btnTemizle=findViewById(R.id.button12);

        String[] cevirimislemi={"Dolar->TL","TL->Dolar","TL->Euro","Euro->TL"};

        ArrayAdapter<String> adapter=new ArrayAdapter<>(
          this,
                android.R.layout.simple_list_item_1,
              cevirimislemi



        );
        spinnerCeviri.setAdapter(adapter);


       btnCeviri.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

               String cevirme=ceviriTlDolar.getText().toString().trim();

               if(!cevirme.isEmpty()){


                   double tl=0;
                   int secim=spinnerCeviri.getSelectedItemPosition();

                   try {
                     tl=Double.parseDouble((cevirme));
                   }
                   catch (NumberFormatException e){
                       gosterim.setText("Sayı Giriniz asla ama a,b,c,d gibi rakamlar girmeyiniz!!!");
                   }


                   if(secim==0){

                       gosterim.setText("Dolar seçtiniz");

                       double dolar=tl*48.98;

                       gosterim.setText("güncel Kur:"+dolar);

                      resim.setImageResource(R.drawable.dolar);


                   } else if (secim==1) {
                       gosterim.setText("Tl seçtiniz");
                       double dolarim=tl/48.98;
                       gosterim.setText("TL'nin dolar Karşılığı:"+dolarim);
                       resim.setImageResource(R.drawable.tl);

                   }
                   else if(secim==2){
                       gosterim.setText("Euro seçtiniz");
                       double euro=tl*55.64;
                       gosterim.setText("Euro kuru:"+euro);
                       resim.setImageResource(R.drawable.euro);
                   } else if (secim==3) {
                       gosterim.setText("Tl seçtiniz");
                       double eurom= tl/55.64;
                       gosterim.setText("TLnin Euro karşılığı:"+eurom);
                       resim.setImageResource(R.drawable.tl);

                   }


               }
               else{
                   gosterim.setText("Bir secim yapınız");
               }
            btnTemizle.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    gosterim.setText("");
                    ceviriTlDolar.setText("");

                    ceviriTlDolar.requestFocus();

                }
            });
           }

       });
        }
    }

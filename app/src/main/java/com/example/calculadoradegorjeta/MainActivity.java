package com.example.calculadoradegorjeta;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextView textGorjeta , textPorcentagem , textTotal;
    private SeekBar seekBarGorjeta;
    private TextInputEditText editValor;
    private double porcentagem = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textGorjeta            = findViewById(R.id.textGorjeta);
        textPorcentagem        = findViewById(R.id.textPorcentagem);
        textTotal              = findViewById(R.id.textTotal);
        seekBarGorjeta         = findViewById(R.id.seekBarGorjeta);
        editValor              = findViewById(R.id.editValor );

        
        //add um lisner para o seekbar
        seekBarGorjeta.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                porcentagem = i;
                textPorcentagem.setText( Math.round(porcentagem) + " % ");
                calcular();

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


    }
    public void calcular (){
        String valorRecuperado = editValor.getText().toString();
        if ( valorRecuperado == null || valorRecuperado.equals("") ){
            Toast.makeText( getApplicationContext() ,
                    " Digite um valor primeiro!" ,
                    Toast.LENGTH_LONG
                    ).show();
        }else{
                //converte double pra string
            double valorDigitado = Double.parseDouble( valorRecuperado );

             // calcular gorjeta total
            double gorjeta = valorDigitado * (porcentagem/100);
            double total = gorjeta + valorDigitado;

            //exibir a gorjeta e total
            textGorjeta.setText( "R$ " + Math.round(gorjeta) );
            textTotal.setText( "R$ " + Math.round (total) );

        }

    }

}

package com.example.calculadoradecerveja;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    private EditText ed1;
    private EditText ed2;
    private EditText ed3;
    private EditText ed4;
    private Button bt1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed1 = findViewById(R.id.edprecolitrao);
        ed2 = findViewById(R.id.edprecogarrafa);
        ed3 = findViewById(R.id.edprecolong);
        ed4 = findViewById(R.id.edprecolata);
        bt1 = findViewById(R.id.btcalc);

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //if (ed1.length() != 0 || ed2.length() != 0 || ed3.length() != 0 || ed4.length() != 0) {
                //    Toast.makeText(MainActivity.this, "O campo esta vazio", Toast.LENGTH_LONG).show();
                //}
                //while (ed1.getText().toString().trim().equals("") && ed2.getText().toString().trim().equals("")){
                //else {
                    double garrafa1valor = Integer.parseInt(ed1.getText().toString());
                    double garrafa2valor = Integer.parseInt(ed2.getText().toString());
                    double garrafa3valor = Integer.parseInt(ed3.getText().toString());
                    double garrafa4valor = Integer.parseInt(ed4.getText().toString());
                    int respostafinal = 0, garrafa600ml = 600, garrafa355ml = 355, garrafa350ml = 350, litro = 1000;
                    double resposta;
                    String txtfinal;

                    //Irá comparar o valor obtido entre a garrafa 1 e 2 e ver qual o menor
                    if (garrafa2valor != 0 && garrafa1valor != 0 && garrafa3valor != 0 && garrafa4valor != 0) {

                        resposta = (garrafa2valor * litro) / garrafa600ml;

                        if (resposta <= garrafa1valor) {
                            respostafinal = 2;
                        } else {
                            respostafinal = 1;
                        }
                        //Variavel para receber a resposta final da primeira regra de três
                        int aux2 = respostafinal;

                        //Irá comparar o valor obtido entre a garrafa 1 e 2 com a garrafa 3 e ver qual o menor
                        double resposta2 = (garrafa3valor * litro) / garrafa355ml;
                        if (resposta2 <= resposta) {
                            respostafinal = 3;
                        } else {
                            respostafinal = aux2;
                        }

                        //Variavel para receber a resposta final da segunda regra de três
                        int aux3 = respostafinal;

                        //Irá comparar o valor obtido entre a garrafa 1 e 2 com a garrafa 3 e ver qual o menor
                        double resposta3 = (garrafa4valor * litro) / garrafa350ml;
                        if (resposta3 <= resposta2) {
                            respostafinal = 4;
                        } else {
                            respostafinal = aux3;
                        }

                    } else {
                        Toast.makeText(MainActivity.this, "Algum valor esta zarado!", Toast.LENGTH_LONG).show();
                    }

                    switch (respostafinal) {
                        case 0:
                            txtfinal = "Infefinida";
                            break;
                        case 1:
                            txtfinal = "o Litrao";
                            break;
                        case 2:
                            txtfinal = "a Garrafa";
                            break;
                        case 3:
                            txtfinal = "a Long Neck";
                            break;
                        case 4:
                            txtfinal = "a Lata";
                            break;
                        default:
                            txtfinal = "No value found";
                    }

                    Toast.makeText(MainActivity.this, "A cerveja mais barata é: " + txtfinal, Toast.LENGTH_LONG).show();
                //}

            }
        });
    }
}

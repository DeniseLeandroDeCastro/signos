package mobile.ifrn.edu.signos;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
    private Spinner spinnerDia = null; //Obtendo o índice selecionado nos spinners
    private Spinner spinnerMes = null; //Obtendo o índice selecionado nos spinners

    //Método para validação das datas
    private void validarData() {
        int dia = spinnerDia.getSelectedItemPosition();
        int mes = spinnerMes.getSelectedItemPosition();

        dia++; //Índice dos spinners começam a contar em 0 e dias e meses em 1, por isso o incremento
        mes++; //Índice dos spinners começam a contar em 0 e dias e meses em 1, por isso o incremento

        if (dia > 29 && mes == 2) {
            spinnerDia.setSelection(28);
        } else if ((mes == 4 || mes == 6 || mes == 9 || mes == 11) && (dia > 30)) {
            spinnerDia.setSelection(29);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinnerDia = (Spinner) findViewById(R.id.spinnerDia);
        spinnerMes = (Spinner) findViewById(R.id.spinnerMes);

        ArrayAdapter<CharSequence> adapter_dia = ArrayAdapter.createFromResource(this, R.array.dias,
                android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> adapter_mes = ArrayAdapter.createFromResource(this, R.array.meses,
                android.R.layout.simple_spinner_item);

        //Definindo o tipo de spinner que será usado na aplicação, no caso dropdown
        adapter_dia.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter_mes.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //Setando o adapter passando o ArrayAdapter criado, tanto para os dias como para os meses
        spinnerDia.setAdapter(adapter_dia);
        spinnerMes.setAdapter(adapter_mes);

        spinnerDia.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                validarData();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        //Instanciando a variável Button que faz referência ao elemento na parte visual (XML)
        Button enviar = (Button) findViewById(R.id.buttonEnviar);
        //Método setOnClickListener seta a ação do botão quando for pressionado
        enviar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                int posicaoDia = spinnerDia.getSelectedItemPosition();
                int posicaoMes = spinnerMes.getSelectedItemPosition();

                posicaoDia++;
                posicaoMes++;

                InterpretadorSigno Interpretador = new InterpretadorSigno();

                Signo signoResultado = Interpretador.interpretar(posicaoDia, posicaoMes);

                Bundle args = new Bundle();
                args.putSerializable("resultado", signoResultado);

                Intent intent = new Intent(MainActivity.this, Resultado.class);
                intent.putExtra("signo", args);

                startActivity(intent);
            }
        });

    }
}

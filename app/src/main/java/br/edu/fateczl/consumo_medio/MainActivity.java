package br.edu.fateczl.consumo_medio;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText etConsumoMedio;

    private EditText etQuantLitros;

    private TextView tvRes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        etConsumoMedio = findViewById(R.id.etConsumoMedio);
        etConsumoMedio.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        etQuantLitros = findViewById(R.id.etQuantLitros);
        etQuantLitros.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        tvRes = findViewById(R.id.tvRes);
        tvRes.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        Button btnCalcular = findViewById(R.id.btnCalcular);

        btnCalcular.setOnClickListener(op -> calc());
    }

    private void calc() {
        float cmedio = Float.parseFloat(etConsumoMedio.getText().toString());
        float litros = Float.parseFloat(etQuantLitros.getText().toString());
        float autmet = 1000 * cmedio * litros;
        String res = getString(R.string.autonomia) + " " + autmet + "m!";
        tvRes.setText(res);
        etConsumoMedio.setText("");
        etQuantLitros.setText("");
    }
}
package com.example.app02;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Switch;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private ImageView imagen;
    private Switch mostrarLogo;

    private EditText alumno;
    private Button comprobar;
    private Spinner listadoAlumnos;
    private String alumnoAcomprobar;
    private CheckBox checkbox;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        imagen = (ImageView) findViewById(R.id.imageView);
        mostrarLogo = (Switch) findViewById(R.id.switch1);
        alumno = (EditText) findViewById(R.id.comprobarAlumno);
        comprobar = (Button) findViewById(R.id.comprobar);
        listadoAlumnos = (Spinner) findViewById(R.id.listaAlumnos);
        checkbox = (CheckBox) findViewById(R.id.checkBox);
        alumnoAcomprobar = "";

        String[] alumnos = {"Pedro","Luis","Maria","Paula"};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, alumnos);
        listadoAlumnos.setAdapter(adapter);

        // evento programado directamente.
        mostrarLogo.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (mostrarLogo.isChecked()) {
                            imagen.setVisibility(View.VISIBLE);
                        } else {
                            imagen.setVisibility(View.INVISIBLE);
                        }
                    }
                }

        );

        comprobar.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        alumnoAcomprobar = String.valueOf(alumno.getText());
                    }
                }
        );

        listadoAlumnos.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                        if (listadoAlumnos.getSelectedItem().toString().equals(alumnoAcomprobar)) {
                            checkbox.setChecked(true);
                        } else {
                            checkbox.setChecked(false);
                        }
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> adapterView) {
                        checkbox.setChecked(false);
                    }
                }
        );

    }
}
package com.luis.myappsqlite;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.luis.myappsqlite.basededatos.BebidaDAO;
import com.luis.myappsqlite.basededatos.BebidaVO;
public class MABuscarIdSQLite extends AppCompatActivity {
    private TextView textViewNombre, textViewCodigo, textViewSabor, textViewPresentacion, textViewTipo, textViewPrecio;
    private EditText editTextCodigo;
    private ImageButton imageButton;
    private BebidaDAO bdao = new BebidaDAO();
    private BebidaVO bvo = new BebidaVO();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mabuscar_id_sqlite);
        editTextCodigo = findViewById(R.id.edtIdBebidaBuscar);
        textViewCodigo = findViewById(R.id.txtCodigoB);
        textViewNombre = findViewById(R.id.txtNombreB);
        textViewPrecio = findViewById(R.id.txtPrecioB);
        textViewPresentacion = findViewById(R.id.txtPresentacionB);
        textViewSabor = findViewById(R.id.txtSaborB);
        textViewTipo = findViewById(R.id.txtTipoB);
        imageButton = findViewById(R.id.imgBBuscar);
        this.clickBuscar();
    }

    private void clickBuscar() {
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buscarIdBebida();
            }
        });
    }

    private void buscarIdBebida(){
        if(!editTextCodigo.getText().toString().isEmpty()){
            bvo.setCodigoBebida(Integer.parseInt(editTextCodigo.getText().toString()));
            //Se pueden realizar las dos validaciones porque el método buscarIdBebida retorna un Cursor
            if(bdao.buscarIdBebida(bvo, getApplicationContext())!= null){
                if(bdao.buscarIdBebida(bvo, getApplicationContext()).getCount() > 0){
                    textViewCodigo.setText(String.valueOf(bvo.getCodigoBebida()));
                    textViewNombre.setText(String.valueOf(bvo.getNombreBebida()));
                    textViewSabor.setText(String.valueOf(bvo.getSaborBebida()));
                    textViewPresentacion.setText(String.valueOf(bvo.getPresentacionBebida()));
                    textViewTipo.setText(String.valueOf(bvo.getTipoBebida()));
                    textViewPrecio.setText(String.valueOf(bvo.getPrecioBebida()));
                }else{
                    textViewPrecio.setText("");
                    textViewNombre.setText("");
                    textViewPresentacion.setText("");
                    textViewCodigo.setText("");
                    textViewTipo.setText("");
                    textViewSabor.setText("");
                    textViewPrecio.setText("");
                    Toast.makeText(MABuscarIdSQLite.this, "No se encontró bebidas con ese código", Toast.LENGTH_SHORT).show();
                }
            }else{
                Toast.makeText(MABuscarIdSQLite.this, "Error en la Búsqueda", Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(this, "Debe llenar todos los campos", Toast.LENGTH_SHORT).show();
        }
    }
}
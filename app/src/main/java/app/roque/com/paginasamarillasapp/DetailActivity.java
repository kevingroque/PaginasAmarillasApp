package app.roque.com.paginasamarillasapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    private TextView idText;
    private TextView rubroText;
    private TextView nombreText;
    private TextView direccionText;
    private TextView telefonoText;
    private TextView correoText;
    private TextView urlText;
    private TextView infoText;
    private ImageView logo;

    String nombre, rubro, direccion, telefono, correo, url, info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        showToolbar("Detalles",true);
        rubroText = (TextView) findViewById(R.id.rubroText);
        nombreText = (TextView) findViewById(R.id.nombreText);
        direccionText = (TextView) findViewById(R.id.direccionText);
        telefonoText = (TextView) findViewById(R.id.telefonoText);
        correoText = (TextView) findViewById(R.id.correoText);
        urlText = (TextView) findViewById(R.id.urlText);
        infoText = (TextView) findViewById(R.id.infoText);
        logo = (ImageView)findViewById(R.id.logo);


        if (this.getIntent().getExtras() != null) {

            if (this.getIntent().getExtras().get("rubro") != null) {
                String rubro = this.getIntent().getExtras().getString("rubro");
                rubroText.setText(rubro);
            }

            if (this.getIntent().getExtras().get("nombre") != null) {
                String nombre = this.getIntent().getExtras().getString("nombre");
                nombreText.setText(String.valueOf(nombre));
            }

            if (this.getIntent().getExtras().get("direccion") != null) {
                String direccion = this.getIntent().getExtras().getString("direccion");
                direccionText.setText(String.valueOf(direccion));
            }

            if (this.getIntent().getExtras().get("telefono") != null) {
                String telefono = this.getIntent().getExtras().getString("telefono");
                telefonoText.setText(String.valueOf(telefono));
            }

            if (this.getIntent().getExtras().get("correo") != null) {
                String correo = this.getIntent().getExtras().getString("correo");
                correoText.setText(String.valueOf(correo));
            }

            if (this.getIntent().getExtras().get("url") != null) {
                String url = this.getIntent().getExtras().getString("url");
                urlText.setText(String.valueOf(url));
            }

            if (this.getIntent().getExtras().get("info") != null) {
                String info = this.getIntent().getExtras().getString("info");
                infoText.setText(String.valueOf(info));

            }if (this.getIntent().getExtras().get("logo") != null) {
                Integer logos = this.getIntent().getExtras().getInt("logo");
                logo.setImageResource(logos);
            }

        }

    }

    public void callNumber(View view){
        telefono = telefonoText.getText().toString();
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:"+telefono));
        startActivity(intent);
    }

    public void gotoWeb(View view){
        url = urlText.getText().toString();
        startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse(url)));
    }

    public void share(View view){
        nombre = nombreText.getText().toString();
        rubro = rubroText.getText().toString();
        direccion = direccionText.getText().toString();
        telefono = telefonoText.getText().toString();
        correo = correoText.getText().toString();
        url = urlText.getText().toString();
        info = infoText.getText().toString();

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT,"Empresa: "+nombre+"\nRubro: "+rubro+"\nDirección: "+direccion+"\nTelefono: "+telefono+
                "\nCorreo: "+correo+"\nURL: "+url+"\nInfo: "+info);
        startActivity(Intent.createChooser(intent, "Share with"));
    }

    public void sendMessage(View view){
        nombre = nombreText.getText().toString();
        rubro = rubroText.getText().toString();
        direccion = direccionText.getText().toString();
        telefono = telefonoText.getText().toString();
        correo = correoText.getText().toString();
        url = urlText.getText().toString();
        info = infoText.getText().toString();

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_TEXT, "Empresa: "+nombre+"\nRubro: "+rubro+"\nDirección: "+direccion+"\nTelefono: "+telefono+
        "\nCorreo: "+correo+"\nURL: "+url+"\nInfo: "+info);
        intent.setType("text/plain");
        startActivity(intent);
    }

    public void showToolbar(String title, boolean upButton){
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(title);
        getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);
    }
}

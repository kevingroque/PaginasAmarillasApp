package app.roque.com.paginasamarillasapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;
import java.util.List;

import app.roque.com.paginasamarillasapp.adapter.EmpresaAdapter;
import app.roque.com.paginasamarillasapp.model.Empresa;
import app.roque.com.paginasamarillasapp.repository.EmpresaRepository;


public class MainActivity extends AppCompatActivity {

    EmpresaAdapter adapter;
    SearchView buscador;
    ListView lista;
    ArrayList<Empresa> listaEmpresa;
    String id, rubro, nombre, direccion,  telefono, correo, url, info;
    Integer logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lista = (ListView) findViewById(R.id.ContenlistView);
        buscador = (SearchView) findViewById(R.id.buscador);

        listaEmpresa = new ArrayList<Empresa>();

        Empresa emp1 = new Empresa("KFC","Restaurante",R.drawable.lg_kfc,
                "AV. AREQUIPA NRO. 1989 LIMA LIMA LINCE","505-0505 ", "kfc123@hotmail.com",
                "https://www.kfc.com.pe/Online",getResources().getString(R.string.detalle_kfc) ,"001");
        Empresa emp2 = new Empresa("Scotiabank","Banco",R.drawable.lg_scotiabank,
                "AV. AREQUIPA NRO. 1989 LIMA LIMA LINCE","505-0505 ", "kfc123@hotmail.com",
                "https://www.kfc.com.pe/Online",getResources().getString(R.string.detalle_kfc) ,"001");
        Empresa emp3 = new Empresa("Móvil Bus","Transporte",R.drawable.lg_movilbus,
                "AV. AREQUIPA NRO. 1989 LIMA LIMA LINCE","505-0505 ", "kfc123@hotmail.com",
                "https://www.kfc.com.pe/Online",getResources().getString(R.string.detalle_kfc) ,"001");
        Empresa emp4 = new Empresa("El Comercio","Transporte",R.drawable.lg_comercio,
                "AV. AREQUIPA NRO. 1989 LIMA LIMA LINCE","505-0505 ", "kfc123@hotmail.com",
                "https://www.kfc.com.pe/Online",getResources().getString(R.string.detalle_kfc) ,"001");
        Empresa emp5 = new Empresa("Entel","Telefonia",R.drawable.lg_entel,
                "AV. AREQUIPA NRO. 1989 LIMA LIMA LINCE","505-0505 ", "kfc123@hotmail.com",
                "https://www.kfc.com.pe/Online",getResources().getString(R.string.detalle_kfc) ,"001");
        Empresa emp6 = new Empresa("G4S","Seguridad",R.drawable.lg_g4s,
                "AV. AREQUIPA NRO. 1989 LIMA LIMA LINCE","505-0505 ", "kfc123@hotmail.com",
                "https://www.kfc.com.pe/Online",getResources().getString(R.string.detalle_kfc) ,"001");
        Empresa emp7 = new Empresa("Latam","Transporte/ Aerolineas",R.drawable.lg_latam,
                "AV. AREQUIPA NRO. 1989 LIMA LIMA LINCE","505-0505 ", "kfc123@hotmail.com",
                "https://www.kfc.com.pe/Online",getResources().getString(R.string.detalle_kfc) ,"001");
        Empresa emp8 = new Empresa("Texas Steak","Restaurante",R.drawable.lg_texas,
                "AV. AREQUIPA NRO. 1989 LIMA LIMA LINCE","505-0505 ", "kfc123@hotmail.com",
                "https://www.kfc.com.pe/Online",getResources().getString(R.string.detalle_kfc) ,"001");
        Empresa emp9 = new Empresa("Oftalmica","Oftalmica",R.drawable.lg_oftalmica,
                "AV. AREQUIPA NRO. 1989 LIMA LIMA LINCE","505-0505 ", "kfc123@hotmail.com",
                "https://www.kfc.com.pe/Online",getResources().getString(R.string.detalle_kfc) ,"001");
        Empresa emp10 = new Empresa("Luz del sur","Transporte",R.drawable.lg_luzdelsur,
                "AV. AREQUIPA NRO. 1989 LIMA LIMA LINCE","505-0505 ", "kfc123@hotmail.com",
                "https://www.kfc.com.pe/Online",getResources().getString(R.string.detalle_kfc) ,"001");

        listaEmpresa.add(emp1);
        listaEmpresa.add(emp2);
        listaEmpresa.add(emp3);
        listaEmpresa.add(emp4);
        listaEmpresa.add(emp5);
        listaEmpresa.add(emp6);
        listaEmpresa.add(emp7);
        listaEmpresa.add(emp8);
        listaEmpresa.add(emp9);
        listaEmpresa.add(emp10);

        final EmpresaRepository empresaRepository = EmpresaRepository.getInstance();
        empresaRepository.agregarEmpresa(emp1);
        empresaRepository.agregarEmpresa(emp2);
        empresaRepository.agregarEmpresa(emp3);
        empresaRepository.agregarEmpresa(emp4);
        empresaRepository.agregarEmpresa(emp5);
        empresaRepository.agregarEmpresa(emp6);
        empresaRepository.agregarEmpresa(emp7);
        empresaRepository.agregarEmpresa(emp8);
        empresaRepository.agregarEmpresa(emp9);
        empresaRepository.agregarEmpresa(emp10);



        adapter = new EmpresaAdapter(this, listaEmpresa);
        lista.setAdapter(adapter);

        final List<Empresa> empresas = empresaRepository.getEmpresas();
        for( Empresa empresa : empresas){
            rubro     = empresa.getRubro().toString();
            nombre    = empresa.getNombre().toString();
            direccion = empresa.getDireccion().toString();
            telefono  = empresa.getTelefono().toString();
            correo    = empresa.getCorreo().toString();
            url       = empresa.getUrl().toString();
            info      = empresa.getInfo().toString();
            logo      = empresa.getLogo();
            id        = empresa.getId().toString();
        }

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position,long id) {

                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                intent.putExtra("id", id);
                intent.putExtra("rubro", rubro);
                intent.putExtra("nombre", nombre);
                intent.putExtra("direccion", direccion);
                intent.putExtra("telefono", telefono);
                intent.putExtra("correo", correo);
                intent.putExtra("url", url);
                intent.putExtra("info", info);
                intent.putExtra("logo", logo);
                startActivity(intent);
            }
        });

        buscador.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String query) {
                adapter.getFilter().filter(query);
                return false;
            }
        });

    }






}

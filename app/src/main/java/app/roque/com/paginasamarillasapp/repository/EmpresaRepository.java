package app.roque.com.paginasamarillasapp.repository;

import java.util.ArrayList;
import java.util.List;

import app.roque.com.paginasamarillasapp.model.Empresa;

public class EmpresaRepository {

    private static EmpresaRepository _INSTANCE = null;

    private EmpresaRepository(){
    }

    public static EmpresaRepository getInstance(){
        if(_INSTANCE == null)
            _INSTANCE = new EmpresaRepository();
        return _INSTANCE;
    }

    private List<Empresa> empresas = new ArrayList<Empresa>();

    public List<Empresa> getEmpresas(){
        return this.empresas;
    }

    public void agregarEmpresa(Empresa empresa){
        this.empresas.add(empresa);
    }

}

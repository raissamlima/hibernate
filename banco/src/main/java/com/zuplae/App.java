package com.zuplae;


import com.zuplae.dao.CategoriaDao;
import com.zuplae.model.Categoria;

public class App 
{
    public static void main( String[] args )
    {
        CategoriaDao dao = new CategoriaDao();

        Categoria model = new Categoria();
        model.setId(13);
        model.setNome("Teste update");
        model.setDescricao("Jpa");

        dao.delete(13);

        for (Categoria categoria : dao.read()) {
            System.out.printf("%d - %s - %s\n", categoria.getId(), categoria.getNome(), categoria.getDescricao());
        }
    }
}

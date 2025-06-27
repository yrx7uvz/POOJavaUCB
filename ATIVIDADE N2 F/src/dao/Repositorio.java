// arquivo: Repositorio.java
package dao;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Repositorio<T> {
    private String arquivo;
    private List<T> lista;

    public Repositorio(String arquivo) {
        this.arquivo = arquivo;
        this.lista = carregar();
    }

    @SuppressWarnings("unchecked")
    private List<T> carregar() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(arquivo))) {
            return (List<T>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return new ArrayList<>();
        }
    }

    public void salvar() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(arquivo))) {
            oos.writeObject(lista);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void adicionar(T obj) {
        lista.add(obj);
        salvar();
    }

    public List<T> listar() {
        return lista;
    }
}
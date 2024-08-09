package dao;

import java.util.List;

public interface IDao <T>{
    T guardarVeterinario(T t);
    List<T> buscarTodos();
}

package shop.mtcoding.blog2.model;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CrudRepository<T> {
    public List<T> findAll();
    public T findById(int id);
    public int insert(T entity);
    public int deleteById(int id);
    public int updateById(T entity);
}

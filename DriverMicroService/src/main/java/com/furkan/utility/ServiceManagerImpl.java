package com.furkan.utility;

import com.furkan.repository.entity.BaseEntity;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Getter
public class ServiceManagerImpl<T extends BaseEntity,ID> implements IServiceManager<T,ID>{

    private final JpaRepository<T,ID> repository;

    @Override
    public T save(T t) {
        t.setCreateDate(System.currentTimeMillis());
        t.setUpdateDate(System.currentTimeMillis());
        t.setState(true);
        return repository.save(t);
    }


    @Override
    public T update(T t) {
        t.setUpdateDate(System.currentTimeMillis());
        return repository.save(t);
    }

    @Override
    public void delete(T t) {
        repository.delete(t);
    }

    @Override
    public void deleteById(ID id) {
        repository.deleteById(id);
    }

    @Override
    public List<T> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<T> findById(ID id) {
        return repository.findById(id);
    }
}

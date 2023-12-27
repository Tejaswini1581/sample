package com.techwave.Bank.models.repositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.techwave.Bank.models.pojo.ProduceID;
@Repository
public interface ProduceIDRepository extends CrudRepository<ProduceID, String> {

}
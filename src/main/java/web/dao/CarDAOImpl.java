package web.dao;

import org.springframework.stereotype.Component;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CarDAOImpl implements CarDAO {
    private List<Car> carList;

    {
        carList = new ArrayList<>();
        carList.add(new Car("Модель-1", "Двигатель-1", 100));
        carList.add(new Car("Модель-2", "Двигатель-2", 200));
        carList.add(new Car("Модель-3", "Двигатель-3", 300));
        carList.add(new Car("Модель-4", "Двигатель-4", 400));
        carList.add(new Car("Модель-5", "Двигатель-5", 500));
    }

    @Override
    public List<Car> getCarsList(int count) {
        return carList.stream().limit(count).collect(Collectors.toList());
    }

}

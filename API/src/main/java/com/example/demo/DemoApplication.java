package com.example.demo;

import com.example.demo.model.Car;
import com.example.demo.service.DAO.CarRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

import static com.example.demo.model.enums.CarColor.*;
import static com.example.demo.model.enums.CarCompany.*;
import static com.example.demo.model.enums.CarFuelType.DIESEL;
import static com.example.demo.model.enums.CarFuelType.GASOLINE;
import static com.example.demo.model.enums.CarTransmissionType.AUTOMATIC_TRANSMISSION;
import static com.example.demo.model.enums.CarTransmissionType.MANUAL_TRANSMISSION;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(CarRepository carRepository) {
        return args -> {
            Car nissan = Car
                    .builder()
                    .carName("Nissan GTR R33")
                    .carColor(BLACK)
                    .carTransmissionType(MANUAL_TRANSMISSION)
                    .carCompany(NISSAN)
                    .carFuelType(GASOLINE)
                    .km(120000)
                    .price(68980)
                    .hp(900)
                    .damaged(false)
                    .productionYear(1998)
                    .quantityInStock(10)
                    .build();

            Car toyota = Car
                    .builder()
                    .carName("toyota supra")
                    .carColor(RED)
                    .carTransmissionType(AUTOMATIC_TRANSMISSION)
                    .carCompany(TOYOTA)
                    .carFuelType(DIESEL)
                    .km(100000)
                    .price(44900)
                    .hp(1000)
                    .damaged(true)
                    .productionYear(1994)
                    .quantityInStock(3)
                    .build();

            Car honda = Car
                    .builder()
                    .carName("Honda S2000")
                    .carColor(YELLOW)
                    .carTransmissionType(MANUAL_TRANSMISSION)
                    .carCompany(HONDA)
                    .carFuelType(GASOLINE)
                    .km(89500)
                    .price(33900)
                    .hp(550)
                    .damaged(false)
                    .productionYear(2005)
                    .quantityInStock(6)
                    .build();

            Car subaru = Car
                    .builder()
                    .carName("Subaru Impreza WRX STI")
                    .carColor(BLUE)
                    .carTransmissionType(MANUAL_TRANSMISSION)
                    .carCompany(SUBARU)
                    .carFuelType(GASOLINE)
                    .km(11600)
                    .price(33900)
                    .hp(445)
                    .damaged(true)
                    .productionYear(2005)
                    .quantityInStock(9)
                    .build();

            Car mazda = Car
                    .builder()
                    .carName("Mazda RX7")
                    .carColor(WHITE)
                    .carTransmissionType(MANUAL_TRANSMISSION)
                    .carCompany(MAZDA)
                    .carFuelType(GASOLINE)
                    .km(81600)
                    .price(29600)
                    .hp(400)
                    .damaged(false)
                    .productionYear(1999)
                    .quantityInStock(4)
                    .build();

            Car mitsubishi = Car
                    .builder()
                    .carName("Mitsubishi Lancer Evolution")
                    .carColor(YELLOW)
                    .carTransmissionType(AUTOMATIC_TRANSMISSION)
                    .carCompany(MITSUBISHI)
                    .carFuelType(DIESEL)
                    .km(81600)
                    .price(34000)
                    .hp(850)
                    .damaged(false)
                    .productionYear(2005)
                    .quantityInStock(6)
                    .build();


            Car infinity = Car
                    .builder()
                    .carName("Infinity G35")
                    .carColor(RED)
                    .carTransmissionType(MANUAL_TRANSMISSION)
                    .carCompany(INFINITY)
                    .carFuelType(GASOLINE)
                    .km(35690)
                    .price(39900)
                    .hp(985)
                    .damaged(false)
                    .productionYear(2022)
                    .quantityInStock(2)
                    .build();


            Car lexus = Car
                    .builder()
                    .carName("Lexus SC300")
                    .carColor(BLACK)
                    .carTransmissionType(MANUAL_TRANSMISSION)
                    .carCompany(LEXUS)
                    .carFuelType(GASOLINE)
                    .km(35690)
                    .price(39900)
                    .hp(225)
                    .damaged(true)
                    .productionYear(2022)
                    .quantityInStock(1)
                    .build();

            carRepository.saveAll(
                    List.of(
                            nissan, toyota, honda, subaru, mazda, mitsubishi, infinity, lexus
                    ));

        };
    }
}

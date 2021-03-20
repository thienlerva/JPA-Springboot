package com.mybatis.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.*;

@Slf4j
@RestController
@RequestMapping("/schedule")
public class AnimalEnricherController {

    public static void main (String[] args) {

        LocalDateTime start = LocalDateTime.now();
        LocalDateTime end = start.plusMinutes(5);

        //performAnimalEnrichment(start,end);

        List<Integer> firstList = new ArrayList<>();
        firstList.add(3);
        firstList.add(5);
        firstList.add(1);
        Set<Integer> set = new HashSet<>(firstList);
        List<Integer> secondList = new ArrayList<>();
        secondList.addAll(firstList);
        System.out.println(secondList.size() == 1 ? "Yes" : "No");
        //System.out.println(str);
        for(Integer i : secondList) {
            System.out.println(i);
        }

        LocalDate date = LocalDate.of(1981, Month.JANUARY, 22);
        LocalTime time = LocalTime.of(10,30);
        LocalDateTime localDateTime = LocalDateTime.of(date, time);

        DateTimeFormatter shortF = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
        System.out.println(date.getDayOfWeek() + shortF.format(localDateTime));

        LocalDateTime localDateTime1 = LocalDateTime.now();
        System.out.println(localDateTime1.getDayOfWeek());
    }

    @GetMapping("/go")
    String schedule() {

        LocalDateTime start = LocalDateTime.now();
        LocalDateTime end = start.plusMinutes(5);

        log.info("Start from {}, and end in {}", start, end);
        //Period period = start.plusSeconds(5);
        performAnimalEnrichment(start, end);

        return null;

    }

    private void performAnimalEnrichment(LocalDateTime start,
                                         LocalDateTime end) {

        LocalDateTime upTo = start;
        while(upTo.isBefore(end)) {
            System.out.println("Give new toy: " + upTo);
            upTo = upTo.plusSeconds(5);

        }
    }

    static String calculateAge() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter day: ");
        String day = scanner.next();
        System.out.println("Enter month: ");
        String month = scanner.next();
        System.out.println("Enter year: ");
        String year = scanner.next();

        LocalDate dob = LocalDate.of(Integer.valueOf(year), Integer.valueOf(month), Integer.valueOf(day));

        LocalDate now = LocalDate.now();


        Integer y=0, m=0, d=0;

        Period p = Period.between(dob, now);

        d = p.getDays();
        m = p.getMonths();
        y = p.getYears();
        DateTimeFormatter f = DateTimeFormatter.ofPattern("MMMM dd, yyyy");
        return "You were born on: " + " " + dob.getDayOfWeek() + " " + dob.format(f) +
                " .You are: " + y + " years " + m + " month " + d + " old";
    }
}

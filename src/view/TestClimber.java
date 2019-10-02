package view;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import helper.AscentHelper;
import helper.ClimberHelper;
import helper.RouteHelper;
import model.Ascent;
import model.Climber;
import model.Route;

public class TestClimber {

    public static void main(String[] args) {
        ClimberHelper ch = new ClimberHelper();
        RouteHelper rh = new RouteHelper();
        AscentHelper ah = new AscentHelper();
        //Route r = new Route("Millenium Falcon", "5.10c", "Rumney, NH");
        //Route r = rh.getRouteById(1);
        //rh.insertRoute(r);
        //r = rh.getRouteById(2);
        //rh.insertRoute(r);
        //Climber c = new Climber("Joe", "Clambers", LocalDate.of(1979, 4, 1), null);
        //Climber c = ch.getClimberById(3);
        //ch.insertClimber(c);
        //c = ch.getClimberById(1);
        //Ascent a = new Ascent(c, r, LocalDate.now());
        //ah.insertAscent(a);
        /*
        List<Climber> cl = ch.getAllClimbers();
        System.out.println("got all climbers");
        Climber c2 = cl.get(2);
        System.out.println("got third climber");
        List<Ascent> al = c2.getAscents();
        System.out.println("got all ascents from climber");
        System.out.println("number of ascents");
        System.out.println(al.size());
        for (Ascent i : al) {
            /*
            System.out.println("for each ascent");
            System.out.println("id");
            System.out.println(i.getId());
            System.out.println("climber");
            System.out.println(i.getClimber().getId());
            System.out.println("route");
            System.out.println(i.getRoute());
            System.out.println("date");
            System.out.println(i.getDate());
            System.out.println(i.toString());
            System.out.println("printed ascent");
        }
        for (Climber x : cl) {
            System.out.println(x);
        }
        Route newRoute = new Route("this is a route", "5.15", "");
        Climber newClimber = new Climber("Carl", "Vert", LocalDate.of(1998, 10, 1));
        Ascent newAscent = new Ascent(newClimber, newRoute, LocalDate.now());
        ah.insertAscent(newAscent);
        */
        List<Climber> allClimbers = ch.getAllClimbers();
        Climber lastClimber = allClimbers.get(allClimbers.size() -1);
        for (Ascent asc : lastClimber.getAscents()) {
            System.out.println(asc.toString());
        }
    }

}

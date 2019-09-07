
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import controller.RouteHelper;
import model.Route;

public class Start {

    static RouteHelper rh;
    static Scanner in = new Scanner(System.in);

    static void mainMenu() {
        System.out.println("Climbing route tracking app.");
        while (true) {
            System.out.println("Select an option:");
            System.out.println("1 - Display Routes");
            System.out.println("2 - Add Route");
            System.out.println("3 - Search for Route");
            System.out.println("4 - Remove Route");
            System.out.println("5 - Modify Route");
            System.out.println("6 - Exit");
            System.out.print(">>> ");
            char c = in.next().charAt(0);
            switch (c) {
            case '1':
                displayRoutes();
                break;
            case '2':
                addRoute();
                break;
            case '3':
                removeRoute();
                break;
            default:
                try {
                    rh.cleanUp();
                } finally {
                    return;
                }
            }
        }
    }

    static void displayRoutes() {
        System.out.println("Displaying routes:");
        try {
            List<Route> rl = rh.getAllRoutes();
            if (rl.size() > 0) {
                System.out.println("Displaying routes:");
                System.out.println("Route ID  Name"
                        + "                                "
                        + "Difficulty     Completed");
                for (Route r : rl) {
                    System.out.println(r.display());
                }
            } else {
                System.out.println("No routes found.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void addRoute() {
        System.out.println("Enter route name:");
        System.out.print(">>> ");
        String name = in.next();
        System.out.println("Enter route difficulty:");
        System.out.print(">>> ");
        String diff = in.next();
        System.out.println("Have you sent the route? (Y/N)");
        System.out.print(">>> ");
        boolean sent;
        char c = in.next().charAt(0);
        if (c == 'y' || c == 'Y') {
            sent = true;
        } else {
            sent = false;
        }
        Route r = new Route(name, diff, sent);
        try {
            rh.insertRoute(r);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    static boolean searchRoute() {
        System.out.println("Search by (N)ame, (D)ifficulty, or (C)ancel?:");
        System.out.print(">>> ");
        List<Route> rl = null;
        char c = in.next().charAt(0);
        switch (c) {
        case 'n':
        case 'N':
            System.out.println("Enter route name:");
            System.out.print(">>> ");
            String n = in.next();
            try {
                rl = rh.searchRouteByName(n);
            } catch (Exception e) {
                e.printStackTrace();
            }
            break;
        case 'd':
        case 'D':
            System.out.println("Enter route difficulty:");
            System.out.print(">>> ");
            String d = in.next();
            try {
                rl = rh.searchRouteByDifficulty(d);
            } catch (Exception e) {
                e.printStackTrace();
            }
            break;
        default:
            System.out.println("Search cancelled.");
            return false;
        }
        if (rl != null && rl.size() > 0) {
            for (Route r : rl) {
                System.out.println(r.display());
            }
            return true;
        } else {
            System.out.println("No results found.");
            return false;
        }
    }
    
    static void removeRoute() {
        if (searchRoute()) {
            System.out.println("Which route ID would you like to remove?");
            System.out.print(">>> ");
            try {
                int id = in.nextInt();
                Route r = rh.getRouteById(id);
                rh.deleteRoute(r);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
    static void modifyRoute() {
        if (searchRoute()) {
            int id = 0;
            Route r = null;
            System.out.println("Which route ID would you like to modify?");
            System.out.print(">>> ");
            try {
                id = in.nextInt();
                r = rh.getRouteById(id);
            } catch (InputMismatchException e) {
                System.out.println("Route ID must be an integer.");
                return;
            }
            System.out.println("Which field would you like to change?");
            System.out.println("1 - Name");
            System.out.println("2 - Difficulty");
            System.out.println("3 - Completed");
            System.out.println("4 - Cancel");
            System.out.print(">>> ");
            char c = in.next().charAt(0);
            switch (c) {
            case '1':
                System.out.println("Enter new name");
                System.out.print(">>> ");
                String name = in.next();
                r.setName(name);
                break;
            case '2':
                System.out.println("Enter new difficulty");
                System.out.print(">>> ");
                String diff = in.next();
                r.setDifficulty(diff);
                break;
            case '3':
                System.out.println("Did you send the route? (Y/N)");
                System.out.print(">>> ");
                boolean sent;
                char d = in.next().charAt(0);
                if (d == 'y' || d == 'Y') {
                    sent = true;
                } else {
                    sent = false;
                }
                r.setCompleted(sent);
                break;
            default:
                System.out.println("Route modification cancelled.");
                return;
            }
            try {
                rh.updateRoute(r);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    public static void main(String[] args) {
        try {
            rh = new RouteHelper();
        } catch (Exception e) {
            System.out.println(e);
            return;
        }

        mainMenu();

    }

}

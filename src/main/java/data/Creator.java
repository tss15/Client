package data;

import commands.excpetionsCommand.NullException;
import commands.excpetionsCommand.ValueTooBigException;
import commands.excpetionsCommand.ValueTooSmallException;
import data.dataException.NoSuchCountry;
import data.dataException.NoSuchDifficulty;
import data.dataException.NoSuchEyeColor;
import data.dataException.NoSuchHairColor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Creator {

    private static Integer id;
    private static String name;
    private static Long x;
    private static double y;
    private static Coordinates coordinates;
    private static LocalDateTime creationDate;
    private static Double minimalPoint;
    private static Difficulty difficulty;
    private static Person author;
    private static Location location;
    private static String pname;
    private static Double pweight;
    private static Color eyeColor;
    private static data.hairColor hairColor;
    private static Country nationality;
    private static Long lx;
    private static double ly;
    private static String lname;
    public static Integer setID() {
        id = 0;
        id++;
        return id;
    }

    public static LabWork LabWorkCreate() throws NullException, ValueTooSmallException, ValueTooBigException {

//        System.out.print("Please enter name");
//        Long x;
//        double y;
//        String name;
//        double minimalPoint;
//        Difficulty difficulty;
//        String pname;
//        Double pweight;
//        Color eyeColor;
//        Data.hairColor hairColor;
//        Country nationality;
//        Long lx;
//        double ly;
//        String lname;

        System.out.println("Please enter name");
        while (true) {
            try {
                Scanner names = new Scanner(System.in);
                name = names.nextLine();
                if (name == null) {
                    throw new NullException("Print Something");
                }
                break;
            } catch (NullException ex) {
                System.out.print(ex.getMessage());
            }
        }

        System.out.println("Please enter x-coordinate");
        while (true) {
            try {
                Scanner scanner = new Scanner(System.in);
                String lly = scanner.nextLine();

                x = Long.parseLong(lly);
                break;
            } catch (NumberFormatException ex) {
                System.out.println("Field cannot be null");
            }
        }

        System.out.println("Please enter y-coordinate");
        while (true) {
            try {
                Scanner scanner = new Scanner(System.in);
                String lly = scanner.nextLine();
                y = Double.parseDouble(lly);
                break;
            } catch (NumberFormatException ex) {
                System.out.println("Field cannot be null");
            }
        }

        System.out.println("Please enter minimal point");
        while (true) {
            try {
                Scanner scanner = new Scanner(System.in);
                String lly = scanner.nextLine();
                minimalPoint = Double.valueOf(lly);
                if (minimalPoint < 0) {
                    throw new ValueTooSmallException(" should be bigger than 0\n");
                }
                break;
            } catch (ValueTooSmallException ex) {
                System.out.println(ex.getMessage());
            } catch (NumberFormatException ex) {
                System.out.println("Please enter something");
            }
        }

        System.out.println("Please enter difficulty level");
        while (true) {
            try {
                Scanner scanner = new Scanner(System.in);
                String df = scanner.nextLine();
                df = df.toUpperCase();
                if (!Difficulty.nameList().contains(df)){
                    throw new NoSuchDifficulty("no such difficulty\n");
                }
                difficulty = Difficulty.valueOf(df);
                break;
            }catch (NoSuchDifficulty ex) {
                System.out.print(ex.getMessage());
            }

        }

        System.out.println("Please enter person's name");
        while (true) {
            try {
                Scanner names = new Scanner(System.in);
                pname = names.nextLine();
                if (pname == null){
                    throw new NullException("Print Something");
                }break;
            }catch (NullException ex) {
                System.out.print(ex.getMessage());
            }
        }

        System.out.println("Please enter person's weight");
        while (true) {
            try {
                Scanner scanner = new Scanner(System.in);
                String lly = scanner.nextLine();
                pweight = Double.parseDouble(lly);
                break;
            } catch (NumberFormatException ex) {
                System.out.println("Field cannot be null");
            }
        }

        System.out.println("Please enter eye color");
        while (true) {
            try {
                Scanner scanner = new Scanner(System.in);
                String ec = scanner.nextLine();
                ec = ec.toUpperCase();
                if (!Color.nameList().contains(ec)){
                    throw new NoSuchEyeColor("no such eye color\n");
                }
                eyeColor = Color.valueOf(ec);
                break;
            }catch (NoSuchEyeColor ex) {
                System.out.print(ex.getMessage());
            }
        }

        System.out.println("Please enter hair color");
        while (true) {
            try{
                Scanner scanner = new Scanner(System.in);
                String hc = scanner.nextLine();
                hc = hc.toUpperCase();
                if (!data.hairColor.nameList().contains(hc)){
                    throw new NoSuchHairColor("no such hair color\n");
                }
                hairColor = data.hairColor.valueOf(hc);
                break;
            }catch (NoSuchHairColor ex) {
                System.out.print(ex.getMessage());
            }
        }

        System.out.println("Please enter country");
        while (true) {
            try{
                Scanner scanner = new Scanner(System.in);
                String c = scanner.nextLine();
                c = c.toUpperCase();
                if (!Country.nameList().contains(c)){
                    throw new NoSuchCountry("no such country\n");
                }
                nationality = Country.valueOf(c);
                break;
            }catch (NoSuchCountry ex) {
                System.out.print(ex.getMessage());
            }
        }

        System.out.println("Please enter location x-coordinate");
        while (true) {
            try {
                Scanner scanner = new Scanner(System.in);
                String lly = scanner.nextLine();
                lx = Long.parseLong(lly);
//                String locx = StringTool.Input();
//                lx = Long.parseLong(locx);
                break;
            } catch (NumberFormatException ex) {
                System.out.println("Field cannot be null");
            }
        }

        System.out.println("Please enter location y-coordinate");
        while (true) {
            try {
                Scanner scanner = new Scanner(System.in);
                String lly = scanner.nextLine();
                ly = Double.parseDouble(lly);
                break;
            } catch (NumberFormatException ex) {
                System.out.println("Field cannot be null");
            }
        }

        System.out.println("Please enter location name");
        while (true) {
            try {
                Scanner scanner = new Scanner(System.in);
                lname = scanner.nextLine();
                if (lname.length()>838) {
                    throw new ValueTooBigException("too long");}
                if (lname == null) { throw new NullException("Print Something");}
                break;
            }catch (ValueTooBigException ex) {System.out.println(ex.getMessage());}
            catch (NullException ex) {System.out.print(ex.getMessage());}
        }
        location =new Location(lx,ly,lname);
        author = new Person(pname, pweight,eyeColor, hairColor, nationality, location);
        coordinates = new Coordinates(x,y);

        setID();


        return new LabWork(name, coordinates, minimalPoint, difficulty, author );
    }

    public static LabWork ScriptFromJsonToCollection(ArrayList<String> field) {

            return new LabWork( name.valueOf(field.get(1)), new Coordinates(Long.parseLong(field.get(2)), Integer.parseInt(field.get(3))), Double.parseDouble(field.get(4)), Difficulty.valueOf(field.get(5)), new Person(pname.valueOf(field.get(6)),Double.parseDouble(field.get(6)),Color.valueOf(field.get(7)), data.hairColor.valueOf(field.get(8)),Country.valueOf(field.get(9)),new Location(Long.parseLong(field.get(10)),Double.parseDouble(field.get(11)),lname.valueOf(field.get(12)))));

    }


}

package application;

import dao.MedDao;
import entity.Med;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Menu {

    private MedDao medDao = new MedDao();
    private Scanner scanner = new Scanner(System.in);
    private List<String> options = Arrays.asList(
            "Create a Med",
            "Display one Med",
            "Display all Meds",
            "Update a Med",
            "Delete a Med");

    public void start() {
        String selection = "";

        do {
            printMenu();
            selection = scanner.nextLine();

            try {
                if (selection.equals("1")) {
                    createMed();
                } else if (selection.equals("2")) {
                    displayOneMed();
                } else if (selection.equals("3")) {
                    displayAllMeds();
                } else if (selection.equals("4")) {
                    updateMedName();
                } else if (selection.equals("5")) {
                    deleteMed();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            System.out.println("Press enter to continue...");
            scanner.nextLine();
        } while (!selection.equals("-1"));
    }

    private void createMed() throws SQLException {
        System.out.print("Enter medication ID NUMBER for the new medication: ");
        int medId = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter generic name: ");
        String genericName = scanner.nextLine();
        medDao.createNewMed(medId, genericName);
    }

    private void displayOneMed() throws SQLException {
        System.out.println("Search med by name: ");
        String genericName = scanner.nextLine();
        Med result = (Med) medDao.getMedByName(genericName);
    }

    private void displayAllMeds() throws SQLException {
        List<Med> allMeds = medDao.getAllMeds();
        for (Med med : allMeds) {
            System.out.println(med.getMedId() + ": " + med.getGenericName());
        }
    }

    private void updateMedName() throws SQLException {
        System.out.println("Enter the name of the med you need to update: ");
        String inputName = scanner.nextLine();
        System.out.print("Enter the updated name: ");
        String updatedName = scanner.nextLine();
        medDao.updateMedName(inputName, updatedName);
        System.out.println(inputName + " has been updated to " + updatedName);
    }

    private void deleteMed() throws SQLException {
        System.out.print("Enter the medication name to delete:");
        String genericName = scanner.nextLine();
        medDao.deleteMedByName(genericName);
    }

    private void printMenu() {
        System.out.println("Select an Option:\n------------------------");
        for (int i = 0; i < options.size(); i++) {
            System.out.println(i + 1 + ") " + options.get(i));
        }
    }

}


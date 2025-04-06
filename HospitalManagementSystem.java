import java.util.*;

class Patient {
    String id, name, disease;
    int age;

    Patient(String id, String name, int age, String disease) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.disease = disease;
    }

    public String toString() {
        return id + ": " + name + ", Age: " + age + ", Disease: " + disease;
    }
}

class Appointment {
    String appointmentId, patientId, doctorName, date;

    Appointment(String appointmentId, String patientId, String doctorName, String date) {
        this.appointmentId = appointmentId;
        this.patientId = patientId;
        this.doctorName = doctorName;
        this.date = date;
    }

    public String toString() {
        return "Appointment ID: " + appointmentId + ", Patient ID: " + patientId + ", Doctor: " + doctorName + ", Date: " + date;
    }
}

class Staff {
    String staffId, name, role;

    Staff(String staffId, String name, String role) {
        this.staffId = staffId;
        this.name = name;
        this.role = role;
    }

    public String toString() {
        return staffId + ": " + name + " (" + role + ")";
    }
}

class InventoryItem {
    String itemId, name;
    int quantity;

    InventoryItem(String itemId, String name, int quantity) {
        this.itemId = itemId;
        this.name = name;
        this.quantity = quantity;
    }

    public String toString() {
        return itemId + ": " + name + " - Quantity: " + quantity;
    }
}

class Billing {
    String billId, patientId;
    double amount;

    Billing(String billId, String patientId, double amount) {
        this.billId = billId;
        this.patientId = patientId;
        this.amount = amount;
    }

    public String toString() {
        return "Bill ID: " + billId + ", Patient ID: " + patientId + ", Amount: Rs." + amount;
    }
}

public class HospitalManagementSystem {
    static Scanner sc = new Scanner(System.in);
    static List<Patient> patients = new ArrayList<>();
    static List<Appointment> appointments = new ArrayList<>();
    static List<Staff> staffList = new ArrayList<>();
    static List<InventoryItem> inventory = new ArrayList<>();
    static List<Billing> billings = new ArrayList<>();

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n--- Hospital Management System ---");
            System.out.println("1. Register Patient\n2. Schedule Appointment\n3. Add Staff\n4. Manage Inventory\n5. Generate Bill\n6. View All Data\n7. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt(); sc.nextLine();

            switch (choice) {
                case 1 -> registerPatient();
                case 2 -> scheduleAppointment();
                case 3 -> addStaff();
                case 4 -> manageInventory();
                case 5 -> generateBill();
                case 6 -> viewAll();
                case 7 -> System.exit(0);
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    static void registerPatient() {
        System.out.print("Patient ID: "); String id = sc.nextLine();
        System.out.print("Name: "); String name = sc.nextLine();
        System.out.print("Age: "); int age = sc.nextInt(); sc.nextLine();
        System.out.print("Disease: "); String disease = sc.nextLine();
        patients.add(new Patient(id, name, age, disease));
        System.out.println("Patient registered successfully.");
    }

    static void scheduleAppointment() {
        System.out.print("Appointment ID: "); String aid = sc.nextLine();
        System.out.print("Patient ID: "); String pid = sc.nextLine();
        System.out.print("Doctor Name: "); String dname = sc.nextLine();
        System.out.print("Date (dd/mm/yyyy): "); String date = sc.nextLine();
        appointments.add(new Appointment(aid, pid, dname, date));
        System.out.println("Appointment scheduled.");
    }

    static void addStaff() {
        System.out.print("Staff ID: "); String sid = sc.nextLine();
        System.out.print("Name: "); String name = sc.nextLine();
        System.out.print("Role: "); String role = sc.nextLine();
        staffList.add(new Staff(sid, name, role));
        System.out.println("Staff added.");
    }

    static void manageInventory() {
        System.out.print("Item ID: "); String itemId = sc.nextLine();
        System.out.print("Item Name: "); String name = sc.nextLine();
        System.out.print("Quantity: "); int qty = sc.nextInt(); sc.nextLine();
        inventory.add(new InventoryItem(itemId, name, qty));
        System.out.println("Inventory updated.");
    }

    static void generateBill() {
        System.out.print("Bill ID: "); String bid = sc.nextLine();
        System.out.print("Patient ID: "); String pid = sc.nextLine();
        System.out.print("Amount: "); double amt = sc.nextDouble(); sc.nextLine();
        billings.add(new Billing(bid, pid, amt));
        System.out.println("Bill generated.");
    }

    static void viewAll() {
        System.out.println("\n--- Patients ---");
        patients.forEach(System.out::println);
        System.out.println("\n--- Appointments ---");
        appointments.forEach(System.out::println);
        System.out.println("\n--- Staff ---");
        staffList.forEach(System.out::println);
        System.out.println("\n--- Inventory ---");
        inventory.forEach(System.out::println);
        System.out.println("\n--- Billing ---");
        billings.forEach(System.out::println);
    }
}

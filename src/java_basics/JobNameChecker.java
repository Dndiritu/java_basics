package java_basics;


public class JobNameChecker {

    public static void main(String[] args) {

        // 1. Hard-code at least 8 job names
        String[] jobNames = {
            "KL_ORD_EXTRACT_01",
            "kl orders validate 02",
            "KL_ORD_TRANSFORM_03",
            "KL-SHP-LOAD-04",
            "KL_CUS_NOTIFY_06!",
            "Kl_Fin_Reconcile_05",
            "KL_INV_LOAD_04",
            "KL_EDI_EXPORT_12"
        };

        // 2. Job types
        String[] jobTypes = {
            "CMD", "CMD", "CMD", "CMD",
            "CMD", "CMD", "CMD", "FT"
        };

        int passed = 0;
        int failed = 0;

        System.out.println("===== JOB NAME VALIDATION =====");

        // 3. Loop through job names
        for (int i = 0; i < jobNames.length; i++) {

            String name = jobNames[i];

            if (isValidJobName(name)) {
                System.out.println(name + " : VALID");
                passed++;
            } else {
                System.out.println(name + " : INVALID");
                failed++;
            }

            // 4. Display job type using switch
            System.out.println("Job Type: "
                    + getJobTypeLabel(jobTypes[i]));

            System.out.println();
        }

        // 5. Display summary
        System.out.println("===== VALIDATION SUMMARY =====");
        System.out.println("Names passed: " + passed);
        System.out.println("Names failed: " + failed);
        System.out.println("Total names: " + (passed + failed));

        // 6. Test additional edge cases
        System.out.println("\n===== EDGE CASE TESTS =====");

        String[] testNames = {
            "",
            "KL ORDERS",
            "kl_orders",
            "KL_ORDERS_01",
            "KL_ORDERS!"
        };

        for (int i = 0; i < testNames.length; i++) {

            System.out.println(
                "Test [" + testNames[i] + "] : "
                + (isValidJobName(testNames[i]) ? "VALID" : "INVALID")
            );
        }
    }

    // METHOD 1: Check whether a job name is valid
    public static boolean isValidJobName(String name) {

        if (name == null || name.length() == 0) {
            return false;
        }

        for (int i = 0; i < name.length(); i++) {

            char ch = name.charAt(i);

            if (!((ch >= 'A' && ch <= 'Z') ||
                  (ch >= '0' && ch <= '9') ||
                  ch == '_')) {

                return false;
            }
        }

        return true;
    }

    // METHOD 2: Identify the job type
    public static String getJobTypeLabel(String type) {

        switch (type) {

            case "CMD":
                return "Command Job";

            case "FT":
                return "File Transfer Job";

            default:
                return "Unknown Job Type";
        }
    }
}


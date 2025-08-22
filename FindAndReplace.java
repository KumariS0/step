
    import java.util.*;

public class FindAndReplace {
    
    // Method to find all occurrences of substring
    public static List<Integer> findOccurrences(String text, String find) {
        List<Integer> positions = new ArrayList<>();
        int index = text.indexOf(find);
        while (index != -1) {
            positions.add(index);
            index = text.indexOf(find, index + find.length()); 
        }
        return positions;
    }
    
    // Method to manually replace substring
    public static String manualReplace(String text, String find, String replace) {
        StringBuilder result = new StringBuilder();
        int i = 0;
        while (i < text.length()) {
            // If substring matches at position i
            if (i <= text.length() - find.length() && text.substring(i, i + find.length()).equals(find)) {
                result.append(replace); // insert replacement
                i += find.length();     // skip the original substring
            } else {
                result.append(text.charAt(i)); // copy character
                i++;
            }
        }
        return result.toString();
    }
    
    // Method to compare with built-in replace()
    public static boolean compareWithBuiltIn(String text, String find, String replace, String manualResult) {
        String builtInResult = text.replace(find, replace);
        return builtInResult.equals(manualResult);
    }

    // Main function
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Input
        System.out.println("Enter the main text:");
        String text = sc.nextLine();
        
        System.out.println("Enter the substring to find:");
        String find = sc.nextLine();
        
        System.out.println("Enter the substring to replace with:");
        String replace = sc.nextLine();
        
        // Find occurrences
        List<Integer> positions = findOccurrences(text, find);
        System.out.println("Occurrences at positions: " + positions);
        
        // Manual replacement
        String manualResult = manualReplace(text, find, replace);
        System.out.println("Manual Replace Result: " + manualResult);
        
        // Built-in replacement
        String builtInResult = text.replace(find, replace);
        System.out.println("Built-in Replace Result: " + builtInResult);
        
        // Compare results
        boolean isSame = compareWithBuiltIn(text, find, replace, manualResult);
        System.out.println("Do both results match? " + isSame);
        
        sc.close();
    }
}

    

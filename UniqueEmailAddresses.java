// Every valid email consists of a local name and a domain name, separated by the '@' sign. Besides lowercase letters, the email may contain one or more '.' or '+'.

// For example, in "alice@leetcode.com", "alice" is the local name, and "leetcode.com" is the domain name.
// If you add periods '.' between some characters in the local name part of an email address, mail sent there will be forwarded to the same address without dots in the local name. Note that this rule does not apply to domain names.

// For example, "alice.z@leetcode.com" and "alicez@leetcode.com" forward to the same email address.
// If you add a plus '+' in the local name, everything after the first plus sign will be ignored. This allows certain emails to be filtered. Note that this rule does not apply to domain names.

// For example, "m.y+name@email.com" will be forwarded to "my@email.com".
// It is possible to use both of these rules at the same time.

// Given an array of strings emails where we send one email to each emails[i], return the number of different addresses that actually receive mails.

 

// Example 1:

// Input: emails = ["test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"]
// Output: 2
// Explanation: "testemail@leetcode.com" and "testemail@lee.tcode.com" actually receive mails.
// Example 2:

// Input: emails = ["a@leetcode.com","b@leetcode.com","c@leetcode.com"]
// Output: 3
 

// Constraints:

// 1 <= emails.length <= 100
// 1 <= emails[i].length <= 100
// emails[i] consist of lowercase English letters, '+', '.' and '@'.
// Each emails[i] contains exactly one '@' character.
// All local and domain names are non-empty.
// Local names do not start with a '+' character.
// Domain names end with the ".com" suffix.
// Domain names must contain at least one character before ".com" suffix.

import java.util.HashSet;
import java.util.Set;

public class UniqueEmailAddresses {
    public int numUniqueEmails(String[] emails) {
        Set<String> uniqueEmails = new HashSet<>();
        
        for (String email : emails) {
            // Split the email into local and domain parts
            int atIndex = email.indexOf('@');
            String local = email.substring(0, atIndex);
            String domain = email.substring(atIndex + 1);
            
            // Process the local part by removing '.' and ignoring everything after '+'
            local = local.replace(".", "");
            if (local.contains("+")) {
                local = local.substring(0, local.indexOf("+"));
            }
            
            // Reconstruct the full email and add it to the set
            String processedEmail = local + "@" + domain;
            uniqueEmails.add(processedEmail);
        }
        
        // The size of the set is the number of unique email addresses
        return uniqueEmails.size();
    }

    public static void main(String[] args) {
        UniqueEmailAddresses solution = new UniqueEmailAddresses();
        
        // Example 1
        String[] emails1 = {
            "test.email+alex@leetcode.com",
            "test.e.mail+bob.cathy@leetcode.com",
            "testemail+david@lee.tcode.com"
        };
        System.out.println(solution.numUniqueEmails(emails1));  // Output: 2
        
        // Example 2
        String[] emails2 = {
            "a@leetcode.com", 
            "b@leetcode.com", 
            "c@leetcode.com"
        };
        System.out.println(solution.numUniqueEmails(emails2));  // Output: 3
    }
}

// Detailed Explanation:
// Imports:

// import java.util.HashSet;
// import java.util.Set;
// We import HashSet and Set from the java.util package.
// Set is an interface in Java that ensures unique elements (no duplicates).
// HashSet is one of the most common implementations of the Set interface, backed by a hash table. It provides fast access and ensures uniqueness of elements.
// Class Definition:

// public class UniqueEmailAddresses {
// This defines the class UniqueEmailAddresses, which will contain our method to solve the problem.
// Method to Count Unique Emails:

// public int numUniqueEmails(String[] emails) {
// This method, numUniqueEmails, takes an array of strings (emails) as input, where each string is an email address.
// The method will return an integer representing the number of unique email addresses after processing each one.
// Create a Set to Store Unique Emails:

// Set<String> uniqueEmails = new HashSet<>();
// Here we create a HashSet called uniqueEmails to store the unique email addresses. The HashSet automatically handles duplicates by only keeping distinct entries.
// Loop through Each Email:

// for (String email : emails) {
// This loop iterates over each email in the emails array. The variable email will represent the current email in each iteration.
// Split the Email into Local and Domain Parts:

// int atIndex = email.indexOf('@');
// String local = email.substring(0, atIndex);
// String domain = email.substring(atIndex + 1);
// email.indexOf('@'): This finds the index of the @ character in the email. We use this index to split the email into two parts: the local part (before @) and the domain part (after @).
// substring(0, atIndex): This extracts the local part from the beginning of the string up to the @ character.
// substring(atIndex + 1): This extracts the domain part, starting from one character after @ to the end of the string.
// Process the Local Part:

// local = local.replace(".", "");
// if (local.contains("+")) {
//     local = local.substring(0, local.indexOf("+"));
// }
// local.replace(".", ""): This removes all periods (.) in the local part. According to the problem description, periods in the local part are ignored for email comparison.
// local.contains("+"): This checks if there is a + in the local part. If there is, everything after the first + is ignored (for filtering purposes).
// substring(0, local.indexOf("+")): This takes only the portion of the local part before the + sign, effectively ignoring the part after it.
// Reconstruct the Full Email:


// String processedEmail = local + "@" + domain;
// After processing the local part (removing periods and handling the + rule), we reconstruct the email by combining the processed local part with the domain part. This gives us the normalized or processed email address.
// Add the Processed Email to the Set:


// uniqueEmails.add(processedEmail);
// We add the processed email to the HashSet (uniqueEmails). If this email has already been added, the HashSet will automatically ignore it, ensuring that only unique email addresses are stored.
// Return the Number of Unique Emails:



// return uniqueEmails.size();
// After processing all the emails, we return the size of the uniqueEmails set. The size() method returns the number of unique email addresses stored in the set.
// Main Method (Example Usage):


// public static void main(String[] args) {
//     UniqueEmailAddresses solution = new UniqueEmailAddresses();
    
//     // Example 1
//     String[] emails1 = {
//         "test.email+alex@leetcode.com",
//         "test.e.mail+bob.cathy@leetcode.com",
//         "testemail+david@lee.tcode.com"
//     };
//     System.out.println(solution.numUniqueEmails(emails1));  // Output: 2
    
//     // Example 2
//     String[] emails2 = {
//         "a@leetcode.com", 
//         "b@leetcode.com", 
//         "c@leetcode.com"
//     };
//     System.out.println(solution.numUniqueEmails(emails2));  // Output: 3
// }
// main method: This is where we test the numUniqueEmails method.
// First, we create an instance of the UniqueEmailAddresses class: solution.
// Then, we test the method using two different input email arrays (emails1 and emails2).
// We print the results of solution.numUniqueEmails() for both examples:
// In Example 1, we expect 2 unique email addresses after processing.
// In Example 2, we expect 3 unique email addresses.
// Summary of Key Concepts:
// HashSet is used to store unique email addresses, ensuring there are no duplicates.
// String manipulation (using substring, replace, contains, etc.) is used to transform the email addresses according to the rules (removing periods, ignoring parts after +, etc.).
// Set size gives the count of distinct processed email addresses.
// This approach efficiently processes each email and ensures that duplicates are automatically handled by the HashSet.




// Time Complexity:
// For each email, we perform operations such as splitting the string, replacing characters, and potentially slicing the string. Each of these operations takes linear time relative to the length of the string.
// Therefore, the overall time complexity is O(N * L), where:
// N is the number of emails.
// L is the average length of each email.
// Since the input constraints are relatively small (up to 100 emails, each up to 100 characters long), this approach will run efficiently within the provided limits.


// Space Complexity
// The space complexity is dominated by the space needed to store the unique email addresses in the HashSet.
// In the worst case (if all emails are unique after processing), we would store all n emails in the HashSet.
// Therefore, the space complexity is O(n), where n is the number of emails.
// Final Complexity Summary
// Time Complexity: O(n * m), where n is the number of emails, and m is the average length of each email.
// Space Complexity: O(n) for storing the unique email addresses in the HashSet.
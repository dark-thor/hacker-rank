import java.util.*;
import java.util.stream.Collectors;
public class MergeContacts {

  // just find uniques and return without merging.
  static Map<Integer, Set<String>> findUniques(Map<Integer, Set<String>> contacts) {
      Set<Integer> duplicates = new HashSet();
      Map<String, Set<Integer>> emailMap = new HashMap<>();
      contacts.forEach((contactId, emails) -> {
          emails.forEach(email -> {
              emailMap.computeIfAbsent(email, contactList -> new HashSet()).add(contactId);
              if (emailMap.get(email).size() >= 2) {
                  duplicates.add(contactId);
              }
          });
      });
      return contacts.entrySet().stream().filter(e -> !duplicates.contains(e.getKey()))
        .collect(Collectors.toMap(p->p.getKey(), p-> p.getValue()));
  }

  // find uniques and return merged contacts.
  static Map<Integer, Set<String>> mergeContacts(Map<Integer, Set<String>> contacts) {
      Map<String, Set<Integer>> emailMap = new HashMap<>();
      contacts.forEach((contactId, emails) -> {
          emails.forEach(email -> {
              emailMap.computeIfAbsent(email, contactList -> new HashSet()).add(contactId);
          });
      });
      Set<Integer> visitedIds = new HashSet<>();
      Set<String> visitedEmails = new HashSet<>();
      Map<Integer, Set<String>> result = new HashMap<>();
      contacts.keySet().forEach((contactId) -> {
          Queue<Integer> queue = new LinkedList<>();
          if (!visitedIds.contains(contactId))
            queue.add(contactId);
          // traverse through all connected children
          while (!queue.isEmpty()) {
              Integer id = queue.poll();
              contacts.get(id).forEach(email -> {
                  if (!visitedEmails.contains(email)) {
                    emailMap.get(email).forEach(cid -> {
                        if (!visitedIds.contains(cid)) {
                            queue.add(cid);
                        }
                    });
                    result.computeIfAbsent(contactId, emailList -> new HashSet()).add(email);
                    visitedEmails.add(email);
                  }
              });
              visitedIds.add(id);
          }
      });
      return result;
  }

  public static void main(String args[]){
      String[] e1 = {"a@x.com", "a@y.com"};
      String[] e2 = {"b@x.com", "a@y.com"};
      String[] e3 = {"c@x.com", "c@y.com"};
      String[] e4 = {"d@x.com", "d@y.com"};
      String[] e5 = {"d@x.com", "e@y.com"};
      Map<Integer, Set<String>> contacts = new HashMap<>();
      contacts.put(1, Arrays.stream(e1).collect(Collectors.toSet()));
      contacts.put(2, Arrays.stream(e2).collect(Collectors.toSet()));
      contacts.put(3, Arrays.stream(e3).collect(Collectors.toSet()));
      contacts.put(4, Arrays.stream(e4).collect(Collectors.toSet()));
      contacts.put(5, Arrays.stream(e5).collect(Collectors.toSet()));
      Map<Integer, Set<String>> result = mergeContacts(contacts);
      result.forEach((k,v) -> {
          System.out.println(k + Arrays.toString(v.toArray()));
      });
  }
}


package net.engineeringdigest.journalApp.Controller;

import net.engineeringdigest.journalApp.entity.JournalEntry;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/journal")
public class JournalEntryController {

    Map<Long, JournalEntry> journalEntries = new HashMap<>();

    @GetMapping("/get-entry")
    public List<JournalEntry> getAll(){
        return new ArrayList<>(journalEntries.values());
    }

    @PostMapping("/post-entry")
    public boolean createEntry(@RequestBody JournalEntry myEntry){
        journalEntries.put(myEntry.getId(), myEntry);
        return true;
    }

    @GetMapping("/get-entry/id/{id}")
    public JournalEntry getEntryById(@PathVariable  long id){
        if(journalEntries.containsKey(id)){
            return journalEntries.get(id);
        }
        return null;
    }

    @DeleteMapping("/delete-entry/{id}")
    public void deleteEntry(@PathVariable long id){
        journalEntries.remove(id);
    }

    @PutMapping("/update-entry/id/{id}")
    public boolean updateEntryById(@PathVariable long id, @RequestBody JournalEntry myEntry){
        journalEntries.put(id,myEntry);
        return true;
    }
}

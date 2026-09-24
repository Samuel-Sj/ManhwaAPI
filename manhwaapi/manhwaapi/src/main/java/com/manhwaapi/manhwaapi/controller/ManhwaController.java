package com.manhwaapi.manhwaapi.controller;

import com.manhwaapi.manhwaapi.exceptions.ManhwaNotFound;
import com.manhwaapi.manhwaapi.model.Manhwa;
import com.manhwaapi.manhwaapi.services.ManhwaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/manhwa")
public class ManhwaController {

    @Autowired
    private ManhwaService manhwaService;

    @PostMapping
    public Manhwa saveManhwa(@Validated @RequestBody Manhwa manhwa) {
        return manhwaService.saveManhwa(manhwa);
    }

    @GetMapping("/name/{name}")
    public Manhwa fetchManhwaByName(@PathVariable String name) {
        return manhwaService.fetchManhwaByName(name.toLowerCase());
    }

    @GetMapping("/year/{releasedYear}")
    public Manhwa fetchManhwaByReleasedYear(@PathVariable("releasedYear") int releasedYear) {
        return manhwaService.fetchManhwaByReleasedYear(releasedYear);
    }

    @GetMapping("/finished/{isFinished}")
    public Manhwa fetchManhwByFinished(@PathVariable Boolean isFinished) {
        return manhwaService.fetchManhwByFinished(isFinished);
    }

    @PutMapping("/{id}")
    public Manhwa updateManhwa(@RequestBody Manhwa manhwa, @PathVariable("id") Long id) {
        return manhwaService.updateManhwa(manhwa, id);
    }

    @DeleteMapping("/id/{id}")
    public String deleteManhwaById(@PathVariable("id") Long id) {
        manhwaService.deleteManhwaById(id);
        return "Manhwa com id " + id + " deletado com sucesso";
    }

    @DeleteMapping("/name/{name}")
    public String deleteManhwaByName(@PathVariable("name") String name) {
        manhwaService.deleteManhwaByName(name.toLowerCase());
        return "Manhwa " + name + " deletado com sucesso";
    }

}
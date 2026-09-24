package com.manhwaapi.manhwaapi.services;

import com.manhwaapi.manhwaapi.exceptions.ManhwaNotFound;
import com.manhwaapi.manhwaapi.model.Manhwa;
import com.manhwaapi.manhwaapi.repository.ManhwaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class ManhwaServiceImpl implements ManhwaService {

    @Autowired
    ManhwaRepository manhwaRepository;

    @Override
    public Manhwa saveManhwa(Manhwa manhwa) {
        return manhwaRepository.save(manhwa);
    }

    @Override
    public Manhwa fetchManhwaByName(String name) {
        Manhwa manhwa = manhwaRepository.findByName(name.toLowerCase());
        if (Objects.isNull(manhwa)) {
            throw new ManhwaNotFound("Manhwa não encontrado com nome: " + name);
        }
        return manhwa;
    }

    @Override
    public Manhwa fetchManhwaByReleasedYear(int year) {
        Manhwa manhwa = manhwaRepository.findByReleaseYear(year);
        if (Objects.isNull(manhwa)) {
            throw new ManhwaNotFound("Manhwa não encontrado com ano: " + year);
        }
        return manhwa;
    }

    @Override
    public Manhwa fetchManhwByFinished(Boolean isFinished) {
        Manhwa manhwa = manhwaRepository.findByFinished(isFinished);
        if (Objects.isNull(manhwa)) {
            throw new ManhwaNotFound("Manhwa não encontrado com status finalizado: " + isFinished);
        }
        return manhwa;
    }

    @Override
    public Manhwa updateManhwa(Manhwa manhwa, Long id) {
        Manhwa manhwaDB = manhwaRepository.findById(id)
                .orElseThrow(() -> new ManhwaNotFound("Manhwa não encontrado com id: " + id));

        if (Objects.nonNull(manhwa.getName())
                && !"".equalsIgnoreCase(manhwa.getName())) {
            manhwaDB.setName(manhwa.getName());
        }

        return manhwaRepository.save(manhwaDB);
    }

    @Override
    public void deleteManhwaById(Long id) {
        if (!manhwaRepository.existsById(id)) {
            throw new ManhwaNotFound("Manhwa não encontrado com id: " + id);
        }
        manhwaRepository.deleteById(id);
    }

    @Override
    public void deleteManhwaByName(String name) {
        Manhwa manhwa = manhwaRepository.findByName(name.toLowerCase());
        if (Objects.isNull(manhwa)) {
            throw new ManhwaNotFound("Manhwa não encontrado com nome: " + name);
        }
        manhwaRepository.deleteByName(name);
    }
}